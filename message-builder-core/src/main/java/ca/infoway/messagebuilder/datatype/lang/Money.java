package ca.infoway.messagebuilder.datatype.lang;

import java.math.BigDecimal;

/**
 * <p>Java datatype backing the Hl7 Datatype MO (MO.CAD).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class Money {
    
    private final BigDecimal amount;
    private final Currency currency;

    /**
     * <p>Constructs a Money object with the supplied amount and currency. 
     * 
     * @param amount an amount 
     * @param currency a currency
     */
    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    /**
     * <p>Returns the amount.
     * 
     * @return the amount
     */
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    /**
     * <p>Returns the currency.
     * 
     * @return the currency
     */
    public Currency getCurrency() {
        return this.currency;
    }
}
