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

package ca.infoway.messagebuilder.generator.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class FingerprintDuplicateRegistry {
	
	private static Map<String, Set<String>> duplicateFingerprintRegistry = new HashMap<String, Set<String>>();
	
	// TM - Not as ideal as I would like. Would be better to log and check the Version as well. While
	// we could log the Version here easily, this value is not available at the time we create Fingerprints.
	
	static {
		// all known type/relationships that cause duplicate fingerprints
		
		// from the AB Session Management MIFs:
		addDuplicateFingerprint("COMT_MT900003AB.ActPermissionRequest", "performer1");
		addDuplicateFingerprint("COMT_MT900003AB.ActPermissionRequest", "performer2");
		
		addDuplicateFingerprint("POLB_MT330000CA.ParameterList", "batteryRequestStatus");
		addDuplicateFingerprint("POLB_MT330000CA.ParameterList", "observationRequestStatus");
	}
	
	static boolean causesDuplicateFingerprint(String type, String relationship) {
		return duplicateFingerprintRegistry.containsKey(type) && duplicateFingerprintRegistry.get(type).contains(relationship);
	}
	
	public static void addDuplicateFingerprint(String type, String relationship) {
		Set<String> set = duplicateFingerprintRegistry.get(type);
		if (set == null) {
			set = new HashSet<String>();
			duplicateFingerprintRegistry.put(type, set);
		}
		set.add(relationship);
	}

}
