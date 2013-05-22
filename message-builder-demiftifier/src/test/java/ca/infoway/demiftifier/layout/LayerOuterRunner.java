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
package ca.infoway.demiftifier.layout;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import ca.infoway.demiftifier.PackageLocationLayout;
import ca.infoway.demiftifier.svgifier.Svgifier;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

public class LayerOuterRunner {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		LayerOuter layerOuter = new LayerOuter();
		
//		MessageSet messageSet = layerOuter.getMessageSet("/messageSet_r02_04_03.xml");
		MessageSet messageSet = getMessageSet("/messageSet_r02_04_04_miftesting.xml");
//		MessageSet messageSet = layerOuter.getMessageSet("/eHO-CeRxHF3-MessageSet_Jason.xml");
		

		String jurisdictionCode = "CA";
		List<String> packageLocationNames = new ArrayList<String>();
		packageLocationNames.add("PRPA_MT101103");
		packageLocationNames.add("QUCR_MT810201");
		packageLocationNames.add("REPC_MT230001");
		packageLocationNames.add("FICR_MT600201");
		packageLocationNames.add("PORX_MT060160");
		packageLocationNames.add("PORX_MT010120");
		packageLocationNames.add("COCT_MT220200");
		packageLocationNames.add("MCCI_MT002300");
		packageLocationNames.add("POLB_MT004000");
		packageLocationNames.add("COCT_MT011001");
		packageLocationNames.add("COCT_MT270010");
		packageLocationNames.add("COMT_MT111111");

		long startDemiftify = System.currentTimeMillis();
		System.out.println("MessageSet load took: " + (startDemiftify - start) + "ms");

		int mifsRendered = 0;
		
		for (String packageLocationNameRaw : packageLocationNames) {
			String packageLocationName = packageLocationNameRaw + jurisdictionCode;
			if (messageSet.getPackageLocation(packageLocationName) == null){
				System.out.println("MessageSet does not contain packageLocation " + packageLocationName);
			} else {
				PackageLocationLayout layout = layerOuter.layout(messageSet, packageLocationName);
				
				new Svgifier().render(layout, new File(packageLocationName + ".svg"));
				long endDemiftify = System.currentTimeMillis();
				mifsRendered++;
				System.out.println(packageLocationName + " was rendered in " + (endDemiftify - startDemiftify) + "ms");
				startDemiftify = endDemiftify;
			}
		}

		String text = mifsRendered > 1 ? " mifs were rendered in " : " mif was rendered in ";
		System.out.println(mifsRendered + text + (System.currentTimeMillis() - start) + "ms");
		int mifsNotFound = packageLocationNames.size()-mifsRendered;
		System.out.println(mifsNotFound + " mifs were missing from messageSet");

	}
	

	private static MessageSet getMessageSet(String fileName) throws Exception {
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream input = LayerOuterRunner.class.getResourceAsStream(fileName);
		try {
			return marshaller.unmarshall(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
