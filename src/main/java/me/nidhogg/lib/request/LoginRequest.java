package me.nidhogg.lib.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * <h1>Login Request</h1>
 * <p>Send a username & password to receive a JWT.</p>
 */
@RequestMetadata(endpoint = "/session/login")
@Data
@Builder
@AllArgsConstructor
public class LoginRequest {

	private final String username;
	private final String password;
}
