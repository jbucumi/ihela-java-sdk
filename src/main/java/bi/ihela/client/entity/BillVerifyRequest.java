/**
 * 
 */
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
public class BillVerifyRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String billCode,billReference;
}
