package me.nidhogg.lib;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nidhogg.lib.client.Sigurd;

@AllArgsConstructor
public class Instance {

	@Getter
	private final String rootUrl;
	@Getter
	private final Sigurd sigurd = new Sigurd(this);
}
