/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Privilege</p>
 * 
 * <p>PRPM_MT303010CA.Privilege: Privilege</p>
 * 
 * <p><p>A record of something that is being done, has been 
 * done, can be done, or is intended or requested to be done. 
 * In this instance it is a description of the privilege 
 * associated with the specified healthcare providers' 
 * practice</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * privileges associated with the specified healthcare 
 * provider</p></p>
 * 
 * <p>PRPM_MT309000CA.Privilege: Privilege</p>
 * 
 * <p><p>A record of something that is being done, has been 
 * done, can be done, or is intended or requested to be done. 
 * In this instance it is a description of the privilege 
 * associated with the specified healthcare providers' 
 * practice</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * privileges associated with the specified healthcare 
 * provider</p></p>
 * 
 * <p>PRPM_MT301010CA.Privilege: Privilege</p>
 * 
 * <p><p>A record of something that is being done, has been 
 * done, can be done, or is intended or requested to be done. 
 * In this instance it is a description of the privilege 
 * associated with the specified healthcare providers' 
 * practice</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * privileges associated with the specified healthcare 
 * provider</p></p>
 * 
 * <p><p>Any ACT could be the subject of a Privilege, hence the 
 * Classcode=ACT</p></p>
 * 
 * <p>PRPM_MT306011CA.Privilege: Privilege</p>
 * 
 * <p><p>A record of something that is being done, has been 
 * done, can be done, or is intended or requested to be done. 
 * In this instance it is a description of the privilege 
 * associated with the specified healthcare providers' 
 * practice</p></p>
 * 
 * <p><p>Supports the business requirement to identify 
 * privileges associated with the specified healthcare 
 * provider</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.Privilege","PRPM_MT303010CA.Privilege","PRPM_MT306011CA.Privilege","PRPM_MT309000CA.Privilege"})
public class PrivilegeBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private List<PrivilegeCategorizationBean> subjectOfPrivilegeCategorization = new ArrayList<PrivilegeCategorizationBean>();


    /**
     * <p>RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Restrictions to Practice Identifier</p>
     * 
     * <p><p>Unique identifier for the restriction.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p>Restrictions to Practice Identifier</p>
     * 
     * <p><p>Unique identifier for the restriction.</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>RestrictionsToPracticeType</p>
     * 
     * <p>Restrictions to Practice Type</p>
     * 
     * <p><p>Type of restriction.</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p><p>If Restrictions to Practice are included in the 
     * message, then Type Must Exist</p></p>
     * 
     * <p>Restrictions to Practice Type</p>
     * 
     * <p><p>Type of restriction.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p><p>If Restrictions to Practice are included in the 
     * message, then Type Must Exist</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Restrictions to Practice Negation Indicator</p>
     * 
     * <p><p>Indicating that the privilege is a restriction.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>RestrictionsToPracticeText</p>
     * 
     * <p>Restrictions to Practice Text</p>
     * 
     * <p><p>Comments pertaining to the restriction.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Restrictions to Practice Type</p>
     * 
     * <p><p>Effective date of the restriction.</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p><p>If Restrictions to Practice are included in the 
     * message, then Effective Date Must Exist</p></p>
     * 
     * <p>Restrictions to Practice Effective Date</p>
     * 
     * <p><p>Effective date of the restriction.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p><p>If Restrictions to Practice are included in the 
     * message, then Effective Date Must Exist</p></p>
     * 
     * <p>Restrictions to Practice Effective Date</p>
     * 
     * <p><p>Effective date of the restriction.</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p><p>If Restrictions to Practice are included in the 
     * message, then Effective Date Must Exist</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Restrictions to Practice Confidentiality Code</p>
     * 
     * <p><p>dicates the degree to which the restriction to 
     * practice is to be kept confidential.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p><p>Data in the EHR may at some point (and in some 
     * jurisdictions) be accessed directly by patients. Some health 
     * information may be deemed inappropriate for direct access by 
     * patients and requires interpretation by a clinician (e.g. 
     * prescription of placebos, analysis of certain psychiatric 
     * conditions, etc) Even where direct access by patient is not 
     * provided, there may need to be guidance to other providers 
     * viewing the record where care should be used in disclosing 
     * information to the patient. Non-clinical data (e.g. 
     * demographics) may need to be flagged as not for disclosure 
     * to patient and or next of kin. There may be professional 
     * policy and or legislative guidelines about when/if records 
     * may be flagged as not for direct disclosure.</p></p>
     * 
     * <p>Restrictions to Practice Confidentiality Code</p>
     * 
     * <p><p>Indicates the degree to which the restriction to 
     * practice is to be kept confidential.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p><p>Data in the EHR may at some point (and in some 
     * jurisdictions) be accessed directly by patients. Some health 
     * information may be deemed inappropriate for direct access by 
     * patients and requires interpretation by a clinician (e.g. 
     * prescription of placebos, analysis of certain psychiatric 
     * conditions, etc) Even where direct access by patient is not 
     * provided, there may need to be guidance to other providers 
     * viewing the record where care should be used in disclosing 
     * information to the patient. Non-clinical data (e.g. 
     * demographics) may need to be flagged as not for disclosure 
     * to patient and or next of kin. There may be professional 
     * policy and or legislative guidelines about when/if records 
     * may be flagged as not for direct disclosure.</p></p>
     * 
     * <p>Restrictions to Practice Confidentiality Code</p>
     * 
     * <p><p>Indicates the degree to which the restriction to 
     * practice is to be kept confidential.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    @Hl7XmlMapping({"subjectOf/privilegeCategorization"})
    public List<PrivilegeCategorizationBean> getSubjectOfPrivilegeCategorization() {
        return this.subjectOfPrivilegeCategorization;
    }

}
