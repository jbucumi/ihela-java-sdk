/**
 * 
 */
package bi.ihela.client.dto.verify;

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
@JsonRootName("bill")
@JsonPropertyOrder({ "bank_reference", "reference", "code", "status" })
public class BillStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("bank_reference")
	public Object bankReference;
	@JsonProperty("reference")
	public String reference;
	@JsonProperty("code")
	public String code;
	@JsonProperty("status")
	public String status;
}
