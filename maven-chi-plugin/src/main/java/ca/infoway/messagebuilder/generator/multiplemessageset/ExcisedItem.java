package ca.infoway.messagebuilder.generator.multiplemessageset;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.xml.HasDifferences;

public class ExcisedItem implements Comparable<ExcisedItem>, Named {

	private final HasDifferences itemWithDifferences;
	private final String exciseSourceName;
	
	public ExcisedItem(HasDifferences itemWithDifferences, String exciseSourceName) {
		if (itemWithDifferences == null) {
			throw new NullPointerException("item with differences cannot be null");
		}
		this.itemWithDifferences = itemWithDifferences;
		this.exciseSourceName = exciseSourceName;
	}

	public String getName() {
		return this.itemWithDifferences.getName();
	}
	
	public String getExciseSourceName() {
		return this.exciseSourceName;
	}

	public HasDifferences getItemWithDifferences() {
		return this.itemWithDifferences;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getName()).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj.getClass() != getClass()) {
			return false;
		} else {
			ExcisedItem that = (ExcisedItem) obj;
			return new EqualsBuilder().append(this.getName(), that.getName()).isEquals();
		}
	}

	public int compareTo(ExcisedItem o) {
		return new CompareToBuilder()
				.append(this.getName(), o.getName())
				.toComparison();
	}
	
}
