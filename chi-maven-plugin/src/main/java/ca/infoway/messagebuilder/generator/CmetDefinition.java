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

package ca.infoway.messagebuilder.generator;

import ca.infoway.messagebuilder.xml.Documentable;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.TypeName;

public class CmetDefinition implements Documentable {

	private String definitionPackage;
	private String cmetName;
	private String attributionLevel;
	private String code;
	private String codeSystemOid;
	private String boundClass;
	private Documentation documentation;
	
	public String getDefinitionPackage() {
		return definitionPackage;
	}
	public void setDefinitionPackage(String definitionPackage) {
		this.definitionPackage = definitionPackage;
	}
	public String getCmetName() {
		return cmetName;
	}
	public void setCmetName(String cmetName) {
		this.cmetName = cmetName;
	}
	public String getAttributionLevel() {
		return attributionLevel;
	}
	public void setAttributionLevel(String attributionLevel) {
		this.attributionLevel = attributionLevel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeSystemOid() {
		return codeSystemOid;
	}
	public void setCodeSystemOid(String codeSystemOid) {
		this.codeSystemOid = codeSystemOid;
	}
	public String getBoundClass() {
		return boundClass;
	}
	public void setBoundClass(String boundClass) {
		this.boundClass = boundClass;
	}
	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	public CmetDefinitionKey toKeyByAlias() {
		return new CmetDefinitionKey(this.definitionPackage, this.cmetName);
	}
	public CmetDefinitionKey toKeyByPackageName() {
		return new CmetDefinitionKey(this.definitionPackage, TypeName.determineRootName(this.boundClass));
	}
}
