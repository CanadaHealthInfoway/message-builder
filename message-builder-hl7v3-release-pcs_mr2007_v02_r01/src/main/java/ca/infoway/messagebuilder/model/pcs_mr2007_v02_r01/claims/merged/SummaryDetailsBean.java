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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>QUCR_MT810201CA.AdjudResultsGroupSummaryData: Adjudicated 
 * Results Group Summary Data</p>
 * 
 * <p><p>Constrain Value to PQ or MO data types only</p></p>
 * 
 * <p><p>Used for SOFA queries only</p></p>
 * 
 * <p>FICR_MT610201CA.AdjudResultsGroupSummaryData: Summary 
 * Details</p>
 * 
 * <p><p>Constrain Value to PQ or MO data types only</p></p>
 * 
 * <p><p>Used for SOFA queries only</p></p>
 * 
 * <p>FICR_MT630000CA.AdjudResultsGroupSummaryData: Summary 
 * Details</p>
 * 
 * <p><p>Constrain Value to PQ or MO data types only</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudResultsGroupSummaryData","FICR_MT630000CA.AdjudResultsGroupSummaryData","QUCR_MT810201CA.AdjudResultsGroupSummaryData"})
public class SummaryDetailsBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private CV code = new CVImpl();
    private PQ value = new PQImpl();


    /**
     * <p>Summary Period Amt</p>
     * 
     * <p><p>Summary Period Amt</p></p>
     * 
     * <p><p>(defines the 'categorization'. Only really relevant 
     * for summaries.</p></p>
     * 
     * <p>Summary Type Code</p>
     * 
     * <p><p>summary type</p></p>
     * 
     * <p>Code for Type of Adjudicated Result</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Summary Total Amount</p>
     * 
     * <p><p>Summary Total</p></p>
     * 
     * <p><p>Data type can be PQ or MO only.</p></p>
     * 
     * <p>Value of summary</p>
     * 
     * <p><p>PQ or MO - Value of summary</p></p>
     * 
     * <p>Summary Total Amt</p>
     * 
     * <p><p>Summary Total Amt</p></p>
     * 
     * <p><p>PQ or MO only - Value of summary</p></p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }

}
