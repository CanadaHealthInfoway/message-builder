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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt500201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT500201CA.ParentOrGuardianRole"})
public class ParentOrGuardianRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PN relationshipHolderName = new PNImpl();


    /**
     * <p>Id of parent</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Id of parent</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Parent or Guardian Relationship to patient</p>
     */
    @Hl7XmlMapping({"code"})
    public PersonalRelationshipRoleType getCode() {
        return (PersonalRelationshipRoleType) this.code.getValue();
    }

    /**
     * <p>Parent or Guardian Relationship to patient</p>
     */
    public void setCode(PersonalRelationshipRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Name of Parent or Guardian</p>
     */
    @Hl7XmlMapping({"relationshipHolder/name"})
    public PersonName getRelationshipHolderName() {
        return this.relationshipHolderName.getValue();
    }

    /**
     * <p>Name of Parent or Guardian</p>
     */
    public void setRelationshipHolderName(PersonName relationshipHolderName) {
        this.relationshipHolderName.setValue(relationshipHolderName);
    }

}
