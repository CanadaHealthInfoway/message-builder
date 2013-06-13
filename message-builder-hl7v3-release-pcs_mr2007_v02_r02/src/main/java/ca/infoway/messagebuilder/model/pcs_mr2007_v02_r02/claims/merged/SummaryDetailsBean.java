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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActInvoiceElementSummaryCode;



/**
 * <p>QUCR_MT810201CA.AdjudResultsGroupSummaryData: Adjudicated 
 * Results Group Summary Data</p>
 * 
 * <p>Constrain Value to PQ or MO data types only</p>
 * 
 * <p>Used for SOFA queries only</p>
 * 
 * <p>FICR_MT610201CA.AdjudResultsGroupSummaryData: Summary 
 * Details</p>
 * 
 * <p>Constrain Value to PQ or MO data types only</p>
 * 
 * <p>Used for SOFA queries only</p>
 * 
 * <p>FICR_MT630000CA.AdjudResultsGroupSummaryData: Summary 
 * Details</p>
 * 
 * <p>Constrain Value to PQ or MO data types only</p>
 * 
 * <p>Summarised Details of the Adjudicated Results for a group 
 * of Invoice elements/line items.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudResultsGroupSummaryData","FICR_MT630000CA.AdjudResultsGroupSummaryData","QUCR_MT810201CA.AdjudResultsGroupSummaryData"})
public class SummaryDetailsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV code = new CVImpl();
    private PQ value = new PQImpl();


    /**
     * <p>Un-merged Business Name: CodeForTypeOfAdjudicatedResult</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupSummaryData.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: SummaryTypeCode</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroupSummaryData.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Identify the different types of summary information.</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodAmt</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsGroupSummaryData.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>(defines the 'categorization'. Only really relevant for 
     * summaries.</p>
     * 
     * <p>Summary Period Amt</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceElementSummaryCode getCode() {
        return (ActInvoiceElementSummaryCode) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: CodeForTypeOfAdjudicatedResult</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupSummaryData.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: SummaryTypeCode</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroupSummaryData.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Identify the different types of summary information.</p>
     * 
     * <p>Un-merged Business Name: SummaryPeriodAmt</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsGroupSummaryData.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>(defines the 'categorization'. Only really relevant for 
     * summaries.</p>
     * 
     * <p>Summary Period Amt</p>
     */
    public void setCode(ActInvoiceElementSummaryCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: ValueOfSummary</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupSummaryData.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>PQ or MO - Value of summary</p>
     * 
     * <p>Un-merged Business Name: SummaryTotalAmount</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroupSummaryData.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Data type can be PQ or MO only.</p>
     * 
     * <p>Summary Total</p>
     * 
     * <p>Un-merged Business Name: SummaryTotalAmt</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsGroupSummaryData.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>PQ or MO only - Value of summary</p>
     * 
     * <p>Summary Total Amt</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Un-merged Business Name: ValueOfSummary</p>
     * 
     * <p>Relationship: 
     * QUCR_MT810201CA.AdjudResultsGroupSummaryData.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>PQ or MO - Value of summary</p>
     * 
     * <p>Un-merged Business Name: SummaryTotalAmount</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudResultsGroupSummaryData.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Data type can be PQ or MO only.</p>
     * 
     * <p>Summary Total</p>
     * 
     * <p>Un-merged Business Name: SummaryTotalAmt</p>
     * 
     * <p>Relationship: 
     * FICR_MT630000CA.AdjudResultsGroupSummaryData.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>PQ or MO only - Value of summary</p>
     * 
     * <p>Summary Total Amt</p>
     */
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }

}
