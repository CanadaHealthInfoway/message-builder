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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt260020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT260020CA.InFulfillmentOf"})
public class InFulfillmentOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CS typeCode = new CSImpl();
    private CS substanceAdministrationEventClassCode = new CSImpl();
    private CS substanceAdministrationEventMoodCode = new CSImpl();
    private II substanceAdministrationEventId = new IIImpl();


    /**
     * <p>Relationship: COCT_MT260020CA.InFulfillmentOf.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: COCT_MT260020CA.InFulfillmentOf.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: 
     * COCT_MT260020CA.SubstanceAdministrationEvent.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"substanceAdministrationEvent/classCode"})
    public ActClass getSubstanceAdministrationEventClassCode() {
        return (ActClass) this.substanceAdministrationEventClassCode.getValue();
    }

    /**
     * <p>Relationship: 
     * COCT_MT260020CA.SubstanceAdministrationEvent.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubstanceAdministrationEventClassCode(ActClass substanceAdministrationEventClassCode) {
        this.substanceAdministrationEventClassCode.setValue(substanceAdministrationEventClassCode);
    }


    /**
     * <p>Relationship: 
     * COCT_MT260020CA.SubstanceAdministrationEvent.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"substanceAdministrationEvent/moodCode"})
    public ActMood getSubstanceAdministrationEventMoodCode() {
        return (ActMood) this.substanceAdministrationEventMoodCode.getValue();
    }

    /**
     * <p>Relationship: 
     * COCT_MT260020CA.SubstanceAdministrationEvent.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubstanceAdministrationEventMoodCode(ActMood substanceAdministrationEventMoodCode) {
        this.substanceAdministrationEventMoodCode.setValue(substanceAdministrationEventMoodCode);
    }


    /**
     * <p>Relationship: 
     * COCT_MT260020CA.SubstanceAdministrationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The identifier for the prescription that the dispense 
     * fulfilled.</p>
     */
    @Hl7XmlMapping({"substanceAdministrationEvent/id"})
    public Identifier getSubstanceAdministrationEventId() {
        return this.substanceAdministrationEventId.getValue();
    }

    /**
     * <p>Relationship: 
     * COCT_MT260020CA.SubstanceAdministrationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The identifier for the prescription that the dispense 
     * fulfilled.</p>
     */
    public void setSubstanceAdministrationEventId(Identifier substanceAdministrationEventId) {
        this.substanceAdministrationEventId.setValue(substanceAdministrationEventId);
    }

}
