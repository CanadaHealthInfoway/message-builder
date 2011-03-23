package ca.infoway.messagebuilder.acceptance.devcreek;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestMetrics;
import ca.infoway.messagebuilder.lang.XmlStringEscape;

public class AcceptanceTestMetricsRecord extends MetricsRecord {

	private final String groupName;
	private final AcceptanceTestMetrics metrics;
	private final String language;

	public AcceptanceTestMetricsRecord(String groupName, String language, AcceptanceTestMetrics metrics) {
		this.groupName = groupName;
		this.language = language;
		this.metrics = metrics;
	}

	@Override
	public Map<String, String> getRecord() {
		Map<String, String> record = super.getRecord();
		record.put("acceptanceTestsMetrics.groupName", this.groupName);
		record.put("acceptanceTestsMetrics.name", this.metrics.getName());
		record.put("acceptanceTestsMetrics.language", this.language);
		record.put("acceptanceTestsMetrics.numSuccessful", String.valueOf(this.metrics.getNumSuccessful()));
		record.put("acceptanceTestsMetrics.numTotal", String.valueOf(this.metrics.getNumTotal()));
		record.put("acceptanceTestsMetrics.messages", XmlStringEscape.escape(convertList(this.metrics.getMessages())));
		return record;
	}

	private String convertList(List<String> messages) {
		return StringUtils.join(messages, "^^^");
	}

	@Override
	public String getCoreType() {
		return "acceptanceTestsMetrics.acceptanceTestMetrics";
		
	}

}
