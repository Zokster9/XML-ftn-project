<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:a1="http://www.ftn.uns.ac.rs/autorska/"
>
    <xsl:template match="/">
        <rdf:RDF>
            <rdf:Description rdf:about="ObrazacAutorska">
                <xsl:variable name="broj_prijave">
                    <xsl:value-of select="//broj_prijave"/>
                </xsl:variable>
                <xsl:variable name="datum_prijave">
                    <xsl:value-of select="//datum_prijave"/>
                </xsl:variable>
                <xsl:variable name="email_podnosioca">
                    <xsl:value-of select="//podnosilac/email"/>
                </xsl:variable>
                <xsl:variable name="ime_podnosioca">
                    <xsl:value-of select="//podnosilac/ime"/>
                </xsl:variable>
                <xsl:variable name="prezime_podnosioca">
                    <xsl:value-of select="//podnosilac/prezime"/>
                </xsl:variable>
                <xsl:variable name="poslovno_ime_podnosioca">
                    <xsl:value-of select="//podnosilac/poslovno_ime"/>
                </xsl:variable>
                <xsl:variable name="naslov">
                    <xsl:value-of select="//podaci_o_autorskom_delu/naslov"/>
                </xsl:variable>
                <xsl:variable name="vrsta">
                    <xsl:value-of select="//podaci_o_autorskom_delu/vrsta"/>
                </xsl:variable>
                <xsl:variable name="forma_zapisa">
                    <xsl:value-of select="//podaci_o_autorskom_delu/forma_zapisa"/>
                </xsl:variable>

                <a1:broj_prijave>
                    <xsl:value-of select="$broj_prijave"/>
                </a1:broj_prijave>
                <a1:datum_prijave>
                    <xsl:value-of select="$datum_prijave"/>
                </a1:datum_prijave>
                <a1:email_podnosioca>
                    <xsl:value-of select="$email_podnosioca"/>
                </a1:email_podnosioca>
                <xsl:choose>
                    <xsl:when test="$ime_podnosioca">
                        <a1:ime_podnosioca>
                            <xsl:value-of select="$ime_podnosioca"/>
                        </a1:ime_podnosioca>
                        <a1:prezime_podnosioca>
                            <xsl:value-of select="$prezime_podnosioca"/>
                        </a1:prezime_podnosioca>
                    </xsl:when>
                    <xsl:otherwise>
                        <a1:poslovno_ime_podnosioca>
                            <xsl:value-of select="$poslovno_ime_podnosioca"/>
                        </a1:poslovno_ime_podnosioca>
                    </xsl:otherwise>
                </xsl:choose>
                <a1:naslov>
                    <xsl:value-of select="$naslov"/>
                </a1:naslov>
                <a1:vrsta>
                    <xsl:value-of select="$vrsta"/>
                </a1:vrsta>
                <a1:forma_zapisa>
                    <xsl:value-of select="$forma_zapisa"/>
                </a1:forma_zapisa>
            </rdf:Description>
        </rdf:RDF>
    </xsl:template>
</xsl:stylesheet>