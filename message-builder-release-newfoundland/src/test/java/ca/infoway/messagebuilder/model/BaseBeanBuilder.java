package ca.infoway.messagebuilder.model;

import java.io.Serializable;

public class BaseBeanBuilder<T extends Serializable> {
	
	protected final T bean;
	
	public BaseBeanBuilder(T bean) {
		this.bean = bean;
	}
	
	public T create() {
		return bean;
	}

}
