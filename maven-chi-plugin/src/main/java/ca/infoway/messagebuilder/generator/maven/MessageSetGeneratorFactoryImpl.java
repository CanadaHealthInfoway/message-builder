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

package ca.infoway.messagebuilder.generator.maven;

import java.io.File;

import org.apache.maven.plugin.Mojo;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.MessageSetGenerator;
import ca.infoway.messagebuilder.generator.MifToXmlGenerator;
import ca.infoway.messagebuilder.generator.multiplemessageset.MultipleXmlToXmlGenerator;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;

/**
 * <p>The standard implementation of the generator factory.
 * 
 * @author administrator
 */
class MessageSetGeneratorFactoryImpl implements MessageSetGeneratorFactory {
	
	public MessageSetGenerator create(Mojo mojo, String version, String realmCode, String descriptiveName, File mifTransform, File reportDir) throws GeneratorException {
		return new MifToXmlGenerator(new OutputUIImpl(mojo), version, realmCode, descriptiveName, mifTransform, reportDir);
	}

	public MessageSetGenerator create(Mojo mojo, String version, String realmCode, String descriptiveName, File reportDir) throws GeneratorException {
		return new MultipleXmlToXmlGenerator(new OutputUIImpl(mojo), version, reportDir);
	}

}
