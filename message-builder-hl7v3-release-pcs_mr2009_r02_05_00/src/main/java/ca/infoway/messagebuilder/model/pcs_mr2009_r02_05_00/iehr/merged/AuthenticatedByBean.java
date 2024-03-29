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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt911108ca.ActingPerson;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT220001CA.Authenticator","REPC_MT220002CA.Authenticator","REPC_MT220003CA.Authenticator","REPC_MT230001CA.Authenticator","REPC_MT230002CA.Authenticator","REPC_MT230003CA.Authenticator"})
public class AuthenticatedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private TS time = new TSImpl();
    private ActingPerson actingPerson;
    private ED<String> signatureText = new EDImpl<String>();


    /**
     * <p>Un-merged Business Name: ValidatedDatetime</p>
     * 
     * <p>Relationship: REPC_MT220002CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The Date and time that the clinical document was 
     * authenticated.</p>
     * 
     * <p>Un-merged Business Name: DateVerified</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date that the document was verified.</p>
     * 
     * <p>Un-merged Business Name: DateVerified</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date that the document was verified.</p>
     * 
     * <p>Un-merged Business Name: DateVerified</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date that the document was verified.</p>
     * 
     * <p>Un-merged Business Name: ValidatedDatetime</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The Date and time that the clinical document was 
     * authenticated.</p>
     * 
     * <p>Un-merged Business Name: ValidatedDatetime</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The Date andl time that the clinical document was 
     * authenticated.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Un-merged Business Name: ValidatedDatetime</p>
     * 
     * <p>Relationship: REPC_MT220002CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The Date and time that the clinical document was 
     * authenticated.</p>
     * 
     * <p>Un-merged Business Name: DateVerified</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date that the document was verified.</p>
     * 
     * <p>Un-merged Business Name: DateVerified</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date that the document was verified.</p>
     * 
     * <p>Un-merged Business Name: DateVerified</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date that the document was verified.</p>
     * 
     * <p>Un-merged Business Name: ValidatedDatetime</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The Date and time that the clinical document was 
     * authenticated.</p>
     * 
     * <p>Un-merged Business Name: ValidatedDatetime</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Authenticator.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The Date andl time that the clinical document was 
     * authenticated.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"actingPerson"})
    public ActingPerson getActingPerson() {
        return this.actingPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Authenticator.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setActingPerson(ActingPerson actingPerson) {
        this.actingPerson = actingPerson;
    }


    /**
     * <p>Business Name: VerifierSignature</p>
     * 
     * <p>Un-merged Business Name: VerifierSignature</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Authenticator.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The electronic signature of the clinical document 
     * verifier.</p>
     * 
     * <p>Un-merged Business Name: VerifierSignature</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Authenticator.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The electronic signature of the clinical document 
     * verifier.</p>
     * 
     * <p>Un-merged Business Name: VerifierSignature</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Authenticator.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The electronic signature of the clinical document 
     * verifier.</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }

    /**
     * <p>Business Name: VerifierSignature</p>
     * 
     * <p>Un-merged Business Name: VerifierSignature</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Authenticator.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The electronic signature of the clinical document 
     * verifier.</p>
     * 
     * <p>Un-merged Business Name: VerifierSignature</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Authenticator.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The electronic signature of the clinical document 
     * verifier.</p>
     * 
     * <p>Un-merged Business Name: VerifierSignature</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Authenticator.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The electronic signature of the clinical document 
     * verifier.</p>
     */
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }

}
