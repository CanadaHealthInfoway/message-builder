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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt220003ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DocumentSectionType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged.ReferenceChoice;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Document Sections</p>
 * 
 * <p>Provides contextual information for understanding the 
 * Discharge-Care Summary by sharing a filtered, rendered view 
 * of portions of the patient's record.</p>
 * 
 * <p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p>
 */
@Hl7PartTypeMapping({"REPC_MT220003CA.SubSection"})
public class DocumentSectionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<DocumentSectionsBean> component1SubSection = new ArrayList<DocumentSectionsBean>();
    private List<ReferenceChoice> component2ReferenceChoice = new ArrayList<ReferenceChoice>();


    /**
     * <p>Business Name: A: Section Type</p>
     * 
     * <p>Relationship: REPC_MT220003CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Section Type is used for searching and for organizing 
     * Discharge-Care Summary records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>The element uses CWE to allow for 
     * the capture of Section Type concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p> <i>Identifies the type of Discharge-Care Summary 
     * represented by this record.</i> </p><p>Examples: allergy 
     * list, problem list, medication list, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public DocumentSectionType getCode() {
        return (DocumentSectionType) this.code.getValue();
    }

    /**
     * <p>Business Name: A: Section Type</p>
     * 
     * <p>Relationship: REPC_MT220003CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Section Type is used for searching and for organizing 
     * Discharge-Care Summary records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>The element uses CWE to allow for 
     * the capture of Section Type concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p> <i>Identifies the type of Discharge-Care Summary 
     * represented by this record.</i> </p><p>Examples: allergy 
     * list, problem list, medication list, etc.</p>
     */
    public void setCode(DocumentSectionType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: B: Section Title</p>
     * 
     * <p>Relationship: REPC_MT220003CA.SubSection.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human readable label for the section. Because 
     * it is used as part of the document rendering, the attribute 
     * is mandatory.</p>
     * 
     * <p>Represents the label associated with this particular 
     * portion of the document. These are a human-readable 
     * equivalents to the Section Type code. E.g. 
     * &quot;Allergies&quot;, &quot;Assessment&quot;, 
     * &quot;Recommendations&quot;, etc.</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: B: Section Title</p>
     * 
     * <p>Relationship: REPC_MT220003CA.SubSection.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human readable label for the section. Because 
     * it is used as part of the document rendering, the attribute 
     * is mandatory.</p>
     * 
     * <p>Represents the label associated with this particular 
     * portion of the document. These are a human-readable 
     * equivalents to the Section Type code. E.g. 
     * &quot;Allergies&quot;, &quot;Assessment&quot;, 
     * &quot;Recommendations&quot;, etc.</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: M: Section Content</p>
     * 
     * <p>Relationship: REPC_MT220003CA.SubSection.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable view of data that is accessible 
     * without sophisticated PoS applications. Allows data to be 
     * filtered and rendered in a manner to focus on the content 
     * deemed relevant by the author of the document. Because it 
     * conveys the content, the attribute must be mandatory.</p>
     * 
     * <p>Represents the rendered text content for the section.</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: M: Section Content</p>
     * 
     * <p>Relationship: REPC_MT220003CA.SubSection.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable view of data that is accessible 
     * without sophisticated PoS applications. Allows data to be 
     * filtered and rendered in a manner to focus on the content 
     * deemed relevant by the author of the document. Because it 
     * conveys the content, the attribute must be mandatory.</p>
     * 
     * <p>Represents the rendered text content for the section.</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: Document Section Status</p>
     * 
     * <p>Relationship: REPC_MT220003CA.SubSection.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Document Section Status</p>
     * 
     * <p>Relationship: REPC_MT220003CA.SubSection.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Document Section Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT220003CA.SubSection.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>The value specified for a particular SubSection may be 
     * overridden by a higher level masking applied to an 
     * indication, a care composition, a type of record or even all 
     * patient records.</p>
     * 
     * <p>Communicates the desire of the patient to restrict access 
     * to this SubSection.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: REPC_MT220003CA.Component8.subSection</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/subSection"})
    public List<DocumentSectionsBean> getComponent1SubSection() {
        return this.component1SubSection;
    }


    /**
     * <p>Relationship: REPC_MT220003CA.Component7.referenceChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/referenceChoice"})
    public List<ReferenceChoice> getComponent2ReferenceChoice() {
        return this.component2ReferenceChoice;
    }

}
