package ca.infoway.messagebuilder.datatype.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Java datatype that backs the HL7 datatype ON. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class OrganizationName extends EntityName {

    private List<EntityNamePart> parts = Collections.synchronizedList(new ArrayList<EntityNamePart>());
    
    /**
     * <p>Obtains the name parts.
     * 
     * @return the list of name parts
     */
    @Override
    public List<EntityNamePart> getParts() {
        return this.parts;
    }
    
    /**
     * <p>Adds a name part to the list of parts.
     * 
     * @param namePart the name part to add
     */
    public void addNamePart(EntityNamePart namePart) {
        this.parts.add(namePart);
    }
}
