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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Cross Reference Identifier</p>
 * 
 * <p>Identifier required to link invoices.</p>
 * 
 * <p>Unique identifier used for cross-referrence.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementCrossReference"})
public class CrossReferenceIdentifierBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: Cross Reference Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementCrossReference.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Includes references to authorization, coverage extension 
     * and pre-determination results. The identifier is the Root 
     * Adjudicated Invoice Element Group ID, returned on the 
     * previous authorization, coverage extension or 
     * pre-determination results.</p><p>In some situations, the 
     * authorization, coverage extension and pre-determination 
     * number may not be available to the submitter electronically. 
     * Therefore, the OID root may not be available. Current action 
     * item raised to determine if the OID root can be optional for 
     * this situation.</p><p>Previous adjudication results are not 
     * referenced with this mechanism</p><p>May also be used for 
     * other identifiers that have been assigned by external 
     * agencies through a manual process, that if supplied on an 
     * Invoice, would result in payment.</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>Includes references to authorization, coverage extension 
     * and pre-determination results. Previous adjudication results 
     * are not referenced with this mechanism</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Cross Reference Identifier</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementCrossReference.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Includes references to authorization, coverage extension 
     * and pre-determination results. The identifier is the Root 
     * Adjudicated Invoice Element Group ID, returned on the 
     * previous authorization, coverage extension or 
     * pre-determination results.</p><p>In some situations, the 
     * authorization, coverage extension and pre-determination 
     * number may not be available to the submitter electronically. 
     * Therefore, the OID root may not be available. Current action 
     * item raised to determine if the OID root can be optional for 
     * this situation.</p><p>Previous adjudication results are not 
     * referenced with this mechanism</p><p>May also be used for 
     * other identifiers that have been assigned by external 
     * agencies through a manual process, that if supplied on an 
     * Invoice, would result in payment.</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>Includes references to authorization, coverage extension 
     * and pre-determination results. Previous adjudication results 
     * are not referenced with this mechanism</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
