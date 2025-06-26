<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/devices">
        <html>
            <head>
                <title>Device Health Report</title>
                <style>
                    table { border-collapse: collapse; width: 90%; }
                    th, td { border: 1px solid #aaa; padding: 6px; text-align: left; }
                    th { background-color: #f0f0f0; }
                </style>
            </head>
            <body>
                <h2>Device Health Report</h2>
                <table>
                    <tr>
                        <th>Device ID</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Battery Level</th>
                        <th>Status</th>
                        <th>Online</th>
                        <th>Latest Health Report</th>
                    </tr>
                    <xsl:for-each select="device">
                        <tr>
                            <td><xsl:value-of select="deviceId"/></td>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="type"/></td>
                            <td><xsl:value-of select="batteryLevel"/></td>
                            <td><xsl:value-of select="status"/></td>
                            <td>
                                <xsl:choose>
                                    <xsl:when test="online='true'">Yes</xsl:when>
                                    <xsl:otherwise>No</xsl:otherwise>
                                </xsl:choose>
                            </td>
                            <td>
                                <xsl:for-each select="healthReports[1]">
                                    <b>Status:</b> <xsl:value-of select="status"/><br/>
                                    <b>Temp:</b> <xsl:value-of select="temperature"/><br/>
                                    <b>Battery:</b> <xsl:value-of select="batteryLevel"/><br/>
                                    <b>Time:</b> <xsl:value-of select="timestamp"/><br/>
                                    <b>Msg:</b> <xsl:value-of select="message"/>
                                </xsl:for-each>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
