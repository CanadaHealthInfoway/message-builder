package ca.infoway.messagebuilder.datatype.lang;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Abstract super class for names.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public abstract class EntityName {

    private Set<EntityNameUse> uses = Collections.synchronizedSet(new HashSet<EntityNameUse>());
    
    /**
     * <p>Obtains the list of name parts.
     * 
     * @return the list of name parts
     */
    public abstract List<EntityNamePart> getParts();
    
    /**
     * <p>Obtains the set of name uses for this name.
     * 
     * @return the set of name uses
     */
    public Set<EntityNameUse> getUses() {
        return this.uses;
    }
    
    /**
     * <p>Replaces the set of name uses for this name.
     * 
     * @param uses the set of name uses
     */
    public void setUses(Set<EntityNameUse> uses) {
        this.uses = uses;
    }
    
    /**
     * <p>Adds a name use to this name.
     * 
     * @param use the name use to add
     */
    public void addUse(EntityNameUse use) {
        this.uses.add(use);
    }
}
