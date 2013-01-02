<!--

    Copyright 2013 Canada Health Infoway, Inc.

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

<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:mif="urn:hl7-org:v3/mif2" xmlns:xhtml="http://www.w3.org/1999/xhtml">  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="no"/>  <!--    - ******************    - ** Convert Down **    - ******************    -->  <!-- Standard rules -->  <xsl:template mode="Do2.1.6to2.1.5" match="*">    <xsl:param name="toVersion"/>    <xsl:variable name="firstPass">      <xsl:apply-templates mode="from2.1.6to2.1.5" select="self::*"/>    </xsl:variable>    <xsl:choose>      <xsl:when test="$toVersion='2.1.5'">        <xsl:copy-of select="$firstPass"/>      </xsl:when>      <xsl:otherwise>        <xsl:apply-templates mode="Do2.1.5to2.1.4" select="$firstPass">          <xsl:with-param name="toVersion" select="$toVersion"/>        </xsl:apply-templates>      </xsl:otherwise>    </xsl:choose>  </xsl:template>  <xsl:template mode="from2.1.6to2.1.5" match="node()|@*">    <xsl:copy>      <xsl:apply-templates mode="from2.1.6to2.1.5" select="node()|@*"/>    </xsl:copy>  </xsl:template>  <xsl:template mode="from2.1.6to2.1.5" match="text()[normalize-space(.)='']"/>	<xsl:template mode="from2.1.6to2.1.5" match="@schemaVersion[.='2.1.6']">		<xsl:attribute name="schemaVersion" select="'2.1.5'"/>	</xsl:template>	<!-- Version-specific rules -->  <xsl:template mode="from2.1.6to2.1.5" match="@conformance[.='U']"/>  <!--    - ****************    - ** Convert Up **    - ****************    -->  <!-- Standard rules -->  <xsl:template mode="Do2.1.5to2.1.6" match="*">      <xsl:param name="toVersion"/>    <xsl:variable name="firstPass">      <xsl:apply-templates mode="from2.1.5to2.1.6" select="self::*"/>    </xsl:variable>    <xsl:choose>      <xsl:when test="$toVersion='2.1.6'">        <xsl:copy-of select="$firstPass"/>      </xsl:when>      <xsl:otherwise>        <xsl:apply-templates mode="Do2.1.6to2.1.7" select="$firstPass">          <xsl:with-param name="toVersion" select="$toVersion"/>        </xsl:apply-templates>      </xsl:otherwise>    </xsl:choose>  </xsl:template>  <xsl:template mode="from2.1.5to2.1.6" match="node()|@*">    <xsl:copy>      <xsl:apply-templates mode="from2.1.5to2.1.6" select="node()|@*"/>    </xsl:copy>  </xsl:template>  <xsl:template mode="from2.1.5to2.1.6" match="text()[normalize-space(.)='']"/>	<xsl:template mode="from2.1.5to2.1.6" match="@schemaVersion[.='2.1.5']">		<xsl:attribute name="schemaVersion" select="'2.1.6'"/>	</xsl:template>	<!-- Version-specific rules --></xsl:stylesheet>