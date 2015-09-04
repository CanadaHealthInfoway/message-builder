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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Exposures</p>
 * 
 * <p>REPC_MT000005CA.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000006CA.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000001CA.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000012CA.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000009CA.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000013CA.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000002CA.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.ExposureEvent","REPC_MT000002CA.ExposureEvent","REPC_MT000005CA.ExposureEvent","REPC_MT000006CA.ExposureEvent","REPC_MT000009CA.ExposureEvent","REPC_MT000012CA.ExposureEvent","REPC_MT000013CA.ExposureEvent"})
public class ExposuresBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private CV routeCode = new CVImpl();
    private AgentCategoryBean consumableAdministrableMaterialAdministerableMaterialKind;


    /**
     * <p>Business Name: IncidenceIdentifier</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000005CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000006CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000001CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the record or order that caused the 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000012CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000013CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000002CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: IncidenceIdentifier</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000005CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000006CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000001CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the record or order that caused the 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000012CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000013CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000002CA.ExposureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for drilling down to retrieve further information 
     * about the exposure</p>
     * 
     * <p>Identifier of the exposure event that caused the adverse 
     * reaction. This could be an identifier for a prescription, 
     * immunization, or other active medication record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ExposureMethod</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000005CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000006CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000001CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000012CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000013CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000002CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>routeCode is required if not using SNOMED</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>Business Name: ExposureMethod</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000005CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000006CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000001CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000012CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000013CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     * 
     * <p>Un-merged Business Name: ExposureMethod</p>
     * 
     * <p>Relationship: REPC_MT000002CA.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>routeCode is required if not using SNOMED</p>
     * 
     * <p>Helps evaluate the cause of the reaction.</p>
     * 
     * <p>The method by which the patient was exposed to the 
     * substance.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000005CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.AdministerableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.AdministerableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000002CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/administerableMaterial/administerableMaterialKind","consumable/administrableMaterial/administerableMaterialKind"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="consumable", type="REPC_MT000001CA.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000002CA.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000005CA.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000006CA.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000009CA.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000012CA.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000013CA.Consumable"),
        @Hl7MapByPartType(name="consumable/administerableMaterial", type="REPC_MT000009CA.AdministerableMaterial"),
        @Hl7MapByPartType(name="consumable/administerableMaterial", type="REPC_MT000012CA.AdministerableMaterial"),
        @Hl7MapByPartType(name="consumable/administerableMaterial/administerableMaterialKind", type="REPC_MT000009CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administerableMaterial/administerableMaterialKind", type="REPC_MT000012CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000001CA.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000002CA.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000005CA.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000006CA.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000013CA.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000001CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000002CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000005CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000006CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000013CA.MaterialKind")})
    public AgentCategoryBean getConsumableAdministrableMaterialAdministerableMaterialKind() {
        return this.consumableAdministrableMaterialAdministerableMaterialKind;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000005CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.AdministerableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012CA.AdministerableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000002CA.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableAdministrableMaterialAdministerableMaterialKind(AgentCategoryBean consumableAdministrableMaterialAdministerableMaterialKind) {
        this.consumableAdministrableMaterialAdministerableMaterialKind = consumableAdministrableMaterialAdministerableMaterialKind;
    }

}
