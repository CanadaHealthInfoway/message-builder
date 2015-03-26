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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt090102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Assigned Person</p>
 * 
 * <p>The person assigned to carry out the associated (linked 
 * by a participation) action.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090102CA.AssignedEntity"})
@Hl7RootType
public class AssignedPersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt470012ca.Recipient, ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.AuthorPerson_2, ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt911102ca.ActingPerson, ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.EntererChoice, ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt470002ca.Recipient {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private PN assignedPersonName = new PNImpl();


    /**
     * <p>Business Name: Assigned Person Identifier</p>
     * 
     * <p>Relationship: COCT_MT090102CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier assigned to the person for this role (in 
     * this participation).</p>
     * 
     * <p>Identifies the person in an assigned role (participating 
     * in the associated act).</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Assigned Person Identifier</p>
     * 
     * <p>Relationship: COCT_MT090102CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier assigned to the person for this role (in 
     * this participation).</p>
     * 
     * <p>Identifies the person in an assigned role (participating 
     * in the associated act).</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Assigned Person Name</p>
     * 
     * <p>Relationship: COCT_MT090102CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the assigned person.</p>
     */
    @Hl7XmlMapping({"assignedPerson/name"})
    public PersonName getAssignedPersonName() {
        return this.assignedPersonName.getValue();
    }

    /**
     * <p>Business Name: Assigned Person Name</p>
     * 
     * <p>Relationship: COCT_MT090102CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the assigned person.</p>
     */
    public void setAssignedPersonName(PersonName assignedPersonName) {
        this.assignedPersonName.setValue(assignedPersonName);
    }

}
