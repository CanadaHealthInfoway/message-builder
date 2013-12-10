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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010120ON.MedicalDirectiveInfo","PORX_MT060160ON.MedicalDirectiveInfo"})
public class MedicalDirectiveInfoBean extends MessagePartBean implements ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt060160on.DelegatedChoice, ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt010120on.DelegatedChoice {

    private static final long serialVersionUID = 20131210L;
    private II id = new IIImpl();
    private ST title = new STImpl();
    private PN responsiblePartyDelegatorHealthCarePersonName = new PNImpl();


    /**
     * <p>Business Name: MedicalDirectiveId</p>
     * 
     * <p>Un-merged Business Name: MedicalDirectiveId</p>
     * 
     * <p>Relationship: PORX_MT060160ON.MedicalDirectiveInfo.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: MedicalDirectiveId</p>
     * 
     * <p>Relationship: PORX_MT010120ON.MedicalDirectiveInfo.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: MedicalDirectiveId</p>
     * 
     * <p>Un-merged Business Name: MedicalDirectiveId</p>
     * 
     * <p>Relationship: PORX_MT060160ON.MedicalDirectiveInfo.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: MedicalDirectiveId</p>
     * 
     * <p>Relationship: PORX_MT010120ON.MedicalDirectiveInfo.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: MedicalDirectiveName</p>
     * 
     * <p>Un-merged Business Name: MedicalDirectiveName</p>
     * 
     * <p>Relationship: PORX_MT060160ON.MedicalDirectiveInfo.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: MedicalDirectiveName</p>
     * 
     * <p>Relationship: PORX_MT010120ON.MedicalDirectiveInfo.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: MedicalDirectiveName</p>
     * 
     * <p>Un-merged Business Name: MedicalDirectiveName</p>
     * 
     * <p>Relationship: PORX_MT060160ON.MedicalDirectiveInfo.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: MedicalDirectiveName</p>
     * 
     * <p>Relationship: PORX_MT010120ON.MedicalDirectiveInfo.title</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: DelegatorName</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DelegatorName</p>
     * 
     * <p>Relationship: PORX_MT010120ON.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/delegator/healthCarePerson/name"})
    public PersonName getResponsiblePartyDelegatorHealthCarePersonName() {
        return this.responsiblePartyDelegatorHealthCarePersonName.getValue();
    }

    /**
     * <p>Business Name: DelegatorName</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160ON.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DelegatorName</p>
     * 
     * <p>Relationship: PORX_MT010120ON.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setResponsiblePartyDelegatorHealthCarePersonName(PersonName responsiblePartyDelegatorHealthCarePersonName) {
        this.responsiblePartyDelegatorHealthCarePersonName.setValue(responsiblePartyDelegatorHealthCarePersonName);
    }

}
