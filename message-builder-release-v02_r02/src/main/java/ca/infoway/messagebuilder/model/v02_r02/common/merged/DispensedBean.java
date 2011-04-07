/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r02.common.coct_mt220200ca.DrugProductBean;



/**
 * <p>Dispensed</p>
 * 
 * <p>COCT_MT260020CA.Product: *a:dispensed</p>
 * 
 * <p><p>Indicates the implicated drug that was dispensed.</p></p>
 * 
 * <p><p>Important information for issue management.</p><p>The 
 * association is only marked as 'populated' because it may be 
 * masked.</p></p>
 * 
 * <p><p>Important information for issue management.</p><p>The 
 * association is only marked as 'populated' because it may be 
 * masked.</p></p>
 * 
 * <p>COCT_MT260010CA.Product: *a:dispensed</p>
 * 
 * <p><p>Indicates the drug that was dispensed</p></p>
 * 
 * <p><p>Important information for issue management.</p><p>The 
 * association is marked as populated because it may be 
 * masked.</p></p>
 * 
 * <p><p>Important information for issue management.</p><p>The 
 * association is marked as populated because it may be 
 * masked.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.Product","COCT_MT260020CA.Product"})
public class DispensedBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private DrugProductBean medication;


    @Hl7XmlMapping({"medication"})
    public DrugProductBean getMedication() {
        return this.medication;
    }
    public void setMedication(DrugProductBean medication) {
        this.medication = medication;
    }

}
