package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

/**
 * <p>A representation of an entire message set.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class MessageSet implements MessagePartResolver {

	@Attribute(required=false)
	private String version;
	
	@Attribute(required=false)
	private String component;
	
	@ElementMap(name="packageLocation",key="name",required=false,inline=true,attribute=true,entry="packageEntry")
	private Map<String,PackageLocation> packageLocations = new TreeMap<String,PackageLocation>();

	@ElementMap(name="interaction",key="name",required=false,inline=true,attribute=true)
	private Map<String,Interaction> interactions = new TreeMap<String,Interaction>();

	/**
	 * <p>Get the version code that this message set represents.
	 * @return - the version code.
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * <p>Set the version code.
	 * @param version - the new version code.
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * <p>Get a map of all the interactions defined in the message set, keyed by 
	 * interaction id.
	 * @return - the map of all interactions.
	 */
	public Map<String, Interaction> getInteractions() {
		return this.interactions;
	}

	/**
	 * <p>Set the interactions.
	 * @param interactions - the new value
	 */
	public void setInteractions(Map<String, Interaction> interactions) {
		this.interactions = interactions;
	}

	/**
	 * <p>Get a map of all package locations, keyed by package location id.
	 * @return - the map
	 */
	public Map<String, PackageLocation> getPackageLocations() {
		return this.packageLocations;
	}

	/**
	 * <p>Set the package locations.
	 * @param packageLocations - the new value.
	 */
	public void setPackageLocations(Map<String, PackageLocation> packageLocations) {
		this.packageLocations = packageLocations;
	}
	
	/**
	 * <p>Get a part by part type name.
	 * @param type - the message part type name
	 * @return - the message part
	 */
	public MessagePart getMessagePart(String type) {
		MessagePart messagePart = null;
		if (type != null) {
			String packageLocationName = type.contains(".") ? StringUtils.substringBefore(type, ".") : type;
			PackageLocation location = getPackageLocations().get(packageLocationName);
			if (location == null) {
				messagePart = null;
			} else if (type.contains(".")) {
				messagePart = location.getMessageParts().get(type);
			} else if (StringUtils.isNotBlank(location.getRootType())) {
				messagePart = location.getMessageParts().get(location.getRootType());
			} 
		}
		return messagePart;
	}

	/**
	 * <p>Add a message part.
	 * @param part - the message part to add
	 */
	public void addMessagePart(MessagePart part) {
		TypeName name = new TypeName(part.getName());
		
		String packageName = name.getRootName().getName();
		PackageLocation location = this.packageLocations.get(packageName);
		if (location == null) {
			throw new IllegalArgumentException("No package location exists: " + packageName);
		} else {
			location.getMessageParts().put(part.getName(), part);
		}
	}

	/**
	 * <p>Get a collection of all message parts defined by the message set.
	 * @return the message parts
	 */
	public Collection<MessagePart> getAllMessageParts() {
		List<MessagePart> result = new ArrayList<MessagePart>();
		for (PackageLocation packageLocation : this.packageLocations.values()) {
			result.addAll(packageLocation.getMessageParts().values());
		}
		return result;
	}

	/**
	 * <p>Get a package location root type.
	 * @param packageLocation - the package location key
	 * @return the package location
	 */
	public String getPackageLocationRootType(String packageLocation) {
		if (this.packageLocations.containsKey(packageLocation)) {
			return this.packageLocations.get(packageLocation).getRootType();
		} else {
			return null;
		}
	}

	/**
	 * <p>Get the component.
	 * @return the component
	 */
	public String getComponent() {
		return this.component;
	}

	/**
	 * <p>Set the component.
	 * @param component - the new value
	 */
	public void setComponent(String component) {
		this.component = component;
	}
}
