/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged.PrescriptionPatientMeasurementsBean;



@Hl7PartTypeMapping({"PORX_MT010120CA.PertinentInformation"})
public class IncludesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private BL contextConductionInd = new BLImpl();
    private PrescriptionPatientMeasurementsBean quantityObservationEvent;


    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    @Hl7XmlMapping({"quantityObservationEvent"})
    public PrescriptionPatientMeasurementsBean getQuantityObservationEvent() {
        return this.quantityObservationEvent;
    }
    public void setQuantityObservationEvent(PrescriptionPatientMeasurementsBean quantityObservationEvent) {
        this.quantityObservationEvent = quantityObservationEvent;
    }

}