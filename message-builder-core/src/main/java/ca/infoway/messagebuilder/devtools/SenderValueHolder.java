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

package ca.infoway.messagebuilder.devtools;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class SenderValueHolder {

    private TelecommunicationAddress telecom;
    private Identifier deviceId;
    private String deviceName;
    private String deviceDesc;
    private Interval<Date> deviceExistenceTime;
    private String deviceManufacturerModelName;
    private String deviceSoftwareName;
    private Identifier deviceAgentAgentOrganizationId;
    
	public TelecommunicationAddress getTelecom() {
		return telecom;
	}
	public void setTelecom(TelecommunicationAddress telecom) {
		this.telecom = telecom;
	}
	public Identifier getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Identifier deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceDesc() {
		return deviceDesc;
	}
	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}
	public Interval<Date> getDeviceExistenceTime() {
		return deviceExistenceTime;
	}
	public void setDeviceExistenceTime(Interval<Date> deviceExistenceTime) {
		this.deviceExistenceTime = deviceExistenceTime;
	}
	public String getDeviceManufacturerModelName() {
		return deviceManufacturerModelName;
	}
	public void setDeviceManufacturerModelName(String deviceManufacturerModelName) {
		this.deviceManufacturerModelName = deviceManufacturerModelName;
	}
	public String getDeviceSoftwareName() {
		return deviceSoftwareName;
	}
	public void setDeviceSoftwareName(String deviceSoftwareName) {
		this.deviceSoftwareName = deviceSoftwareName;
	}
	public Identifier getDeviceAgentAgentOrganizationId() {
		return deviceAgentAgentOrganizationId;
	}
	public void setDeviceAgentAgentOrganizationId(Identifier deviceAgentAgentOrganizationId) {
		this.deviceAgentAgentOrganizationId = deviceAgentAgentOrganizationId;
	}
    
}
