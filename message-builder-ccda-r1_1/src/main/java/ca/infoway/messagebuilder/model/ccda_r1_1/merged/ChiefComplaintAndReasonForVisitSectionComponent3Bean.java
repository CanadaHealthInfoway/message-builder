/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ccda_r1_1.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.chiefcomplaintandreasonforvisitsection.SectionBean;
import java.util.List;



@Hl7PartTypeMapping({"ConsultationNote.ChiefComplaintAndReasonForVisitSectionComponent3","DischargeSummary.ChiefComplaintAndReasonForVisitSectionComponent3","HistoryAndPhysical.ChiefComplaintAndReasonForVisitSectionComponent3","ProcedureNote.ChiefComplaintAndReasonForVisitSectionComponent3"})
public class ChiefComplaintAndReasonForVisitSectionComponent3Bean extends MessagePartBean implements ca.infoway.messagebuilder.model.ccda_r1_1.procedurenote.Component3Choice, ca.infoway.messagebuilder.model.ccda_r1_1.consultationnote.Component3Choice, ca.infoway.messagebuilder.model.ccda_r1_1.historyandphysical.Component3Choice, ca.infoway.messagebuilder.model.ccda_r1_1.dischargesummary.Component3Choice {

    private static final long serialVersionUID = 20150206L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private SectionBean section;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ConsultationNote.ChiefComplaintAndReasonForVisitSectionComponent3.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * HistoryAndPhysical.ChiefComplaintAndReasonForVisitSectionComponent3.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProcedureNote.ChiefComplaintAndReasonForVisitSectionComponent3.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * DischargeSummary.ChiefComplaintAndReasonForVisitSectionComponent3.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ConsultationNote.ChiefComplaintAndReasonForVisitSectionComponent3.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * HistoryAndPhysical.ChiefComplaintAndReasonForVisitSectionComponent3.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProcedureNote.ChiefComplaintAndReasonForVisitSectionComponent3.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * DischargeSummary.ChiefComplaintAndReasonForVisitSectionComponent3.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ConsultationNote.ChiefComplaintAndReasonForVisitSectionComponent3.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * HistoryAndPhysical.ChiefComplaintAndReasonForVisitSectionComponent3.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProcedureNote.ChiefComplaintAndReasonForVisitSectionComponent3.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * DischargeSummary.ChiefComplaintAndReasonForVisitSectionComponent3.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ConsultationNote.ChiefComplaintAndReasonForVisitSectionComponent3.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * HistoryAndPhysical.ChiefComplaintAndReasonForVisitSectionComponent3.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProcedureNote.ChiefComplaintAndReasonForVisitSectionComponent3.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * DischargeSummary.ChiefComplaintAndReasonForVisitSectionComponent3.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ConsultationNote.ChiefComplaintAndReasonForVisitSectionComponent3.section</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * HistoryAndPhysical.ChiefComplaintAndReasonForVisitSectionComponent3.section</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProcedureNote.ChiefComplaintAndReasonForVisitSectionComponent3.section</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * DischargeSummary.ChiefComplaintAndReasonForVisitSectionComponent3.section</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"section"})
    public SectionBean getSection() {
        return this.section;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ConsultationNote.ChiefComplaintAndReasonForVisitSectionComponent3.section</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * HistoryAndPhysical.ChiefComplaintAndReasonForVisitSectionComponent3.section</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * ProcedureNote.ChiefComplaintAndReasonForVisitSectionComponent3.section</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * DischargeSummary.ChiefComplaintAndReasonForVisitSectionComponent3.section</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSection(SectionBean section) {
        this.section = section;
    }

}
