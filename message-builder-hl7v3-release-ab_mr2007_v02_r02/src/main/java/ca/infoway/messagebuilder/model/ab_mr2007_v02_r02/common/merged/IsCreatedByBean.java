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
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>COCT_MT470002CA.Author2: c:consent overridden by</p>
 * 
 * <p><p>Indicates that information access was approved by a 
 * provider rather than a patient. I.e. This is an override 
 * rather than an actual consent, and is used for the purposes 
 * of 'breaking the glass' only.</p></p>
 * 
 * <p><p>Authorization.signatory(PROV)</p></p>
 * 
 * <p><p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p></p>
 * 
 * <p>COCT_MT260010CA.Author2: is created by</p>
 * 
 * <p><p>Identity of the organization who is responsible for 
 * the contents of the monograph.</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>Provides a means of evaluating accuracy of 
 * content.</p></p>
 * 
 * <p>COCT_MT470012CA.Author2: c:consent overridden by</p>
 * 
 * <p><p>Indicates that information access was approved by a 
 * provider rather than a patient, client, or original 
 * provider. I.e. This is an override rather than an actual 
 * consent, and is used for the purposes of 'breaking the 
 * glass' only.</p></p>
 * 
 * <p><p>Authorization.signatory(PROV)</p></p>
 * 
 * <p><p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p></p>
 * 
 * <p>COCT_MT260030CA.Author2: is created by</p>
 * 
 * <p><p>Identity of the organization who is responsible for 
 * the contents of the monograph.</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>Provides a means of evaluating accuracy of 
 * content.</p></p>
 * 
 * <p>COCT_MT260020CA.Author2: is created by</p>
 * 
 * <p><p>Identity of the organization who is responsible for 
 * the contents of the monograph.</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>Provides a means of evaluating accuracy of 
 * content.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.Author2","COCT_MT260020CA.Author2","COCT_MT260030CA.Author2","COCT_MT470002CA.Author2","COCT_MT470012CA.Author2"})
public class IsCreatedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CS typeCode = new CSImpl();
    private CS contextControlCode = new CSImpl();
    private AssignedEntity_1Bean assignedEntity;
    private TS time = new TSImpl();


    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    @Hl7XmlMapping({"assignedEntity"})
    public AssignedEntity_1Bean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(AssignedEntity_1Bean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }


    /**
     * <p>IssueMonographEffectiveDate</p>
     * 
     * <p>B:Issue Monograph Effective Date</p>
     * 
     * <p><p>The date and time on which the monograph becomes valid 
     * and applicable.</p></p>
     * 
     * <p><p>DDIMonograph.EffectiveDate</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>DDIMonograph.EffectiveDate</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Allows detailed matching of local knowledgebase record 
     * with that of the central. (The monograph id may remain the 
     * same, but the effective date will always change).</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }

}
