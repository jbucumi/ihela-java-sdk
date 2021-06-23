package bi.ihela.client.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jeanclaude.bucumi jeanclaude.bucumi@outlook.com
 */

@Getter
@Setter
@Builder
@ToString
public class ATRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String clientSecret, clientId;
	@Builder.Default
	private String grantType = "client_credentials";

	public ATRequest() {
		this("", "");
	}

	public ATRequest(String client_secret, String client_id) {
		this(client_secret, client_id, "");
	}

	public ATRequest(String client_secret, String client_id, String grant_type) {
		this.clientSecret = client_secret;
		this.clientId = client_id;
		this.grantType = grant_type;
	}
}
