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
package ca.infoway.messagebuilder.model.ccda_r1_1.fetussubjectcontext;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS_R2;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.List;



@Hl7PartTypeMapping({"FetusSubjectContext.SubjectPerson"})
public class SubjectPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20150202L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private PN name = new PNImpl();
    private CE_R2 administrativeGenderCode = new CE_R2Impl();
    private TS_R2 birthTime = new TS_R2Impl();
    private BL deceasedInd = new BLImpl();
    private TS_R2 deceasedTime = new TS_R2Impl();


    /**
     * <p>Relationship: FetusSubjectContext.SubjectPerson.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: FetusSubjectContext.SubjectPerson.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: FetusSubjectContext.SubjectPerson.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * FetusSubjectContext.SubjectPerson.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: FetusSubjectContext.SubjectPerson.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: FetusSubjectContext.SubjectPerson.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }

    /**
     * <p>Relationship: FetusSubjectContext.SubjectPerson.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setName(PersonName name) {
        this.name.setValue(name);
    }


    /**
     * <p>Relationship: 
     * FetusSubjectContext.SubjectPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public CodedTypeR2<Code> getAdministrativeGenderCode() {
        return (CodedTypeR2<Code>) this.administrativeGenderCode.getValue();
    }

    /**
     * <p>Relationship: 
     * FetusSubjectContext.SubjectPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAdministrativeGenderCode(CodedTypeR2<Code> administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }


    /**
     * <p>Relationship: FetusSubjectContext.SubjectPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"birthTime"})
    public MbDate getBirthTime() {
        return this.birthTime.getValue();
    }

    /**
     * <p>Relationship: FetusSubjectContext.SubjectPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setBirthTime(MbDate birthTime) {
        this.birthTime.setValue(birthTime);
    }


    /**
     * <p>Relationship: 
     * FetusSubjectContext.SubjectPerson.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"deceasedInd"})
    public Boolean getDeceasedInd() {
        return this.deceasedInd.getValue();
    }

    /**
     * <p>Relationship: 
     * FetusSubjectContext.SubjectPerson.deceasedInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDeceasedInd(Boolean deceasedInd) {
        this.deceasedInd.setValue(deceasedInd);
    }


    /**
     * <p>Relationship: 
     * FetusSubjectContext.SubjectPerson.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"deceasedTime"})
    public MbDate getDeceasedTime() {
        return this.deceasedTime.getValue();
    }

    /**
     * <p>Relationship: 
     * FetusSubjectContext.SubjectPerson.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDeceasedTime(MbDate deceasedTime) {
        this.deceasedTime.setValue(deceasedTime);
    }

}