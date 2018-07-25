package report_aggregator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AppController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String index(Model model) {

		ObjectMapper mapper = new ObjectMapper();
		CollectionType javaType = mapper.getTypeFactory()
				.constructCollectionType(List.class, Test.class);
		List<Test> asList = null;
		List<ReportLog> reportLogs = null;
		try {
			String data = "";
			ClassPathResource cpr = new ClassPathResource("sdk_package_testing/meta/tests.json");
			try {
				byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
				data = new String(bdata, StandardCharsets.UTF_8);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

			asList = mapper.readValue(data, javaType);

			reportLogs = buildLog(asList);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		model.addAttribute("reportLogs", reportLogs);
		return "dashboard";
	}

	private List<ReportLog> buildLog(List<Test> asList) throws IOException {
		// TODO : Handle unreachable endpoints or unusable responses gracefully
		List<ReportLog> masterReportLogList = new ArrayList();
		List<ReportLog> reportLogList;
		ReportLog[] reportLogsArray = null;

		for (Test test : asList) {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ReportLog[]> responseEntity = null;
			try {
				responseEntity = restTemplate.getForEntity(test.getEndpoint(), ReportLog[].class);
				reportLogsArray = responseEntity.getBody();
			} catch (RestClientException e) {
				System.out.println(e.getMessage());
			}

			reportLogList = Arrays.stream(reportLogsArray).collect(Collectors.toList());
//			MediaType contentType = responseEntity.getHeaders().getContentType();
//			HttpStatus statusCode = responseEntity.getStatusCode();
			masterReportLogList.addAll(reportLogList);
		}

		return masterReportLogList;
	}

}
