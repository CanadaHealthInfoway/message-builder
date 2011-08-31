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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.repc_mt000006ca.AgentCategoryBean;



@Hl7PartTypeMapping({"REPC_MT000001CA.ExposureEvent","REPC_MT000002CA.ExposureEvent","REPC_MT000005CA.ExposureEvent","REPC_MT000006CA.ExposureEvent","REPC_MT000009CA.ExposureEvent","REPC_MT000012CA.ExposureEvent","REPC_MT000013CA.ExposureEvent"})
public class ExposuresBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II incidenceIdentifier = new IIImpl();
    private CV exposureMethod = new CVImpl();
    private CV exposedMaterialType = new CVImpl();
    private AgentCategoryBean consumableAdministrableMaterialAdministerableMaterialKind;


    /**
     * <p>IncidenceIdentifier</p>
     * 
     * <p>B:Incidence Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getIncidenceIdentifier() {
        return this.incidenceIdentifier.getValue();
    }
    public void setIncidenceIdentifier(Identifier incidenceIdentifier) {
        this.incidenceIdentifier.setValue(incidenceIdentifier);
    }


    /**
     * <p>ExposureMethod</p>
     * 
     * <p>C:Exposure Method</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getExposureMethod() {
        return (RouteOfAdministration) this.exposureMethod.getValue();
    }
    public void setExposureMethod(RouteOfAdministration exposureMethod) {
        this.exposureMethod.setValue(exposureMethod);
    }


    /**
     * <p>ExposedMaterialType</p>
     * 
     * <p>A:Exposed Material Type</p>
     */
    @Hl7XmlMapping({"consumable/administerableMaterial/administerableMaterialKind/code","consumable/administrableMaterial/administerableMaterialKind/code"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="consumable", type="REPC_MT000001CA.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000002CA.Consumable"),
        @Hl7MapByPartType(name="consumable", type="REPC_MT000005CA.Consumable"),
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
        @Hl7MapByPartType(name="consumable/administrableMaterial", type="REPC_MT000013CA.AdministrableMaterial"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000001CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000002CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000005CA.MaterialKind"),
        @Hl7MapByPartType(name="consumable/administrableMaterial/administerableMaterialKind", type="REPC_MT000013CA.MaterialKind")})
    public ExposureAgentEntityType getExposedMaterialType() {
        return (ExposureAgentEntityType) this.exposedMaterialType.getValue();
    }
    public void setExposedMaterialType(ExposureAgentEntityType exposedMaterialType) {
        this.exposedMaterialType.setValue(exposedMaterialType);
    }


    @Hl7XmlMapping({"consumable/administrableMaterial/administerableMaterialKind"})
    public AgentCategoryBean getConsumableAdministrableMaterialAdministerableMaterialKind() {
        return this.consumableAdministrableMaterialAdministerableMaterialKind;
    }
    public void setConsumableAdministrableMaterialAdministerableMaterialKind(AgentCategoryBean consumableAdministrableMaterialAdministerableMaterialKind) {
        this.consumableAdministrableMaterialAdministerableMaterialKind = consumableAdministrableMaterialAdministerableMaterialKind;
    }

}
