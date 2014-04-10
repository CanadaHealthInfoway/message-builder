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
package ca.infoway.messagebuilder.util.messagegenerator;

import static ca.infoway.messagebuilder.datatype.StandardDataType.AD_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.AD_FULL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.AD_SEARCH;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ANY;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ANY_CA_IZ;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ANY_LAB;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ANY_PATH;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ANY_X1;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ANY_X2;
import static ca.infoway.messagebuilder.datatype.StandardDataType.BL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CD;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CD_LAB;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CV;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ED;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ED_DOC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ED_DOC_OR_REF;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ED_DOC_REF;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ED_REF;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ED_SIGNATURE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.GTS_BOUNDEDPIVL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_BUS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_BUSVER;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_BUS_AND_VER;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_OID;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_PUBLIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_PUBLICVER;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_TOKEN;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_VER;
import static ca.infoway.messagebuilder.datatype.StandardDataType.INT;
import static ca.infoway.messagebuilder.datatype.StandardDataType.INT_NONNEG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.INT_POS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_DATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_DATETIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_FULL_DATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_FULL_DATE_PART_TIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_FULL_DATE_TIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_FULL_DATE_WITH_TIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_HIGH_TS_FULLDATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_LOW_TS_DATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_LOW_TS_FULLDATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_PQ_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_PQ_DISTANCE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_PQ_DRUG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_PQ_HEIGHTWEIGHT;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_PQ_LAB;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_PQ_TIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.IVL_WIDTH_TS_FULLDATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.MO_CAD;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ON;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PIVL_TS_DATETIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PN;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PN_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PN_FULL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PN_SEARCH;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PN_SIMPLE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DISTANCE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_DRUG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_HEIGHTWEIGHT;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_LAB;
import static ca.infoway.messagebuilder.datatype.StandardDataType.PQ_TIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.REAL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.REAL_CONF;
import static ca.infoway.messagebuilder.datatype.StandardDataType.REAL_COORD;
import static ca.infoway.messagebuilder.datatype.StandardDataType.RTO_MO_CAD_PQ_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.RTO_PQ_DRUG_PQ_DRUG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.RTO_PQ_DRUG_PQ_TIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.SC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ST;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ST_LANG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_ALL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_EMAIL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_PHONE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_PHONEMAIL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_URI;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TN;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_DATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_DATETIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_FULLDATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_FULLDATEPARTTIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_FULLDATETIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_FULLDATEWITHTIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.URG_PQ_BASIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.URG_PQ_DISTANCE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.URG_PQ_DRUG;
import static ca.infoway.messagebuilder.datatype.StandardDataType.URG_PQ_HEIGHTWEIGHT;
import static ca.infoway.messagebuilder.datatype.StandardDataType.URG_PQ_LAB;
import static ca.infoway.messagebuilder.datatype.StandardDataType.URG_PQ_TIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.URG_TS_DATE;
import static ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType.STREET_NAME;
import static ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse.HOME;
import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.PLAIN_TEXT;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.time.DateUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.util.UncertainRangeFactory;
import ca.infoway.messagebuilder.domainvalue.basic.Country;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.domainvalue.basic.State;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.X_DistanceObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.basic.X_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.basic.X_HeightOrWeightObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.j5goodies.DateUtil;

/**
 * @sharpen.ignore sample message generator is for MB Java only
 */
@SuppressWarnings("deprecation")
public class DefaultDataTypeValueStore extends DataTypeValueStoreImpl {

	// TODO - not able to set meta data with this approach (modify to have bean containing the property passed in?)

	public DefaultDataTypeValueStore() {
		super();
		setupAbstractMappings();
		createAddressValues();
		createAnyValues();
		createBooleanValues();
		createEntityNameValues();
		createIdentifierValues();
		createStringValues();
		createEdValues();
		createIntervalValues();
		createPhysicalQuantityValues();
		createMoneyValues();
		createNumberValues();
		createTimestampValues();
		creatTelecomValues();
		createUncertainRangeValues();
		createScValues();
		createPivlValues();
		createRatioValues();
		createCodeValues();

		// these values are in the StandardDataType enum but are not used in MIFs as datatypes (at least, not in the pan-Canadian standards)
		
//		this.addValue(AD, value);
//		this.addValue(EN, value);
//		this.addValue(QTY, value);
//		this.addValue(MO, value);
//		this.addValue(PIVL, value);
//		this.addValue(SXPR, value);
//		this.addValue(SXCM, value);
//		this.addValue(URL, value);
//		this.addValue(RTO, value);
//		this.addValue(URG, value);
//		this.addValue(PQ, value);
//		this.addValue(IVL_PQ, value);
//		this.addValue(GTS, value);
//		this.addValue(IVL, value);
//		this.addValue(IVL_TS, value);
//		this.addValue(IVL_WIDTH, value);
//		this.addValue(IVL_LOW, value);
//		this.addValue(IVL_HIGH, value);
//		this.addValue(TEL, value);
//		this.addValue(URG_PQ, value);
//		this.addValue(PIVL_TS_FULLDATETIME, pivl);
	}

	private void createCodeValues() {
		this.addValue(CV, "cv_code");
		this.addValue(CD, "cd_code");
		this.addValue(CD_LAB, "cd.lab_code");
		this.addValue(CE, "ce_code");
		this.addValue(CS, "cs_code");
	}

	private void createRatioValues() {
		Ratio<PhysicalQuantity, PhysicalQuantity> ratioDrugDrug = new Ratio<PhysicalQuantity, PhysicalQuantity>();
		ratioDrugDrug.setNumerator(new PhysicalQuantity(new BigDecimal("1"), ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.GRAM));
		ratioDrugDrug.setDenominator(new PhysicalQuantity(new BigDecimal("2"), ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.GRAM));

		Ratio<PhysicalQuantity, PhysicalQuantity> ratioDrugTime = new Ratio<PhysicalQuantity, PhysicalQuantity>();
		ratioDrugTime.setNumerator(new PhysicalQuantity(new BigDecimal("1"), ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIGRAM));
		ratioDrugTime.setDenominator(new PhysicalQuantity(new BigDecimal("2"), ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.DAY));

        Ratio<Money, PhysicalQuantity> ratioMoPq = new Ratio<Money, PhysicalQuantity> ();
        ratioMoPq.setNumerator(new Money(new BigDecimal("1.00"), Currency.CANADIAN_DOLLAR));
        ratioMoPq.setDenominator(new PhysicalQuantity(new BigDecimal("10.00"), UnitsOfMeasureCaseSensitive.MILLILITRE));

        this.addValue(RTO_PQ_DRUG_PQ_DRUG, ratioDrugDrug);
		this.addValue(RTO_PQ_DRUG_PQ_TIME, ratioDrugTime);
		this.addValue(RTO_MO_CAD_PQ_BASIC, ratioMoPq);
	}

	private void createPivlValues() {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriod(new DateDiff(new PhysicalQuantity(new BigDecimal("3"), DefaultTimeUnit.DAY))));

		this.addValue(GTS_BOUNDEDPIVL, gts);

		PeriodicIntervalTime pivl = PeriodicIntervalTime.createFrequency(3, new PhysicalQuantity(new BigDecimal("1"), DefaultTimeUnit.DAY));
		
		this.addValue(PIVL_TS_DATETIME, pivl);
	}

	private void createScValues() {
		this.addValue(SC, new CodedString<Code>("an SC string", this.codeResolver.lookup(Code.class, "an SC code")));
	}

	private void createUncertainRangeValues() {
		Interval<Date> dateUrg = IntervalFactory.createLowHigh(DateUtil.getDate(1997, 5, 19), DateUtil.getDate(2005, 9, 21));
		this.addValue(URG_TS_DATE, dateUrg);
		
		UncertainRange<PhysicalQuantity> urgPqBasic = UncertainRangeFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("11.2"), UnitsOfMeasureCaseSensitive.FOOT), new PhysicalQuantity(new BigDecimal("15.2"), UnitsOfMeasureCaseSensitive.FOOT));
		UncertainRange<PhysicalQuantity> urgPqDrug = UncertainRangeFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("13.3"), X_DrugUnitsOfMeasure.CUP), new PhysicalQuantity(new BigDecimal("26.3"), X_DrugUnitsOfMeasure.CUP));
		UncertainRange<PhysicalQuantity> urgPqTime = UncertainRangeFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("26.2"), DefaultTimeUnit.DAY), new PhysicalQuantity(new BigDecimal("39.2"), DefaultTimeUnit.DAY));
		UncertainRange<PhysicalQuantity> urgPqLab = UncertainRangeFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("477.2"), UnitsOfMeasureCaseSensitive.GRAM), new PhysicalQuantity(new BigDecimal("5277.2"), UnitsOfMeasureCaseSensitive.GRAM));
		UncertainRange<PhysicalQuantity> urgPqHeightWeight = UncertainRangeFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("1144.1"), X_HeightOrWeightObservationUnitsOfMeasure.POUND), new PhysicalQuantity(new BigDecimal("2148.1"), X_HeightOrWeightObservationUnitsOfMeasure.POUND));
		UncertainRange<PhysicalQuantity> urgPqDistance = UncertainRangeFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("161.2"), X_DistanceObservationUnitsOfMeasure.MILE), new PhysicalQuantity(new BigDecimal("2161.2"), X_DistanceObservationUnitsOfMeasure.MILE));

		this.addValue(URG_PQ_BASIC, urgPqBasic);
		this.addValue(URG_PQ_DRUG, urgPqDrug);
		this.addValue(URG_PQ_TIME, urgPqTime);
		this.addValue(URG_PQ_LAB, urgPqLab);
		this.addValue(URG_PQ_HEIGHTWEIGHT, urgPqHeightWeight);
		this.addValue(URG_PQ_DISTANCE, urgPqDistance);
	}

	private void creatTelecomValues() {
		this.addValue(TEL_PHONE, new TelecommunicationAddress(URLScheme.TEL, "4167620032"));
		this.addValue(TEL_PHONE, new TelecommunicationAddress(URLScheme.TEL, "9053458876"));
		this.addValue(TEL_PHONE, new TelecommunicationAddress(URLScheme.TEL, "4168123444"));
		this.addValue(TEL_EMAIL, new TelecommunicationAddress(URLScheme.MAILTO, "postmaster@chi.ca"));
		this.addValue(TEL_EMAIL, new TelecommunicationAddress(URLScheme.MAILTO, "info@gov.ca"));
		this.addValue(TEL_EMAIL, new TelecommunicationAddress(URLScheme.MAILTO, "general@delivery.com"));
		this.addValue(TEL_URI, new TelecommunicationAddress(URLScheme.HTTP, "192.168.2.1"));
		this.addValue(TEL_URI, new TelecommunicationAddress(URLScheme.HTTP, "192.168.66.888"));
		this.addValue(TEL_URI, new TelecommunicationAddress(URLScheme.HTTP, "192.168.44.111"));
		this.addValue(TEL_ALL, new TelecommunicationAddress(URLScheme.TEL, "4162226789"));
		this.addValue(TEL_ALL, new TelecommunicationAddress(URLScheme.TEL, "9025653333"));
		this.addValue(TEL_ALL, new TelecommunicationAddress(URLScheme.TEL, "9051234566"));
		this.addValue(TEL_PHONEMAIL, new TelecommunicationAddress(URLScheme.TEL, "4169876543"));
		this.addValue(TEL_PHONEMAIL, new TelecommunicationAddress(URLScheme.TEL, "4161122334"));
		this.addValue(TEL_PHONEMAIL, new TelecommunicationAddress(URLScheme.TEL, "4167766554"));
	}

	private void createTimestampValues() {
		Date date = DateUtil.getDate(2007, 2, 19, 8, 27, 30, 25);
		
		this.addValue(TS, date);
		this.addValue(TS_DATE, date);
		this.addValue(TS_DATETIME, date);
		this.addValue(TS_FULLDATE, date);
		this.addValue(TS_FULLDATETIME, date);
		this.addValue(TS_FULLDATEWITHTIME, date);
		this.addValue(TS_FULLDATEPARTTIME, date);
	}

	private void createNumberValues() {
		this.addValue(INT, 123);
		this.addValue(INT, 1);
		this.addValue(INT, 3);
		this.addValue(INT_NONNEG, 888);
		this.addValue(INT_NONNEG, 5);
		this.addValue(INT_NONNEG, 77);
		this.addValue(INT_POS, 16);
		this.addValue(INT_POS, 17);
		this.addValue(INT_POS, 18);
		
		this.addValue(REAL, new BigDecimal("1.234"));
		this.addValue(REAL, new BigDecimal("1.7"));
		this.addValue(REAL, new BigDecimal("66.543"));
		this.addValue(REAL_COORD, new BigDecimal("1234.5678"));
		this.addValue(REAL_COORD, new BigDecimal("1221.5665"));
		this.addValue(REAL_COORD, new BigDecimal("1233.4444"));
		this.addValue(REAL_CONF, new BigDecimal("0.1122"));
		this.addValue(REAL_CONF, new BigDecimal("0.3344"));
		this.addValue(REAL_CONF, new BigDecimal("0.5566"));
	}

	private void createMoneyValues() {
		this.addValue(MO_CAD, new Money(new BigDecimal("75.34"), Currency.CANADIAN_DOLLAR));
		this.addValue(MO_CAD, new Money(new BigDecimal("10324.11"), Currency.CANADIAN_DOLLAR));
		this.addValue(MO_CAD, new Money(new BigDecimal("9877.01"), Currency.CANADIAN_DOLLAR));
	}

	private void createPhysicalQuantityValues() {
		this.addValue(PQ_BASIC, new PhysicalQuantity(new BigDecimal("31.2"), UnitsOfMeasureCaseSensitive.CUBIC_MILIMETER));
		this.addValue(PQ_DRUG, new PhysicalQuantity(new BigDecimal("43.3"), X_DrugUnitsOfMeasure.FLUID_OUNCE));
		this.addValue(PQ_TIME, new PhysicalQuantity(new BigDecimal("5.2"), DefaultTimeUnit.HOUR));
		this.addValue(PQ_LAB, new PhysicalQuantity(new BigDecimal("76.2"), UnitsOfMeasureCaseSensitive.MICROGRAM));
		this.addValue(PQ_HEIGHTWEIGHT, new PhysicalQuantity(new BigDecimal("44.1"), X_HeightOrWeightObservationUnitsOfMeasure.KILOGRAM));
		this.addValue(PQ_DISTANCE, new PhysicalQuantity(new BigDecimal("6.2"), X_DistanceObservationUnitsOfMeasure.KILOMETER));
	}

	private void createBooleanValues() {
		this.addValue(BL, Boolean.TRUE);
	}

	private void createIntervalValues() {
		Interval<Date> dateIvl = IntervalFactory.createLowHigh(DateUtil.getDate(1977, 4, 22), DateUtil.getDate(2013, 8, 14));
		this.addValue(IVL_DATE, dateIvl);
		this.addValue(IVL_DATETIME, dateIvl);
		this.addValue(IVL_FULL_DATE, dateIvl);
		this.addValue(IVL_FULL_DATE_TIME, dateIvl);
		this.addValue(IVL_FULL_DATE_PART_TIME, dateIvl);
		this.addValue(IVL_FULL_DATE_WITH_TIME, dateIvl);
		
		Interval<Date> dateHigh = IntervalFactory.createHigh(DateUtil.getDate(2014, 1, 8));
		this.addValue(IVL_HIGH_TS_FULLDATE, dateHigh);
		
		Interval<Date> dateLow = IntervalFactory.createLow(DateUtil.getDate(2014, 2, 27));
		this.addValue(IVL_LOW_TS_DATE, dateLow);
		this.addValue(IVL_LOW_TS_FULLDATE, dateLow);
		
		Diff<Date> diff = new Diff<Date>(new Date(15 * DateUtils.MILLIS_PER_DAY));
		Interval<Date> dateWidth = IntervalFactory.<Date>createWidth(diff);
		this.addValue(IVL_WIDTH_TS_FULLDATE, dateWidth);
		
		Interval<PhysicalQuantity> ivlPqBasic = IntervalFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("1.2"), UnitsOfMeasureCaseSensitive.FOOT), new PhysicalQuantity(new BigDecimal("5.2"), UnitsOfMeasureCaseSensitive.FOOT));
		Interval<PhysicalQuantity> ivlPqDrug = IntervalFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("3.3"), X_DrugUnitsOfMeasure.CUP), new PhysicalQuantity(new BigDecimal("6.3"), X_DrugUnitsOfMeasure.CUP));
		Interval<PhysicalQuantity> ivlPqTime = IntervalFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("6.2"), DefaultTimeUnit.DAY), new PhysicalQuantity(new BigDecimal("9.2"), DefaultTimeUnit.DAY));
		Interval<PhysicalQuantity> ivlPqLab = IntervalFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("77.2"), UnitsOfMeasureCaseSensitive.GRAM), new PhysicalQuantity(new BigDecimal("277.2"), UnitsOfMeasureCaseSensitive.GRAM));
		Interval<PhysicalQuantity> ivlPqHeightWeight = IntervalFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("144.1"), X_HeightOrWeightObservationUnitsOfMeasure.POUND), new PhysicalQuantity(new BigDecimal("148.1"), X_HeightOrWeightObservationUnitsOfMeasure.POUND));
		Interval<PhysicalQuantity> ivlPqDistance = IntervalFactory.createLowHigh(new PhysicalQuantity(new BigDecimal("61.2"), X_DistanceObservationUnitsOfMeasure.MILE), new PhysicalQuantity(new BigDecimal("161.2"), X_DistanceObservationUnitsOfMeasure.MILE));
		
		this.addValue(IVL_PQ_BASIC, ivlPqBasic);
		this.addValue(IVL_PQ_DRUG, ivlPqDrug);
		this.addValue(IVL_PQ_TIME, ivlPqTime);
		this.addValue(IVL_PQ_LAB, ivlPqLab);
		this.addValue(IVL_PQ_HEIGHTWEIGHT, ivlPqHeightWeight);
		this.addValue(IVL_PQ_DISTANCE, ivlPqDistance);
	}

	private void createEdValues() {
		EncapsulatedData edWithRef = new EncapsulatedData(PLAIN_TEXT, "http://www.google.ca", null, "this is some text & some \"more\"".getBytes());
		EncapsulatedData edRefOnly = new EncapsulatedData(PLAIN_TEXT, "http://www.google.ca", null, null);
		String edSig = "this is a signature";
		
		this.addValue(ED, edWithRef);
		this.addValue(ED_DOC, edWithRef);
		this.addValue(ED_REF, edRefOnly);
		this.addValue(ED_DOC_REF, edRefOnly);
		this.addValue(ED_SIGNATURE, edSig);
		this.addValue(ED_DOC_OR_REF, edWithRef);
	}

	private void createStringValues() {
		this.addValue(ST, "a descriptive string");
		this.addValue(ST, "some example text");
		this.addValue(ST, "an example of descriptive text");
		this.addValue(ST_LANG, "a descriptive string (language)");
		this.addValue(ST_LANG, "some example text (language)");
		this.addValue(ST_LANG, "an example of descriptive text (language)");
	}

	private void createIdentifierValues() {
		this.addValue(II, new Identifier("1.2.3.4", "II value"));
		this.addValue(II_BUS, new Identifier("1.2.3.5", "II.BUS value"));
		this.addValue(II_PUBLIC, new Identifier("1.2.3.6", "II.PUBLIC value"));
		this.addValue(II_OID, new Identifier("1.2.3.7", "II.OID value"));
		this.addValue(II_PUBLICVER, new Identifier("1.2.3.8", "II.PUBLICVER value"));
		this.addValue(II_BUSVER, new Identifier("1.2.3.9", "II.BUSVER value"));
		this.addValue(II_TOKEN, new Identifier(UUID.randomUUID().toString()));
		this.addValue(II_VER, new Identifier(UUID.randomUUID().toString()));
		this.addValue(II_BUS_AND_VER, new Identifier("1.2.2.2", "II.BUS_AND_VER value"));
	}

	private void setupAbstractMappings() {
		abstractMapping.put(ANY, StandardDataType.ST);
		abstractMapping.put(ANY_LAB, StandardDataType.ST);
		abstractMapping.put(ANY_CA_IZ, StandardDataType.ST);
		abstractMapping.put(ANY_PATH, StandardDataType.ST);
		abstractMapping.put(ANY_X1, StandardDataType.ST);
		abstractMapping.put(ANY_X2, StandardDataType.ST);
		abstractMapping.put(II_BUS_AND_VER, StandardDataType.II_BUS);
		abstractMapping.put(ED_DOC_OR_REF, StandardDataType.ED_DOC);
		abstractMapping.put(IVL_FULL_DATE_PART_TIME, StandardDataType.IVL_FULL_DATE_TIME);
		abstractMapping.put(IVL_FULL_DATE_WITH_TIME, StandardDataType.IVL_FULL_DATE_TIME);
		abstractMapping.put(TS_FULLDATEWITHTIME, StandardDataType.TS_FULLDATETIME);
		abstractMapping.put(TS_FULLDATEPARTTIME, StandardDataType.TS_FULLDATETIME);
		abstractMapping.put(TEL_ALL, StandardDataType.TEL_PHONE);
		abstractMapping.put(TEL_PHONEMAIL, StandardDataType.TEL_PHONE);
	}
	
	private void createEntityNameValues() {
		this.addValue(ON, createOrganizationName("Canada Health Infoway"));
		this.addValue(ON, createOrganizationName("Acme Products"));
		this.addValue(ON, createOrganizationName("Intelliware Development Ltd."));
		
		this.addValue(TN, new TrivialName("John Smith"));
		this.addValue(TN, new TrivialName("Alistair Crowely"));
		this.addValue(TN, new TrivialName("Howard Lovecraft"));
		
		PersonName name1 = PersonName.createFirstNameLastName("Bob", "McAnulty");
		PersonName name2 = PersonName.createFirstNameLastName("Allison", "Johnson");
		PersonName name3 = PersonName.createFirstNameLastName("Jack", "Simpson");
		
		this.addValue(PN, name1);
		this.addValue(PN, name2);
		this.addValue(PN, name3);
		this.addValue(PN_BASIC, name1);
		this.addValue(PN_BASIC, name2);
		this.addValue(PN_BASIC, name3);
		this.addValue(PN_SIMPLE, name1);
		this.addValue(PN_SIMPLE, name2);
		this.addValue(PN_SIMPLE, name3);
		this.addValue(PN_FULL, name1);
		this.addValue(PN_FULL, name2);
		this.addValue(PN_FULL, name3);
		this.addValue(PN_SEARCH, name1);
		this.addValue(PN_SEARCH, name2);
		this.addValue(PN_SEARCH, name3);
	}

	private void createAnyValues() {
		this.addValue(ANY, "string value for ANY");
		this.addValue(ANY_LAB, "string value for ANY_LAB");
		this.addValue(ANY_CA_IZ, "string value for ANY_CA_IZ");
		this.addValue(ANY_PATH, "string value for ANY_PATH");
		this.addValue(ANY_X1, "string value for ANY_X1");
		this.addValue(ANY_X2, "string value for ANY_X2");
	}

	private void createAddressValues() {
		this.addValue(AD_BASIC, createBasicPostalAddress("146 Yonge Street"));
		this.addValue(AD_BASIC, createBasicPostalAddress("17 Reynard Way"));
		this.addValue(AD_BASIC, createBasicPostalAddress("199 Frenchman's Creek"));
		
		this.addValue(AD_SEARCH, createSearchPostalAddress("Ottawa"));
		this.addValue(AD_SEARCH, createSearchPostalAddress("Deep River"));
		this.addValue(AD_SEARCH, createSearchPostalAddress("Brampton"));

		this.addValue(AD_FULL, createPostalAddress("Yonge"));
		this.addValue(AD_FULL, createPostalAddress("Richmond"));
		this.addValue(AD_FULL, createPostalAddress("Keele"));
	}

	private Object createOrganizationName(String organizationName) {
		OrganizationName orgName = new OrganizationName();
		orgName.addNamePart(new EntityNamePart(organizationName));
		return orgName;
	}
	
	private PostalAddress createPostalAddress(String streetName) {
		PostalAddress address1 = new PostalAddress();
		address1.addUse(HOME);
		address1.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.HOUSE_NUMBER, "123"));
		address1.addPostalAddressPart(new PostalAddressPart(STREET_NAME, streetName));
		address1.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "Toronto"));
		return address1;
	}

	private PostalAddress createBasicPostalAddress(String streetAndNumber) {
		PostalAddress address = createSearchPostalAddress("Toronto");
		address.addUse(X_BasicPostalAddressUse.HOME);
		address.getParts().add(0, new PostalAddressPart(streetAndNumber));
		address.addPostalAddressPart(new PostalAddressPart("c/o general delivery"));
		return address;
	}
	
	private PostalAddress createSearchPostalAddress(String city) {
		PostalAddress address = new PostalAddress();
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, city));
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, State.ONTARIO));
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "H0H0H0"));
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, Country.CANADA));
		return address;
	}
}
