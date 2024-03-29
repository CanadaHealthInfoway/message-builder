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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.si.rcmr_mt010002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt910107ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.si.merged.Consenter;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.si.merged.PatientBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Keyword</p>
 * 
 * <p>Allows a patient to control access to their health 
 * information. Provides authorization for providers to view 
 * patient information.</p>
 * 
 * <p>Information pertaining to a patient's secret password 
 * used to control access to his/her health information.</p>
 */
@Hl7PartTypeMapping({"RCMR_MT010002CA.KeywordEvent"})
@Hl7RootType
public class KeywordBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private ST authorSignatureText = new STImpl();
    private Consenter authorConsenter;
    private List<CV> subjectRecordTypeCode = new ArrayList<CV>();


    /**
     * <p>Business Name: Keyword</p>
     * 
     * <p>Relationship: RCMR_MT010002CA.Author.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows patients to change their keyword. If explicitly 
     * set to null, removes the keyword for the identified record 
     * types. Because of this, the attribute is set to 
     * 'populated'.</p>
     * 
     * <p>Indicate the keyword associated with a particular 
     * consent.</p>
     */
    @Hl7XmlMapping({"author/signatureText"})
    public String getAuthorSignatureText() {
        return this.authorSignatureText.getValue();
    }

    /**
     * <p>Business Name: Keyword</p>
     * 
     * <p>Relationship: RCMR_MT010002CA.Author.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows patients to change their keyword. If explicitly 
     * set to null, removes the keyword for the identified record 
     * types. Because of this, the attribute is set to 
     * 'populated'.</p>
     * 
     * <p>Indicate the keyword associated with a particular 
     * consent.</p>
     */
    public void setAuthorSignatureText(String authorSignatureText) {
        this.authorSignatureText.setValue(authorSignatureText);
    }


    /**
     * <p>Relationship: RCMR_MT010002CA.Author.consenter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/consenter"})
    public Consenter getAuthorConsenter() {
        return this.authorConsenter;
    }

    /**
     * <p>Relationship: RCMR_MT010002CA.Author.consenter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorConsenter(Consenter authorConsenter) {
        this.authorConsenter = authorConsenter;
    }

    public PatientBean getAuthorConsenterAsPatient() {
        return this.authorConsenter instanceof PatientBean ? (PatientBean) this.authorConsenter : null;
    }
    public boolean hasAuthorConsenterAsPatient() {
        return (this.authorConsenter instanceof PatientBean);
    }

    public RelatedPersonBean getAuthorConsenterAsPersonalRelationship() {
        return this.authorConsenter instanceof RelatedPersonBean ? (RelatedPersonBean) this.authorConsenter : null;
    }
    public boolean hasAuthorConsenterAsPersonalRelationship() {
        return (this.authorConsenter instanceof RelatedPersonBean);
    }


    /**
     * <p>Business Name: B:Consent Information Types</p>
     * 
     * <p>Relationship: RCMR_MT010002CA.RecordType.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Different keywords may be needed to access different 
     * types of patient information (e.g. demographics, 
     * medications, allergies, lab results). Understanding the type 
     * of information the keyword applies to is critical, and 
     * therefore the attribute is mandatory.</p>
     * 
     * <p>The type of patient information that can be accessed or 
     * modified. Examples are: demographics, medications, lab, DI, 
     * etc</p><p>The keyword revisioning process may also involve 
     * revising the list of information types covered by the 
     * keyword.</p>
     */
    @Hl7XmlMapping({"subject/recordType/code"})
    public List<ActInformationAccessTypeCode> getSubjectRecordTypeCode() {
        return new RawListWrapper<CV, ActInformationAccessTypeCode>(subjectRecordTypeCode, CVImpl.class);
    }

}
