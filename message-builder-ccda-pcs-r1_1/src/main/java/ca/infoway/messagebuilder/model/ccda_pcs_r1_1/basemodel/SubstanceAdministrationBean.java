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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.basemodel;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.SXCMTSCDAR1;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.SXCMTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.domainvalue.x_DocumentSubstanceMood;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationship_2Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Participant2_2Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Performer2_1Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.SpecimenBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.SubstanceAdministration"})
public class SubstanceAdministrationBean extends MessagePartBean implements EntryChoice, Component4Choice, EntryRelationshipChoice {

    private static final long serialVersionUID = 20160107L;
    private CS moodCode = new CSImpl();
    private BL negationInd = new BLImpl();
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private CS statusCode = new CSImpl();
    private LIST<SXCMTSCDAR1, MbDate> effectiveTime = new LISTImpl<SXCMTSCDAR1, MbDate>(SXCMTSCDAR1Impl.class);
    private CE priorityCode = new CEImpl();
    private IVL<INT, Interval<Integer>> repeatNumber = new IVLImpl<INT, Interval<Integer>>();
    private CE routeCode = new CEImpl();
    private LIST<CD, Code> approachSiteCode = new LISTImpl<CD, Code>(CDImpl.class);
    private IVL<PQ, Interval<PhysicalQuantity>> doseQuantity = new IVLImpl<PQ, Interval<PhysicalQuantity>>();
    private IVL<PQ, Interval<PhysicalQuantity>> rateQuantity = new IVLImpl<PQ, Interval<PhysicalQuantity>>();
    private RTO<PhysicalQuantity, PhysicalQuantity> maxDoseQuantity = new RTOImpl<PhysicalQuantity, PhysicalQuantity>();
    private CE administrationUnitCode = new CEImpl();
    private SubjectBean subject;
    private List<SpecimenBean> specimen = new ArrayList<SpecimenBean>();
    private ConsumableBean consumable;
    private List<Performer2_1Bean> performer = new ArrayList<Performer2_1Bean>();
    private List<Author_1Bean> author = new ArrayList<Author_1Bean>();
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<Participant2_2Bean> participant = new ArrayList<Participant2_2Bean>();
    private List<EntryRelationship_2Bean> entryRelationship = new ArrayList<EntryRelationship_2Bean>();
    private List<ReferenceBean> reference = new ArrayList<ReferenceBean>();
    private List<PreconditionBean> precondition = new ArrayList<PreconditionBean>();


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_DocumentSubstanceMood getMoodCode() {
        return (x_DocumentSubstanceMood) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setMoodCode(x_DocumentSubstanceMood moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }

    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public Code getStatusCode() {
        return (Code) this.statusCode.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setStatusCode(Code statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public List<MbDate> getEffectiveTime() {
        return this.effectiveTime.rawList();
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public Code getPriorityCode() {
        return (Code) this.priorityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPriorityCode(Code priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Interval<Integer> getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRepeatNumber(Interval<Integer> repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public Code getRouteCode() {
        return (Code) this.routeCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.routeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRouteCode(Code routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.approachSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public List<Code> getApproachSiteCode() {
        return this.approachSiteCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public Interval<PhysicalQuantity> getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDoseQuantity(Interval<PhysicalQuantity> doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.rateQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"rateQuantity"})
    public Interval<PhysicalQuantity> getRateQuantity() {
        return this.rateQuantity.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.rateQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRateQuantity(Interval<PhysicalQuantity> rateQuantity) {
        this.rateQuantity.setValue(rateQuantity);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.maxDoseQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"maxDoseQuantity"})
    public Ratio<PhysicalQuantity, PhysicalQuantity> getMaxDoseQuantity() {
        return this.maxDoseQuantity.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.maxDoseQuantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMaxDoseQuantity(Ratio<PhysicalQuantity, PhysicalQuantity> maxDoseQuantity) {
        this.maxDoseQuantity.setValue(maxDoseQuantity);
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.administrationUnitCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"administrationUnitCode"})
    public Code getAdministrationUnitCode() {
        return (Code) this.administrationUnitCode.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.administrationUnitCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAdministrationUnitCode(Code administrationUnitCode) {
        this.administrationUnitCode.setValue(administrationUnitCode);
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.specimen</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<SpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.consumable</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"consumable"})
    public ConsumableBean getConsumable() {
        return this.consumable;
    }

    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.consumable</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setConsumable(ConsumableBean consumable) {
        this.consumable = consumable;
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"performer"})
    public List<Performer2_1Bean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<Author_1Bean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant2_2Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"entryRelationship"})
    public List<EntryRelationship_2Bean> getEntryRelationship() {
        return this.entryRelationship;
    }


    /**
     * <p>Relationship: BaseModel.SubstanceAdministration.reference</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<ReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Relationship: 
     * BaseModel.SubstanceAdministration.precondition</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"precondition"})
    public List<PreconditionBean> getPrecondition() {
        return this.precondition;
    }

}
