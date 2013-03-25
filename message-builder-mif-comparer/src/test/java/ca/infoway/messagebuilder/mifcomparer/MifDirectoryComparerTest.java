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


import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

public class MifDirectoryComparerTest extends TestCase {
	@Test
	public void test_constructor() {
		File leftFile = new File("leftdir");
		File rightFile = new File("rightdir");
		MifDirectory left = new MifDirectory(leftFile);
		MifDirectory right = new MifDirectory(rightFile);

		MifDirectoryComparer obj = new MifDirectoryComparer(left, right);

		assertNotNull(obj);
	}

	@Test
	public void disk_based_smoke_test() {
		File leftDir = getResourceAsFile("disk-based-directory-smoke-test/left-input");
		File rightDir = getResourceAsFile("disk-based-directory-smoke-test/right-input");
		MifDirectory leftMD = new MifDirectory(leftDir);
		MifDirectory rightMD = new MifDirectory(rightDir);
		expMsgs = new String[] {
				"DEBUG: " + new File(leftDir, "dir1/AAAA_AA111111CA")		+ " - identical.mif, " + 
							new File(rightDir, "dirA/AAAA_AA111111CA")		+ " - identical.mif: Comparing using XmlFileComparer",
							
				"INFO: "  + new File(leftDir, "dir1/AAAA_AA111111CA")		+ " - identical.mif, " + 
							new File(rightDir, "dirA/AAAA_AA111111CA")		+ " - identical.mif: Files are identical",
							

				"DEBUG: " + new File(leftDir, "dir2/BBBB_BB222222CA")		+ " - differing in name and content.mif, " +
							new File(rightDir, "dirB/BBBB_BB222222CA")		+ " - differing in content and name.mif: Comparing using XmlFileComparer",
							
				"ERROR: " + new File(leftDir, "dir2/BBBB_BB222222CA")		+ " - differing in name and content.mif(/outer[1]/inner[1]/foo[1]), " +
							new File(rightDir, "dirB/BBBB_BB222222CA")		+ " - differing in content and name.mif(): missing element: \"foo\"",
							
				"ERROR: " + new File(leftDir, "dir2/BBBB_BB222222CA")		+ " - differing in name and content.mif(), " +
							new File(rightDir, "dirB/BBBB_BB222222CA")		+ " - differing in content and name.mif(/outer[1]/inner[1]/bar[1]): extra element: \"bar\"",
							
				"INFO: "  + new File(leftDir, "dir2/BBBB_BB222222CA")		+ " - differing in name and content.mif, " +
							new File(rightDir, "dirB/BBBB_BB222222CA")		+ " - differing in content and name.mif: Files differ",
							
				"WARNING: " + new File(leftDir, "dir2/BBBB_BB222222CA")		+ " - differing in name and content.mif, " +
							  new File(rightDir, "dirB/BBBB_BB222222CA")	+ " - differing in content and name.mif: Different descriptions for same key",
							  

				"DEBUG: " + new File(leftDir, "dir1/DEFN=CA=IFC=R02.04.xx.coremif")		+ ", " + 
							new File(rightDir, "DEFN=CA=IFC=R02.04.xx.coremif")			+ ": Comparing using XmlFileComparer",
									
				"ERROR: " + new File(leftDir, "dir1/DEFN=CA=IFC=R02.04.xx.coremif")		+ "(/coremif[1]/inner[1]/@attr), " +
							new File(rightDir, "DEFN=CA=IFC=R02.04.xx.coremif")			+ "(/coremif[1]/inner[1]/@attr): For attribute \"attr\", expected \"left-value\", but got \"right-value\"",

				"INFO: "  + new File(leftDir, "dir1/DEFN=CA=IFC=R02.04.xx.coremif")		+ ", " +
							new File(rightDir, "DEFN=CA=IFC=R02.04.xx.coremif")			+ ": Files differ",


		};
		
		MifDirectoryComparer obj = new MifDirectoryComparer(leftMD, rightMD);
		obj.compare(actMsgs);
	}
	
	@Test
	public void that_comparer_matches_in_simple_case() {
		String filename = "ABCD_EF123456CA - desc.mif";
		File[] left =  { new File("leftdir",  filename) };
		File[] right = { new File("rightdir", filename) };
		expMsgs = new String[] { "DEBUG: " + left[0].toString() + ", " + right[0].toString() + ": These files were paired up for comparison" };
		
		MifDirectoryComparer obj = createComparerFromFileLists(left, right);
		obj.compare(actMsgs);
		
	}

	@Test
	public void that_comparer_warns_about_single_unpaired_files_with_same_key_but_compares_anyway() {
		File[] left =  {
			new File("leftdir",  "ABCD_EF111111CA - desc 1.mif"),
		};
		File[] right = {
			new File("rightdir", "ABCD_EF111111CA - desc 2.mif"),
		};
		expMsgs = new String[] {
			"DEBUG: " + left[0].toString() + ", " + right[0].toString() + ": These files were paired up for comparison",
			"WARNING: " + left[0].toString() + ", " + right[0].toString() + ": Different descriptions for same key",
		};
						
		MifDirectoryComparer obj = createComparerFromFileLists(left, right);
		obj.compare(actMsgs);
		
	}

	@Test
	public void that_comparer_matches_up_identical_descs_when_others_are_also_present_on_left() {
		File[] left =  {
			new File("leftdir",  "ABCD_EF111111CA - a.mif"),
			new File("leftdir",  "ABCD_EF111111CA - b.mif"),
			new File("leftdir",  "ABCD_EF111111CA - c.mif"),
		};
		File[] right = {
			new File("rightdir", "ABCD_EF111111CA - b.mif"),
		};
		expMsgs = new String[] {
			"DEBUG: " + left[1].toString() + ", " + right[0].toString() + ": These files were paired up for comparison",
			"ERROR: " + left[0].toString()  + ", (none): File occurs only in leftdir",
			"ERROR: " + left[2].toString()  + ", (none): File occurs only in leftdir",
		};
						
		MifDirectoryComparer obj = createComparerFromFileLists(left, right);
		obj.compare(actMsgs);
		
	}

	@Test
	public void that_comparer_matches_up_identical_descs_when_others_are_also_present_on_right() {
		File[] left =  {
			new File("leftdir",  "ABCD_EF111111CA - b.mif"),
		};
		File[] right = {
			new File("rightdir",  "ABCD_EF111111CA - a.mif"),
			new File("rightdir", "ABCD_EF111111CA - b.mif"),
			new File("rightdir",  "ABCD_EF111111CA - c.mif"),
		};
		expMsgs = new String[] {
			"DEBUG: " + left[0].toString() + ", " + right[1].toString() + ": These files were paired up for comparison",
			"ERROR: (none), " + right[0].toString()  + ": File occurs only in rightdir",
			"ERROR: (none), " + right[2].toString()  + ": File occurs only in rightdir",
		};
						
		MifDirectoryComparer obj = createComparerFromFileLists(left, right);
		obj.compare(actMsgs);
		
	}

	@Test
	public void that_comparer_matches_up_identical_descs_when_others_are_also_present_on_both() {
		File[] left =  {
			new File("leftdir",  "ABCD_EF111111CA - a.mif"),
			new File("leftdir",  "ABCD_EF111111CA - left b.mif"),
		};
		File[] right = {
			new File("rightdir", "ABCD_EF111111CA - right b.mif"),
			new File("rightdir", "ABCD_EF111111CA - a.mif"),
		};
		expMsgs = new String[] {
			"DEBUG: " + left[0].toString() + ", " + right[1].toString() + ": These files were paired up for comparison",
			"DEBUG: " + left[1].toString() + ", " + right[0].toString() + ": These files were paired up for comparison",
			"WARNING: " + left[1].toString() + ", " + right[0].toString() + ": Different descriptions for same key",
		};
						
		MifDirectoryComparer obj = createComparerFromFileLists(left, right);
		obj.compare(actMsgs);
		
	}

	@Test
	public void that_comparer_reports_errors_on_multiple_unpaired_files_with_different_keys() {
		File[] left =  {
			new File("leftdir",  "ABCD_EF111111CA - desc.mif"),
			new File("leftdir",  "ABCD_EF444444CA - desc.mif"),
		};
		File[] right = {
			new File("rightdir", "ABCD_EF222222CA - desc.mif"),
			new File("rightdir", "ABCD_EF333333CA - desc.mif"),
		};
		expMsgs = new String[] {
			"ERROR: " + left[0].toString()  + ", (none): File occurs only in leftdir",
			"ERROR: " + left[1].toString()  + ", (none): File occurs only in leftdir",
			"ERROR: (none), " + right[0].toString() + ": File occurs only in rightdir",
			"ERROR: (none), " + right[1].toString() + ": File occurs only in rightdir",
		};
						
		MifDirectoryComparer obj = createComparerFromFileLists(left, right);
		obj.compare(actMsgs);
		
	}

	@Test
	public void that_comparer_pairs_up_multiple_unpaired_files_with_same_key_in_order() {
		File[] left =  {
			new File("leftdir",  "ABCD_EF111111CA - desc 1.mif"),
			new File("leftdir",  "ABCD_EF111111CA - desc 3.mif"),
		};
		File[] right = {
			new File("rightdir", "ABCD_EF111111CA - desc 4.mif"),
			new File("rightdir", "ABCD_EF111111CA - desc 2.mif"),
		};
		expMsgs = new String[] {
				"DEBUG: " + left[0].toString() + ", " + right[0].toString() + ": These files were paired up for comparison",
				"DEBUG: " + left[1].toString() + ", " + right[1].toString() + ": These files were paired up for comparison",
				"WARNING: " + left[0].toString() + ", " + right[0].toString() + ": Different descriptions for same key",
				"WARNING: " + left[1].toString() + ", " + right[1].toString() + ": Different descriptions for same key",
		};
						
		MifDirectoryComparer obj = createComparerFromFileLists(left, right);
		obj.compare(actMsgs);
		
	}

	@Test
	public void that_comparer_reports_errors_on_both_files_with_same_key_when_no_matching_key() {
		File[] left =  {
			new File("leftdir",  "ABCD_EF111111CA - desc 1.mif"),
			new File("leftdir",  "ABCD_EF111111CA - desc 2.mif"),
		};
		File[] right = {
			new File("rightdir", "ABCD_EF222222CA - desc 3.mif"),
			new File("rightdir", "ABCD_EF222222CA - desc 4.mif"),
		};
		expMsgs = new String[] {
			"ERROR: " + left[0].toString()  + ", (none): File occurs only in leftdir",
			"ERROR: " + left[1].toString()  + ", (none): File occurs only in leftdir",
			"ERROR: (none), " + right[0].toString() + ": File occurs only in rightdir",
			"ERROR: (none), " + right[1].toString() + ": File occurs only in rightdir",
		};
						
		MifDirectoryComparer obj = createComparerFromFileLists(left, right);
		obj.compare(actMsgs);
		
	}


	// Utility methods

	/*
	 * Given two arrays of File's, create a MifDirectoryComparer that will
	 * compare them.
	 * 
	 * If any messages are generated, that is treated as a test error (not failure).
	 */
	private MifDirectoryComparer createComparerFromFileLists(File[] leftContents, File[] rightContents) {
		MessageList errorList = new MessageList();
		MifDirectoryComparer comparer = createComparerFromFileLists(leftContents, rightContents, errorList);
		String errors = errorList.asText();
		if (!errors.equals("")) {
			throw new RuntimeException(errors);
		}
		
		return comparer;
	}

	/*
	 * Given two arrays of File's, create a MifDirectoryComparer that will
	 * compare them.
	 * 
	 * Any messages are written to msgs.
	 */
	private MifDirectoryComparer createComparerFromFileLists(File[] leftContents, File[] rightContents, MessageList msgs) {
		File leftFile = new File("leftdir");
		File rightFile = new File("rightdir");
		MifDirectory leftMD = new MifDirectory(leftFile);
		MifDirectory rightMD = new MifDirectory(rightFile);

		leftMD.analyzeContents(Arrays.asList(leftContents), msgs);
		rightMD.analyzeContents(Arrays.asList(rightContents), msgs);

		MifDirectoryComparer obj = new MifDirectoryComparer(leftMD, rightMD, StubFileComparer.class);
		return obj;
	}

}
