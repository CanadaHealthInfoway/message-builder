package ca.infoway.messagebuilder.simple.xml.formatter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlFormatter;

class FormatterFactoryImpl implements FormatterFactory {
	
	Map<String,Class<? extends SimpleXmlFormatter>> map = Collections.synchronizedMap(new HashMap<String,Class<? extends SimpleXmlFormatter>>());
	
	public FormatterFactoryImpl() {
		this.map.put("InstanceIdentifier", IdentifierXmlFormatter.class);
		this.map.put("EncapsulatedSignatureType", EncapsulatedDataSignatureXmlFormatter.class);
		this.map.put("EncapsulatedDocumentType", EncapsulatedDataDocumentXmlFormatter.class);
		this.map.put("EncapsulatedReferenceType", EncapsulatedDataDocumentXmlFormatter.class);
		this.map.put("Money", MoneyXmlFormatter.class);
		this.map.put("PersonName", PersonNameXmlFormatter.class);
		this.map.put("PhysicalQuantity", PhysicalQuantityXmlFormatter.class);
		this.map.put("PartialDate", DateXmlFormatter.class);
		this.map.put("PartialDateTime", DateXmlFormatter.class);
		this.map.put("FullDateWithTime", DateXmlFormatter.class);
		this.map.put("FullDate", DateXmlFormatter.class);
		this.map.put("FullDateTime", DateXmlFormatter.class);
		this.map.put("DateInterval", DateIntervalXmlFormatter.class);
		this.map.put("DateUncertainRange", DateUncertainRangeXmlFormatter.class);
		this.map.put("PhysicalQuantityUncertainRange", PhysicalQuantityUncertainRangeXmlFormatter.class);
		this.map.put("PhysicalQuantityInterval", PhysicalQuantityIntervalXmlFormatter.class);
		this.map.put("PeriodicIntervalOfTime", PeriodicIntervalOfTimeXmlFormatter.class);
		this.map.put("BoundedPeriodicIntervalOfTime", BoundedPeriodicIntervalOfTimeXmlFormatter.class);
		this.map.put("TrivialName", TrivialNameXmlFormatter.class);
		this.map.put("Uri", TelecomAddressXmlFormatter.class);
		this.map.put("EmailAddress", TelecomAddressXmlFormatter.class);
		this.map.put("PhoneNumber", TelecomAddressXmlFormatter.class);
		this.map.put("SimpleCodedType", SimpleCodedTypeXmlFormatter.class);
		this.map.put("CodedValue", CodedValueXmlFormatter.class);
		this.map.put("CodedType", ConceptDescriptorXmlFormatter.class);
		this.map.put("RatioDrugQuantityPerTime", RatioDrugQuantityPerTimeXmlFormatter.class);
		this.map.put("RatioMoneyPerUnit", RatioMoneyPerUnitXmlFormatter.class);
		this.map.put("PostalAddress", PostalAddressXmlFormatter.class);
		
		this.map.put("NullFlavor", NullFlavorXmlFormatter.class);
		
		this.map.put("boolean", BooleanXmlFormatter.class);
		this.map.put("integer", IntegerXmlFormatter.class);
		this.map.put("decimal", RealXmlFormatter.class);
		this.map.put("string", StringXmlFormatter.class);
	}
	
	public SimpleXmlFormatter createFormatter(String typeName) throws FormatterException {
		FormatterConfiguration configuration = new FormatterConfiguration();
		try {
			Constructor<? extends SimpleXmlFormatter> constructor = 
				this.map.get(typeName).getDeclaredConstructor(FormatterConfiguration.class);
			constructor.setAccessible(true);
			return constructor.newInstance(configuration);
		} catch (IllegalArgumentException e) {
			throw new FormatterException(e);
		} catch (SecurityException e) {
			throw new FormatterException(e);
		} catch (InstantiationException e) {
			throw new FormatterException(e);
		} catch (IllegalAccessException e) {
			throw new FormatterException(e);
		} catch (InvocationTargetException e) {
			throw new FormatterException(e);
		} catch (NoSuchMethodException e) {
			throw new FormatterException(e);
		}
	}

	public boolean isSimpleDataType(String typeName) {
		return this.map.containsKey(typeName);
	}
}
