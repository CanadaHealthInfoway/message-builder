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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt061140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



@Hl7PartTypeMapping({"POIZ_MT061140CA.PatientID"})
public class PatientIDBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private SET<II, Identifier> value = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>Business Name: A:Patient IDs</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     * 
     * <p>Allows filtering of result set by patient Id. As a 
     * result, this parameter is required.</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * immunization candidate query. Filter the result set to 
     * include only those records pertaining to the patient with 
     * this Id.</p>
     */
    @Hl7XmlMapping({"value"})
    public Set<Identifier> getValue() {
        return this.value.rawSet();
    }

}
