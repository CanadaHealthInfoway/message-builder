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
package ca.infoway.messagebuilder.model.ccda_r00_alpha.authorizationactivity;

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
import ca.infoway.messagebuilder.model.ccda_r00_alpha.domainvalue.x_ActRelationshipEntryRelationship;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.ActBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.EncounterBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.EntryRelationshipChoice;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.ObservationBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.ObservationMediaBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.OrganizerBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.ProcedureBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.RegionOfInterestBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.SubstanceAdministrationBean;
import ca.infoway.messagebuilder.model.ccda_r00_alpha.pocd_mt000040.SupplyBean;
import java.util.List;



@Hl7PartTypeMapping({"AuthorizationActivity.EntryRelationship"})
public class EntryRelationshipBean extends MessagePartBean {

    private static final long serialVersionUID = 20140915L;
    private CS_R2 typeCode = new CS_R2Impl();
    private BL inversionInd = new BLImpl();
    private BL contextConductionInd = new BLImpl();
    private BL negationInd = new BLImpl();
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private INT sequenceNumber = new INTImpl();
    private BL seperatableInd = new BLImpl();
    private EntryRelationshipChoice entryRelationshipChoice;


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.typeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public CodedTypeR2<x_ActRelationshipEntryRelationship> getTypeCode() {
        return (CodedTypeR2<x_ActRelationshipEntryRelationship>) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.typeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setTypeCode(CodedTypeR2<x_ActRelationshipEntryRelationship> typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.inversionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"inversionInd"})
    public Boolean getInversionInd() {
        return this.inversionInd.getValue();
    }

    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.inversionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setInversionInd(Boolean inversionInd) {
        this.inversionInd.setValue(inversionInd);
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"seperatableInd"})
    public Boolean getSeperatableInd() {
        return this.seperatableInd.getValue();
    }

    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.seperatableInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSeperatableInd(Boolean seperatableInd) {
        this.seperatableInd.setValue(seperatableInd);
    }


    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.entryRelationshipChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"entryRelationshipChoice"})
    public EntryRelationshipChoice getEntryRelationshipChoice() {
        return this.entryRelationshipChoice;
    }

    /**
     * <p>Relationship: 
     * AuthorizationActivity.EntryRelationship.entryRelationshipChoice</p>
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
