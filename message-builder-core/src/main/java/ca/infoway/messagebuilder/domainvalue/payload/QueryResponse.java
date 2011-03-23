package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum QueryResponse. Values in this domain allow a query response system to return a precise response status.
 */
public class QueryResponse extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.QueryResponse {

	private static final long serialVersionUID = -6211467438802392184L;
	
	public static final QueryResponse APPLICATION_ERROR = new QueryResponse("APPLICATION_ERROR", "AE", true);
	public static final QueryResponse NO_DATA_FOUND = new QueryResponse("NO_DATA_FOUND", "NF", false);
	public static final QueryResponse DATA_FOUND = new QueryResponse("DATA_FOUND", "OK", false);
	public static final QueryResponse QUERY_PARAMETER_ERROR = new QueryResponse("QUERY_PARAMETER_ERROR", "QE", true);
	
	private final String codeValue;
	private final boolean error;

	private QueryResponse(String name, String codeValue, boolean error) {
		super(name);
		this.codeValue = codeValue;
		this.error = error;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_QUERY_RESPONSE.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
	
	/**
	 * <p>Checks if is error.
	 *
	 * @return true, if is error
	 */
	public boolean isError() {
		return this.error;
	}
}
