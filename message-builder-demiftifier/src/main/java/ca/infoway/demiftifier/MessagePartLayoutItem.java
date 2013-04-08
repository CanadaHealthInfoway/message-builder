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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.CmetBinding;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>A class that models mif elements added to the layout.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public class MessagePartLayoutItem implements LayoutItem {

	private final MessagePart messagePart;
	
	private int logicalX = -1;
	private int logicalY = -1;
	private int height = 1;
	private int width = 1;
	
	private InboundAssociation inboundAssociation;

	private MessagePartLayoutItem original;
	private boolean cyclic;
	private Layout layout;
	MessagePartLayoutItem parentItem;

	private int encroachmentLevel;
	private int encroachmentLevelEnd;


	
	public MessagePartLayoutItem getOriginal() {
		return original == null ? this : this.original;
	}

	public boolean isDuplicate() {
		return this.original != null;
	}

	public boolean isAbstract() {
		return this.messagePart.isAbstract();
	}
	/**
	 * 
	 * @param messagePart
	 * @param rootPackageLocationName - the root type's package location name - used to identify CMET references
	 * 
	 */
	public MessagePartLayoutItem(MessagePart messagePart, Layout layout) {
		this.messagePart = messagePart;
		this.layout = layout;
	}
	
	MessagePartLayoutItem(MessagePartLayoutItem parent, MessagePart messagePart, Layout layout) {
		this.parentItem = parent;
		this.messagePart = messagePart;
		this.layout = layout;
	}
	
	public MessagePart getMessagePart() {
		return this.messagePart;
	}
	
	public int getLogicalY() {
		return logicalY;
	}

	public void setLogicalY(int logicalY) {
		this.logicalY = logicalY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLogicalX() {
		return logicalX;
	}

	public void setLogicalX(int logicalX) {
		this.logicalX = logicalX;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}

	public String getName() {
		return this.messagePart.getName();
	}

	/*
	 * Delegate methods
	 */
	public RimClass getRimClass() {
		return this.messagePart.getRimClass();
	}

	/*
	 * Behaviour methods (other than simple mutation)
	 */
	public String getLabel() {
		if (isCmet()) {
			return TypeName.determineRootName(getName());
		} else if (this.inboundAssociation != null && 
				(this.messagePart.getRimClass() == RimClass.ACT_RELATIONSHIP || 
				this.messagePart.getRimClass() == RimClass.PARTICIPATION)) {
			return this.inboundAssociation.getName();
		} else {
			return new TypeName(this.messagePart.getName()).getUnqualifiedName();
		}
	}

	public List<Relationship> getAttributes() {
		List<Relationship> result = new ArrayList<Relationship>();
		if (!isCmet() && !isDuplicate()) {
			for (Relationship relationship : this.messagePart.getRelationships()) {
				if (relationship.isAttribute()) {
					result.add(relationship);
				}
			}
		}
		return result;
	}
	
	public boolean isCmet() {
		return !StringUtils.equals(this.layout.getPackageLocation().getName(), TypeName.determineRootName(getName()));
	}
	
	public boolean isAlreadyLayedOut() {
		return this.logicalX >= 0 && this.logicalY >= 0;
	}
	public MessagePartLayoutItem createDuplicate() {
		MessagePartLayoutItem duplicate = new MessagePartLayoutItem(messagePart, this.layout);
		duplicate.original = getOriginal();
		this.layout.addItem(duplicate);
		return duplicate;
	}

	public PackageLocation getPackageLocation() {
		return this.layout.getMessageSet().getPackageLocation(TypeName.determineRootName(this.messagePart.getName()));
	}

	@Deprecated
	public MessageSet getMessageSet() {
		return this.layout.getMessageSet();
	}

	public Layout getLayout() {
		return this.layout;
	}

	public List<Relationship> getAssociations() {
		List<Relationship> result = new ArrayList<Relationship>();
		if (!isCmet() && !isDuplicate()) {
			result = getAssociationRelationships();
		}
		return result;
	}

	private List<Relationship> getAssociationRelationships() {
		List<Relationship> result = new ArrayList<Relationship>();
		for (Relationship relationship : this.messagePart.getRelationships()) {
			if (relationship.isAssociation()) {
				result.add(relationship);
			}
		}
		return result;
	}

	public Relationship getFirstOutgoingAssociation() {
		List<Relationship> result = getAssociationRelationships();
		return result.isEmpty() ? null : result.get(0);
	}

	public boolean isRootType() {
		return StringUtils.equals(getMessagePart().getName(), getPackageLocation().getRootType());
	}

	public List<AnnotationItem> getRelevantAnnotations() {
		if (isCmet()) {
			return Collections.<AnnotationItem>emptyList();
		} else {
			List<AnnotationItem> result = new ArrayList<AnnotationItem>();
			addAnnotationItems(result, this.messagePart.getDocumentation(), null, AnnotationType.DEFINITION, AnnotationType.CONSTRAINT);
			for (Relationship relationship : this.messagePart.getRelationships()) {
				addAnnotationItems(result, relationship.getDocumentation(), relationship.getName(), AnnotationType.CONSTRAINT);
			}
			return result;
		}
	}

	private void addAnnotationItems(List<AnnotationItem> result,
			Documentation documentation, String relationshipName, AnnotationType... types) {
		Set<AnnotationType> set = new HashSet<AnnotationType>(Arrays.asList(types));
		if (documentation != null) {
			for (Annotation annotation : documentation.getAnnotations()) {
				if (set.contains(annotation.getAnnotationTypeAsEnum())) {
					result.add(AnnotationItem.from(annotation, relationshipName));
				}
			}
		}
	}

	public boolean isSpecialization() {
		return this.parentItem != null;
	}
	
	public MessagePartLayoutItem getTopAncestor() {
		if (this.parentItem == null) {
			return this;
		} else {
			return this.parentItem.getTopAncestor();
		}
	}

	public MessagePartLayoutItem getParentItem() {
		return this.parentItem;
	}
	public Collection<MessagePartLayoutItem> getSpecializationChilds() {
		return this.layout.getSpecializationChildsFor(this);
	}

	public int getEncroachmentLevel() {
		return this.encroachmentLevel;
	}

	public void setEncroachmentLevel(int encroachmentLevel) {
		this.encroachmentLevel = encroachmentLevel;
	}

	public int getSpecializationDepth() {
		if (this.parentItem == null) {
			return 0;
		} else {
			return 1 + this.parentItem.getSpecializationDepth();
		}
	}

	public InboundAssociation getInboundAssociation() {
		return this.inboundAssociation;
	}
	
	public void setInboundAssociation(InboundAssociation inboundAssociation){
		this.inboundAssociation = inboundAssociation;
	}

	public boolean isEntityOrOtherClassType() {
		return this.getRimClass() == RimClass.ENTITY || this.getRimClass() == RimClass.OTHER_CLASS;
	}

	public boolean isCyclic() {
		return this.cyclic;
	}

	public void setCyclic(boolean cyclic) {
		this.cyclic = cyclic;
	}

	public void setEncroachmentLevelEnd(int encroachmentLevelEnd) {
		this.encroachmentLevelEnd = encroachmentLevelEnd;
	}

	public int getEncroachmentLevelEnd() {
		return this.encroachmentLevelEnd;
	}
	public boolean isTrivial() {
		return isCmet() || getAssociations().size() == 0;
	}
	@Override
	public CmetBinding getCmetBinding() {
		if (this.getPackageLocation() != null) {
			String cmetBindingName = null;
			if (this.getInboundAssociation() != null) {
				cmetBindingName = this.getInboundAssociation().getCmetBindingName();
			} else if (this.getPackageLocation() != null && this.isSpecialization()) {
				for (SpecializationChild specializationChild : this.parentItem.messagePart.getSpecializationChilds()) {
					if (specializationChild.getName().equals(this.messagePart.getName())) {
						cmetBindingName = specializationChild.getCmetBindingName();
						break;
					}
				}
			}
			
			return cmetBindingName == null ? null : this.getPackageLocation().getCmetBinding(cmetBindingName);
		} else {
			return null;
		}
	}
}
