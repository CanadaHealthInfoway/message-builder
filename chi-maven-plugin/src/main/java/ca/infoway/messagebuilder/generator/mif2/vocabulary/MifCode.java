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
 * Last modified: $LastChangedDate: 2012-03-06 13:41:31 -0500 (Tue, 06 Mar 2012) $
 * Revision:      $LastChangedRevision: 5770 $
 */
package ca.infoway.messagebuilder.generator.mif2.vocabulary;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifCode {
	
	@Attribute(required=false)
	private String codeSystemName;
	@Attribute(required=false)
	private String codeSystem;
	@Attribute(required=false)
	private String code;
	@Attribute(required=false)
	private String status;
	@Attribute(required=false)
	private String codePrintName;
	@ElementList(required=false,inline=true,entry="printName")
	private List<MifConceptPrintName> printNames;

	public String getCodeSystemName() {
		return codeSystemName;
	}
	
	public String getCodeSystem() {
		return codeSystem;
	}

	public String getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodePrintName() {
		return codePrintName;
	}

	public List<MifConceptPrintName> getPrintNames() {
		return printNames;
	}
	
	public boolean isActive() {
		return "active".equals(status);
	}

}
