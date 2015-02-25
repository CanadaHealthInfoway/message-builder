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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.basemodel;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.domainvalue.x_ActRelationshipEntryRelationship;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.EntryRelationship"})
public class EntryRelationshipBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ccda_pcs_r1_1.reactionobservation.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.immunizationactivity.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.allergyproblemact.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.medicationdispense.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.procedureactivityobservation.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.studyact.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.problemobservation.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.coverageactivity.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.familyhistoryobservation.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.encounteractivities.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationshipChoice_1, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationshipChoice_6, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.policyactivity.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationshipChoice_4, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationshipChoice_3, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.assessmentscaleobservation.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.pressureulcerobservation.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationshipChoice_5, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.sopinstanceobservation.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationshipChoice_7, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.medicationactivity.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.pregnancyobservation.EntryRelationshipChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryRelationshipChoice_2, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.authorizationactivity.EntryRelationshipChoice {

    private static final long serialVersionUID = 20150225L;
    private CS typeCode = new CSImpl();
    private BL inversionInd = new BLImpl();
    private BL contextConductionInd = new BLImpl();
    private BL negationInd = new BLImpl();
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private INT sequenceNumber = new INTImpl();
    private BL seperatableInd = new BLImpl();
    private EntryRelationshipChoice entryRelationshipChoice;


    /**
     * <p>Relationship: BaseModel.EntryRelationship.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public x_ActRelationshipEntryRelationship getTypeCode() {
        return (x_ActRelationshipEntryRelationship) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.EntryRelationship.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(x_ActRelationshipEntryRelationship typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: BaseModel.EntryRelationship.inversionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"inversionInd"})
    public Boolean getInversionInd() {
        return this.inversionInd.getValue();
    }

    /**
     * <p>Relationship: BaseModel.EntryRelationship.inversionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setInversionInd(Boolean inversionInd) {
        this.inversionInd.setValue(inversionInd);
    }


    /**
     * <p>Relationship: 
     * BaseModel.EntryRelationship.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Relationship: 
     * BaseModel.EntryRelationship.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Relationship: BaseModel.EntryRelationship.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Relationship: BaseModel.EntryRelationship.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Relationship: BaseModel.EntryRelationship.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<Code> getRealmCode() {
        return this.realmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: BaseModel.EntryRelationship.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: BaseModel.EntryRelationship.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: BaseModel.EntryRelationship.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: BaseModel.EntryRelationship.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Relationship: BaseModel.EntryRelationship.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: BaseModel.EntryRelationship.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"seperatableInd"})
    public Boolean getSeperatableInd() {
        return this.seperatableInd.getValue();
    }

    /**
     * <p>Relationship: BaseModel.EntryRelationship.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSeperatableInd(Boolean seperatableInd) {
        this.seperatableInd.setValue(seperatableInd);
    }


    /**
     * <p>Relationship: 
     * BaseModel.EntryRelationship.entryRelationshipChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"entryRelationshipChoice"})
    public EntryRelationshipChoice getEntryRelationshipChoice() {
        return this.entryRelationshipChoice;
    }

    /**
     * <p>Relationship: 
     * BaseModel.EntryRelationship.entryRelationshipChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEntryRelationshipChoice(EntryRelationshipChoice entryRelationshipChoice) {
        this.entryRelationshipChoice = entryRelationshipChoice;
    }

    public ActBean getEntryRelationshipChoiceAsAct() {
        return this.entryRelationshipChoice instanceof ActBean ? (ActBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsAct() {
        return (this.entryRelationshipChoice instanceof ActBean);
    }

    public EncounterBean getEntryRelationshipChoiceAsEncounter() {
        return this.entryRelationshipChoice instanceof EncounterBean ? (EncounterBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsEncounter() {
        return (this.entryRelationshipChoice instanceof EncounterBean);
    }

    public ObservationBean getEntryRelationshipChoiceAsObservation() {
        return this.entryRelationshipChoice instanceof ObservationBean ? (ObservationBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsObservation() {
        return (this.entryRelationshipChoice instanceof ObservationBean);
    }

    public ObservationMediaBean getEntryRelationshipChoiceAsObservationMedia() {
        return this.entryRelationshipChoice instanceof ObservationMediaBean ? (ObservationMediaBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsObservationMedia() {
        return (this.entryRelationshipChoice instanceof ObservationMediaBean);
    }

    public OrganizerBean getEntryRelationshipChoiceAsOrganizer() {
        return this.entryRelationshipChoice instanceof OrganizerBean ? (OrganizerBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsOrganizer() {
        return (this.entryRelationshipChoice instanceof OrganizerBean);
    }

    public ProcedureBean getEntryRelationshipChoiceAsProcedure() {
        return this.entryRelationshipChoice instanceof ProcedureBean ? (ProcedureBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsProcedure() {
        return (this.entryRelationshipChoice instanceof ProcedureBean);
    }

    public RegionOfInterestBean getEntryRelationshipChoiceAsRegionOfInterest() {
        return this.entryRelationshipChoice instanceof RegionOfInterestBean ? (RegionOfInterestBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsRegionOfInterest() {
        return (this.entryRelationshipChoice instanceof RegionOfInterestBean);
    }

    public SubstanceAdministrationBean getEntryRelationshipChoiceAsSubstanceAdministration() {
        return this.entryRelationshipChoice instanceof SubstanceAdministrationBean ? (SubstanceAdministrationBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsSubstanceAdministration() {
        return (this.entryRelationshipChoice instanceof SubstanceAdministrationBean);
    }

    public SupplyBean getEntryRelationshipChoiceAsSupply() {
        return this.entryRelationshipChoice instanceof SupplyBean ? (SupplyBean) this.entryRelationshipChoice : null;
    }
    public boolean hasEntryRelationshipChoiceAsSupply() {
        return (this.entryRelationshipChoice instanceof SupplyBean);
    }

}
