package ca.infoway.messagebuilder.acceptance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.acceptance.runner.javadoc.FilesProvider;
import ca.infoway.messagebuilder.acceptance.runner.javadoc.ProjectFilesProvider;
import ca.infoway.messagebuilder.util.iterator.NodeListIterator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.NodeUtil;

public class DetectSpecialCharactersTest {
	
	private final List<String> directoryExclusions = Arrays.asList();
	private final List<String> fileExclusions = Arrays.asList("BusinessNameUtilTest.java");
	
	@Test
	public void shouldAvoidSpecialCharacters() throws Exception {
		Set<File> results = new HashSet<File>();
		
		FilesProvider filesProvider = new ProjectFilesProvider(getProjectNames(), false);

		for (File sourceFile : filesProvider.getFiles()) {
			if (!this.fileExclusions.contains(sourceFile.getName())) {
				checkFileForSpecialCharacters(results, sourceFile);
			}
		}
		
		if (!results.isEmpty()) {
			Assert.fail(generateErrorMessage(results));
		}
				
	}

	private String generateErrorMessage(Set<File> results) {
		StringBuffer sb = new StringBuffer();
		for (File file : results) {
			sb.append(MessageFormat.format("File {0} contains special characters.\n", file.getName()));
		}
		return sb.toString();
	}

	private void checkFileForSpecialCharacters(Set<File> results, File sourceFile) throws IOException {
		byte[] bytes = getFileAsBytes(sourceFile);
		if (bytes != null) {
			for (byte b : bytes) {
				if (!(128 > b && b >= 0)) {
					results.add(sourceFile);
					break;
				}
			}
		}
	}

	private byte[] getFileAsBytes(File file) throws IOException {
		InputStream input = new FileInputStream(file);
		if (input == null) {
			return null;
		} else {
			try {
				return IOUtils.toByteArray(input);
			} finally {
				IOUtils.closeQuietly(input);
			}
		}
	}

	
	private List<String> getProjectNames() throws Exception {
		List<String> result = new ArrayList<String>();

		Document document = readParentPom();
		NodeList nodes = document.getElementsByTagNameNS("http://maven.apache.org/POM/4.0.0", "module");
		for (Element element : NodeListIterator.elementIterable(nodes)) {
			String projectName = NodeUtil.getTextValue(element);
			if (!this.directoryExclusions.contains(projectName)) {
				result.add(projectName);
			}
		}
		return result;
	}
	
	private Document readParentPom() throws SAXException, IOException {
		return new DocumentFactory().createFromFile(new File("../pom.xml"));
	}
	
}
