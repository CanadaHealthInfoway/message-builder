/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ccda_r1_1.historyandphysical;

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
import ca.infoway.messagebuilder.model.ccda_r1_1.pocd_mt000040.NonXMLBodyBean;
import java.util.List;



@Hl7PartTypeMapping({"HistoryAndPhysical.Component2"})
public class Component2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20150206L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private Component2Choice component2Choice;


    /**
     * <p>Relationship: HistoryAndPhysical.Component2.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: HistoryAndPhysical.Component2.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: HistoryAndPhysical.Component2.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: HistoryAndPhysical.Component2.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * HistoryAndPhysical.Component2.component2Choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2Choice"})
    public Component2Choice getComponent2Choice() {
        return this.component2Choice;
    }

    /**
     * <p>Relationship: 
     * HistoryAndPhysical.Component2.component2Choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent2Choice(Component2Choice component2Choice) {
        this.component2Choice = component2Choice;
    }

    public NonXMLBodyBean getComponent2ChoiceAsNonXMLBody() {
        return this.component2Choice instanceof NonXMLBodyBean ? (NonXMLBodyBean) this.component2Choice : null;
    }
    public boolean hasComponent2ChoiceAsNonXMLBody() {
        return (this.component2Choice instanceof NonXMLBodyBean);
    }

    public StructuredBodyBean getComponent2ChoiceAsStructuredBody() {
        return this.component2Choice instanceof StructuredBodyBean ? (StructuredBodyBean) this.component2Choice : null;
    }
    public boolean hasComponent2ChoiceAsStructuredBody() {
        return (this.component2Choice instanceof StructuredBodyBean);
    }

}
