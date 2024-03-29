/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.util.DomainRegistry;
import ca.infoway.messagebuilder.generator.util.DomainType;
import ca.infoway.messagebuilder.xml.Hl7TypeName;
import ca.infoway.messagebuilder.xml.Relationship;

public class TypeConverter {

	private boolean isR2;
	
	public TypeConverter(boolean isR2) {
		this.isR2 = isR2;
	}

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
			DataType baseType = getBasicType(name, domainType);
			if (baseType.getParameters() != null && baseType.getParameters().length > 0) {
				parameters.addAll(Arrays.asList(baseType.getParameters()));
			}
			dataType = new DataType(baseType.getType(), baseType.getTypeName(), this.isR2, parameters);
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

	private DataType getBasicType(Hl7TypeName name, String domainType) {
		DataTypeGenerationDetails type = DataTypeGenerationDetails.getByTypeName(name.toString(), this.isR2);
		if (type == null) {
			type = DataTypeGenerationDetails.getByTypeName(name.getUnparameterizedName(), this.isR2);
		}
		if (type == null) {
			return new DataType(DataTypeGenerationDetails.ANY, Object.class.getName(), this.isR2);
		} else if (!this.isR2 && "SC".equals(type.getRootType())) {
			return new DataType(type, type.getJavaTypeName(), this.isR2, resolveDomainType(type, type.getHl7TypeName(), domainType));
		} else if (type.isCoded()) {
			return resolveDomainType(type, type.getHl7TypeName(), domainType);
		} else {
			return new DataType(type, type.getJavaTypeName(), this.isR2);
		}
	}

	private DataType resolveDomainType(DataTypeGenerationDetails type, String dataTypeName, String domainTypeName) {
		DomainType domainType = DomainRegistry.getInstance().getDomainType(domainTypeName);
		if (domainType != null) {
			return new DataType(type, domainType.getFullyQualifiedClassName(), this.isR2);
		} else {
			return new DataType(type, Code.class.getName(), this.isR2);
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
