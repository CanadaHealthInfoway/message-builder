/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.coct_mt260030ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r02.common.coct_mt220210ca.DrugProductBean;



/**
 * <p>*a:dispensed</p>
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
@Hl7PartTypeMapping({"COCT_MT260030CA.Product"})
public class DispensedBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private DrugProductBean medication;


    @Hl7XmlMapping({"medication"})
    public DrugProductBean getMedication() {
        return this.medication;
    }
    public void setMedication(DrugProductBean medication) {
        this.medication = medication;
    }

}