package report_aggregator;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class ReportLog {
	private String status;
	private String transactionType;
	private String stage;
	private String endpoint;
	private String response;
	private String details;
}
