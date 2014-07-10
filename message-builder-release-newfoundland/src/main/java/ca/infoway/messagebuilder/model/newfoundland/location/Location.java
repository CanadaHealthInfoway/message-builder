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

package ca.infoway.messagebuilder.model.newfoundland.location;

import java.util.List;

import ca.infoway.messagebuilder.datatype.lang.Identifiable;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;

public interface Location extends Identifiable {
	
	public void setId(Identifier id);
	public ServiceDeliveryLocationRoleType getCode();
	public void setCode(ServiceDeliveryLocationRoleType code);
	public List<String> getName();
	public PostalAddress getAddr();
	public void setAddr(PostalAddress addr);
	public ServiceDeliveryRoleStatus getStatusCode();
	public void setStatusCode(ServiceDeliveryRoleStatus statusCode);
	public ServiceDeliveryLocationPlaceType getPlaceCode();
	public void setPlaceCode(ServiceDeliveryLocationPlaceType placeCode);
	public Boolean getMobileInd();
	public void setMobileInd(Boolean mobileInd);
	
}
