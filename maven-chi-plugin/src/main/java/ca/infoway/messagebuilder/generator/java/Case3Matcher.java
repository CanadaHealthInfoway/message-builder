package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.generator.LogUI;


abstract class Case3Matcher {
	
	private final LogUI log;
	protected final SimplifiableTypeProvider definitions;
	private final ClusterProvider clusterProvider;
	
	Case3Matcher(LogUI log, SimplifiableTypeProvider definitions, ClusterProvider clusterProvider) {
		this.log = log;
		this.definitions = definitions;
		this.clusterProvider = clusterProvider;
	}
	
	abstract String getDescription();
	abstract boolean performMatching(SimplifiableType type, List<SimplifiableType> types);

	boolean matchAllTypes() {
		boolean changes = false;
		
		for (Cluster cluster : this.clusterProvider.getClusters()) {
			List<SimplifiableType> types = new ArrayList<SimplifiableType>(cluster.getTypes());
			
			while (!types.isEmpty()) {
				SimplifiableType type = types.remove(0);
				
				boolean match = performMatching(type, types);
				this.log.log(DEBUG, "Simplification case 3: Now analyzing " + type.getTypeName() + ". " +
						(match ? "Candidate for simplification" : ""));
				changes |= match;
			}
		}

		return changes;
	}
}
