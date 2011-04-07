/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Pharmacist Role</p>
 * 
 * <p><p>Details of the pharmacist</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.PharmacistRole"})
public class PharmacistRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private SET<II, Identifier> pharmacistID = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>Pharmacist ID</p>
     * 
     * <p><p>Pharmacist ID</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getPharmacistID() {
        return this.pharmacistID.rawSet();
    }

}
