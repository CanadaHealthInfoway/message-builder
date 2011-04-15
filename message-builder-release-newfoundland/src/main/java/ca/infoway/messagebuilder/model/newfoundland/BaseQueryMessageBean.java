package ca.infoway.messagebuilder.model.newfoundland;

import ca.infoway.messagebuilder.datatype.lang.Identifier;

public interface BaseQueryMessageBean<T extends QueryCriteria> extends MessageBean {

    public Identifier getQueryId();

    public void setQueryId(Identifier queryId);

    public T getCriteria();
}
