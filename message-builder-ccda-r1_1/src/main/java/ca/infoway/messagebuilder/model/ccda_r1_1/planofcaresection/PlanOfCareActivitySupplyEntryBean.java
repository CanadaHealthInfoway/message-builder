/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ccda_r1_1.planofcaresection;

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
import ca.infoway.messagebuilder.model.ccda_r1_1.domainvalue.x_ActRelationshipEntry;
import ca.infoway.messagebuilder.model.ccda_r1_1.planofcareactivitysupply.SupplyBean;
import java.util.List;



@Hl7PartTypeMapping({"PlanOfCareSection.PlanOfCareActivitySupplyEntry"})
public class PlanOfCareActivitySupplyEntryBean extends MessagePartBean implements EntryChoice {

    private static final long serialVersionUID = 20150206L;
    private CS_R2 typeCode = new CS_R2Impl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private SupplyBean observation;


    /**
     * <p>Relationship: 
     * PlanOfCareSection.PlanOfCareActivitySupplyEntry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public CodedTypeR2<x_ActRelationshipEntry> getTypeCode() {
        return (CodedTypeR2<x_ActRelationshipEntry>) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: 
     * PlanOfCareSection.PlanOfCareActivitySupplyEntry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(CodedTypeR2<x_ActRelationshipEntry> typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: 
     * PlanOfCareSection.PlanOfCareActivitySupplyEntry.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * PlanOfCareSection.PlanOfCareActivitySupplyEntry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * PlanOfCareSection.PlanOfCareActivitySupplyEntry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * PlanOfCareSection.PlanOfCareActivitySupplyEntry.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * PlanOfCareSection.PlanOfCareActivitySupplyEntry.observation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"observation"})
    public SupplyBean getObservation() {
        return this.observation;
    }

    /**
     * <p>Relationship: 
     * PlanOfCareSection.PlanOfCareActivitySupplyEntry.observation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setObservation(SupplyBean observation) {
        this.observation = observation;
    }

}
