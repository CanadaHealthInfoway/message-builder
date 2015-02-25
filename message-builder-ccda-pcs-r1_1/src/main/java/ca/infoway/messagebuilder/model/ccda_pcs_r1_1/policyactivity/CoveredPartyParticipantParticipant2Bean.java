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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.policyactivity;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PolicyActivity.CoveredPartyParticipantParticipant2"})
public class CoveredPartyParticipantParticipant2Bean extends MessagePartBean implements Participant2Choice {

    private static final long serialVersionUID = 20150225L;
    private II templateId = new IIImpl();
    private IVLTSCDAR1 time = new IVLTSCDAR1Impl();
    private CoveredPartyParticipantParticipantRoleBean participantRole;


    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipant2.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public Identifier getTemplateId() {
        return this.templateId.getValue();
    }

    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipant2.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTemplateId(Identifier templateId) {
        this.templateId.setValue(templateId);
    }


    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipant2.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"time"})
    public DateInterval getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipant2.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTime(DateInterval time) {
        this.time.setValue(time);
    }


    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipant2.participantRole</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"participantRole"})
    public CoveredPartyParticipantParticipantRoleBean getParticipantRole() {
        return this.participantRole;
    }

    /**
     * <p>Relationship: 
     * PolicyActivity.CoveredPartyParticipantParticipant2.participantRole</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setParticipantRole(CoveredPartyParticipantParticipantRoleBean participantRole) {
        this.participantRole = participantRole;
    }

}
