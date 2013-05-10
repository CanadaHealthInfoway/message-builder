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

import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class MifDirectory {
	private File directory;
	private File defnFile; 								// DEFN=CA=IFC=*.coremif
	private SortedMap<String, List<MifFile>> mifMap = new TreeMap<String, List<MifFile>>();
	private boolean isScanned = false;
	private boolean ignoreRealms = false;

	public MifDirectory(String dir) {
		this(new File(dir));
	}
	
	public MifDirectory(File dir) {
		this.directory = dir;
	}

	public boolean isIgnoreRealms() {
		return this.ignoreRealms;
	}

	public void setIgnoreRealms(boolean ignoreRealms) {
		this.ignoreRealms = ignoreRealms;
	}

	Collection<File> scanDirectory() throws FileNotFoundException {
		if (!directory.exists()) {
			throw new FileNotFoundException(this.directory.toString() + ": does not exist");
		}
		
		if (!directory.isDirectory()) {
			throw new FileNotFoundException(this.directory.toString() + ": is not a directory");
		}
		
		try {
			return FileUtils.listFiles(this.directory, TrueFileFilter.TRUE,
					TrueFileFilter.TRUE);
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals(
					"Parameter 'directory' is not a directory")) {
				throw new FileNotFoundException(this.directory.toString());
			} else {
				throw e;
			}
		}
	}

	void addMif(MifFile mf) {
		String key = mf.getSubSection() + mf.getDomain() + "_" + mf.getArtifact() + mf.getId() +
			(ignoreRealms ? "" : mf.getRealm());

		List<MifFile> files = this.mifMap.get(key);
		if (files == null) {
			files = new LinkedList<MifFile>();
			this.mifMap.put(key, files);
		}
		files.add(mf);
	}

	//TODO Complain if contains both a/foo and b/foo (same name, different dirs)
	//TODO WARN about multiple files with same key -- gist of warning is that pairing up of files was guessed at, and might be wrong
	void analyzeContents(Collection<File> rawContents, MessageList errors) {
		for (File f : rawContents) {
			String baseName = f.getName();
			if (baseName.endsWith(".mif")) {
				try {
					MifFile mf = new MifFile(f);
					addMif(mf);
				} catch (IllegalArgumentException e) {
					// TODO: put f in the correct File argument (left or right as appropriate)
					errors.add(new Message(ERROR, UNRECOGNIZED_FILE_TYPE, "Malformed MIF name", f, null));
				}
			}

			else if (f.getName().startsWith("DEFN=CA=IFC=")) {
				if (defnFile == null) {
					defnFile = f;
				} else {
					errors.add(new Message(ERROR, UNPAIRED_FILE, "Extra DEFN=CA=IFC=*.coremif file", f, null));
				}
			}
			
			else if (f.getName().endsWith(".coremif")) {
				errors.add(new Message(INFO, IGNORED_FILE, "Ignored coremif file", f, null));
			}

			else {
				errors.add(new Message(ERROR, UNRECOGNIZED_FILE_TYPE, "Unrecognized filename pattern: \"" + baseName + "\"", f, null));
			}
		}
		
		isScanned = true;
	}

	public File getDirectory() {
		return directory;
	}

	public File getDefnFile() {
		return defnFile;
	}

	public SortedMap<String, List<MifFile>> getMifMap() {
		return mifMap;
	}
	
	public void scanAndAnalyze(MessageList msgs) throws FileNotFoundException {
		if (isScanned)
			return;
		
		Collection<File> contents = scanDirectory();
		analyzeContents(contents, msgs);
		
	}
	
}
