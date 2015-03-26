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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt080100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.EntityRisk;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.HumanLabSpecimenEntityType;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Specimen Material</p>
 * 
 * <p>The specimen material is of primary importance when 
 * communicating a lab result. The specimen Material may be 
 * inherent in the LOINC code describing the lab result.</p>
 * 
 * <p>This entity object is the specimen material itself.</p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.Material"})
public class SpecimenMaterialBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CD code = new CDImpl();
    private ST desc = new STImpl();
    private List<OtherSpecimenIdentificationsBean> asIdentifiedEntity = new ArrayList<OtherSpecimenIdentificationsBean>();
    private CV asContentContainerRiskCode = new CVImpl();


    /**
     * <p>Business Name: V:Specimen Code</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Material.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The specimen code differentiates testing types, methods, 
     * and resulting processing of specimen material.</p>
     * 
     * <p>The code of the specimen material collected e.g. skin, 
     * blood, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public HumanLabSpecimenEntityType getCode() {
        return (HumanLabSpecimenEntityType) this.code.getValue();
    }

    /**
     * <p>Business Name: V:Specimen Code</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Material.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The specimen code differentiates testing types, methods, 
     * and resulting processing of specimen material.</p>
     * 
     * <p>The code of the specimen material collected e.g. skin, 
     * blood, etc.</p>
     */
    public void setCode(HumanLabSpecimenEntityType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: W:Specimen Text</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Material.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when information is not able to be coded or 
     * represented using the available other attributes.</p>
     * 
     * <p>Any descriptive specimen information not sufficiently 
     * communicated by the code attribute.</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDesc() {
        return this.desc.getValue();
    }

    /**
     * <p>Business Name: W:Specimen Text</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Material.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when information is not able to be coded or 
     * represented using the available other attributes.</p>
     * 
     * <p>Any descriptive specimen information not sufficiently 
     * communicated by the code attribute.</p>
     */
    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }


    /**
     * <p>Relationship: COCT_MT080100CA.Material.asIdentifiedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"asIdentifiedEntity"})
    public List<OtherSpecimenIdentificationsBean> getAsIdentifiedEntity() {
        return this.asIdentifiedEntity;
    }


    /**
     * <p>Business Name: Y:Specimen Container Risk</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Container.riskCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to document container risks to those who handle the 
     * container.</p>
     * 
     * <p>Describes any risk to the handlers of this container 
     * (containing a specimen).</p>
     */
    @Hl7XmlMapping({"asContent/container/riskCode"})
    public EntityRisk getAsContentContainerRiskCode() {
        return (EntityRisk) this.asContentContainerRiskCode.getValue();
    }

    /**
     * <p>Business Name: Y:Specimen Container Risk</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Container.riskCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to document container risks to those who handle the 
     * container.</p>
     * 
     * <p>Describes any risk to the handlers of this container 
     * (containing a specimen).</p>
     */
    public void setAsContentContainerRiskCode(EntityRisk asContentContainerRiskCode) {
        this.asContentContainerRiskCode.setValue(asContentContainerRiskCode);
    }

}
