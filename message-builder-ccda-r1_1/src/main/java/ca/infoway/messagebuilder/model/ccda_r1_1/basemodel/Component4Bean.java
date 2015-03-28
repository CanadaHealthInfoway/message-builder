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
package ca.infoway.messagebuilder.model.ccda_r1_1.basemodel;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.Component4"})
public class Component4Bean extends MessagePartBean implements ca.infoway.messagebuilder.model.ccda_r1_1.vitalsignsorganizer.Component4Choice, ca.infoway.messagebuilder.model.ccda_r1_1.resultorganizer.Component4Choice, ca.infoway.messagebuilder.model.ccda_r1_1.cognitivestatusresultorganizer.Component4Choice, ca.infoway.messagebuilder.model.ccda_r1_1.functionalstatusresultorganizer.Component4Choice {

    private static final long serialVersionUID = 20150328L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private INT sequenceNumber = new INTImpl();
    private BL seperatableInd = new BLImpl();
    private Component4Choice component4Choice;


    /**
     * <p>Relationship: BaseModel.Component4.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: BaseModel.Component4.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Component4.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: BaseModel.Component4.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: BaseModel.Component4.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Component4.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: BaseModel.Component4.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"seperatableInd"})
    public Boolean getSeperatableInd() {
        return this.seperatableInd.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Component4.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSeperatableInd(Boolean seperatableInd) {
        this.seperatableInd.setValue(seperatableInd);
    }


    /**
     * <p>Relationship: BaseModel.Component4.component4Choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component4Choice"})
    public Component4Choice getComponent4Choice() {
        return this.component4Choice;
    }

    /**
     * <p>Relationship: BaseModel.Component4.component4Choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent4Choice(Component4Choice component4Choice) {
        this.component4Choice = component4Choice;
    }

    public ActBean getComponent4ChoiceAsAct() {
        return this.component4Choice instanceof ActBean ? (ActBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsAct() {
        return (this.component4Choice instanceof ActBean);
    }

    public EncounterBean getComponent4ChoiceAsEncounter() {
        return this.component4Choice instanceof EncounterBean ? (EncounterBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsEncounter() {
        return (this.component4Choice instanceof EncounterBean);
    }

    public ObservationBean getComponent4ChoiceAsObservation() {
        return this.component4Choice instanceof ObservationBean ? (ObservationBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsObservation() {
        return (this.component4Choice instanceof ObservationBean);
    }

    public ObservationMediaBean getComponent4ChoiceAsObservationMedia() {
        return this.component4Choice instanceof ObservationMediaBean ? (ObservationMediaBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsObservationMedia() {
        return (this.component4Choice instanceof ObservationMediaBean);
    }

    public OrganizerBean getComponent4ChoiceAsOrganizer() {
        return this.component4Choice instanceof OrganizerBean ? (OrganizerBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsOrganizer() {
        return (this.component4Choice instanceof OrganizerBean);
    }

    public ProcedureBean getComponent4ChoiceAsProcedure() {
        return this.component4Choice instanceof ProcedureBean ? (ProcedureBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsProcedure() {
        return (this.component4Choice instanceof ProcedureBean);
    }

    public RegionOfInterestBean getComponent4ChoiceAsRegionOfInterest() {
        return this.component4Choice instanceof RegionOfInterestBean ? (RegionOfInterestBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsRegionOfInterest() {
        return (this.component4Choice instanceof RegionOfInterestBean);
    }

    public SubstanceAdministrationBean getComponent4ChoiceAsSubstanceAdministration() {
        return this.component4Choice instanceof SubstanceAdministrationBean ? (SubstanceAdministrationBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsSubstanceAdministration() {
        return (this.component4Choice instanceof SubstanceAdministrationBean);
    }

    public SupplyBean getComponent4ChoiceAsSupply() {
        return this.component4Choice instanceof SupplyBean ? (SupplyBean) this.component4Choice : null;
    }
    public boolean hasComponent4ChoiceAsSupply() {
        return (this.component4Choice instanceof SupplyBean);
    }

}
