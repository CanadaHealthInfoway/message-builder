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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

/* This file was generated from HL7's HTML vocabulary documentation */
package ca.infoway.messagebuilder.domainvalue;

import ca.infoway.messagebuilder.Code;

/**
 * <p>Coded concepts representing Binding Realms (used for Context Binding of 
 * terminology in HL7 models) and/or Namespace Realms (used to help ensure 
 * unique identification of HL7 artifacts). This code system is partitioned 
 * into three sections: Affiliate realms, Binding realms and Namespace realms.  
 * All affiliate realm codes may automatically be used as both binding realms 
 * and namespace realms.  Furthermore, affiliate realms are the only realms 
 * that have authority over the creation of binding realms.  (Note that 
 * 'affiliate' includes the idea of both international affiliates and the HL7 
 * International organization.)  All other codes must be associated with an 
 * owning affiliate realm and must appear as a specialization of _BindingRealm 
 * or _NamespaceRealm.  For affiliates whose concepts align with nations, the 
 * country codes from ISO 3166-1 2-character alpha are used for the code when 
 * possible so these codes should not be used for other realm types.  It is 
 * recommended that binding realm and namespace codes submitted by affiliates 
 * use the realm code as a prefix to avoid possible collisions with ISO codes.  
 * However, tooling does not currently support namepace realm codes greater 
 * than 2 characters. 
 */
public interface Realm extends Code {
}
