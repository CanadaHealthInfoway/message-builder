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

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.xml.CmetBinding;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;

public class ConceptDomainLayoutItem implements LayoutItem {
	private int logicalX = -1;
	private int logicalY = -1;
	private int height = 1;
	private int width = 1;
	private ConceptDomain conceptDomain;
	
	public ConceptDomainLayoutItem(ConceptDomain conceptDomain) {
		this.conceptDomain = conceptDomain;
	}

	@Override
	public int getLogicalX() {
		return logicalX;
	}
	public void setLogicalX(int logicalX) {
		this.logicalX = logicalX;
	}
	
	@Override
	public int getLogicalY() {
		return logicalY;
	}
	public void setLogicalY(int logicalY) {
		this.logicalY = logicalY;
	}

	@Override
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}


	@Override
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String getName() {
		return getConceptDomain().getName();
	}

	@Override
	public String getLabel() {
		return getConceptDomain().getName();
	}

	@Override
	public RimClass getRimClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relationship> getAttributes() {
		return new ArrayList<Relationship>();
	}

	@Override
	public PackageLocation getPackageLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship getFirstOutgoingAssociation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDuplicate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCmet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAbstract() {
		return false;
	}

	@Override
	public boolean isSpecialization() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRootType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InboundElement getInboundElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmetBinding getCmetBinding() {
		// TODO Auto-generated method stub
		return null;
	}

	public ConceptDomain getConceptDomain() {
		return conceptDomain;
	}

	public void setConceptDomain(ConceptDomain conceptDomain) {
		this.conceptDomain = conceptDomain;
	}
}
