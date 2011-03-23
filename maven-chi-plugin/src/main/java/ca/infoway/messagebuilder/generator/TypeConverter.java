package ca.infoway.messagebuilder.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.Hl7TypeName;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.util.DomainRegistry;
import ca.infoway.messagebuilder.xml.Relationship;

public class TypeConverter {

	public DataType convertToType(Relationship relationship) {
		return convertToType(relationship.getType(), relationship.getDomainType());
	}

	public DataType convertToType(String type, String domainType) {
		Hl7TypeName name = Hl7TypeName.parse(type);
		return convertToType(name, domainType);
	}

	private DataType convertToType(Hl7TypeName name, String domainType) {
		DataType dataType = null;
		if (name!=null) {
			List<DataType> parameters = convertAll(name.getParameters(), domainType);
			DataType baseType = getBasicType(name.getUnparameterizedName(), domainType);
			dataType = new DataType(baseType.getType(), baseType.getTypeName(), parameters);
		}
		return dataType;
	}

	private List<DataType> convertAll(List<Hl7TypeName> parameters, String domainType) {
		List<DataType> result = new ArrayList<DataType>();
		for (Hl7TypeName name : parameters) {
			result.add(convertToType(name, domainType));
		}
		return result;
	}

	private DataType getBasicType(String relationshipType, String domainType) {
		DataTypeGenerationDetails type = DataTypeGenerationDetails.getByTypeName(relationshipType);
		if (type == null) {
			return new DataType(DataTypeGenerationDetails.ANY, Object.class.getName());
		} else if (type.isCoded()) {
			return resolveDomainType(type, type.getHl7TypeName(), domainType);
		} else {
			return new DataType(type, type.getJavaTypeName());
		}
	}

	private DataType resolveDomainType(DataTypeGenerationDetails type, String dataTypeName, String domainType) {
		Class<?> c = DomainRegistry.getInstance().getDomainType(domainType);
		if (c != null) {
			return new DataType(type, c.getName());
		} else {
			return new DataType(type, Code.class.getName());
		}
	}

	public static boolean isCodedCollectionType(String type) {
		String[] split = StringUtils.split(type, "<>");
		return split != null && split.length == 2 && Arrays.asList("SET","LIST").contains(split[0])
			&& isCodedType(split[1]);
	}

	public static boolean isCodedType(String type) {
		StandardDataType dataType = StandardDataType.getByTypeName(type);
	    return dataType!=null && dataType.isCoded();
	}
	
}
