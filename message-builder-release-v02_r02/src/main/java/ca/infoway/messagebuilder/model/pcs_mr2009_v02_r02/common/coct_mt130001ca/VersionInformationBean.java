/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.common.coct_mt130001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.merged.ChangedByBean;

import java.util.Date;



/**
 * <p>Version Information</p>
 * 
 * <p><p>This records the history of changes that have been 
 * made to the record, including why the changes were made, who 
 * made them and when.</p></p>
 * 
 * <p><p>Provides a record changes, providing deeper clinical 
 * understanding, particularly of past clinical decisions.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT130001CA.ControlActEvent"})
@Hl7RootType
public class VersionInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II changeIdentifier = new IIImpl();
    private CV changeType = new CVImpl();
    private IVL<TS, Interval<Date>> changeEffectiveDateAndEndDate = new IVLImpl<TS, Interval<Date>>();
    private CV changeReason = new CVImpl();
    private ChangedByBean author;


    /**
     * <p>B:Change Identifier</p>
     * 
     * <p><p>A unique identifier for this particular change.</p></p>
     * 
     * <p><p>Allows referencing (and potentially undoing) a 
     * specific change. Every status change has an identifier, thus 
     * this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getChangeIdentifier() {
        return this.changeIdentifier.getValue();
    }
    public void setChangeIdentifier(Identifier changeIdentifier) {
        this.changeIdentifier.setValue(changeIdentifier);
    }


    /**
     * <p>A:Change Type</p>
     * 
     * <p><p>Identifies what kind of change occurred.</p></p>
     * 
     * <p><p>This attribute is mandatory to ensure that change 
     * types are distinguishable.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getChangeType() {
        return (HL7TriggerEventCode) this.changeType.getValue();
    }
    public void setChangeType(HL7TriggerEventCode changeType) {
        this.changeType.setValue(changeType);
    }


    /**
     * <p>C:Change Effective Date and End Date</p>
     * 
     * <p><p>The date on which the various changes of an event 
     * become valid and applicable and potentially when the change 
     * is supposed to cease.</p></p>
     * 
     * <p><p>Allows applications to sort and filter by time. The 
     * date on which a change is effective should always be known 
     * and thus is mandatory. The end date may be left unspecified 
     * if there isn't a specific targetted end date (e.g. with a 
     * suspend including a planned release date).</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getChangeEffectiveDateAndEndDate() {
        return this.changeEffectiveDateAndEndDate.getValue();
    }
    public void setChangeEffectiveDateAndEndDate(Interval<Date> changeEffectiveDateAndEndDate) {
        this.changeEffectiveDateAndEndDate.setValue(changeEffectiveDateAndEndDate);
    }


    /**
     * <p>D:Change Reason</p>
     * 
     * <p><p>Denotes the reason the record was modified.</p></p>
     * 
     * <p><p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getChangeReason() {
        return (ControlActReason) this.changeReason.getValue();
    }
    public void setChangeReason(ControlActReason changeReason) {
        this.changeReason.setValue(changeReason);
    }


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }

}