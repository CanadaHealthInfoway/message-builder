/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt980040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT980040CA.ActEventCriterion"})
public class AdministrationPreconditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ST dosageCondition = new STImpl();


    /**
     * <p>A:Dosage Condition</p>
     */
    @Hl7XmlMapping({"text"})
    public String getDosageCondition() {
        return this.dosageCondition.getValue();
    }
    public void setDosageCondition(String dosageCondition) {
        this.dosageCondition.setValue(dosageCondition);
    }

}
