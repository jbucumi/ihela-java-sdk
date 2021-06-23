/**
 * 
 */
package bi.ihela.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import bi.ihela.client.entity.BillInitRequest;
import bi.ihela.client.entity.BillInitResponse;
import bi.ihela.client.entity.BillVerifyRequest;
import bi.ihela.client.entity.BillVerifyResponse;

/**
 * @author jeanclaude.bucumi jeanclaude.bucumi@outlook.com
 */

public class IhelaClientTests {

	static IhelaClient client;

	@BeforeAll
	static void setup() throws Exception {
		client = IhelaClient.getInstance();
		client.init("<YOUR CLIENT ID>", "<YOUR CLIENT SECRET>");//retrieve the token
	}

	@Test
	void canInitBill() throws Exception {
		  BillInitRequest bir = BillInitRequest.builder()
				  .user("<YOUR USERNAME>")
				  .description("<BILL DESCRIPTION>")
				  .merchantReference("<BILL REF>")
				  .billAmount(Double.valueOf("<AMOUNT>"))
				  .build();
		  BillInitResponse biresp = client.initBill(bir);
		  
		  assertTrue(biresp.getBillDetails() != null);
		  assertEquals(bir.getMerchantReference(), biresp.getBillDetails().getMerchantReference());
	}

	@Test
	void canVerifyBill() throws Exception {

		BillVerifyRequest bvr = BillVerifyRequest.builder()
				.billCode("<IHELA BILL CODE>")
				.billReference("<BILL REF>").build();
		BillVerifyResponse resp = client.verifyBill(bvr);
		
		assertTrue(resp.getBillStatus() != null);
		assertEquals(bvr.getBillCode(), resp.getBillStatus().getReference());
	}
}
