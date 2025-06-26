<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/devices">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-width="210mm" page-height="297mm" margin="20mm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="16pt" font-weight="bold" space-after="12pt">Device Health Report</fo:block>
                    <fo:table table-layout="fixed" width="100%">
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell><fo:block>Device ID</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Name</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Type</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Battery</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Status</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Online</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Latest Health</fo:block></fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="device">
                                <fo:table-row>
                                    <fo:table-cell><fo:block><xsl:value-of select="deviceId"/></fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block><xsl:value-of select="name"/></fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block><xsl:value-of select="type"/></fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block><xsl:value-of select="batteryLevel"/></fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block><xsl:value-of select="status"/></fo:block></fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:choose>
                                                <xsl:when test="online='true'">Yes</xsl:when>
                                                <xsl:otherwise>No</xsl:otherwise>
                                            </xsl:choose>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:for-each select="healthReports[1]">
                                                <xsl:text>Status: </xsl:text><xsl:value-of select="status"/><fo:block/>
                                                <xsl:text>Temp: </xsl:text><xsl:value-of select="temperature"/><fo:block/>
                                                <xsl:text>Battery: </xsl:text><xsl:value-of select="batteryLevel"/><fo:block/>
                                                <xsl:text>Time: </xsl:text><xsl:value-of select="timestamp"/><fo:block/>
                                                <xsl:text>Msg: </xsl:text><xsl:value-of select="message"/>
                                            </xsl:for-each>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
