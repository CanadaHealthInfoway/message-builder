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
	private List<MifCode> enumeratedCodes = new ArrayList<MifCode>();
	@ElementList(required=false,inline=false,name="exampleContent",entry="code")
	private List<MifCode> exampleCodes = new ArrayList<MifCode>();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<MifCode> getEnumeratedCodes() {
		return enumeratedCodes;
	}

	public void setEnumeratedCodes(List<MifCode> enumeratedCodes) {
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

	public List<MifCode> getExampleCodes() {
		return exampleCodes;
	}

	public void setExampleCodes(List<MifCode> exampleCodes) {
		this.exampleCodes = exampleCodes;
	}
	
}
