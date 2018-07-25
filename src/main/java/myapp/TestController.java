package myapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@RestController
public class TestController {

	@Value("${api_secret}")
	String apiSecret;

	@Value("${api_key}")
	private String apiKey;

	@GetMapping("/api/test_group_1")
	public List<ReportLog> getMerchant() {
		List<ReportLog> ReportLogList = new ArrayList();

		ReportLogList.add(new ReportLog("PASS", "Java Client: Create Transaction", "Create PaymentApi Instance", "/v1/payments", "response", "details"));
		ReportLogList.add(new ReportLog("FAIL", "Java Client: Create Transaction", "Create PrimaryTransaction Instance", "/v1/payments", "response", "details"));

		return ReportLogList;

	}




}
