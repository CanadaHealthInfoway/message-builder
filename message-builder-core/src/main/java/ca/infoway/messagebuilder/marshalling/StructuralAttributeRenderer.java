package ca.infoway.messagebuilder.marshalling;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;

abstract class StructuralAttributeRenderer {
	
	private final Log log = LogFactory.getLog(StructuralAttributeRenderer.class);
	protected final Relationship relationship;

	public StructuralAttributeRenderer(Relationship relationship) {
		this.relationship = relationship;
	}

	public void render(StringBuilder builder) {
		if (relationship.isFixed()) {
			formatFixedValue(builder, relationship);
		} else {
			Object value = getValue();
			if (value != null) {
				formatValue(builder, relationship, value);
			} else if (relationship.getConformance() == ConformanceLevel.MANDATORY) {
				this.log.info("Relationship " + relationship.getName() 
						+ " is mandatory, but no value is specified");
			}
		}
	}

	protected abstract Object getValue();

	private void formatValue(StringBuilder builder, Relationship relationship, Object value) {
		builder.append(" ")
				.append(relationship.getName())
				.append("=\"")
				.append(XmlStringEscape.escape(valueAsString(value, relationship)))
				.append("\"");
	}

    private String valueAsString(Object value, Relationship relationship) {
        String type = relationship.getType();
        if (type == null) {
            throw new MarshallingException("Relationship " 
                    + relationship.getName()
                    + " has no type information");
        } else if ("CS".equals(type)) {
            return ((Code)value).getCodeValue();
        } else if ("BL".equals(type)) {
            return Boolean.TRUE.equals(value) ? "true" : "false";
        } else {
            throw new MarshallingException("Cannot handle structural attribute string of type " 
            		+ type + " (" + relationship.getName() + ")");
        }
    }

	private void formatFixedValue(StringBuilder builder, Relationship relationship) {
		builder.append(" ")
				.append(relationship.getName())
				.append("=\"")
				.append(XmlStringEscape.escape(relationship.getFixedValue()))
				.append("\"");
	}
}
