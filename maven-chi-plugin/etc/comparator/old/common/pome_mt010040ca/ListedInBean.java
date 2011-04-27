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
package ca.infoway.messagebuilder.model.common.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



/**
 * <p>listed in 
 * 
 * <p>Identifies list of formularies which allow supply of the 
 * drug. Formularies may include regulatory formularies, stock 
 * formularies (i.e. what medications are typically stocked) 
 * and coverage formularies (what medications are typically 
 * covered by an insurance program.) 
 * 
 * <p>Whether a medication is typically available or covered by 
 * insurance can have a significant influence on the likelihood 
 * of a patient complying with administration instructions. 
 * Therefore it becomes an important consideration for 
 * prescribing 
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Product"})
public class ListedInBean extends MessagePartBean {

    private II formularyId = new IIImpl();
    private ST formularyName = new STImpl();
    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();
    private CV<HealthcareOrganizationRoleType> organizationType = new CVImpl<HealthcareOrganizationRoleType>();
    private SET<TEL, TelecommunicationAddress> organizationPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    @Hl7XmlMapping({"potentialSupply/id"})
    public Identifier getFormularyId() {
        return this.formularyId.getValue();
    }
    public void setFormularyId(Identifier formularyId) {
        this.formularyId.setValue(formularyId);
    }

    @Hl7XmlMapping({"potentialSupply/title"})
    public java.lang.String getFormularyName() {
        return this.formularyName.getValue();
    }
    public void setFormularyName(java.lang.String formularyName) {
        this.formularyName.setValue(formularyName);
    }

    @Hl7XmlMapping({"potentialSupply/performer/assignedEntity/assignedOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }

    @Hl7XmlMapping({"potentialSupply/performer/assignedEntity/assignedOrganization/name"})
    public java.lang.String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(java.lang.String organizationName) {
        this.organizationName.setValue(organizationName);
    }

    @Hl7XmlMapping({"potentialSupply/performer/assignedEntity/assignedOrganization/assignedOrganization/code"})
    public HealthcareOrganizationRoleType getOrganizationType() {
        return this.organizationType.getValue();
    }
    public void setOrganizationType(HealthcareOrganizationRoleType organizationType) {
        this.organizationType.setValue(organizationType);
    }

    @Hl7XmlMapping({"potentialSupply/performer/assignedEntity/assignedOrganization/assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getOrganizationPhoneAndEmails() {
        return this.organizationPhoneAndEmails.rawSet();
    }

}
