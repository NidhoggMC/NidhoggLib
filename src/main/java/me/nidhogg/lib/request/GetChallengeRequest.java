package me.nidhogg.lib.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * <h1>Get Challenge</h1>
 * Request a challenge from the server.
 */
@RequestMetadata(endpoint = "/challenge/generate")
@Data
@Builder
@AllArgsConstructor
public class GetChallengeRequest {
	
}
