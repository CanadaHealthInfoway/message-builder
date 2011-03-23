package ca.infoway.messagebuilder.acceptance.metrics;

import java.util.ArrayList;
import java.util.List;

public class AcceptanceTestGroupMetrics {
	
	private final String groupName;
	private final AcceptanceTestLanguage language;
	private final List<AcceptanceTestMetrics> metrics = new ArrayList<AcceptanceTestMetrics>();
	private final String groupDescription;
	
	public AcceptanceTestGroupMetrics(String groupName, String groupDescription, AcceptanceTestLanguage language) {
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.language = language;
	}

	public String getGroupDescription() {
		return this.groupDescription;
	}

	public AcceptanceTestLanguage getLanguage() {
		return this.language;
	}

	public String getGroupName() {
		return this.groupName;
	}
	
	public List<AcceptanceTestMetrics> getMetrics() {
		return this.metrics;
	}

	public int getOverallSuccessful() {
		int sumSuccessful = 0;
		for (AcceptanceTestMetrics testMetrics : this.metrics) {
			sumSuccessful += testMetrics.getNumSuccessful();
		}
		return sumSuccessful;
	}
	
	public int getOverallTotal() {
		int sumTotal = 0;
		for (AcceptanceTestMetrics testMetrics : this.metrics) {
			sumTotal += testMetrics.getNumTotal();
		}
		return sumTotal;
	}
	
	public boolean hasData() {
		return !metrics.isEmpty();
	}
}
