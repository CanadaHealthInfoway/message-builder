package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import static ca.infoway.messagebuilder.xml.DifferenceType.ARGUMENT_TEMPLATE_PARAMETER_NAME;
import static ca.infoway.messagebuilder.xml.DifferenceType.ARGUMENT_TRAVERSAL_NAME;
import static ca.infoway.messagebuilder.xml.DifferenceType.ASSOCIATION_TYPE;
import static ca.infoway.messagebuilder.xml.DifferenceType.ATTRIBUTE_TYPE;
import static ca.infoway.messagebuilder.xml.DifferenceType.CHOICE_RELATIONSHIP_TYPE;
import static ca.infoway.messagebuilder.xml.DifferenceType.COMPONENT_ONLY_IN_ONE_VERSION;
import static ca.infoway.messagebuilder.xml.DifferenceType.INTERACTION_SUPER_TYPE_NAME;
import static ca.infoway.messagebuilder.xml.DifferenceType.MESSAGE_PART_ABSTRACT;
import static ca.infoway.messagebuilder.xml.DifferenceType.PACKAGE_LOCATION_ROOT_TYPE;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_DOMAIN_TYPES_INCOMPATIBLE;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_ONE_OR_BOTH_DOMAIN_TYPES_NOT_IN_SYSTEM;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_ONLY_ONE_HAS_DOMAIN_TYPE;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_RENAMED;
import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_TEMPLATE_PARAMETER_NAME;

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
    	register(ARGUMENT_TEMPLATE_PARAMETER_NAME, new ArgumentTemplateParameterNameDifferenceAnalyzer());
    	register(ARGUMENT_TRAVERSAL_NAME, new ArgumentTraversalNameDifferenceAnalyzer());
    	register(INTERACTION_SUPER_TYPE_NAME, new InteractionSuperTypeNameDifferenceAnalyzer());
    	register(MESSAGE_PART_ABSTRACT, new MessagePartAbstractDifferenceAnalyzer());
    	register(PACKAGE_LOCATION_ROOT_TYPE, new PackageLocationRootTypeDifferenceAnalyzer());
    	register(RELATIONSHIP_DOMAIN_TYPES_INCOMPATIBLE, new RelationshipDomainTypesIncompatibleDifferenceAnalyzer());
    	register(RELATIONSHIP_ONE_OR_BOTH_DOMAIN_TYPES_NOT_IN_SYSTEM, new RelationshipDomainTypeNotInSystemDifferenceAnalyzer());
    	register(RELATIONSHIP_ONLY_ONE_HAS_DOMAIN_TYPE, new RelationshipMissingDomainTypeDifferenceAnalyzer());
    	register(RELATIONSHIP_TEMPLATE_PARAMETER_NAME, new RelationshipTemplateParameterNameDifferenceAnalyzer());
    	register(ASSOCIATION_TYPE, new AssociationTypeDifferenceAnalyzer());
    	register(CHOICE_RELATIONSHIP_TYPE, new AssociationTypeDifferenceAnalyzer());
    	register(COMPONENT_ONLY_IN_ONE_VERSION, new ComponentMissingDifferenceAnalyzer());
    	register(RELATIONSHIP_RENAMED, new TrivialDifferenceAnalyzer(true));
    	register(ATTRIBUTE_TYPE, new TrivialDifferenceAnalyzer(false));
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
