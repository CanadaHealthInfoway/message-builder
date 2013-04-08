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

import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CmetBinding;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;

public class EntryPointLayoutItem implements LayoutItem {

	private PackageLocation packageLocation;
	
	public EntryPointLayoutItem(PackageLocation packageLocation) {
		this.packageLocation = packageLocation;
	}
	
	public String getLabel() {
		return this.packageLocation.getName();
	}

	public RimClass getRimClass() {
		return null;
	}

	public boolean isDuplicate() {
		return false;
	}

	public List<Relationship> getAttributes() {
		return Collections.<Relationship>emptyList();
	}

	public PackageLocation getPackageLocation() {
		return this.packageLocation;
	}

	public int getLogicalX() {
		return 0;
	}

	public int getHeight() {
		return 1;
	}

	public int getLogicalY() {
		return 0;
	}

	public int getWidth() {
		return 1;
	}

	public Cardinality getInboundRelationshipCardinality() {
		return null;
	}

	public Relationship getFirstOutgoingAssociation() {
		return null;
	}

	public boolean isCmet() {
		return false;
	}

	public boolean isAbstract() {
		return false;
	}

	public boolean isSpecialization() {
		return false;
	}

	public boolean isRootType() {
		return false;
	}

	public boolean isRecursive() {
		return false;
	}

	public InboundAssociation getInboundAssociation() {
		return null;
	}

	public String getName() {
		return this.packageLocation.getName();
	}

	public CmetBinding getCmetBinding() {
		return null;
	}
}
