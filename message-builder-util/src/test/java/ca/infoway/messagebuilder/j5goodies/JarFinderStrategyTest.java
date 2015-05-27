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

package ca.infoway.messagebuilder.j5goodies;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;


public class JarFinderStrategyTest {

	private static String STANDARD_JAR_URL = "jar:file:/home/administrator/workspace/message-builder/message-builder-core/target/message-builder-core-1.2.4-SNAPSHOT.jar";
	private static String WEBLOGIC_JAR_URL = "zip:D:/bea/wlserver_10.3/server/config/saskbrokerdomain/servers/AdminServer/tmp/_WL_user/ehealth-broker-sask/c7f700/war/WEB-INF/lib/message-builder-hl7v3-release-sk_cerx_v01_r04_3-1.2.3-SNAPSHOT.jar!/META-INF/MANIFEST.MF";
	private static String WEBSPHERE_JAR_URL = "wsjar:file:/C:/Program%20Files%20(x86)/IBM/WebSphere/AppServer_1/profiles/AppSrv01/installedApps/AUSSYDCVTLJ007Node02Cell/myapp.ear/lib/core.jar!/project.properties";

	@Test
	public void testStandardUrl() throws Exception {
		JarFinderStrategy jarFinderStrategy = new JarFinderStrategy(STANDARD_JAR_URL);
		URL url = jarFinderStrategy.createUrl();
		Assert.assertEquals("/home/administrator/workspace/message-builder/message-builder-core/target/message-builder-core-1.2.4-SNAPSHOT.jar", url.getPath());
	}
	
	@Test
	public void testWeblogicUrl() throws Exception {
		JarFinderStrategy jarFinderStrategy = new JarFinderStrategy(WEBLOGIC_JAR_URL);
		URL url = jarFinderStrategy.createUrl();
		Assert.assertEquals("/D:/bea/wlserver_10.3/server/config/saskbrokerdomain/servers/AdminServer/tmp/_WL_user/ehealth-broker-sask/c7f700/war/WEB-INF/lib/message-builder-hl7v3-release-sk_cerx_v01_r04_3-1.2.3-SNAPSHOT.jar!/META-INF/MANIFEST.MF", url.getPath());
	}
	
	@Test
	public void testWebsphereUrl() throws Exception {
		JarFinderStrategy jarFinderStrategy = new JarFinderStrategy(WEBSPHERE_JAR_URL);
		URL url = jarFinderStrategy.createUrl();
		Assert.assertEquals("/C:/Program%20Files%20(x86)/IBM/WebSphere/AppServer_1/profiles/AppSrv01/installedApps/AUSSYDCVTLJ007Node02Cell/myapp.ear/lib/core.jar!/project.properties", url.getPath());
	}
	
}
