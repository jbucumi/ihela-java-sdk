/**
 * 
 */
package bi.ihela.client.dto.cashIn;

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
@JsonRootName("operation")
@JsonPropertyOrder({ "bank_slug", "account", "amount", "description", "merchant_reference", "reference", "error",
		"error_message" })
public class CashInOperation implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("bank_slug")
	public String bankSlug;
	@JsonProperty("account")
	public String account;
	@JsonProperty("amount")
	public String amount;
	@JsonProperty("description")
	public String description;
	@JsonProperty("merchant_reference")
	public String merchantReference;
	@JsonProperty("reference")
	public String reference;
	@JsonProperty("error")
	public Boolean error;
	@JsonProperty("error_message")
	public String errorMessage;
}
