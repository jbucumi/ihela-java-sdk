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
@JsonRootName("cuurency_info")
@JsonPropertyOrder({ "operation_min_amount", "iso_code", "title", "abbreviation", "iso_alpha_code" })
public class CurrencyInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("operation_min_amount")
	public String operationMinAmount;
	@JsonProperty("iso_code")
	public Integer isoCode;
	@JsonProperty("title")
	public String title;
	@JsonProperty("abbreviation")
	public String abbreviation;
	@JsonProperty("iso_alpha_code")
	public String isoAlphaCode;

}
