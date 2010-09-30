package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <p>The package location.  Each package location corresponds with one MIF file.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class PackageLocation implements Categorizable, HasDifferences {
	
	@Attribute
	private String name;
	@Attribute(name="desc",required=false)
	private String descriptiveName;
	@Attribute(required=false)
	private String rootType;
	@ElementList(inline=true, required=false)
	@Namespace(prefix="regen",reference="regen_ns")
	private List<Difference> differences = new ArrayList<Difference>();
	@ElementMap(name="messagePart",key="name",required=false,inline=true,attribute=true)
	private Map<String,MessagePart> messageParts = new TreeMap<String,MessagePart>();
	@Attribute(required=false)
	private String category;

	/**
	 * <p>The default constructor.
	 */
	public PackageLocation() {
	}
	/**
	 * <p>Standard constructor.
	 * @param name the name of the package location
	 */
	public PackageLocation(String name) {
		this.name = name;
	}
	/**
	 * <p>Get the name.  e.g. "PRPA_MT101103CA"
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * <p>Set the name.
	 * @param name - the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>The name of the top-level class defined by the MIF file.
	 * @return the root type name.
	 */
	public String getRootType() {
		return this.rootType;
	}
	/**
	 * <p>Set the name of the top-level class defined by the MIF file.
	 * @param rootType - the root type name.
	 */
	public void setRootType(String rootType) {
		this.rootType = rootType;
	}
	/**
	 * <p>Get a map of all message parts, keyed by fully-qualified type name.
	 * @return - the map
	 */
	public Map<String, MessagePart> getMessageParts() {
		return this.messageParts;
	}
	/**
	 * <p>Set the map of all message parts.
	 * @param messageParts - the new value
	 */
	public void setMessageParts(Map<String, MessagePart> messageParts) {
		this.messageParts = messageParts;
	}
	/**
	 * <p>Get the descriptive name.
	 * @return the descriptive name.
	 */
	public String getDescriptiveName() {
		return this.descriptiveName;
	}
	/**
	 * <p>Set the descriptive name.
	 * @param descriptiveName - the new value
	 */
	public void setDescriptiveName(String descriptiveName) {
		this.descriptiveName = descriptiveName;
	}
	/**
	 * <p>Set the category, such as "cr" (Client Registry).
	 * @param category - the new value
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * <p>Get the category.
	 * @return the category
	 */
	public String getCategory() {
		return this.category;
	}
	
	/**
	 * Tracks package location differences for regen 
	 * 
	 * @return the differences
	 */
	public List<Difference> getDifferences() {
		return this.differences;
	}
	public void setDifferences(List<Difference> differences) {
		this.differences = differences;
	}
	public void addDifference(Difference difference) {
		this.differences.add(difference);
	}
	
}
