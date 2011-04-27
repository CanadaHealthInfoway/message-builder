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

package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

public class RelationshipMissingDomainTypeDifferenceAnalyzer extends TrivialDifferenceAnalyzer {

	// all known instances of this difference has indicated an error in the source MIF(s)
	// this has been handled substituting (TBD) either the domain type that is present, or Code
	
	public RelationshipMissingDomainTypeDifferenceAnalyzer() {
		super(true);
	}
	
}
