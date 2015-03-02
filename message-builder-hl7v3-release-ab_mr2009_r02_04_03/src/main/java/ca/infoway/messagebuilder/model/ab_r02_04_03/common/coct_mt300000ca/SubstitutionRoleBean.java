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
package ca.infoway.messagebuilder.model.ab_r02_04_03.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Who did the substitution</p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SubstitutionRole"})
public class SubstitutionRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20150302L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: Person who did the substitution</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SubstitutionRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ID must be that of the patient, ordering provider or 
     * dispensing provider</p>
     * 
     * <p>Id must be that of the patient, ordering provider or 
     * dispensing provider.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Person who did the substitution</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SubstitutionRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ID must be that of the patient, ordering provider or 
     * dispensing provider</p>
     * 
     * <p>Id must be that of the patient, ordering provider or 
     * dispensing provider.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
