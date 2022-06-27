package me.nidhogg.lib.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * <h1>Signup Request</h1>
 * Send a username and password to create an account and receive a JWT.
 */
@RequestMetadata(endpoint = "/session/signup")
@Data
@Builder
@AllArgsConstructor
public class SignupRequest {

	private final String username;
	private final String password;
	private final String challenge;
}
