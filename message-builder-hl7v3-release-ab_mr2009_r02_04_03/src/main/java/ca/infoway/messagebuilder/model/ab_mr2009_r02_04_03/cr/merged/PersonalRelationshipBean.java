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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.merged;

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
 * <p>Business Name: PersonalRelationship</p>
 * 
 * <p>PRPA_MT101104CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
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
 * <p>PRPA_MT101991AB.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
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
 * <p>PRPA_MT101102CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
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
 * <p>PRPA_MT101002CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
 * 
 * <p>Links two people in a personal relationship. The 
 * character of the relationship must be defined by a 
 * PersonalRelationshipRoleType code. The player and scoper are 
 * determined by PersonalRelationshipRoleType code as well.</p>
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
 * <p>PRPA_MT101001CA.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
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
 * <p>PRPA_MT101002AB.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
 * 
 * <p>Links two people in a personal relationship. The 
 * character of the relationship must be defined by a 
 * PersonalRelationshipRoleType code. The player and scoper are 
 * determined by PersonalRelationshipRoleType code as well.</p>
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
 * <p>PRPA_MT101001AB.PersonalRelationship: Personal 
 * Relationship</p>
 * 
 * <p>Supports the business requirement to capture additional 
 * information about the Identified Client's Next of Kin</p>
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
 */
@Hl7PartTypeMapping({"PRPA_MT101001AB.PersonalRelationship","PRPA_MT101001CA.PersonalRelationship","PRPA_MT101002AB.PersonalRelationship","PRPA_MT101002CA.PersonalRelationship","PRPA_MT101102AB.PersonalRelationship","PRPA_MT101102CA.PersonalRelationship","PRPA_MT101104AB.PersonalRelationship","PRPA_MT101104CA.PersonalRelationship","PRPA_MT101991AB.PersonalRelationship"})
public class PersonalRelationshipBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private II relationshipHolderId = new IIImpl();
    private PN relationshipHolderName = new PNImpl();


    /**
     * <p>Business Name: ClientNextOfKin</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101102AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101002AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101001AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
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
     * <p>Relationship: PRPA_MT101104AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101102AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the Next of Kin</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101002AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     * 
     * <p>Un-merged Business Name: ClientNextOfKin</p>
     * 
     * <p>Relationship: PRPA_MT101001AB.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p>
     * 
     * <p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p>
     */
    public void setCode(PersonalRelationshipRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101102AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
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
     * <p>Relationship: PRPA_MT101104AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101102AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * next of kin and allows for the use of null flavours when the 
     * identifier is not known or available.</p>
     * 
     * <p>A unique identifier for the next of kin</p>
     */
    public void setRelationshipHolderId(Identifier relationshipHolderId) {
        this.relationshipHolderId.setValue(relationshipHolderId);
    }


    /**
     * <p>Business Name: NextOfKinName</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101104AB.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101102AB.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101002AB.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101001AB.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
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
     * <p>Relationship: PRPA_MT101104AB.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101102AB.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101002AB.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     * 
     * <p>Un-merged Business Name: NextOfKinName</p>
     * 
     * <p>Relationship: PRPA_MT101001AB.ParentPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * next of kin</p>
     * 
     * <p>A name for the next of kin</p>
     */
    public void setRelationshipHolderName(PersonName relationshipHolderName) {
        this.relationshipHolderName.setValue(relationshipHolderName);
    }

}
