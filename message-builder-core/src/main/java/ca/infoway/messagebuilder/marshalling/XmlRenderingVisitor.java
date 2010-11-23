package ca.infoway.messagebuilder.marshalling;

import static ca.infoway.messagebuilder.marshalling.BeanBridgeChoiceRelationshipResolver.resolveChoice;
import static ca.infoway.messagebuilder.xml.ChoiceSupport.choiceOptionTypePredicate;

import java.text.MessageFormat;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

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
				builder.append(new XmlWarningRenderer().createWarning(this.indent, this.warning));
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
			this.propertyPathNames.push(part.getPropertyName());
			this.buffers.push(new Buffer(determineXmlName(part, relationship), this.buffers.size()));
			if (part.isEmpty() && relationship.getConformance() == ConformanceLevel.POPULATED) {
				currentBuffer().getStructuralBuilder().append(
						MessageFormat.format(NULL_FLAVOR_FORMAT_FOR_ASSOCIATIONS, getNullFlavor(part).getCodeValue()));
			} else if (part.isEmpty() && relationship.getConformance() == ConformanceLevel.MANDATORY && !isTrivial(part)) {
				currentBuffer().setWarning("Mandatory association has no data. (" + relationship.getName() + ")");
			}
		}
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

	public void visitAttribute(AttributeBridge tealBean, Relationship relationship, VersionNumber version) {
		this.propertyPathNames.push(tealBean.getPropertyName());
		if (relationship.isStructural()) {
			new VisitorStructuralAttributeRenderer(relationship, tealBean.getValue()).render(currentBuffer().getStructuralBuilder());
		} else {
			renderNonStructuralAttribute(tealBean, relationship, version);
		}
		this.propertyPathNames.pop();
		// remove(this.propertyPathNames.size() - 1);
	}

	private void renderNonStructuralAttribute(AttributeBridge tealBean, Relationship relationship, VersionNumber version) {
		String type = relationship.getType();
		PropertyFormatter formatter = FormatterRegistry.getInstance().get(type);
		if (formatter == null) {
			throw new RenderingException("Cannot support properties of type " + type);
		} else {
			try {
				BareANY any;
				
				if (relationship.isFixed()) {
					any = (BareANY) DataTypeFactory.createDataType(relationship.getType());
					((BareANYImpl) any).setBareValue(NonStructuralHl7AttributeRenderer.getFixedValue(relationship));
				} else {
					any = tealBean.getHl7Value();
					any = this.adapterProvider.getAdapter(any!=null ? any.getClass() : null, type).adapt(any);
				}
				
				String xmlFragment = formatter.format(FormatContextImpl.create(relationship, version), any, getIndent());
				currentBuffer().getChildBuilder().append(xmlFragment);
			} catch (ModelToXmlTransformationException e) {
				String propertyPath = StringUtils.join(this.propertyPathNames, ".");
				Hl7Error hl7Error = new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, e.getMessage(), propertyPath);
				this.result.addHl7Error(hl7Error);
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
		this.propertyPathNames.push(tealBean.getPropertyName());
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
