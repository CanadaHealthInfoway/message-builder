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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.PrescriptionPatientMeasurementsBean;



/**
 * <p>Business Name: g:includes</p>
 * 
 * <p>Indicates other patient information that is an important 
 * consideration for the prescription. This information is 
 * limited to height and weight.</p>
 * 
 * <p>Allows patient height and weight to be conveyed to the 
 * pharmacy for dosage calculation or verification</p><p>The 
 * additional repetitions are to allow for capturing of 
 * additional concepts beyond height and weight without 
 * impacting the message structure should future versions of 
 * the specification allow.</p>
 * 
 * <p>Allows patient height and weight to be conveyed to the 
 * pharmacy for dosage calculation or verification</p><p>The 
 * additional repetitions are to allow for capturing of 
 * additional concepts beyond height and weight without 
 * impacting the message structure should future versions of 
 * the specification allow.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.PertinentInformation"})
public class Includes_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20131210L;
    private BL contextConductionInd = new BLImpl();
    private PrescriptionPatientMeasurementsBean quantityObservationEvent;


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.PertinentInformation.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.PertinentInformation.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.PertinentInformation.quantityObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"quantityObservationEvent"})
    public PrescriptionPatientMeasurementsBean getQuantityObservationEvent() {
        return this.quantityObservationEvent;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.PertinentInformation.quantityObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setQuantityObservationEvent(PrescriptionPatientMeasurementsBean quantityObservationEvent) {
        this.quantityObservationEvent = quantityObservationEvent;
    }

}
