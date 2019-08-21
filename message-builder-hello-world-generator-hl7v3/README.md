# API Generation Sample Project

This project provides a sample specification (MIF files) and corresponding `pom.xml` file to demonstrate the use of the Message Builder Generator.  In this case, the generator will be used to create a Message Set from the MIF files, and, subsequently, both Java and C# API code from the Message Set.

### Message Specification
The MIF files are taken from the panCanadian Standard R02.04.02 release MIFs, but are only for the Client Registry portion of the specification.  The following volumes of the specification were used:  

- Volume 1 - Infrastructure
- Volume 2 - Terminology
- Volume 3 - Shared Interactions
- Volume 4 - Client Registry

#### Excluded CMETs
Some of the CMETs contained in Infrastructure volume (Volume 1) of the release are not used by any of the Client Registry interactions.  The corresponding MIF files for those CMETs have therefore been excluded from this version of the MIF file set (otherwise, the Generator will report warning messages regarding "orphaned" CMETs that were declared but not referenced).

### Generating the Message Set
To generate the Messsage Set file, messageSet.xml, from the MIFs, invoke the Generator as a maven plug-in using the following command:

```
> mvn chi:mif-to-xml
```

The generator logs its progress as it works through the Message Set generation process and prints the message `BUILD SUCCESS	` upon successful completion.  A new file, `messageSet.xml`, will have been generated as a result.

In addition, you may notice the following validation errors in the Generator output.

```
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002100CA.AttentionLine.keyWordText
Domains should only be provided for coded types (Type: ST - domain: AttentionKeyword)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002100CA.AttentionLine.value
Domains should only be provided for coded types (Type: ST - domain: AttentionLineValue)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002100CA.Device1.manufacturerModelName
Domains should only be provided for coded types (Type: ST - domain: ManufacturerModelName)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002100CA.Device1.softwareName
Domains should only be provided for coded types (Type: ST - domain: SoftwareName)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002200CA.Device1.manufacturerModelName
Domains should only be provided for coded types (Type: ST - domain: ManufacturerModelName)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002200CA.Device1.softwareName
Domains should only be provided for coded types (Type: ST - domain: SoftwareName)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002300CA.AttentionLine.keyWordText
Domains should only be provided for coded types (Type: ST - domain: AttentionKeyword)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002300CA.AttentionLine.value
Domains should only be provided for coded types (Type: ST - domain: AttentionLineValue)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002300CA.Device1.manufacturerModelName
Domains should only be provided for coded types (Type: ST - domain: ManufacturerModelName)
[INFO] ERROR: DOMAIN_SHOULD_NOT_BE_PROVIDED
MCCI_MT002300CA.Device1.softwareName
Domains should only be provided for coded types (Type: ST - domain: SoftwareName)
``` 

The Generator has discovered some invalid vocabulary concept domain elements that have been included in the declarations of a handful of transport wrapper attributes.  In this case, the concept domain stipulation is invalid because the attributes themselves are of type `ST` (i.e., strings), which is not a coded value and therefore cannot have a concept domain.  However, once the errors are logged, the Generator continues on and ignores the invalid entries in order to successfully create the complete message set file.

### Generating the API Code

Once the Message Set is created, the Generator is again invoked on the command line as a Maven plug-in to create the API source code.

To create the Java API, use the command:

```
> mvn chi:xml-to-java
```
Once the generation is complete, inspect the Java code found in the `java` directory.  The model classes are created using a Java base package name of `ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02`.

To create the .Net API, use the command:

```
> mvn chi:xml-to-csharp
```

Once the generation is complete, inspect the Java code found in the `cSharp` directory.  The model classes are created using a base namespace of `Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02`.
