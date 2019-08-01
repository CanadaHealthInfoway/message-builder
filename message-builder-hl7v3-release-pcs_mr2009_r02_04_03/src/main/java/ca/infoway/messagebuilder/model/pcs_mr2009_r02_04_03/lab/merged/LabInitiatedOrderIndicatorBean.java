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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POLB_MT001000CA.LabInitiatedOrderIndicator","POLB_MT001001CA.LabInitiatedOrderIndicator","POLB_MT001010CA.LabInitiatedOrderIndicator","POLB_MT001999CA.LabInitiatedOrderIndicator"})
public class LabInitiatedOrderIndicatorBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private BL negationInd = new BLImpl();


    /**
     * <p>Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Un-merged Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A 'true' value indicates that the Order was initiated by 
     * the Lab.</p>
     * 
     * <p>Un-merged Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Un-merged Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A 'true' value indicates that the Order was initiated by 
     * the Lab.</p>
     * 
     * <p>Un-merged Business Name: LabInitiatedOrderIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

}
