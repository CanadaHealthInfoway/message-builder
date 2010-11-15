package ca.infoway.messagebuilder.xml;

import java.io.File;

public class Cleaner {
	
	public static void main(String[] args) throws Exception {
		
//		File file = new File("../message-builder-release-v02_r02/src/main/resources/messageSet_v02_r02.xml");
//		File file = new File("../message-builder-release-v01_r04_3/src/main/resources/messageSet_v01r04_3.xml");
//		File file = new File("../message-builder-release-newfoundland/src/main/resources/messageSet_NEWFOUNDLAND.xml");
//		File file = new File("../message-builder-release-r02_04_02/src/main/resources/messageSet_r02_04_02.xml");
		File file = new File("../message-builder-xml-validation/src/test/resources/ca/infoway/messagebuilder/xml/validator/messageSet_v02r02.xml");
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		MessageSet messageSet = marshaller.unmarshall(file);
		
		marshaller.marshall(messageSet, file);
		
	}

}
