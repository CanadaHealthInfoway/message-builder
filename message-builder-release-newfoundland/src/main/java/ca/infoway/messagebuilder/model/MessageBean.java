package ca.infoway.messagebuilder.model;

import java.io.Serializable;

public interface MessageBean extends Serializable, InteractionBean {

    public MessageAttributesBean getMessageAttributes();

    public ControlActEventBean getControlActEvent();

    public AuthorBean getAuthor();
}
