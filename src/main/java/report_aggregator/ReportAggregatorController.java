package report_aggregator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class ReportAggregatorController {

//	@GetMapping("/report_aggregator/secure/group1")
//	public String getGroup1() {
//		Date date = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss");
//		String fileName = "sdk_package_testing/output/Report_" + dateFormat.format(date) + ".xlsx";
//		File file = new File(fileName);
//
//		try {
//			file.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return "report_aggregator index";
//	}



}
