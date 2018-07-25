package report_aggregator;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tests {
	private List<Test> tests;
}
