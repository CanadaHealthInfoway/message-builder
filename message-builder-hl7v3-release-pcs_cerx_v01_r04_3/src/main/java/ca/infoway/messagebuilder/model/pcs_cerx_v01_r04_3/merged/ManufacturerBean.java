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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Manufacturer</p>
 * 
 * <p>POME_MT010040CA.Manufacturer: Manufacturer</p>
 * 
 * <p><p>Identity of the organization that manufactured the 
 * drug product.</p></p>
 * 
 * <p><p>Useful in distinguishing and grouping drug 
 * products</p></p>
 * 
 * <p>POME_MT010100CA.Manufacturer: Manufacturer</p>
 * 
 * <p><p>Identity of the organization that manufactured the 
 * drug product.</p></p>
 * 
 * <p><p>Useful in distinguishing and grouping drug 
 * products</p></p>
 * 
 * <p>COCT_MT220210CA.Manufacturer: Manufacturer</p>
 * 
 * <p><p>Identity of the organization that manufactured the 
 * drug product.</p></p>
 * 
 * <p><p>Useful in distinguishing and grouping drug 
 * products</p></p>
 * 
 * <p>COCT_MT220110CA.Manufacturer: Manufacturer</p>
 * 
 * <p><p>Identity of the organization that manufactured the 
 * drug product.</p></p>
 * 
 * <p><p>Useful in distinguishing and grouping drug 
 * products</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT220110CA.Manufacturer","COCT_MT220210CA.Manufacturer","POME_MT010040CA.Manufacturer","POME_MT010100CA.Manufacturer"})
public class ManufacturerBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private II id = new IIImpl();
    private ST name = new STImpl();


    /**
     * <p>Manufacturer Id</p>
     * 
     * <p><p>An identifier denoting a specific drug 
     * manufacturer.</p></p>
     * 
     * <p><p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p></p>
     * 
     * <p>Organization Id</p>
     * 
     * <p><p>An identifier denoting a specific drug 
     * manufacturer.</p></p>
     * 
     * <p><p>Allows sending of identifiers in place of manufacturer 
     * name. May be used in drug search where specific manufacturer 
     * is a criterion.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>ManufacturerName</p>
     * 
     * <p>Manufacturer Name</p>
     * 
     * <p><p>The name of the drug manufacturer.</p></p>
     * 
     * <p><p>Used for reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p></p>
     * 
     * <p><p>Used for reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p></p>
     * 
     * <p>Manufacturer Name</p>
     * 
     * <p><p>The name of the drug manufacturer.</p></p>
     * 
     * <p><p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p></p>
     * 
     * <p><p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p></p>
     * 
     * <p>Manufacturer Name</p>
     * 
     * <p><p>The name of the drug manufacturer.</p></p>
     * 
     * <p><p>DrugProduct.ManufacturerName</p><p>ZPC.6</p><p>RXA.17</p><p>C.1c</p><p>Manufacturer</p></p>
     * 
     * <p><p>DrugProduct.ManufacturerName</p><p>ZPC.6</p><p>RXA.17</p><p>C.1c</p><p>Manufacturer</p></p>
     * 
     * <p><p>DrugProduct.ManufacturerName</p><p>ZPC.6</p><p>RXA.17</p><p>C.1c</p><p>Manufacturer</p></p>
     * 
     * <p><p>DrugProduct.ManufacturerName</p><p>ZPC.6</p><p>RXA.17</p><p>C.1c</p><p>Manufacturer</p></p>
     * 
     * <p><p>DrugProduct.ManufacturerName</p><p>ZPC.6</p><p>RXA.17</p><p>C.1c</p><p>Manufacturer</p></p>
     * 
     * <p><p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p></p>
     * 
     * <p><p>Used in reporting.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; because there will always be a name 
     * for an organization.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }
    public void setName(String name) {
        this.name.setValue(name);
    }

}
