<?xml version="1.0"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:p1="http://www.ftn.uns.ac.rs/patent/"
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
                <p1:Broj_prijave>
                    <xsl:value-of select="$Broj_prijave"/>
                </p1:Broj_prijave>
                <p1:Datum_prijave>
                    <xsl:value-of select="$Datum_prijave"/>
                </p1:Datum_prijave>
                <xsl:choose>
                    <xsl:when test="string-length($Priznati_datum_prijave) > 0 and string-length($Priznati_datum_prijave) != 12">
                        <p1:Priznati_datum_prijave>
                            <xsl:value-of select="$Priznati_datum_prijave"/>
                        </p1:Priznati_datum_prijave>
                    </xsl:when>
                </xsl:choose>
                <p1:Srpski_naziv_pronalaska>
                    <xsl:value-of select="$Srpski_naziv_pronalaska"/>
                </p1:Srpski_naziv_pronalaska>
                <p1:Engleski_naziv_pronalaska>
                    <xsl:value-of select="$Engleski_naziv_pronalaska"/>
                </p1:Engleski_naziv_pronalaska>
                <p1:Naziv_podnosioca>
                    <xsl:value-of select="$Naziv_podnosioca"/>
                </p1:Naziv_podnosioca>
            </rdf:Description>
        </rdf:RDF>
    </xsl:template>
</xsl:stylesheet>