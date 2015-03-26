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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ConsentGivenToBean;
import java.util.Date;



@Hl7PartTypeMapping({"POIZ_MT030050CA.Consent","POIZ_MT030060CA.Consent","POIZ_MT060150CA.Consent"})
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private BL negationInd = new BLImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ConsentGivenToBean receiver;
    private CE responsiblePartyModeCode = new CEImpl();
    private Consenter responsiblePartyConsenter;


    /**
     * <p>Business Name: ConsentID</p>
     * 
     * <p>Un-merged Business Name: ConsentID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Consent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: ConsentID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Consent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: ConsentID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Consent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ConsentID</p>
     * 
     * <p>Un-merged Business Name: ConsentID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Consent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: ConsentID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Consent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: ConsentID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Consent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ConsentWitheldIndicator</p>
     * 
     * <p>Un-merged Business Name: ConsentWitheldIndicator</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Consent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ConsentWitheldIndicator</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Consent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ConsentWitheldIndicator</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Consent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: ConsentWitheldIndicator</p>
     * 
     * <p>Un-merged Business Name: ConsentWitheldIndicator</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Consent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ConsentWitheldIndicator</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Consent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ConsentWitheldIndicator</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Consent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Consent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Consent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Consent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Consent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Consent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Consent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Consent.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Consent.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Consent.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"receiver"})
    public ConsentGivenToBean getReceiver() {
        return this.receiver;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Consent.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Consent.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Consent.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setReceiver(ConsentGivenToBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>Business Name: ConsentMethod</p>
     * 
     * <p>Un-merged Business Name: ConsentMethod</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.ResponsibleParty2.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ConsentMethod</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.ResponsibleParty2.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ConsentMethod</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.ResponsibleParty2.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for explicit communication of how consent was 
     * given (e.g. verbal, written, etc.)</p>
     * 
     * <p>Describes the method in which consent was given.</p>
     */
    @Hl7XmlMapping({"responsibleParty/modeCode"})
    public ParticipationMode getResponsiblePartyModeCode() {
        return (ParticipationMode) this.responsiblePartyModeCode.getValue();
    }

    /**
     * <p>Business Name: ConsentMethod</p>
     * 
     * <p>Un-merged Business Name: ConsentMethod</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.ResponsibleParty2.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ConsentMethod</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.ResponsibleParty2.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ConsentMethod</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.ResponsibleParty2.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for explicit communication of how consent was 
     * given (e.g. verbal, written, etc.)</p>
     * 
     * <p>Describes the method in which consent was given.</p>
     */
    public void setResponsiblePartyModeCode(ParticipationMode responsiblePartyModeCode) {
        this.responsiblePartyModeCode.setValue(responsiblePartyModeCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.ResponsibleParty2.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.ResponsibleParty2.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.ResponsibleParty2.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/consenter"})
    public Consenter getResponsiblePartyConsenter() {
        return this.responsiblePartyConsenter;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.ResponsibleParty2.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.ResponsibleParty2.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.ResponsibleParty2.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyConsenter(Consenter responsiblePartyConsenter) {
        this.responsiblePartyConsenter = responsiblePartyConsenter;
    }

}
