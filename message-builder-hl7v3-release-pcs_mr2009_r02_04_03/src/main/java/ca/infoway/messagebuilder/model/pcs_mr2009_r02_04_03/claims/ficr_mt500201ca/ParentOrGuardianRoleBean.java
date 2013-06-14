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



/**
 * <p></p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.ParentOrGuardianRole"})
public class ParentOrGuardianRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PN relationshipHolderName = new PNImpl();


    /**
     * <p>Business Name: Id of parent</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ParentOrGuardianRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Id of parent</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ParentOrGuardianRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Parent or Guardian Relationship to patient</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ParentOrGuardianRole.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public PersonalRelationshipRoleType getCode() {
        return (PersonalRelationshipRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Parent or Guardian Relationship to patient</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ParentOrGuardianRole.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(PersonalRelationshipRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Name of Parent or Guardian</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ParentOrGuardian.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"relationshipHolder/name"})
    public PersonName getRelationshipHolderName() {
        return this.relationshipHolderName.getValue();
    }

    /**
     * <p>Business Name: Name of Parent or Guardian</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ParentOrGuardian.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRelationshipHolderName(PersonName relationshipHolderName) {
        this.relationshipHolderName.setValue(relationshipHolderName);
    }

}
