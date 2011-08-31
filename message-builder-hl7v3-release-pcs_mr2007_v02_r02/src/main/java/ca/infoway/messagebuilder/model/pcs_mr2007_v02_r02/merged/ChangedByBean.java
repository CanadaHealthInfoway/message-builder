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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.ChangedBy;
import java.util.Date;



/**
 * <p>PORX_MT060340CA.Author1: *changed by</p>
 * 
 * <p><p>Identity of the health service provider or application 
 * responsible for the change in the prescription status.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who (or 
 * what application) is responsible for status changes. Also 
 * used by applications for auditing and sorting.</p><p>The 
 * attribute is marked as &quot;mandatory&quot; because 
 * provider or application maintaining the prescription must be 
 * known.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who (or 
 * what application) is responsible for status changes. Also 
 * used by applications for auditing and sorting.</p><p>The 
 * attribute is marked as &quot;mandatory&quot; because 
 * provider or application maintaining the prescription must be 
 * known.</p></p>
 * 
 * <p>COCT_MT260022CA.Author1: managed by</p>
 * 
 * <p><p>Identifies the provider who created the management of 
 * the issue.</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>Part of the audit record, but may not always be known 
 * for historical managements.</p></p>
 * 
 * <p>COCT_MT260012CA.Author1: *managed by</p>
 * 
 * <p><p>Identifies the provider who managed the issue.</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>Part of the audit record and therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060090CA.Author6: *changed by</p>
 * 
 * <p><p>Identity of the health service provider or the 
 * application responsible for the change in the prescription 
 * dispense status.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing and sorting. The attribute is mandatory because 
 * provider or application maintaining the prescription 
 * dispense must be known.</p></p>
 * 
 * <p>COCT_MT130001CA.Author3: *changed by</p>
 * 
 * <p><p>Identity of the health service provider responsible 
 * for the change.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who is 
 * responsible for a given change. Also used by applications 
 * for auditing and sorting. The attribute is mandatory because 
 * the responsible provider should always be known.</p></p>
 * 
 * <p>PORX_MT060160CA.Author1: *changed by</p>
 * 
 * <p><p>Identity of the health service provider or application 
 * responsible for the change in the prescription status.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who (or 
 * what application) is responsible for status changes. Also 
 * used by applications for auditing and sorting.</p><p>The 
 * attribute is &quot;mandatory&quot; because provider or 
 * application maintaining the prescription must be known.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who (or 
 * what application) is responsible for status changes. Also 
 * used by applications for auditing and sorting.</p><p>The 
 * attribute is &quot;mandatory&quot; because provider or 
 * application maintaining the prescription must be known.</p></p>
 * 
 * <p>COCT_MT260030CA.Author1: *managed by</p>
 * 
 * <p><p>Identifies the provider who managed the issue.</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>Part of the audit record and therefore mandatory.</p></p>
 * 
 * <p>REPC_MT000009CA.Author3: *changed by</p>
 * 
 * <p><p>Identity of the health service provider responsible 
 * for the change in the allergy/intolerance status.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who is 
 * responsible for a given change. Also used by applications 
 * for auditing and sorting. The attribute is mandatory because 
 * the responsible provider should always be known.</p></p>
 * 
 * <p>COCT_MT260020CA.Author1: managed by</p>
 * 
 * <p><p>Identifies the provider who created the management of 
 * the issue.</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>Part of the audit record, but may not always be known 
 * for historical managements.</p></p>
 * 
 * <p>PORX_MT060040CA.Author1: *changed by</p>
 * 
 * <p><p>Identity of the health service provider or application 
 * responsible for the change in the prescription status.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who (or 
 * what application) is responsible for status changes. Also 
 * used by applications for auditing and sorting.</p><p>The 
 * attribute is mandatory because provider or application 
 * maintaining the prescription must be known.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who (or 
 * what application) is responsible for status changes. Also 
 * used by applications for auditing and sorting.</p><p>The 
 * attribute is mandatory because provider or application 
 * maintaining the prescription must be known.</p></p>
 * 
 * <p>PORX_MT060210CA.Author7: *changed by</p>
 * 
 * <p><p>Identity of the health service provider or the 
 * application responsible for the change in the other 
 * medication status.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing and sorting. The attribute is marked as 
 * &quot;mandatory&quot; because provider or application 
 * maintaining the other medication must be known.</p></p>
 * 
 * <p>COCT_MT260010CA.Author1: *managed by</p>
 * 
 * <p><p>Identifies the provider who managed the issue.</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>OverrideReason.provider</p><p>ManagedContraindication.provider</p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>Part of the audit record and therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060010CA.Author6: *changed by</p>
 * 
 * <p><p>Identity of the health service provider or the 
 * application responsible for the change in the prescription 
 * dispense status.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing and sorting.</p><p>The attribute is populated 
 * because provider or application maintaining the prescription 
 * dispense must be known else an appropriate 'null' flavor 
 * must be specified.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing and sorting.</p><p>The attribute is populated 
 * because provider or application maintaining the prescription 
 * dispense must be known else an appropriate 'null' flavor 
 * must be specified.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT130001CA.Author3","COCT_MT260010CA.Author1","COCT_MT260012CA.Author1","COCT_MT260020CA.Author1","COCT_MT260022CA.Author1","COCT_MT260030CA.Author1","PORX_MT060010CA.Author6","PORX_MT060040CA.Author1","PORX_MT060090CA.Author6","PORX_MT060160CA.Author1","PORX_MT060210CA.Author7","PORX_MT060340CA.Author1","REPC_MT000009CA.Author3"})
public class ChangedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TS time = new TSImpl();
    private ChangedBy changedBy;
    private HealthcareWorkerBean assignedEntity;
    private ActingPerson actingPerson;


    /**
     * <p>Change Timestamp</p>
     * 
     * <p><p>The date and time at which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit purposes.</p></p>
     * 
     * <p>Change Timestamp</p>
     * 
     * <p><p>The date on which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>The 
     * attribute is marked as &quot;mandatory&quot; because the 
     * time of change must be known.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>The 
     * attribute is marked as &quot;mandatory&quot; because the 
     * time of change must be known.</p></p>
     * 
     * <p>Change Datetime</p>
     * 
     * <p><p>The date on which the change was made. Note that this 
     * may be earlier or occassionally later than when the change 
     * is actually effective.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the event. Also used 
     * for sorting and audit purposes. Time of change is always 
     * known and thus the attribute is mandatory.</p></p>
     * 
     * <p>Change Timestamp</p>
     * 
     * <p><p>The date and time at which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>The 
     * attribute is marked as &quot;mandatory&quot; because the 
     * time of change must be known.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>The 
     * attribute is marked as &quot;mandatory&quot; because the 
     * time of change must be known.</p></p>
     * 
     * <p>Change Timestamp</p>
     * 
     * <p><p>The date and time at which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the other medication. 
     * Also used for sorting and audit purposes.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the time of change must 
     * be known.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the other medication. 
     * Also used for sorting and audit purposes.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the time of change must 
     * be known.</p></p>
     * 
     * <p>Change Timestamp</p>
     * 
     * <p><p>The date on which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>This 
     * attribute is marked as &quot;mandatory&quot; as the time the 
     * comment was posted will always be known.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>This 
     * attribute is marked as &quot;mandatory&quot; as the time the 
     * comment was posted will always be known.</p></p>
     * 
     * <p>Change Timestamp</p>
     * 
     * <p><p>The date and time at which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit 
     * purposes.</p><p>The attribute is mandatory as the time of 
     * change is known.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit 
     * purposes.</p><p>The attribute is mandatory as the time of 
     * change is known.</p></p>
     * 
     * <p>Change Time</p>
     * 
     * <p><p>The date on which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the allergy. Also 
     * used for sorting and audit purposes. Time of change is 
     * always known and thus the attribute is mandatory.</p></p>
     * 
     * <p>B:Management Date</p>
     * 
     * <p><p>The date and time on which the provider used this 
     * management for the issue in the past.</p></p>
     * 
     * <p><p>ManagedContraindication.CreationDate</p></p>
     * 
     * <p><p>Part of the audit record but not always available and 
     * therefore only marked as 'populated'.</p></p>
     * 
     * <p>B:Management Date</p>
     * 
     * <p><p>The date and time on which the provider managed the 
     * issue.</p></p>
     * 
     * <p><p>ManagedContraindication.CreationDate</p></p>
     * 
     * <p><p>Part of the audit record, but not always available and 
     * therefore 'populated'.</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    @Hl7XmlMapping({"changedBy"})
    public ChangedBy getChangedBy() {
        return this.changedBy;
    }
    public void setChangedBy(ChangedBy changedBy) {
        this.changedBy = changedBy;
    }


    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }


    @Hl7XmlMapping({"actingPerson"})
    public ActingPerson getActingPerson() {
        return this.actingPerson;
    }
    public void setActingPerson(ActingPerson actingPerson) {
        this.actingPerson = actingPerson;
    }

}
