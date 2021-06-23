/**
 * 
 */
package bi.ihela.client.entity;

import java.io.Serializable;

import bi.ihela.client.dto.verify.BillStatus;
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
public class BillVerifyResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private BillStatus billStatus;
}
