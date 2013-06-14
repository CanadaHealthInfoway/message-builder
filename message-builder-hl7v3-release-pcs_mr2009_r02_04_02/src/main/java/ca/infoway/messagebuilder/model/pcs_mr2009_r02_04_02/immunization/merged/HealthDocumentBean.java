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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: HealthDocument</p>
 * 
 * <p>POIZ_MT030060CA.HealthDocument: Health Document</p>
 * 
 * <p>Useful for identifying the Health Document that is the 
 * basis of historical immunization information.</p>
 * 
 * <p>The health document that supports the historical 
 * immunization information.</p>
 * 
 * <p>POIZ_MT030050CA.HealthDocument: Health Document</p>
 * 
 * <p>Useful for identifying the Health Document that is the 
 * basis of historical immunization information.</p>
 * 
 * <p>The health document that supports the historical 
 * immunization information.</p>
 * 
 * <p>POIZ_MT060150CA.HealthDocument: Health Document</p>
 * 
 * <p>Useful for identifying the Health Document that is the 
 * basis of historical immunization information.</p>
 * 
 * <p>The health document that supports the historical 
 * immunization information.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.HealthDocument","POIZ_MT030060CA.HealthDocument","POIZ_MT060150CA.HealthDocument"})
public class HealthDocumentBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private ST title = new STImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();


    /**
     * <p>Business Name: HealthDocumentID</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.HealthDocument.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to reference identified health documents. As not all 
     * implementations will support this concept, this attribute is 
     * optional.</p>
     * 
     * <p>Identifies the health document that supports the 
     * historical immunization information.</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.HealthDocument.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to reference identified health documents. As not all 
     * implementations will support this concept, this attribute is 
     * optional.</p>
     * 
     * <p>Identifies the health document that supports the 
     * historical immunization information.</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.HealthDocument.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to reference identified health documents. As not all 
     * implementations will support this concept, this attribute is 
     * optional.</p>
     * 
     * <p>Identifies the health document that supports the 
     * historical immunization information.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: HealthDocumentID</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.HealthDocument.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to reference identified health documents. As not all 
     * implementations will support this concept, this attribute is 
     * optional.</p>
     * 
     * <p>Identifies the health document that supports the 
     * historical immunization information.</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.HealthDocument.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to reference identified health documents. As not all 
     * implementations will support this concept, this attribute is 
     * optional.</p>
     * 
     * <p>Identifies the health document that supports the 
     * historical immunization information.</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.HealthDocument.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to reference identified health documents. As not all 
     * implementations will support this concept, this attribute is 
     * optional.</p>
     * 
     * <p>Identifies the health document that supports the 
     * historical immunization information.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: HealthDocumentTitle</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentTitle</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.HealthDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>The title of the Health Document</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentTitle</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.HealthDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>The title of the Health Document</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentTitle</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.HealthDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>The title of the Health Document</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: HealthDocumentTitle</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentTitle</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.HealthDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>The title of the Health Document</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentTitle</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.HealthDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>The title of the Health Document</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentTitle</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.HealthDocument.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>The title of the Health Document</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: HealthDocumentText</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentText</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.HealthDocument.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>Contains the body of the health document that is the 
     * basis of the immunization information.</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentText</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.HealthDocument.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>Contains the body of the health document that is the 
     * basis of the immunization information.</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentText</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.HealthDocument.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>Contains the body of the health document that is the 
     * basis of the immunization information.</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: HealthDocumentText</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentText</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.HealthDocument.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>Contains the body of the health document that is the 
     * basis of the immunization information.</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentText</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.HealthDocument.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>Contains the body of the health document that is the 
     * basis of the immunization information.</p>
     * 
     * <p>Un-merged Business Name: HealthDocumentText</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.HealthDocument.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p>
     * 
     * <p>Contains the body of the health document that is the 
     * basis of the immunization information.</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }

}
