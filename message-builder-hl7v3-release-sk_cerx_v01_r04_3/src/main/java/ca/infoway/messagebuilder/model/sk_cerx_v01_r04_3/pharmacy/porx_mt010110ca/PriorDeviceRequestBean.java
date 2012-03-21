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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt010110ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.PriorDeviceRequest"})
public class PriorDeviceRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20120320L;
    private II id = new IIImpl();


    /**
     * <p>B:Previous Prescription Order Number</p>
     * 
     * <p><p>A reference to a previous prescription which the 
     * current prescription replaces.</p></p>
     * 
     * <p><p>New or Repeat (if present, then Repeat)</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
