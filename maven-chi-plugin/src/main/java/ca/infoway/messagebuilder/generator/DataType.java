package ca.infoway.messagebuilder.generator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.datatype.Hl7TypeName;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class DataType {

	private final String qualifier;
	private final DataType[] parameters;
	private final DataTypeGenerationDetails type;
	
	private final WrappedParameterAppenderRegistry parameterAppenderRegistry = WrappedParameterAppenderRegistry.getInstance(); 

	DataType(DataTypeGenerationDetails type, String qualifier, DataType... parameters) {
		this.qualifier = qualifier;
		this.parameters = parameters;
		this.type = type;
	}
	DataType(DataTypeGenerationDetails type, String typeName, List<DataType> parameters) {
		this(type, typeName, parameters == null ? new DataType[0] : parameters.toArray(new DataType[parameters.size()]));
	}
	
	public String getShortName() {
		return getShortName(ProgrammingLanguage.JAVA);
	}
	public String getShortName(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		getShortName(builder, language);
		return builder.toString();
	}

	void getShortName(StringBuilder builder, ProgrammingLanguage language) {
		builder.append(getUnparameterizedShortName(language));
		appendParameters(builder, language);
	}

	private void appendParameters(StringBuilder builder, ProgrammingLanguage language) {
		getWrappedParameterAppender().append(builder, this, Arrays.asList(this.parameters), language);
	}
	
	public String getUnparameterizedShortName() {
		return getUnparameterizedShortName(ProgrammingLanguage.JAVA);
	}
	public String getUnparameterizedShortName(ProgrammingLanguage language) {
		if (this.type.isCoded()) {
			return ClassUtils.getShortClassName(this.qualifier);
		} else {
			return ClassUtils.getShortClassName(this.type.getLanguageSpecificTypeName(language));
		}
	}

	public String getUnparameterizedShortWrappedName() {
		return ClassUtils.getShortClassName(this.type.getHl7TypeName());
	}
	
	public String getTypeParameters(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		appendParameters(builder, language);
		return builder.toString();
	}

	public String getCollectionParameterWrappedTypeImpl() {
		String collectionWrappedParameter = "Object";
		if (this.parameters.length>0) {
			collectionWrappedParameter = this.parameters[0].getUnparameterizedShortWrappedNameImpl();
		}
		return collectionWrappedParameter;
	}

	/**
	 * @return <b>true</b> if the underlaying HL7 type is a LIST or a SET. 
	 */
	public boolean isWrappedTypeListOrSet() {
		boolean isListOrSet = false;
		if (getShortWrappedName()!=null) {
			Hl7TypeName typeName = Hl7TypeName.parse(getShortWrappedName());
			isListOrSet = StandardDataType.isSetOrList(typeName!=null ? typeName.getRootName() : null) ;
		}
		return isListOrSet;

	}
	
	/**
	 * @return <b>true</b> if the java type used to represent this data type is a collection.
	 */
	public boolean isTypeCollection() {
		return "Set".equals(getUnparameterizedShortName()) ||
			"List".equals(getUnparameterizedShortName());
	}
	
	public Set<String> getImportTypes() {
		Set<String> result = new HashSet<String>();
		result.add(this.qualifier);
		addWrappedTypeIfNecessary(result);
		for (DataType dataType : this.parameters) {
			result.addAll(dataType.getImportTypes());
		}
		return result;
	}
	private void addWrappedTypeIfNecessary(Set<String> result) {
		if (getWrappedName() != null) {
			result.add(getWrappedName());
			result.add(getWrappedTypeImplName());
		}
	}

	private String getWrappedTypeImplName() {
		return getWrappedName().replace(
				"."+getUnparameterizedShortWrappedName(), 
				".impl."+getUnparameterizedShortWrappedName() + "Impl");
	}
	public String getTypeName(ProgrammingLanguage language) {
		if (this.type.isCoded()) {
			return this.qualifier;
		} else {
			return this.type.getLanguageSpecificTypeName(language);
		}
	}
	public String getTypeName() {
		return this.qualifier;
	}

	public String getShortWrappedName() {
		return getShortWrappedName(ProgrammingLanguage.JAVA);
	}
	
	public String getShortWrappedName(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		getShortWrappedName(builder, language);
		return builder.toString();
	}

	public String getShortWrappedNameImpl(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		getShortWrappedNameImpl(builder, language);
		return builder.toString();
	}
	
	public String getShortWrappedNameImpl() {
		return getShortWrappedNameImpl(ProgrammingLanguage.JAVA);
	}

	public String getUnparameterizedShortWrappedNameImpl() {
		StringBuilder builder = new StringBuilder();
		getUnparameterizedShortWrappedNameImpl(builder);
		return builder.toString();
	}
	
	public String getWrappedName() {
		return this.type.getHl7TypeName();
	}
	
	private void getShortWrappedName(StringBuilder builder, ProgrammingLanguage language) {
		builder.append(getUnparameterizedShortWrappedName());
		getWrappedParameterAppender().appendWrapped(builder, this, Arrays.asList(this.parameters), language);
	}
	private ParameterAppender getWrappedParameterAppender() {
		ParameterAppender appender = this.parameterAppenderRegistry.getAppender(StandardDataType.getByTypeName(getUnparameterizedShortWrappedName()));
		return appender;
	}
	
	private void getShortWrappedNameImpl(StringBuilder builder, ProgrammingLanguage language) {
		getUnparameterizedShortWrappedNameImpl(builder);
		getWrappedParameterAppender().appendWrapped(builder, this, Arrays.asList(this.parameters), language);
	}
	private void getUnparameterizedShortWrappedNameImpl(StringBuilder builder) {
		builder.append(getUnparameterizedShortWrappedName());
		builder.append("Impl");
	}
	
	@Override
	public String toString() {
		return getShortWrappedName() + "/" + getShortName();
	}
	DataTypeGenerationDetails getType() {
		return this.type;
	}
	public boolean isCodedType() {
		return getType().isCoded();
	}
	public DataType[] getParameters() {
		return this.parameters;
	}
}
