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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.procedureactivityobservation;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD_R2;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActClassObservation;
import ca.infoway.messagebuilder.domainvalue.ActPriority;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.BodySite;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.MoodCodeEvnInt;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.ProcedureActStatusCode;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Informant12Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Participant2_1Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.Performer2Bean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ReferenceBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.ReferenceRangeBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.merged.SpecimenBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.PreconditionBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.SubjectBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"ProcedureActivityObservation.Observation"})
@Hl7RootType
public class ObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private CS_R2 classCode = new CS_R2Impl();
    private CS_R2 moodCode = new CS_R2Impl();
    private BL negationInd = new BLImpl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private II templateId = new IIImpl();
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private CD_R2 code = new CD_R2Impl();
    private ST derivationExpr = new STImpl();
    private ED<EncapsulatedDataR2> text = new EDImpl<EncapsulatedDataR2>();
    private CS_R2 statusCode = new CS_R2Impl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CE_R2 priorityCode = new CE_R2Impl();
    private IVL<INT, Interval<Integer>> repeatNumber = new IVLImpl<INT, Interval<Integer>>();
    private CS_R2 languageCode = new CS_R2Impl();
    private ANY<Object> value = new ANYImpl<Object>();
    private LIST<CE_R2, CodedTypeR2<? extends Code>> interpretationCode = new LISTImpl<CE_R2, CodedTypeR2<? extends Code>>(CE_R2Impl.class);
    private CE_R2 methodCode = new CE_R2Impl();
    private LIST<CD_R2, CodedTypeR2<? extends Code>> targetSiteCode = new LISTImpl<CD_R2, CodedTypeR2<? extends Code>>(CD_R2Impl.class);
    private SubjectBean subject;
    private List<SpecimenBean> specimen = new ArrayList<SpecimenBean>();
    private List<Performer2Bean> performer = new ArrayList<Performer2Bean>();
    private List<Author_1Bean> author = new ArrayList<Author_1Bean>();
    private List<Informant12Bean> informant = new ArrayList<Informant12Bean>();
    private List<Participant2_1Bean> participant = new ArrayList<Participant2_1Bean>();
    private List<EntryRelationshipChoice> entryRelationship = new ArrayList<EntryRelationshipChoice>();
    private List<ReferenceBean> reference = new ArrayList<ReferenceBean>();
    private List<PreconditionBean> precondition = new ArrayList<PreconditionBean>();
    private List<ReferenceRangeBean> referenceRange = new ArrayList<ReferenceRangeBean>();


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.classCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public CodedTypeR2<ActClassObservation> getClassCode() {
        return (CodedTypeR2<ActClassObservation>) this.classCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.classCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setClassCode(CodedTypeR2<ActClassObservation> classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.moodCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public CodedTypeR2<MoodCodeEvnInt> getMoodCode() {
        return (CodedTypeR2<MoodCodeEvnInt>) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.moodCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setMoodCode(CodedTypeR2<MoodCodeEvnInt> moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public Identifier getTemplateId() {
        return this.templateId.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTemplateId(Identifier templateId) {
        this.templateId.setValue(templateId);
    }


    /**
     * <p>Relationship: ProcedureActivityObservation.Observation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CodedTypeR2<Code> getCode() {
        return (CodedTypeR2<Code>) this.code.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(CodedTypeR2<Code> code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.derivationExpr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"derivationExpr"})
    public String getDerivationExpr() {
        return this.derivationExpr.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.derivationExpr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDerivationExpr(String derivationExpr) {
        this.derivationExpr.setValue(derivationExpr);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedDataR2 getText() {
        return this.text.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(EncapsulatedDataR2 text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public CodedTypeR2<ProcedureActStatusCode> getStatusCode() {
        return (CodedTypeR2<ProcedureActStatusCode>) this.statusCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(CodedTypeR2<ProcedureActStatusCode> statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public CodedTypeR2<ActPriority> getPriorityCode() {
        return (CodedTypeR2<ActPriority>) this.priorityCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setPriorityCode(CodedTypeR2<ActPriority> priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Interval<Integer> getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRepeatNumber(Interval<Integer> repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public CodedTypeR2<Code> getLanguageCode() {
        return (CodedTypeR2<Code>) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLanguageCode(CodedTypeR2<Code> languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setValue(Object value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public List<CodedTypeR2<Code>> getInterpretationCode() {
        return this.interpretationCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.methodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"methodCode"})
    public CodedTypeR2<Code> getMethodCode() {
        return (CodedTypeR2<Code>) this.methodCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.methodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMethodCode(CodedTypeR2<Code> methodCode) {
        this.methodCode.setValue(methodCode);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.targetSiteCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"targetSiteCode"})
    public List<CodedTypeR2<BodySite>> getTargetSiteCode() {
        return this.targetSiteCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public SubjectBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.subject</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.specimen</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<SpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.performer</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"performer"})
    public List<Performer2Bean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"author"})
    public List<Author_1Bean> getAuthor() {
        return this.author;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.informant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"informant"})
    public List<Informant12Bean> getInformant() {
        return this.informant;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.participant</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<Participant2_1Bean> getParticipant() {
        return this.participant;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.entryRelationship</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"entryRelationship"})
    public List<EntryRelationshipChoice> getEntryRelationship() {
        return this.entryRelationship;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.reference</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<ReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.precondition</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"precondition"})
    public List<PreconditionBean> getPrecondition() {
        return this.precondition;
    }


    /**
     * <p>Relationship: 
     * ProcedureActivityObservation.Observation.referenceRange</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"referenceRange"})
    public List<ReferenceRangeBean> getReferenceRange() {
        return this.referenceRange;
    }

}
