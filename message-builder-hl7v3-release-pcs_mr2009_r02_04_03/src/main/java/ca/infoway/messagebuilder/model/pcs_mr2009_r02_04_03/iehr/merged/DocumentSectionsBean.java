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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.DocumentSectionType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: DocumentSections</p>
 * 
 * <p>REPC_MT220001CA.SubSection: Document Sections</p>
 * 
 * <p>Provides contextual information for understanding the 
 * Discharge-Care Summary by sharing a filtered, rendered view 
 * of portions of the patient's record.</p>
 * 
 * <p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p>
 * 
 * <p>REPC_MT230003CA.SubSection: Document Sections</p>
 * 
 * <p>Provides contextual information for understanding the 
 * Clinical Observation Document by sharing a filtered, 
 * rendered view of portions of the patient's record.</p>
 * 
 * <p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p>
 * 
 * <p>REPC_MT220003CA.SubSection: Document Sections</p>
 * 
 * <p>Provides contextual information for understanding the 
 * Discharge-Care Summary by sharing a filtered, rendered view 
 * of portions of the patient's record.</p>
 * 
 * <p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p>
 * 
 * <p>REPC_MT210003CA.SubSection: Document Sections</p>
 * 
 * <p>Provides contextual information for understanding the 
 * Referral by sharing a filtered, rendered view of portions of 
 * the patient's record.</p>
 * 
 * <p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p>
 * 
 * <p>REPC_MT230001CA.SubSection: Document Sections</p>
 * 
 * <p>Provides contextual information for understanding the 
 * Clinical Observation Document by sharing a filtered, 
 * rendered view of portions of the patient's record.</p>
 * 
 * <p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p>
 */
@Hl7PartTypeMapping({"REPC_MT210001CA.SubSection","REPC_MT210003CA.SubSection","REPC_MT220001CA.SubSection","REPC_MT220003CA.SubSection","REPC_MT230001CA.SubSection","REPC_MT230003CA.SubSection"})
public class DocumentSectionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private List<II> componentReferenceId = new ArrayList<II>();


    /**
     * <p>Business Name: SectionType</p>
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT220001CA.SubSection.code</p>
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
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT230003CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Section Type is used for searching and for organizing 
     * Clinical Observation Document records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p><p> <i>The element uses CWE to 
     * allow for the capture of Section Type concepts not presently 
     * supported by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>Examples: allergy 
     * list, problem list, medication list, etc.</p>
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT210003CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Section Type is used for searching and for organizing 
     * Referral records as well as sorting them for 
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
     * <p> <i>Identifies the type of Referral represented by this 
     * record.</i> </p><p>Examples: allergy list, problem list, 
     * medication list, etc.</p>
     * 
     * <p>Un-merged Business Name: SectionType</p>
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
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT230001CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Section Type is used for searching and for organizing 
     * Clinical Observation Document records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p><p> <i>The element uses CWE to 
     * allow for the capture of Section Type concepts not presently 
     * supported by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>Examples: allergy 
     * list, problem list, medication list, etc.</p>
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT210001CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public DocumentSectionType getCode() {
        return (DocumentSectionType) this.code.getValue();
    }

    /**
     * <p>Business Name: SectionType</p>
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT220001CA.SubSection.code</p>
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
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT230003CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Section Type is used for searching and for organizing 
     * Clinical Observation Document records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p><p> <i>The element uses CWE to 
     * allow for the capture of Section Type concepts not presently 
     * supported by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>Examples: allergy 
     * list, problem list, medication list, etc.</p>
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT210003CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Section Type is used for searching and for organizing 
     * Referral records as well as sorting them for 
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
     * <p> <i>Identifies the type of Referral represented by this 
     * record.</i> </p><p>Examples: allergy list, problem list, 
     * medication list, etc.</p>
     * 
     * <p>Un-merged Business Name: SectionType</p>
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
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT230001CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Section Type is used for searching and for organizing 
     * Clinical Observation Document records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p><p> <i>The element uses CWE to 
     * allow for the capture of Section Type concepts not presently 
     * supported by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>Examples: allergy 
     * list, problem list, medication list, etc.</p>
     * 
     * <p>Un-merged Business Name: SectionType</p>
     * 
     * <p>Relationship: REPC_MT210001CA.SubSection.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(DocumentSectionType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: SectionTitle</p>
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT220001CA.SubSection.title</p>
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
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT230003CA.SubSection.title</p>
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
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT210003CA.SubSection.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human readable label for the section. Because 
     * it is used as part of the document rendering, the attribute 
     * is mandatory.</p>
     * 
     * <p>Represents the label associated with this particular 
     * portion of the document. These are human-readable 
     * equivalents to the Section Type code. E.g. 
     * &quot;Allergies&quot;, &quot;Assessment&quot;, 
     * &quot;Recommendations&quot;, etc.</p>
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
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
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT230001CA.SubSection.title</p>
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
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT210001CA.SubSection.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: SectionTitle</p>
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT220001CA.SubSection.title</p>
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
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT230003CA.SubSection.title</p>
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
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT210003CA.SubSection.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human readable label for the section. Because 
     * it is used as part of the document rendering, the attribute 
     * is mandatory.</p>
     * 
     * <p>Represents the label associated with this particular 
     * portion of the document. These are human-readable 
     * equivalents to the Section Type code. E.g. 
     * &quot;Allergies&quot;, &quot;Assessment&quot;, 
     * &quot;Recommendations&quot;, etc.</p>
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
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
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT230001CA.SubSection.title</p>
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
     * 
     * <p>Un-merged Business Name: SectionTitle</p>
     * 
     * <p>Relationship: REPC_MT210001CA.SubSection.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: SectionContent</p>
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT220001CA.SubSection.text</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT230003CA.SubSection.text</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT210003CA.SubSection.text</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT230001CA.SubSection.text</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT210001CA.SubSection.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: SectionContent</p>
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT220001CA.SubSection.text</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT230003CA.SubSection.text</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT210003CA.SubSection.text</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT230001CA.SubSection.text</p>
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
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT210001CA.SubSection.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: ReferenceRecordLinks</p>
     * 
     * <p>Un-merged Business Name: ReferenceRecordLinks</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Reference.id</p>
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
     * 
     * <p>Un-merged Business Name: ReferenceRecordLinks</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Reference.id</p>
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
     * 
     * <p>Un-merged Business Name: ReferenceRecordLinks</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Reference.id</p>
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
     * 
     * <p>Un-merged Business Name: ReferenceRecordLinks</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Reference.id</p>
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
     * 
     * <p>Un-merged Business Name: ReferenceRecordLinks</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Reference.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/reference/id"})
    public List<Identifier> getComponentReferenceId() {
        return new RawListWrapper<II, Identifier>(componentReferenceId, IIImpl.class);
    }

}
