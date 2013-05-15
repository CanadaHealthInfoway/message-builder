/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.datatype.lang;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.datatype.lang.util.Currency;

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
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
			    .append(this.amount)
			    .append(this.currency)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((Money) obj);
        }
    }
    
    private boolean equals(Money that) {
        return new EqualsBuilder()
                .append(this.amount, that.amount)
                .append(this.currency, that.currency)
                .isEquals();
    }
    
}
