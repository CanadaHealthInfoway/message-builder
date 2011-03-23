package ca.infoway.messagebuilder.datatype.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Java datatype for TN Hl7 datatypes.
 * 
 * <p>A string used for simple names for things (e.g. drug names) and places (e.g. "Canada Health Infoway")
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class TrivialName extends EntityName {

    private final String name;
   
    /**
     * 
     * <p>Constructs a trivial name based on a string.
     * 
     * @param name the trivial name
     */
    public TrivialName(String name) {
        this.name = name;
    }

    /**
     * <p>Returns this trivial name as a list containing a single EntityNamPart.
     * 
     * @return this trivial name as a list of parts.
     */
    @Override
    public List<EntityNamePart> getParts() {
        if (this.name == null) {
            return new ArrayList<EntityNamePart>();
        } else {
            return Arrays.asList(new EntityNamePart(this.name));
        }
    }

    /**
     * <p>Returns this trivial name formatted as a string.
     *  
     * @return this trivial name formatted as a string 
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * 
     * <p>Returns the underlying string representing this trivial name.
     * 
     * @return the underlying string representing this trivial name.
     */
    public String getName() {
        return this.name;
    }
}
