package ca.infoway.messagebuilder.lang;


public class XmlStringEscape {

    public static String escape(String str) {
    	StringBuilder builder = new StringBuilder();
    	
        int len = str == null ? 0 : str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            String entityName = entityName(c);
            if (entityName == null) {
                if (c > 0x7F) {
                    builder.append("&#");
                    int ascii = c;
                    builder.append(ascii);
                    builder.append(';');
                } else {
                    builder.append(c);
                }
            } else {
                builder.append('&');
                builder.append(entityName);
                builder.append(';');
            }
        }
        return builder.toString();
    }

	private static String entityName(char c) {
		switch (c) {
		case '\'':
			return "apos";
		case '&':
			return "amp";
		case '<':
			return "lt";
		case '>':
			return "gt";
		case '"':
			return "quot";
		default:
			return null;
		}
	}
	
	
}
