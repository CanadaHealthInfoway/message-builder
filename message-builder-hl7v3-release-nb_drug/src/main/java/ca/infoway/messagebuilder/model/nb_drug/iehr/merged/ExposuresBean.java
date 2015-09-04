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
package ca.infoway.messagebuilder.model.nb_drug.iehr.merged;

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
 * <p>REPC_MT000012NB.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000006NB.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000001NB.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000009NB.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000013NB.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000005NB.ExposureEvent: Exposures</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 * 
 * <p>REPC_MT000002NB.ExposureEvent: Exposures</p>
 * 
 * <p>routeCode is required if not using SNOMED</p>
 * 
 * <p>Communicates the cause of the adverse reaction.</p>
 * 
 * <p>Incidence of the patient's exposure to (or contact with) 
 * with some material that might have caused the adverse 
 * reaction.</p><p>Examples of exposures include: Administering 
 * a substance (drug, food, etc) to the patient, Patient coming 
 * into contact with an environmental material, etc.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000001NB.ExposureEvent","REPC_MT000002NB.ExposureEvent","REPC_MT000005NB.ExposureEvent","REPC_MT000006NB.ExposureEvent","REPC_MT000009NB.ExposureEvent","REPC_MT000012NB.ExposureEvent","REPC_MT000013NB.ExposureEvent"})
public class ExposuresBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private II id = new IIImpl();
    private CV routeCode = new CVImpl();
    private AgentCategoryBean consumableAdministrableMaterialAdministerableMaterialKind;


    /**
     * <p>Business Name: IncidenceIdentifier</p>
     * 
     * <p>Un-merged Business Name: IncidenceIdentifier</p>
     * 
     * <p>Relationship: REPC_MT000012NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000006NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000001NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000009NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000002NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000005NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000013NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000012NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000006NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000001NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000009NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000002NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000005NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000013NB.ExposureEvent.id</p>
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
     * <p>Relationship: REPC_MT000012NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000006NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000001NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000009NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000002NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000005NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000013NB.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Relationship: REPC_MT000012NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000006NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000001NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000009NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000002NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000005NB.ExposureEvent.routeCode</p>
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
     * <p>Relationship: REPC_MT000013NB.ExposureEvent.routeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * REPC_MT000012NB.AdministerableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009NB.AdministerableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000002NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000005NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/administerableMaterial/administerableMaterialKind","consumable/administrableMaterial/administerableMaterialKind"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="consumable", type="REPC_MT000001NB.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000002NB.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000005NB.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000006NB.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000009NB.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000012NB.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000013NB.Consumable"),
        @Hl7MapByPartType(name="consumable/administerableMaterial", type="REPC_MT000009NB.AdministerableMaterial"),
        @Hl7MapByPartType(name="consumable/administerableMaterial", type="REPC_MT000012NB.AdministerableMaterial"),
        @Hl7MapByPartType(name="consumable/administerableMaterial/administerableMaterialKind", type="REPC_MT000009NB.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administerableMaterial/administerableMaterialKind", type="REPC_MT000012NB.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000001NB.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000002NB.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000005NB.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000006NB.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000013NB.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000001NB.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000002NB.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000005NB.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000006NB.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000013NB.MaterialKind")})
    public AgentCategoryBean getConsumableAdministrableMaterialAdministerableMaterialKind() {
        return this.consumableAdministrableMaterialAdministerableMaterialKind;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000012NB.AdministerableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000006NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009NB.AdministerableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000002NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000005NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013NB.AdministrableMaterial.administerableMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableAdministrableMaterialAdministerableMaterialKind(AgentCategoryBean consumableAdministrableMaterialAdministerableMaterialKind) {
        this.consumableAdministrableMaterialAdministerableMaterialKind = consumableAdministrableMaterialAdministerableMaterialKind;
    }

}