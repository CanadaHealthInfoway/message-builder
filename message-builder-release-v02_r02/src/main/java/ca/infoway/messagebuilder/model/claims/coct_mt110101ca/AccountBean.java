/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.coct_mt110101ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Payor identifier, assigned by adjudicator.</p>
 */
@Hl7PartTypeMapping({"COCT_MT110101CA.Account"})
@Hl7RootType
public class AccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private SET<II, Identifier> payorIdentifier = new SETImpl<II, Identifier>(IIImpl.class);

    @Hl7XmlMapping({"holder/payorRole/id"})
    public Set<Identifier> getPayorIdentifier() {
        return this.payorIdentifier.rawSet();
    }

}
