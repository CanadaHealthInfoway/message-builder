package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

public class MifToXmlGeneratorTest {

	class MifReferenceImpl implements MifReference {
		private final File file;

		public MifReferenceImpl(File file) {
			this.file = file;
		}
		public File asFile() {
			return this.file;
		}
		public String getCategory() {
			return null;
		}
	}
	
	@Test
	public void shouldFindFirstMif() throws Exception {
		MifToXmlGenerator generator = new MifToXmlGenerator(null, "someVersion", null);
		List<MifReference> list = new ArrayList<MifReference>();
		list.add(new MifReferenceImpl(new File("sldjf.dmif")));
		list.add(new MifReferenceImpl(new File("sldjf2.dmif")));
		list.add(new MifReferenceImpl(new File("blorf.mif")));
		list.add(new MifReferenceImpl(new File("hubbahubba.mif")));
		MifReference mifFile = generator.getFirstMifFile(list);
		assertEquals("extension", "mif", FilenameUtils.getExtension(mifFile.asFile().getName()));
		assertEquals("name", "blorf.mif", mifFile.asFile().getName());
	}
}
