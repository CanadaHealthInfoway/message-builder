package ca.infoway.messagebuilder.datatype.lang;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Java datatype for AD Hl7 datatype. 
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-AD
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PostalAddress implements Serializable {
	
    private static final long serialVersionUID = -12550370508382374L;
	private Set<PostalAddressUse> uses = Collections.synchronizedSet(new LinkedHashSet<PostalAddressUse>());
    private final List<PostalAddressPart> parts = Collections.synchronizedList(new ArrayList<PostalAddressPart>());

    /**
     * <p>Obtains the postal address' set of uses.
     * 
     * @return set of postal address uses
     */
    public Set<PostalAddressUse> getUses() {
        return this.uses;
    }
    
    /**
     * <p>Replaces the postal address' set of uses.
     * 
     * @param uses  set of postal address uses
     */
    public void setUses(Set<PostalAddressUse> uses) {
        this.uses = uses;
    }
    
    /**
     * <p>Adds a postal address use.
     * 
     * @param use a postal address use
     */
    public void addUse(PostalAddressUse use) {
        this.uses.add(use);
    }
    
    /**
     * <p>Obtains the list of postal address parts for this postal address.
     * 
     * @return list of postal address parts
     */
    public List<PostalAddressPart> getParts() {
        return this.parts;
    }
    
    /**
     * <p>Add a part to this postal address.
     * 
     * @param postalAddressPart the part to add
     */
    public void addPostalAddressPart(PostalAddressPart postalAddressPart) {
        this.parts.add(postalAddressPart);
    }
}
