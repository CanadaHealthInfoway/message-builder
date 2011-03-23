package ca.infoway.messagebuilder.transport.mohawk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>A registry for service definitions. The registry is keyed by intertcation id.
 * A service definition contains a path and an action (i.e. submit).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public class ServiceDefinition {

	private final String path;
	private final String action;

	ServiceDefinition(String path, String action) {
		this.path = path;
		this.action = action;
	}

	/**
	 * <p>Gets the path of this service definition.
	 * 
	 * @return the path of this service
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * <p>Gets the action of this service definition.
	 * 
	 * @return the action of this service
	 */
	public String getAction() {
		return this.action;
	}

	private static final String SUBMIT = "submit";
	private static Map<String,ServiceDefinition> actions = Collections.synchronizedMap(new HashMap<String,ServiceDefinition>());
	
	static {
//		Client Registry
//		Find candidates - PRPA_IN101103CA/PRPA_IN101104CA
		actions.put("PRPA_IN101103CA", new ServiceDefinition("", SUBMIT));
//		Get client demographics - PRPA_IN101101CA/PRPA_IN101102CA
		actions.put("PRPA_IN101101CA", new ServiceDefinition("", SUBMIT));
//
//		Provider Registry
//		Provider details query - PRPM_IN306010CA/PRPM_IN306011CA
		actions.put("PRPM_IN306010CA", new ServiceDefinition("", SUBMIT));		
//
//		Lab
//		Query Laboratory Test Results - POLB_IN354000CA/POLB_IN364000CA
		actions.put("POLB_IN354000CA", new ServiceDefinition("", SUBMIT));		
//
//		Allergy
//		Add allergy - REPC_IN000012CA/REPC_IN000013CA/REPC_IN000014CA
		actions.put("REPC_IN000012CA", new ServiceDefinition("", SUBMIT));
//		Update allergy - REPC_IN000020CA/REPC_IN000021CA/REPC_IN000022CA
		actions.put("REPC_IN000020CA", new ServiceDefinition("", SUBMIT));
//		Patient allergy/intolerance query - REPC_IN000015CA/REPC_IN000016CA
		actions.put("REPC_IN000015CA", new ServiceDefinition("", SUBMIT));
//
//		Immunization
//		Immunization Event Record Request -
//		POIZ_IN010020CA/POIZ_IN010030CA/POIZ_IN010040CA
		actions.put("POIZ_IN010020CA", new ServiceDefinition("", SUBMIT));
//
//		Infrastructure
//		Add patient note - COMT_IN300001CA/COMT_IN300002CA/COMT_IN300003CA
		actions.put("COMT_IN300001CA", new ServiceDefinition("", SUBMIT));
//		Query patient notes - COMT_IN300201CA/COMT_IN300202CA
		actions.put("COMT_IN300201CA", new ServiceDefinition("", SUBMIT));
//		Add record note - COMT_IN301001CA/COMT_IN301002CA/COMT_IN301003CA
		actions.put("COMT_IN301001CA", new ServiceDefinition("", SUBMIT));
//
//		Professional Services
//		List Patient Professional Services - REPC_IN000041CA/REPC_IN000042CA
		actions.put("REPC_IN000041CA", new ServiceDefinition("", SUBMIT));
//		Record Patient Professional Service - REPC_IN000044CA/REPC_IN000045CA/REPC_IN000046CA			
		actions.put("REPC_IN000044CA", new ServiceDefinition("", SUBMIT));
	}

	/**
	 * <p>Obtains a service based on a name/interaction id. If a service could not be found then returns null.  
	 * 
	 * @param name the name/interaction id to lookup the service under
	 * 
	 * @return the service definition for the given name/interaction id
	 */
	public static ServiceDefinition getService(String name) {
		return actions.get(name);
	}
	
}
