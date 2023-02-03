<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:z1="http://www.ftn.uns.ac.rs/zig/"
>

    <xsl:template match="/">
        <rdf:RDF>
            <rdf:Description rdf:about="Zig">
                <xsl:variable name="Broj_prijave_ziga">
                    <xsl:value-of select="//Podaci_o_prijavi/Broj_prijave_ziga"/>
                </xsl:variable>
                <xsl:variable name="Datum_podnosenja">
                    <xsl:value-of select="//Podaci_o_prijavi/Datum_podnosenja"/>
                </xsl:variable>
                <xsl:variable name="Datum_prihvatanja">
                    <xsl:value-of select="//Podaci_o_prijavi/Datum_prihvatanja"/>
                </xsl:variable>
                <xsl:for-each select="//Podnosioci_prijave/Podnosilac_prijave">
                    <z1:Podnosilac_prijave>
                        <xsl:choose>
                            <xsl:when test="./Naziv">
                                <xsl:value-of select="./Naziv"/>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:value-of select="./Ime"/><xsl:text> </xsl:text><xsl:value-of select="./Prezime"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </z1:Podnosilac_prijave>
                </xsl:for-each>
                <z1:Broj_prijave_ziga>
                    <xsl:value-of select="$Broj_prijave_ziga"/>
                </z1:Broj_prijave_ziga>
                <z1:Datum_prijave>
                    <xsl:value-of select="$Datum_podnosenja"/>
                </z1:Datum_prijave>
                <xsl:choose>
                    <xsl:when test="string-length($Datum_prihvatanja) > 0 ">
                        <z1:Datum_prihvatanja>
                            <xsl:value-of select="$Datum_prihvatanja"/>
                        </z1:Datum_prihvatanja>
                    </xsl:when>
                </xsl:choose>
            </rdf:Description>
        </rdf:RDF>
    </xsl:template>
</xsl:stylesheet>