package ca.infoway.messagebuilder.acceptance.metrics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllAcceptanceGroupTestMetrics {
	
	private final Date timestamp;
	private final List<AcceptanceTestGroupMetrics> groupMetrics = new ArrayList<AcceptanceTestGroupMetrics>();

	public AllAcceptanceGroupTestMetrics(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public List<AcceptanceTestGroupMetrics> getGroupMetrics() {
		return this.groupMetrics;
	}

	public boolean hasData() {
		return !getGroupMetrics().isEmpty();
	}

	public Date getTimestamp() {
		return this.timestamp;
	}
	
}
