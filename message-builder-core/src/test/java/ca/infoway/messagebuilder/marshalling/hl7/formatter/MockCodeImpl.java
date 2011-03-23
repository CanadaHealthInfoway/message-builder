/**
 * 
 */
package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.Code;


class MockCodeImpl implements Code {

    private final String codeValue;
    private final String codeSystem;

    public MockCodeImpl(String codeValue, String codeSystem) {
        this.codeValue = codeValue;
        this.codeSystem = codeSystem;
    }
    
    public String getCodeSystem() {
        return this.codeSystem;
    }

    public String getCodeValue() {
        return this.codeValue;
    }
}