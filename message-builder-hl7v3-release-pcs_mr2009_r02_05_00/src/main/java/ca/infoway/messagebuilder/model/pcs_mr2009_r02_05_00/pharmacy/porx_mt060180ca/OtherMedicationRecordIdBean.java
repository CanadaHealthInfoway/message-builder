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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pharmacy.porx_mt060180ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



@Hl7PartTypeMapping({"PORX_MT060180CA.OtherMedicationRecordId"})
public class OtherMedicationRecordIdBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private SET<II, Identifier> value = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>Business Name: E:Other Medication Record Id</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.OtherMedicationRecordId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Allows for the retrieval of medication records based on a 
     * specific active medication record.</p>
     * 
     * <p>Identifier of the other active medication record for 
     * which detailed information is to be retrieved.</p>
     */
    @Hl7XmlMapping({"value"})
    public Set<Identifier> getValue() {
        return this.value.rawSet();
    }

}
