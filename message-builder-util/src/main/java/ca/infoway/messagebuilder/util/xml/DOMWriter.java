package ca.infoway.messagebuilder.util.xml;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @sharpen.ignore
 */
public class DOMWriter {
	
	   /** Default Encoding */
    private static  String  PRINTWRITER_ENCODING = "UTF8";

    private static String MIME2JAVA_ENCODINGS[] =
    { "Default", "UTF-8", "US-ASCII", "ISO-8859-1", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4",
        "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-2022-JP",
        "SHIFT_JIS", "EUC-JP","GB2312", "BIG5", "EUC-KR", "ISO-2022-KR", "KOI8-R", "EBCDIC-CP-US",
        "EBCDIC-CP-CA", "EBCDIC-CP-NL", "EBCDIC-CP-DK", "EBCDIC-CP-NO", "EBCDIC-CP-FI", "EBCDIC-CP-SE",
        "EBCDIC-CP-IT", "EBCDIC-CP-ES", "EBCDIC-CP-GB", "EBCDIC-CP-FR", "EBCDIC-CP-AR1",
        "EBCDIC-CP-HE", "EBCDIC-CP-CH", "EBCDIC-CP-ROECE","EBCDIC-CP-YU",
        "EBCDIC-CP-IS", "EBCDIC-CP-AR2", "UTF-16"
    };

    /** Print writer. */
    protected PrintWriter out;

    /** Canonical output. */
    protected boolean canonical;
    protected boolean needNormalize;

    static class MIME2Java {
        
        static private Hashtable<String, String> s_enchash;
        static private Hashtable<String, String> s_revhash;
        
        static {
            s_enchash = new Hashtable<String, String>();
            //    <preferred MIME name>, <Java encoding name>
            s_enchash.put("UTF-8", "UTF8");
            s_enchash.put("US-ASCII",        "8859_1");    // ?
            s_enchash.put("ISO-8859-1",      "8859_1");
            s_enchash.put("ISO-8859-2",      "8859_2");
            s_enchash.put("ISO-8859-3",      "8859_3");
            s_enchash.put("ISO-8859-4",      "8859_4");
            s_enchash.put("ISO-8859-5",      "8859_5");
            s_enchash.put("ISO-8859-6",      "8859_6");
            s_enchash.put("ISO-8859-7",      "8859_7");
            s_enchash.put("ISO-8859-8",      "8859_8");
            s_enchash.put("ISO-8859-9",      "8859_9");
            s_enchash.put("ISO-2022-JP",     "JIS");
            s_enchash.put("SHIFT_JIS",       "SJIS");
            s_enchash.put("EUC-JP",          "EUCJIS");
            s_enchash.put("GB2312",          "GB2312");
            s_enchash.put("BIG5",            "Big5");
            s_enchash.put("EUC-KR",          "KSC5601");
            s_enchash.put("ISO-2022-KR",     "ISO2022KR");
            s_enchash.put("KOI8-R",          "KOI8_R");

            s_enchash.put("EBCDIC-CP-US",    "CP037");
            s_enchash.put("EBCDIC-CP-CA",    "CP037");
            s_enchash.put("EBCDIC-CP-NL",    "CP037");
            s_enchash.put("EBCDIC-CP-DK",    "CP277");
            s_enchash.put("EBCDIC-CP-NO",    "CP277");
            s_enchash.put("EBCDIC-CP-FI",    "CP278");
            s_enchash.put("EBCDIC-CP-SE",    "CP278");
            s_enchash.put("EBCDIC-CP-IT",    "CP280");
            s_enchash.put("EBCDIC-CP-ES",    "CP284");
            s_enchash.put("EBCDIC-CP-GB",    "CP285");
            s_enchash.put("EBCDIC-CP-FR",    "CP297");
            s_enchash.put("EBCDIC-CP-AR1",   "CP420");
            s_enchash.put("EBCDIC-CP-HE",    "CP424");
            s_enchash.put("EBCDIC-CP-CH",    "CP500");
            s_enchash.put("EBCDIC-CP-ROECE", "CP870");
            s_enchash.put("EBCDIC-CP-YU",    "CP870");
            s_enchash.put("EBCDIC-CP-IS",    "CP871");
            s_enchash.put("EBCDIC-CP-AR2",   "CP918");

                                                    // j:CNS11643 -> EUC-TW?
                                                    // ISO-2022-CN? ISO-2022-CN-EXT?
                                                    
            s_revhash = new Hashtable<String, String>();
            //    <Java encoding name>, <preferred MIME name>
            s_revhash.put("UTF8", "UTF-8");
            //s_revhash.put("8859_1", "US-ASCII");    // ?
            s_revhash.put("8859_1", "ISO-8859-1");
            s_revhash.put("8859_2", "ISO-8859-2");
            s_revhash.put("8859_3", "ISO-8859-3");
            s_revhash.put("8859_4", "ISO-8859-4");
            s_revhash.put("8859_5", "ISO-8859-5");
            s_revhash.put("8859_6", "ISO-8859-6");
            s_revhash.put("8859_7", "ISO-8859-7");
            s_revhash.put("8859_8", "ISO-8859-8");
            s_revhash.put("8859_9", "ISO-8859-9");
            s_revhash.put("JIS", "ISO-2022-JP");
            s_revhash.put("SJIS", "Shift_JIS");
            s_revhash.put("EUCJIS", "EUC-JP");
            s_revhash.put("GB2312", "GB2312");
            s_revhash.put("BIG5", "Big5");
            s_revhash.put("KSC5601", "EUC-KR");
            s_revhash.put("ISO2022KR", "ISO-2022-KR");
            s_revhash.put("KOI8_R", "KOI8-R");

            s_revhash.put("CP037", "EBCDIC-CP-US");
            s_revhash.put("CP037", "EBCDIC-CP-CA");
            s_revhash.put("CP037", "EBCDIC-CP-NL");
            s_revhash.put("CP277", "EBCDIC-CP-DK");
            s_revhash.put("CP277", "EBCDIC-CP-NO");
            s_revhash.put("CP278", "EBCDIC-CP-FI");
            s_revhash.put("CP278", "EBCDIC-CP-SE");
            s_revhash.put("CP280", "EBCDIC-CP-IT");
            s_revhash.put("CP284", "EBCDIC-CP-ES");
            s_revhash.put("CP285", "EBCDIC-CP-GB");
            s_revhash.put("CP297", "EBCDIC-CP-FR");
            s_revhash.put("CP420", "EBCDIC-CP-AR1");
            s_revhash.put("CP424", "EBCDIC-CP-HE");
            s_revhash.put("CP500", "EBCDIC-CP-CH");
            s_revhash.put("CP870", "EBCDIC-CP-ROECE");
            s_revhash.put("CP870", "EBCDIC-CP-YU");
            s_revhash.put("CP871", "EBCDIC-CP-IS");
            s_revhash.put("CP918", "EBCDIC-CP-AR2");
        }

        private MIME2Java() {
        }

        /**
         * Convert a MIME charset name, also known as an XML encoding name, to a Java encoding name.
         * @param   mimeCharsetName Case insensitive MIME charset name: <code>UTF-8, US-ASCII, ISO-8859-1,
         *                          ISO-8859-2, ISO-8859-3, ISO-8859-4, ISO-8859-5, ISO-8859-6,
         *                          ISO-8859-7, ISO-8859-8, ISO-8859-9, ISO-2022-JP, Shift_JIS, 
         *                          EUC-JP, GB2312, Big5, EUC-KR, ISO-2022-KR, KOI8-R,
         *                          EBCDIC-CP-US, EBCDIC-CP-CA, EBCDIC-CP-NL, EBCDIC-CP-DK,
         *                          EBCDIC-CP-NO, EBCDIC-CP-FI, EBCDIC-CP-SE, EBCDIC-CP-IT,
         *                          EBCDIC-CP-ES, EBCDIC-CP-GB, EBCDIC-CP-FR, EBCDIC-CP-AR1,
         *                          EBCDIC-CP-HE, EBCDIC-CP-CH, EBCDIC-CP-ROECE, EBCDIC-CP-YU,
         *                          EBCDIC-CP-IS and EBCDIC-CP-AR2</code>.
         * @return                  Java encoding name, or <var>null</var> if <var>mimeCharsetName</var>
         *                          is unknown.
         * @see #reverse
         */
        public static String convert(String mimeCharsetName) {
            return (String)s_enchash.get(mimeCharsetName.toUpperCase());
        }

        /**
         * Convert a Java encoding name to MIME charset name.
         * Available values of <i>encoding</i> are "UTF8", "8859_1", "8859_2", "8859_3", "8859_4",
         * "8859_5", "8859_6", "8859_7", "8859_8", "8859_9", "JIS", "SJIS", "EUCJIS",
         * "GB2312", "BIG5", "KSC5601", "ISO2022KR",  "KOI8_R", "CP037", "CP277", "CP278",
         * "CP280", "CP284", "CP285", "CP297", "CP420", "CP424", "CP500", "CP870", "CP871" and "CP918".
         * @param   encoding    Case insensitive Java encoding name: <code>UTF8, 8859_1, 8859_2, 8859_3,
         *                      8859_4, 8859_5, 8859_6, 8859_7, 8859_8, 8859_9, JIS, SJIS, EUCJIS,
         *                      GB2312, BIG5, KSC5601, ISO2022KR, KOI8_R, CP037, CP277, CP278,
         *                      CP280, CP284, CP285, CP297, CP420, CP424, CP500, CP870, CP871 
         *                      and CP918</code>.
         * @return              MIME charset name, or <var>null</var> if <var>encoding</var> is unknown.
         * @see #convert
         */
        public static String reverse(String encoding) {
            return (String)s_revhash.get(encoding.toUpperCase());
        }
    }

    /** Returns a sorted list of attributes. */
    protected Attr[] sortAttributes(NamedNodeMap attrs) {

        int len = (attrs != null) ? attrs.getLength() : 0;
        Attr array[] = new Attr[len];
        for ( int i = 0; i < len; i++ ) {
            array[i] = (Attr)attrs.item(i);
        }
        for ( int i = 0; i < len - 1; i++ ) {
            String name  = array[i].getNodeName();
            int    index = i;
            for ( int j = i + 1; j < len; j++ ) {
                String curName = array[j].getNodeName();
                if ( curName.compareTo(name) < 0 ) {
                    name  = curName;
                    index = j;
                }
            }
            if ( index != i ) {
                Attr temp    = array[i];
                array[i]     = array[index];
                array[index] = temp;
            }
        }

        return(array);

    } // sortAttributes(NamedNodeMap):Attr[]

    //
    // Constructors
    //

    public DOMWriter(String encoding, boolean canonical)
    throws UnsupportedEncodingException {
        this(encoding, canonical, true);
    }

    /** Default constructor */
    public DOMWriter() throws UnsupportedEncodingException {
        this(false, true);
    }

    /** Default constructor. */
    public DOMWriter(boolean canonical, boolean needNormalize) throws UnsupportedEncodingException {
        this( getWriterEncoding(), canonical, needNormalize);
    }

    public static String renderAsString(Node node, boolean canonical, boolean needNormalize) throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        DOMWriter domWriter = new DOMWriter(canonical, needNormalize);
        domWriter.setPrintWriter(printWriter);
        domWriter.print(node);
        
        return stringWriter.toString();
    }

    //
    // Constructors
    //

    /** Default constructor. */
    public DOMWriter(boolean canonical) throws UnsupportedEncodingException {
        this( getWriterEncoding(), canonical, true);
    }

    /** Prints the specified node, recursively. */
    public void print(Node node) {
        // is there anything to do?
        if ( node == null ) {
            return;
        }

        int type = node.getNodeType();
        switch ( type ) {
        // print document
        case Node.DOCUMENT_NODE: {
                if ( !canonical ) {
                    String  Encoding = getWriterEncoding();
                    if ( Encoding.equalsIgnoreCase( "DEFAULT" ) )
                        Encoding = "UTF-8";
                    else if ( Encoding.equalsIgnoreCase( "Unicode" ) )
                        Encoding = "UTF-16";
                    else
                        Encoding = MIME2Java.reverse( Encoding );

                    out.println("<?xml version=\"1.0\" encoding=\""+
                                Encoding + "\"?>");
                }
                //print(((Document)node).getDocumentElement());

                NodeList children = node.getChildNodes();
                for ( int iChild = 0; iChild < children.getLength(); iChild++ ) {
                    print(children.item(iChild));
                }
                out.flush();
                break;
            }

            // print element with attributes
        case Node.ELEMENT_NODE: {
                out.print('<');
                out.print(node.getNodeName());
                Attr attrs[] = sortAttributes(node.getAttributes());
                for ( int i = 0; i < attrs.length; i++ ) {
                    Attr attr = attrs[i];
                    out.print(' ');
                    out.print(attr.getNodeName());
                    out.print("=\"");
                    out.print(this.needNormalize? normalize(attr.getNodeValue()) : attr.getNodeValue());
                    out.print('"');
                }
                out.print('>');
                NodeList children = node.getChildNodes();
                if ( children != null ) {
                    int len = children.getLength();
                    for ( int i = 0; i < len; i++ ) {
                        print(children.item(i));
                    }
                }
                break;
            }

            // handle entity reference nodes
        case Node.ENTITY_REFERENCE_NODE: {
                if ( canonical ) {
                    NodeList children = node.getChildNodes();
                    if ( children != null ) {
                        int len = children.getLength();
                        for ( int i = 0; i < len; i++ ) {
                            print(children.item(i));
                        }
                    }
                } else {
                    out.print('&');
                    out.print(node.getNodeName());
                    out.print(';');
                }
                break;
            }

            // print cdata sections
        case Node.CDATA_SECTION_NODE: {
                if ( canonical ) {
                    out.print(this.needNormalize? normalize(node.getNodeValue()) : node.getNodeValue());
                } else {
                    out.print("<![CDATA[");
                    out.print(node.getNodeValue());
                    out.print("]]>");
                }
                break;
            }

            // print text
        case Node.TEXT_NODE: {
                out.print(this.needNormalize? normalize(node.getNodeValue()) : node.getNodeValue());
                break;
            }

            // print processing instruction
        case Node.PROCESSING_INSTRUCTION_NODE: {
                out.print("<?");
                out.print(node.getNodeName());
                String data = node.getNodeValue();
                if ( data != null && data.length() > 0 ) {
                    out.print(' ');
                    out.print(data);
                }
                out.println("?>");
                break;
            }
        }

        if ( type == Node.ELEMENT_NODE ) {
            out.print("</");
            out.print(node.getNodeName());
            out.print('>');
        }

        out.flush();

    } // print(Node)

    /** Normalizes the given string. */
    protected String normalize(String s) {
        StringBuffer str = new StringBuffer();

        int len = (s != null) ? s.length() : 0;
        for ( int i = 0; i < len; i++ ) {
            char ch = s.charAt(i);
            switch ( ch ) {
            case '<': {
                    str.append("&lt;");
                    break;
                }
            case '>': {
                    str.append("&gt;");
                    break;
                }
            case '&': {
                    str.append("&amp;");
                    break;
                }
            case '"': {
                    str.append("&quot;");
                    break;
                }
            case '\r':
            case '\n': {
                    if ( canonical ) {
                        str.append("&#");
                        str.append(Integer.toString(ch));
                        str.append(';');
                        break;
                    }
                    // else, default append char
                }
            default: {
                    str.append(ch);
                }
            }
        }

        return(str.toString());

    } // normalize(String):String

    public static String renderAsString(Node node, boolean canonical) throws IOException {
        return renderAsString(node, canonical, true);
    }

    public DOMWriter(String encoding, boolean canonical, boolean needNormalize)
    throws UnsupportedEncodingException {
        out = new PrintWriter(new OutputStreamWriter(System.out, encoding));
        this.canonical = canonical;
        this.needNormalize = needNormalize;
    } // <init>(String,boolean)

    public static String renderAsString(Node node) throws IOException {
        return renderAsString(node, false);
    }

    public static String getWriterEncoding( ) {
        return(PRINTWRITER_ENCODING);
    }// getWriterEncoding

    public void setPrintWriter(PrintWriter printWriter) {
        if (printWriter != null) {
            out = printWriter;
        }
    }

    public static void  setWriterEncoding( String encoding ) {
        if ( encoding.equalsIgnoreCase( "DEFAULT" ) )
            PRINTWRITER_ENCODING  = "UTF8";
        else if ( encoding.equalsIgnoreCase( "UTF-16" ) )
            PRINTWRITER_ENCODING  = "Unicode";
        else
            PRINTWRITER_ENCODING = MIME2Java.convert( encoding );
    }// setWriterEncoding

    public static boolean isValidJavaEncoding( String encoding ) {
        for ( int i = 0; i < MIME2JAVA_ENCODINGS.length; i++ )
            if ( encoding.equals( MIME2JAVA_ENCODINGS[i] ) )
                return(true);

        return(false);
    }// isValidJavaEncoding
}

