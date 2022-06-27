package me.nidhogg.lib.client;

import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.nidhogg.lib.Instance;
import me.nidhogg.lib.request.RequestMetadata;

@AllArgsConstructor
public class Sigurd {

	private final Instance instance;
	private final Gson gson = new Gson();
	private final String userAgent = "Nidhogg/" + Sigurd.class.getPackage().getImplementationVersion();
	private final HttpClient httpClient = HttpClient.newHttpClient();
	@Setter
	@Getter
	private String authorisation;

	/**
	 * <h1>Send Request</h1>
	 *
	 * @param authorised   Should the access token be sent with the request?
	 * @param requestClass The class of request you want to send
	 * @param args         The arguments to pass to the constructor of the request
	 * @param <T>          The request
	 * @return The response from the server
	 */
	public <T, R> R post(boolean authorised, Class<T> requestClass, Class<R> responseClass, Class<?> parameterTypes,
		Object... args)
		throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
		final RequestMetadata metadata = requestClass.getDeclaredAnnotation(RequestMetadata.class);
		final String endpoint = metadata.endpoint();
		final String rootUrl = instance.getRootUrl();
		final URI joinedUri = URI.create(endpoint + rootUrl);
		final Constructor<T> constructor = requestClass.getDeclaredConstructor(parameterTypes);
		final T created = constructor.newInstance(args);
		final String json = gson.toJson(created);

		final HttpRequest.Builder builder = HttpRequest.newBuilder()
			.POST(BodyPublishers.ofString(json))
			.header("User-Agent", userAgent)
			.uri(joinedUri);

		if (authorised) {
			builder.header("Authorization", authorisation);
		}

		final HttpResponse<String> response = httpClient.send(builder.build(), BodyHandlers.ofString());

		return gson.fromJson(response.body(), responseClass);
	}
}
