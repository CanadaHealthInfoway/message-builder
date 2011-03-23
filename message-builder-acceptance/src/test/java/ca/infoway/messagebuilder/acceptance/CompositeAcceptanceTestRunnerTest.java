package ca.infoway.messagebuilder.acceptance;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.mutable.MutableDouble;
import org.apache.commons.lang.mutable.MutableObject;
import org.junit.Test;

import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestGroupRunner;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;


public class CompositeAcceptanceTestRunnerTest {

	@Test
	public void shouldUseCorrectName() throws Exception {
		AcceptanceTestGroupRunner runner = new AcceptanceTestGroupRunner("name", Arrays.<AcceptanceTestRunner>asList());
		
		final MutableObject actualName = new MutableObject();
		
		runner.run(new AcceptanceTestResultCallback() {
			public void done(String name, int numSuccessful, int numTotal, List<String> messages) {
				actualName.setValue(name);
			}

		});
		
		assertEquals("name", actualName.getValue());
	}
	
	@Test
	public void shouldAveragePercentSuccessful() throws Exception {
		AcceptanceTestGroupRunner runner = new AcceptanceTestGroupRunner("name", Arrays.<AcceptanceTestRunner>asList(
				new FakeAcceptanceTestRunner(5, 10),
				new FakeAcceptanceTestRunner(10, 10)));
		
		final MutableDouble actualPercentSuccessful = new MutableDouble(); 
		
		runner.run(new AcceptanceTestResultCallback() {
			public void done(String name, int numSuccessful, int numTotal, List<String> messages) {
				actualPercentSuccessful.setValue(numSuccessful * 100.0 / numTotal);
			}
		});
		
		assertEquals(75.0, actualPercentSuccessful.doubleValue(), 0.0);
	}
	
	class FakeAcceptanceTestRunner implements AcceptanceTestRunner {
		
		private int numSuccess;
		private int numTotal;

		public FakeAcceptanceTestRunner(int numSuccess, int numTotal) {
			this.numSuccess = numSuccess;
			this.numTotal = numTotal;
		}

		public void run(AcceptanceTestResultCallback resultCallback) {
			resultCallback.done("", this.numSuccess, this.numTotal, Collections.<String>emptyList());
		}
		
	}

}
