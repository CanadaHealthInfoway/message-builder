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
