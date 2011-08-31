/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060110ca;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060110CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV issueFilterCode = new CVImpl();
    private BL mostRecentByDrugIndicator = new BLImpl();
    private BL mostRecentDispenseForEachRxIndicator = new BLImpl();


    /**
     * <p>D:Administration Effective Period</p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Allows the requester to specify the administration 
     * period of interest for the retrieval. Useful for 
     * constraining run-away queries.</p></p>
     * 
     * <p><p>The determination for applicability for inclusion in 
     * the query response should be considered to be the 'Pick up 
     * date plus the days supply'</p></p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }
    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }


    /**
     * <p>Issue Filter Code</p>
     * 
     * <p><p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p></p>
     * 
     * <p><p>By filtering returned records to include only those 
     * which have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p></p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCode() {
        return (IssueFilterCode) this.issueFilterCode.getValue();
    }
    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }


    /**
     * <p>Most Recent By Drug Indicator</p>
     * 
     * <p><p>Indicates whether or not the medication records are to 
     * be retrieved based on the most recent by Drug Code. If true, 
     * only the most recent prescription, dispense or other active 
     * medication for a particular drug generic classification will 
     * be returned. The default is 'FALSE' indicating that 
     * retrieval of prescription, dispense and other active 
     * medication records should not be limited to one per 
     * drug.</p></p>
     * 
     * <p><p>Helps decrease the volume of records returned, while 
     * still maintaining information on all drugs that the patient 
     * is on.</p><p>Because this is a boolean attribute whose value 
     * must be known to evaluate the query, the attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Helps decrease the volume of records returned, while 
     * still maintaining information on all drugs that the patient 
     * is on.</p><p>Because this is a boolean attribute whose value 
     * must be known to evaluate the query, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"mostRecentByDrugIndicator/value"})
    public Boolean getMostRecentByDrugIndicator() {
        return this.mostRecentByDrugIndicator.getValue();
    }
    public void setMostRecentByDrugIndicator(Boolean mostRecentByDrugIndicator) {
        this.mostRecentByDrugIndicator.setValue(mostRecentByDrugIndicator);
    }


    /**
     * <p>Most Recent Dispense for each Rx Indicator</p>
     * 
     * <p><p>Indicates whether or not prescription dispenses 
     * returned on a query should be limited to only the most 
     * recent dispense for a prescription order.</p><p>Allows for 
     * the returning of at most one prescription dispense record 
     * per a prescription.</p><p>The default is 'TRUE' indicating 
     * that retrieval should be for only the most recent dispense 
     * for a prescription is to be included in a query result.</p></p>
     * 
     * <p><p>Indicates whether or not prescription dispenses 
     * returned on a query should be limited to only the most 
     * recent dispense for a prescription order.</p><p>Allows for 
     * the returning of at most one prescription dispense record 
     * per a prescription.</p><p>The default is 'TRUE' indicating 
     * that retrieval should be for only the most recent dispense 
     * for a prescription is to be included in a query result.</p></p>
     * 
     * <p><p>Indicates whether or not prescription dispenses 
     * returned on a query should be limited to only the most 
     * recent dispense for a prescription order.</p><p>Allows for 
     * the returning of at most one prescription dispense record 
     * per a prescription.</p><p>The default is 'TRUE' indicating 
     * that retrieval should be for only the most recent dispense 
     * for a prescription is to be included in a query result.</p></p>
     * 
     * <p><p>Helps to trim down volume of query response by 
     * eliminating multiple prescription dispenses for the same 
     * prescription order.</p><p>Because this is a boolean 
     * attribute whose value must be known to evaluate the query, 
     * the attribute is mandatory.</p></p>
     * 
     * <p><p>Helps to trim down volume of query response by 
     * eliminating multiple prescription dispenses for the same 
     * prescription order.</p><p>Because this is a boolean 
     * attribute whose value must be known to evaluate the query, 
     * the attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"mostRecentDispenseForEachRxIndicator/value"})
    public Boolean getMostRecentDispenseForEachRxIndicator() {
        return this.mostRecentDispenseForEachRxIndicator.getValue();
    }
    public void setMostRecentDispenseForEachRxIndicator(Boolean mostRecentDispenseForEachRxIndicator) {
        this.mostRecentDispenseForEachRxIndicator.setValue(mostRecentDispenseForEachRxIndicator);
    }

}
