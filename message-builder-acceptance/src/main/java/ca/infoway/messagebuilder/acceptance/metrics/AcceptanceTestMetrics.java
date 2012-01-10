/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
