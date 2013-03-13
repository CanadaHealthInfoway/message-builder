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

package ca.infoway.messagebuilder.xml;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * <p>Descriptors of external resources that are imported into a MIF file
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class ImportedPackage  {
	
	@Attribute(required=false)
	private String root;
	@Attribute(required=false)
	private String artifact;
	@Attribute(required=false)
	private String version;
	@Attribute(required=false)
	private String realm;
	
	/**
	 * <p>The default constructor.
	 */
	public ImportedPackage() {
	}
	/**
	 * <p>Get the root - e.g., "DEFN"
	 * @return the root
	 */
	public String getRoot() {
		return root;
	}
	/**
	 * <p>Set the root
	 * @param root - the new root
	 */
	public void setRoot(String root) {
		this.root = root;
	}
	/**
	 * <p>Get the artifact - e.g., "VO"
	 * @return the artifact
	 */
	public String getArtifact() {
		return artifact;
	}
	/**
	 * <p>Set the artifact
	 * @param artifact - the new artifact
	 */
	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}
	/**
	 * <p>Get the version = e.g., "R04.04.xx"
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * <p>Set the version
	 * @param version - the new version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * <p>Get the realm namespace - e.g., "CA"
	 * @return the realm namespace
	 */
	public String getRealm() {
		return realm;
	}
	/**
	 * <p>Set the realm namespace
	 * @param realm - the new realm namespace
	 */
	public void setRealm(String realm) {
		this.realm = realm;
	}
	
	public String toTextRepresentation() {
		return this.root + "=" + this.realm + "=" + this.artifact + "=" + this.version;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!ImportedPackage.class.isAssignableFrom(obj.getClass())) return false;
		
		ImportedPackage that = (ImportedPackage) obj;
		return new EqualsBuilder()
			.append(this.root, that.root)
			.append(this.realm, that.realm)
			.append(this.artifact, that.artifact)
			.append(this.version, that.version)
			.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(this.root)
			.append(this.realm)
			.append(this.artifact)
			.append(this.version)
			.toHashCode();
	}
}
