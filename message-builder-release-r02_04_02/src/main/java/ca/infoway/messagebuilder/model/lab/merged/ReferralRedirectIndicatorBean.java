/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ReferralRedirectIndicator</p>
 * 
 * <p>POLB_MT001000CA.ReferralRedirectIndicator: Referral 
 * Redirect Indicator</p>
 * 
 * <p><p>This referral redirect flag object is present and the 
 * code is set to &quot;referral&quot; when the order is a 
 * referral order (an order from labA to labB, labA will report 
 * all results), set to &quot;redirect&quot; when the order is 
 * a redirect order (an order from labA to labB, labB will 
 * report the results to ordering provider), or this object is 
 * absent from orders requested by providers.</p></p>
 * 
 * <p><p>OLIS needs a flag at the ObservationRequest level test 
 * request to identify a &quot;reference&quot; test request 
 * because this limits the visibility of the test request in 
 * OLIS to the laboratory sector (i.e., practitioners and 
 * hospitals can't retrieve reference test requests).</p></p>
 * 
 * <p>POLB_MT001001CA.ReferralRedirectIndicator: Referral 
 * Redirect Indicator</p>
 * 
 * <p><p>This referral redirect flag object is present and the 
 * code is set to &quot;referral&quot; when the order is a 
 * referral order (an order from labA to labB, labA will report 
 * all results), set to &quot;redirect&quot; when the order is 
 * a redirect order (an order from labA to labB, labB will 
 * report the results to ordering provider), or this object is 
 * absent from orders requested by providers.</p></p>
 * 
 * <p><p>OLIS needs a flag at the ObservationRequest level test 
 * request to identify a &quot;reference&quot; test request 
 * because this limits the visibility of the test request in 
 * OLIS to the laboratory sector (i.e., practitioners and 
 * hospitals can't retrieve reference test requests).</p></p>
 * 
 * <p>POLB_MT001999CA.ReferralRedirectIndicator: Referral 
 * Redirect Indicator</p>
 * 
 * <p><p>This referral redirect flag object is present and the 
 * code is set to &quot;referral&quot; when the order is a 
 * referral order (an order from labA to labB, labA will report 
 * all results), set to &quot;redirect&quot; when the order is 
 * a redirect order (an order from labA to labB, labB will 
 * report the results to ordering provider), or this object is 
 * absent from orders requested by providers.</p></p>
 * 
 * <p><p>OLIS needs a flag at the ObservationRequest level test 
 * request to identify a &quot;reference&quot; test request 
 * because this limits the visibility of the test request in 
 * OLIS to the laboratory sector (i.e., practitioners and 
 * hospitals can't retrieve reference test requests).</p></p>
 * 
 * <p>POLB_MT001010CA.ReferralRedirectIndicator: Referral 
 * Redirect Indicator</p>
 * 
 * <p><p>This referral redirect flag object is present and the 
 * code is set to &quot;referral&quot; when the order is a 
 * referral order (an order from labA to labB, labA will report 
 * all results), set to &quot;redirect&quot; when the order is 
 * a redirect order (an order from labA to labB, labB will 
 * report the results to ordering provider), or this object is 
 * absent from orders requested by providers.</p></p>
 * 
 * <p><p>OLIS needs a flag at the ObservationRequest level test 
 * request to identify a &quot;reference&quot; test request 
 * because this limits the visibility of the test request in 
 * OLIS to the laboratory sector (i.e., practitioners and 
 * hospitals can't retrieve reference test requests).</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.ReferralRedirectIndicator","POLB_MT001001CA.ReferralRedirectIndicator","POLB_MT001010CA.ReferralRedirectIndicator","POLB_MT001999CA.ReferralRedirectIndicator"})
public class ReferralRedirectIndicatorBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CD referralRedirectIndicator = new CDImpl();


    /**
     * <p>ReferralRedirectIndicator</p>
     * 
     * <p>O:Referral Redirect Indicator</p>
     * 
     * <p><p>Describes this act event as a referral or redirect 
     * indicator act.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getReferralRedirectIndicator() {
        return (Code) this.referralRedirectIndicator.getValue();
    }
    public void setReferralRedirectIndicator(Code referralRedirectIndicator) {
        this.referralRedirectIndicator.setValue(referralRedirectIndicator);
    }

}
