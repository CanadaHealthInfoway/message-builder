/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.CreatedAtBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: ParticipantGroupings</p>
 * 
 * <p>REPC_MT500002CA.PatientCareProvisionEventPortion: 
 * Participant Groupings</p>
 * 
 * <p>May only be used when Care Composition Type is Encounter 
 * or a specialization of Encounter</p>
 * 
 * <p>All participant identifiers must correspond to either 
 * patient identifiers or performer identifiers</p>
 * 
 * <p>Allows tracking what participants were present at each 
 * location within the encounter. This information provides 
 * context for the events within the encounter.</p>
 * 
 * <p>Identifies a 'portion' of the encounter performed at a 
 * single location.</p>
 * 
 * <p>REPC_MT500001CA.PatientCareProvisionEventPortion: 
 * Participant Groupings</p>
 * 
 * <p>May only be used when Care Composition Type is Encounter 
 * or a specialization of Encounter</p>
 * 
 * <p>All participant identifiers must correspond to either 
 * patient identifiers or performer identifiers</p>
 * 
 * <p>Allows tracking what participants were present at each 
 * location within the encounter. This information provides 
 * context for the events within the encounter.</p>
 * 
 * <p>Identifies a 'portion' of the encounter performed at a 
 * single location.</p>
 * 
 * <p>REPC_MT500004CA.PatientCareProvisionEventPortion: 
 * Participant Groupings</p>
 * 
 * <p>May only be used when Care Composition Type is Encounter 
 * or a specialization of Encounter</p>
 * 
 * <p>All participant identifiers must correspond to either 
 * patient identifiers or performer identifiers</p>
 * 
 * <p>Allows tracking what participants were present at each 
 * location within the encounter. This information provides 
 * context for the events within the encounter.</p>
 * 
 * <p>Identifies a 'portion' of the encounter performed at a 
 * single location.</p>
 */
@Hl7PartTypeMapping({"REPC_MT500001CA.PatientCareProvisionEventPortion","REPC_MT500002CA.PatientCareProvisionEventPortion","REPC_MT500004CA.PatientCareProvisionEventPortion"})
public class ParticipantGroupingsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CreatedAtBean location;
    private List<HasBean> participant = new ArrayList<HasBean>();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500002CA.PatientCareProvisionEventPortion.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEventPortion.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500004CA.PatientCareProvisionEventPortion.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500002CA.PatientCareProvisionEventPortion.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEventPortion.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500004CA.PatientCareProvisionEventPortion.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500002CA.PatientCareProvisionEventPortion.participant</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-200)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.PatientCareProvisionEventPortion.participant</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-200)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500004CA.PatientCareProvisionEventPortion.participant</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-200)</p>
     */
    @Hl7XmlMapping({"participant"})
    public List<HasBean> getParticipant() {
        return this.participant;
    }

}
