/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml;

/**
 * <p>A tool that can locate message parts.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface MessagePartResolver {
	/**
	 * <p>Find a message part by name.
	 * 
	 * @param type - the name of message type to retrieve.
	 * @return - the message part
	 */
	public MessagePart getMessagePart(String type);	
	/**
	 * <p>Find the root type of a package location.
	 * @param packageLocationName - the name of the package location.
	 * @return - the root type of the package location.
	 */
	public String getPackageLocationRootType(String packageLocationName);
}
