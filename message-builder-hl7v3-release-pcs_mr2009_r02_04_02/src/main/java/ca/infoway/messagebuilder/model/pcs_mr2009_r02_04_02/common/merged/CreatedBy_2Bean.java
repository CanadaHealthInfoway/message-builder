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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mfmi_mt700711ca.NullAuthorRoleBean;
import java.util.Date;



/**
 * <p>CreatedBy</p>
 * 
 * <p>MFMI_MT700751CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise (R_AssignedPerson CMET or R_AssignedOrganization) 
 * must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p>MFMI_MT700711CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise (R_AssignedPerson CMET or R_AssignedOrganization) 
 * must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.Author","MFMI_MT700751CA.Author"})
public class CreatedBy_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TS timeOfCreation = new TSImpl();
    private CV informationReceivedMethod = new CVImpl();
    private ED<String> digitalSignature = new EDImpl<String>();
    private AuthorPerson authorPerson;


    /**
     * <p>TimeOfCreation</p>
     * 
     * <p>D:Time of Creation</p>
     * 
     * <p><p>The time the person responsible for the event made the 
     * decision for it to occur. This may be different than the 
     * time the change became effective. (E.g. If a provider 
     * decides today to put a prescription on hold starting next 
     * Tuesday, the time of creation would be today and the change 
     * effective period would be next Tuesday.)</p><p>This date can 
     * be back-dated.</p></p>
     * 
     * <p><p>The time the person responsible for the event made the 
     * decision for it to occur. This may be different than the 
     * time the change became effective. (E.g. If a provider 
     * decides today to put a prescription on hold starting next 
     * Tuesday, the time of creation would be today and the change 
     * effective period would be next Tuesday.)</p><p>This date can 
     * be back-dated.</p></p>
     * 
     * <p><p>The time a change is made is a critical piece of audit 
     * information and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTimeOfCreation() {
        return this.timeOfCreation.getValue();
    }
    public void setTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation.setValue(timeOfCreation);
    }


    /**
     * <p>InformationReceivedMethod</p>
     * 
     * <p>F:Information Received Method</p>
     * 
     * <p><p>Indicates how the person who recorded the event became 
     * aware of it.. E.g. Verbal, written, fax, etc.</p></p>
     * 
     * <p><p>May have ramifications for the audit trail and 
     * reliability of the information.</p></p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getInformationReceivedMethod() {
        return (ParticipationMode) this.informationReceivedMethod.getValue();
    }
    public void setInformationReceivedMethod(ParticipationMode informationReceivedMethod) {
        this.informationReceivedMethod.setValue(informationReceivedMethod);
    }


    /**
     * <p>DigitalSignature</p>
     * 
     * <p>G:Digital Signature</p>
     * 
     * <p><p>Indicates the formal digital signature of the message 
     * content.</p></p>
     * 
     * <p><p>Digital signatures may be needed for authentication of 
     * message content. The attribute is marked as optional because 
     * it is not yet clear whether there is a use-case for this, or 
     * where it will be used.</p></p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getDigitalSignature() {
        return this.digitalSignature.getValue();
    }
    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature.setValue(digitalSignature);
    }


    @Hl7XmlMapping({"authorPerson"})
    public AuthorPerson getAuthorPerson() {
        return this.authorPerson;
    }
    public void setAuthorPerson(AuthorPerson authorPerson) {
        this.authorPerson = authorPerson;
    }

}
