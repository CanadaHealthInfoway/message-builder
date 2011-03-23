/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCAI_MT700210CA.AuthorizationToken","MCAI_MT700211CA.AuthorizationToken","MCAI_MT700212CA.AuthorizationToken","MCAI_MT700220CA.AuthorizationToken","MCAI_MT700221CA.AuthorizationToken","MCAI_MT700222CA.AuthorizationToken","MCAI_MT700230CA.AuthorizationToken","MCAI_MT700231CA.AuthorizationToken","MCAI_MT700232CA.AuthorizationToken","MFMI_MT700711CA.AuthorizationToken","MFMI_MT700751CA.AuthorizationToken","QUQI_MT020000CA.AuthorizationToken","QUQI_MT020002CA.AuthorizationToken"})
public class AuthenticationTokenBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II authorizationTokenAsId = new IIImpl();
    private ST authorizationToken = new STImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getAuthorizationTokenAsId() {
        return this.authorizationTokenAsId.getValue();
    }
    public void setAuthorizationTokenAsId(Identifier authorizationTokenAsId) {
        this.authorizationTokenAsId.setValue(authorizationTokenAsId);
    }

    @Hl7XmlMapping({"text"})
    public String getAuthorizationToken() {
        return this.authorizationToken.getValue();
    }
    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken.setValue(authorizationToken);
    }

}
