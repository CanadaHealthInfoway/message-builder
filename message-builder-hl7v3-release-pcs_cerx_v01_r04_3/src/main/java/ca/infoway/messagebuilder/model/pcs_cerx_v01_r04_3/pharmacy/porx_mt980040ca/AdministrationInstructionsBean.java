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



@Hl7PartTypeMapping({"PORX_MT980040CA.DosageInstruction"})
@Hl7RootType
public class AdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
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
     * <p>Dosage Usage Context</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getMoodCode() {
        return (x_ActMoodDefEvnRqo) this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodDefEvnRqo moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Dosage Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>C:Rendered Dosage Instruction</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>A:Administration Period</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>A:Route Code</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>B:Administration Sites</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public Set<HumanSubstanceAdministrationSite> getApproachSiteCode() {
        return this.approachSiteCode.rawSet(HumanSubstanceAdministrationSite.class);
    }


    /**
     * <p>D:Maximum Doses per Period</p>
     */
    @Hl7XmlMapping({"maxDoseQuantity"})
    public Set<Ratio<PhysicalQuantity, PhysicalQuantity>> getMaxDoseQuantity() {
        return this.maxDoseQuantity.rawSet();
    }


    /**
     * <p>Dosage Unit</p>
     */
    @Hl7XmlMapping({"administrationUnitCode"})
    public AdministrableDrugForm getAdministrationUnitCode() {
        return (AdministrableDrugForm) this.administrationUnitCode.getValue();
    }
    public void setAdministrationUnitCode(AdministrableDrugForm administrationUnitCode) {
        this.administrationUnitCode.setValue(administrationUnitCode);
    }


    @Hl7XmlMapping({"consumable/medication1"})
    public Medication getConsumableMedication1() {
        return this.consumableMedication1;
    }
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


    @Hl7XmlMapping({"component1/supplementalInstruction"})
    public AdditionalSIGInstructionBean getComponent1SupplementalInstruction() {
        return this.component1SupplementalInstruction;
    }
    public void setComponent1SupplementalInstruction(AdditionalSIGInstructionBean component1SupplementalInstruction) {
        this.component1SupplementalInstruction = component1SupplementalInstruction;
    }


    @Hl7XmlMapping({"component2"})
    public List<ConsistsOfBean> getComponent2() {
        return this.component2;
    }

}
