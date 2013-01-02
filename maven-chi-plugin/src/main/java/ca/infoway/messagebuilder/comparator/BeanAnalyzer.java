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

package ca.infoway.messagebuilder.comparator;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.type.ClassOrInterfaceType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanAnalyzer {
	
	// if adding interfaces or behaviour to this enum, please consider using enum pattern for translation purposes
	public enum ErrorType {
		EXTENDS, 
		IMPLEMENTS, 
		NO_CORRESPONDING_CLASS, 
		METHOD_NOT_FOUND, 
		DIFFERENT_RETURN_TYPE, CLASS_NOT_PUBLIC;
	}
	
	private final Log log = LogFactory.getLog(BeanAnalyzer.class);
	
	private final String oldRootPath;
	private final String newRootPath;
	private BeanVisitor oldVisitor;
	private BeanVisitor newVisitor;

	public BeanAnalyzer(String oldRootPath, String newRootPath) {
		this.oldRootPath = oldRootPath;
		this.newRootPath = newRootPath;
	}

	List<BeanAnalysisError> analyzeFile(File file) throws ParseException, IOException {
		List<BeanAnalysisError> errors = new ArrayList<BeanAnalysisError>();
		
		CompilationUnit oldCompilationUnit = JavaParser.parse(new FileInputStream(file));
		try {
			String newPath = file.getPath().replace(this.oldRootPath, this.newRootPath);
			CompilationUnit newCompilationUnit = JavaParser.parse(new FileInputStream(new File(newPath)));
		
			this.oldVisitor = new BeanVisitor();
			this.oldVisitor.visit(oldCompilationUnit, oldCompilationUnit);

			this.newVisitor = new BeanVisitor();			
			this.newVisitor.visit(newCompilationUnit, newCompilationUnit);

			findAndAddErrors(file, errors);
			
		} catch (FileNotFoundException e) {
			errors.add(new BeanAnalysisError(file, ErrorType.NO_CORRESPONDING_CLASS, "no corresponding file among new beans"));
		} catch (RuntimeException e) {
			System.err.println("Unable to analyze file: " + file.getName());
			throw e;
		}

		return errors;
	}

	private void findAndAddErrors(File file, List<BeanAnalysisError> errors) {
		if (!this.newVisitor.isClassOrInterfacePublic()) {
			errors.add(new BeanAnalysisError(file, ErrorType.CLASS_NOT_PUBLIC, "class is not public"));
		}
		if (!sameLists(this.oldVisitor.getExtendsList(), this.newVisitor.getExtendsList())) {
			errors.add(new BeanAnalysisError(file, ErrorType.EXTENDS, "extends list differs"));
		}
		if (!sameLists(this.oldVisitor.getImplementsList(), this.newVisitor.getImplementsList())) {
			errors.add(new BeanAnalysisError(file, ErrorType.IMPLEMENTS, "implements list differs"));
		}
		
		findAndAddMethodErrors(file, errors);
	}

	private boolean sameLists(List<ClassOrInterfaceType> oldList, List<ClassOrInterfaceType> newList) {
		if (oldList.size() != newList.size()) {
			return false;
		} else {
			List<String> oldExtendsList = new ArrayList<String>();
			for (ClassOrInterfaceType classOrInterfaceType : oldList) {
				String typeName = TypeUtil.getTypeName(classOrInterfaceType);
				if (typeName != null) {
					oldExtendsList.add(typeName);
				}
			}
			List<String> newExtendsList = new ArrayList<String>();
			for (ClassOrInterfaceType classOrInterfaceType : newList) {
				String typeName = TypeUtil.getTypeName(classOrInterfaceType);
				if (typeName != null) {
					newExtendsList.add(typeName);
				}
			}
			return newExtendsList.containsAll(oldExtendsList);
		}
	}

	private void findAndAddMethodErrors(File file, List<BeanAnalysisError> errors) {
		for (String methodString : this.oldVisitor.getSignatureToReturnTypeMap().keySet()) {
			if (!this.newVisitor.getSignatureToReturnTypeMap().containsKey(methodString)) {
				// method not found
				errors.add(new BeanAnalysisError(file, ErrorType.METHOD_NOT_FOUND, "method not found: " + methodString));
			} else if (!sameMethodReturnType(methodString)) {
				// return types different
				errors.add(new BeanAnalysisError(file, ErrorType.DIFFERENT_RETURN_TYPE, "method '" + methodString + "' has different return types"));					
			}
		}
	}

	private boolean sameMethodReturnType(String methodString) {
		return StringUtils.equals(
				this.newVisitor.getSignatureToReturnTypeMap().get(methodString), 
				this.oldVisitor.getSignatureToReturnTypeMap().get(methodString));
	}
	
	private Iterable<File> collectFiles() {
		ArrayList<File> files = new ArrayList<File>();

		collectFiles(new File(this.oldRootPath), files);
		
		return files ;
	}

	private void collectFiles(File root, final ArrayList<File> files) {
		String[] fileNames = root.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.endsWith("Bean.java")) {
					return true;
				} else {
					File directory = new File(dir, name);
					if (directory.isDirectory() && (!".".equals(name) && !"..".equals(name) && !".svn".equals(name))) {
						collectFiles(directory, files);
					}
				}
				return false;
			}
		});

		for (String fileName : fileNames) {
			File file = new File(root, fileName);
			files.add(file);
		}
		
	}


	public BeanAnalysisResult analyze() throws IOException {
		Iterable<File> files = collectFiles();
		
		BeanAnalysisResult result = new BeanAnalysisResult();
		
		for (File file : files) {
			try {
				result.addErrors(file, analyzeFile(file));
			} catch (FileNotFoundException e) {
				log.error("Unable to anaylze file: " + file.getName(), e);
			} catch (ParseException e) {
				log.error("Unable to anaylze file: " + file.getName(), e);
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		 BeanAnalysisResult result = new BeanAnalyzer(
				 "./etc/comparator/old/",
				 "./etc/comparator/new/"
				 ).analyze();
		 System.out.println(result.getBeanAnalysisReport());
		 System.out.println("DONE!");	 
	}
}
