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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.RestrictionToPracticeType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Privilege</p>
 * 
 * <p>PRPM_MT303010CA.Privilege: Privilege</p>
 * 
 * <p>Supports the business requirement to identify privileges 
 * associated with the specified healthcare provider</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done. In this 
 * instance it is a description of the privilege associated 
 * with the specified healthcare providers' practice</p>
 * 
 * <p>PRPM_MT309000CA.Privilege: Privilege</p>
 * 
 * <p>Supports the business requirement to identify privileges 
 * associated with the specified healthcare provider</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done. In this 
 * instance it is a description of the privilege associated 
 * with the specified healthcare providers' practice</p>
 * 
 * <p>PRPM_MT301010CA.Privilege: Privilege</p>
 * 
 * <p>Supports the business requirement to identify privileges 
 * associated with the specified healthcare provider</p>
 * 
 * <p>Any ACT could be the subject of a Privilege, hence the 
 * Classcode=ACT</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done. In this 
 * instance it is a description of the privilege associated 
 * with the specified healthcare providers' practice</p>
 * 
 * <p>PRPM_MT306011CA.Privilege: Privilege</p>
 * 
 * <p>Supports the business requirement to identify privileges 
 * associated with the specified healthcare provider</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done. In this 
 * instance it is a description of the privilege associated 
 * with the specified healthcare providers' practice</p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.Privilege","PRPM_MT303010CA.Privilege","PRPM_MT306011CA.Privilege","PRPM_MT309000CA.Privilege"})
public class PrivilegeBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private ST text = new STImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private List<PrivilegeCategorizationBean> subjectOfPrivilegeCategorization = new ArrayList<PrivilegeCategorizationBean>();


    /**
     * <p>Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Unique identifier for the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Unique identifier for the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT309000CA.Privilege.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Unique identifier for the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Unique identifier for the restriction.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Unique identifier for the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Unique identifier for the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT309000CA.Privilege.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Unique identifier for the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Unique identifier for the restriction.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Type Must Exist</p>
     * 
     * <p>Type of restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Type Must Exist</p>
     * 
     * <p>Type of restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Type Must Exist</p>
     * 
     * <p>Type of restriction.</p>
     */
    @Hl7XmlMapping({"code"})
    public RestrictionToPracticeType getCode() {
        return (RestrictionToPracticeType) this.code.getValue();
    }

    /**
     * <p>Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Type Must Exist</p>
     * 
     * <p>Type of restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Type Must Exist</p>
     * 
     * <p>Type of restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Type Must Exist</p>
     * 
     * <p>Type of restriction.</p>
     */
    public void setCode(RestrictionToPracticeType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Indicating that the privilege is a restriction.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Indicating that the privilege is a restriction.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Indicating that the privilege is a restriction.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Indicating that the privilege is a restriction.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Indicating that the privilege is a restriction.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeNegationIndicator</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Indicating that the privilege is a restriction.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: RestrictionsToPracticeText</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeText</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Comments pertaining to the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeText</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Comments pertaining to the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeText</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Comments pertaining to the restriction.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: RestrictionsToPracticeText</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeText</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Comments pertaining to the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeText</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Comments pertaining to the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeText</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Comments pertaining to the restriction.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeEffectiveDate</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Effective Date Must Exist</p>
     * 
     * <p>Effective date of the restriction.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeEffectiveDate</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Effective Date Must Exist</p>
     * 
     * <p>Effective date of the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Relationship: PRPM_MT309000CA.Privilege.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Effective Date Must Exist</p>
     * 
     * <p>Effective date of the restriction.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeEffectiveDate</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Effective Date Must Exist</p>
     * 
     * <p>Effective date of the restriction.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeEffectiveDate</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Privilege.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Effective Date Must Exist</p>
     * 
     * <p>Effective date of the restriction.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeEffectiveDate</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Privilege.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Effective Date Must Exist</p>
     * 
     * <p>Effective date of the restriction.</p>
     * 
     * <p>Un-merged Business Name: RestrictionsToPracticeType</p>
     * 
     * <p>Relationship: PRPM_MT309000CA.Privilege.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Effective Date Must Exist</p>
     * 
     * <p>Effective date of the restriction.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeEffectiveDate</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Privilege.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>If Restrictions to Practice are included in the message, 
     * then Effective Date Must Exist</p>
     * 
     * <p>Effective date of the restriction.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.Privilege.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Data in the EHR may at some point (and in some 
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
     * may be flagged as not for direct disclosure.</p>
     * 
     * <p>dicates the degree to which the restriction to practice 
     * is to be kept confidential.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.Privilege.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Indicates the degree to which the restriction to practice 
     * is to be kept confidential.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.Privilege.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Data in the EHR may at some point (and in some 
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
     * may be flagged as not for direct disclosure.</p>
     * 
     * <p>Indicates the degree to which the restriction to practice 
     * is to be kept confidential.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.Privilege.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Data in the EHR may at some point (and in some 
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
     * may be flagged as not for direct disclosure.</p>
     * 
     * <p>dicates the degree to which the restriction to practice 
     * is to be kept confidential.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.Privilege.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Indicates the degree to which the restriction to practice 
     * is to be kept confidential.</p>
     * 
     * <p>Un-merged Business Name: 
     * RestrictionsToPracticeConfidentialityCode</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.Privilege.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p>
     * 
     * <p>Data in the EHR may at some point (and in some 
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
     * may be flagged as not for direct disclosure.</p>
     * 
     * <p>Indicates the degree to which the restriction to practice 
     * is to be kept confidential.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.Subject4.privilegeCategorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.Subject4.privilegeCategorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT309000CA.Subject4.privilegeCategorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.Subject4.privilegeCategorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/privilegeCategorization"})
    public List<PrivilegeCategorizationBean> getSubjectOfPrivilegeCategorization() {
        return this.subjectOfPrivilegeCategorization;
    }

}
