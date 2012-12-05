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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt130001ca;

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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import java.util.Date;



/**
 * <p>Business Name: Version Information</p>
 * 
 * <p>Provides a record changes, providing deeper clinical 
 * understanding, particularly of past clinical decisions.</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the record, including why the changes were made, who made 
 * them and when.</p>
 */
@Hl7PartTypeMapping({"COCT_MT130001CA.ControlActEvent"})
@Hl7RootType
public class VersionInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private TS authorTime = new TSImpl();
    private ActingPerson authorActingPerson;


    /**
     * <p>Business Name: B:Change Identifier</p>
     * 
     * <p>Relationship: COCT_MT130001CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows referencing (and potentially undoing) a specific 
     * change. Every status change has an identifier, thus this 
     * attribute is mandatory.</p>
     * 
     * <p>A unique identifier for this particular change.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Change Identifier</p>
     * 
     * <p>Relationship: COCT_MT130001CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows referencing (and potentially undoing) a specific 
     * change. Every status change has an identifier, thus this 
     * attribute is mandatory.</p>
     * 
     * <p>A unique identifier for this particular change.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Change Type</p>
     * 
     * <p>Relationship: COCT_MT130001CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred.</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Change Type</p>
     * 
     * <p>Relationship: COCT_MT130001CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred.</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Change Effective Date and End Date</p>
     * 
     * <p>Relationship: 
     * COCT_MT130001CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time. The date 
     * on which a change is effective should always be known and 
     * thus is mandatory. The end date may be left unspecified if 
     * there isn't a specific targetted end date (e.g. with a 
     * suspend including a planned release date).</p>
     * 
     * <p>The date on which the various changes of an event become 
     * valid and applicable and potentially when the change is 
     * supposed to cease.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Change Effective Date and End Date</p>
     * 
     * <p>Relationship: 
     * COCT_MT130001CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time. The date 
     * on which a change is effective should always be known and 
     * thus is mandatory. The end date may be left unspecified if 
     * there isn't a specific targetted end date (e.g. with a 
     * suspend including a planned release date).</p>
     * 
     * <p>The date on which the various changes of an event become 
     * valid and applicable and potentially when the change is 
     * supposed to cease.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Change Reason</p>
     * 
     * <p>Relationship: COCT_MT130001CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the record was modified.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: D:Change Reason</p>
     * 
     * <p>Relationship: COCT_MT130001CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the record was modified.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Business Name: Change Datetime</p>
     * 
     * <p>Relationship: COCT_MT130001CA.Author3.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the event. Also used 
     * for sorting and audit purposes. Time of change is always 
     * known and thus the attribute is mandatory.</p>
     * 
     * <p>The date on which the change was made. Note that this may 
     * be earlier or occassionally later than when the change is 
     * actually effective.</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }

    /**
     * <p>Business Name: Change Datetime</p>
     * 
     * <p>Relationship: COCT_MT130001CA.Author3.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the event. Also used 
     * for sorting and audit purposes. Time of change is always 
     * known and thus the attribute is mandatory.</p>
     * 
     * <p>The date on which the change was made. Note that this may 
     * be earlier or occassionally later than when the change is 
     * actually effective.</p>
     */
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    /**
     * <p>Relationship: COCT_MT130001CA.Author3.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/actingPerson"})
    public ActingPerson getAuthorActingPerson() {
        return this.authorActingPerson;
    }

    /**
     * <p>Relationship: COCT_MT130001CA.Author3.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorActingPerson(ActingPerson authorActingPerson) {
        this.authorActingPerson = authorActingPerson;
    }

    public HealthcareWorkerBean getAuthorActingPersonAsAssignedEntity1() {
        return this.authorActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.authorActingPerson : null;
    }
    public boolean hasAuthorActingPersonAsAssignedEntity1() {
        return (this.authorActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getAuthorActingPersonAsAssignedEntity2() {
        return this.authorActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.authorActingPerson : null;
    }
    public boolean hasAuthorActingPersonAsAssignedEntity2() {
        return (this.authorActingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getAuthorActingPersonAsPersonalRelationship() {
        return this.authorActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.authorActingPerson : null;
    }
    public boolean hasAuthorActingPersonAsPersonalRelationship() {
        return (this.authorActingPerson instanceof RelatedPersonBean);
    }

}
