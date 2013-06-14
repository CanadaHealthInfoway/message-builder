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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt090302on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Application</p>
 * 
 * <p>Allows an application to be uniquely identified.</p>
 * 
 * <p>An identification of a system/application that can 
 * initiate an event to change the status of an object.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090302ON.AssignedDevice"})
@Hl7RootType
public class ApplicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged.ChangedBy {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private ST assignedDeviceName = new STImpl();


    /**
     * <p>Business Name: C:Application Id</p>
     * 
     * <p>Relationship: COCT_MT090302ON.AssignedDevice.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.020-01 (extension)</p>
     * 
     * <p>PVD.020-02 (root)</p>
     * 
     * <p>Dispensing Pharmacy number</p>
     * 
     * <p>Pharmacy Identifier</p>
     * 
     * <p>Facility.facilityKey</p>
     * 
     * <p>DispensedItem.facilityKey</p>
     * 
     * <p>To uniquely identify an 
     * application/system.</p><p>Attribute is mandatory to allow 
     * for distinguishing different applications/systems.</p>
     * 
     * <p>Unique identifier of an application or a system.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: C:Application Id</p>
     * 
     * <p>Relationship: COCT_MT090302ON.AssignedDevice.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.020-01 (extension)</p>
     * 
     * <p>PVD.020-02 (root)</p>
     * 
     * <p>Dispensing Pharmacy number</p>
     * 
     * <p>Pharmacy Identifier</p>
     * 
     * <p>Facility.facilityKey</p>
     * 
     * <p>DispensedItem.facilityKey</p>
     * 
     * <p>To uniquely identify an 
     * application/system.</p><p>Attribute is mandatory to allow 
     * for distinguishing different applications/systems.</p>
     * 
     * <p>Unique identifier of an application or a system.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: B:Application Name</p>
     * 
     * <p>Relationship: COCT_MT090302ON.Device.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.070</p>
     * 
     * <p>Dispensing Pharmacy Name</p>
     * 
     * <p>Facility.name</p>
     * 
     * <p>Used for human communication. The name of the application 
     * must be known and is therefore marked as 'mandatory'.</p>
     * 
     * <p>The name assigned to the application/system.</p>
     */
    @Hl7XmlMapping({"assignedDevice/name"})
    public String getAssignedDeviceName() {
        return this.assignedDeviceName.getValue();
    }

    /**
     * <p>Business Name: B:Application Name</p>
     * 
     * <p>Relationship: COCT_MT090302ON.Device.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.070</p>
     * 
     * <p>Dispensing Pharmacy Name</p>
     * 
     * <p>Facility.name</p>
     * 
     * <p>Used for human communication. The name of the application 
     * must be known and is therefore marked as 'mandatory'.</p>
     * 
     * <p>The name assigned to the application/system.</p>
     */
    public void setAssignedDeviceName(String assignedDeviceName) {
        this.assignedDeviceName.setValue(assignedDeviceName);
    }

}
