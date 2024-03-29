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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt141007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Device Package 
 * 
 * <p>Describes the container in which a device can be or 
 * should be provided to the patient. 
 * 
 * <p>Used for informing dispenser of the need and 
 * authorization to dispense device in a clinically approved 
 * container. Aids patients in adhering to usage instructions. 
 * May also influence the quantity prescribed. 
 * 
 * <p>The empty class is mandatory for HL7 alignment and 
 * modeling reasons. 
 */
@Hl7PartTypeMapping({"COCT_MT141007CA.PackagedDevice"})
public class DevicePackageBean extends MessagePartBean {


}
