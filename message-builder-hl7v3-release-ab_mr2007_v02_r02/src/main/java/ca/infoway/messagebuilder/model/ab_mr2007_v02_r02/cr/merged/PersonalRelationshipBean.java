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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.EntityClass;
import ca.infoway.messagebuilder.domainvalue.EntityDeterminer;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: PersonalRelationship</p>
 * 
 * <p>PRPA_MT101001CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Associations between persons in the Person Registry, such 
 * as spouse or parent, can be sent in a PersonalRelationship 
 * class. The exact nature of a association is described by the 
 * code attribute with a value drawn from the 
 * PersonalRelationshipRoleType domain. Most associations can 
 * be represented in either of two ways depending on who is the 
 * player and who is the scoper. For example, the association 
 * between a father and his daughter can be represented by a 
 * code of &quot;father&quot; where the parent is the player 
 * and the child is the scoper, or by a code of 
 * &quot;daughter&quot; where the child is the player and the 
 * parent is the scoper.</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
 * 
 * <p>PRPA_MT101104CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Associations between persons in the Person Registry, such 
 * as spouse or parent, can be sent in a PersonalRelationship 
 * class. The exact nature of a association is described by the 
 * code attribute with a value drawn from the 
 * PersonalRelationshipRoleType domain. Most associations can 
 * be represented in either of two ways depending on who is the 
 * player and who is the scoper. For example, the association 
 * between a father and his daughter can be represented by a 
 * code of &quot;father&quot; where the parent is the player 
 * and the child is the scoper, or by a code of 
 * &quot;daughter&quot; where the child is the player and the 
 * parent is the scoper.</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
 * 
 * <p>PRPA_MT101102CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Associations between persons in the Person Registry, such 
 * as spouse or parent, can be sent in a PersonalRelationship 
 * class. The exact nature of a association is described by the 
 * code attribute with a value drawn from the 
 * PersonalRelationshipRoleType domain. Most associations can 
 * be represented in either of two ways depending on who is the 
 * player and who is the scoper. For example, the association 
 * between a father and his daughter can be represented by a 
 * code of &quot;father&quot; where the parent is the player 
 * and the child is the scoper, or by a code of 
 * &quot;daughter&quot; where the child is the player and the 
 * parent is the scoper.</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
 * 
 * <p>PRPA_MT101002CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Associations between persons in the Person Registry, such 
 * as spouse or parent, can be sent in a PersonalRelationship 
 * class. The exact nature of a association is described by the 
 * code attribute with a value drawn from the 
 * PersonalRelationshipRoleType domain. Most associations can 
 * be represented in either of two ways depending on who is the 
 * player and who is the scoper. For example, the association 
 * between a father and his daughter can be represented by a 
 * code of &quot;father&quot; where the parent is the player 
 * and the child is the scoper, or by a code of 
 * &quot;daughter&quot; where the child is the player and the 
 * parent is the scoper.</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
 * 
 * <p>Links two people in a personal relationship. The 
 * character of the relationship must be defined by a 
 * PersonalRelationshipRoleType code. The player and scoper are 
 * determined by PersonalRelationshipRoleType code as well.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101001CA.PersonalRelationship","PRPA_MT101002CA.PersonalRelationship","PRPA_MT101102CA.PersonalRelationship","PRPA_MT101104CA.PersonalRelationship"})
public class PersonalRelationshipBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private CV code = new CVImpl();
    private II relationshipHolderId = new IIImpl();
    private PN relationshipHolderName = new PNImpl();
    private CS classCode = new CSImpl();
    private CS relationshipHolderClassCode = new CSImpl();
    private CS relationshipHolderDeterminerCode = new CSImpl();


    /**
     * <p>Business Name: ClientNextOfKin</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     */
    @Hl7XmlMapping({"code"})
    public PersonalRelationshipRoleType getCode() {
        return (PersonalRelationshipRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: ClientNextOfKin</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     */
    public void setCode(PersonalRelationshipRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * next of kin</p>
     */
    @Hl7XmlMapping({"relationshipHolder/id"})
    public Identifier getRelationshipHolderId() {
        return this.relationshipHolderId.getValue();
    }

    /**
     * <p>Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * next of kin</p>
     */
    public void setRelationshipHolderId(Identifier relationshipHolderId) {
        this.relationshipHolderId.setValue(relationshipHolderId);
    }


    /**
     * <p>Business Name: NextOfKinName</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     */
    @Hl7XmlMapping({"relationshipHolder/name"})
    public PersonName getRelationshipHolderName() {
        return this.relationshipHolderName.getValue();
    }

    /**
     * <p>Business Name: NextOfKinName</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     */
    public void setRelationshipHolderName(PersonName relationshipHolderName) {
        this.relationshipHolderName.setValue(relationshipHolderName);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.PersonalRelationship.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>A code specifying the major category of a Role as defined 
     * by HL7 vocabulary.</p>
     * 
     * <p>Provides a means to identify Roles played by entities</p>
     * 
     * <p>Links two people in a personal relationship. The 
     * character of the relationship must be defined by a 
     * PersonalRelationshipRoleType code. The player and scoper are 
     * determined by PersonalRelationshipRoleType code as well.</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101102CA.PersonalRelationship.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.PersonalRelationship.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>A code specifying the major category of a Role as defined 
     * by HL7 vocabulary.</p>
     * 
     * <p>Provides a means to identify Roles played by entities</p>
     * 
     * <p>Links two people in a personal relationship. The 
     * character of the relationship must be defined by a 
     * PersonalRelationshipRoleType code. The player and scoper are 
     * determined by PersonalRelationshipRoleType code as well.</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101102CA.PersonalRelationship.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An HL7 defined value representing the class or category 
     * that the Entity instance represents.</p><p>Examples: Person, 
     * Animal, Chemical Substance, Group, Organization</p>
     * 
     * <p>An HL7 defined value representing the class or category 
     * that the Entity instance represents.</p><p>Examples: Person, 
     * Animal, Chemical Substance, Group, Organization</p>
     * 
     * <p>Due to the extremely large number of potential values for 
     * a code set representing all physical things in the universe, 
     * the class code indicates both the subtype branch of the 
     * Entity hierarchy used as well as a high level classifier to 
     * represent the instance of Entity. This can be used to 
     * constrain the eligible value domains for the Entity.code 
     * attribute.</p>
     * 
     * <p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityClass.htm</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"relationshipHolder/classCode"})
    public EntityClass getRelationshipHolderClassCode() {
        return (EntityClass) this.relationshipHolderClassCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An HL7 defined value representing the class or category 
     * that the Entity instance represents.</p><p>Examples: Person, 
     * Animal, Chemical Substance, Group, Organization</p>
     * 
     * <p>An HL7 defined value representing the class or category 
     * that the Entity instance represents.</p><p>Examples: Person, 
     * Animal, Chemical Substance, Group, Organization</p>
     * 
     * <p>Due to the extremely large number of potential values for 
     * a code set representing all physical things in the universe, 
     * the class code indicates both the subtype branch of the 
     * Entity hierarchy used as well as a high level classifier to 
     * represent the instance of Entity. This can be used to 
     * constrain the eligible value domains for the Entity.code 
     * attribute.</p>
     * 
     * <p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityClass.htm</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRelationshipHolderClassCode(EntityClass relationshipHolderClassCode) {
        this.relationshipHolderClassCode.setValue(relationshipHolderClassCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.determinerCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p>
     * 
     * <p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p>
     * 
     * <p>An Entity may at times represent information concerning a 
     * specific instance (the most common), a quantifiable group 
     * with common characteristics or a general type of Entity. 
     * This code distinguishes these different representations.</p>
     * 
     * <p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityDeterminer.htm</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.determinerCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"relationshipHolder/determinerCode"})
    public EntityDeterminer getRelationshipHolderDeterminerCode() {
        return (EntityDeterminer) this.relationshipHolderDeterminerCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.determinerCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p>
     * 
     * <p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p>
     * 
     * <p>An Entity may at times represent information concerning a 
     * specific instance (the most common), a quantifiable group 
     * with common characteristics or a general type of Entity. 
     * This code distinguishes these different representations.</p>
     * 
     * <p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityDeterminer.htm</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.determinerCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRelationshipHolderDeterminerCode(EntityDeterminer relationshipHolderDeterminerCode) {
        this.relationshipHolderDeterminerCode.setValue(relationshipHolderDeterminerCode);
    }

}
