package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

class Tuple<T> {
	private final T name1;
	private final T name2;
	public Tuple(T name1, T name2) {
		this.name1 = name1;
		this.name2 = name2;
	}
	public int hashCode() {
		return new HashCodeBuilder().append(this.name1).append(this.name2).toHashCode();
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj.getClass() != getClass()) {
			return false;
		} else {
			Tuple<T> that = (Tuple<T>) obj;
			return new EqualsBuilder().append(this.name1, that.name1)
					.append(this.name2, that.name2).isEquals();
		}
	}
	public T getName1() {
		return this.name1;
	}
	public T getName2() {
		return this.name2;
	}
}
