package myapp;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportLog {
	private String status;
	private String transactionType;
	private String stage;
	private String endpoint;
	private String response;
	private String details;
}
