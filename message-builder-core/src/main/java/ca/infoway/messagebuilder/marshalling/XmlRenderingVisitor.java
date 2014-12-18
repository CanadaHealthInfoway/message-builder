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

package ca.infoway.messagebuilder.marshalling;

import static ca.infoway.messagebuilder.marshalling.BeanBridgeChoiceRelationshipResolver.resolveChoice;
import static ca.infoway.messagebuilder.marshalling.FixedValueAttributeBeanBridge.FIXED;
import static ca.infoway.messagebuilder.xml.ChoiceSupport.choiceOptionTypePredicate;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ASSOCIATION_IS_IGNORED_AND_CAN_NOT_BE_USED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ASSOCIATION_IS_IGNORED_AND_WILL_NOT_BE_USED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ASSOCIATION_IS_NOT_ALLOWED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ATTRIBUTE_IS_IGNORED_AND_WILL_NOT_BE_USED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ATTRIBUTE_IS_NOT_ALLOWED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.isIgnoredNotAllowed;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.NamedAndTyped;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.impl.DataTypeFactory;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.datatypeadapter.DataTypeValueAdapterProvider;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.Registry;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterRegistry;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.ModelToXmlTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.PropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.r2.FormatterR2Registry;
import ca.infoway.messagebuilder.marshalling.polymorphism.PolymorphismHandler;
import ca.infoway.messagebuilder.util.text.Indenter;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Predicate;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;
import ca.infoway.messagebuilder.xml.util.XmlWarningRenderer;

class XmlRenderingVisitor implements Visitor {	
	private static final String INLINED_PROPERTY_SUFFIX = "_INLINED";
	private static final String NULL_FLAVOR_FORMAT_FOR_ASSOCIATIONS = "nullFlavor=\"{0}\" xsi:nil=\"true\"";

	class Buffer {
		private final String name;
		private final StringBuilder structuralBuilder = new StringBuilder();
		private final StringBuilder childBuilder = new StringBuilder();
		private final int indent;
		private List<String> warnings = new ArrayList<String>();
		private List<String> infos = new ArrayList<String>();

		private XmlWarningRenderer xmlWarningRenderer = new XmlWarningRenderer();
		
		public Buffer(String name, int indent) {
			this.name = name;
			this.indent = indent;
		}
		public int getIndent() {
			return this.indent;
		}
		public String getName() {
			return this.name;
		}
		public StringBuilder getStructuralBuilder() {
			return this.structuralBuilder;
		}
		public StringBuilder getChildBuilder() {
			return this.childBuilder;
		}
		public String toXml() {
			StringBuilder builder = new StringBuilder();
			if (!this.warnings.isEmpty()) {
				for (String warning : this.warnings) {
					builder.append(this.xmlWarningRenderer.createWarning(this.indent, warning));
				}
			}
			if (!this.infos.isEmpty()) {
				for (String warning : this.infos) {
					builder.append(this.xmlWarningRenderer.createLog("INFO", this.indent, warning));
				}
			}
			Indenter.indentBuilder(builder, this.indent);
			
			builder.append("<")
				.append(this.name);
			
			if (this.structuralBuilder.length() > 0) {
				builder.append(" ")
				.append(this.structuralBuilder.toString().trim());
			}
			if (StringUtils.isNotBlank(this.childBuilder.toString())) {
				builder.append(">")
					.append(SystemUtils.LINE_SEPARATOR)
					.append(this.childBuilder.toString());
				Indenter.indentBuilder(builder, this.indent);
				builder.append("</")
					.append(this.name)
					.append(">");
			} else {
				builder.append("/>");
			}
			if (this.indent > 0) {
				builder.append(SystemUtils.LINE_SEPARATOR);
			}
			return builder.toString();
		}
		@Override
		public String toString() {
			return "Buffer: " + this.name;
		}
		public List<String> getWarnings() {
			return this.warnings;
		}
		public void addWarning(String warning) {
			this.warnings.add(warning);
		}
		public void addInfo(String info) {
			this.infos.add(info);
		}
	}
	
	private PolymorphismHandler polymorphismHandler = new PolymorphismHandler();

	private final Stack<String> propertyPathNames = new Stack<String>();
	private final Stack<Buffer> buffers = new Stack<Buffer>();
	private Interaction interaction;
	private final DataTypeValueAdapterProvider adapterProvider = new DataTypeValueAdapterProvider();
	private final ModelToXmlResult result = new ModelToXmlResult();
	private final XmlWarningRenderer xmlWarningRenderer = new XmlWarningRenderer();
	private final Registry<PropertyFormatter> formatterRegistry;
	private final boolean isR2;
	private final boolean isCda;
	
	public XmlRenderingVisitor() {
		this(false, false);
	}
	
	public XmlRenderingVisitor(boolean isR2, boolean isCda) {
		this.isR2 = isR2;
		this.isCda = isCda;
		this.formatterRegistry = (isR2 ? FormatterR2Registry.getInstance() : FormatterRegistry.getInstance());
	}
	
	private Buffer currentBuffer() {
		return this.buffers.peek();
	}
	
	public void visitAssociationEnd(PartBridge tealBean, Relationship relationship) {
		if (isSomethingToRender(tealBean, relationship)) {
			popBuffer();
			this.propertyPathNames.pop();
		}
	}

	private boolean isSomethingToRender(PartBridge tealBean, Relationship relationship) {
		return !tealBean.isEmpty() 
				|| ConformanceLevelUtil.isMandatory(relationship) 
				|| ConformanceLevelUtil.isPopulated(relationship)
				|| tealBean.hasNullFlavor();
	}

	public void visitAssociationStart(PartBridge part, Relationship relationship) {
		if (isSomethingToRender(part, relationship)) {
			boolean validationWarning = false;
			String warningMessage = null;
			
			pushPropertyPathName(determinePropertyName(part.getPropertyName(), relationship), part.isCollapsed());
			String propertyPath = buildPropertyPath();
			
			String xmlElementName = determineXmlName(part, relationship);
			if (StringUtils.isNotBlank(relationship.getNamespace())) {
				xmlElementName = relationship.getNamespace() + ":" + xmlElementName;
			}
			this.buffers.push(new Buffer(xmlElementName, this.buffers.size()));
			
			addChoiceAnnotation(part, relationship);
			
			if (part.isEmpty() && (ConformanceLevelUtil.isPopulated(relationship) || part.hasNullFlavor())) {
				currentBuffer().getStructuralBuilder().append(
						MessageFormat.format(NULL_FLAVOR_FORMAT_FOR_ASSOCIATIONS, getNullFlavor(part).getCodeValue()));
			} else if (part.isEmpty() && ConformanceLevelUtil.isMandatory(relationship) && !isTrivial(part)) {
				// some errors are due to "null" parts MB has inserted to create structural XML; don't log errors on these
				validationWarning = !part.isNullPart() && !part.isCollapsed();
				warningMessage = "Mandatory association has no data.";
				if (!validationWarning) {
					currentBuffer().addWarning(warningMessage + " (" + propertyPath + ")");
				}
			} else if (ConformanceLevelUtil.isIgnored(relationship)) {
				validationWarning = true;
				warningMessage = MessageFormat.format(isIgnoredNotAllowed() ? 
						ASSOCIATION_IS_IGNORED_AND_CAN_NOT_BE_USED :
						ASSOCIATION_IS_IGNORED_AND_WILL_NOT_BE_USED, relationship.getName());
			} else if (ConformanceLevelUtil.isNotAllowed(relationship)) {
				validationWarning = true;
				warningMessage = MessageFormat.format(ASSOCIATION_IS_NOT_ALLOWED, relationship.getName());
			}
			
			if (validationWarning) {
				// store error within error collection
				this.result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, warningMessage, propertyPath));
			}
			
			addNewErrorsToList(currentBuffer().getWarnings());
		}
	}

	private void addChoiceAnnotation(PartBridge part, Relationship relationship) {
		NamedAndTyped choiceOptionRelationship = null;
		String choiceType = relationship.getType();
		if (relationship.isChoice()) {
			choiceOptionRelationship = resolveChoice(part, relationship);
		} else if (relationship.isTemplateRelationship()) {
			Argument argument = this.interaction.getArgumentByTemplateParameterName(relationship.getTemplateParameterName());
			if (argument != null && argument.isChoice()) {
				Predicate<Relationship> predicate =	choiceOptionTypePredicate(new String[] { part.getTypeName() } );
				choiceOptionRelationship = argument.findChoiceOption(predicate);
				choiceType = argument.getName();
			}
		}
		if (choiceOptionRelationship != null) {
			currentBuffer().addInfo("Selected option " + choiceOptionRelationship.getType() + " (" + choiceOptionRelationship.getName() + ") from choice " + choiceType);
		}
	}

	private void pushPropertyPathName(String propertyName, boolean isCollapsed) {
		String nameToPush = propertyName + (isCollapsed ? INLINED_PROPERTY_SUFFIX : "");
		this.propertyPathNames.push(nameToPush);
	}

	private String determinePropertyName(String propertyName, Named nameFallBack) {
		String backupName = (nameFallBack == null ? null : nameFallBack.getName());
		return (StringUtils.isNotBlank(propertyName) && !FIXED.equals(propertyName)) 
				? propertyName 
				: (backupName == null ? "" : backupName);
	}
	
	/**
	 * <p>Very rarely, there's a mandatory association that has no data.  
	 * 
	 * @param part
	 * @return
	 */
	private boolean isTrivial(PartBridge part) {
		boolean trivial = true;
		for (BaseRelationshipBridge relationship : part.getRelationshipBridges()) {
			Relationship r = relationship.getRelationship();
			if (relationship.getRelationship().isAssociation() || !r.hasFixedValue()) {
				trivial = false;
				break;
			}
		}
		return trivial;
	}

	private NullFlavor getNullFlavor(PartBridge tealBean) {
		NullFlavor nullFlavor = ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.NO_INFORMATION;
		if (tealBean.hasNullFlavor()) {
			nullFlavor = tealBean.getNullFlavor();
		}
		return nullFlavor;
	}

	private String determineXmlName(PartBridge tealBean, Relationship relationship) {
		if (!relationship.isChoice() && !relationship.isTemplateRelationship()) {
			return relationship.getName();
		} else if (relationship.isTemplateRelationship()) {
			Argument argument = this.interaction.getArgumentByTemplateParameterName(relationship.getTemplateParameterName());
			if (argument == null) {
				throw new RenderingException("Cannot determine the template/choice parameter type : " + relationship.getName());
			} else if (argument.isChoice()) {
				Predicate<Relationship> predicate =	choiceOptionTypePredicate(new String[] { tealBean.getTypeName() } );
				Relationship option = argument.findChoiceOption(predicate);
				if (option == null) {
					throw new RenderingException("Cannot determine the choice type of template argument : " + argument.getName());
				} else {
					return option.getName();
				}
			} else {
				return argument.getTraversalName();
			}
		} else if (tealBean.isEmpty()) {
			return relationship.getChoices().get(0).getName();
		} else {
			if (relationship.getCardinality().isMultiple()) {
				return relationship.getName();
			}
			 
			Relationship option = resolveChoice(tealBean, relationship);
			if (option == null) {
				// log an error instead?
				throw new RenderingException("Cannot determine the choice type of relationship : " + relationship.getName());
			} else {
				return option.getName();
			}
		}
	}

	public void visitAttribute(AttributeBridge tealBean, Relationship relationship, ConstrainedDatatype constraints, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		pushPropertyPathName(determinePropertyName(tealBean.getPropertyName(), relationship), false);
		if (relationship.isStructural()) {
			String propertyPath = buildPropertyPath();
			
			handleNotAllowedAndIgnored(relationship, propertyPath);
			// TODO - CDA - TM - may need to handle constraints for structural attributes
			new VisitorStructuralAttributeRenderer(relationship, tealBean.getValue()).render(currentBuffer().getStructuralBuilder(), propertyPath, this.result);
			addNewErrorsToList(currentBuffer().getWarnings());
		} else {
			renderNonStructuralAttribute(tealBean, relationship, constraints, version, dateTimeZone, dateTimeTimeZone);
		}
		this.propertyPathNames.pop();
	}

	private String buildPropertyPath() {
		StringBuilder result = new StringBuilder();
		String previousPathName = null;
		for (String currentPathName : this.propertyPathNames) {
			if (isInlined(previousPathName)) {
				if (isInlined(currentPathName)) {
					if (!StringUtils.equals(previousPathName, currentPathName)) {
						result.append('.').append(removeInlinedSuffix(currentPathName));
					}
				} else {
					String convertedPreviousPathName = removeInlinedSuffix(previousPathName);
					if (!StringUtils.equals(convertedPreviousPathName, currentPathName)) {
						result.append('.').append(currentPathName);
					}
				}
			} else {
				result.append('.').append(removeInlinedSuffix(currentPathName));
			}
			previousPathName = currentPathName;
		}		
		
		return result.toString().substring(1);
	}

	private boolean isInlined(String propertyName) {
		return propertyName != null && propertyName.endsWith(INLINED_PROPERTY_SUFFIX);
	}
	
	private String removeInlinedSuffix(String propertyName) {
		return isInlined(propertyName) ? propertyName.substring(0, propertyName.length() - INLINED_PROPERTY_SUFFIX.length()) : propertyName;
	}

	private void renderNonStructuralAttribute(AttributeBridge tealBean, Relationship relationship, ConstrainedDatatype constraints, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		String propertyPath = buildPropertyPath();
		
		BareANY hl7Value = tealBean.getHl7Value();
		String type = determineActualType(relationship, hl7Value, this.result, propertyPath);
		
		PropertyFormatter formatter = this.formatterRegistry.get(type);
		
		if (formatter == null) {
			throw new RenderingException("Cannot support properties of type " + type);
		} else {
			String xmlFragment = "";
			try {
				BareANY any = null;
				
				boolean isMandatoryOrPopulated = ConformanceLevelUtil.isMandatory(relationship) || ConformanceLevelUtil.isPopulated(relationship);
				if (relationship.hasFixedValue()) {
					// suppress rendering fixed values for optional or required
					if (isMandatoryOrPopulated) {
						any = (BareANY) DataTypeFactory.createDataType(relationship.getType());
						Object fixedValue = NonStructuralHl7AttributeRenderer.getFixedValue(relationship, version, this.isR2, this.result, propertyPath);
						((BareANYImpl) any).setBareValue(fixedValue);
					}
				} else {
					any = hl7Value;
					any = this.adapterProvider.getAdapter(any != null ? any.getClass() : null, type).adapt(any);

					// TODO - CDA - TM - implement default value handling
//					boolean valueNotProvided = (any.getBareValue() == null && !any.hasNullFlavor());
//					if (valueNotProvided && relationship.hasDefaultValue() && isMandatoryOrPopulated) {
//						// FIXME - CDA - TM - this doesn't work - will have a class cast exception (put Object convert(Object/String?) on ANY, implement trivial in ANYImpl, implement where necessary?)
//						
//						any.setBareValue(relationship.getDefaultValue());
//					}
					
				}
				
				handleNotAllowedAndIgnored(relationship, propertyPath);
				
				FormatContext context = FormatContextImpl.create(this.result, propertyPath, relationship, version, dateTimeZone, dateTimeTimeZone, constraints, this.isCda);
				if (!StringUtils.equals(type, relationship.getType())) {
					context = new ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl(type, true, context);
				}
				xmlFragment += formatter.format(
						context, 
						any, 
						getIndent());
				
				// if relationship specifies a namespace, need to add it to xml
				if (StringUtils.isNotBlank(xmlFragment) & StringUtils.isNotBlank(relationship.getNamespace())) {
					xmlFragment = xmlFragment.replaceAll("<" + relationship.getName() + " ", "<" + relationship.getNamespace() + ":" + relationship.getName() + " ");
					xmlFragment = xmlFragment.replaceAll("<" + relationship.getName() + ">", "<" + relationship.getNamespace() + ":" + relationship.getName() + ">");
					xmlFragment = xmlFragment.replaceAll("</" + relationship.getName() + ">", "</" + relationship.getNamespace() + ":" + relationship.getName() + ">");
				}
				
			} catch (ModelToXmlTransformationException e) {
				Hl7Error hl7Error = new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, e.getMessage(), propertyPath);
				this.result.addHl7Error(hl7Error);
			}
			renderNewErrorsToXml(currentBuffer().getChildBuilder());
			currentBuffer().getChildBuilder().append(xmlFragment);
		}
	}

	private String determineActualType(Relationship relationship, BareANY hl7Value, final Hl7Errors errors, final String propertyPath) {
		StandardDataType newTypeEnum = (hl7Value == null ? null : hl7Value.getDataType());
		return this.polymorphismHandler.determineActualDataType(relationship.getType(), newTypeEnum, this.isCda, !this.isR2, createErrorLogger(propertyPath, errors));
	}

	private ErrorLogger createErrorLogger(final String propertyPath, final Hl7Errors errors) {
		return new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};
	}

	private void handleNotAllowedAndIgnored(Relationship relationship,	String propertyPath) {
		String warningForIncorrectUseOfIgnore = null;
		if (ConformanceLevelUtil.isIgnored(relationship)) {
			warningForIncorrectUseOfIgnore = MessageFormat.format(isIgnoredNotAllowed() ? 
					ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED :
					ATTRIBUTE_IS_IGNORED_AND_WILL_NOT_BE_USED, relationship.getName());
		}  else if (ConformanceLevelUtil.isNotAllowed(relationship)) {
			warningForIncorrectUseOfIgnore = MessageFormat.format(ATTRIBUTE_IS_NOT_ALLOWED, relationship.getName());
		}
		if (warningForIncorrectUseOfIgnore != null) {
			this.result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, warningForIncorrectUseOfIgnore, propertyPath));
		}
	}


	private void renderNewErrorsToXml(StringBuilder stringBuilder) {
		for (Hl7Error hl7Error : this.result.getHl7Errors()) {
			if (!hl7Error.isRenderedToXml()) {
				stringBuilder.append(this.xmlWarningRenderer.createWarning(getIndent(), hl7Error.toString(), ""));
				hl7Error.markAsRenderedToXml();
			}
		}
	}
	
	private void addNewErrorsToList(List<String> errors) {
		for (Hl7Error hl7Error : this.result.getHl7Errors()) {
			if (!hl7Error.isRenderedToXml()) {
				errors.add(hl7Error.toString());
				hl7Error.markAsRenderedToXml();
			}
		}
	}
	
	private int getIndent() {
		return this.buffers.size();
	}

	public void visitRootEnd(PartBridge tealBean, Interaction interaction) {
		this.propertyPathNames.pop();
	}

	public void visitRootStart(PartBridge tealBean, Interaction interaction) {
		this.propertyPathNames.push(determinePropertyName(tealBean.getPropertyName(), interaction));
		this.interaction = interaction;
		this.buffers.clear();
		this.buffers.push(new Buffer(this.isCda ? "ClinicalDocument" : interaction.getName(), 0));
		
		currentBuffer().getStructuralBuilder().append(" xmlns=\"urn:hl7-org:v3\" ");
		currentBuffer().getStructuralBuilder().append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
		if (this.isCda) {
			currentBuffer().getStructuralBuilder().append("xmlns:sdtc=\"urn:hl7-org:sdtc\" xmlns:cda=\"urn:hl7-org:v3\"");
		} else {
			currentBuffer().getStructuralBuilder().append("ITSVersion=\"XML_1.0\"");
		}
	}
	
	public ModelToXmlResult toXml() {
		while (this.buffers.size() > 1) {
			popBuffer();
		}
		String xml = currentBuffer().toXml();
		this.result.setXmlMessage(xml);
		return this.result;
	}

	private void popBuffer() {
		Buffer buffer = this.buffers.pop();
		if (this.buffers.size() != 0) {
			currentBuffer().getChildBuilder().append(buffer.toXml());
		}
	}

	public void logError(Hl7Error error) {
		this.result.addHl7Error(error);
	}

	public String getCurrentPropertyPath() {
		return buildPropertyPath();
	}
}
