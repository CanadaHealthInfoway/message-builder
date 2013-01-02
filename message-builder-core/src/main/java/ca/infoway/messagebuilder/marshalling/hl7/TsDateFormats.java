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
 * Last modified: $LastChangedDate: 2012-07-16 19:39:52 -0400 (Mon, 16 Jul 2012) $
 * Revision:      $LastChangedRevision: 5975 $
 */

package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;

public class TsDateFormats {

	public static final Map<StandardDataType, List<String>> formats;
	public static final Map<String, String> expandedFormats;
	public static final Map<Hl7BaseVersion, Map<StandardDataType, List<String>>> versionFormatExceptions;
	public static final List<String> datetimeFormatsRequiringWarning;

	static {
		Map<StandardDataType, List<String>> map = new LinkedHashMap<StandardDataType,List<String>>();
		map.put(StandardDataType.TS_FULLDATETIME, Arrays.asList(
				"yyyyMMddHHmmss.SSS0ZZZZZ",
				"yyyyMMddHHmmss.SSSZZZZZ",
				"yyyyMMddHHmmssZZZZZ"
				));
		map.put(StandardDataType.TS_FULLDATE, Arrays.asList(
				"yyyyMMdd"
				));
		// this is an abstract type and these formats are only used after issuing a warning (there should be a specializationType); only defined in MR2009
		map.put(StandardDataType.TS_FULLDATEWITHTIME, Arrays.asList(
				"yyyyMMddHHmmss.SSS0ZZZZZ",
				"yyyyMMddHHmmss.SSSZZZZZ",
				"yyyyMMddHHmmssZZZZZ",
				"yyyyMMdd"
				));
		map.put(StandardDataType.TS_DATE, Arrays.asList(
				"yyyyMMdd",
				"yyyyMM",
				"yyyy"));
		map.put(StandardDataType.TS_DATETIME, Arrays.asList(
				"yyyyMMddHHmmss.SSS0ZZZZZ",
				"yyyyMMddHHmmss.SSS0",      // not allowed if non-CeRx
				"yyyyMMddHHmmss.SSSZZZZZ",
				"yyyyMMddHHmmss.SSS",       // not allowed if non-CeRx
				"yyyyMMddHHmmssZZZZZ",
				"yyyyMMddHHmmss",           // not allowed if non-CeRx
				"yyyyMMddHHmmZZZZZ",
				"yyyyMMddHHmm",             // not allowed if non-CeRx
				"yyyyMMddHHZZZZZ",
				"yyyyMMddHH",               // not allowed if non-CeRx
				"yyyyMMddZZZZZ",
				"yyyyMMdd",
				"yyyyMMZZZZZ",
				"yyyyMM",
				"yyyyZZZZZ",
				"yyyy"));
		map.put(StandardDataType.TS,
				map.get(StandardDataType.TS_DATETIME));

		formats = Collections.unmodifiableMap(map);
		
		datetimeFormatsRequiringWarning = Collections.unmodifiableList(Arrays.asList(
				"yyyyMMddHHmmss.SSS0",
				"yyyyMMddHHmmss.SSS",
				"yyyyMMddHHmmss",
				"yyyyMMddHHmm",
				"yyyyMMddHH"
				));

		Map<String, String> _expandedFormats = new HashMap<String, String>();
		_expandedFormats.put("yyyyMMddHHmmss.SSSZZZZZ", "yyyyMMddHHmmss.SSS0ZZZZZ");
		_expandedFormats.put("yyyyMMddHHmmss.SSS", "yyyyMMddHHmmss.SSS0");
		
		expandedFormats = Collections.unmodifiableMap(_expandedFormats);

		// some older versions have slightly different rules for allowable time formats

		Map<StandardDataType, List<String>> exceptionMapMR2007 = new LinkedHashMap<StandardDataType,List<String>>();
		exceptionMapMR2007.put(StandardDataType.TS_FULLDATEWITHTIME, Collections.<String>emptyList());

		Map<StandardDataType, List<String>> exceptionMapV02R01 = new LinkedHashMap<StandardDataType,List<String>>();
		exceptionMapV02R01.put(StandardDataType.TS_FULLDATEWITHTIME, Collections.<String>emptyList());

		Map<StandardDataType, List<String>> exceptionMapCeRx = new LinkedHashMap<StandardDataType,List<String>>();
		exceptionMapCeRx.put(StandardDataType.TS_FULLDATEWITHTIME, Collections.<String>emptyList());
		exceptionMapCeRx.put(StandardDataType.TS_FULLDATETIME, Arrays.asList("yyyyMMddHHmmss"));
		exceptionMapCeRx.put(StandardDataType.TS_DATETIME, Arrays.asList(
				"yyyyMMddHHmmss.SSS0",
				"yyyyMMddHHmmss.SSS",
				"yyyyMMddHHmmss",
				"yyyyMMddHHmm",
				"yyyyMMddHH",
				"yyyyMMdd",
				"yyyyMM",
				"yyyy"));

		Map<Hl7BaseVersion, Map<StandardDataType, List<String>>> versionMap = new HashMap<Hl7BaseVersion, Map<StandardDataType,List<String>>>();
		versionMap.put(Hl7BaseVersion.MR2007, Collections.unmodifiableMap(exceptionMapMR2007));
		versionMap.put(Hl7BaseVersion.MR2007_V02R01, Collections.unmodifiableMap(exceptionMapV02R01));
		versionMap.put(Hl7BaseVersion.CERX, Collections.unmodifiableMap(exceptionMapCeRx));

		versionFormatExceptions = Collections.unmodifiableMap(versionMap);
	}
	
	public static String[] getAllDateFormats(StandardDataType standardDataType, VersionNumber version) {
		
		if (standardDataType == null || version == null) {
			return new String[0];
		}
		
		Map<StandardDataType, List<String>> exceptionMap = TsDateFormats.versionFormatExceptions.get(version);
		if (exceptionMap == null) {
			exceptionMap = TsDateFormats.versionFormatExceptions.get(version.getBaseVersion());
		}

		List<String> formats = (exceptionMap == null ? null : exceptionMap.get(standardDataType));
		if (formats == null) {
			formats = TsDateFormats.formats.get(standardDataType);
		}

		return CollectionUtils.isEmpty(formats) ? new String[0] : formats.toArray(new String[formats.size()]);
	}

}
