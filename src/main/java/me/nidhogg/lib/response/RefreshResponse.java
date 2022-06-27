package me.nidhogg.lib.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RefreshResponse {

	private final String accessToken;
}
