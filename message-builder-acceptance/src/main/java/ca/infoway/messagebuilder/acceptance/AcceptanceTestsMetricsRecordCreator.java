package ca.infoway.messagebuilder.acceptance;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.acceptance.devcreek.AcceptanceTestGroupMetricsRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.AcceptanceTestMetricsRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.RunEndedRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.RunStartedRecord;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestGroupMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AllAcceptanceGroupTestMetrics;
import ca.intelliware.commons.dependency.devcreek.Record;

public class AcceptanceTestsMetricsRecordCreator {

	public List<Record> create(AllAcceptanceGroupTestMetrics metrics) {
		List<Record> records = new ArrayList<Record>();
		
		records.add(new RunStartedRecord());
		processGroups(records, metrics.getGroupMetrics());
		records.add(new RunEndedRecord());
		
		return records;
	}

	private void processGroups(List<Record> records, List<AcceptanceTestGroupMetrics> groupMetrics) {
		for (AcceptanceTestGroupMetrics aGroupMetrics : groupMetrics) {
			records.add(new AcceptanceTestGroupMetricsRecord(aGroupMetrics));
			processGroup(records, aGroupMetrics);
		}
	}

	private void processGroup(List<Record> records, AcceptanceTestGroupMetrics aGroupMetrics) {
		for (AcceptanceTestMetrics acceptanceTestMetrics : aGroupMetrics.getMetrics()) {
			records.add(new AcceptanceTestMetricsRecord(aGroupMetrics.getGroupName(), aGroupMetrics.getLanguage().getLanguageLiteral(), acceptanceTestMetrics));
		}
	}

}
