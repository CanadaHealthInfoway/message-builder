package ca.infoway.messagebuilder.domainvalue.nullflavor;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum NullFlavor. Indicates why a value is not present
 */
public class NullFlavor extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.NullFlavor {

    private static final long serialVersionUID = 7363875379566291402L;
    
	public static final NullFlavor NO_INFORMATION = new NullFlavor("NO_INFORMATION", "NI"); 
    public static final NullFlavor OTHER = new NullFlavor("OTHER", "OTH"); 
    public static final NullFlavor NEGATIVE_INFINITY = new NullFlavor("NEGATIVE_INFINITY", "NINF"); 
    public static final NullFlavor POSITIVE_INFINITY = new NullFlavor("POSITIVE_INFINITY", "PINF");
    public static final NullFlavor UNKNOWN = new NullFlavor("UNKNOWN", "UNK"); 
    public static final NullFlavor ASKED_BUT_UNKNOWN = new NullFlavor("ASKED_BUT_UNKNOWN", "ASKU"); 
    public static final NullFlavor TEMPORARILY_UNAVAILABLE = new NullFlavor("TEMPORARILY_UNAVAILABLE", "NAV");
    public static final NullFlavor SUFFICIENT_QUANTITY = new NullFlavor("SUFFICIENT_QUANTITY", "QS"); 
    public static final NullFlavor NOT_ASKED = new NullFlavor("NOT_ASKED", "NASK"); 
    public static final NullFlavor TRACE = new NullFlavor("TRACE", "TRC"); 
    public static final NullFlavor MASKED = new NullFlavor("MASKED", "MSK");
    public static final NullFlavor NOT_APPLICABLE = new NullFlavor("NOT_APPLICABLE", "NA"); 
    public static final NullFlavor UN_ENCODED = new NullFlavor("UN_ENCODED", "UNC");
    
    private final String codeValue;

    private NullFlavor(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeValue() {
        return this.codeValue;
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_NULL_FLAVOR.getRoot();
    }

    /**
     * * fast Code lookup **.
     *
     * @param codeValue the code value
     * @return the null flavor
     */
    public static final NullFlavor lookup(String codeValue) {
    	if (StringUtils.isBlank(codeValue)) {
    		return null;
    	} else if (codeToNullFlavor.containsKey(codeValue)) {
    		return codeToNullFlavor.get(codeValue);
    	} else {
    		return null;
    	}
    }
    
    private static final Map<String, NullFlavor> codeToNullFlavor;
    
    static {
    	codeToNullFlavor = new HashMap<String, NullFlavor>();
    	for (NullFlavor nullFlavor : EnumPattern.values(NullFlavor.class)) {
    		codeToNullFlavor.put(nullFlavor.getCodeValue(), nullFlavor);
    	}
    }
    
}
