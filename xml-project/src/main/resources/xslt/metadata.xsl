<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                >

    <xsl:template match="/">
        <rdf:RDF>
            <rdf:Description rdf:about="Patent">
                <xsl:variable name="Broj_prijave">
                    <xsl:value-of select="//Nova_prijava/Broj_prijave"/>
                </xsl:variable>
                <xsl:variable name="Datum_prijave">
                    <xsl:value-of select="//Nova_prijava/Datum_prijave"/>
                </xsl:variable>
                <xsl:variable name="Priznati_datum_prijave">
                    <xsl:value-of select="//Nova_prijava/Priznati_datum_prijave"/>
                </xsl:variable>
                <xsl:variable name="Srpski_naziv_pronalaska">
                    <xsl:value-of select="//Naziv_pronalaska/Srpski_naziv"/>
                </xsl:variable>
                <xsl:variable name="Engleski_naziv_pronalaska">
                    <xsl:value-of select="//Naziv_pronalaska/Engleski_naziv"/>
                </xsl:variable>
                <xsl:variable name="Naziv_podnosioca">
                    <xsl:value-of select="//Podnosilac/Naziv"/>
                </xsl:variable>
                <rdf:Description rdf:about="Broj_prijave">
                    <xsl:value-of select="$Broj_prijave"/>
                </rdf:Description>
                <rdf:Description rdf:about="Datum_prijave">
                    <xsl:value-of select="$Datum_prijave"/>
                </rdf:Description>
                <rdf:Description rdf:about="Priznati_datum_prijave">
                    <xsl:value-of select="$Priznati_datum_prijave"/>
                </rdf:Description>
                <rdf:Description rdf:about="Srpski_naziv_pronalaska">
                    <xsl:value-of select="$Srpski_naziv_pronalaska"/>
                </rdf:Description>
                <rdf:Description rdf:about="Engleski_naziv_pronalaska">
                    <xsl:value-of select="$Engleski_naziv_pronalaska"/>
                </rdf:Description>
                <rdf:Description rdf:about="Naziv_podnosioca">
                    <xsl:value-of select="$Naziv_podnosioca"/>
                </rdf:Description>
            </rdf:Description>
        </rdf:RDF>
    </xsl:template>
</xsl:stylesheet>