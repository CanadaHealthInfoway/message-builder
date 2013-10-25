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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifValueSetVersion {

	@Attribute(name="versionDate")
	private Date date;
	@ElementList(required=false,inline=true,entry="content")
	private List<MifValueSetContent> content = new ArrayList<MifValueSetContent>();
	@ElementList(required=false,inline=false,name="enumeratedContent",entry="code")
	private ArrayList<MifCode> enumeratedCodes = new ArrayList<MifCode>(); // RM 17524: TM - changed to ArrayList to prevent simpleframework from outputting java class reference
	@ElementList(required=false,inline=false,name="exampleContent",entry="code")
	private ArrayList<MifCode> exampleCodes = new ArrayList<MifCode>(); // RM 17524: TM - changed to ArrayList to prevent simpleframework from outputting java class reference

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<MifCode> getEnumeratedCodes() {
		return enumeratedCodes;
	}

	public void setEnumeratedCodes(ArrayList<MifCode> enumeratedCodes) {
		this.enumeratedCodes = enumeratedCodes;
	}

	public boolean hasEnumeratedCodes() {
		return getEnumeratedCodes() != null && !getEnumeratedCodes().isEmpty();
	}

	public List<MifValueSetContent> getContent() {
		return content;
	}

	public void setContent(List<MifValueSetContent> content) {
		this.content = content;
	}

	public ArrayList<MifCode> getExampleCodes() {
		return exampleCodes;
	}

	public void setExampleCodes(ArrayList<MifCode> exampleCodes) {
		this.exampleCodes = exampleCodes;
	}
	
}
