package ca.infoway.messagebuilder.datatype.lang;

import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum representing all the valid and applicable URL types used within MessageBuilder.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class URLScheme extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.URLScheme, Describable {
	
    private static final long serialVersionUID = -2569871003868077442L;
    
	public static final URLScheme FTP = new URLScheme("ftp"); 
    public static final URLScheme FAX = new URLScheme("fax"); 
    public static final URLScheme FILE = new URLScheme("file"); 
    public static final URLScheme HTTP = new URLScheme("http"); 
    public static final URLScheme HTTPS = new URLScheme("https"); 
    public static final URLScheme MLLP = new URLScheme("mllp"); 
    public static final URLScheme MAILTO = new URLScheme("mailto"); 
    public static final URLScheme MODEM = new URLScheme("modem"); 
    public static final URLScheme NFS = new URLScheme("nfs"); 
    public static final URLScheme TEL = new URLScheme("tel", "Phone"); 
    public static final URLScheme TELNET = new URLScheme("telnet");

	private final String description;

    private URLScheme(String codeValue) {
    	super(codeValue);
        this.description = DescribableUtil.getDefaultDescription(name());
    }
    
    private URLScheme(String codeValue, String description) {
    	super(codeValue);
		this.description = description;
    }
    
    /**
     * <p>Returns the code system for the URL.
     * 
     * @return the code system for the URL
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_URL_SCHEME.getRoot();
    }

    /**
     * <p>Returns the value (protocol) for the URL.
     * 
     * @return the value (protocol) for the URL.
     */
    public String getCodeValue() {
        return name();
    }

    /**
     * <p>A description of the URL.
     * 
     * @return the URL description
     */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * <p>Returns a list of enums applicable for "phone". 
	 *  
	 * @return URLs applicable for phone
	 */
	public static List<URLScheme> getPhoneSchemes() {
		return Arrays.asList(FAX, TEL); 
	}
}
