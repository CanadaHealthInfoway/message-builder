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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.ficr_mt490003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActSpecialAuthorizationCode;



@Hl7PartTypeMapping({"FICR_MT490003CA.SpecialAuthorizationRequest"})
public class SpecialAuthorizationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();


    /**
     * <p>Business Name: Special Authorization Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Special Authorization Request Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSpecialAuthorizationCode getCode() {
        return (ActSpecialAuthorizationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Request Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActSpecialAuthorizationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Request Status</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Request Status</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

}
