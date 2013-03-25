/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.mifcomparer;

import static org.junit.Assert.assertEquals;
import static ca.infoway.messagebuilder.mifcomparer.Assert.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class MifDirectoryTest extends TestCase {
	@Test
	public void that_addMif_adds_one_mif() {
		// Setup
		File root = new File("root");
		MifFile mif = new MifFile(new File(root, "subdir/MIFA_AA123456CA - a MIF file.mif"));
		MifFile[] exp = {mif};
		MifDirectory obj = new MifDirectory(root);

		// Action
		obj.addMif(mif);
		
		// Test
		assertEquals(1, obj.getMifMap().size());
		Collection<MifFile> act = obj.getMifMap().get("MIFA_AA123456CA");
		assertNotNull(act);
		assertEquals(Arrays.asList(exp), act);
	}
		
	@Test
	public void that_addMif_adds_two_mifs_with_same_key_to_the_same_bucket() {
		// Setup
		File root = new File("root");
		MifFile mif1 = new MifFile(new File(root, "subdir/MIFA_AA123456CA - a MIF file.mif"));
		MifFile mif2 = new MifFile(new File(root, "subdir/MIFA_AA123456CA - a duplicate MIF file.mif"));
		MifFile[] exp = {mif1, mif2};
		MifDirectory obj = new MifDirectory(root);

		// Action
		obj.addMif(mif1);
		obj.addMif(mif2);
		
		// Test
		assertEquals(1, obj.getMifMap().size());
		Collection<MifFile> act = obj.getMifMap().get("MIFA_AA123456CA");
		assertNotNull(act);
		assertEquals(Arrays.asList(exp), act);
	}
		
	@Test
	public void that_addMif_adds_two_mifs_with_different_keys_to_different_buckets() {
		// Setup
		File root = new File("root");
		MifFile mif1 = new MifFile(new File(root, "subdir/MIFA_AA123456CA - a MIF file.mif"));
		MifFile mif2 = new MifFile(new File(root, "subdir/MIFB_AA123456CA - another MIF file.mif"));
		MifFile[] exp1 = {mif1};
		MifFile[] exp2 = {mif2};
		MifDirectory obj = new MifDirectory(root);

		// Action
		obj.addMif(mif1);
		obj.addMif(mif2);
		
		// Test
		assertEquals(2, obj.getMifMap().size());
		Collection<MifFile> act;
		
		act = obj.getMifMap().get("MIFA_AA123456CA");
		assertNotNull(act);
		assertEquals(Arrays.asList(exp1), act);

		act = obj.getMifMap().get("MIFB_AA123456CA");
		assertNotNull(act);
		assertEquals(Arrays.asList(exp2), act);
	}
		
	
	@Test
	public void that_analyzeContents_handles_a_mif() {
		// Setup
		File root = new File("root");
		String[] inputRelNames = { "Volume 4 Client Registry/PRPA_IN101001CA - New Person Added Notification.mif", };
		List<File> inputFiles = makeFileCollection(root, inputRelNames);
		MifFile[] expMifs = {new MifFile(inputFiles.get(0))};
		MifDirectory obj = new MifDirectory(root);

		// Action
		obj.analyzeContents(inputFiles, actMsgs);

		// Test
		assertEquals(1, obj.getMifMap().size());
		Collection<MifFile> actMifs = obj.getMifMap().get("PRPA_IN101001CA");
		assertNotNull(actMifs);
		assertEquals(Arrays.asList(expMifs), actMifs);
	}
	
	@Test
	public void that_analyzeContents_handles_one_defn_file() {
		// Setup
		File root = new File("root");
		String[] inputRelNames = { "DEFN=CA=IFC=R02.04.xx.coremif", };
		List<File> inputFiles = makeFileCollection(root, inputRelNames);
		MifDirectory obj = new MifDirectory(root);

		// Action
		obj.analyzeContents(inputFiles, actMsgs);

		// Test
		assertEquals(0, obj.getMifMap().size());
		assertEquals(inputFiles.get(0), obj.getDefnFile());
	}

	@Test
	public void that_analyzeContents_handles_two_defn_files() {
		// Setup
		File root = new File("root");
		String[] inputRelNames = {	"DEFN=CA=IFC=good.coremif",
									"DEFN=CA=IFC=extra.coremif", };
		List<File> inputFiles = makeFileCollection(root, inputRelNames);
		expMsgs = new String[] { "ERROR: " + inputFiles.get(1) + ", (none): Extra DEFN=CA=IFC=*.coremif file" };
		MifDirectory obj = new MifDirectory(root);

		// Action
		obj.analyzeContents(inputFiles, actMsgs);

		// Test
		assertEquals(0, obj.getMifMap().size());
		assertEquals(inputFiles.get(0), obj.getDefnFile());
	}
	
	@Test
	public void that_analyzeContents_handles_extraneous_coremif_file() {
		// Setup
		File root = new File("root");
		String[] inputRelNames = { "DEFN=CA=DT=R02.04.xx.coremif", };
		List<File> inputFiles = makeFileCollection(root, inputRelNames);
		expMsgs = new String[] { "INFO: " + inputFiles.get(0) + ", (none): Ignored coremif file" };
		MifDirectory obj = new MifDirectory(root);

		// Action
		obj.analyzeContents(inputFiles, actMsgs);

		// Test
		assertEquals(0, obj.getMifMap().size());
		assertNull(obj.getDefnFile());
	}

	@Test
	public void that_analyzeContents_handles_an_unrecognized_filename() {
		// Setup
		File root = new File("root");
		String[] inputRelNames = { "bad_file_name.unknown", };
		List<File> inputFiles = makeFileCollection(root, inputRelNames);
		MifDirectory obj = new MifDirectory(root);
		expMsgs = new String[] { "ERROR: " + inputFiles.get(0).toString() + ", (none): Unrecognized file type" };

		// Action
		obj.analyzeContents(inputFiles, actMsgs);

		// Test
		assertEquals(0, obj.getMifMap().size());
	}


	@Test
	public void that_scanDirectory_retrieves_directory_contents()
			throws FileNotFoundException {
		// Setup
		File dirToList = getResourceAsFile("tiny-mif-dir");
		String[] expectedRelativePathnames = {
				"Volume 2 Terminology/DEFN=CA=VO=R02.04.xx.coremif",
				"Volume 4 Client Registry/PRPA_IN101001CA - New Person Added Notification.mif",
				"Volume 4 Client Registry/PRPA_IN101002CA - Person Information Revised Notification.mif",
				"Volume 4 Client Registry/PRPA_IN101004CA - Resolve Duplicate Person Registrations.mif",
				"Volume 1 Infrastructure/DEFN=CA=IFC=R02.04.xx.coremif",
				"Volume 4 Client Registry/PRPA_IN101999CA - Person Nullified Notification.mif",
				"Volume 2 Terminology/DEFN=UV=VO=R02.04.xx.coremif",
				"Volume 4 Client Registry/PRPA_MT101001CA - Add Client.mif",
				"Volume 4 Client Registry/PRPA_MT101002CA - Revise Client.mif",
				"Volume 4 Client Registry/PRPA_MT101003CA - Nullify Client Record.mif",

		};
		Collection<File> expectedFiles = makeFileCollection(dirToList,
				expectedRelativePathnames);

		// Action
		MifDirectory obj = new MifDirectory(dirToList);
		Collection<File> actualFiles = obj.scanDirectory();

		// Test
		assertEqualsUnordered(expectedFiles, actualFiles);
	}

	@Test
	public void that_scanDirectory_throws_FileNotFoundException_with_useful_message_on_nonexistent_directory()
			throws FileNotFoundException {
		File dirToList = new File("/non/existent/directory");

		// Action
		MifDirectory obj = new MifDirectory(dirToList);
		exception.expect(FileNotFoundException.class);
		exception.expectMessage(dirToList.toString() + ": does not exist");
		Collection<File> temp = obj.scanDirectory();
	}
	
	@Test
	public void that_scanDirectory_throws_IOException_with_useful_message_if_given_a_file()
			throws FileNotFoundException {
		File dirToList = getResourceAsFile("tiny-mif-dir/Volume 1 Infrastructure/DEFN=CA=IFC=R02.04.xx.coremif");

		// Action
		MifDirectory obj = new MifDirectory(dirToList);
		exception.expect(IOException.class);
		exception.expectMessage(dirToList.toString() + ": is not a directory");
		Collection<File> temp = obj.scanDirectory();
	}

	// Utility methods

	/**
	 * Turn a parent directory and a list of relative pathnames into a
	 * List of File objects representing the given pathnames, each
	 * interpreted as relative to the given parent.
	 * 
	 * Does no I/O; it doesn't matter whether the file-system objects actually
	 * exist. This is purely pathname manipulation.
	 */
	private List<File> makeFileCollection(File parentDir,
			String[] contents) {
		List<File> files = new LinkedList<File>();
		for (String p : contents) {
			File f = new File(parentDir, p);
			files.add(f);
		}

		return files;
	}
	
	/**
	 * Turn a Collection of MifFile objects into a Collection of the underlying File
	 * objects.  Order is preserved.
	 */
	private Collection<File> toFileCollection(Collection<MifFile> mifs) {
		Collection<File> files = new LinkedList<File>();
		
		for (MifFile mf : mifs) {
			files.add(mf.getFile());
		}
		
		return files;
	}
}
