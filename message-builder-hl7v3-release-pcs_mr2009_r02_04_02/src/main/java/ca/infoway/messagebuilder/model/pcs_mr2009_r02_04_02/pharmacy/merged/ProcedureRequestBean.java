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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.ProcedureRequest","PORX_MT020060CA.ProcedureRequest","PORX_MT060010CA.ProcedureRequest","PORX_MT060040CA.ProcedureRequest","PORX_MT060060CA.ProcedureRequest"})
public class ProcedureRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private ST text = new STImpl();


    /**
     * <p>Business Name: UsageInstructions</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT060010CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Shows other providers the usage instructions provided to 
     * the patient.</p>
     * 
     * <p>Indicates how the device is intended to be used.</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT020060CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Communicates to other providers how the patient is 
     * expected to use the dispensed device</p>
     * 
     * <p>Indicates how the patient is expected to use the 
     * device.</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT060040CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Instructions for use are a key part of any 
     * prescription</p>
     * 
     * <p>Indicates how the prescribed device is intended to be 
     * used.</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT010110CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Instructions are a key part of the prescription.</p>
     * 
     * <p>Indicates how the device should be used by the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT060060CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Usage instructions are a critical part of a 
     * prescription.</p>
     * 
     * <p>Indicates how the prescribed device is intended to be 
     * used.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: UsageInstructions</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT060010CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Shows other providers the usage instructions provided to 
     * the patient.</p>
     * 
     * <p>Indicates how the device is intended to be used.</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT020060CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Communicates to other providers how the patient is 
     * expected to use the dispensed device</p>
     * 
     * <p>Indicates how the patient is expected to use the 
     * device.</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT060040CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Instructions for use are a key part of any 
     * prescription</p>
     * 
     * <p>Indicates how the prescribed device is intended to be 
     * used.</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT010110CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Instructions are a key part of the prescription.</p>
     * 
     * <p>Indicates how the device should be used by the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: UsageInstructions</p>
     * 
     * <p>Relationship: PORX_MT060060CA.ProcedureRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Usage instructions are a critical part of a 
     * prescription.</p>
     * 
     * <p>Indicates how the prescribed device is intended to be 
     * used.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
