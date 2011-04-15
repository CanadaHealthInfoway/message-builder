package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.model.InteractionBean;

public interface MessageBean extends Serializable, InteractionBean {

    public MessageAttributesBean getMessageAttributes();

    public ControlActEventBean getControlActEvent();

    public AuthorBean getAuthor();
}
