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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD_R2;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.SXCM_R2;
import ca.infoway.messagebuilder.datatype.TS_R2;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.SXCM_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.TS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.x_DocumentSubstanceMood;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Performer2_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.SpecimenBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"POCD_MT000040.SubstanceAdministration"})
public class SubstanceAdministrationBean extends MessagePartBean implements EntryChoice, EntryRelationshipChoice, Component4Choice {

    private static final long serialVersionUID = 20141104L;
    private CS_R2 moodCode = new CS_R2Impl();
    private BL negationInd = new BLImpl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CD_R2 code = new CD_R2Impl();
    private ED<EncapsulatedDataR2> text = new EDImpl<EncapsulatedDataR2>();
    private CS_R2 statusCode = new CS_R2Impl();
    private LIST<SXCM_R2<Date>, Date> effectiveTime = new LISTImpl<SXCM_R2<Date>, Date>(SXCM_R2Impl.class);
    private CE_R2 priorityCode = new CE_R2Impl();
    private IVL<INT, Interval<Integer>> repeatNumber = new IVLImpl<INT, Interval<Integer>>();
    private CE_R2 routeCode = new CE_R2Impl();
    private LIST<CD_R2, CodedTypeR2<? extends Code>> approachSiteCode = new LISTImpl<CD_R2, CodedTypeR2<? extends Code>>(CD_R2Impl.class);
    private IVL<PQ, Interval<PhysicalQuantity>> doseQuantity = new IVLImpl<PQ, Interval<PhysicalQuantity>>();
    private IVL<PQ, Interval<PhysicalQuantity>> rateQuantity = new IVLImpl<PQ, Interval<PhysicalQuantity>>();
    private RTO<PhysicalQuantity, PhysicalQuantity> maxDoseQuantity = new RTOImpl<PhysicalQuantity, PhysicalQuantity>();
    private CE_R2 administrationUnitCode = new CE_R2Impl();
    private SubjectBean subject;
    private List<SpecimenBean> specimen = new ArrayList<SpecimenBean>();
    private ConsumableBean consumable;
    private List<Performer2_1Bean> performer = new ArrayList<Performer2_1Bean>();
    private List<Author_1Bean> author = new ArrayList<Author_1Bean>();
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<Participant2Bean> participant = new ArrayList<Participant2Bean>();
    private List<EntryRelationshipBean> entryRelationship = new ArrayList<EntryRelationshipBean>();
    private List<ReferenceBean> reference = new ArrayList<ReferenceBean>();
    private List<PreconditionBean> precondition = new ArrayList<PreconditionBean>();


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public CodedTypeR2<x_DocumentSubstanceMood> getMoodCode() {
        return (CodedTypeR2<x_DocumentSubstanceMood>) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setMoodCode(CodedTypeR2<x_DocumentSubstanceMood> moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: POCD_MT000040.SubstanceAdministration.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: POCD_MT000040.SubstanceAdministration.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.SubstanceAdministration.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: POCD_MT000040.SubstanceAdministration.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedDataR2 getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.SubstanceAdministration.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(EncapsulatedDataR2 text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public CodedTypeR2<Code> getStatusCode() {
        return (CodedTypeR2<Code>) this.statusCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setStatusCode(CodedTypeR2<Code> statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public List<Date> getEffectiveTime() {
        return this.effectiveTime.rawList();
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public CodedTypeR2<Code> getPriorityCode() {
        return (CodedTypeR2<Code>) this.priorityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPriorityCode(CodedTypeR2<Code> priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Interval<Integer> getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRepeatNumber(Interval<Integer> repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public CodedTypeR2<Code> getRouteCode() {
        return (CodedTypeR2<Code>) this.routeCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRouteCode(CodedTypeR2<Code> routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.approachSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public List<CodedTypeR2<Code>> getApproachSiteCode() {
        return this.approachSiteCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public Interval<PhysicalQuantity> getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDoseQuantity(Interval<PhysicalQuantity> doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.rateQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"rateQuantity"})
    public Interval<PhysicalQuantity> getRateQuantity() {
        return this.rateQuantity.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.rateQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRateQuantity(Interval<PhysicalQuantity> rateQuantity) {
        this.rateQuantity.setValue(rateQuantity);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.maxDoseQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"maxDoseQuantity"})
    public Ratio<PhysicalQuantity, PhysicalQuantity> getMaxDoseQuantity() {
        return this.maxDoseQuantity.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.maxDoseQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMaxDoseQuantity(Ratio<PhysicalQuantity, PhysicalQuantity> maxDoseQuantity) {
        this.maxDoseQuantity.setValue(maxDoseQuantity);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.administrationUnitCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"administrationUnitCode"})
    public CodedTypeR2<Code> getAdministrationUnitCode() {
        return (CodedTypeR2<Code>) this.administrationUnitCode.getValue();
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.administrationUnitCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAdministrationUnitCode(CodedTypeR2<Code> administrationUnitCode) {
        this.administrationUnitCode.setValue(administrationUnitCode);
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.specimen</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<SpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.consumable</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"consumable"})
    public ConsumableBean getConsumable() {
        return this.consumable;
    }

    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.consumable</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setConsumable(ConsumableBean consumable) {
        this.consumable = consumable;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"performer"})
    public List<Performer2_1Bean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<Author_1Bean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant2Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"entryRelationship"})
    public List<EntryRelationshipBean> getEntryRelationship() {
        return this.entryRelationship;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.reference</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<ReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Relationship: 
     * POCD_MT000040.SubstanceAdministration.precondition</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"precondition"})
    public List<PreconditionBean> getPrecondition() {
        return this.precondition;
    }

}
