package ca.infoway.messagebuilder.generator.java;

import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Relationship;

public class Attribute extends BaseRelationship {

	private static final long serialVersionUID = -6995768063449967900L;
	
	private final DataType dataType;
	private final boolean indicator;

	public Attribute(Relationship relationship, DataType dataType) {
		this(relationship, dataType, false);
	}
	
	public Attribute(Relationship relationship, DataType dataType, boolean indicator) {
		super(relationship, 
				dataType == null ? null : dataType.getWrappedName(), 
				dataType == null ? null : dataType.getTypeName());
		this.dataType = dataType;
		this.indicator = indicator;
	}
	
	@Override
	public RelationshipType getRelationshipType() {
		return RelationshipType.ATTRIBUTE;
	}
	
    /**
     * <p>We say that an attribute is a collection type if the underlying data type
     * is a collection.  For example, if the attribute is defined as <code>LIST&lt;II&gt;</code>, 
     * then the attribute is a collection type.  
     * 
     * <p>The idea of a collection type is separate from (but often related to) the idea
     * of multiple cardinality.
     * 
     * @return
     */
    public boolean isCollection() {
        return this.dataType.isTypeCollection();
    }
	
	@Override
	public Set<Object> getImportTypes() {
		Set<Object> result = super.getImportTypes();
		if (this.dataType.isTypeCollection()) {
			result.add(this.dataType.getTypeName());
			if (this.dataType.getParameters()!=null && this.dataType.getParameters().length > 0) {
				DataType parameter = this.dataType.getParameters()[0];
				if (parameter.isCodedType()) {
					result.add(Code.class.getName());
				}
			}
		}
		if (this.dataType != null) {
			result.addAll(this.dataType.getImportTypes());
		}
		
		if (!this.dataType.isWrappedTypeListOrSet() && isCardinalityMultiple()) {
			result.add(RawListWrapper.class.getName());
		}
		
		return result;
	}
	
	public DataType getDataType() {
		return this.dataType;
	}
	
	@Override
	public boolean isWriteable() {
		return super.isWriteable() && !isCollection();
	}
	
	@Override
	public String getTypeParameters() {
		// TODO: BCH: I don't think this should be called, here.
		return this.dataType.getTypeParameters(ProgrammingLanguage.JAVA);
	}
	
	public PropertyGenerator getPropertyGenerator(ProgrammingLanguage language, ClassNameManager representation, BaseRelationshipNameResolver nameResolver) {
		return PropertyGeneratorBuilders.newAttributeBuilder(language, this).build(representation, nameResolver);
	}

	/**
	 * If this is an attribute that has replaced an indicator bean, this will return true.
	 * 
	 * @return whether this attribute represents an indicator bean
	 */
	public boolean isIndicator() {
		return this.indicator;
	}
	
}
