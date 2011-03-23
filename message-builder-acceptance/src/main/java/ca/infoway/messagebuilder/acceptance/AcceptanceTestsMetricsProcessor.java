package ca.infoway.messagebuilder.acceptance;

import java.util.List;

import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestGroupMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestLanguage;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestMetrics;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;

public class AcceptanceTestsMetricsProcessor {

	private final List<AcceptanceTestRunner> acceptanceTestRunners;

	private final String groupName;
	private final AcceptanceTestLanguage language;
	private final String groupDescription;

	public AcceptanceTestsMetricsProcessor(String groupName, String groupDescription, AcceptanceTestLanguage language, List<AcceptanceTestRunner> acceptanceTestRunners) {
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.language = language;
		this.acceptanceTestRunners = acceptanceTestRunners;
	}

	String getGroupDescription() {
		return this.groupDescription;
	}

	String getGroupName() {
		return this.groupName;
	}

	AcceptanceTestLanguage getLanguage() {
		return this.language;
	}

	public AcceptanceTestGroupMetrics process() {
		final AcceptanceTestGroupMetrics groupMetrics = new AcceptanceTestGroupMetrics(this.getGroupName(), this.getGroupDescription(), getLanguage());
		
		for (AcceptanceTestRunner acceptanceTestRunner : acceptanceTestRunners) {
			acceptanceTestRunner.run(new AcceptanceTestResultCallback() {
				public void done(String name, int numSuccessful, int numTotal, List<String> messages) {
					groupMetrics.getMetrics().add(new AcceptanceTestMetrics(name, numSuccessful, numTotal, messages));
				}
			});
		}
		
		return groupMetrics;
	}
	
	List<AcceptanceTestRunner> getAcceptanceTestRunners() {
		return this.acceptanceTestRunners;
	}
}
