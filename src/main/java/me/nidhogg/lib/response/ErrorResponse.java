package me.nidhogg.lib.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

	private final String message;
	private final String errorName;
	private final String path;
}
