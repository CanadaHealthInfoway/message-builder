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
package ca.infoway.messagebuilder.model.common.porx_mt020070ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.merged.Component2_2Bean;
import ca.infoway.messagebuilder.model.merged.DispensedForBean;
import ca.infoway.messagebuilder.model.merged.PerformsBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



/**
 * <p>Prescription Dispense 
 * 
 * <p>This is the detailed information about a medication 
 * dispense that has been performed on behalf a patient. 
 * 
 * <p>Dispensing is an integral part of the overall medication 
 * process. 
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.MedicationDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private II localDispenseId = new IIImpl();
    private SET<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind> prescriptionMaskingIndicators = new SETImpl<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind>(CVImpl.class);
    private DispensedForBean subject;
    private DispensedBean inFulfillmentOf = new DispensedBean();
    private PerformsBean component1;
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private Component2_2Bean component3 = new Component2_2Bean();
    private NotesBean subjectOfAnnotation;

    @Hl7XmlMapping({"id"})
    public Identifier getLocalDispenseId() {
        return this.localDispenseId.getValue();
    }
    public void setLocalDispenseId(Identifier localDispenseId) {
        this.localDispenseId.setValue(localDispenseId);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet();
    }

    @Hl7XmlMapping({"subject"})
    public DispensedForBean getSubject() {
        return this.subject;
    }
    public void setSubject(DispensedForBean subject) {
        this.subject = subject;
    }

    @Hl7XmlMapping({"inFulfillmentOf"})
    public DispensedBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }
    public void setInFulfillmentOf(DispensedBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }

    @Hl7XmlMapping({"component1"})
    public PerformsBean getComponent1() {
        return this.component1;
    }
    public void setComponent1(PerformsBean component1) {
        this.component1 = component1;
    }

    @Hl7XmlMapping({"component2/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent2DosageInstruction() {
        return this.component2DosageInstruction;
    }

    @Hl7XmlMapping({"component3"})
    public Component2_2Bean getComponent3() {
        return this.component3;
    }
    public void setComponent3(Component2_2Bean component3) {
        this.component3 = component3;
    }

    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
