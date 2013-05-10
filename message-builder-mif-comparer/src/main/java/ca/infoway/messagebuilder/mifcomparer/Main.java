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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.NamespaceContext;

import org.ini4j.Ini;
import org.ini4j.Profile;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import ca.infoway.messagebuilder.mifcomparer.Message.Severity;

public class Main {
	private enum OutputFormat { TEXT, CSV, XML }; 
	
	@Option(name = "-s", usage = "minimum severity to include in output")
	private Severity severity;

	@Option(name = "-c", usage = "config file")
	private File configFile;
	
	@Option(name = "-f", usage = "output format")
	private OutputFormat format = OutputFormat.XML;

	@Option(name = "-h", usage = "print help")
	private boolean help = false;
	
	@Option(name = "-ignore-realms", usage = "ignore \"realm\" fields when choosing pairs of files to compare")
	private boolean ignoreRealms = false;

	@Argument
	private static List<String> pathnames = new LinkedList<String>();
	
	private GlobalConfiguration globalConfig;

	public void setSeverity(String s) {
	}

	public static void main(String[] args) {
		try {
			new Main().doMain(args);
		} catch (FatalConditionException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	public void doMain(String[] args) {
		parseArguments(args);

		if (configFile == null) {
			globalConfig = new GlobalConfiguration();
		} else {
			try {
				globalConfig = new GlobalConfiguration(configFile);
			} catch (IOException e) {
				throw new FatalConditionException("Error reading config file " + configFile + ": " + e.getMessage(), e);
			}
		}
		
		MessageList messages = new MessageList();
		File left = new File(pathnames.get(0));
		File right = new File(pathnames.get(1));
		
		if (left.isDirectory() && right.isDirectory()) {
			compareDirectories(left, right, messages);
		} else {
			compareFiles(left, right, messages);
		}

		if (format == OutputFormat.TEXT)
			System.out.print(messages.asText(severity));
		else if (format == OutputFormat.CSV)
			System.out.print(messages.asCSV(severity));
		else if (format == OutputFormat.XML)
			System.out.print(messages.asXML(severity));
		else
			System.err.println("Unsupported output format \"" + format + "\"");
		
		System.err.print(messages.getStatistics());
	}

	public void parseArguments(String[] args) {
		CmdLineParser parser = new CmdLineParser(this);

		try {
			parser.parseArgument(args);

			if (help) {
				usage();
				System.exit(0);
			}

			if (pathnames.size() != 2)
				throw new CmdLineException(parser,
						pathnames.size() + " pathnames supplied; expecting 2");

		} catch (CmdLineException e) {
			System.err.println("Error: " + e.getMessage());
			System.err.println("(-h for help)");
			System.exit(2);
		}
	}

	public void compareDirectories(File fLeft, File fRight, MessageList messages) {
		MifDirectory mdLeft = new MifDirectory(fLeft);
		MifDirectory mdRight = new MifDirectory(fRight);
		
		mdLeft.setIgnoreRealms(ignoreRealms);
		mdRight.setIgnoreRealms(ignoreRealms);
		
		MifDirectoryComparer comparer = new MifDirectoryComparer(mdLeft, mdRight);
		comparer.setGlobalConfig(globalConfig);
		comparer.compare(messages);
	}
	
	public void compareFiles(File fLeft, File fRight, MessageList messages) {
		XmlFileComparer comparer = new XmlFileComparer(fLeft, fRight, messages);
		comparer.setGlobalConfig(globalConfig);
		comparer.compare();
	}

	public void usage() {
		CmdLineParser parser = new CmdLineParser(this);

		System.err.println("Usage: java -jar mif-comparer.jar [options...] dir1 dir2...");
		System.err.println("       java -jar mif-comparer.jar [options...] file1 file2...");
		//TODO:  Accept file arguments, as well as directories
		System.err.println("Where:");
		// print the list of available options
		parser.printUsage(System.err);
		System.err.println();
	}
}
