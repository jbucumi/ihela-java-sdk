/**
 * 
 */
package bi.ihela.client;

import java.io.IOException;
import java.io.Serializable;

import bi.ihela.client.dto.cashIn.CashInOperation;
import bi.ihela.client.dto.init.Bill;
import bi.ihela.client.dto.verify.BillStatus;
import bi.ihela.client.entity.ATRequest;
import bi.ihela.client.entity.ATResponse;
import bi.ihela.client.entity.BillInitRequest;
import bi.ihela.client.entity.BillInitResponse;
import bi.ihela.client.entity.BillVerifyRequest;
import bi.ihela.client.entity.BillVerifyResponse;
import bi.ihela.client.entity.CashInRequest;
import bi.ihela.client.entity.CashInResponse;
import bi.ihela.client.utils.JsonUtils;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author jeanclaude.bucumi jeanclaude.bucumi@outlook.com
 */

public class IhelaClient implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Object LOCK = new Object();

	private static ATResponse accessToken = null;
	private static ATRequest accessTokenRequest = null;
	private static String API_URL = "https://testgate.ihela.online";

	private static String AUTH_URL = API_URL + "/oAuth2/token/";
	private static String BILL_INIT_URL = API_URL + "/api/v1/payments/bill/init/";
	private static String BILL_VERIFICATION_URL = API_URL + "/api/v1/payments/bill/verify/";
	private static String CASH_IN_URL = API_URL + "/api/v1/payments/cash-in/";
	// private static String USER_INFO_URL = API_URL + "/api/v1/connected-user/";
	// private static String BANKS_URL = API_URL + "/api/v1/bank/all";
	// OkHttpClient
	private OkHttpClient client = new OkHttpClient().newBuilder().followRedirects(false).build();

	private static IhelaClient instance = null;

	private IhelaClient() {

	}

	public static IhelaClient getInstance() {
		synchronized (LOCK) {
			if (instance == null) {
				instance = new IhelaClient();
			}
		}
		return instance;
	}

	public BillInitResponse initBill(BillInitRequest bir) throws Exception {
		RequestBody body = new FormBody.Builder().add("user", bir.getUser())
				.add("merchant_reference", bir.getMerchantReference()).add("description", bir.getDescription())
				.add("amount", bir.getBillAmount().toString()).add("redirect_uri", bir.getRedirectUri()).build();
		String jso = sendRequest(body, BILL_INIT_URL, authenticate().getAccessToken());
		return BillInitResponse.builder().billDetails(JsonUtils.toObject(jso, Bill.class, true)).build();
	}

	public BillVerifyResponse verifyBill(BillVerifyRequest bvr) throws Exception {
		RequestBody body = new FormBody.Builder().add("reference", bvr.getBillCode())
				.add("code", bvr.getBillReference()).build();
		String jso = sendRequest(body, BILL_VERIFICATION_URL, authenticate().getAccessToken());
		System.err.println(jso);
		return BillVerifyResponse.builder().billStatus(JsonUtils.toObject(jso, BillStatus.class, true)).build();
	}

	public CashInResponse cashIn(CashInRequest cir) throws Exception {
		RequestBody body = new FormBody.Builder().add("description", cir.getDescription())
				.add("merchant_reference", cir.getMerchantReference()).add("account", cir.getAccountNumber())
				.add("amount", cir.getAmountIn().toString()).add("bank_slug", cir.getBankSlug()).build();
		String jso = sendRequest(body, CASH_IN_URL, authenticate().getAccessToken());
		return CashInResponse.builder().operationDetails(JsonUtils.toObject(jso, CashInOperation.class, true)).build();
	}

	public void init(String clientId, String clientSecret) throws Exception {
		init(null, clientId, clientSecret, null);
	}

	public void init(String apiUrl, String clientId, String clientSecret, String grantType) throws Exception {
		API_URL = (apiUrl != null) ? apiUrl : API_URL;
		accessTokenRequest = new ATRequest();
		accessTokenRequest.setClientId(clientId);
		accessTokenRequest.setClientSecret(clientSecret);
		accessTokenRequest.setGrantType((grantType != null) ? grantType : "client_credentials");
		authenticate();
	}

	private String sendRequest(RequestBody body, String targetUrl) throws IOException {
		return sendRequest(body, targetUrl, null);
	}

	private String sendRequest(RequestBody body, String targetUrl, String accessToken) throws IOException {
		Request request = new Request.Builder().url(targetUrl).post(body).build();
		if (accessToken != null)
			request = new Request.Builder().addHeader("Authorization", "Bearer " + accessToken).url(targetUrl)
					.post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	private ATResponse getAccessToken(ATRequest atrq) throws Exception {
		if (accessToken == null || (accessToken != null && !accessToken.isValid())) {
			accessToken = authenticate(atrq);
			accessToken.setExpirationDate();
		}
		return accessToken;
	}

	private ATResponse authenticate() throws Exception {
		if (accessTokenRequest != null)
			return getAccessToken(accessTokenRequest);
		throw new Exception("Not authenticated !");
	}

	private ATResponse authenticate(ATRequest atrq) throws Exception {
		try {
			RequestBody body = new FormBody.Builder().add("client_secret", atrq.getClientSecret())
					.add("client_id", atrq.getClientId()).add("grant_type", atrq.getGrantType()).build();
			String jso = sendRequest(body, AUTH_URL);
			// System.err.println("TOKEN : " + jso);
			return JsonUtils.toObject(jso, ATResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Failed to authenticate");
	}
}
