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

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.FIND_CANDIDATES_QUERY;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.RegistrationEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mfmi_mt700751ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.cr.merged.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.cr.prpa_mt101103ca.ParameterListBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.FindCandidatesQueryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.FindCandidatesResponseBean;

/**
 * <p>
 * Hello world example for Client Registry Transactions - Find Candidates Query.
 * </p>
 * <p>
 * This example illustrates the use of the Message Builder library to perform a
 * Find Candidates Query.
 * </p>
 * <p>
 * The pan-Canadian specifications supported used are base R02.04.02 release of:
 * 
 * Transaction: N2.1 Find Candidates Query
 * 
 * Request Message: PRPA_IN101103CA Response Message: PRPA_IN101104CA
 * </p>
 * 
 */
public class FindCandidatesApp extends HelloWorldApp {

	public static void main(final String[] args) throws Exception {
		FindCandidatesApp app = new FindCandidatesApp();

		// Use the Find Candidates response example from the resource bundle:
		app.responseExampleResourceFile = "/PRPA_EX101104CA.xml";
		app.run(args);
	}

	protected void processResponseInteraction(InteractionBean interactionBean) {
		FindCandidatesResponseBean response = (FindCandidatesResponseBean) interactionBean;
		// Now we print out some of the response values...
		System.out.printf("Message ID (root):=%s\n", response.getId().getRoot());
		System.out.printf("Query ID:=%s\n", response.getControlActEvent().getQueryAck().getQueryId().getRoot());
		System.out.printf("Query Result count:=%d\n", response.getControlActEvent().getQueryAck().getResultTotalQuantity());

		// Checking the message ID matches the query.
		System.out.printf("Acknowledges Message ID (root):=%s\n", response.getAcknowledgement().getTargetMessageId().getRoot());

		if (response.getControlActEvent().getQueryAck().getResultCurrentQuantity() > 0) {
			// Now print out the first result record returned...

			List<RegistrationEventBean<IdentifiedPersonBean>> records = response.getControlActEvent().getSubjectRegistrationEvent();

			Iterator<RegistrationEventBean<IdentifiedPersonBean>> recordIterator = records.iterator();
			while (recordIterator.hasNext()) {
				RegistrationEventBean<IdentifiedPersonBean> record = recordIterator.next();
				IdentifiedPersonBean person = record.getSubject().getRegisteredRole();
				Set<Identifier> ids = person.getId();
				Iterator<Identifier> iterator = ids.iterator();

				while (iterator.hasNext()) {
					Identifier id = iterator.next();
					// Identifier doesn't support extracting 'use' or
					// 'specializationType'
					System.out.printf("Person id := {root = %s, extension = %s}\n", id.getRoot(), id.getExtension());
				}
				// Print out the person's name(s)
				List<PersonName> names = person.getIdentifiedPersonName();
				Iterator<PersonName> namesIterator = names.iterator();
				while (namesIterator.hasNext()) {
					PersonName name = namesIterator.next();
					System.out.printf("Person name := %s %s\n", name.getGivenName(), name.getFamilyName());
				}
			}
		}
	}

	protected InteractionBean createRequestInteraction() {
		FindCandidatesQueryBean messageBean = new FindCandidatesQueryBean();

		this.setTransportWrapperValues(messageBean);

		messageBean.setControlActEvent(this.createControlActEvent());

		// Lastly, set the Query Parameters
		QueryByParameterBean<ParameterListBean> query = new QueryByParameterBean<ParameterListBean>();
		messageBean.getControlActEvent().setQueryByParameter(query);

		// Set unique query identifier
		query.setQueryId(new Identifier(UUID.randomUUID().toString()));

		// Setup the query parameters
		ParameterListBean parameters = new ParameterListBean();
		// person name query parameter
		parameters.getPersonNameValue().add(PersonName.createFirstNameLastName("Cyril", "Lambert"));
		// Set the birth date of the person...
		java.util.Date birthDate = (new GregorianCalendar(1949, java.util.Calendar.NOVEMBER, 05)).getTime();
		parameters.setPersonBirthtimeValue(birthDate);
		// Set the gender
		parameters.setAdministrativeGenderValue(AdministrativeGender.MALE);
		query.setParameterList(parameters);

		return messageBean;
	}

	private TriggerEventBean<ParameterListBean> createControlActEvent() {
		TriggerEventBean<ParameterListBean> cae = new TriggerEventBean<ParameterListBean>();

		// Set the control act identifier
		cae.setId(new Identifier(UUID.randomUUID().toString()));

		// Set the event type
		cae.setCode(FIND_CANDIDATES_QUERY);

		// Setting the event time stamp
		Interval<Date> eventEffectivePeriod = IntervalFactory.createLow(new Date());
		cae.setEffectiveTime(eventEffectivePeriod);

		cae.setDataEntryLocationServiceDeliveryLocation(this.createServiceDeliveryLocationBean());

		// Setting the author
		cae.setAuthor(this.createAuthor_2Bean());

		return cae;
	}
}
