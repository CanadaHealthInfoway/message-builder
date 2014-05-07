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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pharmacy.merged;

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
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.SubstanceAdministrationType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: OtherMedication</p>
 * 
 * <p>PORX_MT040020CA.OtherMedication: Other Medication</p>
 * 
 * <p>The medication record being updated.</p><p>Because of the 
 * nature of the source of information for some instances of 
 * OtherMedication, the exact Drug Active Period may not be 
 * known. For this reason the attribute is Populated.</p>
 * 
 * <p>While SNOMED codes may pre-coordinate the drug code, the 
 * drug must not be modified. However route information for a 
 * drug may be updated.</p>
 * 
 * <p>A record of an 'other medication'. Other medications 
 * include any drug product deemed relevant to the patient's 
 * drug profile, but which was not specifically ordered by a 
 * prescriber. Examples include over-the counter medications 
 * that were not specifically ordered, herbal remedies, and 
 * recreational drugs.</p>
 * 
 * <p>PORX_MT040010CA.OtherMedication: Other Medication</p>
 * 
 * <p>Necessary component of a person's overall medication 
 * profile. Allows DUR checking against a more complete drug 
 * profile.</p>
 * 
 * <p>A record of a medication the patient is believed to be 
 * taking, but for which an electronic order does not exist. 
 * 'Other medications' include any drug product deemed relevant 
 * to the patient's drug profile, but which was not 
 * specifically ordered by a prescriber in a DIS-enabled 
 * jurisdiction. Examples include over-the counter medications 
 * that were not specifically ordered, herbal remedies, and 
 * recreational drugs. Prescription drugs that the patient may 
 * be taking but were not prescribed on the EHR (e.g. 
 * institutionally administered or out-of-jurisdiction 
 * prescriptions) will also be recorded here.</p>
 */
@Hl7PartTypeMapping({"PORX_MT040010CA.OtherMedication","PORX_MT040020CA.OtherMedication"})
@Hl7RootType
public class OtherMedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20140507L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV routeCode = new CVImpl();
    private DrugProductBean consumableMedication;
    private List<AdministrationInstructionsBean> componentDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private IncludesBean subjectOf;


    /**
     * <p>Business Name: OtherMedicationId</p>
     * 
     * <p>Un-merged Business Name: OtherMedicationId</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Uniquely identifies the record to be updated and is 
     * therefore mandatory.</p>
     * 
     * <p>Identifier of the Other Medication record that needs to 
     * be updated.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: OtherMedicationType</p>
     * 
     * <p>Un-merged Business Name: OtherMedicationType</p>
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
     * 
     * <p>Un-merged Business Name: OtherMedicationType</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.code</p>
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
    public SubstanceAdministrationType getCode() {
        return (SubstanceAdministrationType) this.code.getValue();
    }

    /**
     * <p>Business Name: OtherMedicationType</p>
     * 
     * <p>Un-merged Business Name: OtherMedicationType</p>
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
     * 
     * <p>Un-merged Business Name: OtherMedicationType</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.code</p>
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
    public void setCode(SubstanceAdministrationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: MedicationStatus</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Status can only be '''ACTIVE''' or '''COMPLETED'''</p>
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
     * 
     * <p>Un-merged Business Name: OtherMedicationStatus</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Status can only be 'ACTIVE' or 'COMPLETED'</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against an other medication record. This is a mandatory 
     * field because every recorded 'other medication' needs to be 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>This denotes a state in the lifecycle of the other 
     * medication. Valid statuses are: 'ACTIVE' and 'COMPLETED' 
     * only.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: MedicationStatus</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Status can only be '''ACTIVE''' or '''COMPLETED'''</p>
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
     * 
     * <p>Un-merged Business Name: OtherMedicationStatus</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Status can only be 'ACTIVE' or 'COMPLETED'</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against an other medication record. This is a mandatory 
     * field because every recorded 'other medication' needs to be 
     * in some state.</p><p>Note ------ The provider might know 
     * that the patient is not taking the medication but not 
     * necessarily when the patient stopped it. Thus the status of 
     * the medication could be set to 'COMPLETED' by the provider 
     * without necessarily setting an End Date on the medication 
     * record.</p>
     * 
     * <p>This denotes a state in the lifecycle of the other 
     * medication. Valid statuses are: 'ACTIVE' and 'COMPLETED' 
     * only.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: DrugActivePeriod</p>
     * 
     * <p>Un-merged Business Name: DrugActivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT040020CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows the drug active period information to be 
     * changed.</p>
     * 
     * <p>The new period in which the active medication is deemed 
     * to be active.</p>
     * 
     * <p>Un-merged Business Name: DrugActivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT040010CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     * 
     * <p>Either the start or end or both can be null if they are 
     * not known.</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the medication.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: DrugActivePeriod</p>
     * 
     * <p>Un-merged Business Name: DrugActivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT040020CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows the drug active period information to be 
     * changed.</p>
     * 
     * <p>The new period in which the active medication is deemed 
     * to be active.</p>
     * 
     * <p>Un-merged Business Name: DrugActivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT040010CA.OtherMedication.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to help determine whether the medication is 
     * currently active. Because this information won't always be 
     * available, the attribute is marked as 'populated'.</p>
     * 
     * <p>Either the start or end or both can be null if they are 
     * not known.</p>
     * 
     * <p>Indicates the time-period in which the patient has been 
     * taking or is expected to be taking the medication.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: OtherMedicationMaskingIndicators</p>
     * 
     * <p>Un-merged Business Name: OtherMedicationMaskingIndicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT040020CA.OtherMedication.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>Taboo allows the provider to 
     * request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can'''t have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their medication records.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Un-merged Business Name: OtherMedicationMaskingIndicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT040010CA.OtherMedication.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>Taboo 
     * allows the provider to request restricted access to patient 
     * or their care giver.</p><p>Constraint: Can'''t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Un-merged Business Name: Route</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>routeCode must not be used when code is SNOMED and is 
     * mandatory otherwise</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * other medication.</p>
     * 
     * <p>Un-merged Business Name: RouteOfAdministration</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>routeCode must not be used when code is SNOMED and is 
     * mandatory otherwise</p>
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
     * <p>Un-merged Business Name: Route</p>
     * 
     * <p>Relationship: PORX_MT040020CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>routeCode must not be used when code is SNOMED and is 
     * mandatory otherwise</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Because 
     * this information is pre-coordinated into 'code' for SNOMED, 
     * it is marked as optional.</p>
     * 
     * <p>This is the means by which the patient is taking the 
     * other medication.</p>
     * 
     * <p>Un-merged Business Name: RouteOfAdministration</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>routeCode must not be used when code is SNOMED and is 
     * mandatory otherwise</p>
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


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT040010CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT040010CA.Consumable2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT040010CA.Component.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponentDosageInstruction() {
        return this.componentDosageInstruction;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT040010CA.OtherMedication.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }

}
