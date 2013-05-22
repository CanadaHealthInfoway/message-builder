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

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifCodeSystem {

	@Attribute(required=false)
	private String name;
	@Attribute(required=false)
	private String title;
	@Attribute(required=false)
	private String codeSystemId;
	@Element(required=false)
	private MifCodeSystemHeader header;
	@Element(required=false)
	private MifAnnotations annotations;
	@Element(required=false)
	private MifCodeSystemVersion releasedVersion;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCodeSystemId() {
		return codeSystemId;
	}

	public void setCodeSystemId(String codeSystemId) {
		this.codeSystemId = codeSystemId;
	}

	public MifCodeSystemHeader getHeader() {
		return header;
	}

	public void setHeader(MifCodeSystemHeader header) {
		this.header = header;
	}

	public MifCodeSystemVersion getReleasedVersion() {
		return releasedVersion;
	}

	public void setReleasedVersion(MifCodeSystemVersion releasedVersion) {
		this.releasedVersion = releasedVersion;
	}

	public MifAnnotations getAnnotations() {
		return annotations;
	}

	public void setAnnotations(MifAnnotations annotations) {
		this.annotations = annotations;
	}

}
