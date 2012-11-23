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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Filler Order</p>
 * 
 * <p>The filler order communiates the intended testing (as 
 * opposed to the requested tests).</p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.ActPromise"})
public class FillerOrderBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.FulfillmentChoice {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();


    /**
     * <p>Filler Order Identifier</p>
     * 
     * <p>The unique identfier for the filler order or promise.</p>
     * 
     * <p>The promise id is mandatory as it is necessary to create 
     * the association (act relationship).</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Filler Order Identifier</p>
     * 
     * <p>The unique identfier for the filler order or promise.</p>
     * 
     * <p>The promise id is mandatory as it is necessary to create 
     * the association (act relationship).</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
