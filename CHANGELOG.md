# Changelog


## [2.1.3]
### Added
- Eight codes to the AcknowledgementDetailCode enumeration to align it with the current terminology definitions
- Validation to ensure all template parameters are populated in interactions


### Changed
- Performance improvements in run-time engine
- Update message sets to explicitly mark attributes
- If you are upgrading from a previous version (i.e., 1.6 or earlier), please be aware of the following:
  - The following classes were moved from `ca.infoway.messagebuilder.datatype.lang.util` and placed in `ca.infoway.messagebuilder.datatype.lang`:
    - `IntervalFactor`
    - `Identifiable`
    - `IntervalFactory`
    - `IntervalUtil`
    - `NameFormatter`
    - `UncertainRangeFactory`
  - The following classes were moved from `ca.infoway.messagebuilder.marshalling.hl7` and placed in `ca.infoway.messagebuilder.error`:
    - `Hl7Error`
    - `Hl7ErrorCode`
    - `Hl7Errors`
  - Other classes in the generated Message Builder HL7v3 runtime libraries may have been moved as well due to internal changes in the Message Builder Generator. Please use an IDE to re-locate those classes and fix the import statements appropriately in your project.


## [2.1.0]
### Added
- .NET APIs for CDA - Consolidated CDA R1_1, Consolidated CDA R1_1 with Canadian data types, pC CDA document with pC CDA header guideline R1_2
- CDA Code Resolver in .NET supporting CCDA R1.1 vocabulary
- MB CDA .NET HelloWorld project


## [2.0.0]
### Added
- Java APIs for CDA - Consolidated CDA R1_1, Consolidated CDA R1_1 with Canadian data types, pC CDA document with pC CDA header guideline R1_2
- CDA Code Resolver supporting CCDA R1.1 vocabulary
- MB CDA HelloWorld project
- CDA R2 datatypes now supported


### Changed
- error classes have moved (to `ca.infoway.messagebuilder.error`)
- errors now include an error level (INFO, WARNING, ERROR)
- major changes to ED datatype (`ca.infoway.messagebuilder.datatype.lang.EncapsulatedData`)
- validator now uses the transformer directly (instead of duplicating code)


## [1.6.0]
### Added
- Support for the following new HL7v3 releases:
  - NS CeRx R04.03 Drug
  - NS MR2009 R02.04.03 Client Registry, Provider Registry and Location Registry
- Two new HelloWorld projects created for NS (CeRx & MR2009)


### Fixed
- MBR-319 - change Message Element Name from NS to CA; resolve `dosageInstruction/@moodCode` value


## [1.5.9]
### Added
- CDA support


## [1.5.8.1]
### Added
- The following new HL7v3 releases are now supported in Message Builder:
  - AB MR2009 R02.04.03 Client Registry and Provider Registry
  - AB MR2009 R02.04.03 Immunization
  - pan-Canadian MR 02.05
  - pan-Canadian CeRx 4.4
- 20423 - created an interaction walker (Java only)


### Changed
- 20416 - URG changes for BC


### Removed
- unused interactions for AB MR2007 and AB MR2009


## [1.5.8]
### Added
- created a Sample Message Generator (Java only) that uses a generated MB API to create a sample message for a specific interaction or for all interactions
- added new official MB API releases: V01R04.4; R02.05.00; AB PA R02.05.00
- 17375 - Add support for EN abstract datatype
- 18989 - Create a message set validator
- 18988 - Create a utility for checking message sets for "orphaned" message parts

### Fixed
- 18979 - Complex relationship sorting duplicated in three places
- 16129 - Message Bean Transformer for unmarshalling xml (xml -> beans) does not validate cardinality for associations
- 16132 - Unmarshalling xml (xml -> beans) does not validate against relationships that are out of order
- 16130 - Message Bean Transformer for marshalling xml (beans -> xml) does not validate cardinality for associations
- 16131 - Message validator does not validate order of relationships within an element
- 18719 - ST should be able to handle CDATA blocks
- 18070 - When an ANY type is set as a NullFlavor, originalText is not preserved
- 18423 - MB runtime should not necessarily log an error when SpecializationType is unnecessarily provided
- 18422 - MB Runtime should not throw an exception in a situation where logging an error would be more appropriate
- 18323 - Domain type package location is effectively still hardcoded in one place
- 16399 - TS.FULLDATEWITHTIME formatter will incorrectly flag a validation error when no value specified and relationship is not mandatory


## [1.5.6]
### Added
- 16697 [DB RESOLVER] Provide a code demo for the new DB Resolver changes, utilizing an in-memory database
- 17372 [.NET] implement Database Resolver registration utility in .NET
- 18202 [BC] New dataype SC - and alias, SC.CA
- 18194 [BC] Add alias for ST.CA
- 18195 [BC] Add alias for CS.CA
- 18196 [BC] Add alias for CV.CA
- 18197 [BC] implement ANY.x1 and ANY.x2
- 18198 [BC] create new datatype TS.FULLDATEPARTTIME
- 18201 [BC] Implement a cross-release approach to datatype validations
- 18203 [BC] add displayName to CV/CV.CA


### Fixed
- 17048 BC: Parsing issue with HL7 sensitivityObservationEvent
- 17316 Store the release Realm Code and Descriptive Name in a MessageSet
- 17371 [.NET] manual translation required for VocabularyDomain.getTypeAsClasses()
- 17421 Validation errors with no xpath
- 17477 Assigning different colors and adding CSS class for the vocab SVG diagrams
- 17511 Invalid Concept Domains are defined in Message Set
- 18049 Capture concept status from MIF to Message Set
- 18531 [.NET] datatypes are not implementing Equals() correctly


### Removed
- 17524 Remove Java class assignment from Message Set


## [1.5.0]
### Added
- 14452 - Create a Message Builder Java API for ON Drug Message Set
- 14453 - Create a Message Builder .NET API for ON Drug Message Set
- 14561 - Create a helper method for setting specialization type on a collection
- 14581 - Create helper methods for setting null flavor on a collection

### Changed
- All MB message sets and APIs have been re-generated to accomodate Message Remixer v3 changes
  - Some minor coding changes may be required for clients using a MB API as a result of the re-gens


### Fixed
- 14377 - FW: Infoway message builder API 1.4.6 problem [`IVL<TS.FULLDATETIME>` could not be properly specified for an `ANY` type]
- 14562 - CodedString datatype (SC) does not generate properly (not a pan-Canadian standard datatype)
- 14612 - Unexpected console output from MessageBeanTransformerImpl
- 14620 - DRUG_DOCUMENT_QUERY and DRUG_DOCUMENT_QUERY_RESPONSE missing from Ca.Infoway.Messagebuilder.Domainvalue.Transport.HL7TriggerEventCode
- 14644 - Unable to read a message (Can't find a relationship named : component1 on messa gePart named POLB_MT004200BC.ObservationReport) [a Remixer had affected the sort of message elements in rendered xml]
- 14740 - Some formatters and parsers will break when dealing with values provided though the ANY datatype
- 15236 - argument type mismatch [the ActMood enum implemented the ActCode interface instead of the ActMood interface]
- 15390 - Could not find coded value for domain type x_ActMoodDefEvnRqo [the Terminology component had a bug with fixed or CS codes]
- 15393 - Errors validating combinedMedicationRequest.subjectOf3.rxOrderType.moodCode [same as 15390]
- 15395 - Cardinality for telecom fields not validated. [Cardinality now validated for all attribute collections]
- 15419 - no exception if duplicates were specified for the SET<> datatype
- 15431 - MANDATORY_FIELD_NOT_PROVIDED: Attribute "id" is required, but is specified as nullFlavor="NI". [MB now allows NF for all conformances except MANDATORY]
- 15446 - java.lang.ClassCastException [this was caused by a complex generator bug]
- 15915 - Crash in MessageBuilder while generating a Message Set when a vocabulary MIF contains <excludeContent>
filters based on <propertyBasedContent>
- 15929 - MB-generated message does not pass XSD validation [IVL and URG inner elements did not have the correct xsi:type]


### Removed
- 14626 - Drop support for MR2007 V02R01 in Message Builder


## [1.4.6]
### Added
- Runtime and Generator support for .NET
- Sample .Net project


## [1.4.5]
### Added
- Infoway public Maven repository created.  As an option, you can now use Maven to install Message Builder. Please refer to the Download page for more details.


### Changed
- JavaDoc API documentation improvements (including the addition of Class diagrams)
- New User Guide released with more information, guidance, and tips.
- The message validator in Message Builder has been greatly improved and is more "strict" in accordance with with Infoway datatype specifications. As a result, you may notice more validation errors being reported by Message Builder than before.
- The following classes were moved from `ca.infoway.messagebuilder.datatype.lang` and placed in `ca.infoway.messagebuilder.datatype.lang.util`:
  - `Compression`
  - `Currency`
  - `NamePartType`
  - `OrganizationNamePartType`
  - `PersonNamePartType`
  - `PostalAddressPartType`
  - `Representation`
  - `SetOperator`
- The following classes were moved from `ca.infoway.messagebuilder.datatype.lang` and placed in `ca.infoway.messagebuilder.domainvalue.basic`:
  - `Country`
  - `DefaultTimeUnit`
  - `EntityNameUse`
  - `MediaType`
  - `PostalAddressUse`
  - `TelecommunicationAddressUse`
  - `UnitsOfMeasureCaseSensitive`
  - `URLScheme`


### Fixed
- 14145 - MBT does not allow use attribute of PN.BASIC datatype to be specified in CeRx standard


## [1.4.3]
### Changed
- Internal release only
- Minor micellaneous improvements

## [1.4.2]
### Changed
- Internal release only


### Fixed
- 13398 - Message Builder Validator is not reporting certain validations
- 13365 - HL7Error class never displays error path


## [1.4.1]
### Changed
- Internal release only


## [1.4.0]
### Changed
- This release incorporates massive changes to the entire MB validation mechanism (for marshalling and unmarshalling).
- Specifying a version (via the VersionNumber interface) has changed to use a new Hl7BaseVersion enum
- 11316 - Refactor Message Builder datatype validation


### Fixed
- 11430 - [DATATYPE] MBT MR2009 Runtime coremif mismatch.
- 11372 - [DATATYPE] MBT does not validate the II.PUBLIC datatype correctly
- 11322 - [DATATYPE] MBT does not validate various definitions of the AD.BASIC datatype for both CeRx4.3 and MR2009
- 11302 - Ensure lack of coding strength from MIFv2s won't cause problems when marshalling/unmarshalling
- 11297 - [DATATYPE] MBT does not validate various definitions of the PN.BASIC datatype for CeRx4.3
- 11296 - [DATATYPE] MBT does not pick up administrativeGenderCode being null as a problem.
- 11267 - [DATATYPE] Validator gaps (was FW: Mif or MBT CeRx problems)
- 717 - Need to finalize a process for ensuring that we have interfaces for all Domain Values


## [1.3.4.1]
### Added
- Added RimClass To MessagePart
- Added Vocabulary Mif processing
- Generation of Vocabulary Classes (C# and java)
- Added ConformanceLevel.IGNORED (as not allowed and as optional)


### Fixed
- Expanded AnnotationType to include missing types


## [1.3.1]
### Fixed
- 11455 - NullPointerException if unit of measure is null from code-to-XML



## [1.3.0]
### Fixed
- 11271 - NullPointerException if unit of measure is null
- 11293 - `use="BUS"` for MR2009 id fields.
- 11294 - Null Pointer exceptions thrown out of the Validate method
- 11384 - MIF annotations on interactions not picked up when processing MIFv2s
- 11385 - Interaction model has duplicated business name field
- 11386 - MIFv1 annotations not processed properly - subtypes are missing
- 11393 - Core Message Builder project tests fail when run with time zones other than EST


## [1.2.9]
### Fixed
- 11239 - Re-generate SK API using v01r04.2 (hotfix2)
  - We have discovered that there is an error in the previous releases of Infoway Message Builder SK API: the version of CeRX 4.3 used to generate the SK API distributed on the EMR & Integration Wiki (Hotfix 3) is different from the actual version in use by Saskatchewan (Hotfix 2). This error is now corrected in this release. For your convenience, attached "CeRx-EN-Release Notes - V01R04.3 - HOTFIX 3 - 20080814.pdf" is the change log for Hotfix 3. You may wish to review and determine whether this issue will impact you.
  - Please replace your previous release of Message Builder SK API with this release and use SpecificationVersion.V01R04_2_SK instead of SpecificationVersion.V01R04_3_SK in your implementation code.
- 11271 - Fixed NullPointerException when adding physical quanitities using MessageBuilder and the unit of measure is null


## [1.2.8]
### Added
- The first official release of the Message Builder AB API, providing support for AB Provincial Client Registry (MR2007 V02R02) and Session Management.


### Changed
- An updated release of the Message Builder SK API, containing mostly annotation and javadoc changes. Minimal impact is expected for those who upgrade from the previous release of Message Builder.
- 11087 - V01R04.3 API re-generated
- 11078 - V02R01 API re-generated
- 11077 - V02R02 API re-generated


### Fixed
- 10239 - Creation Time value with 3 digits for millisecond now supported via system property using `"messagebuilder.date.format.override.<INSERT_SPECIFIC_VERSION_HERE>"`


## [1.2.7]
### Added
- Support SK CeRx V01R04.3
  - For the Message Builder SK API, the following two constraints were applied by SK which are not included yet in this release of Message Builder (and we are planning to include them in the next release). Therefore, please take notice of them during development:
    - Not allowed to set `ServiceLocationBean` (which is part of the `ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt240003ca` package) as the `Recipient` in `ConsentGivenToBean` (which is part of `ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged` package)
    - The `id` attribute in `ObservationEventBean` (which is part of `ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged` package) has been constrained by SK to "NOT ALLOWED". This means that it will not be emitted in xml nor accepted from xml (even though it is available to set via the Message Builder API, as the class that contains it has been merged with a number of nearly identical classes which do allow the `id` field) .
- Support pCS MR2009 R02.04.03


### Fixed
- 10965 Missing sender sub-elements in some complex cases (AB Session Management messages in particular)
- 10983 Re-generate SK API
- 10990 Relax `II` validation constraints for AB (`SpecializationType` no longer required for `II` fields)


## [1.2.6]
### Added
- 10266 Support pCS MR2009 R02.04.03
- 10293 Create an official release for AB Session Managment API


### Changed
- 1228 Update tutorial applications and related documents
- 1242 Updating hello_world guide and code


### Fixed
- 488 ControlActEvent -> EventType for MedicationPrescriptionDetailQuery (PORX_IN060370CA)
- 1239 hello_world example - NullPointerException in FindCandidatesApp using REST
- 1240 hello_world example - FindCandidatesApp failed to receive a response when using SOAP
- 1466 Setting SpecializationType to a collection object
- 1561 INT.NONNEG Value is changed to 0 if a negative number is given
- 1562 INT.POS Value is not set and no warning/error if a negative number is given
- 1570 PQ.Basic truncation provides no way to know what was the original value
- 1624 [SASK feature] Timezone can cause problems in general, and with TS.FULLDATE in particular
- 2159 Question - Generate MB API using HL7 model element name (option #3) as the default option ?
- 10245 Duplicate fingerprint found in AB Session Managment messages
- 10284 ValueHolder does not work in Message builder v1.2.5
- 10285 MANIFEST.MF is missing the "Implementation-Version" property in the Message Builder hl7v3 releases

## [1.2.5]
### Changed
- All APIs have been re-built using HL7 element names, instead of HL7 business names. Note, this change applies to attributes and methods only while class names still use HL7 business names to reduce ambiguity. This change, in response to user feedback, means for quicker development and makes resulting code more consistent with HL7 specifications and other resources which tend to use HL7 element names for specification.


### Fixed
- 2159 Generate MB API using HL7 model element name (option #3) as the default option


## [1.2.0]
### Fixed
- 654 (.NET)System.NotImplementedException: The method or operation is not implemented.
- 649 (.NET)Validator - Can't determine the domain type of .
- 600 (.NET)Could not read messageSet_r02_04_02.xml
- 594 (.NET)AbstractPivlPropertyFormatter.cs - Unreachable code
- 586 Missing dlls for releases other than MR2009
- 585 paragraph tags in comments (.NET) are unclosed
- 492 Expected mandatory attribute "specializationType" (Aversan)
- 482 Runtime exception trying to parse a generated BC Find Candidates message
- 427 New Issue: No support for `BAG<AD>`
