/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.multiplemessageset;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

public class TemplateParameterNameRenamerTest {

	private String originalTemplateParameterName = TemplateParameterNameRenamer.TEMPLATE_PARAMETER_NAME_RENAMES.keySet().iterator().next();
	private String newTemplateParameterName = TemplateParameterNameRenamer.TEMPLATE_PARAMETER_NAME_RENAMES.get(originalTemplateParameterName);
	
	@Test
	public void shouldRenameArgumentTemplateParameterName() {
		Argument argument = new Argument();
		argument.setTemplateParameterName(this.originalTemplateParameterName);
				
		Interaction interaction = new Interaction();
		interaction.getArguments().add(argument);
		
		MessageSet messageSet = new MessageSet();
		messageSet.getInteractions().put("anInteraction", interaction);
		
		assertEquals("old", this.originalTemplateParameterName, argument.getTemplateParameterName());
		new TemplateParameterNameRenamer().renameTemplateParameterNames(messageSet);
		assertEquals("new", this.newTemplateParameterName, argument.getTemplateParameterName());
	}
	
	@Test
	public void shouldRenameNestedArgumentTemplateParameterName() {
		Argument nestedArgument = new Argument();
		nestedArgument.setTemplateParameterName(this.originalTemplateParameterName);
				
		Argument argument = new Argument();
		argument.getArguments().add(nestedArgument);
		
		Interaction interaction = new Interaction();
		interaction.getArguments().add(argument);
		
		MessageSet messageSet = new MessageSet();
		messageSet.getInteractions().put("anInteraction", interaction);
		
		assertEquals("old", this.originalTemplateParameterName, nestedArgument.getTemplateParameterName());
		new TemplateParameterNameRenamer().renameTemplateParameterNames(messageSet);
		assertEquals("new", this.newTemplateParameterName, nestedArgument.getTemplateParameterName());
	}
	
	@Test
	public void shouldRenameRelationshipTemplateParameterName() {
		Relationship relationship = new Relationship();
		relationship.setTemplateParameterName(this.originalTemplateParameterName);
		
		MessagePart messagePart = new MessagePart("ABCD_MT123456CA.MyMessagePart");
		messagePart.getRelationships().add(relationship);
		
		PackageLocation packageLocation = new PackageLocation("ABCD_MT123456CA");
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", packageLocation);
		messageSet.addMessagePart(messagePart);
		
		assertEquals("old", this.originalTemplateParameterName, relationship.getTemplateParameterName());
		new TemplateParameterNameRenamer().renameTemplateParameterNames(messageSet);
		assertEquals("new", this.newTemplateParameterName, relationship.getTemplateParameterName());
	}
	
}
