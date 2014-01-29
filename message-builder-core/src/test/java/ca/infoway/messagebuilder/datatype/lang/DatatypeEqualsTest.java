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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.datatype.lang;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.OrganizationNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;

public class DatatypeEqualsTest {
	
    @Test
    public void TestTrivialNameEquals()
    {
        TrivialName trivialName1 = new TrivialName("aName");
        trivialName1.addUse(EntityNameUse.PHONETIC);

        TrivialName trivialName2 = new TrivialName("aName");
        trivialName2.addUse(EntityNameUse.PHONETIC);

        Assert.assertEquals(trivialName1, trivialName2);
    }

    @Test
    public void TestTelecomAddressEquals()
    {
        TelecommunicationAddress telecomAddress1 = new TelecommunicationAddress();
        telecomAddress1.setAddress("192.168.0.27");
        telecomAddress1.setUrlScheme(URLScheme.HTTP);
        telecomAddress1.addAddressUse(TelecommunicationAddressUse.ANSWERING_MACHINE);

        TelecommunicationAddress telecomAddress2 = new TelecommunicationAddress();
        telecomAddress2.setAddress("192.168.0.27");
        telecomAddress2.setUrlScheme(URLScheme.HTTP);
        telecomAddress2.addAddressUse(TelecommunicationAddressUse.ANSWERING_MACHINE);

        Assert.assertEquals(telecomAddress1, telecomAddress2);
    }

    @Test
    public void TestPhysicalQuantityEquals()
    {
        PhysicalQuantity pq1 = new PhysicalQuantity(new BigDecimal(1.5), UnitsOfMeasureCaseSensitive.CENTIMETRE);

        PhysicalQuantity pq2 = new PhysicalQuantity(new BigDecimal(1.5), UnitsOfMeasureCaseSensitive.CENTIMETRE);

        Assert.assertEquals(pq1, pq2);
    }

    @Test
    public void TestOrganizationNameEquals()
    {
        OrganizationName orgName1 = new OrganizationName();
        orgName1.addUse(EntityNameUse.LEGAL);
        orgName1.addNamePart(new EntityNamePart("aName", OrganizationNamePartType.PREFIX, "aQualifier"));

        OrganizationName orgName2 = new OrganizationName();
        orgName2.addUse(EntityNameUse.LEGAL);
        orgName2.addNamePart(new EntityNamePart("aName", OrganizationNamePartType.PREFIX, "aQualifier"));

        Assert.assertEquals(orgName1, orgName2);
    }

    @Test
    public void TestPersonNameEquals()
    {
        PersonName personName1 = new PersonName();
        personName1.addUse(EntityNameUse.LEGAL);
        personName1.addNamePart(new EntityNamePart("aName", PersonNamePartType.FAMILY, "aQualifier"));

        PersonName personName2 = new PersonName();
        personName2.addUse(EntityNameUse.LEGAL);
        personName2.addNamePart(new EntityNamePart("aName", PersonNamePartType.FAMILY, "aQualifier"));

        Assert.assertEquals(personName1, personName2);
    }

    @Test
    public void TestPostalAddressEquals()
    {
        PostalAddress address1 = new PostalAddress();
        address1.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CARE_OF, "careOfPlace"));
        address1.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "aCity"));
        address1.addUse(X_BasicPostalAddressUse.HOME);
        address1.addUse(X_BasicPostalAddressUse.TEMPORARY);

        PostalAddress address2 = new PostalAddress();
        address2.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CARE_OF, "careOfPlace"));
        address2.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "aCity"));
        address2.addUse(X_BasicPostalAddressUse.HOME);
        address2.addUse(X_BasicPostalAddressUse.TEMPORARY);

        Assert.assertEquals(address1, address2);
    }

    @Test
    public void TestIdentiferEquals()
    {
        Identifier id1 = new Identifier("aRoot", "anExtension", "aVersion");
        Identifier id2 = new Identifier("aRoot", "anExtension", "aVersion");
        Assert.assertEquals(id1, id2);
    }

    @Test
    public void TestDateEquals()
    {
        Date date1 = new Date(12345);
        Date date2 = new Date(12345);
        Assert.assertEquals(date1, date2);
    }

    @Test
    public void TestMoneyEquals()
    {
        Money money1 = new Money(new BigDecimal(3.21), Currency.CANADIAN_DOLLAR);
        Money money2 = new Money(new BigDecimal(3.21), Currency.CANADIAN_DOLLAR);
        Assert.assertEquals(money1, money2);
    }

    @Test
    public void TestRatioEquals()
    {
        PhysicalQuantity pq1a = new PhysicalQuantity(new BigDecimal(1.5), UnitsOfMeasureCaseSensitive.CENTIMETRE);
        PhysicalQuantity pq1b = new PhysicalQuantity(new BigDecimal(1.46), UnitsOfMeasureCaseSensitive.CUBIC_MILIMETER);
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio1 = new Ratio<PhysicalQuantity, PhysicalQuantity>(pq1a, pq1b);

        PhysicalQuantity pq2a = new PhysicalQuantity(new BigDecimal(1.5), UnitsOfMeasureCaseSensitive.CENTIMETRE);
        PhysicalQuantity pq2b = new PhysicalQuantity(new BigDecimal(1.46), UnitsOfMeasureCaseSensitive.CUBIC_MILIMETER);
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio2 = new Ratio<PhysicalQuantity, PhysicalQuantity>(pq2a, pq2b);

        Assert.assertEquals(ratio1, ratio2);
    }

    @Test
    public void TestIntervalEquals()
    {
        Interval<Date> interval1 = IntervalFactory.createLowHigh(new Date(1234), new Date(5678));
        Interval<Date> interval2 = IntervalFactory.createLowHigh(new Date(1234), new Date(5678));

        Assert.assertEquals(interval1, interval2);
    }

    @Test
    public void TestPivlEquals()
    {
        PeriodicIntervalTime pivl1 = PeriodicIntervalTime.createPeriodPhase(
                new DateDiff(new PhysicalQuantity(new BigDecimal(4), UnitsOfMeasureCaseSensitive.DAY)),
                IntervalFactory.createLowHigh(new Date(1234), new Date(5678))
            );

        PeriodicIntervalTime pivl2 = PeriodicIntervalTime.createPeriodPhase(
                new DateDiff(new PhysicalQuantity(new BigDecimal(4), UnitsOfMeasureCaseSensitive.DAY)),
                IntervalFactory.createLowHigh(new Date(1234), new Date(5678))
            );

        Assert.assertEquals(pivl1, pivl2);

        pivl1 = PeriodicIntervalTime.createFrequency(5, new PhysicalQuantity(new BigDecimal(4), UnitsOfMeasureCaseSensitive.DAY));
        pivl2 = PeriodicIntervalTime.createFrequency(5, new PhysicalQuantity(new BigDecimal(4), UnitsOfMeasureCaseSensitive.DAY));

        Assert.assertEquals(pivl1, pivl2);
    }

    @Test
    public void TestGtsEquals()
    {
        PeriodicIntervalTime pivl1 = PeriodicIntervalTime.createPeriodPhase(
                new DateDiff(new PhysicalQuantity(new BigDecimal(4), UnitsOfMeasureCaseSensitive.DAY)),
                IntervalFactory.createLowHigh(new Date(1234), new Date(5678))
            );
        GeneralTimingSpecification gts1 = new GeneralTimingSpecification(IntervalFactory.createLowHigh(new Date(2222), new Date(3333)), pivl1);


        PeriodicIntervalTime pivl2 = PeriodicIntervalTime.createPeriodPhase(
                new DateDiff(new PhysicalQuantity(new BigDecimal(4), UnitsOfMeasureCaseSensitive.DAY)),
                IntervalFactory.createLowHigh(new Date(1234), new Date(5678))
            );
        GeneralTimingSpecification gts2 = new GeneralTimingSpecification(IntervalFactory.createLowHigh(new Date(2222), new Date(3333)), pivl2);

        Assert.assertEquals(gts1, gts2);
    }

    @Test
    public void TestCodedStringEquals()
    {
        CodedString<ca.infoway.messagebuilder.domainvalue.ActStatus> cs1 = new CodedString<ca.infoway.messagebuilder.domainvalue.ActStatus>("111", ActStatus.CANCELLED, "222", "333", "444");
        CodedString<ca.infoway.messagebuilder.domainvalue.ActStatus> cs2 = new CodedString<ca.infoway.messagebuilder.domainvalue.ActStatus>("111", ActStatus.CANCELLED, "222", "333", "444");

        Assert.assertEquals(cs1, cs2);
    }

}
