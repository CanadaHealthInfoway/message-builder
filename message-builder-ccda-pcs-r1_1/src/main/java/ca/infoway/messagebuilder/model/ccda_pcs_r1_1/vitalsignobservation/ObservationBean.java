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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.vitalsignobservation;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.IVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.basemodel.PreconditionBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.basemodel.ReferenceBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.basemodel.SubjectBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.domainvalue.VitalSignResult;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationship_2Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Participant2_2Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Performer2_1Bean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.ReferenceRangeBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.SpecimenBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"VitalSignObservation.Observation"})
@Hl7RootType
public class ObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20160107L;
    private BL negationInd = new BLImpl();
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private ST derivationExpr = new STImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private IVLTSCDAR1 effectiveTime = new IVLTSCDAR1Impl();
    private CE priorityCode = new CEImpl();
    private IVL<INT, Interval<Integer>> repeatNumber = new IVLImpl<INT, Interval<Integer>>();
    private CS languageCode = new CSImpl();
    private PQ value = new PQImpl();
    private CE interpretationCode = new CEImpl();
    private CE methodCode = new CEImpl();
    private CD targetSiteCode = new CDImpl();
    private SubjectBean subject;
    private List<SpecimenBean> specimen = new ArrayList<SpecimenBean>();
    private List<Performer2_1Bean> performer = new ArrayList<Performer2_1Bean>();
    private Author_1Bean author;
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<Participant2_2Bean> participant = new ArrayList<Participant2_2Bean>();
    private List<EntryRelationship_2Bean> entryRelationship = new ArrayList<EntryRelationship_2Bean>();
    private List<ReferenceBean> reference = new ArrayList<ReferenceBean>();
    private List<PreconditionBean> precondition = new ArrayList<PreconditionBean>();
    private List<ReferenceRangeBean> referenceRange = new ArrayList<ReferenceRangeBean>();


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: VitalSignObservation.Observation.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public VitalSignResult getCode() {
        return (VitalSignResult) this.code.getValue();
    }

    /**
     * <p>Relationship: VitalSignObservation.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setCode(VitalSignResult code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.derivationExpr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"derivationExpr"})
    public String getDerivationExpr() {
        return this.derivationExpr.getValue();
    }

    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.derivationExpr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDerivationExpr(String derivationExpr) {
        this.derivationExpr.setValue(derivationExpr);
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: VitalSignObservation.Observation.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public DateInterval getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setEffectiveTime(DateInterval effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public Code getPriorityCode() {
        return (Code) this.priorityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPriorityCode(Code priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Interval<Integer> getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRepeatNumber(Interval<Integer> repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public Code getLanguageCode() {
        return (Code) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLanguageCode(Code languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.value</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Relationship: VitalSignObservation.Observation.value</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public Code getInterpretationCode() {
        return (Code) this.interpretationCode.getValue();
    }

    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setInterpretationCode(Code interpretationCode) {
        this.interpretationCode.setValue(interpretationCode);
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.methodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"methodCode"})
    public Code getMethodCode() {
        return (Code) this.methodCode.getValue();
    }

    /**
     * <p>Relationship: VitalSignObservation.Observation.methodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMethodCode(Code methodCode) {
        this.methodCode.setValue(methodCode);
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.targetSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"targetSiteCode"})
    public Code getTargetSiteCode() {
        return (Code) this.targetSiteCode.getValue();
    }

    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.targetSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTargetSiteCode(Code targetSiteCode) {
        this.targetSiteCode.setValue(targetSiteCode);
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: VitalSignObservation.Observation.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.specimen</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<SpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"performer"})
    public List<Performer2_1Bean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public Author_1Bean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: VitalSignObservation.Observation.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAuthor(Author_1Bean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant2_2Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"entryRelationship"})
    public List<EntryRelationship_2Bean> getEntryRelationship() {
        return this.entryRelationship;
    }


    /**
     * <p>Relationship: VitalSignObservation.Observation.reference</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<ReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.precondition</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"precondition"})
    public List<PreconditionBean> getPrecondition() {
        return this.precondition;
    }


    /**
     * <p>Relationship: 
     * VitalSignObservation.Observation.referenceRange</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"referenceRange"})
    public List<ReferenceRangeBean> getReferenceRange() {
        return this.referenceRange;
    }

}
