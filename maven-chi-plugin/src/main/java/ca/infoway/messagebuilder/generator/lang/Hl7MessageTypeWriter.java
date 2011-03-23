package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.util.iterator.EmptyIterable.nullSafeIterable;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.JavaCodeGenerator;
import ca.infoway.messagebuilder.generator.java.PropertyGenerator;
import ca.infoway.messagebuilder.generator.java.RenderedType;
import ca.infoway.messagebuilder.xml.Relationship;

public abstract class Hl7MessageTypeWriter extends JavaCodeGenerator {
	
	protected final RenderedType type;
	
	protected Hl7MessageTypeWriter(RenderedType type) {
		this.type = type;
	}
	
	protected void writeAllRelationships(Writer writer, int indentLevel) throws IOException {
		if (!isAbstractAndHasNoRelationships(this.type)) {
        	if (this.type.isAbstract()) {
        		writeAbstractRelationships(writer, indentLevel, this.type.getRelationships());
        	} else {
        		writeRelationships(writer, indentLevel, this.type.getRelationships());
        	}
        }
	}

	private boolean isAbstractAndHasNoRelationships(RenderedType type) {
		return type.isAbstract() && CollectionUtils.isEmpty(type.getRelationships()); 
	}

	private void writeAbstractRelationships(Writer writer, int indentLevel, List<BaseRelationship> relationships) throws IOException {
        for (BaseRelationship relationship : nullSafeIterable(relationships)) {
            if (!relationship.isFixed()) {
            	createPropertyGenerator(relationship).createGettersAndSettersForInterface(indentLevel, writer);
            	writer.write(LINE_SEPARATOR);
            }
        }
    }

	private void writeRelationships(Writer writer, int indentLevel, List<BaseRelationship> relationships) throws IOException {
        for (BaseRelationship relationship : nullSafeIterable(relationships)) {
            if (!relationship.isFixed()) {
                createPropertyGenerator(relationship).createAttributeDefinition(indentLevel, writer);
            }
        }
        writer.write(LINE_SEPARATOR);
        if (writeConstructor(writer, indentLevel, relationships)) {
        	writer.write(LINE_SEPARATOR);
        }

        for (BaseRelationship relationship : nullSafeIterable(relationships)) {
            if (!relationship.isFixed()) {
            	createPropertyGenerator(relationship).createGettersAndSetters(indentLevel, writer);
            	if (relationship.isChoice() && !relationship.isCardinalityMultiple()) {
            		List<Relationship> choices = relationship.getRelationship().getChoices();
            		createChoiceProperties(relationship, choices, indentLevel, writer);
            	}
            	writer.write(LINE_SEPARATOR);
            }
        }
    }
	
	private void createChoiceProperties(BaseRelationship rootChoice, List<Relationship> choices, int indentLevel, Writer writer) throws IOException {
		for (Relationship choiceRelationship : choices) {
			if (choiceRelationship.isChoice()) {
        		createChoiceProperties(rootChoice, choiceRelationship.getChoices(), indentLevel, writer);
			} else {
				// write this get/has (translate choice type and leaf choice type into useable names)
            	writer.write(LINE_SEPARATOR);
				PropertyGenerator choicePropertyGenerator = createChoicePropertyGenerator(rootChoice, choiceRelationship);
				choicePropertyGenerator.createDerivedChoiceGetterProperties(indentLevel, writer);
			}
		}
	}
	
	protected boolean writeConstructor(Writer writer, int indentLevel, List<BaseRelationship> relationships) throws IOException {
		return false;
	}

	protected abstract PropertyGenerator createPropertyGenerator(BaseRelationship relationship);

	protected abstract PropertyGenerator createChoicePropertyGenerator(BaseRelationship rootChoice, Relationship choiceRelationship);
	
}
