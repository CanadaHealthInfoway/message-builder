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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_drug.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;



/**
 * <p>PORX_MT020060CA.Patient: (no business name)</p>
 * 
 * <p>The patient identifier (PDID) to which this dispense was 
 * for must be specified in the &ldquo;id&rdquo; element in the 
 * message path &ldquo;/subject / deviceDispense /subject 
 * /patient1&rdquo;.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.Patient","PORX_MT020070CA.Patient"})
public interface Patient {

}
