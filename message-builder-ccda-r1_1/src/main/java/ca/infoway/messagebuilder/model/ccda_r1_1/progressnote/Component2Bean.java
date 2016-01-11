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
package ca.infoway.messagebuilder.model.ccda_r1_1.progressnote;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.NonXMLBodyBean;
import java.util.List;



@Hl7PartTypeMapping({"ProgressNote.Component2"})
public class Component2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20160107L;
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private Component2Choice component2Choice;


    /**
     * <p>Relationship: ProgressNote.Component2.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: ProgressNote.Component2.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: ProgressNote.Component2.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: ProgressNote.Component2.component2Choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2Choice"})
    public Component2Choice getComponent2Choice() {
        return this.component2Choice;
    }

    /**
     * <p>Relationship: ProgressNote.Component2.component2Choice</p>
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
