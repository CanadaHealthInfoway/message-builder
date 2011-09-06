/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.domainvalue.DocumentSectionType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>DocumentSections</p>
 * 
 * <p>REPC_MT220001CA.SubSection: Document Sections</p>
 * 
 * <p><p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p></p>
 * 
 * <p><p>Provides contextual information for understanding the 
 * Discharge-Care Summary by sharing a filtered, rendered view 
 * of portions of the patient's record.</p></p>
 * 
 * <p>REPC_MT230003CA.SubSection: Document Sections</p>
 * 
 * <p><p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p></p>
 * 
 * <p><p>Provides contextual information for understanding the 
 * Clinical Observation Document by sharing a filtered, 
 * rendered view of portions of the patient's record.</p></p>
 * 
 * <p>REPC_MT220003CA.SubSection: Document Sections</p>
 * 
 * <p><p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p></p>
 * 
 * <p><p>Provides contextual information for understanding the 
 * Discharge-Care Summary by sharing a filtered, rendered view 
 * of portions of the patient's record.</p></p>
 * 
 * <p>REPC_MT210003CA.SubSection: Document Sections</p>
 * 
 * <p><p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p></p>
 * 
 * <p><p>Provides contextual information for understanding the 
 * Referral by sharing a filtered, rendered view of portions of 
 * the patient's record.</p></p>
 * 
 * <p>REPC_MT230001CA.SubSection: Document Sections</p>
 * 
 * <p><p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p></p>
 * 
 * <p><p>Provides contextual information for understanding the 
 * Clinical Observation Document by sharing a filtered, 
 * rendered view of portions of the patient's record.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT210001CA.SubSection","REPC_MT210003CA.SubSection","REPC_MT220001CA.SubSection","REPC_MT220003CA.SubSection","REPC_MT230001CA.SubSection","REPC_MT230003CA.SubSection"})
public class DocumentSectionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private CV sectionType = new CVImpl();
    private ST sectionTitle = new STImpl();
    private ED<EncapsulatedData> sectionContent = new EDImpl<EncapsulatedData>();
    private List<ReferenceBean> componentReference = new ArrayList<ReferenceBean>();


    /**
     * <p>SectionType</p>
     * 
     * <p>A: Section Type</p>
     * 
     * <p></p><p>Examples: allergy list, problem list, medication 
     * list, etc.</p></p>
     * 
     * <p></p><p>Examples: allergy list, problem list, medication 
     * list, etc.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>A: Section Type</p>
     * 
     * <p>A: Section Type</p>
     * 
     * <p></p><p>Examples: allergy list, problem list, medication 
     * list, etc.</p></p>
     * 
     * <p></p><p>Examples: allergy list, problem list, medication 
     * list, etc.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>A: Section Type</p>
     * 
     * <p></p><p>Examples: allergy list, problem list, medication 
     * list, etc.</p></p>
     * 
     * <p></p><p>Examples: allergy list, problem list, medication 
     * list, etc.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public DocumentSectionType getSectionType() {
        return (DocumentSectionType) this.sectionType.getValue();
    }
    public void setSectionType(DocumentSectionType sectionType) {
        this.sectionType.setValue(sectionType);
    }


    /**
     * <p>SectionTitle</p>
     * 
     * <p>B: Section Title</p>
     * 
     * <p><p>Represents the label associated with this particular 
     * portion of the document. These are a human-readable 
     * equivalents to the Section Type code. E.g. 
     * &quot;Allergies&quot;, &quot;Assessment&quot;, 
     * &quot;Recommendations&quot;, etc.</p></p>
     * 
     * <p><p>Provides a human readable label for the section. 
     * Because it is used as part of the document rendering, the 
     * attribute is mandatory.</p></p>
     * 
     * <p>B: Section Title</p>
     * 
     * <p>B: Section Title</p>
     * 
     * <p><p>Represents the label associated with this particular 
     * portion of the document. These are human-readable 
     * equivalents to the Section Type code. E.g. 
     * &quot;Allergies&quot;, &quot;Assessment&quot;, 
     * &quot;Recommendations&quot;, etc.</p></p>
     * 
     * <p><p>Provides a human readable label for the section. 
     * Because it is used as part of the document rendering, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"title"})
    public String getSectionTitle() {
        return this.sectionTitle.getValue();
    }
    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle.setValue(sectionTitle);
    }


    /**
     * <p>SectionContent</p>
     * 
     * <p>M: Section Content</p>
     * 
     * <p>M: Section Content</p>
     * 
     * <p><p>Represents the rendered text content for the 
     * section.</p></p>
     * 
     * <p><p>Provides a human-readable view of data that is 
     * accessible without sophisticated PoS applications. Allows 
     * data to be filtered and rendered in a manner to focus on the 
     * content deemed relevant by the author of the document. 
     * Because it conveys the content, the attribute must be 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getSectionContent() {
        return this.sectionContent.getValue();
    }
    public void setSectionContent(EncapsulatedData sectionContent) {
        this.sectionContent.setValue(sectionContent);
    }


    @Hl7XmlMapping({"component/reference"})
    public List<ReferenceBean> getComponentReference() {
        return this.componentReference;
    }

}
