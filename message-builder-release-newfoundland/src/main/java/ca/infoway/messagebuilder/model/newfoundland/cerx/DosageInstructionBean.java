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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActSite;
import ca.infoway.messagebuilder.domainvalue.AdministrableDrugForm;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT980040CA.DosageInstruction" })
public class DosageInstructionBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 4662965520747309657L;

    private final CD moodCode = new CDImpl();

    private final CD code = new CDImpl();

    private final ST text = new STImpl();

    private final IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private final CD routeCode = new CDImpl();

    private final SET<CD, Code> approachSiteCode = new SETImpl<CD, Code>(CDImpl.class);

    private final SET<RTO<PhysicalQuantity, PhysicalQuantity>, Ratio<PhysicalQuantity, PhysicalQuantity>> maxDoseQuantity = 
    	new SETImpl<RTO<PhysicalQuantity, PhysicalQuantity>, Ratio<PhysicalQuantity, PhysicalQuantity>>(RTOImpl.class);

    private final CD administrationUnitCode = new CDImpl();

    private MedicationChoice medication;

    private SupplementalInstructionBean supplementalInstructionBean;

    private final List<DosageLineWrapperBean> dosageLineWrappers = Collections.synchronizedList(new ArrayList<DosageLineWrapperBean>());

    @Hl7XmlMapping("moodCode")
    public x_ActMoodDefEvnRqo getMoodCode() {
        return (x_ActMoodDefEvnRqo) this.moodCode.getValue();
    }

    public void setMoodCode(x_ActMoodDefEvnRqo moodCode) {
        this.moodCode.setValue(moodCode);
    }

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("text")
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("routeCode")
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }

    @Hl7XmlMapping("approachSiteCode")
    public Set<ActSite> getApproachSiteCode() {
        return approachSiteCode.rawSet(ActSite.class);
    }

    @Hl7XmlMapping("maxDoseQuantity")
    public Set<Ratio<PhysicalQuantity, PhysicalQuantity>> getMaxDoseQuantity() {
        return maxDoseQuantity.rawSet();
    }

    @Hl7XmlMapping("administrationUnitCode")
    public AdministrableDrugForm getAdministrationUnitCode() {
        return (AdministrableDrugForm) this.administrationUnitCode.getValue();
    }

    public void setAdministrationUnitCode(AdministrableDrugForm administrationUnitCode) {
        this.administrationUnitCode.setValue(administrationUnitCode);
    }

    @Hl7XmlMapping("component1/supplementalInstruction")
    public SupplementalInstructionBean getSupplementalInstructionBean() {
        return supplementalInstructionBean;
    }

    public void setSupplementalInstructionBean(SupplementalInstructionBean supplementalInstructionBean) {
        this.supplementalInstructionBean = supplementalInstructionBean;
    }

    @Hl7XmlMapping("component2")
    public List<DosageLineWrapperBean> getDosageLineWrappers() {
        return dosageLineWrappers;
    }

    @Hl7XmlMapping("consumable/medication1")
    public MedicationChoice getMedication() {
        return medication;
    }

    public void setMedication(MedicationChoice medication) {
        this.medication = medication;
    }
}
