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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt980040ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.AdministrableDrugForm;
import ca.infoway.messagebuilder.domainvalue.HumanSubstanceAdministrationSite;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220200ca.DrugProductBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Administration Instructions</p>
 * 
 * <p>routeCode is mandatory and apporachSiteCode is required 
 * if not using SNOMED</p>
 * 
 * <p>- moodCode must be DEFN for drug definitions (such as 
 * monographs) - moodCode must be RQO for orders; - moodCode 
 * must be EVN for dispenses and recording of other 
 * medications</p>
 * 
 * <p>Allows providers to communicate intentions and to 
 * cross-check intended and actual methods of 
 * administration.</p>
 * 
 * <p>This comprises all specifications necessary for the 
 * dispensed product to be administered to/by the patient in a 
 * manner as intended by the prescriber.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980040CA.DosageInstruction"})
@Hl7RootType
public class AdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CS moodCode = new CSImpl();
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV routeCode = new CVImpl();
    private SET<CV, Code> approachSiteCode = new SETImpl<CV, Code>(CVImpl.class);
    private SET<RTO<PhysicalQuantity, PhysicalQuantity>, Ratio<PhysicalQuantity, PhysicalQuantity>> maxDoseQuantity = new SETImpl<RTO<PhysicalQuantity, PhysicalQuantity>, Ratio<PhysicalQuantity, PhysicalQuantity>>(RTOImpl.class);
    private CV administrationUnitCode = new CVImpl();
    private Medication consumableMedication1;
    private AdditionalSIGInstructionBean component1SupplementalInstruction;
    private List<ConsistsOfBean> component2 = new ArrayList<ConsistsOfBean>();


    /**
     * <p>Business Name: Dosage Usage Context</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageInstruction.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Puts the class in context, and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getMoodCode() {
        return (x_ActMoodDefEvnRqo) this.moodCode.getValue();
    }

    /**
     * <p>Business Name: Dosage Usage Context</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageInstruction.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Puts the class in context, and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates the context of the 
     * administration.</p><p>moodCode = RQO, for administration 
     * instruction on orders</p><p>moodCode = EVN, for 
     * administration instruction on dispenses</p><p>moodCode = 
     * DEF, for administration instruction on medication definition 
     * documents/references (typically, monographs).</p>
     */
    public void setMoodCode(x_ActMoodDefEvnRqo moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Business Name: Dosage Type</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageInstruction.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between types of dosage administration and 
     * is therefore mandatory. Datatype is CD to allow for SNOMED 
     * codes.</p>
     * 
     * <p>For SNOMED this will pre-coordinate route, body site and 
     * potentially drug. For non-SNOMED, this will be a fixed value 
     * of DRUG.</p>
     * 
     * <p>Distinguishes types of dosage.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Dosage Type</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageInstruction.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between types of dosage administration and 
     * is therefore mandatory. Datatype is CD to allow for SNOMED 
     * codes.</p>
     * 
     * <p>For SNOMED this will pre-coordinate route, body site and 
     * potentially drug. For non-SNOMED, this will be a fixed value 
     * of DRUG.</p>
     * 
     * <p>Distinguishes types of dosage.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Rendered Dosage Instruction</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageInstruction.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses.</p><p>This 
     * is mandatory as dosage instructions must always be available 
     * in rendered form.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: C:Rendered Dosage Instruction</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageInstruction.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses.</p><p>This 
     * is mandatory as dosage instructions must always be available 
     * in rendered form.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: A:Administration Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT980040CA.DosageInstruction.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.Admin istrationStartDate (Low)</p>
     * 
     * <p>Prescription.Admin istrationStopDate (High)</p>
     * 
     * <p>DispensedItem.expectedStartDate</p>
     * 
     * <p>Indicates the overall time boundaries in which the person 
     * is expected to take the drug. Denotes the reference point 
     * for calculating expected exhaustion date and quantity on 
     * hand.</p><p>Facilitates compliance checking.</p><p>Note: TID 
     * may be interpreted differently based on situation (e.g. 
     * based on schedules of a facility).</p>
     * 
     * <p>Frequently only the duration (width) component is 
     * specified. E.g. 100mg tid for 10 days. In that case, the 
     * start date is presumed to be the date the prescription was 
     * written</p>
     * 
     * <p>The time period (begin and end dates) within which the 
     * dispensed medication is to be completely administered to/by 
     * the patient. May differ from date prescription was 
     * issued.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: A:Administration Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT980040CA.DosageInstruction.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.Admin istrationStartDate (Low)</p>
     * 
     * <p>Prescription.Admin istrationStopDate (High)</p>
     * 
     * <p>DispensedItem.expectedStartDate</p>
     * 
     * <p>Indicates the overall time boundaries in which the person 
     * is expected to take the drug. Denotes the reference point 
     * for calculating expected exhaustion date and quantity on 
     * hand.</p><p>Facilitates compliance checking.</p><p>Note: TID 
     * may be interpreted differently based on situation (e.g. 
     * based on schedules of a facility).</p>
     * 
     * <p>Frequently only the duration (width) component is 
     * specified. E.g. 100mg tid for 10 days. In that case, the 
     * start date is presumed to be the date the prescription was 
     * written</p>
     * 
     * <p>The time period (begin and end dates) within which the 
     * dispensed medication is to be completely administered to/by 
     * the patient. May differ from date prescription was 
     * issued.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: A:Route Code</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageInstruction.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Prescription.route</p>
     * 
     * <p>ZDP.14.2</p>
     * 
     * <p>Compound.452-E8</p>
     * 
     * <p>RXR.1</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Route is 
     * an optional because it is pre-coordinated with 
     * SubstanceAdministration.code when using SNOMED.</p>
     * 
     * <p>This is the means by which the dispensed drug is to be 
     * administered to the patient.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: A:Route Code</p>
     * 
     * <p>Relationship: PORX_MT980040CA.DosageInstruction.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Prescription.route</p>
     * 
     * <p>ZDP.14.2</p>
     * 
     * <p>Compound.452-E8</p>
     * 
     * <p>RXR.1</p>
     * 
     * <p>Ensures consistency in description of routes. Provides 
     * potential for cross-checking dosage form and route. Route is 
     * an optional because it is pre-coordinated with 
     * SubstanceAdministration.code when using SNOMED.</p>
     * 
     * <p>This is the means by which the dispensed drug is to be 
     * administered to the patient.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Business Name: B:Administration Sites</p>
     * 
     * <p>Relationship: 
     * PORX_MT980040CA.DosageInstruction.approachSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-5)</p>
     * 
     * <p>Allows specificity when a drug can potentially be applied 
     * to different parts of the patien's body. Multiple 
     * repetitions are used when the product should be administered 
     * to multiple parts of the body. CWE is used because using a 
     * code system is not essential for understanding or analyzing 
     * the prescription. The attribute is optional because it can 
     * be pre-coordinated with SubstanceAdministration.code when 
     * using SNOMED.</p>
     * 
     * <p>A value denoting the body area where the medicine should 
     * be administered. E.g. 'Right Elbow', 'Left Ear'. When 
     * multiples sites are specified they should be treated as 
     * 'AND'.</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public Set<HumanSubstanceAdministrationSite> getApproachSiteCode() {
        return this.approachSiteCode.rawSet(HumanSubstanceAdministrationSite.class);
    }


    /**
     * <p>Business Name: D:Maximum Doses per Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT980040CA.DosageInstruction.maxDoseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>ZPB3.5(denominator=1D)</p>
     * 
     * <p>Sets an upper boundary for the quantity of the drug to be 
     * administered over a specified period of time. Particularly 
     * useful for PRN medications.</p>
     * 
     * <p>This field can only capture maximum doses based on 
     * explicit time periods. Dosage maximums based on other 
     * constraints such as patient lifetime, menstrual cycles must 
     * be recorded using additional dosage instruction 
     * comments.</p>
     * 
     * <p>The maximum amount of the dispensed medication to be 
     * administered to the patient in a specified period of time. 
     * Examples include: per hour, 24-hr period (doses per day), 7 
     * day period (doses per week), yearly.</p>
     */
    @Hl7XmlMapping({"maxDoseQuantity"})
    public Set<Ratio<PhysicalQuantity, PhysicalQuantity>> getMaxDoseQuantity() {
        return this.maxDoseQuantity.rawSet();
    }


    /**
     * <p>Business Name: Dosage Unit</p>
     * 
     * <p>Relationship: 
     * PORX_MT980040CA.DosageInstruction.administrationUnitCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed when the dosage unit is not expressed as part of 
     * the dose quantity (mg, mL) or implicit as part of the drug 
     * form (capsules, tablets). Examples are Puffs, Actuations, 
     * etc.</p>
     * 
     * <p>Identifies how the drug is measured for 
     * administration.</p><p>Specified when not implicit from the 
     * drug form (e.g. puff, inhalation, drops, etc.).</p>
     */
    @Hl7XmlMapping({"administrationUnitCode"})
    public AdministrableDrugForm getAdministrationUnitCode() {
        return (AdministrableDrugForm) this.administrationUnitCode.getValue();
    }

    /**
     * <p>Business Name: Dosage Unit</p>
     * 
     * <p>Relationship: 
     * PORX_MT980040CA.DosageInstruction.administrationUnitCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed when the dosage unit is not expressed as part of 
     * the dose quantity (mg, mL) or implicit as part of the drug 
     * form (capsules, tablets). Examples are Puffs, Actuations, 
     * etc.</p>
     * 
     * <p>Identifies how the drug is measured for 
     * administration.</p><p>Specified when not implicit from the 
     * drug form (e.g. puff, inhalation, drops, etc.).</p>
     */
    public void setAdministrationUnitCode(AdministrableDrugForm administrationUnitCode) {
        this.administrationUnitCode.setValue(administrationUnitCode);
    }


    /**
     * <p>Relationship: PORX_MT980040CA.Consumable1.medication1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"consumable/medication1"})
    public Medication getConsumableMedication1() {
        return this.consumableMedication1;
    }

    /**
     * <p>Relationship: PORX_MT980040CA.Consumable1.medication1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setConsumableMedication1(Medication consumableMedication1) {
        this.consumableMedication1 = consumableMedication1;
    }

    public ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220100ca.DrugProductBean getConsumableMedication1AsMedication1() {
        return this.consumableMedication1 instanceof ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220100ca.DrugProductBean ? (ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220100ca.DrugProductBean) this.consumableMedication1 : null;
    }
    public boolean hasConsumableMedication1AsMedication1() {
        return (this.consumableMedication1 instanceof ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220100ca.DrugProductBean);
    }

    public ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean getConsumableMedication1AsMedication2() {
        return this.consumableMedication1 instanceof ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean ? (ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean) this.consumableMedication1 : null;
    }
    public boolean hasConsumableMedication1AsMedication2() {
        return (this.consumableMedication1 instanceof ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean);
    }

    public DrugProductBean getConsumableMedication1AsMedication3() {
        return this.consumableMedication1 instanceof DrugProductBean ? (DrugProductBean) this.consumableMedication1 : null;
    }
    public boolean hasConsumableMedication1AsMedication3() {
        return (this.consumableMedication1 instanceof DrugProductBean);
    }

    public ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220210ca.DrugProductBean getConsumableMedication1AsMedication4() {
        return this.consumableMedication1 instanceof ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220210ca.DrugProductBean ? (ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220210ca.DrugProductBean) this.consumableMedication1 : null;
    }
    public boolean hasConsumableMedication1AsMedication4() {
        return (this.consumableMedication1 instanceof ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220210ca.DrugProductBean);
    }


    /**
     * <p>Relationship: 
     * PORX_MT980040CA.Component.supplementalInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/supplementalInstruction"})
    public AdditionalSIGInstructionBean getComponent1SupplementalInstruction() {
        return this.component1SupplementalInstruction;
    }

    /**
     * <p>Relationship: 
     * PORX_MT980040CA.Component.supplementalInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1SupplementalInstruction(AdditionalSIGInstructionBean component1SupplementalInstruction) {
        this.component1SupplementalInstruction = component1SupplementalInstruction;
    }


    /**
     * <p>Relationship: 
     * PORX_MT980040CA.DosageInstruction.component2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    @Hl7XmlMapping({"component2"})
    public List<ConsistsOfBean> getComponent2() {
        return this.component2;
    }

}
