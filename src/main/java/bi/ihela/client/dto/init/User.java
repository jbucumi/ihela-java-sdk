/**
 * 
 */
package bi.ihela.client.dto.init;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

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
@JsonRootName("user")
@JsonPropertyOrder({ "image", "ihela_code", "following", "bio", "email", "username" })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("image")
	public String image;
	@JsonProperty("ihela_code")
	public String ihelaCode;
	@JsonProperty("following")
	public Boolean following;
	@JsonProperty("bio")
	public String bio;
	@JsonProperty("email")
	public String email;
	@JsonProperty("username")
	public String username;

}
