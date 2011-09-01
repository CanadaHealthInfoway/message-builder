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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT220110CA.Manufacturer","COCT_MT220210CA.Manufacturer","POME_MT010040CA.Manufacturer","POME_MT010100CA.Manufacturer"})
public class ManufacturerBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private II id = new IIImpl();
    private ST manufacturerName = new STImpl();


    /**
     * <p>Organization Id</p>
     * 
     * <p>Manufacturer Id</p>
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
     */
    @Hl7XmlMapping({"name"})
    public String getManufacturerName() {
        return this.manufacturerName.getValue();
    }
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName.setValue(manufacturerName);
    }

}
