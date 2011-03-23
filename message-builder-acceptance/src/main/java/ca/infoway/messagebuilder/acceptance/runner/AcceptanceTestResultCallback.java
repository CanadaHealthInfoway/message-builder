package ca.infoway.messagebuilder.acceptance.runner;

import java.util.List;

public interface AcceptanceTestResultCallback {
	
	public void done(String name, int numSuccessful, int numTotal, List<String> messages);

}
