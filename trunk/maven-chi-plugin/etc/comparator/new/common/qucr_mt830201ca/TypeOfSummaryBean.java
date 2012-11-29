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
package ca.infoway.messagebuilder.model.common.qucr_mt830201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.AdjudicatedInvoiceElementGroupBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * <p>Type of Summary 
 * 
 * <p>(Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
 * Compound, Healthcare Goods, Preferred Accomodation 
 * 
 * <p>Detailed information required for financial 
 * reconciliation. 
 * 
 * <p>The AdjudResultsGroup.netAmt must equal the sum of all 
 * immediate children AdjudResultsGroup.netAmt 
 */
@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudResultsGroup"})
@Hl7RootType
public class TypeOfSummaryBean extends MessagePartBean {

    private CD<Code> code = new CDImpl<Code>();
    private IVL<TS, Interval<Date>> summaryPeriodDateRange = new IVLImpl<TS, Interval<Date>>();
    private MO summaryPeriodAmt = new MOImpl();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();

    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getSummaryPeriodDateRange() {
        return this.summaryPeriodDateRange.getValue();
    }
    public void setSummaryPeriodDateRange(Interval<Date> summaryPeriodDateRange) {
        this.summaryPeriodDateRange.setValue(summaryPeriodDateRange);
    }

    @Hl7XmlMapping({"netAmt"})
    public Money getSummaryPeriodAmt() {
        return this.summaryPeriodAmt.getValue();
    }
    public void setSummaryPeriodAmt(Money summaryPeriodAmt) {
        this.summaryPeriodAmt.setValue(summaryPeriodAmt);
    }

    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }

}
