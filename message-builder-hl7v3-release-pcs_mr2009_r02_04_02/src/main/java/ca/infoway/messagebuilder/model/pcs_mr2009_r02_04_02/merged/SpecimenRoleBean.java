/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.EntityRisk;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt080100ca.SpecimenCollectionProcedureBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt080100ca.SpecimenProcessStepsBean;

import java.util.ArrayList;
import java.util.List;



/**
 * <p>SpecimenRole</p>
 * 
 * <p>COCT_MT080100CA.Specimen: Specimen Role</p>
 * 
 * <p><p>The specimen role represents the information regarding 
 * a material collected from a patient to serve as a specimen 
 * for testing.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.Specimen","REPC_MT500001CA.Specimen","REPC_MT500002CA.Specimen","REPC_MT500003CA.Specimen","REPC_MT500004CA.Specimen"})
@Hl7RootType
public class SpecimenRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ST specimenMaterialDesc = new STImpl();
    private II specimenIdentifier = new IIImpl();
    private CD specimenCode = new CDImpl();
    private List<OtherSpecimenIdentificationsBean> specimenMaterialAsIdentifiedEntity = new ArrayList<OtherSpecimenIdentificationsBean>();
    private CV specimenContainerRisk = new CVImpl();
    private List<SpecimenProcessStepsBean> subjectOfTransportationEvent = new ArrayList<SpecimenProcessStepsBean>();
    private SpecimenCollectionProcedureBean productOfSpecimenCollectionProcedureEvent;


    /**
     * <p>I: Focus Area</p>
     * 
     * <p><p>Describes the specific body region or area associated 
     * with a Localized Health Condition-based 
     * Collection.</p><p>E.g. &quot;Left-most mole approximately 
     * one inch below left shoulder-blade&quot;</p></p>
     * 
     * <p><p>Describes the specific body region or area associated 
     * with a Localized Health Condition-based 
     * Collection.</p><p>E.g. &quot;Left-most mole approximately 
     * one inch below left shoulder-blade&quot;</p></p>
     * 
     * <p><p>Allows grouping observations, procedures and other 
     * records directly associated with a particular mole, tumor or 
     * other potion of a patient not easily referenced as a coded 
     * body site.</p><p>This element is optional because not all 
     * systems will support Localized Health Condition-based 
     * Collections</p></p>
     * 
     * <p><p>Allows grouping observations, procedures and other 
     * records directly associated with a particular mole, tumor or 
     * other potion of a patient not easily referenced as a coded 
     * body site.</p><p>This element is optional because not all 
     * systems will support Localized Health Condition-based 
     * Collections</p></p>
     * 
     * <p>W:Specimen Text</p>
     * 
     * <p><p>Any descriptive specimen information not sufficiently 
     * communicated by the code attribute.</p></p>
     * 
     * <p><p>Used when information is not able to be coded or 
     * represented using the available other attributes.</p></p>
     */
    @Hl7XmlMapping({"specimenMaterial/desc"})
    public String getSpecimenMaterialDesc() {
        return this.specimenMaterialDesc.getValue();
    }
    public void setSpecimenMaterialDesc(String specimenMaterialDesc) {
        this.specimenMaterialDesc.setValue(specimenMaterialDesc);
    }


    /**
     * <p>SpecimenIdentifier</p>
     * 
     * <p>A:Specimen Identifier</p>
     * 
     * <p><p>A unique identifier for the specimen. Frequently the 
     * accession number which often uniquely identifies the 
     * specimen is used as the unique specimen identifier in 
     * communications. However, accessioning may group multiple 
     * specimens (identified) under one accession number. 
     * Therefore, it is recommended that this be truly the specimen 
     * identifier and not the accession number.</p><p>For a 
     * referral, this attribute should be Required so it is 
     * reflected back in the result. If Lab A has collected and or 
     * done something to the specimen, then the identifier would be 
     * sent.</p></p>
     * 
     * <p><p>A unique identifier for the specimen. Frequently the 
     * accession number which often uniquely identifies the 
     * specimen is used as the unique specimen identifier in 
     * communications. However, accessioning may group multiple 
     * specimens (identified) under one accession number. 
     * Therefore, it is recommended that this be truly the specimen 
     * identifier and not the accession number.</p><p>For a 
     * referral, this attribute should be Required so it is 
     * reflected back in the result. If Lab A has collected and or 
     * done something to the specimen, then the identifier would be 
     * sent.</p></p>
     * 
     * <p><p>A unique specimen identifier is necessary for specimen 
     * tracking and management.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getSpecimenIdentifier() {
        return this.specimenIdentifier.getValue();
    }
    public void setSpecimenIdentifier(Identifier specimenIdentifier) {
        this.specimenIdentifier.setValue(specimenIdentifier);
    }


    /**
     * <p>SpecimenCode</p>
     * 
     * <p>V:Specimen Code</p>
     * 
     * <p><p>The code of the specimen material collected e.g. skin, 
     * blood, etc.</p></p>
     * 
     * <p><p>The specimen code differentiates testing types, 
     * methods, and resulting processing of specimen material.</p></p>
     */
    @Hl7XmlMapping({"specimenMaterial/code"})
    public Code getSpecimenCode() {
        return (Code) this.specimenCode.getValue();
    }
    public void setSpecimenCode(Code specimenCode) {
        this.specimenCode.setValue(specimenCode);
    }


    @Hl7XmlMapping({"specimenMaterial/asIdentifiedEntity"})
    public List<OtherSpecimenIdentificationsBean> getSpecimenMaterialAsIdentifiedEntity() {
        return this.specimenMaterialAsIdentifiedEntity;
    }


    /**
     * <p>SpecimenContainerRisk</p>
     * 
     * <p>Y:Specimen Container Risk</p>
     * 
     * <p><p>Describes any risk to the handlers of this container 
     * (containing a specimen).</p></p>
     * 
     * <p><p>Used to document container risks to those who handle 
     * the container.</p></p>
     */
    @Hl7XmlMapping({"specimenMaterial/asContent/container/riskCode"})
    public EntityRisk getSpecimenContainerRisk() {
        return (EntityRisk) this.specimenContainerRisk.getValue();
    }
    public void setSpecimenContainerRisk(EntityRisk specimenContainerRisk) {
        this.specimenContainerRisk.setValue(specimenContainerRisk);
    }


    @Hl7XmlMapping({"subjectOf/transportationEvent"})
    public List<SpecimenProcessStepsBean> getSubjectOfTransportationEvent() {
        return this.subjectOfTransportationEvent;
    }


    @Hl7XmlMapping({"productOf/specimenCollectionProcedureEvent"})
    public SpecimenCollectionProcedureBean getProductOfSpecimenCollectionProcedureEvent() {
        return this.productOfSpecimenCollectionProcedureEvent;
    }
    public void setProductOfSpecimenCollectionProcedureEvent(SpecimenCollectionProcedureBean productOfSpecimenCollectionProcedureEvent) {
        this.productOfSpecimenCollectionProcedureEvent = productOfSpecimenCollectionProcedureEvent;
    }

}
