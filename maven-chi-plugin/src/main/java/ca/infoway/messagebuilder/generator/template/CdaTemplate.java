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

package ca.infoway.messagebuilder.generator.template;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(reference="http://www.lantanagroup.com")
public class CdaTemplate {
	
	@Attribute(required=false)
	private String impliedTemplateOid;
	
	@Attribute(name="isOpen")
	private boolean open;
	
	@Attribute
	private String contextType;
	
	@Attribute
	private String templateType;
	
	@Attribute
	private String oid;
	
	@Attribute
	private String context;
	
	@Attribute
	private String title;
	
	@Element(name="Description",required=false)
	private TemplateDescription description;
	
	@ElementList(inline=true,entry="Constraint")
	private List<CdaConstraint> constraints = new ArrayList<CdaConstraint>();
	
	public String getImpliedTemplateOid() {
		return impliedTemplateOid;
	}

	public void setImpliedTemplateOid(String impliedTemplateOid) {
		this.impliedTemplateOid = impliedTemplateOid;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
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

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TemplateDescription getDescription() {
		return description;
	}

	public void setDescription(TemplateDescription description) {
		this.description = description;
	}

	public List<CdaConstraint> getConstraints() {
		return constraints;
	}

}
