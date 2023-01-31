<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="2.0">
    <xsl:template match="/">
        <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sr" lang="sr">
            <head>
                <meta content="text/html; charset=utf-8" />
                <title>Microsoft Word - z-1 2021 fin</title>
                <meta name="author" content="mb07237" />
                <style type="text/css"> * {margin:0; padding:0; text-indent:0; } h1 { color: black;
                                                                                     font-family:Arial, sans-serif; font-style: normal; font-weight: bold; text-decoration:
                            none; font-size: 14pt; } h2 { color: black; font-family:Arial, sans-serif; font-style:
                        normal; font-weight: bold; text-decoration: none; font-size: 10pt; } p { color: black;
                                                                                                 font-family:Arial, sans-serif; font-style: normal; font-weight: normal; text-decoration:
                            none; font-size: 10pt; margin:0pt; } .s1 { color: black; font-family:Arial, sans-serif;
                                                                     font-style: normal; font-weight: bold; text-decoration: none; font-size: 10pt; } .s2 {
                                                                                                                                                          color: black; font-family:Arial, sans-serif; font-style: normal; font-weight: normal;
                                                                                                                                                          text-decoration: none; font-size: 10pt; } .s3 { color: black; font-family:"Times New Roman", serif; font-style: normal; font-weight: normal; text-decoration: none;
                                                                                                                                                                                                        font-size: 10pt; } .s4 { color: black; font-family:Arial, sans-serif; font-style:
                        italic; font-weight: normal; text-decoration: none; font-size: 9pt; } .s5 { color:
                        black; font-family:"Times New Roman", serif; font-style: normal; font-weight: normal;
                                                                                                  text-decoration: underline; font-size: 10pt; } table, tbody {vertical-align: top;
                                                                                                                                                     overflow: visible; } </style>
            </head>
            <body>
                <h1
                        style="padding-top: 3pt;text-indent: 0pt;line-height: 16pt;text-align: center;">ЗАХТЕВ
                    ЗА ПРИЗНАЊЕ ЖИГА</h1><h2
                    style="text-indent: 0pt;line-height: 11pt;text-align: center;">Заводу
                за интелектуалну својину, Кнегиње Љубице 5, 11000 Београд</h2><p
                    style="text-indent: 0pt;text-align: left;"><br /></p><p
                    style="text-indent: 0pt;text-align: center;">(попунити на рачунару)</p>
                <table
                        style="border-collapse:collapse;margin: 0 auto" cellspacing="0">
                    <tr style="height:23pt">
                        <td
                                style="width:530pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="23"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">1.
                            Подносилац пријаве: <span class="s2">име и презиме/пословно име, улица и број, поштански
                                број, место,</span></p><p class="s2"
                                                          style="padding-left: 16pt;text-indent: 0pt;line-height: 11pt;text-align: left;">држава
                            пребивалишта/седишта:</p></td>
                    </tr>
                    <tr style="height:47pt">
                        <td
                                style="width:530pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="23">
                            <xsl:for-each select="//Podnosioci_prijave/Podnosilac_prijave">
                                <xsl:choose>
                                    <xsl:when test="./Naziv">
                                        <p style="text-indent: 0pt;text-align: left;"><br />
                                            <xsl:value-of select="./Naziv"/>,
                                            <xsl:value-of select="./Adresa/Ulica"/><xsl:text> </xsl:text><xsl:value-of select="./Adresa/Broj"/>,<xsl:text> </xsl:text>
                                            <xsl:value-of select="./Adresa/Postanski_broj"/>,<xsl:text> </xsl:text><xsl:value-of select="./Adresa/Mesto"/>,<xsl:text> </xsl:text><xsl:value-of select="./Adresa/Drzava"/>
                                        </p>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <p style="text-indent: 0pt;text-align: left;"><br />
                                            <xsl:value-of select="./Ime"/><xsl:text> </xsl:text><xsl:value-of select="./Prezime"/>,
                                            <xsl:value-of select="./Adresa/Ulica"/><xsl:text> </xsl:text><xsl:value-of select="./Adresa/Broj"/>,<xsl:text> </xsl:text>
                                            <xsl:value-of select="./Adresa/Postanski_broj"/>,<xsl:text> </xsl:text><xsl:value-of select="./Adresa/Mesto"/>,<xsl:text> </xsl:text><xsl:value-of select="./Adresa/Drzava"/>
                                        </p>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr style="height:13pt">
                        <td
                                style="width:175pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            телефон: <xsl:value-of select="//Podnosioci_prijave/Podnosilac_prijave/Kontakt_podaci/Broj_telefona"/> </p></td>
                        <td
                                style="width:173pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="7"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            e-mail: <xsl:value-of select="//Podnosioci_prijave/Podnosilac_prijave/Kontakt_podaci/Email"/></p></td>
                        <td
                                style="width:182pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 3pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            факс: <xsl:value-of select="//Podnosioci_prijave/Podnosilac_prijave/Kontakt_podaci/Broj_faksa"/></p></td>
                    </tr>
                    <tr style="height:23pt">
                        <td
                                style="width:530pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="23"><p class="s1"
                                                style="padding-left: 13pt;text-indent: -8pt;line-height: 12pt;text-align: left;">2.
                            Пуномоћник: <span class="s2">име и презиме/пословно име, улица и број, поштански број,
                                место, држава пребивалишта/седишта:</span></p></td>
                    </tr>
                    <tr style="height:47pt">
                        <td
                            style="width:530pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                            colspan="23">
                            <p style="text-indent: 0pt;text-align: left;"><br />
                                <xsl:if test="//Punomocnik">
                                    <xsl:value-of select="//Punomocnik/Ime"/><xsl:text> </xsl:text><xsl:value-of select="//Punomocnik/Naziv"/><xsl:value-of select="//Punomocnik/Prezime"/>,
                                    <xsl:value-of select="//Punomocnik/Adresa/Ulica"/><xsl:text> </xsl:text><xsl:value-of select="//Punomocnik/Adresa/Broj"/>,<xsl:text> </xsl:text>
                                    <xsl:value-of select="//Punomocnik/Adresa/Postanski_broj"/>,<xsl:text> </xsl:text><xsl:value-of select="//Punomocnik/Adresa/Mesto"/>,<xsl:text> </xsl:text><xsl:value-of select="//Punomocnik/Adresa/Drzava"/>
                                </xsl:if>
                                </p>
                        </td>
                    </tr>
                    <tr style="height:15pt">
                        <td
                                style="width:170pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            телефон: <xsl:value-of select="//Punomocnik/Kontakt_podaci/Broj_telefona"/></p></td>
                        <td
                                style="width:178pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="7"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            e-mail: <xsl:value-of select="//Punomocnik/Kontakt_podaci/Email"/></p></td>
                        <td
                                style="width:182pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 7pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            факс: <xsl:value-of select="//Punomocnik/Kontakt_podaci/Broj_faksa"/></p></td>
                    </tr>
                    <tr style="height:12pt">
                        <td
                                style="width:530pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="23"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">3.
                            Подаци о заједничком представнику ако постоји више подносилаца пријаве:</p></td>
                    </tr>
                    <tr style="height:47pt">
                        <td
                                style="width:530pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="23"><p style="text-indent: 0pt;text-align: left;"><br />
                            <xsl:if test="//Zajednicki_predstavnik_podnosioca_prijave">
                                <xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Ime"/><xsl:text> </xsl:text><xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Naziv"/><xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Prezime"/>,
                                <xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Adresa/Ulica"/><xsl:text> </xsl:text><xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Adresa/Broj"/>,<xsl:text> </xsl:text>
                                <xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Adresa/Postanski_broj"/>,<xsl:text> </xsl:text><xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Adresa/Mesto"/>,<xsl:text> </xsl:text><xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Adresa/Drzava"/>
                            </xsl:if>
                            </p></td>
                    </tr>
                    <tr style="height:12pt">
                        <td
                                style="width:170pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            телефон: <xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Kontakt_podaci/Broj_telefona"/></p></td>
                        <td
                                style="width:178pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="7"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            e-mail: <xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Kontakt_podaci/Email"/></p></td>
                        <td
                                style="width:182pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                            факс: <xsl:value-of select="//Zajednicki_predstavnik_podnosioca_prijave/Kontakt_podaci/Broj_faksa"/></p></td>
                    </tr>
                    <tr style="height:13pt">
                        <td
                                style="width:260pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="11"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">4.
                            Пријава се подноси за (уписати X):</p></td>
                        <td
                                style="width:270pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="12" rowspan="2"><p style="text-indent: 0pt;text-align: left;"><br /></p><p
                                class="s1" style="padding-left: 6pt;text-indent: 0pt;text-align: left;">в)
                            изглед знака:</p></td>
                    </tr>
                    <tr style="height:12pt">
                        <td
                                style="width:26pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                rowspan="3"><p style="text-indent: 0pt;text-align: left;"><br /></p><p
                                class="s1" style="padding-left: 5pt;text-indent: 0pt;text-align: left;">a)</p></td>
                        <td
                                style="width:183pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">индивидуални
                            жиг</p></td>
                        <td
                                style="width:51pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="2"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Zig/Tip_ziga/Individualni_zig">X</xsl:if></p></td>
                    </tr>
                    <tr style="height:15pt">
                        <td
                                style="width:183pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">колективни
                            жиг</p></td>
                        <td
                                style="width:51pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="2"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Zig/Tip_ziga/Kolektivni_zig">X</xsl:if></p></td>
                        <td
                                style="width:270pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="12" rowspan="11"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:value-of select="//Zig/Izgled_znaka/@image_url"/> </p></td>
                    </tr>
                    <tr style="height:14pt">
                        <td
                                style="width:183pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">жиг
                            гаранције</p></td>
                        <td
                                style="width:51pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="2"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Zig/Tip_ziga/Zig_garancije">X</xsl:if></p></td>
                    </tr>
                    <tr style="height:12pt">
                        <td
                                style="width:26pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                rowspan="5"><p style="text-indent: 0pt;text-align: left;"><br /></p><p
                                class="s1"
                                style="padding-top: 7pt;padding-left: 5pt;text-indent: 0pt;text-align: left;">
                            б)</p></td>
                        <td
                                style="width:183pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">вербални
                            знак (знак у речи)</p></td>
                        <td
                                style="width:51pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="2"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Zig/Tip_znaka/Verbalni_znak">X</xsl:if></p></td>
                    </tr>
                    <tr style="height:23pt">
                        <td
                                style="width:183pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;padding-right: 7pt;text-indent: 0pt;line-height: 12pt;text-align: left;">графички
                            знак; боју, комбинацију боја</p></td>
                        <td
                                style="width:51pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="2"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Zig/Tip_znaka/Graficki_znak">X</xsl:if></p></td>
                    </tr>
                    <tr style="height:14pt">
                        <td
                                style="width:183pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 6pt;text-indent: 0pt;line-height: 11pt;text-align: left;">комбиновани
                            знак</p></td>
                        <td
                                style="width:51pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="2"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Zig/Tip_znaka/Kombinovani_znak">X</xsl:if></p></td>
                    </tr>
                    <tr style="height:14pt">
                        <td
                                style="width:183pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">тродимензионални
                            знак</p></td>
                        <td
                                style="width:51pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="2"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Zig/Tip_znaka/Trodimenzionalni_znak">X</xsl:if></p></td>
                    </tr>
                    <tr style="height:14pt">
                        <td
                                style="width:183pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="8"><p class="s2"
                                               style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">другу
                            врсту знака (навести коју)</p></td>
                        <td
                                style="width:51pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="2"><p style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Zig/Tip_znaka/Druga_vrsta_znaka">X</xsl:if></p></td>
                    </tr>
                    <tr style="height:44pt">
                        <td
                                style="width:260pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="11"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;text-align: left;">5. Назначење
                            боје, односно боја из којих се знак састоји:</p><p style="padding-left: 5pt;text-indent: 0pt;text-align: left;">
                                <xsl:for-each select="//Zig/Naznacene_boje/Boja">
                                    <xsl:value-of select="."/><xsl:text> </xsl:text>
                                </xsl:for-each>
                            </p>
                        </td>
                    </tr>
                    <tr style="height:25pt">
                        <td
                                style="width:260pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="11"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">6.
                            Транслитерација знака*:</p><p style="padding-left: 5pt;text-indent: 0pt;text-align: left;"><xsl:value-of select="//Zig/Transliteracija_znaka"/> </p></td>
                    </tr>
                    <tr style="height:22pt">
                        <td
                                style="width:260pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="11"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">7.
                            Превод знака*:</p><p style="padding-left: 5pt;text-indent: 0pt;text-align: left;"><xsl:value-of select="//Zig/Prevod_znaka"/></p></td>
                    </tr>
                    <tr style="height:36pt">
                        <td
                                style="width:260pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="11"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">8.
                            Опис знака:</p><p style="padding-left: 5pt;text-indent: 0pt;text-align: left;"><xsl:value-of select="//Zig/Opis_znaka"/></p></td>
                    </tr>
                    <tr style="height:12pt">
                        <td
                                style="width:530pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="23"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">9.
                            Заокружити бројеве класа робе и услуга према Ничанској класификацији :</p></td>
                    </tr>
                    <tr style="height:14pt">
                        <xsl:for-each select="//Klase_robe_i_usluga/Klasa">
                            <xsl:variable name="Klasa">
                                <xsl:value-of select="."/>
                            </xsl:variable>
                            <xsl:if test="position() &lt; 24">
                                <xsl:choose>
                                    <xsl:when test="$Klasa = position()">
                                        <td style="width:26pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt">
                                            <p class="s3" style="border: 2px solid black; border-radius: 50%; padding-right: 4pt;text-indent: 0pt;text-align: right;">
                                                <xsl:value-of select="position()"/>
                                            </p>
                                        </td>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <td style="width:26pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt">
                                            <p class="s3" style="padding-right: 4pt;text-indent: 0pt;text-align: right;">
                                                <xsl:value-of select="position()"/>
                                            </p>
                                        </td>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </xsl:if>
                        </xsl:for-each>
                    </tr>
                    <tr style="height:12pt">
                        <xsl:for-each select="//Klase_robe_i_usluga/Klasa">
                            <xsl:variable name="Klasa">
                                <xsl:value-of select="."/>
                            </xsl:variable>
                            <xsl:if test="position() >= 24">
                                <xsl:choose>
                                    <xsl:when test="$Klasa = position()">
                                        <td style="width:26pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt">
                                            <p class="s3" style="border: 2px solid black; border-radius: 50%; padding-right: 4pt;text-indent: 0pt;text-align: right;">
                                                <xsl:value-of select="position()"/>
                                            </p>
                                        </td>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <td style="width:26pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt">
                                            <p class="s3" style="padding-right: 4pt;text-indent: 0pt;text-align: right;">
                                                <xsl:value-of select="position()"/>
                                            </p>
                                        </td>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </xsl:if>
                        </xsl:for-each>
                        <td
                                style="width:26pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                                style="text-indent: 0pt;text-align: left;"><br /></p></td>
                    </tr>
                    <tr style="height:33pt">
                        <td
                                style="width:530pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                                colspan="23"><p class="s1"
                                                style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">10.
                            Затражено право првенства и основ:</p><p style="padding-left: 5pt;text-indent: 0pt;text-align: left;">
                            <xsl:value-of select="//Pravo_prvenstva_i_osnov"/>
                        </p></td>
                    </tr>
                </table><p
                    style="text-indent: 0pt;text-align: left;"><br /></p><p
                    style="padding-left: 13pt;text-indent: 0pt;text-align: center;">*Попунити само ако је знак
                или елемент знака исписан словима која нису ћирилична или латинична</p><table
                    style="border-collapse:collapse;margin: 0 auto" cellspacing="0">
                <tr style="height:28pt">
                    <td
                            style="width:211pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s1"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">11.
                        Плаћене таксе:</p></td>
                    <td
                            style="width:68pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s1"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                        Динара</p></td>
                    <td
                            style="width:240pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                            rowspan="4"><p class="s1"
                                           style="padding-left: 48pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Потпис
                        подносиоца захтева</p><p style="text-indent: 0pt;text-align: left;"><br /></p><p class="s4"
                                                                                                         style="padding-left: 5pt;text-indent: 0pt;text-align: left;">* Печат,
                        уколико је потребан у складу са законом</p></td>
                </tr>
                <tr style="height:27pt">
                    <td
                            style="width:211pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /></p><p class="s1"
                                                                                    style="padding-left: 5pt;text-indent: 0pt;text-align: left;">а) основна
                        такса</p></td>
                    <td
                            style="width:68pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:value-of select="//Placene_takse/Osnovna_taksa"/> </p></td>
                </tr>
                <tr style="height:47pt">
                    <td
                            style="width:211pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /></p><p class="s1"
                                                                                    style="padding-left: 5pt;text-indent: 0pt;text-align: left;">б) за <span><xsl:value-of select="//Placene_takse/Taksa_za_klase/@broj_klasa"/></span> класа</p><p
                            style="text-indent: 0pt;text-align: left;"><br /></p><br/><p class="s1"
                                                                                        style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">в)
                        за графичко решење</p></td>
                    <td
                            style="width:68pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"></p><br /><p><xsl:value-of select="//Placene_takse/Taksa_za_klase/Vrednost"/></p><br/><p><xsl:value-of select="//Placene_takse/Taksa_za_graficko_resenje"/></p></td>
                </tr>
                <tr style="height:27pt">
                    <td
                            style="width:211pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /></p><p class="s1"
                                                                                    style="padding-left: 5pt;text-indent: 0pt;text-align: left;">УКУПНО</p></td>
                    <td
                            style="width:68pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:value-of select="//Placene_takse/Ukupna_taksa"/></p></td>
                </tr>
            </table><p
                    style="text-indent: 0pt;text-align: left;"><br /></p><table
                    style="border-collapse:collapse;margin:0 auto" cellspacing="0">
                <tr style="height:23pt">
                    <td
                            style="width:517pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                            colspan="3"><p style="text-indent: 0pt;text-align: left;"><br /></p><p
                            class="s1"
                            style="padding-left: 207pt;padding-right: 207pt;text-indent: 0pt;line-height: 11pt;text-align: center;">ПОПУЊАВА
                        ЗАВОД</p></td>
                </tr>
                <tr style="height:23pt">
                    <td
                            style="width:298pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                            colspan="2"><p class="s1"
                                           style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Прилози
                        уз захтев:</p></td>
                    <td
                            style="width:219pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"
                            rowspan="9"><p style="text-indent: 0pt;text-align: left;"><br /></p><p
                            class="s2"
                            style="padding-top: 9pt;padding-left: 61pt;padding-right: 61pt;text-indent: 0pt;line-height: 200%;text-align: center;">Број
                        пријаве жига:<br/> <span><xsl:value-of select="//Podaci_o_prijavi/Broj_prijave_ziga"/> </span><br/> <b>Датум подношења:</b> </p><p class="s2"
                                                                                          style="padding-top: 9pt;padding-left: 61pt;padding-right: 61pt;text-indent: 0pt;line-height: 200%;text-align: center;">
                        <xsl:value-of select="//Podaci_o_prijavi/Datum_podnosenja"/></p></td>
                </tr>
                <tr style="height:23pt">
                    <td
                            style="width:248pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s2"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Примерак
                        знака</p></td>
                    <td
                            style="width:50pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:value-of select="//Podaci_o_prijavi/Prilozi_uz_zahtev/Primerak_znaka/@naziv_dokumenta"/></p></td>
                </tr>
                <tr style="height:23pt">
                    <td
                            style="width:248pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s2"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Списак
                        робе и услуга**</p></td>
                    <td
                            style="width:50pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Podaci_o_prijavi/Prilozi_uz_zahtev/Spisak_robe_i_usluga">X</xsl:if> </p></td>
                </tr>
                <tr style="height:23pt">
                    <td
                            style="width:248pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s2"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">
                        Пуномоћје</p></td>
                    <td
                            style="width:50pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:value-of select="//Podaci_o_prijavi/Prilozi_uz_zahtev/Punomocje/@naziv_dokumenta"/></p></td>
                </tr>
                <tr style="height:23pt">
                    <td
                            style="width:248pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s2"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Генерално
                        пуномоћје раније приложено</p></td>
                    <td
                            style="width:50pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Podaci_o_prijavi/Prilozi_uz_zahtev/Generalno_punomocje_ranije_prilozeno">X</xsl:if></p></td>
                </tr>
                <tr style="height:23pt">
                    <td
                            style="width:248pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s2"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Пуномоћје
                        ће бити накнадно достављено</p></td>
                    <td
                            style="width:50pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:if test="//Podaci_o_prijavi/Prilozi_uz_zahtev/Punomocje_ce_biti_naknadno_dostavljeno">X</xsl:if></p></td>
                </tr>
                <tr style="height:23pt">
                    <td
                            style="width:248pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s2"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Општи
                        акт о колективном жигу/жигу гаранције</p></td>
                    <td
                            style="width:50pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:value-of select="//Podaci_o_prijavi/Prilozi_uz_zahtev/Opsti_akt_o_kolektivnom_zigu/@naziv_dokumenta"/></p></td>
                </tr>
                <tr style="height:23pt">
                    <td
                            style="width:248pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s2"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Доказ
                        о праву првенства</p></td>
                    <td
                            style="width:50pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:value-of select="//Podaci_o_prijavi/Prilozi_uz_zahtev/Dokaz_o_pravu_prvenstva/@naziv_dokumenta"/></p></td>
                </tr>
                <tr style="height:22pt">
                    <td
                            style="width:248pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            class="s2"
                            style="padding-left: 5pt;text-indent: 0pt;line-height: 11pt;text-align: left;">Доказ
                        о уплати таксе</p></td>
                    <td
                            style="width:50pt;border-top-style:solid;border-top-width:1pt;border-left-style:solid;border-left-width:1pt;border-bottom-style:solid;border-bottom-width:1pt;border-right-style:solid;border-right-width:1pt"><p
                            style="text-indent: 0pt;text-align: left;"><br /><xsl:value-of select="//Podaci_o_prijavi/Prilozi_uz_zahtev/Dokaz_o_uplati_takse/@naziv_dokumenta"/></p></td>
                </tr>
            </table><p
                    style="text-indent: 0pt;text-align: left;"><br /></p><p
                    style="text-indent: 0pt;text-align: left;" /><p
                    style="padding-top: 4pt;padding-left: 15pt;text-indent: 0pt;text-align: justify;">**Уз
                заокруживање броја класе робе/услуга Ничанске класификације у рубрици 9 доставља се и списак
                који садржи конкретне називе робе коју подносилац пријаве производи, односно услуга које
                пружа. У циљу одређења обима заштите која се стиче жигом, списак треба да садржи јасне и
                прецизне називе робе и услуга. У ту сврху могу се користити појмови из детаљне Листе роба и
                услуга или MGS Manager апликације, доступних на сајту Завода. Уколико се у списак уносе
                термини из Листе класа Ничанске класификације, заштита обухвата само тако именоване,
                конкретне робе/услуге у њиховом јасном и недвосмисленом значењу.</p></body>
        </html>
    </xsl:template>
</xsl:stylesheet>