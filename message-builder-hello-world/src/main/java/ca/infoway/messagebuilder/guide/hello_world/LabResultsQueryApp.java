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

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.LAB_TEST_RESULTS_QUERY;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.RefersTo_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.RequestQueryResultsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.ResultsQueryResponseBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ParameterListBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001001ca.ObservationRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004000ca.BatteryEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004000ca.ObservationReportBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004000ca.ResultObservationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004100ca.ReportHeaderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004200ca.DiagnosisOrInterpretationObservationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004999ca.ResultInstancePayloadChoice;

/**
 * <p>Hello world example for Laboratory Information System Transactions - Lab Test Results Query.</p>
 * <p>This example illustrates the use of the Message Builder library to perform
 *   a Lab Test Results Query.</p> 
 * <p>  
 *   The pan-Canadian specifications supported used are base R02.04.02 release of:
 *   
 *   Transaction: L2.1 Laboratory Results Query 
 *   
 *   Request Message:  POLB_IN354000CA  (POLB_MT310000CA - Lab Result Detail Query Request Message) 
 *   Response Message: POLB_IN364000CA  (POLB_MT004999CA - Lab Result Query Response)
 * </p>
 * 
 */
public class LabResultsQueryApp extends HelloWorldApp {

	public static void main(final String[] args) throws Exception {
			LabResultsQueryApp app = new LabResultsQueryApp();
			app.responseExampleResourceFile = "/POLB_EX364000CA.xml";
			app.run(args);
	}

	protected void processResponseInteraction(InteractionBean interactionBean) {
		ResultsQueryResponseBean response = (ResultsQueryResponseBean)interactionBean;
		// Now we print out some of the response values...
		System.out.printf("Message ID (root):=%s\n", response.getId().getRoot());
		
		if (response.getControlActEvent().getSubject().isEmpty()==false)
		{
			List<RefersTo_1Bean<ResultInstancePayloadChoice>> records = response.getControlActEvent().getSubject();
			Iterator<RefersTo_1Bean<ResultInstancePayloadChoice>> resultChoiceIterator = records.iterator();
			
			while (resultChoiceIterator.hasNext()) {
				RefersTo_1Bean<ResultInstancePayloadChoice> result = resultChoiceIterator.next();
				ResultInstancePayloadChoice bean = result.getAct();
				
				System.out.printf("Result Payload Class = %s\n", bean.getClass().toString());
				if (ObservationReportBean.class.isInstance(bean)) {
					this.processObservationReport(bean);
				}
				else if (ResultObservationBean.class.isInstance(bean)) {
					// process result observation bean here
				}
				else if (BatteryEventBean.class.isInstance(bean)) {
					// process battery event bean here
				}
				else if (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004200ca.BatteryEventBean.class.isInstance(bean)) {
					// process other battery event bean here
				}
				else if (ReportHeaderBean.class.isInstance(bean)) {
					// process report header here
				}
				else if (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004200ca.ReportHeaderBean.class.isInstance(bean)) {
					// process other report header here
				}
				else if (DiagnosisOrInterpretationObservationBean.class.isInstance(bean)) {
					// process diagnosis/interpretation observation bean here
				}
			}
		}
	}
	
	private void processObservationReport(ResultInstancePayloadChoice payloadChoiceBean) {

		// Observation Report Lab Result.
		ObservationReportBean report = (ObservationReportBean)payloadChoiceBean;
		
		// id = Report ID [1..1]
		System.out.printf("Report ID = {root=%s, extension=%s}\n", 
				report.getId().getRoot(), 
				report.getId().getExtension());
		
		// ObservationLabReportType code [1..1]
		String reportTypeCode = report.getCode().getCodeValue();
		String reportTypeCodeSystem = report.getCode().getCodeSystem();
		System.out.printf("Report Type: = {code=%s, codeSystem=%s}\n", reportTypeCode, reportTypeCodeSystem);
	
		// title [1..1]
		System.out.printf("Report Title:= %s\n", report.getTitle());
		
		// text [0..1] specialization = ED.DOCORREF
		//Uncomment the next two lines once CR5 release is provided
		//EncapsulatedData ed = report.getRenderedReport();
		//System.out.printf("Report Text:= %s\n", ed.getContent().toString());
		
		// statusCode
		System.out.printf("Report Status:= %s\n", report.getStatusCode().toString());
		//effectiveTime
		System.out.printf("Report Date:= %s\n", report.getEffectiveTime().toString());
		//confidentialityCode [0..2]

		// Who requested this lab test?
		List<FulfillmentChoice> choiceList = report.getInFulfillmentOfFulfillmentChoice();
		Iterator<FulfillmentChoice> iterator = choiceList.iterator();
		while(iterator.hasNext()) {
			FulfillmentChoice choiceBean = iterator.next();
			
			System.out.printf("fulfillmentChoiceBean is %s\n", choiceBean.getClass().getName());
			
			if (ObservationRequestBean.class.isInstance(choiceBean)) {
				ObservationRequestBean observationRequestBean = (ObservationRequestBean)choiceBean;
				Identifier ii = observationRequestBean.getId();
				System.out.printf("infulfillmentOf/observationRequest/id:= {root=%s extension=%s}\n", ii.getRoot(), ii.getExtension());
			}
		}
		
	}

	@Override
	protected InteractionBean createRequestInteraction() {

		// Interaction ID: POLB_IN354000CA
		// Interaction Business Name: Request Query Results
		// Message Type: POLB_MT310000CA
		// Message Type Name: Laboratory Result Detail Query Request
		// Control Act Wrapper:  QUQI_MT020000CA - Query Request Wrapper - human initiated patient-specfic
		// Transport Wrapper: MCCI_MT002100CA - Send Message Payload
		//
		// Trigger Event ID: POLB_TE304000CA
		// Note: the vague bean name is derived from the Business Name defined
		// by the pan-Canadian Standards Collaborative. 
		
		RequestQueryResultsBean messageBean = new RequestQueryResultsBean();

		this.setTransportWrapperValues(messageBean);
		messageBean.setControlActEvent(this.createControlActEvent());

		// Set the Record Target (i.e the patient)
		messageBean.getControlActEvent().setRecordTargetPatient1(this.createRecordTarget());

		QueryByParameterBean<ParameterListBean> query = new QueryByParameterBean<ParameterListBean>();
		messageBean.getControlActEvent().setQueryByParameter(query );
		
		// Set the Query Identifier
		Identifier queryIdentifier = new Identifier(UUID.randomUUID().toString());
		messageBean.getControlActEvent().getQueryByParameter().setQueryId(queryIdentifier);
		
		// Lastly, set the Query Parameters		
		messageBean.getControlActEvent().getQueryByParameter().setParameterList(this.createQueryParameters());
		
		return messageBean;
	}
	
	private ParameterListBean createQueryParameters() {
		// Lastly, set the Query Parameters
		ParameterListBean parameterList = new ParameterListBean();
		// Focus of the query .. look up lab test results for this lab test record:
		Identifier resultId = new Identifier("2.16.840.1.113883.19.3.207.15.2.13",
		"R2CBJU7LUAGYP");
		
		// Specific Lab Test 
		parameterList.setObservationIdentifierValue(resultId);
		
		// Now set corroborating patient information
		java.util.Date patientBirthDate = (new GregorianCalendar(1949,
				java.util.Calendar.NOVEMBER, 05)).getTime();
		parameterList.setPatientDateofBirthValue(patientBirthDate);
		parameterList.setPatientGenderValue(AdministrativeGender.MALE);
		
		// Set a patient identifier - This is a MANDATORY parameter.
		Identifier patientID = new Identifier("2.16.840.1.113883.3.19.3.163.1", "9880897949");
		parameterList.setPatientIDValue(patientID);
		// For Corroborating the Patient ID
		parameterList.setPatientNameValue(PersonName.createFirstNameLastName("Cyril", "Lambert"));
		return parameterList;
	}

	
	private TriggerEvent_5Bean<ParameterListBean> createControlActEvent() {
		TriggerEvent_5Bean<ParameterListBean> cae = new TriggerEvent_5Bean<ParameterListBean>();
		
		cae.setId(new Identifier("2.16.840.1.113883.1.6", "8141234"));	
		cae.setCode(LAB_TEST_RESULTS_QUERY);
		cae.setEffectiveTime(IntervalFactory.createLow(new Date()));
		cae.setAuthor(this.createAuthor_1Bean());
		cae.setDataEntryLocationServiceDeliveryLocation(this.createServiceLocationBean());
		return cae;
	}	
}
