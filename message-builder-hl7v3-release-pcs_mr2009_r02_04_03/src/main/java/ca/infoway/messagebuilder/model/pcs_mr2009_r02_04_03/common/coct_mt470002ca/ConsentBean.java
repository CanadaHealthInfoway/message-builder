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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt470002ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090102ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.AccessTypeBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ConsentedToByBean;
import java.util.Date;



/**
 * <p>Consent</p>
 * 
 * <p><p>One and only one of author2 (Consenter) and author1 
 * (Provider) must be specified.</p></p>
 * 
 * <p><p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis. May be required on a Prescription Request to indicate 
 * a keyword for DUR processing.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis. May be required on a Prescription Request to indicate 
 * a keyword for DUR processing.</p></p>
 * 
 * <p><p>The keywords will not be passed from prescriber to 
 * dispenser by the DIS.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private PatientBean subject1Patient;
    private ConsentedToByBean author1;
    private HealthcareWorkerBean author2AssignedEntity;
    private AccessTypeBean subject2InformDefinition;


    /**
     * <p>D:Consent Form Number</p>
     * 
     * <p><p>A unique identifier for a specific consent for a 
     * patient.</p></p>
     * 
     * <p><p>Authorization.formNumber</p></p>
     * 
     * <p><p>Provides a traceable audit link between a physical 
     * consent form and its electronic record</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>C:Consent Effective and End Time</p>
     * 
     * <p><p>Indicates the time that the consent will expire. 'Low' 
     * is effective time and 'High' is end time.</p></p>
     * 
     * <p><p>Authorization.endTime (high)</p></p>
     * 
     * <p><p>Most consents are not open-ended, to ensure the 
     * patient retains a level of control.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>E:Consent Override Reason</p>
     * 
     * <p><p>If author1 (provider) is specified, reason code must 
     * be specified.</p></p>
     * 
     * <p><p>Indicates a reason for overriding a patient's consent 
     * rules.</p></p>
     * 
     * <p><p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p></p>
     * 
     * <p><p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p></p>
     * 
     * <p><p>Important for audit purposes</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public Code getReasonCode() {
        return (Code) this.reasonCode.getValue();
    }
    public void setReasonCode(Code reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"subject1/patient"})
    public PatientBean getSubject1Patient() {
        return this.subject1Patient;
    }
    public void setSubject1Patient(PatientBean subject1Patient) {
        this.subject1Patient = subject1Patient;
    }


    @Hl7XmlMapping({"author1"})
    public ConsentedToByBean getAuthor1() {
        return this.author1;
    }
    public void setAuthor1(ConsentedToByBean author1) {
        this.author1 = author1;
    }


    @Hl7XmlMapping({"author2/assignedEntity"})
    public HealthcareWorkerBean getAuthor2AssignedEntity() {
        return this.author2AssignedEntity;
    }
    public void setAuthor2AssignedEntity(HealthcareWorkerBean author2AssignedEntity) {
        this.author2AssignedEntity = author2AssignedEntity;
    }


    @Hl7XmlMapping({"subject2/informDefinition"})
    public AccessTypeBean getSubject2InformDefinition() {
        return this.subject2InformDefinition;
    }
    public void setSubject2InformDefinition(AccessTypeBean subject2InformDefinition) {
        this.subject2InformDefinition = subject2InformDefinition;
    }

}
