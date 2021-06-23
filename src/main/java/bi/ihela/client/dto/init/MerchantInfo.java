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
@JsonPropertyOrder({ "merchant_code", "merchant_logo", "id", "title", "merchant_type", "merchant_slug" })
public class MerchantInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("merchant_code")
	public Integer merchantCode;
	@JsonProperty("merchant_logo")
	public Object merchantLogo;
	@JsonProperty("id")
	public Integer id;
	@JsonProperty("title")
	public String title;
	@JsonProperty("merchant_type")
	public MerchantType merchantType;
	@JsonProperty("merchant_slug")
	public String merchantSlug;

}
