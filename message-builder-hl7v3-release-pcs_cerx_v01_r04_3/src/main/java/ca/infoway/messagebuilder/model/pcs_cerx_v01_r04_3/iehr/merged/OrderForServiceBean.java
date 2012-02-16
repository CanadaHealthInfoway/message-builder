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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;



/**
 * <p>OrderForService</p>
 * 
 * <p>REPC_MT100001CA.ActRequest: Order for Service</p>
 * 
 * <p><p>Represents the order or prescription against which the 
 * service was performed.</p></p>
 * 
 * <p><p>Allows linking the service to the person responsible 
 * for requesting it.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000017CA.ActRequest","REPC_MT100001CA.ActRequest"})
public class OrderForServiceBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private RefusedByBean author;


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }

}
