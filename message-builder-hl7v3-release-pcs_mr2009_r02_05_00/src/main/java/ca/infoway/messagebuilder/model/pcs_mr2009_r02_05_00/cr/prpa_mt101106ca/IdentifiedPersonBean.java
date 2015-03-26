/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.cr.prpa_mt101106ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.cr.merged.ConfidenceValueBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.cr.merged.OtherIDsNonHealthcareIdentifiersBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Identified Person</p>
 * 
 * <p>Provides the message entry point required to add a person 
 * to the Client Registry</p>
 * 
 * <p>The IdentifiedEntity class is the entry point to the 
 * R-MIM and contains one or more identifiers (for example an 
 * &quot;internal&quot; id used only by computer systems and an 
 * &quot;external&quot; id for display to users) for the Person 
 * in the Client Registry. The statusCode is set to 
 * &quot;active&quot;. The beginning of the effectiveTime is 
 * when the record was added to the registry.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101106CA.IdentifiedEntity"})
@Hl7RootType
public class IdentifiedPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private List<OtherIDsNonHealthcareIdentifiersBean> identifiedPersonAsOtherIDs = new ArrayList<OtherIDsNonHealthcareIdentifiersBean>();
    private ConfidenceValueBean subjectOfObservationEvent;


    /**
     * <p>Business Name: Client Healthcare Identification Number</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-1000)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client.</p>
     * 
     * <p>At least 1 client identifier must be present in the 
     * message</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Client Status Code</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdentifiedEntity.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the status of the Client role (e.g. Active)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getStatusCode() {
        return (RoleStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Client Status Code</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdentifiedEntity.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Indicates the status of the Client role (e.g. Active)</p>
     */
    public void setStatusCode(RoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Client Effective Time</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101106CA.IdentifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An interval of time specifying the period during which 
     * this record in a client registry is in effect, if such time 
     * limit is applicable and known</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Client Effective Time</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101106CA.IdentifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * client</p>
     * 
     * <p>An interval of time specifying the period during which 
     * this record in a client registry is in effect, if such time 
     * limit is applicable and known</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Client Masked Information</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101106CA.IdentifiedEntity.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the business requirement to 
     * provide restricted access where required</p>
     * 
     * <p>Data in the EHR may at some point (and in some 
     * jurisdictions) be accessed directly by patients. Some health 
     * information may be deemed inappropriate for direct access by 
     * patients and requires interpretation by a clinician (e.g. 
     * prescription of placebos, analysis of certain psychiatric 
     * conditions, etc) Even where direct access by patient is not 
     * provided, there may need to be guidance to other providers 
     * viewing the record where care should be used in disclosing 
     * information to the patient. Non-clinical data (e.g. 
     * demographics) may need to be flagged as not for disclosure 
     * to patient and or next of kin. There may be professional 
     * policy and or legislative guidelines about when/if records 
     * may be flagged as not for direct disclosure.</p>
     * 
     * <p>A code that controls the disclosure of information about 
     * this patient encounter.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: Client Masked Information</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101106CA.IdentifiedEntity.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the business requirement to 
     * provide restricted access where required</p>
     * 
     * <p>Data in the EHR may at some point (and in some 
     * jurisdictions) be accessed directly by patients. Some health 
     * information may be deemed inappropriate for direct access by 
     * patients and requires interpretation by a clinician (e.g. 
     * prescription of placebos, analysis of certain psychiatric 
     * conditions, etc) Even where direct access by patient is not 
     * provided, there may need to be guidance to other providers 
     * viewing the record where care should be used in disclosing 
     * information to the patient. Non-clinical data (e.g. 
     * demographics) may need to be flagged as not for disclosure 
     * to patient and or next of kin. There may be professional 
     * policy and or legislative guidelines about when/if records 
     * may be flagged as not for direct disclosure.</p>
     * 
     * <p>A code that controls the disclosure of information about 
     * this patient encounter.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: PRPA_MT101106CA.Person.asOtherIDs</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/asOtherIDs"})
    public List<OtherIDsNonHealthcareIdentifiersBean> getIdentifiedPersonAsOtherIDs() {
        return this.identifiedPersonAsOtherIDs;
    }


    /**
     * <p>Relationship: PRPA_MT101106CA.Subject.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/observationEvent"})
    public ConfidenceValueBean getSubjectOfObservationEvent() {
        return this.subjectOfObservationEvent;
    }

    /**
     * <p>Relationship: PRPA_MT101106CA.Subject.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfObservationEvent(ConfidenceValueBean subjectOfObservationEvent) {
        this.subjectOfObservationEvent = subjectOfObservationEvent;
    }

}
