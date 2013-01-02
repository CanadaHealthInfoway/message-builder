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
import static ca.infoway.messagebuilder.util.xml.ConformanceLevelUtil.ASSOCIATION_IS_IGNORED_AND_CAN_NOT_BE_USED;
import static ca.infoway.messagebuilder.util.xml.ConformanceLevelUtil.ASSOCIATION_IS_IGNORED_AND_WILL_NOT_BE_USED;
import static ca.infoway.messagebuilder.util.xml.ConformanceLevelUtil.ASSOCIATION_IS_NOT_ALLOWED;
import static ca.infoway.messagebuilder.util.xml.ConformanceLevelUtil.ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED;
import static ca.infoway.messagebuilder.util.xml.ConformanceLevelUtil.ATTRIBUTE_IS_IGNORED_AND_WILL_NOT_BE_USED;
import static ca.infoway.messagebuilder.util.xml.ConformanceLevelUtil.ATTRIBUTE_IS_NOT_ALLOWED;
import static ca.infoway.messagebuilder.util.xml.ConformanceLevelUtil.isIgnoredNotAllowed;
import static ca.infoway.messagebuilder.xml.ChoiceSupport.choiceOptionTypePredicate;

import java.text.MessageFormat;
import java.util.Stack;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.impl.DataTypeFactory;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.marshalling.datatypeadapter.DataTypeValueAdapterProvider;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterRegistry;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.ModelToXmlTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.PropertyFormatter;
import ca.infoway.messagebuilder.util.text.Indenter;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Predicate;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.util.XmlWarningRenderer;

class XmlRenderingVisitor implements Visitor {	
	private static final String NULL_FLAVOR_FORMAT_FOR_ASSOCIATIONS = "nullFlavor=\"{0}\" xsi:nil=\"true\"";

	class Buffer {
		private final String name;
		private final StringBuilder structuralBuilder = new StringBuilder();
		private final StringBuilder childBuilder = new StringBuilder();
		private final int indent;
		private String warning;

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
			if (StringUtils.isNotBlank(this.warning)) {
				builder.append(this.xmlWarningRenderer.createWarning(this.indent, this.warning));
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
		public String getWarning() {
			return this.warning;
		}
		public void setWarning(String warning) {
			this.warning = warning;
		}
	}
	
	private final Stack<String> propertyPathNames = new Stack<String>();
	private final Stack<Buffer> buffers = new Stack<Buffer>();
	private Interaction interaction;
	private final DataTypeValueAdapterProvider adapterProvider = new DataTypeValueAdapterProvider();
	private final ModelToXmlResult result = new ModelToXmlResult();
	private final XmlWarningRenderer xmlWarningRenderer = new XmlWarningRenderer();
	
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
				|| relationship.getConformance() == ConformanceLevel.MANDATORY 
				|| relationship.getConformance() == ConformanceLevel.POPULATED;
	}

	public void visitAssociationStart(PartBridge part, Relationship relationship) {
		if (isSomethingToRender(part, relationship)) {
			boolean validationWarning = false;
			String warningMessage = null;
			this.propertyPathNames.push(determinePropertyName(part.getPropertyName(), relationship));
			String propertyPath = StringUtils.join(this.propertyPathNames, ".");
			this.buffers.push(new Buffer(determineXmlName(part, relationship), this.buffers.size()));
			
			if (part.isEmpty() && relationship.getConformance() == ConformanceLevel.POPULATED) {
				currentBuffer().getStructuralBuilder().append(
						MessageFormat.format(NULL_FLAVOR_FORMAT_FOR_ASSOCIATIONS, getNullFlavor(part).getCodeValue()));
			} else if (part.isEmpty() && relationship.getConformance() == ConformanceLevel.MANDATORY && !isTrivial(part)) {
				// some errors are due to "null" parts MB has inserted to create structural XML; don't log error on these
				validationWarning = !part.isNullPart();
				warningMessage = "Mandatory association has no data. (" + propertyPath + ")";
				currentBuffer().setWarning(warningMessage);
			} else if (relationship.getConformance() == ConformanceLevel.IGNORED) {
				validationWarning = true;
				warningMessage = MessageFormat.format(isIgnoredNotAllowed() ? 
						ASSOCIATION_IS_IGNORED_AND_CAN_NOT_BE_USED :
						ASSOCIATION_IS_IGNORED_AND_WILL_NOT_BE_USED, relationship.getName());
				currentBuffer().setWarning(warningMessage);
			} else if (relationship.getConformance() == ConformanceLevel.NOT_ALLOWED) {
				validationWarning = true;
				warningMessage = MessageFormat.format(ASSOCIATION_IS_NOT_ALLOWED, relationship.getName());
				currentBuffer().setWarning(warningMessage);
			}
			
			if (validationWarning) {
				// also store error within error collection
				this.result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, warningMessage, propertyPath));
			}
			
		}
	}

	private String determinePropertyName(String propertyName, Named nameFallBack) {
		String backupName = (nameFallBack == null ? null : nameFallBack.getName());
		return StringUtils.isNotBlank(propertyName) ? propertyName : StringUtils.defaultString(backupName);
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
			if (relationship.getRelationship().isAssociation() || !relationship.getRelationship().isFixed()) {
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
			Relationship option = resolveChoice(tealBean, relationship);
			if (option == null) {
				throw new RenderingException("Cannot determine the choice type of relationship : " + relationship.getName());
			} else {
				return option.getName();
			}
		}
	}

	public void visitAttribute(AttributeBridge tealBean, Relationship relationship, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		this.propertyPathNames.push(determinePropertyName(tealBean.getPropertyName(), relationship));
		if (relationship.isStructural()) {
			boolean validationWarning = false;
			String warningMessage = null;
			String propertyPath = StringUtils.join(this.propertyPathNames, ".");
			
			if (StringUtils.isBlank(currentBuffer().getWarning()) && relationship.getConformance() == ConformanceLevel.IGNORED) {
				validationWarning = true;
				warningMessage = MessageFormat.format(isIgnoredNotAllowed() ? 
						ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED :
						ATTRIBUTE_IS_IGNORED_AND_WILL_NOT_BE_USED, relationship.getName());
				currentBuffer().setWarning(warningMessage);
			}  else if (relationship.getConformance() == ConformanceLevel.NOT_ALLOWED) {
				warningMessage = MessageFormat.format(ATTRIBUTE_IS_NOT_ALLOWED, relationship.getName());
				currentBuffer().setWarning(warningMessage);
			}
			if (validationWarning) {
				validationWarning = true;
				// also store error within error collection
				this.result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, warningMessage, propertyPath));
			}
			new VisitorStructuralAttributeRenderer(relationship, tealBean.getValue()).render(currentBuffer().getStructuralBuilder(), propertyPath, this.result);
		} else {
			renderNonStructuralAttribute(tealBean, relationship, version, dateTimeZone, dateTimeTimeZone);
		}
		this.propertyPathNames.pop();
	}

	private void renderNonStructuralAttribute(AttributeBridge tealBean, Relationship relationship, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		String type = relationship.getType();
		PropertyFormatter formatter = FormatterRegistry.getInstance().get(type);
		if (formatter == null) {
			throw new RenderingException("Cannot support properties of type " + type);
		} else {
			String propertyPath = StringUtils.join(this.propertyPathNames, ".");
			String xmlFragment = "";
			try {
				BareANY any;
				
				if (relationship.isFixed()) {
					any = (BareANY) DataTypeFactory.createDataType(relationship.getType());
					((BareANYImpl) any).setBareValue(NonStructuralHl7AttributeRenderer.getFixedValue(relationship, version));
				} else {
					any = tealBean.getHl7Value();
					any = this.adapterProvider.getAdapter(any!=null ? any.getClass() : null, type).adapt(any);
				}
				
				if (StringUtils.isBlank(currentBuffer().getWarning()) && relationship.getConformance() == ConformanceLevel.IGNORED) {
					if (isIgnoredNotAllowed()){
						xmlFragment += new XmlWarningRenderer().createWarning(0, MessageFormat.format(ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED, relationship.getName()));
					} else {
						xmlFragment += new XmlWarningRenderer().createWarning(0, MessageFormat.format(ATTRIBUTE_IS_IGNORED_AND_WILL_NOT_BE_USED, relationship.getName()));
					}
				} else if (relationship.getConformance() == ConformanceLevel.NOT_ALLOWED) {
					xmlFragment += new XmlWarningRenderer().createWarning(0, MessageFormat.format(ATTRIBUTE_IS_NOT_ALLOWED, relationship.getName()));
				}
//				boolean isSpecializationType = (tealBean.getHl7Value().getDataType() != tealBean.getRelationship().getType());
				// FIXME - VALIDATION - TM - SPECIALIZATION_TYPE - need to allow for specialization type to be set here???
				CodingStrength codingStrength = relationship.getCodingStrength();
				xmlFragment += formatter.format(FormatContextImpl.create(this.result, propertyPath, relationship, version, dateTimeZone, dateTimeTimeZone, codingStrength), any, getIndent());
			} catch (ModelToXmlTransformationException e) {
				Hl7Error hl7Error = new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, e.getMessage(), propertyPath);
				this.result.addHl7Error(hl7Error);
			}
			renderNewErrorsToXml(currentBuffer().getChildBuilder());
			currentBuffer().getChildBuilder().append(xmlFragment);
		}
	}

	private void renderNewErrorsToXml(StringBuilder stringBuilder) {
		for (Hl7Error hl7Error : this.result.getHl7Errors()) {
			if (!hl7Error.isRenderedToXml()) {
				stringBuilder.append(this.xmlWarningRenderer.createWarning(getIndent(), hl7Error.toString()));
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
		this.buffers.push(new Buffer(interaction.getName(), 0));
		currentBuffer().getStructuralBuilder()
				.append(" xmlns=\"urn:hl7-org:v3\" ")
				.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\"");
		
	}
	
	public ModelToXmlResult toXml() {
		while (this.buffers.size() > 1) {
			popBuffer();
		}
		String xml = currentBuffer().toXml();
		this.result.setXmlMessage(xml);
		return result;
	}

	private void popBuffer() {
		Buffer buffer = this.buffers.pop();
		if (this.buffers.size() != 0) {
			currentBuffer().getChildBuilder().append(buffer.toXml());
		}
	}
}
