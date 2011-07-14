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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.rcmr_mt010002ca;

import java.util.ArrayList;
import java.util.List;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt040205ca.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.Consenter;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.Patient_1Bean;



/**
 * <p>Keyword</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to a patient's secret password used to control 
 * access to his/her health information.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows a 
 * patient to control access to their health information. 
 * Provides authorization for providers to view patient 
 * information.</p></p>
 */
@Hl7PartTypeMapping({"RCMR_MT010002CA.KeywordEvent"})
@Hl7RootType
public class KeywordBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private ST keyword = new STImpl();
    private Consenter authorConsenter;
    private Patient_1Bean subject1Patient;
    private List<CV> consentInformationTypes = new ArrayList<CV>();


    /**
     * <p>Keyword</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicate the 
     * keyword associated with a particular consent.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZKW.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZZZ.9</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZKW.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZZZ.9</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * patients to change their keyword. If explicitly set to null, 
     * removes the keyword for the identified record types. Because 
     * of this, the attribute is set to 'populated'.</p></p>
     */
    @Hl7XmlMapping({"author/signatureText"})
    public String getKeyword() {
        return this.keyword.getValue();
    }
    public void setKeyword(String keyword) {
        this.keyword.setValue(keyword);
    }


    @Hl7XmlMapping({"author/consenter"})
    public Consenter getAuthorConsenter() {
        return this.authorConsenter;
    }
    public void setAuthorConsenter(Consenter authorConsenter) {
        this.authorConsenter = authorConsenter;
    }

    public PatientBean getAuthorConsenterAsPatient() {
        return this.authorConsenter instanceof PatientBean ? (PatientBean) this.authorConsenter : null;
    }
    public boolean hasAuthorConsenterAsPatient() {
        return (this.authorConsenter instanceof PatientBean);
    }

    public ResponsiblePersonBean getAuthorConsenterAsResponsibleParty() {
        return this.authorConsenter instanceof ResponsiblePersonBean ? (ResponsiblePersonBean) this.authorConsenter : null;
    }
    public boolean hasAuthorConsenterAsResponsibleParty() {
        return (this.authorConsenter instanceof ResponsiblePersonBean);
    }


    @Hl7XmlMapping({"subject1/patient"})
    public Patient_1Bean getSubject1Patient() {
        return this.subject1Patient;
    }
    public void setSubject1Patient(Patient_1Bean subject1Patient) {
        this.subject1Patient = subject1Patient;
    }


    /**
     * <p>B:Consent Information Types</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The type of 
     * patient information that can be accessed or modified. 
     * Examples are: demographics, medications, lab, DI, etc</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The keyword 
     * revisioning process may also involve revising the list of 
     * information types covered by the keyword.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The type of 
     * patient information that can be accessed or modified. 
     * Examples are: demographics, medications, lab, DI, etc</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The keyword 
     * revisioning process may also involve revising the list of 
     * information types covered by the keyword.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Different 
     * keywords may be needed to access different types of patient 
     * information (e.g. demographics, medications, allergies, lab 
     * results). Understanding the type of information the keyword 
     * applies to is critical, and therefore the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"subject2/recordType/code"})
    public List<ActInformationAccessTypeCode> getConsentInformationTypes() {
        return new RawListWrapper<CV, ActInformationAccessTypeCode>(consentInformationTypes, CVImpl.class);
    }

}
