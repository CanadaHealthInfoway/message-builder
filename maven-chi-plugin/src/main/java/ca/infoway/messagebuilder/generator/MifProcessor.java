package ca.infoway.messagebuilder.generator;

import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import ca.infoway.messagebuilder.xml.MessageSet;

interface MifProcessor {
	public void addMessagePartsFromMifs(MessageSet messageSet, List<MifReference> mifs) throws IOException, XPathExpressionException, GeneratorException;
}
