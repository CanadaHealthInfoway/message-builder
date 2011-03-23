package ca.infoway.messagebuilder.acceptance.runner;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.mutable.MutableInt;

public class AcceptanceTestGroupRunner implements AcceptanceTestRunner {
	
	private final String name;
	private final List<AcceptanceTestRunner> acceptanceTestRunners;

	public AcceptanceTestGroupRunner(String name, List<AcceptanceTestRunner> acceptanceTestRunners) {
		this.name = name;
		this.acceptanceTestRunners = acceptanceTestRunners;
	}

	public void run(final AcceptanceTestResultCallback resultCallback) {
		final MutableInt sumSuccess = new MutableInt(0);
		final MutableInt sumTotal = new MutableInt(0);
		final List<String> allMessages = new ArrayList<String>();
		for (AcceptanceTestRunner acceptanceTestRunner : this.acceptanceTestRunners) {
			acceptanceTestRunner.run(new AcceptanceTestResultCallback() {
				public void done(String name, int numSuccessful, int numTotal, List<String> messages) {
					sumSuccess.add(numSuccessful);
					sumTotal.add(numTotal);
					allMessages.addAll(messages);
				}
			});
		}
		resultCallback.done(this.name, sumSuccess.intValue(), sumTotal.intValue(), allMessages);
	}

}
