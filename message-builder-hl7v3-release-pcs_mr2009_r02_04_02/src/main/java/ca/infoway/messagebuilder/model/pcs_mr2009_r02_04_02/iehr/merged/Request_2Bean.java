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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActClassCareProvisionObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Request</p>
 * 
 * <p>REPC_MT230003CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT230001CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT410001CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT420001CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT230002CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT420003CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 */
@Hl7PartTypeMapping({"REPC_MT230001CA.ActRequest","REPC_MT230002CA.ActRequest","REPC_MT230003CA.ActRequest","REPC_MT410001CA.ActRequest","REPC_MT410003CA.ActRequest","REPC_MT420001CA.ActRequest","REPC_MT420003CA.ActRequest"})
public class Request_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CS requestType = new CSImpl();
    private II requestId = new IIImpl();
    private RequestedByBean author;


    /**
     * <p>RequestType</p>
     * 
     * <p>Request Type</p>
     * 
     * <p>Request Type</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>B: Request Type</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>Request Type</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_ActClassCareProvisionObservation getRequestType() {
        return (x_ActClassCareProvisionObservation) this.requestType.getValue();
    }
    public void setRequestType(x_ActClassCareProvisionObservation requestType) {
        this.requestType.setValue(requestType);
    }


    /**
     * <p>RequestId</p>
     * 
     * <p>Request Id</p>
     * 
     * <p>A: Request Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>Request Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>Request Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getRequestId() {
        return this.requestId.getValue();
    }
    public void setRequestId(Identifier requestId) {
        this.requestId.setValue(requestId);
    }


    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }

}
