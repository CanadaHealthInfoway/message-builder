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
package ca.infoway.messagebuilder.model.ccda_r1_1.medicationsupplyorder;

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
import ca.infoway.messagebuilder.datatype.IVL_TS;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SXCM_R2;
import ca.infoway.messagebuilder.datatype.TS_R2;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.IVL_TSImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SXCM_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.TS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.Participant2Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.PreconditionBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.ProductBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.ReferenceBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.SubjectBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ImmunizationMedicationInformationProductBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.MedicationInformationProductBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Performer2_1Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ProductChoice;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.SpecimenBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"MedicationSupplyOrder.Supply"})
@Hl7RootType
public class SupplyBean extends MessagePartBean {

    private static final long serialVersionUID = 20150224L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CD_R2 code = new CD_R2Impl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private CS_R2 statusCode = new CS_R2Impl();
    private LIST<SXCM_R2<MbDate>, MbDate> effectiveTime = new LISTImpl<SXCM_R2<MbDate>, MbDate>(SXCM_R2Impl.class);
    private LIST<CE_R2, CodedTypeR2<? extends Code>> priorityCode = new LISTImpl<CE_R2, CodedTypeR2<? extends Code>>(CE_R2Impl.class);
    private IVL<INT, Interval<Integer>> repeatNumber = new IVLImpl<INT, Interval<Integer>>();
    private BL independentInd = new BLImpl();
    private PQ quantity = new PQImpl();
    private IVL_TS expectedUseTime = new IVL_TSImpl();
    private SubjectBean subject;
    private List<SpecimenBean> specimen = new ArrayList<SpecimenBean>();
    private ProductChoice product;
    private List<Performer2_1Bean> performer = new ArrayList<Performer2_1Bean>();
    private Author_1Bean author;
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<Participant2Bean> participant = new ArrayList<Participant2Bean>();
    private EntryRelationshipBean entryRelationship;
    private List<ReferenceBean> reference = new ArrayList<ReferenceBean>();
    private List<PreconditionBean> precondition = new ArrayList<PreconditionBean>();


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.statusCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public CodedTypeR2<Code> getStatusCode() {
        return (CodedTypeR2<Code>) this.statusCode.getValue();
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.statusCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setStatusCode(CodedTypeR2<Code> statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public List<MbDate> getEffectiveTime() {
        return this.effectiveTime.rawList();
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public List<CodedTypeR2<Code>> getPriorityCode() {
        return this.priorityCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Interval<Integer> getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRepeatNumber(Interval<Integer> repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.independentInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"independentInd"})
    public Boolean getIndependentInd() {
        return this.independentInd.getValue();
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.independentInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setIndependentInd(Boolean independentInd) {
        this.independentInd.setValue(independentInd);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.quantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.quantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Relationship: 
     * MedicationSupplyOrder.Supply.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public DateInterval getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Relationship: 
     * MedicationSupplyOrder.Supply.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setExpectedUseTime(DateInterval expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.specimen</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<SpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.product</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"product"})
    public ProductChoice getProduct() {
        return this.product;
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.product</p>
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

    public ProductBean getProductAsProduct() {
        return this.product instanceof ProductBean ? (ProductBean) this.product : null;
    }
    public boolean hasProductAsProduct() {
        return (this.product instanceof ProductBean);
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"performer"})
    public List<Performer2_1Bean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public Author_1Bean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAuthor(Author_1Bean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant2Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * MedicationSupplyOrder.Supply.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"entryRelationship"})
    public EntryRelationshipBean getEntryRelationship() {
        return this.entryRelationship;
    }

    /**
     * <p>Relationship: 
     * MedicationSupplyOrder.Supply.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEntryRelationship(EntryRelationshipBean entryRelationship) {
        this.entryRelationship = entryRelationship;
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.reference</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<ReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Relationship: MedicationSupplyOrder.Supply.precondition</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"precondition"})
    public List<PreconditionBean> getPrecondition() {
        return this.precondition;
    }

}
