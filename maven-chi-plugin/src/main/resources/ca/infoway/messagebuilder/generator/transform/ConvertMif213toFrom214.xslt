<?xml version="1.0" encoding="UTF-8"?>
<!--

    Copyright ${year} Canada Health Infoway, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    Author:        $LastChangedBy$
    Last modified: $LastChangedDate$
    Revision:      $LastChangedRevision$

-->

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:mif="urn:hl7-org:v3/mif2" xmlns:xhtml="http://www.w3.org/1999/xhtml">
  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="no"/>
  <!-- Note:
    - There were several changes between 2.1.3 and 2.1.4 that affected the allowed maximum length or format of some
    - elements.  As there is no automated way of changing these, they have been left unchanged.  As a result, the
    - converted MIF may fail validation.  Specific changes were:
    -  - Vocabulary property name from EnumerationToken to ShortDescriptiveName
    -  - FormalProperName increased to 60
    -  - CodePrintName from ShortDescriptiveName to LongDescriptiveName
    -->
  <!--
    - ******************
    - ** Convert Down **
    - ******************
    -->
  <!-- Standard rules -->
  <xsl:template mode="Do2.1.4to2.1.3" match="*">
    <xsl:param name="toVersion"/>
    <xsl:variable name="firstPass">
      <xsl:apply-templates mode="from2.1.4to2.1.3" select="self::*"/>
    </xsl:variable>
    <xsl:choose>
      <xsl:when test="$toVersion='2.1.3'">
        <xsl:copy-of select="$firstPass"/>
      </xsl:when>
      <xsl:otherwise>
        <xsl:apply-templates mode="Do2.1.3to2.1.2" select="$firstPass">
          <xsl:with-param name="toVersion" select="$toVersion"/>
        </xsl:apply-templates>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.3" match="node()|@*">
    <xsl:copy>
      <xsl:apply-templates mode="from2.1.4to2.1.3" select="node()|@*"/>
    </xsl:copy>
  </xsl:template>
	<xsl:template mode="from2.1.4to2.1.3" match="@schemaVersion[.='2.1.4']">
		<xsl:attribute name="schemaVersion" select="'2.1.3'"/>
	</xsl:template>
	<!-- Version-specific rules -->
  <xsl:template mode="from2.1.4to2.1.3" match="mif:txtInlineOnly|mif:txtComplex|mif:txtComplexWithLanguage">
    <xsl:message select="concat('Error: Unable to convert element ', name(.), ' to 2.1.3.  Not supported in that version')"/>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.3" match="mif:supplementArtifact
                                          |mif:stabilityRemarks
                                          |mif:minimumValueSet
                                          |mif:ignoredValueSet
                                          |mif:valueSet/@rootCode
                                          |mif:filter/@expression
                                          |@isComplete
                                          |mif:attribute/mif:property
                                          |mif:valueSet/@isImmutable
                                          |@areBaseQualifiersUnlimited
                                          |mif:headCodes">
  <!-- Todo: appears in vocab binding too -->
    <xsl:message select="concat('Error: Item ', name(.), ' is not supported in 2.1.3.  It has been removed which will affect the interpretation of the model.')"/>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.3" match="mif:enumeratedContent">
    <xsl:variable name="name" select="name(.)"/>
    <xsl:for-each select="mif:code">
      <xsl:element name="{$name}" namespace="urn:hl7-org:v3/mif2">
        <xsl:apply-templates mode="from2.1.4to2.1.3" select="node()|@*"/>
      </xsl:element>
    </xsl:for-each>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.3" match="mif:exampleContent">
    <xsl:copy>
      <xsl:for-each select="mif:code">
        <mif:codeBasedContent>
          <xsl:apply-templates mode="from2.1.4to2.1.3" select="@code"/>
        </mif:codeBasedContent>
      </xsl:for-each>
    </xsl:copy>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.3" match="@conformance[.='I']">
    <xsl:message>Warning: Conformance of *ignored* is not supported in 2.1.3.  It has been changed to *undeclared*.</xsl:message>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.3" match="mif:publicTerminologyServer">
    <xsl:copy>
      <xsl:value-of select="@url"/>
    </xsl:copy>
    <xsl:message>Warning: Dropped terminology server type as it is not supported in 2.1.3.</xsl:message>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.3" match="mif:allowedQualifiers|mif:prohibitedQualifiers">
    <xsl:message>Warning: allowedQualifiers and prohibitedQualifiers is modeled differently in 2.1.3 (using the *qualifierContent* element).  There is no automatic translation between the two, so the element has been commented out.</xsl:message>
    <xsl:comment>
      <xsl:copy-of select="."/>
    </xsl:comment>
  </xsl:template>
  <!--
    - ****************
    - ** Convert Up **
    - ****************
    -->
  <!-- Standard rules -->
  <xsl:template mode="from2.1.3to2.1.4" match="*">
    <xsl:param name="toVersion"/>
    <xsl:variable name="firstPass">
      <xsl:apply-templates mode="from2.1.3to2.1.4" select="*"/>
    </xsl:variable>
    <xsl:choose>
      <xsl:when test="$toVersion='2.1.4'">
        <xsl:copy-of select="$firstPass"/>
      </xsl:when>
      <xsl:otherwise>
        <xsl:apply-templates mode="Do2.1.4to2.1.5" select="$firstPass">
          <xsl:with-param name="toVersion" select="$toVersion"/>
        </xsl:apply-templates>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template mode="from2.1.3to2.1.4" match="node()|@*">
    <xsl:copy>
      <xsl:apply-templates mode="from2.1.3to2.1.4" select="node()|@*"/>
    </xsl:copy>
  </xsl:template>
  <xsl:template mode="from2.1.3to2.1.4" match="text()[normalize-space(.)='']"/>
	<xsl:template mode="from2.1.3to2.1.4" match="@schemaVersion[.='2.1.3']">
		<xsl:attribute name="schemaVersion" select="'2.1.4'"/>
	</xsl:template>
	<!-- Version-specific rules -->
  <xsl:template mode="from2.1.3to2.1.4" match="xhtml:param[@name='id']">
    <xsl:message>'id' is no longer allowed as an object parameter name in 2.1.4.  The parameter has been removed.</xsl:message>
  </xsl:template>
  <xsl:template mode="from2.1.3to2.1.4" match="mif:publicTerminologyServer">
    <xsl:copy>
      <xsl:attribute name="url" select="."/>
      <xsl:attribute name="type" select="'Custom'"/>
    </xsl:copy>
    <xsl:message>Warning: Identified terminology server type as *Custom* as there was no way to infer the type.</xsl:message>
  </xsl:template>
  <xsl:template mode="from2.1.3to2.1.4" match="mif:exampleContent[count(preceding-sibling::mif:exampleContent)=0]|mif:enumeratedContent[count(preceding-sibling::mif:enumeratedContent)=0]">
    <xsl:copy>
      <xsl:for-each select="parent::*/*[name(.)=name(current())]">
        <mif:code>
          <xsl:apply-templates mode="from2.1.3to2.1.4" select="node()|@*"/>
        </mif:code>
      </xsl:for-each>
    </xsl:copy>
  </xsl:template>
  <xsl:template mode="from2.1.3to2.1.4" match="mif:qualifierContent">
    <xsl:message>Warning: qualifierContent is modeled differently in 2.1.4 (using the *allowedQualifiers* and *prohibitedQualifiers* elements).  There is no automatic translation between the two, so the element has been commented out.</xsl:message>
    <xsl:comment>
      <xsl:copy-of select="."/>
    </xsl:comment>
  </xsl:template>
</xsl:stylesheet>
