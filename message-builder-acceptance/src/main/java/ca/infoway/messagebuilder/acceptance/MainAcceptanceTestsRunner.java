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

package ca.infoway.messagebuilder.acceptance;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.infoway.messagebuilder.acceptance.metrics.AllAcceptanceGroupTestMetrics;

public class MainAcceptanceTestsRunner {
	
	private final Log log = LogFactory.getLog(MainAcceptanceTestsRunner.class);

	private final AcceptanceTestsMetricsRecordCreator acceptanceTestMetricsRecordCreator;

	private final List<AcceptanceTestsMetricsProcessor> acceptaneTestsProcessors;

	public MainAcceptanceTestsRunner(List<AcceptanceTestsMetricsProcessor> acceptaneTestsProcessors) {
		this(new AcceptanceTestsMetricsRecordCreator(), acceptaneTestsProcessors);
	}
	
	MainAcceptanceTestsRunner(AcceptanceTestsMetricsRecordCreator acceptanceTestMetricsRecordCreator, List<AcceptanceTestsMetricsProcessor> acceptaneTestsProcessors) {
		this.acceptanceTestMetricsRecordCreator = acceptanceTestMetricsRecordCreator;
		this.acceptaneTestsProcessors = acceptaneTestsProcessors;
	}

	private void run() {
		AllAcceptanceGroupTestMetrics amalgamatedMetrics = new AllAcceptanceGroupTestMetrics(new Date());

		for (AcceptanceTestsMetricsProcessor processor : this.acceptaneTestsProcessors) {
			amalgamatedMetrics.getGroupMetrics().add(processor.process());
		}
		
		// need to handle devcreek being down or are settings being invalid
		try {
			log.info(String.format("Transmitting %s acceptance tests group metrics to devcreek...", amalgamatedMetrics.getGroupMetrics().size()));
			this.acceptanceTestMetricsRecordCreator.create(amalgamatedMetrics);
			log.info(String.format("Done transmitting %s acceptance tests group metrics to devcreek.", amalgamatedMetrics.getGroupMetrics().size()));
		} catch(RuntimeException rte) {
			log.info("Unable to transmit acceptance test results to DevCreek (DevCreek offline, settings invalid?)!", rte);
		}
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"MainAcceptanceTestsRunnerContext.xml"});
		context.registerShutdownHook();
		
		MainAcceptanceTestsRunner runner = context.getBean("ca.infoway.messagebuilder.acceptance.MainAcceptanceTestsRunner", MainAcceptanceTestsRunner.class);
		runner.run();
	}
	
	List<AcceptanceTestsMetricsProcessor> getAcceptaneTestsProcessors() {
		return this.acceptaneTestsProcessors;
	}

}
