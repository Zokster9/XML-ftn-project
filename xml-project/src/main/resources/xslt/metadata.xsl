<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                >

    <xsl:template match="/">
        <rdf:RDF>
            <rdf:Description rdf:about="http://www.ftn.uns.ac.rs.com/patent">
                <xsl:variable name="Broj_prijave">
                    <xsl:value-of select="//Nova_prijava/Broj_prijave"/>
                </xsl:variable>
                <xsl:variable name="Datum_prijave">
                    <xsl:value-of select="//Nova_prijava/Datum_prijave"/>
                </xsl:variable>
                <xsl:variable name="Priznati_datum_prijave">
                    <xsl:value-of select="//Nova_prijava/Priznati_datum_prijave"/>
                </xsl:variable>
                <rdf:Description rdf:about="http:/www.ftn.uns.ac.rs/Broj_prijave">
                    <xsl:value-of select="$Broj_prijave"/>
                </rdf:Description>
                <rdf:Description rdf:about="http:/www.ftn.uns.ac.rs/Datum_prijave">
                    <xsl:value-of select="$Datum_prijave"/>
                </rdf:Description>
                <rdf:Description rdf:about="http:/www.ftn.uns.ac.rs.rs/Priznati_datum_prijave">
                    <xsl:value-of select="$Priznati_datum_prijave"/>
                </rdf:Description>
            </rdf:Description>
        </rdf:RDF>
    </xsl:template>
</xsl:stylesheet>