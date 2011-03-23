package ca.infoway.messagebuilder.acceptance.devcreek;

import java.util.Map;

public class RunStartedRecord extends MetricsRecord {

	public RunStartedRecord() {
	}

	@Override
	public Map<String, String> getRecord() {
		return super.getRecord();
	}

	@Override
	public String getCoreType() {
		return "acceptanceTestsMetrics.runStarted";
		
	}

}
