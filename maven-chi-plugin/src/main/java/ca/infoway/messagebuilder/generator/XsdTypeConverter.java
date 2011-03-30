package ca.infoway.messagebuilder.generator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.Hl7TypeName;
import ca.infoway.messagebuilder.xml.Relationship;

/**
 * <p>A class to determine the XSD simple data type given a particular HL7 Data Type.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class XsdTypeConverter {

    private static final String BL = "BL";
	protected static final Map<String,XsdDataType> BASIC_TYPES;
	
    static {
        Map<String,XsdDataType> map = new HashMap<String,XsdDataType>();
        addAllHl7BasicTypes(map);
        BASIC_TYPES = Collections.unmodifiableMap(map);
    }
    
    protected static void addAllHl7BasicTypes(Map<String, XsdDataType> map) {
        map.put("ANY", new XsdDataType("anyType", Namespaces.XSD_NAMESPACE));
        map.put(BL, new XsdDataType("boolean", Namespaces.XSD_NAMESPACE));
        map.put("INT", new XsdDataType("integer", Namespaces.XSD_NAMESPACE));
        map.put("REAL", new XsdDataType("decimal", Namespaces.XSD_NAMESPACE));
        
        map.put("AD", new XsdDataType("PostalAddress", Namespaces.CHI_NAMESPACE));
        map.put("ON", new XsdDataType("OrganizationName", Namespaces.XSD_NAMESPACE));
        map.put("ST", new XsdDataType("string", Namespaces.XSD_NAMESPACE));
        map.put("IVL<TS>", new XsdDataType("DateInterval", Namespaces.CHI_NAMESPACE));
        map.put("PIVL<TS>", new XsdDataType("PeriodicIntervalOfTime", Namespaces.CHI_NAMESPACE));
        map.put("IVL<PQ>", new XsdDataType("PhysicalQuantityInterval", Namespaces.CHI_NAMESPACE));
        map.put("II", new XsdDataType("InstanceIdentifier", Namespaces.CHI_NAMESPACE));
        map.put("CS", new XsdDataType("SimpleCodedType", Namespaces.CHI_NAMESPACE));
        map.put("CV", new XsdDataType("CodedValue", Namespaces.CHI_NAMESPACE));
        map.put("CD", new XsdDataType("CodedType", Namespaces.CHI_NAMESPACE));
        map.put("CE", new XsdDataType("CodedType", Namespaces.CHI_NAMESPACE));
        map.put("GTS", new XsdDataType("BoundedPeriodicIntervalOfTime", Namespaces.CHI_NAMESPACE));
        map.put("ED.SIGNATURE", new XsdDataType("EncapsulatedSignatureType", Namespaces.CHI_NAMESPACE));
        map.put("ED.DOC", new XsdDataType("EncapsulatedDocumentType", Namespaces.CHI_NAMESPACE));
        map.put("ED.DOCORREF", new XsdDataType("EncapsulatedDocumentOrReference", Namespaces.CHI_NAMESPACE));
        map.put("ED.DOCREF", new XsdDataType("EncapsulatedReferenceType", Namespaces.CHI_NAMESPACE));
        // SPD: ED.REF is not in the newer releases
        map.put("ED.REF", new XsdDataType("EncapsulatedReferenceType", Namespaces.CHI_NAMESPACE));
        map.put("PN", new XsdDataType("PersonName", Namespaces.CHI_NAMESPACE));
        map.put("PQ", new XsdDataType("PhysicalQuantity", Namespaces.CHI_NAMESPACE));
        map.put("RTO<PQ,PQ>", new XsdDataType("RatioDrugQuantityPerTime", Namespaces.CHI_NAMESPACE));
        map.put("RTO<MO,PQ>", new XsdDataType("RatioMoneyPerUnit", Namespaces.CHI_NAMESPACE));
        map.put("PN.SIMPLE", new XsdDataType("SimpleName", Namespaces.CHI_NAMESPACE));
        map.put("MO", new XsdDataType("Money", Namespaces.CHI_NAMESPACE));
        map.put("TN", new XsdDataType("string", Namespaces.XSD_NAMESPACE));
        // SPD: TS is not legal but it is in some releases. Just map it to the most general type
        map.put("TS", new XsdDataType("FullDateWithTime", Namespaces.CHI_NAMESPACE));
        map.put("TS.DATE", new XsdDataType("PartialDate", Namespaces.CHI_NAMESPACE));
        map.put("TS.DATETIME", new XsdDataType("PartialDateTime", Namespaces.CHI_NAMESPACE));
        map.put("TS.FULLDATE", new XsdDataType("FullDate", Namespaces.CHI_NAMESPACE));
        map.put("TS.FULLDATEWITHTIME", new XsdDataType("FullDateWithTime", Namespaces.CHI_NAMESPACE));
        map.put("TS.FULLDATETIME", new XsdDataType("FullDateTime", Namespaces.CHI_NAMESPACE));
        map.put("TEL.URI", new XsdDataType("Uri", Namespaces.CHI_NAMESPACE));
        map.put("TEL.PHONEMAIL", new XsdDataType("PhonemailTelecommunicationAddress", Namespaces.CHI_NAMESPACE));
        map.put("TEL.PHONE", new XsdDataType("PhoneNumber", Namespaces.CHI_NAMESPACE));
        map.put("TEL.EMAIL", new XsdDataType("EmailAddress", Namespaces.CHI_NAMESPACE));
        map.put("URG<TS>", new XsdDataType("DateUncertainRange", Namespaces.CHI_NAMESPACE));
        map.put("URG<PQ>", new XsdDataType("PhysicalQuantityUncertainRange", Namespaces.CHI_NAMESPACE));
        
    }
    
	public XsdDataType convertToType(Relationship relationship, boolean isIndicator) throws GeneratorException {
		XsdDataType result = null;
		if (isIndicator) {
			result = BASIC_TYPES.get(BL);
		} else {
			Hl7TypeName name = Hl7TypeName.parse(relationship.getType());
			if (isCollection(name)) {
				name = name.getParameters().get(0);
			}
			
			result = BASIC_TYPES.get(name.toString());
			if (result == null) {
				result = BASIC_TYPES.get(name.getUnspecializedName());
			}
		}
		return result;
	}

	private boolean isCollection(Hl7TypeName name) {
		return "LIST".equals(name.getUnparameterizedName()) || 
			"SET".equals(name.getUnparameterizedName());
	}
}
