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

package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.io.Writer;

public interface PropertyGenerator {

	public void createAttributeDefinition(int indentLevel, Writer writer) throws IOException;
	public void createGetters(int indentLevel, Writer writer) throws IOException;
	public void createSetters(int indentLevel, Writer writer) throws IOException;
	public void createGettersAndSetters(int indentLevel, Writer writer) throws IOException;
	public void createGettersForInterface(int indentLevel, Writer writer) throws IOException;
	public void createSettersForInterface(int indentLevel, Writer writer) throws IOException;
	public void createGettersAndSettersForInterface(int indentLevel, Writer writer) throws IOException;
	public void createDerivedChoiceGetterProperties(int indentLevel, Writer writer) throws IOException;
	/**
	 * <p>Create the initialization of the member variable in the class constructor.
	 * 
	 * <p>For Java classes, initialization happens at the same place as variable
	 * definition, but for .Net/C# classes, the initialization happens in the constructor.
	 * 
	 * @param indentLevel - the number of indents that the code should prefix each line with
	 * @param writer - the writer to which we write the code
	 * @throws IOException
	 */
	public void createConstructorInitialization(int indentLevel, Writer writer) throws IOException;

}