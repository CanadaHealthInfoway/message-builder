package ca.infoway.messagebuilder.acceptance.metrics;

public enum AcceptanceTestCoreType {
	
	RUN_STARTED("acceptanceTestsMetrics.runStarted"),
	RUN_ENDED("acceptanceTestsMetrics.runEnded"),
	GROUP_METRICS("acceptanceTestsMetrics.acceptanceTestGroupMetrics"),
	TEST_METRICS("acceptanceTestsMetrics.acceptanceTestMetrics");
	
	private String coreTypeLiteral;
	
	public String getCoreTypeLiteral() {
		return this.coreTypeLiteral;
	}

	public boolean equalsLiteral(String literal) {
		return this.getCoreTypeLiteral().equals(literal);
	}
	
	private AcceptanceTestCoreType(String coreTypeLiteral) {
		this.coreTypeLiteral = coreTypeLiteral;
	}
	
}
