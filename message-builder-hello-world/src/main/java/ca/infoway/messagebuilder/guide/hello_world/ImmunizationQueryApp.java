package ca.infoway.messagebuilder.guide.hello_world;


import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.IMMUNIZATION_QUERY;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.UUID;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.RefersTo_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged.ImmunizationsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt060140ca.ImmunizationQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt061140ca.PatientIDBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.ImmunizationsQueryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.ImmunizationsQueryResponseBean;

/**
 * <p>Hello world example for Immunization Registry Transactions - Immunization Event Detail Query.</p>
 * <p>This example illustrates the use of the Message Builder library to perform
 *   an Immunization Event Detail Query.</p> 
 * <p>  
 *   The pan-Canadian specifications supported used are base R02.04.02 release of:
 *   
 *   Transaction: P07.01 Immunization Event Detail Query/Response
 *   
 *   Request Message:  POIZ_IN020010CA   
 *   Response Message: POIZ_IN020020CA
 * </p>
 * 
 */
public class ImmunizationQueryApp extends HelloWorldApp {

	public static void main(final String[] args) throws Exception {
			ImmunizationQueryApp app = new ImmunizationQueryApp();
			app.responseExampleResourceFile = "/POIZ_EX020020CA.xml";
			app.run(args);
	}

	protected void processResponseInteraction(InteractionBean interactionBean) {
		// Now we want to parse (i.e. de-serialize or un-marshal) the response message...
		ImmunizationsQueryResponseBean response = (ImmunizationsQueryResponseBean)interactionBean;
		// Now we print out some of the response values...
		System.out.printf("Message ID (root):=%s\n", response.getId().getRoot());
		System.out.printf("Query ID:=%s\n", response.getControlActEvent().getQueryAck().getQueryId().getRoot());
		System.out.printf("Query Result count:=%d\n", response.getControlActEvent().getQueryAck().getResultTotalQuantity());
	
	    //Now let's add  some code to extract an immunization record detail...'
		Iterator<RefersTo_1Bean<ImmunizationsBean>> iterator = response.getControlActEvent().getSubject().iterator();
		while (iterator.hasNext()) {
			RefersTo_1Bean<ImmunizationsBean> immunization = iterator.next();

			String vaccineCode = immunization.getAct().getConsumableAdministerableMedicineAdministerableVaccine().getCode().getCodeValue();
			String vocabulary = immunization.getAct().getConsumableAdministerableMedicineAdministerableVaccine().getCode().getCodeSystem();
			String vaccine = immunization.getAct().getConsumableAdministerableMedicineAdministerableVaccine().getName();
			String aDate = immunization.getAct().getEffectiveTime().toString();
			System.out.printf("Vaccine: %s (code= %s ,codeSystem = %s) administered: %s\n", vaccine, vaccineCode, vocabulary, aDate);	
		}
	}

	protected InteractionBean createRequestInteraction() {

		// Create a POIZ_IN020010CA Immunization Event Detail Request Message
		ImmunizationsQueryBean messageBean = new ImmunizationsQueryBean();
		this.setTransportWrapperValues(messageBean);
		// Create and setup the control act event wrapper
		messageBean.setControlActEvent(this.createControlActEvent());
		
		QueryByParameterBean<ImmunizationQueryParametersBean> query = new QueryByParameterBean<ImmunizationQueryParametersBean>();
		messageBean.getControlActEvent().setQueryByParameter(query);

		// Set unique query identifier
		messageBean.getControlActEvent().getQueryByParameter().setQueryId(new Identifier(UUID.randomUUID().toString()));

		// Lastly, set the Query Parameters		
		messageBean.getControlActEvent().getQueryByParameter().setParameterList(this.createQueryParameters());

		return messageBean;
	}
	
	private ImmunizationQueryParametersBean createQueryParameters() {
		// Lastly, set the Query Parameters
		ImmunizationQueryParametersBean parameterList = new ImmunizationQueryParametersBean();
		// Focus of the query .. look up immz detail results for this immz record
		Identifier immunizationId = new Identifier("2.16.840.1.113883.19.3.207.15.1.1",
		"829SRFGZ80Y6Z");
	
		parameterList.setImmunizationEventIDValue(immunizationId);

		// Set the corroborating patient data.
		java.util.Date patientBirthDate = (new GregorianCalendar(1949,
				java.util.Calendar.NOVEMBER, 05)).getTime();
		parameterList.setPatientBirthDateValue(patientBirthDate);

		parameterList.setPatientGenderValue(AdministrativeGender.MALE);

		Identifier patientID = new Identifier("2.16.840.1.113883.3.19.3.163.1", "9880897949");
		parameterList.getPatientIDValue().add(patientID);

		parameterList.setPatientGenderValue(AdministrativeGender.MALE);
		
		// Set a patient identifier
		parameterList.setPatientNameValue(PersonName.createFirstNameLastName("Cyril", "Lambert"));
		return parameterList;
	}
	
	private TriggerEvent_5Bean<ImmunizationQueryParametersBean> createControlActEvent() {
		TriggerEvent_5Bean<ImmunizationQueryParametersBean> controlActEvent = new TriggerEvent_5Bean<ImmunizationQueryParametersBean>();

		controlActEvent.setCode(IMMUNIZATION_QUERY);

		controlActEvent.setId(new Identifier(UUID.randomUUID().toString()));
		controlActEvent.setEffectiveTime(IntervalFactory.createLow(new Date()));

		controlActEvent.setRecordTargetPatient1(this.createRecordTarget());
		controlActEvent.setAuthor(this.createAuthor_1Bean());
		controlActEvent.setDataEntryLocationServiceDeliveryLocation(this
				.createServiceLocationBean());
		return controlActEvent;
	}	
	
}
