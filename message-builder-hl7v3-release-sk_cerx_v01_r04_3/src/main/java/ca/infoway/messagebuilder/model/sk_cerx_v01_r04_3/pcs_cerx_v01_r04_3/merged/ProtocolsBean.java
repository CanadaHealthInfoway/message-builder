/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Protocols</p>
 * 
 * <p>PORX_MT060340CA.SubstanceAdministrationDefinition: 
 * Protocols</p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Documentation of 
 * why a prescriber has chosen to prescribe the drug in the 
 * manner they have.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * linking to specific guidelines or protocols. Also used to 
 * provide additional detail needed when requesting a 
 * \342\200\230special access\342\200\231 drug from Health 
 * Canada.</p></p>
 * 
 * <p>PORX_MT060160CA.SubstanceAdministrationDefinition: 
 * Protocols</p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Documentation of 
 * why a prescriber has chosen to prescribe the drug in the 
 * manner they have.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * linking to specific guidelines or protocols. Also used to 
 * provide additional detail needed when requesting a 'special 
 * access' drug from Health Canada.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.SubstanceAdministrationDefinition","PORX_MT060160CA.SubstanceAdministrationDefinition","PORX_MT060340CA.SubstanceAdministrationDefinition"})
public class ProtocolsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II protocolIdentifiers = new IIImpl();


    /**
     * <p>ProtocolIdentifiers</p>
     * 
     * <p>Protocol Identifiers</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A unique 
     * identifier for a specific protocol or guideline which the 
     * prescription has been written in accordance with.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables the 
     * communication of a reference to a protocol, study or 
     * guideline id, specific to the jurisdiction;</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Allows providers 
     * to reference a protocol/guideline for prescribing to 
     * specific situations. This could also be used for 
     * justification for prescribing a medication from a particular 
     * formulary. E.g., 'Limited' Use\342\200\231 medications in 
     * Ontario require physicians to use a code indicating that a 
     * patient is eligible for this particular medication.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables the 
     * communication of a reference to a protocol, study or 
     * guideline id, specific to the jurisdiction;</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Allows providers 
     * to reference a protocol/guideline for prescribing to 
     * specific situations. This could also be used for 
     * justification for prescribing a medication from a particular 
     * formulary. E.g., 'Limited' Use\342\200\231 medications in 
     * Ontario require physicians to use a code indicating that a 
     * patient is eligible for this particular medication.</p></p>
     * 
     * <p>Protocol Identifiers</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A unique 
     * identifier for a specific protocol or guideline which the 
     * prescription has been written in accordance with.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables the 
     * communication of a reference to a protocol, study or 
     * guideline id, specific to the jurisdiction;</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Allows providers 
     * to reference a protocol/guideline for prescribing to 
     * specific situations. This could also be used for 
     * justification for prescribing a medication from a particular 
     * formulary. E.g., 'Limited Use' medications in Ontario 
     * require physicians to use a code indicating that a patient 
     * is eligible for this particular medication.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables the 
     * communication of a reference to a protocol, study or 
     * guideline id, specific to the jurisdiction;</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Allows providers 
     * to reference a protocol/guideline for prescribing to 
     * specific situations. This could also be used for 
     * justification for prescribing a medication from a particular 
     * formulary. E.g., 'Limited Use' medications in Ontario 
     * require physicians to use a code indicating that a patient 
     * is eligible for this particular medication.</p></p>
     * 
     * <p>H:Protocol Identifiers</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A unique 
     * identifier for a specific protocol or guideline which the 
     * prescription has been written in accordance with.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables the 
     * communication of a reference to a protocol, study or 
     * guideline id, specific to the jurisdiction;</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Allows providers 
     * to reference a protocol/guideline for prescribing to 
     * specific situations. This could also be used for 
     * justification for prescribing a medication from a particular 
     * formulary. E.g., 'Limited Use' medications in Ontario 
     * require physicians to use a code indicating that a patient 
     * is eligible for this particular medication</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Enables the 
     * communication of a reference to a protocol, study or 
     * guideline id, specific to the jurisdiction;</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Allows providers 
     * to reference a protocol/guideline for prescribing to 
     * specific situations. This could also be used for 
     * justification for prescribing a medication from a particular 
     * formulary. E.g., 'Limited Use' medications in Ontario 
     * require physicians to use a code indicating that a patient 
     * is eligible for this particular medication</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getProtocolIdentifiers() {
        return this.protocolIdentifiers.getValue();
    }
    public void setProtocolIdentifiers(Identifier protocolIdentifiers) {
        this.protocolIdentifiers.setValue(protocolIdentifiers);
    }

}
