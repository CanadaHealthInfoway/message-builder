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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt030060ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p><p>Identifies the source of the immunization information 
 * as someone who has a personal relationship with the 
 * patient.</p></p>
 * 
 * <p><p>Supplies contextual information about the source of 
 * the immunization report.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030060CA.PersonalRelationshipRole"})
public class PersonalRelationshipRoleBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.InformationSourceChoice {

    private static final long serialVersionUID = 20110407L;
    private CV personalRelationshipType = new CVImpl();


    /**
     * <p>Personal Relationship Type</p>
     * 
     * <p><p>Describes the personal relationship between the 
     * information source and the patient.</p></p>
     * 
     * <p><p>Useful for categorizing sources of immunization 
     * information. As a result, this attribute is populated.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public PersonalRelationshipRoleType getPersonalRelationshipType() {
        return (PersonalRelationshipRoleType) this.personalRelationshipType.getValue();
    }
    public void setPersonalRelationshipType(PersonalRelationshipRoleType personalRelationshipType) {
        this.personalRelationshipType.setValue(personalRelationshipType);
    }

}
