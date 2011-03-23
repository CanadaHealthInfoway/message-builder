package ca.infoway.messagebuilder.marshalling;

import static ca.infoway.messagebuilder.j5goodies.EnumeratedIterable.iterable;
import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.split;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.ClassPredicate;
import ca.infoway.messagebuilder.j5goodies.Predicates;
import ca.infoway.messagebuilder.marshalling.hl7.MessageTypeKey;
import ca.infoway.messagebuilder.model.InteractionBean;

/**
 * <p>A utility class that can be used to translate between Java model classes
 * and their corresponding HL7 interactions or message parts.
 * 
 * <p>This utility depends on two conventions:
 * 
 * <p>First, every jar that contains generated model classes will include a Manifest
 * file that has an attribute, MBT-Model-Version-Numbers, which lists the version
 * numbers that the model classes are valid for.
 * 
 * <p>Two, each message part class will have an annotation that describes the part 
 * type that it maps to.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore platform
 */
public class MessageBeanRegistry {
	
	private static MessageBeanRegistry instance;
	
	private final Map<MessageTypeKey,Class<? extends InteractionBean>> registry = Collections.synchronizedMap(new HashMap<MessageTypeKey, Class<? extends InteractionBean>>());
	private final Map<MessageTypeKey,Class<?>> partTypeRegistry = Collections.synchronizedMap(new HashMap<MessageTypeKey, Class<?>>());

	private MessageBeanRegistry() {
	}
	
	/**
	 * <p>Get the instance of the message bean registry.
	 * @return - the message bean registry instance
	 */
	public static MessageBeanRegistry getInstance() {
		if (instance == null) {
			initializeInstance();
		}
		return instance;
	}

	private synchronized static void initializeInstance() {
		if (instance == null) {
			MessageBeanRegistry registry = new MessageBeanRegistry();
			registry.initialize();
			instance = registry;
		}
	}

	private void initialize() {
		ClassPredicate partTypePredicate = Predicates.hasAnnotationPredicate(Hl7PartTypeMapping.class);
		Map<URL, List<String>> manifests = getManifestsWithVersionAttribute();
		for (URL url : manifests.keySet()) {
			List<Class<?>> classes = new ClassFinder().findClasses(url, partTypePredicate);
			registerClasses(classes, manifests.get(url));
		}
	}

	private void registerClasses(List<Class<?>> classes, List<String> versions) {
		for (Class<?> c : classes) {
			registerClass(c, versions);
		}
	}

	void registerClass(Class<?> c, VersionNumber version) {
		registerClass(c, Arrays.asList(version.getVersionLiteral()));
	}
	
	@SuppressWarnings("unchecked")
	private void registerClass(Class<?> c, List<String> versions) {
		Hl7PartTypeMapping mapping = c.getAnnotation(Hl7PartTypeMapping.class);
		if (mapping != null) {
			for (String partId : mapping.value()) {
				for (String version : versions) {
					MessageTypeKey key = new MessageTypeKey(version, partId);
					this.partTypeRegistry.put(key, c);
					if (InteractionBean.class.isAssignableFrom(c)) {
						this.registry.put(key, (Class<? extends InteractionBean>) c);
					}
				}
			}
		}
	}

	private Map<URL, List<String>> getManifestsWithVersionAttribute() {
		Map<URL, List<String>> manifests = new HashMap<URL, List<String>>();
		try {
			Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			for (URL url : iterable(resources)) {
				InputStream input = url.openStream();
				try {
					Manifest manifest = new Manifest(input);
					Attributes attributes = manifest.getMainAttributes();
					String versionNumbers = attributes.getValue("MBT-Model-Version-Numbers");
					if (StringUtils.isNotBlank(versionNumbers)) {
						manifests.put(url, asList(split(versionNumbers)));
					}
				} finally {
					IOUtils.closeQuietly(input);
				}
			}
		} catch (IOException e) {
			// quietly swallow the error
		}
		return manifests;
	}
	
	Class<?> getMessagePartType(MessageTypeKey key) {
		return this.partTypeRegistry.get(key);
	}
	public Collection<Class<?>> getAllMessageParts() {
		return this.partTypeRegistry.values();
	}

	/**
	 * <p>Get a collection of all message type keys that are contained in the registry.
	 * @return - the collection of message type keys
	 */
	public Set<MessageTypeKey> getMessageTypeKeys() {
		return this.registry.keySet();
	}
	
	/**
	 * <p>Get the class for a particular interaction.
	 * @return - the collection of message type keys
	 */
	public Class<? extends InteractionBean> getInteractionBeanType(MessageTypeKey key) {
		return this.registry.get(key);
	}

	MessageTypeKey getType(String version, InteractionBean messageBean) {
		if (messageBean != null && messageBean.getClass().isAnnotationPresent(Hl7PartTypeMapping.class)) {
			return getTypeFromPartTypeMapping(version, messageBean);
		} else {
			throw new MarshallingException("Cannot find a type for " + ClassUtils.getShortClassName(messageBean.getClass()));
		}
	}

	private MessageTypeKey getTypeFromPartTypeMapping(String version, InteractionBean messageBean) {
		String[] values = messageBean.getClass().getAnnotation(Hl7PartTypeMapping.class).value();
		if (values.length >= 1 && StringUtils.isNotBlank(values[0])) {
			return new MessageTypeKey(version, values[0]);
		} else {
			throw new MarshallingException("Cannot find a type for " + ClassUtils.getShortClassName(messageBean.getClass()));
		}
	}

	Class<?> getMessagePartClass(String version, String type) {
		MessageTypeKey key = new MessageTypeKey(version, type);
		Class<?> result = getMessagePartType(key);
		if (result == null && type.contains(".")) {
			String unqualifiedTypeName = StringUtils.substringAfter(type, ".");
			key = new MessageTypeKey(version, unqualifiedTypeName);
			result = getMessagePartType(key);
			
			if (result == null && unqualifiedTypeName.contains("_")) {
				String typeWithoutVersionCode = StringUtils.substringBefore(type, ".")
					+ "." + StringUtils.substringBefore(unqualifiedTypeName, "_");
				result = getMessagePartClass(version, typeWithoutVersionCode);
			}
		}
		return result;
	}
	
	public boolean isMessagePartDefined(String version, String type) {
		return getMessagePartClass(version, type) != null;
	}
}
