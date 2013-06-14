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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.AdjudicationCodeChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActAdjudicationCode;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Adjudication Result</p>
 * 
 * <p>Result of adjudication</p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResult"})
public class AdjudicationResultBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV code = new CVImpl();
    private List<InvoiceElementChoice> referenceInvoiceElementChoice = new ArrayList<InvoiceElementChoice>();
    private List<AdjudicationCodeChoice> pertinentInformationAdjudicationCodeChoice = new ArrayList<AdjudicationCodeChoice>();


    /**
     * <p>Business Name: Code denoting adjudication results</p>
     * 
     * <p>Relationship: COCT_MT680000CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Summary of the adjudication processing - as submitted, 
     * w/ adjust, refuse adjust, refuse</p>
     */
    @Hl7XmlMapping({"code"})
    public ActAdjudicationCode getCode() {
        return (ActAdjudicationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Code denoting adjudication results</p>
     * 
     * <p>Relationship: COCT_MT680000CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Summary of the adjudication processing - as submitted, 
     * w/ adjust, refuse adjust, refuse</p>
     */
    public void setCode(ActAdjudicationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicationResultReference.invoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reference/invoiceElementChoice"})
    public List<InvoiceElementChoice> getReferenceInvoiceElementChoice() {
        return this.referenceInvoiceElementChoice;
    }


    /**
     * <p>Relationship: 
     * COCT_MT680000CA.AdditionalPertinentInformation.adjudicationCodeChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/adjudicationCodeChoice"})
    public List<AdjudicationCodeChoice> getPertinentInformationAdjudicationCodeChoice() {
        return this.pertinentInformationAdjudicationCodeChoice;
    }

}