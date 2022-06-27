package me.nidhogg.lib.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * <h1>Refresh Request</h1>
 * <p>Retrieves a new, valid access token from an invalid access token which expired within the hour.</p>
 */
@RequestMetadata(endpoint = "/session/refresh")
@Data
@Builder
@AllArgsConstructor
public class RefreshRequest {

	private final String accessToken;
}
