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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt040020ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>Business Name: Other Medication</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p>
 * 
 * <p>The medication record being updated.</p>
 * 
 * <p>While SNOMED codes may pre-coordinate the drug code, the 
 * drug must not be modified. However route information for a 
 * drug may be updated.</p>
 */
@Hl7PartTypeMapping({"PORX_MT040020CA.OtherMedication"})
@Hl7RootType
public class OtherMedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV routeCode = new CVImpl();


    /**
     * <p>Business Name: A:Other Medication Id</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Uniquely identifies the record to be updated and is 
     * therefore mandatory.</p>
     * 
     * <p>Identifier of the Other Medication record that needs to 
     * be updated.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Other Medication Id</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Uniquely identifies the record to be updated and is 
     * therefore mandatory.</p>
     * 
     * <p>Identifier of the Other Medication record that needs to 
     * be updated.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Must be 'DRUG' unless using SNOMED</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Indicates that the record is a drug administration rather 
     * than an immunization or other type of administration. For 
     * SNOMED, may also include route, drug and other 
     * information.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Other Medication Type</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Must be 'DRUG' unless using SNOMED</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Indicates that the record is a drug administration rather 
     * than an immunization or other type of administration. For 
     * SNOMED, may also include route, drug and other 
     * information.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: B:Medication Status</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the new state of the medication and is 
     * therefore mandatory.</p><p>Note ------ The provider might 
     * know that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Indicates whether the medication is still considered 
     * active.</p><p>Valid status can only be 'ACTIVE' or 
     * 'COMPLETED'.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: B:Medication Status</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the new state of the medication and is 
     * therefore mandatory.</p><p>Note ------ The provider might 
     * know that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>Indicates whether the medication is still considered 
     * active.</p><p>Valid status can only be 'ACTIVE' or 
     * 'COMPLETED'.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: C:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT040020CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows the drug active period information to be 
     * changed.</p>
     * 
     * <p>The new period in which the active medication is deemed 
     * to be active.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Drug Active Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT040020CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows the drug active period information to be 
     * changed.</p>
     * 
     * <p>The new period in which the active medication is deemed 
     * to be active.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Other Medication Masking Indicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT040020CA.OtherMedication.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Taboo allows the provider to request restricted access to 
     * patient or their care giver.</p><p>Constraint: Can't have 
     * both normal and one of the other codes simultaneously.</p>
     * 
     * <p>Taboo allows the provider to request restricted access to 
     * patient or their care giver.</p><p>Constraint: Can't have 
     * both normal and one of the other codes simultaneously.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Business Name: D:Route</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * other medication.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: D:Route</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * other medication.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }

}
