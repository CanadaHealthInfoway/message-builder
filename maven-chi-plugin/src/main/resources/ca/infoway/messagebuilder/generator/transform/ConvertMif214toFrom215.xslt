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
  <!--
    - ******************
    - ** Convert Down **
    - ******************
    -->
  <!-- Standard rules -->
  <xsl:template mode="Do2.1.5to2.1.4" match="*">
    <xsl:param name="toVersion"/>
    <xsl:variable name="firstPass">
      <xsl:apply-templates mode="from2.1.5to2.1.4" select="self::*"/>
    </xsl:variable>
    <xsl:choose>
      <xsl:when test="$toVersion='2.1.4'">
        <xsl:copy-of select="$firstPass"/>
      </xsl:when>
      <xsl:otherwise>
        <xsl:apply-templates mode="Do2.1.4to2.1.3" select="$firstPass">
          <xsl:with-param name="toVersion" select="$toVersion"/>
        </xsl:apply-templates>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template mode="from2.1.5to2.1.4" match="node()|@*">
    <xsl:copy>
      <xsl:apply-templates mode="from2.1.5to2.1.4" select="node()|@*"/>
    </xsl:copy>
  </xsl:template>
  <xsl:template mode="from2.1.5to2.1.4" match="text()[normalize-space(.)='']"/>
	<xsl:template mode="from2.1.5to2.1.4" match="@schemaVersion[.='2.1.5']">
		<xsl:attribute name="schemaVersion" select="'2.1.4'"/>
	</xsl:template>
	<!-- Version-specific rules -->
	<xsl:template mode="from2.1.5to2.1.4" match="/*">
    <xsl:copy>
      <xsl:namespace name="xhtml" select="'http://www.w3.org/1999/xhtml'"/>
      <xsl:apply-templates mode="from2.1.5to2.1.4" select="node()|@*"/>
    </xsl:copy>
	</xsl:template>
	<xsl:template mode="from2.1.5to2.1.4" match="mif:supplementedObject|mif:description[not(parent::mif:documentation)]|mif:reason|mif:existingContent|mif:suggestedReplacement|mif:resolutionComments|mif:renderingNotes|mif:notation|
                      mif:disclaimer|mif:licenseTerms|mif:versioningPolicy|mif:voterComments|mif:text|mif:combinedText|mif:rationale[not(parent::mif:documentation)]|mif:activityDiagramFigure|mif:figure">
    <xsl:copy>
      <xsl:apply-templates mode="AddXHTML" select="node()|@*"/>
    </xsl:copy>
	</xsl:template>
	<xsl:template mode="AddXHTML" priority="5" match="*">
    <xsl:element name="{concat('xhtml:', local-name())}" namespace="http://www.w3.org/1999/xhtml">
      <xsl:apply-templates mode="AddXHTML" select="node()|@*"/>
		</xsl:element>
	</xsl:template>
	<xsl:template mode="AddXHTML" match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates mode="AddXHTML" select="node()|@*"/>
    </xsl:copy>
	</xsl:template>
  <!--
    - ****************
    - ** Convert Up **
    - ****************
    -->
  <!-- Standard rules -->
  <xsl:template mode="Do2.1.4to2.1.5" match="*">
    <xsl:param name="toVersion"/>
    <xsl:variable name="firstPass">
      <xsl:apply-templates mode="from2.1.4to2.1.5" select="self::*"/>
    </xsl:variable>
    <xsl:choose>
      <xsl:when test="$toVersion='2.1.5'">
        <xsl:copy-of select="$firstPass"/>
      </xsl:when>
      <xsl:otherwise>
        <xsl:apply-templates mode="Do2.1.5to2.1.6" select="$firstPass">
          <xsl:with-param name="toVersion" select="$toVersion"/>
        </xsl:apply-templates>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.5" match="node()|@*">
    <xsl:copy>
      <xsl:apply-templates mode="from2.1.4to2.1.5" select="node()|@*"/>
    </xsl:copy>
  </xsl:template>
  <xsl:template mode="from2.1.4to2.1.5" match="text()[normalize-space(.)='']"/>
	<xsl:template mode="from2.1.4to2.1.5" match="@schemaVersion[.='2.1.4']">
		<xsl:attribute name="schemaVersion" select="'2.1.5'"/>
	</xsl:template>
	<!-- Version-specific rules -->
	<xsl:template mode="from2.1.4to2.1.5" match="xhtml:*">
    <xsl:element name="{local-name()}" namespace="urn:hl7-org:v3/mif2">
      <xsl:apply-templates mode="from2.1.4to2.1.5" select="node()|@*"/>
    </xsl:element>
	</xsl:template>
</xsl:stylesheet>
