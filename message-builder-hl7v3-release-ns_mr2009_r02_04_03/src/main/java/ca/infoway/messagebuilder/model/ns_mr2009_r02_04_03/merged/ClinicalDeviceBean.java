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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.domainvalue.MedicalDeviceType;



@Hl7PartTypeMapping({"FICR_MT400001CA.ClinicalDevice","FICR_MT400003CA.ClinicalDevice","FICR_MT400004CA.ClinicalDevice","FICR_MT490101CA.ClinicalDevice","FICR_MT490102CA.ClinicalDevice"})
public class ClinicalDeviceBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private CV code = new CVImpl();
    private ST name = new STImpl();
    private ST desc = new STImpl();


    /**
     * <p>Business Name: DeviceCode</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT490101CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT400001CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT490102CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT400004CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT400003CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public MedicalDeviceType getCode() {
        return (MedicalDeviceType) this.code.getValue();
    }

    /**
     * <p>Business Name: DeviceCode</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT490101CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT400001CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT490102CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT400004CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceCode</p>
     * 
     * <p>Relationship: FICR_MT400003CA.ClinicalDevice.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCode(MedicalDeviceType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: DeviceName</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT490101CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT400001CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT490102CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT400004CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT400003CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: DeviceName</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT490101CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT400001CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT490102CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT400004CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DeviceName</p>
     * 
     * <p>Relationship: FICR_MT400003CA.ClinicalDevice.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: DeviceDescription</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT490101CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT400001CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT490102CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT400004CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT400003CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDesc() {
        return this.desc.getValue();
    }

    /**
     * <p>Business Name: DeviceDescription</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT490101CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT400001CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT490102CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT400004CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DeviceDescription</p>
     * 
     * <p>Relationship: FICR_MT400003CA.ClinicalDevice.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }

}