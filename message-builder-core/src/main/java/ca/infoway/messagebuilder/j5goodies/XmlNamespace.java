package ca.infoway.messagebuilder.j5goodies;

/**
 * @sharpen.ignore j5goodies - Translated manually
 */
class XmlNamespace {
    
    private final String prefix;
    private final String xmlNamespace;

    public XmlNamespace(String prefix, String xmlNamespace) {
        this.prefix = prefix;
        this.xmlNamespace = xmlNamespace;
    }

    public String getXmlNamespace() {
        return this.xmlNamespace;
    }

    public String getPrefix() {
        return this.prefix;
    }

}

