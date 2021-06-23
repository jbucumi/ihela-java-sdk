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
@JsonRootName("merchant")
@JsonPropertyOrder({ "merchant", "title", "user" })
public class Merchant implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("merchant")
	public MerchantInfo merchantInfo;
	@JsonProperty("title")
	public String title;
	@JsonProperty("user")
	public User user;
	
}
