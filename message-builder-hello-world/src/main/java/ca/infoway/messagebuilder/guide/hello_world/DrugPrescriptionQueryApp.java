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
package ca.infoway.messagebuilder.guide.hello_world;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.payload.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.RefersTo_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.MedicationPrescriptionSummaryQueryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.MedicationPrescriptionSummaryQueryResponseBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt030040ca.PrescriptionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060130ca.ParameterListBean;


/**
 * <p>Hello world example for Pharmacy Transactions - Prescription Summary Query.</p>
 * <p>This example illustrates the use of the Message Builder library to perform
 *   a Patient Drug Prescription Summary Query.</p> 
 * <p>  
 *   The pan-Canadian specifications supported used are base R02.04.02 release of:
 *   
 *   Transaction: C01.07 Get Patient Drug Prescription Order Summary
 *   
 *   Request Message: PORX_IN060290CA   (PORX_MT060130CA Drug Prescription Summary Request)
 *   Response Message: PORX_IN060300CA  (PORX_MT030040CA Drug Prescription summary)
 *   
 *   requests retrieval of basic information about all medication 
 *   prescriptions provided to a single patient, d
 *   optionally filtered by date and status.</p>
 * 
 */
public class DrugPrescriptionQueryApp extends HelloWorldApp {

	public static void main(final String[] args) throws Exception {
		DrugPrescriptionQueryApp app = new DrugPrescriptionQueryApp();
		app.responseExampleResourceFile = "/PORX_EX060300CA.xml";
		app.run(args);
	}

	@Override
	protected void processResponseInteraction(InteractionBean interactionBean) {
		
		MedicationPrescriptionSummaryQueryResponseBean response = (MedicationPrescriptionSummaryQueryResponseBean)interactionBean;
		// Now we print out some of the response values...
		
		if (response == null){
			System.out.printf("Could not cast response to MedicationPrescriptionSummaryQueryResponseBean");
		}
		
		System.out.printf("Message ID (root):=%s\n", response.getId().getRoot());
		System.out.printf("Query ID:=%s\n", response.getControlActEvent().getQueryAck().getQueryId().getRoot());
		System.out.printf("Query Result count:=%d\n", response.getControlActEvent().getQueryAck().getResultTotalQuantity().intValue());

		// Checking the message ID matches the query.
		System.out.printf("Acknowledges Message ID (root):=%s\n",
				response.getAcknowledgement().getTargetMessageId().getRoot());

		if (response.getControlActEvent().getQueryAck().getResultCurrentQuantity().intValue()>0) {
			// Now print out some information for  result records returned...
			List<RefersTo_1Bean<PrescriptionBean>> records = response.getControlActEvent().getSubject(); 
			for (int index=0; index < records.size(); index++) {
				RefersTo_1Bean<PrescriptionBean> subject = records.get(index);
				PrescriptionBean script = subject.getAct();
				HealthcareWorkerBean provider = script.getAuthor().getAssignedEntity();
				String family = provider.getAssignedPerson().getName().getFamilyName();
				String given = provider.getAssignedPerson().getName().getGivenName();
				System.out.printf("Prescriber:= %s %s\n", given, family);
				System.out.printf("prescribed date:= %s\n", script.getAuthor().getTime().toString());
			}
		}
	}

	@Override	
	protected InteractionBean createRequestInteraction() {
		MedicationPrescriptionSummaryQueryBean messageBean = new MedicationPrescriptionSummaryQueryBean();

		this.setTransportWrapperValues(messageBean);
		
		messageBean.setControlActEvent(this.createControlActEvent());
		// Set the Record Target (i.e the patient)
		messageBean.getControlActEvent().setRecordTargetPatient1(this.createRecordTarget());
		
		QueryByParameterBean<ParameterListBean> queryCriteria = new QueryByParameterBean<ParameterListBean>();
		messageBean.getControlActEvent().setQueryByParameter(queryCriteria);
		 
		queryCriteria.setQueryId(new Identifier(UUID.randomUUID().toString()));
		queryCriteria.setParameterList(this.createQueryParameters());
		return messageBean;
	}
	
	private ParameterListBean createQueryParameters() {

		ParameterListBean parameterList = new ParameterListBean();
		
		parameterList.setMostRecentByDrugIndicatorValue(false);
		parameterList.setIssueFilterCodeValue(IssueFilterCode.ALL);
		Interval<Date> fromDate = IntervalFactory.createLow(new Date(0));
		parameterList.setAdministrationEffectivePeriodValue(fromDate);
		return parameterList;
	}

	
	private TriggerEventBean<ParameterListBean> createControlActEvent() {

		TriggerEventBean<ParameterListBean> cae = new TriggerEventBean<ParameterListBean>();
		cae.setId(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		cae.setCode(HL7TriggerEventCode.MEDICATION_PRESCRIPTION_SUMMARY_QUERY);

		cae.setEffectiveTime(IntervalFactory.createLow(new Date()));
		cae.setLocationServiceDeliveryLocation(this.createServiceLocationBean2());
		cae.setAuthor(this.createAuthor_1Bean());
		return cae;
	}
}
