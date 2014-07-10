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

package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.LogLevel.INFO;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

public class MessageSetWriter {

	private final MessageSet messageSet;
	private final OutputUI outputUI;

	public MessageSetWriter(MessageSet messageSet, OutputUI outputUI) {
		this.messageSet = messageSet;
		this.outputUI = outputUI;
	}
	
	public void writeToMessageSet(File outputFile) throws GeneratorException, IOException {
		if (outputFile == null) {
			throw new IllegalArgumentException("output file must not be null");
		} else if (outputFile.exists() && outputFile.isDirectory()) {
			throw new IllegalArgumentException("The output location cannot be a directory");
		} else {
			try {
				
				for (Interaction interaction : this.messageSet.getInteractions().values()) {
					for (Argument argument : interaction.getArguments()) {
						if (StringUtils.isBlank(argument.getName())) {
							System.out.println(interaction.getName() + " has blank argument name1");
						}
						for (Argument argument2 : argument.getArguments()) {
							if (StringUtils.isBlank(argument2.getName())) {
								System.out.println(interaction.getName() + " has blank argument name2");
							}
							for (Argument argument3 : argument2.getArguments()) {
								if (StringUtils.isBlank(argument3.getName())) {
									System.out.println(interaction.getName() + " has blank argument name3");
								}
							}
						}
					}
				}
				
				for (PackageLocation packageLocation : this.messageSet.getPackageLocations().values()) {
					for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
						for (Relationship relationship : messagePart.getRelationships()) {
							if (StringUtils.isBlank(relationship.getName())) {
								System.out.println(packageLocation.getName());
								System.out.println(messagePart.getName());
								System.out.println("empty name for relationship");
							}
							
						}
					}
				}
				FileDirectoryUtil.createDirectoriesIfNeeded(outputFile);
				new MessageSetMarshaller().marshall(this.messageSet, outputFile);
				
				this.outputUI.log(INFO, "The message set has been written to \"" + outputFile + "\"");
			} catch (IOException e) {
				throw e;
			} catch (Exception e) {
				throw new GeneratorException(e);
			}
		}
	}

}
