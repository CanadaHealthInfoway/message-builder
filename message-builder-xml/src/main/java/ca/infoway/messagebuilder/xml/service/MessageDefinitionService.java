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

package ca.infoway.messagebuilder.xml.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.SchematronContext;

/**
 * <p>A service for looking up defintions of components of a message.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - xml.service - translated manually
 */
public interface MessageDefinitionService {

	/**
	 * <p>Initialize the service. Pre-initializing the service during system
	 *  start-up can improve the performance of the first user call to do real work. 
	 */
	public void initialize();
	/**
	 * <p>Get a message part by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the message part
	 */
	public MessagePart getMessagePart(VersionNumber version, String type);
	/**
	 * <p>Get an interaction by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the interaction
	 */
	public Interaction getInteraction(VersionNumber version, String type);
	/**
	 * <p>Get all interactions across all versions.
	 * @param includeDuplicateInteractionsWithChangedBusinessNames 
	 * 	- a flag indicating whether or not to include duplicates
	 * @return the interactions
	 */
	public List<Interaction> getAllInteractions(boolean includeDuplicateInteractionsWithChangedBusinessNames);
	/**
	 * <p>Get all interactions for a particular version of the specification.
	 * @param version - the version
	 * @return the interactions
	 */
	public List<Interaction> getAllInteractions(VersionNumber version);
	/**
	 * <p>Get all the versions known by this service.
	 * @return the versions
	 */
	public Set<String> getSupportedVersions();
	/**
	 * <p>Get all the versions for a particular interaction.
	 * @param type - the type name of the interaction
	 * @return the versions
	 */
	public Set<String> getSupportedVersionsForInteraction(String type);
	/**
	 * <p>Get all the message parts for a particular interaction and version.
	 * @param interaction - the interaction
	 * @param version - the version
	 * @return - the message parts
	 */
	public Map<String, MessagePart> getAllMessageParts(Interaction interaction, VersionNumber version);
	/**
	 * <p>Get all the message parts that a particular root message part references.
	 * @param messagePart - the messagePart
	 * @param version - the version
	 * @return - the message parts
	 */			
	public Map<String, MessagePart> getAllRelatedMessageParts(MessagePart messagePart, VersionNumber version);
	/**
	 * <p>Get all the root message parts for all message sets.
	 * @return - the message parts
	 */	
	public List<MessagePart> getAllRootMessageParts();
	/**
	 * <p>Get all the root message parts for a specific message set.
	 * @param version
	 * @return - the message parts
	 */
	List<MessagePart> getAllRootMessageParts(VersionNumber version);
	
	public Collection<MessagePart> getAllMessageParts(VersionNumber version);
	
	/**
	 * Determine if the message set for the given version has been generated for R2 data types.
	 */
	public boolean isR2(VersionNumber version);

	/**
	 * Determine if the message set for the given version defines CDA documents
	 */
	public boolean isCda(VersionNumber version);

	/**
	 * Returns constraints for a given relationship. Null is returned if no constraints are found.
	 * 
	 * @param version
	 * @param constrainedType
	 * @return the constraints
	 */
	public ConstrainedDatatype getConstraints(VersionNumber version, String constrainedType);
	
	/**
	 * Returns all the schematron test definitions for a specific message set
	 * 
	 * @param version
	 * @return the schematron context definitions
	 */
	public List<SchematronContext> getAllSchematronContexts(VersionNumber version);

	/**
	 * Returns all the package locations for a specific message set
	 * 
	 * @param version
	 * @return the package locations
	 */
	public List<PackageLocation> getAllPackageLocations(VersionNumber version);
	
}