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
 * Last modified: $LastChangedDate: 2013-10-11 11:41:37 -0400 (Fri, 11 Oct 2013) $
 * Revision:      $LastChangedRevision: 7977 $
 */

package ca.infoway.messagebuilder.xml.template;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.delta.Delta;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;

/**
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
public class Template {
	
	private String oid;
	
	private boolean open;
	private String title;
	private String contextType;
	private String templateType;
	private String context;
	private String impliedTemplateOid;
	private String packageName;
	private String entryClassName;
	
	private String description;
	
	private List<Delta> deltas = new ArrayList<Delta>();
	private List<TemplateReference> templateReferences = new ArrayList<TemplateReference>();
	
	public Template() {
		
	}
	
	public Template(String oid) {
		this.oid = oid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContextType() {
		return contextType;
	}

	public void setContextType(String contextType) {
		this.contextType = contextType;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getImpliedTemplateOid() {
		return impliedTemplateOid;
	}

	public void setImpliedTemplateOid(String impliedTemplateOid) {
		this.impliedTemplateOid = impliedTemplateOid;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getEntryClassName() {
		return entryClassName;
	}

	public void setEntryClassName(String entryClassName) {
		this.entryClassName = entryClassName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Delta> getDeltas() {
		return deltas;
	}
	
	public void addDelta(Delta delta) {
		deltas.add(delta);
	}
	
	public Delta getDelta(DeltaChangeType type, String messagePart, String relationshipName) {
		for (Delta delta : deltas) {
			if (new EqualsBuilder().append(delta.getDeltaChangeType(), type)
					.append(delta.getClassName(), messagePart)
					.append(delta.getRelationshipName(), relationshipName).isEquals()) {
				return delta; 
			}
		}
		return null;
	}
	
	public List<TemplateReference> getTemplateReferences() {
		return templateReferences;
	}

	public void addTemplateReference(String context, String containedTemplateOid, Cardinality cardinality) {
		TemplateReference reference = new TemplateReference();
		reference.setContext(context);
		reference.setOid(containedTemplateOid);
		reference.setCardinality(cardinality);
		templateReferences.add(reference);
	}

	public void cloneDelta(Delta parentDelta) {
		addDelta(parentDelta.clone(this.packageName));
		
	}

	public boolean isDocumentTemplate() {
		return StringUtils.equals(this.templateType, "document");
	}

}
