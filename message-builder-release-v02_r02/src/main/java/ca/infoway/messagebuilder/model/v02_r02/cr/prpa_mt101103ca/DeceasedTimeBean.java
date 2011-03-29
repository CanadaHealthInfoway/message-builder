/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PRPA_MT101103CA.DeceasedTime"})
public class DeceasedTimeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private TS deceasedDate = new TSImpl();


    /**
     * <p>Deceased Date</p>
     */
    @Hl7XmlMapping({"value"})
    public Date getDeceasedDate() {
        return this.deceasedDate.getValue();
    }
    public void setDeceasedDate(Date deceasedDate) {
        this.deceasedDate.setValue(deceasedDate);
    }

}