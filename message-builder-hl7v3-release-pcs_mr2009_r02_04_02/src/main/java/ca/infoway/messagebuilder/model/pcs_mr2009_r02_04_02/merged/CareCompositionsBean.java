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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

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
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt011001ca.Assignees;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: CareCompositions</p>
 * 
 * <p>COCT_MT011001CA.PatientCareProvisionEvent: Care 
 * Compositions</p>
 * 
 * <p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p>
 * 
 * <p>A care composition is a record with two purposes. It 
 * indicates that care of a given type has occurred or is 
 * occurring. It also acts as a collector for the events that 
 * happened during care, including who is responsible for the 
 * care provided.</p>
 */
@Hl7PartTypeMapping({"COCT_MT011001CA.PatientCareProvisionEvent","REPC_MT210001CA.PatientCareProvisionEvent2","REPC_MT210002CA.PatientCareProvisionEvent2","REPC_MT210003CA.PatientCareProvisionEvent2"})
@Hl7RootType
public class CareCompositionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<Assignees> admitterAssignees = new ArrayList<Assignees>();
    private List<Assignees> attenderAssignees = new ArrayList<Assignees>();
    private OccurredAtBean location;


    /**
     * <p>Un-merged Business Name: CareCompositionIdentifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p>
     * 
     * <p>Allows care compositions to be uniquely identified and 
     * referenced.</p>
     * 
     * <p>Unique identifier of an encounter, condition or 
     * care-based collection.</p>
     * 
     * <p>Un-merged Business Name: ReferralReportLink</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.PatientCareProvisionEvent2.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a direct link between the referral and the 
     * resulting report.</p>
     * 
     * <p>This linkage may be established after the document has 
     * been created if the report provides a direct link to the 
     * referral.</p>
     * 
     * <p>A unique identifier for the report resulting from the 
     * action requested by this referral.</p>
     * 
     * <p>Un-merged Business Name: ReferralReportLink</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.PatientCareProvisionEvent2.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ReferralReportLink</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.PatientCareProvisionEvent2.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a direct link between the referral and the 
     * resulting report.</p>
     * 
     * <p>This linkage may be established after the document has 
     * been created if the report provides a direct link to the 
     * referral.</p>
     * 
     * <p>A unique identifier for the report resulting from the 
     * action requested by this referral.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: CareCompositionIdentifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p>
     * 
     * <p>Allows care compositions to be uniquely identified and 
     * referenced.</p>
     * 
     * <p>Unique identifier of an encounter, condition or 
     * care-based collection.</p>
     * 
     * <p>Un-merged Business Name: ReferralReportLink</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.PatientCareProvisionEvent2.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a direct link between the referral and the 
     * resulting report.</p>
     * 
     * <p>This linkage may be established after the document has 
     * been created if the report provides a direct link to the 
     * referral.</p>
     * 
     * <p>A unique identifier for the report resulting from the 
     * action requested by this referral.</p>
     * 
     * <p>Un-merged Business Name: ReferralReportLink</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.PatientCareProvisionEvent2.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ReferralReportLink</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.PatientCareProvisionEvent2.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a direct link between the referral and the 
     * resulting report.</p>
     * 
     * <p>This linkage may be established after the document has 
     * been created if the report provides a direct link to the 
     * referral.</p>
     * 
     * <p>A unique identifier for the report resulting from the 
     * action requested by this referral.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: CareCompositionType</p>
     * 
     * <p>Un-merged Business Name: CareCompositionType</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p>
     * 
     * <p>EPHS: vocab concepts needed for LAB ID, Special 
     * Considerations ID etc.</p>
     * 
     * <p>Allows care compositions to be captured and categorized 
     * at different levels of abstraction, and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the kind of composition represented. Examples 
     * include encounters (&quot;Emergency Encounter&quot;, 
     * &quot;Long Term Care Encounter&quot;, etc), health condition 
     * (episode)-based collections (e.g. &quot;Diabetes&quot;, 
     * &quot;Hypertension&quot;, etc) and general care-based 
     * collections such as &quot;gynecological care&quot;.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareEventType getCode() {
        return (ActCareEventType) this.code.getValue();
    }

    /**
     * <p>Business Name: CareCompositionType</p>
     * 
     * <p>Un-merged Business Name: CareCompositionType</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p>
     * 
     * <p>EPHS: vocab concepts needed for LAB ID, Special 
     * Considerations ID etc.</p>
     * 
     * <p>Allows care compositions to be captured and categorized 
     * at different levels of abstraction, and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the kind of composition represented. Examples 
     * include encounters (&quot;Emergency Encounter&quot;, 
     * &quot;Long Term Care Encounter&quot;, etc), health condition 
     * (episode)-based collections (e.g. &quot;Diabetes&quot;, 
     * &quot;Hypertension&quot;, etc) and general care-based 
     * collections such as &quot;gynecological care&quot;.</p>
     */
    public void setCode(ActCareEventType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: CareCompositionEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: CareCompositionEffectiveDate</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: CareCompositionEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: CareCompositionEffectiveDate</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT011001CA.Admitter.assignees</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"admitter/assignees"})
    public List<Assignees> getAdmitterAssignees() {
        return this.admitterAssignees;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT011001CA.Attender.assignees</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"attender/assignees"})
    public List<Assignees> getAttenderAssignees() {
        return this.attenderAssignees;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }

}
