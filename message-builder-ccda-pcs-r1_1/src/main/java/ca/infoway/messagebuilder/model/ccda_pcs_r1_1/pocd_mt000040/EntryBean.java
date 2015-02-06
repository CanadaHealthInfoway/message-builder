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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.pocd_mt000040;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.domainvalue.x_ActRelationshipEntry;
import java.util.List;



@Hl7PartTypeMapping({"POCD_MT000040.Entry"})
public class EntryBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ccda_pcs_r1_1.functionalstatussection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.assessmentandplansection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.procedureindicationssection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.plannedproceduresection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.anesthesiasection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.preoperativediagnosissection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.hospitaladmissionmedicationssectionentriesoptional.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_8, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_10, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.payerssection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_9, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_7, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.postprocedurediagnosissection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.medicalequipmentsection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_6, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_5, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_4, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_3, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.familyhistorysection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_2, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.physicalexamsection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.EntryChoice_1, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.planofcaresection.EntryChoice, ca.infoway.messagebuilder.model.ccda_pcs_r1_1.socialhistorysection.EntryChoice {

    private static final long serialVersionUID = 20150206L;
    private CS typeCode = new CSImpl();
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private EntryChoice entryChoice;


    /**
     * <p>Relationship: POCD_MT000040.Entry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public x_ActRelationshipEntry getTypeCode() {
        return (x_ActRelationshipEntry) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Entry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(x_ActRelationshipEntry typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: POCD_MT000040.Entry.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<Code> getRealmCode() {
        return this.realmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: POCD_MT000040.Entry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: POCD_MT000040.Entry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: POCD_MT000040.Entry.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: POCD_MT000040.Entry.entryChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"entryChoice"})
    public EntryChoice getEntryChoice() {
        return this.entryChoice;
    }

    /**
     * <p>Relationship: POCD_MT000040.Entry.entryChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEntryChoice(EntryChoice entryChoice) {
        this.entryChoice = entryChoice;
    }

    public ActBean getEntryChoiceAsAct() {
        return this.entryChoice instanceof ActBean ? (ActBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsAct() {
        return (this.entryChoice instanceof ActBean);
    }

    public EncounterBean getEntryChoiceAsEncounter() {
        return this.entryChoice instanceof EncounterBean ? (EncounterBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsEncounter() {
        return (this.entryChoice instanceof EncounterBean);
    }

    public ObservationBean getEntryChoiceAsObservation() {
        return this.entryChoice instanceof ObservationBean ? (ObservationBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsObservation() {
        return (this.entryChoice instanceof ObservationBean);
    }

    public ObservationMediaBean getEntryChoiceAsObservationMedia() {
        return this.entryChoice instanceof ObservationMediaBean ? (ObservationMediaBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsObservationMedia() {
        return (this.entryChoice instanceof ObservationMediaBean);
    }

    public OrganizerBean getEntryChoiceAsOrganizer() {
        return this.entryChoice instanceof OrganizerBean ? (OrganizerBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsOrganizer() {
        return (this.entryChoice instanceof OrganizerBean);
    }

    public ProcedureBean getEntryChoiceAsProcedure() {
        return this.entryChoice instanceof ProcedureBean ? (ProcedureBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsProcedure() {
        return (this.entryChoice instanceof ProcedureBean);
    }

    public RegionOfInterestBean getEntryChoiceAsRegionOfInterest() {
        return this.entryChoice instanceof RegionOfInterestBean ? (RegionOfInterestBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsRegionOfInterest() {
        return (this.entryChoice instanceof RegionOfInterestBean);
    }

    public SubstanceAdministrationBean getEntryChoiceAsSubstanceAdministration() {
        return this.entryChoice instanceof SubstanceAdministrationBean ? (SubstanceAdministrationBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsSubstanceAdministration() {
        return (this.entryChoice instanceof SubstanceAdministrationBean);
    }

    public SupplyBean getEntryChoiceAsSupply() {
        return this.entryChoice instanceof SupplyBean ? (SupplyBean) this.entryChoice : null;
    }
    public boolean hasEntryChoiceAsSupply() {
        return (this.entryChoice instanceof SupplyBean);
    }

}
