/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
