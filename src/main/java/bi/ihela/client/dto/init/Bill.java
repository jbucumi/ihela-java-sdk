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
@JsonRootName("bill")
@JsonPropertyOrder({ "initiated_by", "amount", "code", "currency_info", "merchant", "description", "created_at",
		"payment_reference", "bank", "confirmation_uri", "expired", "merchant_reference", "bank_client_id", "currency",
		"redirect_uri", "paid_by", "status" })
public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("initiated_by")
	public InitiatedBy initiatedBy;
	@JsonProperty("amount")
	public String amount;
	@JsonProperty("code")
	public String code;
	@JsonProperty("currency_info")
	public CurrencyInfo currencyInfo;
	@JsonProperty("merchant")
	public Merchant merchant;
	@JsonProperty("description")
	public String description;
	@JsonProperty("created_at")
	public String createdAt;
	@JsonProperty("payment_reference")
	public Object paymentReference;
	@JsonProperty("bank")
	public Object bank;
	@JsonProperty("confirmation_uri")
	public String confirmationUri;
	@JsonProperty("expired")
	public Boolean expired;
	@JsonProperty("merchant_reference")
	public String merchantReference;
	@JsonProperty("bank_client_id")
	public Object bankClientId;
	@JsonProperty("currency")
	public Integer currency;
	@JsonProperty("redirect_uri")
	public Object redirectUri;
	@JsonProperty("paid_by")
	public Object paidBy;
	@JsonProperty("status")
	public Status status;

}
