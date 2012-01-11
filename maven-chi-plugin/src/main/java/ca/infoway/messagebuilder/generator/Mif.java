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

package ca.infoway.messagebuilder.generator;

import org.w3c.dom.Document;

/**
 * <p>Model Interchange Format file contents.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
interface Mif {
	/**
	 * <p>Return the MIF file as a parsed DOM document. </p>
	 * @return
	 */
	public Document asDocument();
	/**
	 * <p>Return the MIF name in the form AAAA_MTBBBBBBCA.</p>
	 * 
	 * <p>Example names might include PRPA_MT101101CA or MCAI_MT700212CA.
	 * @return - the package location
	 */
	public String getPackageLocation();
	/**
	 * <p>Return the MIF name in the Camel-case form.</p>
	 * 
	 * <p>Example names might include "OrderID" or "ActingPersonIdentified-confirmable".</p>
	 * @return - the MIF name
	 */
	public String getName();
	/**
	 * <p>The category that has been assigned to the MIF during the MIF to XML process.</p>
	 * 
	 * <p>Typical categories might be 'cr' or 'iehr'.
	 * 
	 * @return - the category
	 */
	public String getCategory();
}
