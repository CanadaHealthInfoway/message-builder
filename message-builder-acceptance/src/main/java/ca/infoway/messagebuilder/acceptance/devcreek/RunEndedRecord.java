package ca.infoway.messagebuilder.acceptance.devcreek;

import java.util.Map;

public class RunEndedRecord extends MetricsRecord {

	public RunEndedRecord() {
	}

	@Override
	public String getCoreType() {
		return "acceptanceTestsMetrics.runEnded";
	}

	@Override
	public Map<String, String> getRecord() {
		Map<String, String> map = super.getRecord();
		return map;
	}
	
}
