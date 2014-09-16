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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.medicationdispense;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
import ca.infoway.messagebuilder.datatype.SXCM_R2;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SXCM_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActClassSupply;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.MedicationFillStatus;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.x_DocumentSubstanceMood;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ImmunizationMedicationInformationProductBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.MedicationInformationProductBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Participant1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ProductChoice;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ReferenceBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.SpecimenBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.PreconditionBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.SubjectBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"MedicationDispense.Supply"})
@Hl7RootType
public class SupplyBean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private CS_R2 classCode = new CS_R2Impl();
    private CS_R2 moodCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private II templateId = new IIImpl();
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CD_R2 code = new CD_R2Impl();
    private ED<EncapsulatedDataR2> text = new EDImpl<EncapsulatedDataR2>();
    private CS_R2 statusCode = new CS_R2Impl();
    private SXCM_R2<Date> effectiveTime = new SXCM_R2Impl<Date>();
    private LIST<CE_R2, CodedTypeR2<? extends Code>> priorityCode = new LISTImpl<CE_R2, CodedTypeR2<? extends Code>>(CE_R2Impl.class);
    private IVL<INT, Interval<Integer>> repeatNumber = new IVLImpl<INT, Interval<Integer>>();
    private BL independentInd = new BLImpl();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private SubjectBean subject;
    private List<SpecimenBean> specimen = new ArrayList<SpecimenBean>();
    private ProductChoice product;
    private Performer2Bean performer;
    private List<Author_1Bean> author = new ArrayList<Author_1Bean>();
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<Participant1Bean> participant = new ArrayList<Participant1Bean>();
    private EntryRelationshipBean entryRelationship;
    private List<ReferenceBean> reference = new ArrayList<ReferenceBean>();
    private List<PreconditionBean> precondition = new ArrayList<PreconditionBean>();


    /**
     * <p>Relationship: MedicationDispense.Supply.classCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public CodedTypeR2<ActClassSupply> getClassCode() {
        return (CodedTypeR2<ActClassSupply>) this.classCode.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.classCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setClassCode(CodedTypeR2<ActClassSupply> classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.moodCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public CodedTypeR2<x_DocumentSubstanceMood> getMoodCode() {
        return (CodedTypeR2<x_DocumentSubstanceMood>) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.moodCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setMoodCode(CodedTypeR2<x_DocumentSubstanceMood> moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public Identifier getTemplateId() {
        return this.templateId.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTemplateId(Identifier templateId) {
        this.templateId.setValue(templateId);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedDataR2 getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(EncapsulatedDataR2 text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public CodedTypeR2<MedicationFillStatus> getStatusCode() {
        return (CodedTypeR2<MedicationFillStatus>) this.statusCode.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(CodedTypeR2<MedicationFillStatus> statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public List<CodedTypeR2<Code>> getPriorityCode() {
        return this.priorityCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Interval<Integer> getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRepeatNumber(Interval<Integer> repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.independentInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"independentInd"})
    public Boolean getIndependentInd() {
        return this.independentInd.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.independentInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setIndependentInd(Boolean independentInd) {
        this.independentInd.setValue(independentInd);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.quantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.quantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.specimen</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<SpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.product</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"product"})
    public ProductChoice getProduct() {
        return this.product;
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.product</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setProduct(ProductChoice product) {
        this.product = product;
    }

    public MedicationInformationProductBean getProductAsMedicationInformationProduct() {
        return this.product instanceof MedicationInformationProductBean ? (MedicationInformationProductBean) this.product : null;
    }
    public boolean hasProductAsMedicationInformationProduct() {
        return (this.product instanceof MedicationInformationProductBean);
    }

    public ImmunizationMedicationInformationProductBean getProductAsImmunizationMedicationInformationProduct() {
        return this.product instanceof ImmunizationMedicationInformationProductBean ? (ImmunizationMedicationInformationProductBean) this.product : null;
    }
    public boolean hasProductAsImmunizationMedicationInformationProduct() {
        return (this.product instanceof ImmunizationMedicationInformationProductBean);
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"performer"})
    public Performer2Bean getPerformer() {
        return this.performer;
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPerformer(Performer2Bean performer) {
        this.performer = performer;
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<Author_1Bean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant1Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"entryRelationship"})
    public EntryRelationshipBean getEntryRelationship() {
        return this.entryRelationship;
    }

    /**
     * <p>Relationship: MedicationDispense.Supply.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEntryRelationship(EntryRelationshipBean entryRelationship) {
        this.entryRelationship = entryRelationship;
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.reference</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<ReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Relationship: MedicationDispense.Supply.precondition</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"precondition"})
    public List<PreconditionBean> getPrecondition() {
        return this.precondition;
    }

}
