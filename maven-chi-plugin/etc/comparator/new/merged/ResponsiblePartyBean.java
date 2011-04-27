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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT301010CA.ResponsibleParty","PRPM_MT303010CA.ResponsibleParty","PRPM_MT306011CA.ResponsibleParty","PRPM_MT309000CA.ResponsibleParty"})
public class ResponsiblePartyBean extends MessagePartBean {

    private CS<ParticipationType> typeCode = new CSImpl<ParticipationType>();
    private II restrictionsToPracticeIdentifier = new IIImpl();
    private CV<ActCode> restrictionsToPracticeType = new CVImpl<ActCode>();
    private BL restrictionsToPracticeNegationIndicator = new BLImpl();
    private ST restrictionsToPracticeText = new STImpl();
    private IVL<TS, Interval<Date>> restrictionsToPracticeEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private CV<Confidentiality> restrictionsToPracticeConfidentialityCode = new CVImpl<Confidentiality>();
    private List<Subject4Bean> privilegeSubjectOf = new ArrayList<Subject4Bean>();

    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return this.typeCode.getValue();
    }
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }

    @Hl7XmlMapping({"privilege/id"})
    public Identifier getRestrictionsToPracticeIdentifier() {
        return this.restrictionsToPracticeIdentifier.getValue();
    }
    public void setRestrictionsToPracticeIdentifier(Identifier restrictionsToPracticeIdentifier) {
        this.restrictionsToPracticeIdentifier.setValue(restrictionsToPracticeIdentifier);
    }

    @Hl7XmlMapping({"privilege/code"})
    public ActCode getRestrictionsToPracticeType() {
        return this.restrictionsToPracticeType.getValue();
    }
    public void setRestrictionsToPracticeType(ActCode restrictionsToPracticeType) {
        this.restrictionsToPracticeType.setValue(restrictionsToPracticeType);
    }

    @Hl7XmlMapping({"privilege/negationInd"})
    public java.lang.Boolean getRestrictionsToPracticeNegationIndicator() {
        return this.restrictionsToPracticeNegationIndicator.getValue();
    }
    public void setRestrictionsToPracticeNegationIndicator(java.lang.Boolean restrictionsToPracticeNegationIndicator) {
        this.restrictionsToPracticeNegationIndicator.setValue(restrictionsToPracticeNegationIndicator);
    }

    @Hl7XmlMapping({"privilege/text"})
    public java.lang.String getRestrictionsToPracticeText() {
        return this.restrictionsToPracticeText.getValue();
    }
    public void setRestrictionsToPracticeText(java.lang.String restrictionsToPracticeText) {
        this.restrictionsToPracticeText.setValue(restrictionsToPracticeText);
    }

    @Hl7XmlMapping({"privilege/effectiveTime"})
    public Interval<Date> getRestrictionsToPracticeEffectiveDate() {
        return this.restrictionsToPracticeEffectiveDate.getValue();
    }
    public void setRestrictionsToPracticeEffectiveDate(Interval<Date> restrictionsToPracticeEffectiveDate) {
        this.restrictionsToPracticeEffectiveDate.setValue(restrictionsToPracticeEffectiveDate);
    }

    @Hl7XmlMapping({"privilege/confidentialityCode"})
    public Confidentiality getRestrictionsToPracticeConfidentialityCode() {
        return this.restrictionsToPracticeConfidentialityCode.getValue();
    }
    public void setRestrictionsToPracticeConfidentialityCode(Confidentiality restrictionsToPracticeConfidentialityCode) {
        this.restrictionsToPracticeConfidentialityCode.setValue(restrictionsToPracticeConfidentialityCode);
    }

    @Hl7XmlMapping({"privilege/subjectOf"})
    public List<Subject4Bean> getPrivilegeSubjectOf() {
        return this.privilegeSubjectOf;
    }

}
