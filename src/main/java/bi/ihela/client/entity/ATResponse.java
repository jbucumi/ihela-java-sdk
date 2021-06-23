package bi.ihela.client.entity;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jeanclaude.bucumi jeanclaude.bucumi@outlook.com
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ATResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("scope")
	private String tokenScope;
	@JsonProperty("expires_in")
	private Integer tokenValidity;
	
	@JsonIgnore
	private static Instant expirationDate;

	public boolean isValid() {
		return Instant.now().isBefore(expirationDate);
	}

	public void setExpirationDate() {
		expirationDate = Instant.now().plusSeconds(getTokenValidity());
	}
}
