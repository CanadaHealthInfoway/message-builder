package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * <p>A class that models the differences noted during regen.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class Difference {

	@Attribute
	private String type;
	@ElementList(inline=true, required=false)
	private List<DifferenceValue> differences = new ArrayList<DifferenceValue>();
	
	
	/**
	 * A field indicating what kind of difference is being reported.
	 * 
	 * @return the  type of this difference
	 */
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<DifferenceValue> getDifferences() {
		return this.differences;
	}
	public void setDifferences(List<DifferenceValue> differences) {
		this.differences = differences;
	}
	
}
