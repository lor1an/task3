<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>Tariffs</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Tariff name</th>
        <th>Operator name</th>
        <th>Payroll</th>
        <th>SMS price</th>
        <th>Inner price</th>
        <th>Outer price</th>
        <th>Home price</th>
        </tr>
      <xsl:for-each select="tariffs/tariff">
      <tr>
        <td><xsl:value-of select="name"/></td>
        <td><xsl:value-of select="oname"/></td>
        <td><xsl:value-of select="payroll"/></td>
        <td><xsl:value-of select="smsprice"/></td>
        <td><xsl:value-of select="callprices/innerp"/></td>
        <td><xsl:value-of select="callprices/outerp"/></td>
        <td><xsl:value-of select="callprices/homer"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>
