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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.LocationIdentifiedEntityRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Has</p>
 * 
 * <p>PRPA_MT202303CA.IdentifiedLocation: *k:has</p>
 * 
 * <p><p>Provides additional identifiers by which the location 
 * may be known.</p></p>
 * 
 * <p><p>In a registry, it is often necessary to link a 
 * location record to other registries or to commonly used 
 * jurisdictional identifiers.</p></p>
 * 
 * <p>PRPA_MT202302CA.IdentifiedLocation: *k:has</p>
 * 
 * <p><p>Provides additional identifiers by which the location 
 * may be known.</p></p>
 * 
 * <p><p>In a registry, it is often necessary to link a 
 * location record to other registries or to commonly used 
 * jurisdictional identifiers.</p></p>
 * 
 * <p>PRPA_MT202301CA.IdentifiedLocation: *k:has</p>
 * 
 * <p><p>Provides additional identifiers by which the location 
 * may be known.</p></p>
 * 
 * <p><p>In a registry, it is often necessary to link a 
 * location record to other registries or to commonly used 
 * jurisdictional identifiers.</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT202301CA.IdentifiedLocation","PRPA_MT202302CA.IdentifiedLocation","PRPA_MT202303CA.IdentifiedLocation"})
public class HasBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST assigningIdentifierOrganizationName = new STImpl();


    /**
     * <p>Identifier</p>
     * 
     * <p>A: Identifier</p>
     * 
     * <p><p>An identifier by which the location is known.</p></p>
     * 
     * <p><p>Specifies the actual identifier that can be used for 
     * searching or linking. The attribute is mandatory because 
     * there is no point specifying an &quot;Other 
     * Identifiers&quot; class if you are not going to specify an 
     * identifier.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>IdentifierType</p>
     * 
     * <p>B:Identifier Type</p>
     * 
     * <p><p>Specifies the kind of identifier being communicated. 
     * For example, billing identifier, regional identifier, public 
     * health identifier, etc.</p></p>
     * 
     * <p><p>Provides context around the appropriate use for the 
     * identifier and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public LocationIdentifiedEntityRoleType getCode() {
        return (LocationIdentifiedEntityRoleType) this.code.getValue();
    }
    public void setCode(LocationIdentifiedEntityRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>IdentifyingOrganization</p>
     * 
     * <p>C: Identifying Organization</p>
     * 
     * <p><p>This is the name of the organization which issued 
     * and/or uses the identifier for the location.</p></p>
     * 
     * <p><p>Further qualifies how the identifier is intended to be 
     * used. For example distinguishing a health-region assigned 
     * identifier from a provincially-assigned identifier. Because 
     * it is important to understanding the identifier, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"assigningIdentifierOrganization/name"})
    public String getAssigningIdentifierOrganizationName() {
        return this.assigningIdentifierOrganizationName.getValue();
    }
    public void setAssigningIdentifierOrganizationName(String assigningIdentifierOrganizationName) {
        this.assigningIdentifierOrganizationName.setValue(assigningIdentifierOrganizationName);
    }

}
