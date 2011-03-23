package ca.infoway.messagebuilder.generator.maven;

import static ca.infoway.messagebuilder.util.iterator.EmptyIterable.nullSafeIterable;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.infoway.messagebuilder.generator.MifFileUtil;
import ca.infoway.messagebuilder.generator.MifReference;
import ca.infoway.messagebuilder.generator.MifSource;

class MifSourceImpl implements MifSource {
	
	private List<FileSet> fileSets;

	MifSourceImpl(List<FileSet> fileSets) {
		this.fileSets = fileSets;
	}
	
	public List<MifReference> getAllMifs() {
		List<MifReference> mifReferences = new ArrayList<MifReference>();
		for (FileSet fileSet : nullSafeIterable(this.fileSets)) {
			Collection<File> files = MifFileUtil.getMifFiles(fileSet.getDirectory());
			for (File file : nullSafeIterable(files)) {
				mifReferences.add(new MifReferenceImpl(file, fileSet.getName()));
			}
		}
		return mifReferences;
	}

}
