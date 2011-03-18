/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.coct_mt130001ca;

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
import ca.infoway.messagebuilder.model.v02_r01.merged.ChangedByBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT130001CA.ControlActEvent"})
@Hl7RootType
public class VersionInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV changeReason = new CVImpl();
    private ChangedByBean author;
    private II changeIdentifier = new IIImpl();
    private IVL<TS, Interval<Date>> changeEffectiveDateAndEndDate = new IVLImpl<TS, Interval<Date>>();
    private CV changeType = new CVImpl();


    /**
     * <p>D:Change Reason</p>
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


    /**
     * <p>B:Change Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getChangeIdentifier() {
        return this.changeIdentifier.getValue();
    }
    public void setChangeIdentifier(Identifier changeIdentifier) {
        this.changeIdentifier.setValue(changeIdentifier);
    }


    /**
     * <p>C:Change Effective Date and End Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getChangeEffectiveDateAndEndDate() {
        return this.changeEffectiveDateAndEndDate.getValue();
    }
    public void setChangeEffectiveDateAndEndDate(Interval<Date> changeEffectiveDateAndEndDate) {
        this.changeEffectiveDateAndEndDate.setValue(changeEffectiveDateAndEndDate);
    }


    /**
     * <p>A:Change Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getChangeType() {
        return (HL7TriggerEventCode) this.changeType.getValue();
    }
    public void setChangeType(HL7TriggerEventCode changeType) {
        this.changeType.setValue(changeType);
    }

}
