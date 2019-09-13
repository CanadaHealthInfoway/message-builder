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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.MessagePart;


public class ClusterAnalyzerTest {
	
	@Test
	public void shouldClusterItems() throws Exception {
		
		ClusterAnalyzer analyzer = new ClusterAnalyzer();
		
		SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Subject"),false);
		SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Subject2"),false);
		analyzer.cluster(type1, type2);
		SimplifiableType type3 = new SimplifiableType(new MessagePart("EFGH_MT123456CA.Subject"), false);
		SimplifiableType type4 = new SimplifiableType(new MessagePart("EFGH_MT123456CA.Subject2"), false);
		analyzer.cluster(type3, type4);
		
		assertEquals("number of clusters - before", 2, analyzer.getClusters().size());
		
		analyzer.cluster(type1, type3);
		
		assertEquals("number of clusters - after", 1, analyzer.getClusters().size());
		
		Cluster cluster = (Cluster) CollectionUtils.get(analyzer.getClusters(), 0);
		assertEquals("number of names", 4, cluster.getTypes().size());
	}

	@Test
	public void shouldDetectClusters() throws Exception {
		
		ClusterAnalyzer analyzer = new ClusterAnalyzer();
		
		List<SimplifiableType> types = new ArrayList<SimplifiableType>();
		types.add(new SimplifiableType(new MessagePart("ABCD_MT123456CA.Subject"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT123456CA.Subject2"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT987654CA.Subject"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT987654CA.Patient"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT987654CA.Person"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT888888CA.Person"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT888888CA.AssignedEntity"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT888888CA.SubjectOf2"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT888888CA.Patient"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT888888CA.PatientPerson"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT002100CA.Device"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT002100CA.Device1"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT002100CA.Device2"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT002300CA.Device"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT002300CA.Device1"), false));
		types.add(new SimplifiableType(new MessagePart("ABCD_MT002300CA.Device2"), false));
		
		analyzer.analyze(types);
		
		Collection<Cluster> clusters = analyzer.getClusters();
		// items that match nothing appear in no cluster
		assertEquals("matches", 4, clusters.size());
		
		for (Cluster cluster : clusters) {
			System.out.println(cluster.getTypes());
		}
	}
}
