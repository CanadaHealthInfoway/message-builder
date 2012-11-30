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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping({ "PORX_MT020070CA.MedicationDispense" })
public class DispenseRequest1Bean extends BaseDispenseRequestBean implements Serializable {

    private static final long serialVersionUID = -2095634015394561160L;

    private SupplyEventBean supplyEvent;

    private final List<DosageInstructionBean> dosageInstructions = Collections.synchronizedList(new ArrayList<DosageInstructionBean>());

    private SubstitutionMadeBean substitutionMade;

    private SubstanceAdministrationRequestBean substanceAdministrationRequest;

    @Hl7XmlMapping("component1/substitutionMade")
    public SubstitutionMadeBean getSubstitutionMade() {
        return substitutionMade;
    }
    public void setSubstitutionMade(SubstitutionMadeBean substitutionMade) {
        this.substitutionMade = substitutionMade;
    }

    @Hl7XmlMapping({ "component2/dosageInstruction" })
    public List<DosageInstructionBean> getDosageInstructions() {
        return dosageInstructions;
    }

    @Hl7XmlMapping({ "component3/supplyEvent" })
    public SupplyEventBean getSupplyEvent() {
        return supplyEvent;
    }

    public void setSupplyEvent(SupplyEventBean supplyEvent) {
        this.supplyEvent = supplyEvent;
    }

    @Hl7XmlMapping({ "inFulfillmentOf/substanceAdministrationRequest" })
    public SubstanceAdministrationRequestBean getSubstanceAdministrationRequest() {
        return substanceAdministrationRequest;
    }

    public void setSubstanceAdministrationRequest(SubstanceAdministrationRequestBean substanceAdministrationRequest) {
        this.substanceAdministrationRequest = substanceAdministrationRequest;
    }

}
