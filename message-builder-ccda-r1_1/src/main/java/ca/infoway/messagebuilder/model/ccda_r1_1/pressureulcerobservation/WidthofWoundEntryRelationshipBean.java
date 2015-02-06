/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ccda_r1_1.pressureulcerobservation;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.List;



@Hl7PartTypeMapping({"PressureUlcerObservation.WidthofWoundEntryRelationship"})
public class WidthofWoundEntryRelationshipBean extends MessagePartBean implements EntryRelationshipChoice {

    private static final long serialVersionUID = 20150206L;
    private BL inversionInd = new BLImpl();
    private BL contextConductionInd = new BLImpl();
    private BL negationInd = new BLImpl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private INT sequenceNumber = new INTImpl();
    private BL seperatableInd = new BLImpl();
    private WidthofWoundEntryRelationshipObservationBean observation;


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.inversionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"inversionInd"})
    public Boolean getInversionInd() {
        return this.inversionInd.getValue();
    }

    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.inversionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setInversionInd(Boolean inversionInd) {
        this.inversionInd.setValue(inversionInd);
    }


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"seperatableInd"})
    public Boolean getSeperatableInd() {
        return this.seperatableInd.getValue();
    }

    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSeperatableInd(Boolean seperatableInd) {
        this.seperatableInd.setValue(seperatableInd);
    }


    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.observation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"observation"})
    public WidthofWoundEntryRelationshipObservationBean getObservation() {
        return this.observation;
    }

    /**
     * <p>Relationship: 
     * PressureUlcerObservation.WidthofWoundEntryRelationship.observation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setObservation(WidthofWoundEntryRelationshipObservationBean observation) {
        this.observation = observation;
    }

}
