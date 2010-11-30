package ca.infoway.messagebuilder.generator.java;

interface Fuzziness {
	boolean isWorthChecking(SimplifiableType type, SimplifiableType otherType);
}
