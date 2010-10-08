package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import static ca.infoway.messagebuilder.xml.DifferenceType.ARGUMENT_MISSING;
import static ca.infoway.messagebuilder.xml.DifferenceType.ARGUMENT_NAME;
import static ca.infoway.messagebuilder.xml.DifferenceType.ARGUMENT_TEMPLATE_PARAMETER_NAME;
import static ca.infoway.messagebuilder.xml.DifferenceType.ARGUMENT_TRAVERSAL_NAME;
import static ca.infoway.messagebuilder.xml.DifferenceType.INTERACTION_SUPER_TYPE_NAME;
import static ca.infoway.messagebuilder.xml.DifferenceType.MESSAGE_PART_ABSTRACT;
import static ca.infoway.messagebuilder.xml.DifferenceType.PACKAGE_LOCATION_ROOT_TYPE;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_DOMAIN_TYPES_INCOMPATIBLE;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_ONE_OR_BOTH_DOMAIN_TYPES_NOT_IN_SYSTEM;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_ONLY_ONE_HAS_DOMAIN_TYPE;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_TEMPLATE_PARAMETER_NAME;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_TYPE;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.xml.DifferenceType;

public class DifferenceAnalyzerRegistry {

    private static DifferenceAnalyzerRegistry instance = new DifferenceAnalyzerRegistry();

    private final Map<DifferenceType, DifferenceAnalyzer> registryMap = Collections.synchronizedMap(new HashMap<DifferenceType, DifferenceAnalyzer>());

    public DifferenceAnalyzerRegistry() {
    	registerAll();
	}
    
    public void registerAll() {
    	register(ARGUMENT_MISSING, new TrivialDifferenceAnalyzer(true));
    	register(ARGUMENT_NAME, new TrivialDifferenceAnalyzer(true));
    	register(ARGUMENT_TEMPLATE_PARAMETER_NAME, new TrivialDifferenceAnalyzer(true));
    	register(ARGUMENT_TRAVERSAL_NAME, new TrivialDifferenceAnalyzer(true));
    	register(INTERACTION_SUPER_TYPE_NAME, new InteractionSuperTypeNameDifferenceAnalyzer());
    	register(MESSAGE_PART_ABSTRACT, new TrivialDifferenceAnalyzer(true));
    	register(PACKAGE_LOCATION_ROOT_TYPE, new TrivialDifferenceAnalyzer(true));
    	register(RELATIONSHIP_DOMAIN_TYPES_INCOMPATIBLE, new TrivialDifferenceAnalyzer(true));
    	register(RELATIONSHIP_ONE_OR_BOTH_DOMAIN_TYPES_NOT_IN_SYSTEM, new TrivialDifferenceAnalyzer(true));
    	register(RELATIONSHIP_ONLY_ONE_HAS_DOMAIN_TYPE, new TrivialDifferenceAnalyzer(true));
    	register(RELATIONSHIP_TEMPLATE_PARAMETER_NAME, new TrivialDifferenceAnalyzer(true));
    	register(RELATIONSHIP_TYPE, new TrivialDifferenceAnalyzer(true));
    }

	private void register(DifferenceType differenceKey, DifferenceAnalyzer differenceAnalyzer) {
		this.registryMap.put(differenceKey, differenceAnalyzer);
	}
	
	public DifferenceAnalyzer get(DifferenceType differenceType) {
		return this.registryMap.get(differenceType);
	}
	
    public static DifferenceAnalyzerRegistry getInstance() {
        return instance;
    }
}
