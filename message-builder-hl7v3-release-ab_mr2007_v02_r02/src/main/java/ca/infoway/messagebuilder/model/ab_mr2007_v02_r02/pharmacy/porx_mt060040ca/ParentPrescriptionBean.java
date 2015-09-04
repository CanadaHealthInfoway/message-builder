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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt060040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Parent Prescription</p>
 * 
 * <p>This is the original prescription that is being renewed. 
 * The current prescription uses the original prescription as 
 * the basis for its information.</p>
 * 
 * <p>Helps link prescriptions together, and subsequently 
 * indications for prescribing.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.PriorSupplyRequest"})
public class ParentPrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: B:Previous Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT060040CA.PriorSupplyRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A reference to a previous prescription which the current 
     * prescription replaces.</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Previous Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT060040CA.PriorSupplyRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A reference to a previous prescription which the current 
     * prescription replaces.</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}