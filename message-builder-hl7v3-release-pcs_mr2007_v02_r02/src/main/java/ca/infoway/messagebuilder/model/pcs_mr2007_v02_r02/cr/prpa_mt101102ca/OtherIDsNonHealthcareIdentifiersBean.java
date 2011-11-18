/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.cr.prpa_mt101102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.OtherIDsRoleCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Other IDs Non Healthcare Identifiers</p>
 * 
 * <p><p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p></p>
 * 
 * <p><p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101102CA.OtherIDs"})
public class OtherIDsNonHealthcareIdentifiersBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private II scopingIdOrganizationId = new IIImpl();
    private ST scopingIdOrganizationName = new STImpl();


    /**
     * <p>NonHealthcare Identification</p>
     * 
     * <p><p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>NonHealthcare Identification Code</p>
     * 
     * <p><p>A pan Canadian code further specifying the kind of 
     * Role such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"code"})
    public OtherIDsRoleCode getCode() {
        return (OtherIDsRoleCode) this.code.getValue();
    }
    public void setCode(OtherIDsRoleCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>NonHealthcare Organization Identifier</p>
     * 
     * <p><p>Unique identifier for the organization that assigned 
     * the non-healthcare identifier for the client.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p></p>
     */
    @Hl7XmlMapping({"scopingIdOrganization/id"})
    public Identifier getScopingIdOrganizationId() {
        return this.scopingIdOrganizationId.getValue();
    }
    public void setScopingIdOrganizationId(Identifier scopingIdOrganizationId) {
        this.scopingIdOrganizationId.setValue(scopingIdOrganizationId);
    }


    /**
     * <p>NonHealthcare Organization Name</p>
     * 
     * <p><p>A name for the non-healthcare organization</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p></p>
     */
    @Hl7XmlMapping({"scopingIdOrganization/name"})
    public String getScopingIdOrganizationName() {
        return this.scopingIdOrganizationName.getValue();
    }
    public void setScopingIdOrganizationName(String scopingIdOrganizationName) {
        this.scopingIdOrganizationName.setValue(scopingIdOrganizationName);
    }

}
