/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.transport;

/**
 * <p>A basic implementation of a CredentialsProvider. Holds credentials, and nothing more.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public class TrivialCredentialsProvider implements CredentialsProvider {

	private final Credentials credentials;

	/**
	 * <p>Constructs a TrivialCredentialsProvider based on the provided Credentials.
	 * 
	 * @param credentials the credentials to provide
	 */
	public TrivialCredentialsProvider(Credentials credentials) {
		this.credentials = credentials;
	}

	/**
	 * <p>Obtain the credentials.
	 * 
	 * @return the current credentials
	 */
	public Credentials getCredentials() {
		return this.credentials;
	}
}
