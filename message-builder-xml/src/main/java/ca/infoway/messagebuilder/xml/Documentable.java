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

package ca.infoway.messagebuilder.xml;

/**
 * <p>An interface describing types that have documentation.  MIFs often contain 
 * additional documentation that describe the purpose or meaning of types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface Documentable {

	/**
	 * <p>Get the documentation.
	 * @return the documentation.
	 */
	public Documentation getDocumentation();
	/**
	 * <p>Set the documentation.
	 * @param documentation - the new documentation value
	 */
	public void setDocumentation(Documentation documentation);
	
}
