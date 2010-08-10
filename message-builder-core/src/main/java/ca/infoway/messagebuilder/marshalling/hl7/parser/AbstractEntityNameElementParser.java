package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNameUse;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public abstract class AbstractEntityNameElementParser extends AbstractSingleElementParser<EntityName> {

	@Override
	protected EntityName parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		EntityName result = parseNode(node, xmlToJavaResult);
        result.setUses(getNameUses(getAttributeValue(node, "use")));
		return result;
	}
    
    protected Set<EntityNameUse> getNameUses(String nameUseAttribute) {
        Set<EntityNameUse> uses = new HashSet<EntityNameUse>();
        if (nameUseAttribute != null) {
            StringTokenizer tokenizer = new StringTokenizer(nameUseAttribute);
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                EntityNameUse nameUse = CodeResolverRegistry.lookup(EntityNameUse.class, token);
                if (nameUse != null) {
                    uses.add(nameUse);
                }
            }
        }
        return uses;
    }
	
    protected abstract EntityName parseNode(Node node, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException;
   
    public boolean isParseable(Node node) {
        boolean result = false;
        try {
            parse(null, node, new XmlToModelResult());
            result = true;
        } catch (XmlToModelTransformationException e) {
            // expected, sort of
        }
        return result;
    }
}
