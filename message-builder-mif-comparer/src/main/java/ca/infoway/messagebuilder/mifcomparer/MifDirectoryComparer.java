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

import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.DESCRIPTIONS_DIFFER;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.UNPAIRED_FILE;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class MifDirectoryComparer {
	private MifDirectory leftMD;
	private MifDirectory rightMD;
	private final Class<? extends FileComparer> comparerClass;
	private final Constructor<? extends FileComparer> comparerConstructor;
	private GlobalConfiguration globalConfig;
	
	public MifDirectoryComparer(MifDirectory l, MifDirectory r) {
		this(l, r, XmlFileComparer.class);
	}
	
	public MifDirectoryComparer(MifDirectory l, MifDirectory r, Class<? extends FileComparer> c) {
		this.leftMD = l;
		this.rightMD = r;
		this.comparerClass = c;
		this.comparerConstructor = findComparerConstructor();
	}
	
	private Constructor<? extends FileComparer> findComparerConstructor() {
		Class<?>[] constructorArgs = { File.class, File.class, MessageList.class };
		try {
			return comparerClass.getConstructor(constructorArgs);
		} catch (Exception e) {
			throw new RuntimeException("Internal error: Can't instantiate comparer class", e);
		}
	}
	
	void compare(MessageList msgs) {
		try {
			leftMD.scanAndAnalyze(msgs);
			rightMD.scanAndAnalyze(msgs);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(2);
		}
		
		compareAllMifFiles(msgs);
		compareDefnFiles(msgs);
	}
	
	void compareAllMifFiles(MessageList msgs) {
		SortedSet<String> keys = new TreeSet<String>();
		keys.addAll(leftMD.getMifMap().keySet());
		keys.addAll(rightMD.getMifMap().keySet());
		
		for (String k : keys) {
			compareMifLists(leftMD.getMifMap().get(k), rightMD.getMifMap().get(k), msgs);
		}
	}
	
	void compareDefnFiles(MessageList msgs) {
		File left = leftMD.getDefnFile();
		File right = rightMD.getDefnFile();
		
		if (left == null && right == null) {
			return; 
		
		} else if (right == null) {
			msgs.add(new Message(ERROR, UNPAIRED_FILE, "File occurs only in " + leftMD.getDirectory(), left, null));
			
		} else if (left == null) {
			msgs.add(new Message(ERROR, UNPAIRED_FILE, "File occurs only in " + rightMD.getDirectory(), null, right));
			
		} else {
			compareFiles(left, right, msgs);
		}
	}
	
	void compareMifLists(List<MifFile> leftList, List<MifFile> rightList, MessageList msgs) {
		if (leftList == null && rightList == null) {
			throw new IllegalStateException("compareMifLists with two null lists: how did we get here?"); 
		
		} else if (rightList == null) {
			for (MifFile mf : leftList) {
				msgs.add(new Message(ERROR, UNPAIRED_FILE, "File occurs only in " + leftMD.getDirectory(), mf, null));
			}
			
		} else if (leftList == null) {
			for (MifFile mf : rightList) {
				msgs.add(new Message(ERROR, UNPAIRED_FILE, "File occurs only in " + rightMD.getDirectory(), null, mf));
			}
			
		} else {
			compareMifListsNonNull(leftList, rightList, msgs);
		}
	}
	
	private	void compareMifListsNonNull(List<MifFile> leftList, List<MifFile> rightList, MessageList msgs) {
		/*
		 * First, handle the pairs with identical basenames.
		 */
		for (MifFile left : new ArrayList<MifFile>(leftList)) {					// By iterating over a copy, we can safely...
			for (MifFile right : new ArrayList<MifFile>(rightList)) {			//    ... call remove() on the original
				if (left.getBasename().equals(right.getBasename())) {
					compareFiles(left, right, msgs);
					leftList.remove(left);
					rightList.remove(right);
				}
			}
		}

		/*
		 * At this point, we know that no entry in leftList *exactly* matches
		 * any entry in rightList.
		 *
		 * We just compare the file pairs in order.
		 */
		while (leftList.size() > 0 && rightList.size() > 0) {
			MifFile left = leftList.get(0);
			MifFile right = rightList.get(0);
			leftList.remove(left);
			rightList.remove(right);
			
			if (!left.getDescription().equals(right.getDescription())) {
				msgs.add(new Message(TRIVIAL, DESCRIPTIONS_DIFFER, "Different descriptions for same key", left, right));
			} else {
				// Do nothing.  If "-ignore-realms" option was passed, the realms might differ,
				// but we don't report that since the user specifically asked to ignore the fact.
			}
			compareFiles(left, right, msgs);
		}

		/*
		 * At this point, one of the lists is empty, so any remaining files in the
		 * other list are necessarily unpaired.
		 */
		for (MifFile left : leftList) {
			msgs.add(new Message(ERROR, UNPAIRED_FILE, "File occurs only in " + leftMD.getDirectory(), left, null));
		}

		for (MifFile right : rightList) {
			msgs.add(new Message(ERROR, UNPAIRED_FILE, "File occurs only in " + rightMD.getDirectory(), null, right));
		}
	}

	void compareFiles(MifFile left, MifFile right, MessageList msgs) {
		compareFiles(left.getFile(), right.getFile(), msgs);	
	}
	
	void compareFiles(File left, File right, MessageList msgs) {
		FileComparer comparer;
		try {
			comparer = (FileComparer)this.comparerConstructor.newInstance(left, right, msgs);
			comparer.setGlobalConfig(globalConfig);
		} catch (Exception e) {
			throw new RuntimeException("Internal error: Can't instantiate comparer class", e);
		}
		
		comparer.compare();
	}

	public GlobalConfiguration getGlobalConfig() {
		return globalConfig;
	}

	public void setGlobalConfig(GlobalConfiguration globalConfig) {
		this.globalConfig = globalConfig;
	}
}
