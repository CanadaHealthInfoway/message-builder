package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.INFO;

import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.TypeName;

public class Case3Simplifier {
	
	abstract class Case3MatcherFactory {
		public abstract Case3Matcher create(LogUI log, SimplifiableTypeProvider definitions, Case3MergeResult result, ClusterAnalyzer analyzer);
	}

	private LogUI log;
	private final Case3MergeResult mergeResult;
	private List<? extends Case3MatcherFactory> factories = Arrays.asList(
			new Case3MatcherFactory() {
				public Case3Matcher create(LogUI log, SimplifiableTypeProvider definitions, Case3MergeResult result, ClusterAnalyzer analyzer) {
					return new Case3ExactMatcher(log, definitions, analyzer, result);
				}
			},
			new Case3MatcherFactory() {
				public Case3Matcher create(LogUI log, SimplifiableTypeProvider provider, Case3MergeResult result, ClusterAnalyzer analyzer) {
					return new Case3ForcedMergedMatcher(log, provider, analyzer, result, new ForcedMatchManager(Case3Simplifier.this.definitions));
				}
			},
			new Case3MatcherFactory() {
				public Case3Matcher create(LogUI log, SimplifiableTypeProvider definitions, Case3MergeResult result, ClusterAnalyzer analyzer) {
					return new Case3FuzzyMatcher(log, definitions, analyzer, result, FuzzQuotient.LEVEL_00);
				}
			},
			new Case3MatcherFactory() {
				public Case3Matcher create(LogUI log, SimplifiableTypeProvider definitions, Case3MergeResult result, ClusterAnalyzer analyzer) {
					return new Case3FuzzyMatcher(log, definitions, analyzer, result, FuzzQuotient.LEVEL_0);
				}
			},
			new Case3MatcherFactory() {
				public Case3Matcher create(LogUI log, SimplifiableTypeProvider definitions, Case3MergeResult result, ClusterAnalyzer analyzer) {
					return new Case3FuzzyMatcher(log, definitions, analyzer, result, FuzzQuotient.LEVEL_1);
				}
			});
	private final SimplifiableDefinitions definitions;
	
	
	public Case3Simplifier(LogUI log,SimplifiableDefinitions definitions) {
		this(log, definitions, new Case3MergeResult());
	}
	Case3Simplifier(LogUI log, SimplifiableDefinitions definitions, Case3MergeResult mergeResult) {
		this.log = log;
		this.definitions = definitions;
		this.mergeResult = mergeResult;
	}
	public void execute() throws GeneratorException {
		createMatchResult();
	}
	private void markDefinitions() {
		for (MergedTypeDescriptor descriptor : this.mergeResult.getDescriptors()) {
			for (TypeName originalName : descriptor.getMergedTypes()) {
				SimplifiableType type = this.definitions.getType(originalName.getName());
				for (TypeName mergedName : descriptor.getMergedTypes()) {
					SimplifiableType mergedType = this.definitions.getType(mergedName.getName());
					type.setMergedTypeName(descriptor.getNewName());
					type.getMergedWithTypes().add(mergedType);
				}
			}
		}
	}
	/**
	 * <p>Walk through each of the matching approaches to populate the merge result.
	 * 
	 * <p>First, we look for exact matches, progressively matching each type against
	 * all possible other types until matching produces no changes.
	 */
	private void createMatchResult() {
		for (Case3MatcherFactory factory : this.factories) {
			createMatchResult(factory);
		}
	}
	private void createMatchResult(Case3MatcherFactory factory) {
		this.mergeResult.initialize(this.definitions);
		boolean repeat = false;
		SimplifiableTypeProvider provider = OrderedSimplifiableTypeProvider.create(this.definitions);
		
		ClusterAnalyzer analyzer = new ClusterAnalyzer();
		analyzer.analyze(this.definitions.getAllTypes());
		do {
			Case3Matcher matcher = factory.create(this.log, provider, this.mergeResult, analyzer);
			this.log.log(INFO, "Simplification case 3: " + matcher.getDescription());
			repeat = matcher.matchAllTypes();
			markDefinitions();
		} while (repeat);
	}
}
