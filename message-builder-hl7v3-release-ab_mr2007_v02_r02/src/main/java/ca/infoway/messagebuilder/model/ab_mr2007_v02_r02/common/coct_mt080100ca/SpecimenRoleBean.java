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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt080100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.EntityRisk;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.domainvalue.SpecimenTypeCode;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Specimen Role</p>
 * 
 * <p>The specimen role represents the information regarding a 
 * material collected from a patient to serve as a specimen for 
 * testing.</p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.Specimen"})
@Hl7RootType
public class SpecimenRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CS classCode = new CSImpl();
    private II id = new IIImpl();
    private CV specimenMaterialCode = new CVImpl();
    private ST specimenMaterialDesc = new STImpl();
    private List<OtherSpecimenIdentificationsBean> specimenMaterialAsIdentifiedEntity = new ArrayList<OtherSpecimenIdentificationsBean>();
    private CV specimenMaterialAsContentContainerRiskCode = new CVImpl();
    private List<SpecimenProcessStepsBean> subjectOf1TransportationEvent = new ArrayList<SpecimenProcessStepsBean>();
    private List<SpecimenObservationBean> subjectOf2SpecimenObservationEvent = new ArrayList<SpecimenObservationBean>();
    private SpecimenCollectionProcedureBean productOfSpecimenCollectionProcedureEvent;


    /**
     * <p>Relationship: COCT_MT080100CA.Specimen.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }

    /**
     * <p>Relationship: COCT_MT080100CA.Specimen.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Business Name: A:Specimen Identifier</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Specimen.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A unique identifier for the specimen. Frequently the 
     * accession number which often uniquely identifies the 
     * specimen is used as the unique specimen identifier in 
     * communications. However, accessioning may group multiple 
     * specimens (identified) under one accession number. 
     * Therefore, it is recommended that this be truly the specimen 
     * identifier and not the accession number.</p><p>For a 
     * referral, this attribute should be Required so it is 
     * reflected back in the result. If Lab A has collected and or 
     * done something to the specimen, then the identifier would be 
     * sent.</p>
     * 
     * <p>A unique identifier for the specimen. Frequently the 
     * accession number which often uniquely identifies the 
     * specimen is used as the unique specimen identifier in 
     * communications. However, accessioning may group multiple 
     * specimens (identified) under one accession number. 
     * Therefore, it is recommended that this be truly the specimen 
     * identifier and not the accession number.</p><p>For a 
     * referral, this attribute should be Required so it is 
     * reflected back in the result. If Lab A has collected and or 
     * done something to the specimen, then the identifier would be 
     * sent.</p>
     * 
     * <p>A unique specimen identifier is necessary for specimen 
     * tracking and management.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Specimen Identifier</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Specimen.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A unique identifier for the specimen. Frequently the 
     * accession number which often uniquely identifies the 
     * specimen is used as the unique specimen identifier in 
     * communications. However, accessioning may group multiple 
     * specimens (identified) under one accession number. 
     * Therefore, it is recommended that this be truly the specimen 
     * identifier and not the accession number.</p><p>For a 
     * referral, this attribute should be Required so it is 
     * reflected back in the result. If Lab A has collected and or 
     * done something to the specimen, then the identifier would be 
     * sent.</p>
     * 
     * <p>A unique identifier for the specimen. Frequently the 
     * accession number which often uniquely identifies the 
     * specimen is used as the unique specimen identifier in 
     * communications. However, accessioning may group multiple 
     * specimens (identified) under one accession number. 
     * Therefore, it is recommended that this be truly the specimen 
     * identifier and not the accession number.</p><p>For a 
     * referral, this attribute should be Required so it is 
     * reflected back in the result. If Lab A has collected and or 
     * done something to the specimen, then the identifier would be 
     * sent.</p>
     * 
     * <p>A unique specimen identifier is necessary for specimen 
     * tracking and management.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: V:Specimen Code</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Material.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The code of the specimen material collected e.g. skin, 
     * blood, etc.</p>
     * 
     * <p>The specimen code differentiates testing types, methods, 
     * and resulting processing of specimen material.</p>
     */
    @Hl7XmlMapping({"specimenMaterial/code"})
    public SpecimenTypeCode getSpecimenMaterialCode() {
        return (SpecimenTypeCode) this.specimenMaterialCode.getValue();
    }

    /**
     * <p>Business Name: V:Specimen Code</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Material.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The code of the specimen material collected e.g. skin, 
     * blood, etc.</p>
     * 
     * <p>The specimen code differentiates testing types, methods, 
     * and resulting processing of specimen material.</p>
     */
    public void setSpecimenMaterialCode(SpecimenTypeCode specimenMaterialCode) {
        this.specimenMaterialCode.setValue(specimenMaterialCode);
    }


    /**
     * <p>Business Name: W:Specimen Text</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Material.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Any descriptive specimen information not sufficiently 
     * communicated by the code attribute.</p>
     * 
     * <p>Used when information is not able to be coded or 
     * represented using the available other attributes.</p>
     */
    @Hl7XmlMapping({"specimenMaterial/desc"})
    public String getSpecimenMaterialDesc() {
        return this.specimenMaterialDesc.getValue();
    }

    /**
     * <p>Business Name: W:Specimen Text</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Material.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Any descriptive specimen information not sufficiently 
     * communicated by the code attribute.</p>
     * 
     * <p>Used when information is not able to be coded or 
     * represented using the available other attributes.</p>
     */
    public void setSpecimenMaterialDesc(String specimenMaterialDesc) {
        this.specimenMaterialDesc.setValue(specimenMaterialDesc);
    }


    /**
     * <p>Relationship: COCT_MT080100CA.Material.asIdentifiedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"specimenMaterial/asIdentifiedEntity"})
    public List<OtherSpecimenIdentificationsBean> getSpecimenMaterialAsIdentifiedEntity() {
        return this.specimenMaterialAsIdentifiedEntity;
    }


    /**
     * <p>Business Name: Y:Specimen Container Risk</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Container.riskCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Describes any risk to the handlers of this container 
     * (containing a specimen).</p>
     * 
     * <p>Used to document container risks to those who handle the 
     * container.</p>
     */
    @Hl7XmlMapping({"specimenMaterial/asContent/container/riskCode"})
    public EntityRisk getSpecimenMaterialAsContentContainerRiskCode() {
        return (EntityRisk) this.specimenMaterialAsContentContainerRiskCode.getValue();
    }

    /**
     * <p>Business Name: Y:Specimen Container Risk</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Container.riskCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Describes any risk to the handlers of this container 
     * (containing a specimen).</p>
     * 
     * <p>Used to document container risks to those who handle the 
     * container.</p>
     */
    public void setSpecimenMaterialAsContentContainerRiskCode(EntityRisk specimenMaterialAsContentContainerRiskCode) {
        this.specimenMaterialAsContentContainerRiskCode.setValue(specimenMaterialAsContentContainerRiskCode);
    }


    /**
     * <p>Relationship: 
     * COCT_MT080100CA.Subject3.transportationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/transportationEvent"})
    public List<SpecimenProcessStepsBean> getSubjectOf1TransportationEvent() {
        return this.subjectOf1TransportationEvent;
    }


    /**
     * <p>Relationship: 
     * COCT_MT080100CA.Subject4.specimenObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/specimenObservationEvent"})
    public List<SpecimenObservationBean> getSubjectOf2SpecimenObservationEvent() {
        return this.subjectOf2SpecimenObservationEvent;
    }


    /**
     * <p>Relationship: 
     * COCT_MT080100CA.Product.specimenCollectionProcedureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"productOf/specimenCollectionProcedureEvent"})
    public SpecimenCollectionProcedureBean getProductOfSpecimenCollectionProcedureEvent() {
        return this.productOfSpecimenCollectionProcedureEvent;
    }

    /**
     * <p>Relationship: 
     * COCT_MT080100CA.Product.specimenCollectionProcedureEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setProductOfSpecimenCollectionProcedureEvent(SpecimenCollectionProcedureBean productOfSpecimenCollectionProcedureEvent) {
        this.productOfSpecimenCollectionProcedureEvent = productOfSpecimenCollectionProcedureEvent;
    }

}
