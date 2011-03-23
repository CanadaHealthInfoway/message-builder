package ca.infoway.messagebuilder.simple.xml.runner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

public class Runner {
	
	public static void main(String[] args) throws Exception {
		
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod("http://localhost:8080/");
		
		method.setRequestEntity(new InputStreamRequestEntity(Runner.class.getResourceAsStream("/findCandidates.xml")));
		
		int status = client.executeMethod(method);
		if (status == 200) {
			System.out.println("Successful: " + status);
			System.out.println(method.getResponseBodyAsString());
		} else {
			System.out.println("Problem   : " + status + " " + method.getStatusText());
			
		}
	}
}
