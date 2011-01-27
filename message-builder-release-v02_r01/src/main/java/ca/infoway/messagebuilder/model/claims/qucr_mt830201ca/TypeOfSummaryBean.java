/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.qucr_mt830201ca;

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
import ca.infoway.messagebuilder.model.claims.merged.AdjudicationResultIdentifierBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudResultsGroup"})
@Hl7RootType
public class TypeOfSummaryBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private MO summaryPeriodAmt = new MOImpl();
    private List<AdjudicationResultIdentifierBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicationResultIdentifierBean>();
    private IVL<TS, Interval<Date>> summaryPeriodDateRange = new IVLImpl<TS, Interval<Date>>();
    private CD code = new CDImpl();


    /**
     * <p>Summary Period Amt</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getSummaryPeriodAmt() {
        return this.summaryPeriodAmt.getValue();
    }
    public void setSummaryPeriodAmt(Money summaryPeriodAmt) {
        this.summaryPeriodAmt.setValue(summaryPeriodAmt);
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicationResultIdentifierBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


    /**
     * <p>Summary period date range</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getSummaryPeriodDateRange() {
        return this.summaryPeriodDateRange.getValue();
    }
    public void setSummaryPeriodDateRange(Interval<Date> summaryPeriodDateRange) {
        this.summaryPeriodDateRange.setValue(summaryPeriodDateRange);
    }


    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }

}
