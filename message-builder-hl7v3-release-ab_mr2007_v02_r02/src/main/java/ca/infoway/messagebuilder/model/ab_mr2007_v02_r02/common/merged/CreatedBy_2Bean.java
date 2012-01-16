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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged;

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
import java.util.Date;



/**
 * <p>CreatedBy</p>
 * 
 * <p>MFMI_MT700751CA.Author: a:*created by</p>
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

    private static final long serialVersionUID = 20120116L;
    private TS time = new TSImpl();
    private CV modeCode = new CVImpl();
    private ED<String> signatureText = new EDImpl<String>();
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
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
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
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
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
    public String getSignatureText() {
        return this.signatureText.getValue();
    }
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }


    @Hl7XmlMapping({"authorPerson"})
    public AuthorPerson getAuthorPerson() {
        return this.authorPerson;
    }
    public void setAuthorPerson(AuthorPerson authorPerson) {
        this.authorPerson = authorPerson;
    }

}
