/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Drug Half-Life</p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Specification of 
 * the length of time a particular drug remains in the body (as 
 * active)</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Impacts 
 * contraindication checking for drugs no longer being taken by 
 * patients.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.HalfLife"})
public class DrugHalfLifeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private PQ halfLifePeriod = new PQImpl();


    /**
     * <p>Half-Life Period</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Different 
     * drugs are absorbed and degraded by the body at different 
     * rates. The half-life indicates the length of time necessary 
     * for a human body to degrade the drug to half its original 
     * potency. The actual time-period will vary from person to 
     * person based on mass, renal function, liver function, route 
     * of administration and other factors</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DrugProduct.HalfLifePeriod</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Depending on 
     * the half-life, a drug may remain present and active in a 
     * patient's system long after they cease taking it. 
     * Understanding this time period is essential to appropriate 
     * dosing, and also to identifying when to include medications 
     * in drug-drug interaction checking.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getHalfLifePeriod() {
        return this.halfLifePeriod.getValue();
    }
    public void setHalfLifePeriod(PhysicalQuantity halfLifePeriod) {
        this.halfLifePeriod.setValue(halfLifePeriod);
    }

}
