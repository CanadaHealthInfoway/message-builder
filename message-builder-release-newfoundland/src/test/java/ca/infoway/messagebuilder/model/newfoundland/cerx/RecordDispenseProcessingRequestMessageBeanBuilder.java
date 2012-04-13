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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.payload.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.RecordDispenseProcessingRequestMessageBean;

public class RecordDispenseProcessingRequestMessageBeanBuilder extends BaseBeanBuilder<RecordDispenseProcessingRequestMessageBean> {

	public RecordDispenseProcessingRequestMessageBeanBuilder() {
		super(new RecordDispenseProcessingRequestMessageBean());
	}

	public RecordDispenseProcessingRequestMessageBeanBuilder populate() {
		this.bean.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_DISPENSE_PROCESSING_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(this.bean.getMessageAttributes());
		this.bean.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(this.bean.getControlActEvent());
		
		DispenseRequest1Bean medicationDispenseRequestBean = new DispenseRequest1Bean();
		RecordBean<DispenseRequest1Bean> recordBean = new RecordBean<DispenseRequest1Bean>();
		recordBean.setRecord(medicationDispenseRequestBean);
		this.bean.getControlActEvent().setRecordBean(recordBean);
		
		medicationDispenseRequestBean.getConfidentialityCode().add(Confidentiality.NORMAL);
		medicationDispenseRequestBean.getDosageInstructions().add(new DosageInstructionBeanBuilder().populate().withText("do this").create());
		medicationDispenseRequestBean.getDosageInstructions().add(new DosageInstructionBeanBuilder().populate().withText("then do that").create());
		medicationDispenseRequestBean.setIdAssignedByPharmacy(new Identifier("2.16.124.113618.1.1227543788373.2148.1233933814438.2148", "16373838"));
		medicationDispenseRequestBean.setNote(new NoteBeanBuilder().populate().create());
		medicationDispenseRequestBean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		medicationDispenseRequestBean.setSubstanceAdministrationRequest(new SubstanceAdministrationRequestBeanBuilder().populate().create());
		medicationDispenseRequestBean.setSubstitutionMade(new SubstitutionMadeBeanBuilder().populate().create());
		medicationDispenseRequestBean.setSupplyEvent(new SupplyEventBeanBuilder().populateMedication().create());
		return this;
	}
	
	public RecordDispenseProcessingRequestMessageBeanBuilder withPrescriptionIdentifier(Identifier prescriptionIdentifier) {
		this.bean.getRecord().getSubstanceAdministrationRequest().getId().add(prescriptionIdentifier);
		return this;
	}

	public RecordDispenseProcessingRequestMessageBeanBuilder withSubstitution(SubstitutionMadeBean substitutionMadeBean) {
		this.bean.getRecord().setSubstitutionMade(substitutionMadeBean);
		return this;
	}

	public RecordDispenseProcessingRequestMessageBeanBuilder withTxNumber(Identifier txNumber) {
		this.bean.getRecord().setIdAssignedByPharmacy(txNumber);
		return this;
	}

}
