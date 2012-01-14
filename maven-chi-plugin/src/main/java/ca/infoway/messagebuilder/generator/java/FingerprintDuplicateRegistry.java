package ca.infoway.messagebuilder.generator.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class FingerprintDuplicateRegistry {
	
	private static Map<String, Set<String>> duplicateFingerprintRegistry = new HashMap<String, Set<String>>();
	
	// TODO - TM - Not as ideal as I would like. Would be better to log and check the Version as well. While
	// we could log the Version here easily, this value is not available at the time we create Fingerprints.
	
	static {
		// all known type/relationships that cause duplicate fingerprints
		
		// from the AB Session Management MIFs:
		addDuplicateFingerprint("COMT_MT900003AB.ActPermissionRequest", "performer1");
		addDuplicateFingerprint("COMT_MT900003AB.ActPermissionRequest", "performer2");
		
	}
	
	static boolean causesDuplicateFingerprint(String type, String relationship) {
		return duplicateFingerprintRegistry.containsKey(type) && duplicateFingerprintRegistry.get(type).contains(relationship);
	}
	
	static void addDuplicateFingerprint(String type, String relationship) {
		Set<String> set = duplicateFingerprintRegistry.get(type);
		if (set == null) {
			set = new HashSet<String>();
			duplicateFingerprintRegistry.put(type, set);
		}
		set.add(relationship);
	}

}
