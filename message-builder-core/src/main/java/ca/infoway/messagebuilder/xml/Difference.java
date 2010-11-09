package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <p>A class that models the differences noted during regen.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
@Namespace(prefix="regen",reference="regen_ns")
public class Difference {

	@Attribute
	private DifferenceType type;
	@Attribute(name="isOk",required=false)
	private boolean ok;
	@ElementList(inline=true, required=false)
	private List<DifferenceValue> differences = new ArrayList<DifferenceValue>();
	
	public Difference() {
	}
	
	public Difference(DifferenceType differenceType, boolean ok, DifferenceValue... values) {
		this.type = differenceType;
		this.ok = ok;
		this.differences.addAll(Arrays.asList(values));
	}
	
	/**
	 * A field indicating what kind of difference is being reported.
	 * 
	 * @return the  type of this difference
	 */
	public DifferenceType getType() {
		return this.type;
	}
	public void setType(DifferenceType type) {
		this.type = type;
	}
	
	public List<DifferenceValue> getDifferences() {
		return this.differences;
	}
	public void setDifferences(List<DifferenceValue> differences) {
		this.differences = differences;
	}
	
	public boolean isOk() {
		return this.ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
}
