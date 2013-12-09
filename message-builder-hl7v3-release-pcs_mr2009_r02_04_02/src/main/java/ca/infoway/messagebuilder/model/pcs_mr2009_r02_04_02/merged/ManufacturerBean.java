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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Manufacturer</p>
 * 
 * <p>POIZ_MT030050CA.Manufacturer: Manufacturer</p>
 * 
 * <p>Useful in distinguishing and grouping drug products</p>
 * 
 * <p>Identity of the organization that manufactured the drug 
 * product.</p>
 * 
 * <p>POME_MT010040CA.Manufacturer: Manufacturer</p>
 * 
 * <p>Useful in distinguishing and grouping drug products</p>
 * 
 * <p>Identity of the organization that manufactured the drug 
 * product.</p>
 * 
 * <p>POME_MT010100CA.Manufacturer: Manufacturer</p>
 * 
 * <p>Useful in distinguishing and grouping drug products</p>
 * 
 * <p>Identity of the organization that manufactured the drug 
 * product.</p>
 * 
 * <p>POIZ_MT030060CA.Manufacturer: Manufacturer</p>
 * 
 * <p>Useful in distinguishing and grouping drug products</p>
 * 
 * <p>Identity of the organization that manufactured the drug 
 * product.</p>
 * 
 * <p>COCT_MT220210CA.Manufacturer: Manufacturer</p>
 * 
 * <p>Useful in distinguishing and grouping drug products</p>
 * 
 * <p>Identity of the organization that manufactured the drug 
 * product.</p>
 * 
 * <p>POIZ_MT061150CA.Manufacturer: Manufacturer</p>
 * 
 * <p>Useful in distinguishing and grouping drug products</p>
 * 
 * <p>Identity of the organization that manufactured the drug 
 * product.</p>
 * 
 * <p>POIZ_MT060150CA.Manufacturer: Manufacturer</p>
 * 
 * <p>Useful in distinguishing and grouping drug products</p>
 * 
 * <p>Identity of the organization that manufactured the drug 
 * product.</p>
 * 
 * <p>COCT_MT220110CA.Manufacturer: Manufacturer</p>
 * 
 * <p>Useful in distinguishing and grouping drug products</p>
 * 
 * <p>Identity of the organization that manufactured the drug 
 * product.</p>
 */
@Hl7PartTypeMapping({"COCT_MT220110CA.Manufacturer","COCT_MT220210CA.Manufacturer","POIZ_MT030050CA.Manufacturer","POIZ_MT030060CA.Manufacturer","POIZ_MT060150CA.Manufacturer","POIZ_MT061150CA.Manufacturer","POME_MT010040CA.Manufacturer","POME_MT010100CA.Manufacturer"})
public class ManufacturerBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private II id = new IIImpl();
    private ST name = new STImpl();


    /**
     * <p>Un-merged Business Name: ManufacturerID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerId</p>
     * 
     * <p>Relationship: POME_MT010040CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: OrganizationId</p>
     * 
     * <p>Relationship: POME_MT010100CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerId</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerID</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerId</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: ManufacturerID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerId</p>
     * 
     * <p>Relationship: POME_MT010040CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: OrganizationId</p>
     * 
     * <p>Relationship: POME_MT010100CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerId</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerID</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerId</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Manufacturer.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p>
     * 
     * <p>An identifier denoting a specific drug manufacturer.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ManufacturerName</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POME_MT010100CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: ManufacturerName</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POME_MT010100CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     * 
     * <p>Un-merged Business Name: ManufacturerName</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Manufacturer.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p>
     * 
     * <p>The name of the drug manufacturer.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }

}
