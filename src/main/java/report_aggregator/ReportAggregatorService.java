package report_aggregator;//package report_aggregator;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.type.CollectionType;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//
//@Service
//class ReportAggregatorService {
//
//	public void reportAllEndpoints() {
//
//		ObjectMapper mapper = new ObjectMapper();
//		CollectionType javaType = mapper.getTypeFactory()
//										.constructCollectionType(List.class, Test.class);
//
//		List<Test> asList = null;
//		try {
//			asList = mapper.readValue(new File("plugin_testing/meta/tests.json"), javaType);
//			logToSpreadsheet(asList);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public void reportEndpoint() {
//
//	}
//
//
//	private void logToSpreadsheet(List<Test> asList) throws IOException {
//
//		if (asList == null) {
//			return;
//		}
//
//		SpreadSheetBuilder spreadSheetBuilder = new SpreadSheetBuilder();
//		spreadSheetBuilder.makeWorkbook();
//
//		for (Test test : asList) {
//			RestTemplate restTemplate = new RestTemplate();
////			String requestLog = restTemplate.getForObject(test.getEndpoint(), String.class);
//
////			restTemplate.setErrorHandler(new MyErrorHandler());
//			ResponseEntity<RequestLog[]> responseEntity = null;
//			try {
//				responseEntity = restTemplate.getForEntity(test.getEndpoint(), RequestLog[].class);
//			} catch (RestClientException e) {
//				e.printStackTrace();
//			}
//
//
//			RequestLog[] requestLogs = responseEntity.getBody();
//			MediaType contentType = responseEntity.getHeaders().getContentType();
//			HttpStatus statusCode = responseEntity.getStatusCode();
//
//			spreadSheetBuilder.addSheet(test, requestLogs);
//
//		}
//
//		spreadSheetBuilder.save();
//	}
//
//
//
//}
