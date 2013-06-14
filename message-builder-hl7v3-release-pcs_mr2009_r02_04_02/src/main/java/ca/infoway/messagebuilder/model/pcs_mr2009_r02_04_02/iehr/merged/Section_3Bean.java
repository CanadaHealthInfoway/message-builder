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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT230002CA.Section","REPC_MT230003CA.Section"})
public class Section_3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private DocumentContent_3 componentDocumentContent;
    private List<DocumentSectionsBean> component2SubSection = new ArrayList<DocumentSectionsBean>();
    private List<II> component3ReferenceId = new ArrayList<II>();


    /**
     * <p>Business Name: DocumentOverviewContent</p>
     * 
     * <p>Un-merged Business Name: DocumentOverviewContent</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Section.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Represents the principle content of the document and 
     * therefore is mandatory.</p>
     * 
     * <p>There is no guidance provided within the standard on how 
     * report content should be organized or formatted. Guidance 
     * may be provided by professional colleges, specialty groups 
     * or others.</p>
     * 
     * <p>Provides the primary rendered textual content of the 
     * document.</p><p>E.g. The cover letter for a referral, the 
     * overview portion of a report, etc.</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: DocumentOverviewContent</p>
     * 
     * <p>Un-merged Business Name: DocumentOverviewContent</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Section.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Represents the principle content of the document and 
     * therefore is mandatory.</p>
     * 
     * <p>There is no guidance provided within the standard on how 
     * report content should be organized or formatted. Guidance 
     * may be provided by professional colleges, specialty groups 
     * or others.</p>
     * 
     * <p>Provides the primary rendered textual content of the 
     * document.</p><p>E.g. The cover letter for a referral, the 
     * overview portion of a report, etc.</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Component4.documentContent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Component4.documentContent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/documentContent","component1/documentContent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component", type="REPC_MT230002CA.Component4"),
        @Hl7MapByPartType(name="component/documentContent", type="REPC_MT230002CA.DocumentContent"),
        @Hl7MapByPartType(name="component1", type="REPC_MT230003CA.Component4"),
        @Hl7MapByPartType(name="component1/documentContent", type="REPC_MT230003CA.DocumentContent")})
    public DocumentContent_3 getComponentDocumentContent() {
        return this.componentDocumentContent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Component4.documentContent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Component4.documentContent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentDocumentContent(DocumentContent_3 componentDocumentContent) {
        this.componentDocumentContent = componentDocumentContent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Component.subSection</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/subSection"})
    public List<DocumentSectionsBean> getComponent2SubSection() {
        return this.component2SubSection;
    }


    /**
     * <p>Business Name: ReferenceRecordLinks</p>
     * 
     * <p>Un-merged Business Name: ReferenceRecordLinks</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Reference.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The external references allow accessing discrete data for 
     * additional analysis and manipulation such as graphing, 
     * automated comparison or decision-support.</p>
     * 
     * <p>For sections, the links may refer specifically to records 
     * which have been rendered as part of the section.</p>
     * 
     * <p>These identifiers allow for referencing other discrete 
     * records within the EHR which are considered relevant to the 
     * document as a whole or a particular section.</p>
     */
    @Hl7XmlMapping({"component3/reference/id"})
    public List<Identifier> getComponent3ReferenceId() {
        return new RawListWrapper<II, Identifier>(component3ReferenceId, IIImpl.class);
    }

}
