package ca.infoway.messagebuilder.acceptance.metrics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcceptanceTestMetrics {
	
	private final String name;
	private final List<String> messages = new ArrayList<String>();
	private final int numSuccessful;
	private final int numTotal;

	public AcceptanceTestMetrics(String name, int numTotalAllSuccessful) {
		this(name, numTotalAllSuccessful, numTotalAllSuccessful, Collections.<String>emptyList());
	}
	
	public AcceptanceTestMetrics(String name, int numSuccessful, int numTotal, List<String> messages) {
		this.name = name;
		this.numSuccessful = numSuccessful;
		this.numTotal = numTotal;
		this.messages.addAll(messages);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumSuccessful() {
		return this.numSuccessful;
	}

	public int getNumTotal() {
		return this.numTotal;
	}

	public List<String> getMessages() {
		return this.messages;
	}

}
