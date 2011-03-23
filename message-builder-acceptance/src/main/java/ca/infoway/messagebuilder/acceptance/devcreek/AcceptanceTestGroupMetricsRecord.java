package ca.infoway.messagebuilder.acceptance.devcreek;

import java.util.Map;

import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestGroupMetrics;

public class AcceptanceTestGroupMetricsRecord extends MetricsRecord {

	private final AcceptanceTestGroupMetrics metrics;

	public AcceptanceTestGroupMetricsRecord(AcceptanceTestGroupMetrics metrics) {
		this.metrics = metrics;
	}

	@Override
	public Map<String, String> getRecord() {
		Map<String, String> record = super.getRecord();	
		record.put("acceptanceTestsMetrics.groupName", this.metrics.getGroupName());
		record.put("acceptanceTestsMetrics.groupDescription", this.metrics.getGroupDescription());
		record.put("acceptanceTestsMetrics.language", this.metrics.getLanguage().getLanguageLiteral());
		record.put("acceptanceTestsMetrics.overallNumSuccessful", String.valueOf(this.metrics.getOverallSuccessful()));
		record.put("acceptanceTestsMetrics.overallNumTotal", String.valueOf(this.metrics.getOverallTotal()));
		return record;
	}

	@Override
	public String getCoreType() {
		return "acceptanceTestsMetrics.acceptanceTestGroupMetrics";
		
	}

	public static AcceptanceTestGroupMetricsRecord create(AcceptanceTestGroupMetrics metrics) {
		return new AcceptanceTestGroupMetricsRecord(metrics);
	}
}
