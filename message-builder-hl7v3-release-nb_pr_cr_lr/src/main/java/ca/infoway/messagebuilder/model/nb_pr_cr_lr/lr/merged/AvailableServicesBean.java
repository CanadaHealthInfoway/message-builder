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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.domainvalue.ActServiceDeliveryLocationService;
import ca.infoway.messagebuilder.domainvalue.x_ActStatusActiveSuspended;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>Business Name: AvailableServices</p>
 * 
 * <p>PRLO_MT202014CA.ServiceDefinition: Available Services</p>
 * 
 * <p>Useful when searching for a location to provide a 
 * particular service. May be used to filter query 
 * responses.</p>
 * 
 * <p>A list of available services provided by the service 
 * delivery location.</p>
 * 
 * <p>PRLO_MT000002CA.ServiceDefinition: Available Services</p>
 * 
 * <p>Useful when searching for a location to provide a 
 * particular service. May be used to filter query 
 * responses.</p>
 * 
 * <p>A list of available services provided by the service 
 * delivery location.</p>
 * 
 * <p>PRLO_MT202015CA.ServiceDefinition: Available Services</p>
 * 
 * <p>Useful when searching for a location to provide a 
 * particular service. May be used to filter query 
 * responses.</p>
 * 
 * <p>A list of available services provided by the service 
 * delivery location.</p>
 */
@Hl7PartTypeMapping({"PRLO_MT000002CA.ServiceDefinition","PRLO_MT202014CA.ServiceDefinition","PRLO_MT202015CA.ServiceDefinition"})
public class AvailableServicesBean extends MessagePartBean {

    private static final long serialVersionUID = 20151013L;
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private SET<PIVL, PeriodicIntervalTime> activityTime = new SETImpl<PIVL, PeriodicIntervalTime>(PIVLImpl.class);


    /**
     * <p>Business Name: ServiceType</p>
     * 
     * <p>Un-merged Business Name: ServiceType</p>
     * 
     * <p>Relationship: PRLO_MT202014CA.ServiceDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the attribute that defines what the service is 
     * and is therefore mandatory.</p>
     * 
     * <p>Describes the kind of health-related service being 
     * offered.</p>
     * 
     * <p>Un-merged Business Name: ServiceType</p>
     * 
     * <p>Relationship: PRLO_MT000002CA.ServiceDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the attribute that defines what the service is 
     * and is therefore mandatory.</p>
     * 
     * <p>Describes the kind of health-related service being 
     * offered.</p>
     * 
     * <p>Un-merged Business Name: ServiceType</p>
     * 
     * <p>Relationship: PRLO_MT202015CA.ServiceDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the attribute that defines what the service is 
     * and is therefore mandatory.</p>
     * 
     * <p>Describes the kind of health-related service being 
     * offered.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActServiceDeliveryLocationService getCode() {
        return (ActServiceDeliveryLocationService) this.code.getValue();
    }

    /**
     * <p>Business Name: ServiceType</p>
     * 
     * <p>Un-merged Business Name: ServiceType</p>
     * 
     * <p>Relationship: PRLO_MT202014CA.ServiceDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the attribute that defines what the service is 
     * and is therefore mandatory.</p>
     * 
     * <p>Describes the kind of health-related service being 
     * offered.</p>
     * 
     * <p>Un-merged Business Name: ServiceType</p>
     * 
     * <p>Relationship: PRLO_MT000002CA.ServiceDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the attribute that defines what the service is 
     * and is therefore mandatory.</p>
     * 
     * <p>Describes the kind of health-related service being 
     * offered.</p>
     * 
     * <p>Un-merged Business Name: ServiceType</p>
     * 
     * <p>Relationship: PRLO_MT202015CA.ServiceDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the attribute that defines what the service is 
     * and is therefore mandatory.</p>
     * 
     * <p>Describes the kind of health-related service being 
     * offered.</p>
     */
    public void setCode(ActServiceDeliveryLocationService code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ServiceAvailability</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailability</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202014CA.ServiceDefinition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Services may not be always available; it is important to 
     * know whether a service is currently available when making 
     * decisions about where to send a patient.</p><p>Because not 
     * all jurisdictions will support capturing availability time, 
     * this element is being made optional.</p>
     * 
     * <p>Indicates the availability of the health-related service 
     * within the location (as known by the registry/repository). 
     * e.g. active (currently offered), suspended (may have been 
     * offered in the past and may again be offered in the future, 
     * but not available right now).</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailability</p>
     * 
     * <p>Relationship: 
     * PRLO_MT000002CA.ServiceDefinition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Services may not be always available; it is important to 
     * know whether a service is currently available when making 
     * decisions about where to send a patient.</p><p>Because not 
     * all jurisdictions will support capturing availability time, 
     * this element is being made optional.</p>
     * 
     * <p>Indicates the availability of the health-related service 
     * within the location (as known by the registry/repository). 
     * e.g. active (currently offered), suspended (may have been 
     * offered in the past and may again be offered in the future, 
     * but not available right now).</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailability</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202015CA.ServiceDefinition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Services may not be always available; it is important to 
     * know whether a service is currently available when making 
     * decisions about where to send a patient.</p><p>Because not 
     * all jurisdictions will support capturing availability time, 
     * this element is being made optional.</p>
     * 
     * <p>Indicates the availability of the health-related service 
     * within the location (as known by the registry/repository). 
     * e.g. active (currently offered), suspended (may have been 
     * offered in the past and may again be offered in the future, 
     * but not available right now).</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public x_ActStatusActiveSuspended getStatusCode() {
        return (x_ActStatusActiveSuspended) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: ServiceAvailability</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailability</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202014CA.ServiceDefinition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Services may not be always available; it is important to 
     * know whether a service is currently available when making 
     * decisions about where to send a patient.</p><p>Because not 
     * all jurisdictions will support capturing availability time, 
     * this element is being made optional.</p>
     * 
     * <p>Indicates the availability of the health-related service 
     * within the location (as known by the registry/repository). 
     * e.g. active (currently offered), suspended (may have been 
     * offered in the past and may again be offered in the future, 
     * but not available right now).</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailability</p>
     * 
     * <p>Relationship: 
     * PRLO_MT000002CA.ServiceDefinition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Services may not be always available; it is important to 
     * know whether a service is currently available when making 
     * decisions about where to send a patient.</p><p>Because not 
     * all jurisdictions will support capturing availability time, 
     * this element is being made optional.</p>
     * 
     * <p>Indicates the availability of the health-related service 
     * within the location (as known by the registry/repository). 
     * e.g. active (currently offered), suspended (may have been 
     * offered in the past and may again be offered in the future, 
     * but not available right now).</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailability</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202015CA.ServiceDefinition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Services may not be always available; it is important to 
     * know whether a service is currently available when making 
     * decisions about where to send a patient.</p><p>Because not 
     * all jurisdictions will support capturing availability time, 
     * this element is being made optional.</p>
     * 
     * <p>Indicates the availability of the health-related service 
     * within the location (as known by the registry/repository). 
     * e.g. active (currently offered), suspended (may have been 
     * offered in the past and may again be offered in the future, 
     * but not available right now).</p>
     */
    public void setStatusCode(x_ActStatusActiveSuspended statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: ServiceAvailabilityTime</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailabilityTime</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202014CA.ServiceDefinition.activityTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>We'd like this to be String, but need a datatype change 
     * to make that possible.</p>
     * 
     * <p>Allows for a greater level of detail on service 
     * availability, i.e. hours of operation of a specific service 
     * at this location.</p>
     * 
     * <p>Specifies the time that a specific service is generally 
     * available. E.g. 8am to 7pm, Monday through Friday.</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailabilityTime</p>
     * 
     * <p>Relationship: 
     * PRLO_MT000002CA.ServiceDefinition.activityTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>We'd like this to be String, but need a datatype change 
     * to make that possible.</p>
     * 
     * <p>Allows for a greater level of detail on service 
     * availability, i.e. hours of operation of a specific service 
     * at this location.</p>
     * 
     * <p>Specifies the time that a specific service is generally 
     * available. E.g. 8am to 7pm, Monday through Friday.</p>
     * 
     * <p>Un-merged Business Name: ServiceAvailabilityTime</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202015CA.ServiceDefinition.activityTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>We'd like this to be String, but need a datatype change 
     * to make that possible.</p>
     * 
     * <p>Allows for a greater level of detail on service 
     * availability, i.e. hours of operation of a specific service 
     * at this location.</p>
     * 
     * <p>Specifies the time that a specific service is generally 
     * available. E.g. 8am to 7pm, Monday through Friday.</p>
     */
    @Hl7XmlMapping({"activityTime"})
    public Set<PeriodicIntervalTime> getActivityTime() {
        return this.activityTime.rawSet();
    }

}
