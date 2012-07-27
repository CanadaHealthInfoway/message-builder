/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.datatype.lang;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.Oid;

/**
 * <p>An instance identifier. Backs the HL7 datatype II.
 * 
 * <p>An identifier that uniquely identifies a thing or object. Examples are object 
 * identifier for HL7 RIM objects, medical record number, order id, service catalog 
 * item id, Vehicle Identification Number (VIN), etc. Instance identifiers are 
 * defined based on ISO object identifiers. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class Identifier implements Serializable {
    
    private static final long serialVersionUID = -3182973493107028067L;
    private String root;
    private String extension;
	private String version;

	/**
     * <p>Constructs an empty identifier.
     */
    public Identifier() {
    }
    
    /**
     * <p>Constructs an Identifier with the supplied parameters.
     * 
     * @param oid the codesystem
     * @param extension the extension
     */
    public Identifier(Oid oid, String extension) {
    	this(oid == null ? null : oid.getRoot(), extension, null);
    }
    
    public Identifier(Oid oid, String extension, String version) {
    	this(oid == null ? null : oid.getRoot(), extension, version);
    }

    /**
     * <p>Constructs an Identifier with the supplied parameters.
     * 
     * @param root the root
     * @param extension the extension
     */
    public Identifier(String root, String extension) {
    	this(root, extension, null);
    }

    public Identifier(String root, String extension, String version) {
        this.root = root;
        this.extension = extension;
		this.version = version;
    }

    /**
     * <p>Constructs an Identifier with the supplied parameters.
     * 
     * @param root the root
     */
    public Identifier(String root) {
        this(root, null);
    }
    
    /**
     * <p>Sets the extension.
     * 
     * @param extension the extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    /**
     * <p>Returns the extension.
     * 
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }
    
    /**
     * <p>Sets the root.
     * 
     * @param root the root.
     */
    public void setRoot(String root) {
        this.root = root;
    }
    
    /**
     * <p>Returns the root.
     * 
     * @return the root
     */
    public String getRoot() {
        return root;
    }

    /**
     * <p>Returns the version (only applicable for II.BUSVER and II.PUBLICVER)
     * 
     * @return the version
     */
    public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

    /**
     * <p>Formats this object as a string.
     * 
     * @return the string representation of this object
     */
    public String toString() {
        return "root={" + this.root + "},extension={" + this.extension + "}" + (this.version == null ? "" : ",version={" + this.version + "}") ;
    }
    
    /**
     * <p>Calculates a hashcode for this object based on root and extension.
     * 
     * @return the hashcode of this object
     */
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.root)
                .append(this.extension)
                .append(this.version)
                .toHashCode();
    }

    /**
     * <p>Determines if the supplied object is equal to this object based on root and extension.
     * 
     * @param obj the object to compare
     * @return whether the supplied object equals this object 
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((Identifier) obj);
        }
    }

    private boolean equals(Identifier that) {
        return new EqualsBuilder()
                .append(this.root, that.root)
                .append(this.extension, that.extension)
                .append(this.version, that.version)
                .isEquals();
    }
}
