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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt050007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT050007CA.Person"})
public class PersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20150318L;
    private PN name = new PNImpl();
    private CV administrativeGenderCode = new CVImpl();
    private TS birthTime = new TSImpl();
    private BL deceasedInd = new BLImpl();
    private TS deceasedTime = new TSImpl();
    private List<OtherIdentifiersBean> asIdentifiedEntity = new ArrayList<OtherIdentifiersBean>();


    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used, with other patient identity attributes, to confirm 
     * patient identity, as well as when addressing the patient. 
     * Element is populated because the patient's name is 
     * frequently necessary for positive identification of the 
     * patient in the jurisdictional client registry.</p>
     * 
     * <p>The name by which the patient is known and which apply to 
     * a particular clinical action that has been reported or 
     * recorded.</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used, with other patient identity attributes, to confirm 
     * patient identity, as well as when addressing the patient. 
     * Element is populated because the patient's name is 
     * frequently necessary for positive identification of the 
     * patient in the jurisdictional client registry.</p>
     * 
     * <p>The name by which the patient is known and which apply to 
     * a particular clinical action that has been reported or 
     * recorded.</p>
     */
    public void setName(PersonName name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: D:Patient Gender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050007CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p>
     * 
     * <p>Indicates the gender (sex) of the patient. Complex 
     * genetic genders are handled as observations if they are 
     * considered relevant.</p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getAdministrativeGenderCode() {
        return (AdministrativeGender) this.administrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: D:Patient Gender</p>
     * 
     * <p>Relationship: 
     * COCT_MT050007CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p>
     * 
     * <p>Indicates the gender (sex) of the patient. Complex 
     * genetic genders are handled as observations if they are 
     * considered relevant.</p>
     */
    public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>Business Name: C: Patient Birth Datetime</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    @Hl7XmlMapping({"birthTime"})
    public Date getBirthTime() {
        return this.birthTime.getValue();
    }

    /**
     * <p>Business Name: C: Patient Birth Datetime</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to confirm patient identity.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    public void setBirthTime(Date birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Business Name: G:Patient Deceased Indicator</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates whether the patient is deceased.</p>
     */
    @Hl7XmlMapping({"deceasedInd"})
    public Boolean getDeceasedInd() {
        return this.deceasedInd.getValue();
    }

    /**
     * <p>Business Name: G:Patient Deceased Indicator</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates whether the patient is deceased.</p>
     */
    public void setDeceasedInd(Boolean deceasedInd) {
        this.deceasedInd.setValue(deceasedInd);
    }


    /**
     * <p>Business Name: H:Patient Deceased Datetime</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time the patient died or was ruled 
     * &quot;deceased.&quot;</p>
     */
    @Hl7XmlMapping({"deceasedTime"})
    public Date getDeceasedTime() {
        return this.deceasedTime.getValue();
    }

    /**
     * <p>Business Name: H:Patient Deceased Datetime</p>
     * 
     * <p>Relationship: COCT_MT050007CA.Person.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time the patient died or was ruled 
     * &quot;deceased.&quot;</p>
     */
    public void setDeceasedTime(Date deceasedTime) {
        this.deceasedTime.setValue(deceasedTime);
    }


    /**
     * <p>Relationship: COCT_MT050007CA.Person.asIdentifiedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-4)</p>
     */
    @Hl7XmlMapping({"asIdentifiedEntity"})
    public List<OtherIdentifiersBean> getAsIdentifiedEntity() {
        return this.asIdentifiedEntity;
    }

}
