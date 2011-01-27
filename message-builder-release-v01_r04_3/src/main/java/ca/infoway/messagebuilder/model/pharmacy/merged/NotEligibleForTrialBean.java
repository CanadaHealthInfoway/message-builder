/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT060160CA.Component2","PORX_MT060340CA.Component2"})
public class NotEligibleForTrialBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private BL trialSupplyPermission = new BLImpl(false);
    private BL notEligibleForTrial = new BLImpl();


    @Hl7XmlMapping({"trialSupplyPermission"})
    public Boolean getTrialSupplyPermission() {
        return this.trialSupplyPermission.getValue();
    }
    public void setTrialSupplyPermission(Boolean trialSupplyPermission) {
        this.trialSupplyPermission.setValue(trialSupplyPermission);
    }


    /**
     * <p>NotEligibleForTrial</p>
     * 
     * <p>Not Eligible for Trial?</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNotEligibleForTrial() {
        return this.notEligibleForTrial.getValue();
    }
    public void setNotEligibleForTrial(Boolean notEligibleForTrial) {
        this.notEligibleForTrial.setValue(notEligibleForTrial);
    }

}
