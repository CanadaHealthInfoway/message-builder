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
package ca.infoway.messagebuilder.model.pcs_cda_r1_2.basemodel;

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
import ca.infoway.messagebuilder.model.pcs_cda_r1_2.domainvalue.x_ActRelationshipEntry;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.Entry"})
public class EntryBean extends MessagePartBean {

    private static final long serialVersionUID = 20150328L;
    private CS typeCode = new CSImpl();
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private EntryChoice entryChoice;


    /**
     * <p>Relationship: BaseModel.Entry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public x_ActRelationshipEntry getTypeCode() {
        return (x_ActRelationshipEntry) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Entry.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(x_ActRelationshipEntry typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: BaseModel.Entry.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<Code> getRealmCode() {
        return this.realmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: BaseModel.Entry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: BaseModel.Entry.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: BaseModel.Entry.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: BaseModel.Entry.entryChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"entryChoice"})
    public EntryChoice getEntryChoice() {
        return this.entryChoice;
    }

    /**
     * <p>Relationship: BaseModel.Entry.entryChoice</p>
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
