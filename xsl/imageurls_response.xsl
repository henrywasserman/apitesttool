<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 

<xsl:output indent="yes" />

<xsl:template match="*|@*|text()">
  <xsl:copy>
  <xsl:apply-templates select="*|@*|text()"/>
  </xsl:copy>
</xsl:template>

<xsl:template match="message">
  <xsl:copy>
    <xsl:apply-templates>
	    <xsl:sort data-type="number" select="type"/>
    </xsl:apply-templates>
  </xsl:copy>
</xsl:template>

<xsl:strip-space elements="*"/>
</xsl:stylesheet> 
