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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged;

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
 * <p>REPC_MT000083CA.SubSection: Document Sections</p>
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
 * 
 * <p>REPC_MT210001CA.SubSection: Document Sections</p>
 * 
 * <p>Provides contextual information for understanding the 
 * Referral by sharing a filtered, rendered view of portions of 
 * the patient's record.</p>
 * 
 * <p>Used to document additional relevant information about 
 * the patient such as allergies, medications, problem list, 
 * etc.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000083CA.SubSection","REPC_MT210001CA.SubSection","REPC_MT210003CA.SubSection","REPC_MT220001CA.SubSection","REPC_MT220003CA.SubSection","REPC_MT230001CA.SubSection","REPC_MT230003CA.SubSection"})
public class DocumentSectionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20151013L;
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private List<ReferenceBean> componentReference = new ArrayList<ReferenceBean>();


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
     * <p>Relationship: REPC_MT000083CA.SubSection.code</p>
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
     * <p>Relationship: REPC_MT000083CA.SubSection.code</p>
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
     * <p>Relationship: REPC_MT000083CA.SubSection.title</p>
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
     * portion of the document. These are a human-readable 
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
     * <p>Relationship: REPC_MT000083CA.SubSection.title</p>
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
     * portion of the document. These are a human-readable 
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
     * coveys the content, the attribute mus be mandatory.</p>
     * 
     * <p>Represents the rendered text content for the section.</p>
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT000083CA.SubSection.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable view of data that is accessible 
     * without sophisticated PoS applications. Allows data to be 
     * filtered and rendered in a manner to focus on the content 
     * deemed relevant by the author of the document. Because it 
     * coveys the content, the attribute mus be mandatory.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
     * 
     * <p>Represents the rendered text content for the section.</p>
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT210001CA.SubSection.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable view of data that is accessible 
     * without sophisticated PoS applications. Allows data to be 
     * filtered and rendered in a manner to focus on the content 
     * deemed relevant by the author of the document. Because it 
     * coveys the content, the attribute mus be mandatory.</p>
     * 
     * <p>Represents the rendered text content for the section.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
     * 
     * <p>Represents the rendered text content for the section.</p>
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT000083CA.SubSection.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable view of data that is accessible 
     * without sophisticated PoS applications. Allows data to be 
     * filtered and rendered in a manner to focus on the content 
     * deemed relevant by the author of the document. Because it 
     * coveys the content, the attribute mus be mandatory.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
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
     * coveys the content, the attribute mus be mandatory.</p>
     * 
     * <p>Represents the rendered text content for the section.</p>
     * 
     * <p>Un-merged Business Name: SectionContent</p>
     * 
     * <p>Relationship: REPC_MT210001CA.SubSection.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable view of data that is accessible 
     * without sophisticated PoS applications. Allows data to be 
     * filtered and rendered in a manner to focus on the content 
     * deemed relevant by the author of the document. Because it 
     * coveys the content, the attribute mus be mandatory.</p>
     * 
     * <p>Represents the rendered text content for the section.</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Component7.reference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000083CA.Component7.reference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Component7.reference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Component7.reference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Component7.reference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Component7.reference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Component7.reference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/reference"})
    public List<ReferenceBean> getComponentReference() {
        return this.componentReference;
    }

}
