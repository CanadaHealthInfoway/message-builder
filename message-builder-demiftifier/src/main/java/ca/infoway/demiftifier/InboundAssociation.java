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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.demiftifier;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;

public class InboundAssociation {

	private final Relationship relationship;
	private int inboundArrowDepth;
	
	public InboundAssociation(Relationship relationship, int inboundArrowDepth){
		this.relationship = relationship;
		this.inboundArrowDepth = inboundArrowDepth;
	}

	public int getInboundArrowDepth() {
		return this.inboundArrowDepth;
	}

	public boolean isWithArrow() {
		return this.inboundArrowDepth > 0;
	}

	public String getName() {
		return this.relationship == null ? null : this.relationship.getName();
	}

	public Cardinality getCardinality() {
		return this.relationship == null ? null : this.relationship.getCardinality();
	}
	
	public String getCmetBindingName() {
		return this.relationship == null ? null : this.relationship.getCmetBindingName();
	}
	
}
