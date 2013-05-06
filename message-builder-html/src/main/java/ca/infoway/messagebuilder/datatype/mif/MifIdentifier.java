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
package ca.infoway.messagebuilder.datatype.mif;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class MifIdentifier {
	
	@Attribute
	private String root;
	@Attribute
	private String artifact;
	@Attribute
	private String realmNamespace;
	@Attribute
	private String version;
	
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getArtifact() {
		return artifact;
	}
	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}
	public String getRealmNamespace() {
		return realmNamespace;
	}
	public void setRealmNamespace(String realNamespace) {
		this.realmNamespace = realNamespace;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String toPackageName() {
		StringBuffer buf = new StringBuffer();
		
		buf.append(getRoot());
		buf.append("=");
		buf.append(getRealmNamespace());
		buf.append("=");
		buf.append(getArtifact());
		buf.append("=");
		buf.append(getVersion());
			
		return buf.toString();
	}

}
