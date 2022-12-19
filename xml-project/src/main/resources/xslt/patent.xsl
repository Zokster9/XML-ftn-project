<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="2.0">
    <xsl:template match="/">
        <html>
            <!--docxjs library predefined styles--><style>
            .docx-wrapper { background: gray; padding: 30px; padding-bottom: 0px; display: flex; flex-flow: column; align-items: center; }
            .docx-wrapper>section.docx { background: white; box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); margin-bottom: 30px; }
            .docx { color: black; }
            section.docx { box-sizing: border-box; display: flex; flex-flow: column nowrap; position: relative; overflow: hidden; }
            section.docx>article { margin-bottom: auto; }
            .docx table { border-collapse: collapse; }
            .docx table td, .docx table th { vertical-align: top; }
            .docx p { margin: 0pt; min-height: 1em; }
            .docx span { white-space: pre-wrap; overflow-wrap: break-word; }
            .docx a { color: inherit; text-decoration: inherit; }
        </style><!--docxjs mathml polyfill styles--><style>@namespace "http://www.w3.org/1998/Math/MathML";

            math {
            display: inline-block;
            line-height: initial;
            }

            mfrac {
            display: inline-block;
            vertical-align: -50%;
            text-align: center;
            }
            mfrac > :first-child {
            border-bottom: solid thin currentColor;
            }
            mfrac > * {
            display: block;
            }

            msub > :nth-child(2) {
            font-size: smaller;
            vertical-align: sub;
            }

            msup > :nth-child(2) {
            font-size: smaller;
            vertical-align: super;
            }

            munder, mover, munderover {
            display: inline-flex;
            flex-flow: column nowrap;
            vertical-align: middle;
            text-align: center;
            }
            munder > :not(:first-child), mover > :not(:first-child), munderover > :not(:first-child) {
            font-size: smaller;
            }

            munderover > :last-child {
            order: -1;
            }

            mroot, msqrt {
            position: relative;
            display: inline-block;
            border-top: solid thin currentColor;
            margin-top: 0.5px;
            vertical-align: middle;
            margin-left: 1ch;
            }
            mroot:before, msqrt:before {
            content: "";
            display: inline-block;
            position: absolute;
            width: 1ch;
            left: -1ch;
            top: -1px;
            bottom: 0;
            background-image: url("data:image/svg+xml,%3Csvg xmlns=%27http://www.w3.org/2000/svg%27 viewBox=%270 0 20 100%27 preserveAspectRatio=%27none%27%3E%3Cpath d=%27m0,75 l5,0 l5,25 l10,-100%27 stroke=%27black%27 fill=%27none%27 vector-effect=%27non-scaling-stroke%27/%3E%3C/svg%3E");
            }
            /*# sourceURL=webpack://./src/mathml.scss */
            /*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9tYXRobWwuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSwrQ0FBQTtBQUVBO0VBQ0kscUJBQUE7RUFDQSxvQkFBQTtBQUFKOztBQUdBO0VBQ0kscUJBQUE7RUFDQSxvQkFBQTtFQUNBLGtCQUFBO0FBQUo7QUFFSTtFQUNJLHNDQUFBO0FBQVI7QUFHSTtFQUNJLGNBQUE7QUFEUjs7QUFNSTtFQUNJLGtCQUFBO0VBQ0EsbUJBQUE7QUFIUjs7QUFRSTtFQUNJLGtCQUFBO0VBQ0EscUJBQUE7QUFMUjs7QUFTQTtFQUNJLG9CQUFBO0VBQ0Esd0JBQUE7RUFDQSxzQkFBQTtFQUNBLGtCQUFBO0FBTko7QUFRSTtFQUNJLGtCQUFBO0FBTlI7O0FBV0k7RUFBZ0IsU0FBQTtBQVBwQjs7QUFVQTtFQUNJLGtCQUFBO0VBQ0EscUJBQUE7RUFDQSxtQ0FBQTtFQUNBLGlCQUFBO0VBQ0Esc0JBQUE7RUFDQSxnQkFBQTtBQVBKO0FBU0k7RUFDSSxXQUFBO0VBQ0EscUJBQUE7RUFDQSxrQkFBQTtFQUNBLFVBQUE7RUFDQSxVQUFBO0VBQ0EsU0FBQTtFQUNBLFNBQUE7RUFDQSx5REFBQTtBQVBSIiwic291cmNlc0NvbnRlbnQiOlsiQG5hbWVzcGFjZSBcImh0dHA6Ly93d3cudzMub3JnLzE5OTgvTWF0aC9NYXRoTUxcIjtcclxuXHJcbm1hdGgge1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgbGluZS1oZWlnaHQ6IGluaXRpYWw7XHJcbn1cclxuXHJcbm1mcmFjIHtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICAgIHZlcnRpY2FsLWFsaWduOiAtNTAlO1xyXG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG5cclxuICAgICY+OmZpcnN0LWNoaWxkIHtcclxuICAgICAgICBib3JkZXItYm90dG9tOiBzb2xpZCB0aGluIGN1cnJlbnRDb2xvcjtcclxuICAgIH1cclxuXHJcbiAgICAmPioge1xyXG4gICAgICAgIGRpc3BsYXk6IGJsb2NrO1xyXG4gICAgfVxyXG59XHJcblxyXG5tc3ViIHtcclxuICAgICY+Om50aC1jaGlsZCgyKSB7XHJcbiAgICAgICAgZm9udC1zaXplOiBzbWFsbGVyO1xyXG4gICAgICAgIHZlcnRpY2FsLWFsaWduOiBzdWI7XHJcbiAgICB9XHJcbn1cclxuXHJcbm1zdXAge1xyXG4gICAgJj46bnRoLWNoaWxkKDIpIHtcclxuICAgICAgICBmb250LXNpemU6IHNtYWxsZXI7XHJcbiAgICAgICAgdmVydGljYWwtYWxpZ246IHN1cGVyO1xyXG4gICAgfVxyXG59XHJcblxyXG5tdW5kZXIsIG1vdmVyLCBtdW5kZXJvdmVyIHtcclxuICAgIGRpc3BsYXk6IGlubGluZS1mbGV4O1xyXG4gICAgZmxleC1mbG93OiBjb2x1bW4gbm93cmFwO1xyXG4gICAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcclxuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuXHJcbiAgICAmPjpub3QoOmZpcnN0LWNoaWxkKSB7XHJcbiAgICAgICAgZm9udC1zaXplOiBzbWFsbGVyO1xyXG4gICAgfVxyXG59XHJcblxyXG5tdW5kZXJvdmVyIHtcclxuICAgICY+Omxhc3QtY2hpbGQgeyBvcmRlcjogLTE7IH1cclxufVxyXG5cclxubXJvb3QsIG1zcXJ0IHtcclxuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICAgIGJvcmRlci10b3A6IHNvbGlkIHRoaW4gY3VycmVudENvbG9yOyAgXHJcbiAgICBtYXJnaW4tdG9wOiAwLjVweDtcclxuICAgIHZlcnRpY2FsLWFsaWduOiBtaWRkbGU7ICBcclxuICAgIG1hcmdpbi1sZWZ0OiAxY2g7IFxyXG5cclxuICAgICY6YmVmb3JlIHtcclxuICAgICAgICBjb250ZW50OiBcIlwiO1xyXG4gICAgICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICAgICAgICBwb3NpdGlvbjogYWJzb2x1dGU7XHJcbiAgICAgICAgd2lkdGg6IDFjaDtcclxuICAgICAgICBsZWZ0OiAtMWNoO1xyXG4gICAgICAgIHRvcDogLTFweDtcclxuICAgICAgICBib3R0b206IDA7XHJcbiAgICAgICAgYmFja2dyb3VuZC1pbWFnZTogdXJsKFwiZGF0YTppbWFnZS9zdmcreG1sLCUzQ3N2ZyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnIHZpZXdCb3g9JzAgMCAyMCAxMDAnIHByZXNlcnZlQXNwZWN0UmF0aW89J25vbmUnJTNFJTNDcGF0aCBkPSdtMCw3NSBsNSwwIGw1LDI1IGwxMCwtMTAwJyBzdHJva2U9J2JsYWNrJyBmaWxsPSdub25lJyB2ZWN0b3ItZWZmZWN0PSdub24tc2NhbGluZy1zdHJva2UnLyUzRSUzQy9zdmclM0VcIik7XHJcbiAgICB9XHJcbn0iXSwic291cmNlUm9vdCI6IiJ9 */</style><!--docxjs document theme values--><style>.docx {
            --docx-majorHAnsi-font: Calibri Light;
            --docx-minorHAnsi-font: Calibri;
            --docx-dk1-color: #000000;
            --docx-lt1-color: #FFFFFF;
            --docx-dk2-color: #44546A;
            --docx-lt2-color: #E7E6E6;
            --docx-accent1-color: #5B9BD5;
            --docx-accent2-color: #ED7D31;
            --docx-accent3-color: #A5A5A5;
            --docx-accent4-color: #FFC000;
            --docx-accent5-color: #4472C4;
            --docx-accent6-color: #70AD47;
            --docx-hlink-color: #0563C1;
            --docx-folHlink-color: #954F72;
            }
        </style><!--docxjs document styles--><style>.docx span {
            font-family: Arial;
            min-height: 8.00pt;
            font-size: 8.00pt;
            }
            .docx p {
            margin-bottom: 0.15pt;
            line-height: 1.08;
            margin-left: 0.50pt;
            }
            .docx p, p.docx_normal {
            text-indent: -0.50pt;
            }
            .docx p, p.docx_normal span {
            color: #000000;
            }
            p.docx_heading1 {
            margin-top: 24.00pt;
            margin-bottom: 6.00pt;
            text-indent: -0.50pt;
            }
            p.docx_heading1 span {
            font-weight: bold;
            min-height: 24.00pt;
            font-size: 24.00pt;
            color: #000000;
            }
            p.docx_heading2 {
            margin-top: 18.00pt;
            margin-bottom: 4.00pt;
            text-indent: -0.50pt;
            }
            p.docx_heading2 span {
            font-weight: bold;
            min-height: 18.00pt;
            font-size: 18.00pt;
            color: #000000;
            }
            p.docx_heading3 {
            margin-top: 14.00pt;
            margin-bottom: 4.00pt;
            text-indent: -0.50pt;
            }
            p.docx_heading3 span {
            font-weight: bold;
            min-height: 14.00pt;
            font-size: 14.00pt;
            color: #000000;
            }
            p.docx_heading4 {
            margin-top: 12.00pt;
            margin-bottom: 2.00pt;
            text-indent: -0.50pt;
            }
            p.docx_heading4 span {
            font-weight: bold;
            min-height: 12.00pt;
            font-size: 12.00pt;
            color: #000000;
            }
            p.docx_heading5 {
            margin-top: 11.00pt;
            margin-bottom: 2.00pt;
            text-indent: -0.50pt;
            }
            p.docx_heading5 span {
            font-weight: bold;
            min-height: 11.00pt;
            font-size: 11.00pt;
            color: #000000;
            }
            p.docx_heading6 {
            margin-top: 10.00pt;
            margin-bottom: 2.00pt;
            text-indent: -0.50pt;
            }
            p.docx_heading6 span {
            font-weight: bold;
            min-height: 10.00pt;
            font-size: 10.00pt;
            color: #000000;
            }
            .docx table, table.docx_tablenormal td {
            padding-top: 0.00pt;
            padding-left: 5.40pt;
            padding-bottom: 0.00pt;
            padding-right: 5.40pt;
            }
            p.docx_title {
            margin-top: 24.00pt;
            margin-bottom: 6.00pt;
            text-indent: -0.50pt;
            }
            p.docx_title span {
            font-weight: bold;
            min-height: 36.00pt;
            font-size: 36.00pt;
            color: #000000;
            }
            table.docx_tablegrid p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_tablegrid td {
            padding-top: 0.00pt;
            padding-left: 0.00pt;
            padding-bottom: 0.00pt;
            padding-right: 0.00pt;
            }
            p.docx_balloontext {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            p.docx_balloontext span {
            font-family: Tahoma;
            color: #000000;
            }
            p.docx_balloontext span {
            font-family: Tahoma;
            color: #000000;
            min-height: 8.00pt;
            font-size: 8.00pt;
            }
            span.docx_balloontextchar {
            font-family: Tahoma;
            color: #000000;
            min-height: 8.00pt;
            font-size: 8.00pt;
            }
            span.docx_balloontextchar p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            span.docx_balloontextchar {
            font-family: Tahoma;
            color: #000000;
            }
            p.docx_listparagraph {
            margin-left: 36.00pt;
            text-indent: -0.50pt;
            }
            p.docx_listparagraph span {
            color: #000000;
            }
            p.docx_header {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            p.docx_header span {
            color: #000000;
            }
            p.docx_header span {
            font-family: Arial;
            color: #000000;
            min-height: 8.00pt;
            font-size: 8.00pt;
            }
            span.docx_headerchar {
            font-family: Arial;
            color: #000000;
            min-height: 8.00pt;
            font-size: 8.00pt;
            }
            span.docx_headerchar p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            span.docx_headerchar {
            color: #000000;
            }
            table.docx_tablegrid1 p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_tablegrid1 td {
            padding-top: 0.00pt;
            padding-left: 0.00pt;
            padding-bottom: 0.00pt;
            padding-right: 0.00pt;
            }
            table.docx_tablegrid0 p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_tablegrid0 td {
            border-top: 0.50pt solid black;
            border-left: 0.50pt solid black;
            border-bottom: 0.50pt solid black;
            border-right: 0.50pt solid black;
            padding-top: 0.00pt;
            padding-left: 5.40pt;
            padding-bottom: 0.00pt;
            padding-right: 5.40pt;
            }
            table.docx_tablegrid10 p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_tablegrid10 span {
            }
            table.docx_tablegrid10 td {
            border-top: 0.50pt solid black;
            border-left: 0.50pt solid black;
            border-bottom: 0.50pt solid black;
            border-right: 0.50pt solid black;
            padding-top: 0.00pt;
            padding-left: 5.40pt;
            padding-bottom: 0.00pt;
            padding-right: 5.40pt;
            }
            p.docx_footer {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            p.docx_footer span {
            color: #000000;
            }
            p.docx_footer span {
            font-family: Arial;
            color: #000000;
            min-height: 8.00pt;
            font-size: 8.00pt;
            }
            span.docx_footerchar {
            font-family: Arial;
            color: #000000;
            min-height: 8.00pt;
            font-size: 8.00pt;
            }
            span.docx_footerchar p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            span.docx_footerchar {
            color: #000000;
            }
            table.docx_tablegrid2 p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_tablegrid2 td {
            padding-top: 0.00pt;
            padding-left: 0.00pt;
            padding-bottom: 0.00pt;
            padding-right: 0.00pt;
            }
            table.docx_tablegrid3 p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_tablegrid3 td {
            padding-top: 0.00pt;
            padding-left: 0.00pt;
            padding-bottom: 0.00pt;
            padding-right: 0.00pt;
            }
            span.docx_commentreference {
            min-height: 8.00pt;
            font-size: 8.00pt;
            }
            p.docx_commenttext {
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            p.docx_commenttext span {
            min-height: 10.00pt;
            font-size: 10.00pt;
            color: #000000;
            }
            p.docx_commenttext span {
            font-family: Arial;
            color: #000000;
            min-height: 10.00pt;
            font-size: 10.00pt;
            }
            span.docx_commenttextchar {
            font-family: Arial;
            color: #000000;
            min-height: 10.00pt;
            font-size: 10.00pt;
            }
            span.docx_commenttextchar p {
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            span.docx_commenttextchar {
            min-height: 10.00pt;
            font-size: 10.00pt;
            color: #000000;
            }
            p.docx_commentsubject span {
            font-weight: bold;
            min-height: 10.00pt;
            font-size: 10.00pt;
            color: #000000;
            }
            p.docx_commentsubject {
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            p.docx_commentsubject span {
            font-family: Arial;
            font-weight: bold;
            color: #000000;
            min-height: 10.00pt;
            font-size: 10.00pt;
            }
            span.docx_commentsubjectchar {
            font-family: Arial;
            font-weight: bold;
            color: #000000;
            min-height: 10.00pt;
            font-size: 10.00pt;
            }
            span.docx_commentsubjectchar {
            font-weight: bold;
            min-height: 10.00pt;
            font-size: 10.00pt;
            color: #000000;
            }
            span.docx_commentsubjectchar p {
            line-height: 1.00;
            text-indent: -0.50pt;
            }
            span.docx_placeholdertext {
            color: #808080;
            }
            p.docx_subtitle {
            margin-top: 18.00pt;
            margin-bottom: 4.00pt;
            text-indent: -0.50pt;
            }
            p.docx_subtitle span {
            font-family: Georgia;
            font-style: italic;
            color: #666666;
            min-height: 24.00pt;
            font-size: 24.00pt;
            }
            table.docx_a p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_a td {
            padding-left: 7.10pt;
            padding-right: 5.75pt;
            padding-top: 0.00pt;
            padding-bottom: 0.00pt;
            }
            table.docx_a0 p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_a0 td {
            padding-top: 6.60pt;
            padding-bottom: 5.20pt;
            padding-right: 5.75pt;
            padding-left: 5.40pt;
            }
            table.docx_a1 p {
            margin-bottom: 0.00pt;
            line-height: 1.00;
            }
            table.docx_a1 td {
            padding-top: 6.60pt;
            padding-bottom: 5.20pt;
            padding-right: 5.75pt;
            padding-left: 5.40pt;
            }
        </style><style>
            word-wrap: break-word;
        </style>
        <div class="docx-wrapper">
            <section class="docx" style="padding: 24.95pt 34.85pt 14.2pt 28.35pt; width: 595pt; min-height: 842pt;">
                <header>
                    <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; margin-right: 0.35pt; text-align: right;">
                        <span>Obrazac </span>
                        <span>P-1</span>
                    </p>
                    <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; margin-right: 0.35pt; text-align: right;"></p>
                    <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; margin-right: 0.35pt; text-align: right;"></p>
                </header>
                <article>
                    <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                    <table class="no-vband docx_a" style="width: 322.75pt; table-layout: auto;">
                        <colgroup>
                            <col style="width: 66.75pt;"/>
                            <col style="width: 81pt;"/>
                            <col style="width: 135pt;"/>
                            <col style="width: 40pt;"/>
                        </colgroup>
                        <tr style="height: 12.35pt;">
                            <td colspan="4" style="width: 322.75pt; border-width: 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-top: 2pt; margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; text-align: center;">
                                    <span>Popunjava Zavod</span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 19.05pt;">
                            <td style="width: 66.75pt; border-bottom: none; border-right: none; vertical-align: middle; border-left: 1.5pt solid rgb(0, 0, 0); border-top: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Broj prijave</span>
                                </p>
                            </td>
                            <td rowspan="2" colspan="2" style="width: 216pt; border-left: none; border-right: none; vertical-align: middle; border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 16pt; font-size: 16pt;"><xsl:value-of select="//Broj_prijave"/></span>
                                </p>
                            </td>
                            <td style="width: 40pt; border-left: none; border-bottom: none; vertical-align: middle; border-right: 1.5pt solid rgb(0, 0, 0); border-top: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 4.55pt;">
                            <td style="width: 66.75pt; border-top: none; border-right: none; vertical-align: middle; border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span></span>
                                </p>
                            </td>
                            <td colspan="2" style="display: none; width: 216pt; border-left: none; border-right: none; vertical-align: middle; border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td style="width: 40pt; border-top: none; border-left: none; vertical-align: middle; border-right: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 8pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                        </tr>
                        <tr style="height: 19.35pt;">
                            <td colspan="2" style="width: 147.75pt; border-top: 1.5pt solid rgb(0, 0, 0); border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: none; border-right: 1.5pt solid rgb(0, 0, 0); background-color: inherit; vertical-align: middle;">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Datum prijema</span>
                                </p>
                            </td>
                            <td style="width: 135pt; border-top: 1.5pt solid rgb(0, 0, 0); border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: none; border-right: none; background-color: inherit; vertical-align: middle;">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Priznati datum podnosenja</span>
                                </p>
                            </td>
                            <td style="width: 40pt; border-top: 1.5pt solid rgb(0, 0, 0); border-left: none; border-bottom: none; border-right: 1.5pt solid rgb(0, 0, 0); background-color: inherit; vertical-align: middle;">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 19.35pt;">
                            <td colspan="2" style="width: 147.75pt; border-top: none; border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); vertical-align: middle;">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Nova_prijava/Datum_prijave"/></span>
                                </p>
                            </td>
                            <td colspan="2" style="width: 175pt; border-top: none; border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); vertical-align: middle;">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Priznati_datum_prijave"/></span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 19.65pt;">
                            <td colspan="3" style="width: 282.75pt; border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: none; border-right: none; vertical-align: middle; border-left: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Pecat i potpis</span>
                                </p>
                            </td>
                            <td style="width: 40pt; border-top: 1.5pt solid rgb(0, 0, 0); border-left: none; border-bottom: none; vertical-align: middle; border-right: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                        </tr>
                        <tr style="height: 19.25pt;">
                            <td colspan="3" style="width: 282.75pt; border-top: none; border-right: none; vertical-align: middle; border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td style="width: 40pt; border-top: none; border-left: none; vertical-align: middle; border-right: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                        </tr>
                    </table>
                    <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;">
                        <span style="min-height: 10pt; font-size: 10pt;">Republika Srbija</span>
                    </p>
                    <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;">
                        <span style="min-height: 10pt; font-size: 10pt;">Zavod za intelektualnu svojinu</span>
                    </p>
                    <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;">
                        <span style="min-height: 10pt; font-size: 10pt;">Kneginje Ljubice broj 5</span>
                    </p>
                    <p style="margin-bottom: 0pt;">
                        <span style="min-height: 10pt; font-size: 10pt;">11000 Beograd</span>
                    </p>
                    <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;"></p>
                    <p style="margin-bottom: 0.25pt; text-align: center;">
                        <span style="font-weight: bold; min-height: 12pt; font-size: 12pt;">ZAHTEV</span>
                    </p>
                    <p style="margin-bottom: 0.25pt; text-align: center;">
                        <span style="font-weight: bold; min-height: 12pt; font-size: 12pt;">ZA PRIZNANJE PATENTA</span>
                    </p>
                    <p style="margin-bottom: 0.25pt; text-indent: 0pt; margin-left: 0pt;"></p>
                    <p style="margin-bottom: 0.25pt; text-indent: 0pt; margin-left: 0pt;"></p>
                    <p style="margin-bottom: 0.25pt; text-indent: 0pt; margin-left: 0pt; text-align: center;"></p>
                    <table class="no-vband docx_a0" style="width: 529.9pt; table-layout: auto;">
                        <colgroup>
                            <col style="width: 185.1pt;"/>
                            <col style="width: 38.25pt;"/>
                            <col style="width: 146.85pt;"/>
                            <col style="width: 114.35pt;"/>
                            <col style="width: 45.35pt;"/>
                        </colgroup>
                        <tr style="height: 42.1pt;">
                            <td colspan="5" style="width: 529.9pt; border-width: 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 3pt; line-height: 1.08; text-indent: 0pt; margin-left: 0pt; margin-right: 2pt; text-align: justify;">
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Polje Broj I    </span>
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"><span class="docx-tab-stop"></span>NAZIV PRONALASKA</span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0pt; margin-right: 2.85pt; text-align: justify;">
                                    <span>* Naziv pronalaska treba jasno i sazeto da izrazava sustinu i ne sme da sadrzi izmisljene ili komercijalne nazive, zigove, imena, sifre, uobicajene skracenice za proizvode i sl.</span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 14.95pt;">
                            <td colspan="5" style="width: 529.9pt; border-width: 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span id="_heading=h.gjdgxs"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">Na srpskom jeziku:    </span>
                                    <span style="min-height: 9pt; font-size: 9pt;">
                                        <xsl:value-of select="//Srpski_naziv"/>
                                    </span>
                                    <span id="bookmark=id.30j0zll"></span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Na engleskom jeziku:    </span>
                                    <span id="bookmark=id.1fob9te"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">
                                        <xsl:value-of select="//Engleski_naziv"/>
                                    </span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 1pt;">
                            <td colspan="4" style="width: 484.55pt; border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Polje Broj II</span>
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"><span class="docx-tab-stop"> </span>   PODNOSILAC PRIJAVE</span>
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"><span class="docx-tab-stop"> </span>                    </span>
                                    <xsl:choose>
                                        <xsl:when test="//Podnosilac_je_pronalazac = 'true'">
                                            <span style="min-height: 10pt; font-size: 10pt;">PODNOSILAC JE PRONALAZAC</span>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <span style="min-height: 10pt; font-size: 10pt;">PODNOSILAC NIJE PRONALAZAC</span>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">                               </span>
                                </p>
                            </td>
                            <td style="width: 45.35pt; border-top: 1.5pt solid rgb(0, 0, 0); border-left: none; border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                        </tr>
                        <tr style="height: 39.7pt;">
                            <td rowspan="3" style="width: 185.1pt; border-width: 0.75pt 0.75pt 1pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Ime i prezime / Poslovno ime: </span>
                                    <span>(prezime / poslovno ime upisati velikim slovima)</span>
                                </p>
                                <p>
                                    <span id="bookmark=id.3znysh7"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                </p>
                                <p style="text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Naziv"/> </span>
                                </p>
                            </td>
                            <td rowspan="3" colspan="2" style="width: 185.1pt; border-width: 0.75pt 0.75pt 1pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt; margin-right: 1.15pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Ulica i broj, postanski broj, mesto i drzava:</span>
                                </p>
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt; margin-right: 1.15pt;"></p>
                                <p>
                                    <span id="bookmark=id.2et92p0"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Adresa/Ulica_i_broj"/></span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Adresa/Postanski_broj"/></span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Adresa/Mesto"/></span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Adresa/Drzava"/></span>
                                </p>
                            </td>
                            <td colspan="2" style="width: 159.7pt; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Broj telefona:</span>
                                </p>
                                <p>
                                    <span id="bookmark=id.tyjcwt"></span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Kontakt_podaci/Broj_telefona"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 39.1pt;">
                            <td style="display: none; width: 185.1pt; border-width: 0.75pt 0.75pt 1pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="display: none; width: 185.1pt; border-width: 0.75pt 0.75pt 1pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="width: 159.7pt; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Broj faksa:</span>
                                </p>
                                <p>
                                    <span id="bookmark=id.3dy6vkm"></span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Kontakt_podaci/Broj_faksa"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 11.9pt;">
                            <td style="display: none; width: 185.1pt; border-width: 0.75pt 0.75pt 1pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="display: none; width: 185.1pt; border-width: 0.75pt 0.75pt 1pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td rowspan="2" colspan="2" style="width: 159.7pt; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; line-height: 1.08; text-indent: -0.55pt; margin-left: 0.55pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">E-posta:</span>
                                </p>
                                <p>
                                    <span id="bookmark=id.1t3h5sf"></span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Kontakt_podaci/E_posta"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 19.3pt;">
                            <td colspan="2" style="width: 223.35pt; border-top: 0.75pt solid rgb(0, 0, 0); border-bottom: none; border-right: none; border-left: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Drzavljanstvo: </span>
                                    <span id="bookmark=id.4d34og8"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"> </span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Podnosilac/Drzavljanstvo"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"> </span>
                                </p>
                            </td>
                            <td style="width: 146.85pt; border-top: 0.75pt solid rgb(0, 0, 0); border-left: none; border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: 0.75pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="display: none; width: 159.7pt; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                        </tr>
                        <tr style="height: 25pt;">
                            <td colspan="5" style="width: 529.9pt; border-width: 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); vertical-align: middle;">
                                <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Polje broj III        PRONALAZAC</span>
                            </td>
                        </tr>
                        <tr style="height: 15.4pt;">
                            <td rowspan="3" style="width: 185.1pt; border-width: 0.75pt 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Ime i prezime: </span>
                                    <span>(prezime upisati velikim slovima)</span>
                                </p>
                                <p>
                                    <span id="bookmark=id.2s8eyo1"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"> </span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Pronalazac/Naziv"/> </span>
                                </p>
                            </td>
                            <td rowspan="3" colspan="2" style="width: 185.1pt; border-width: 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Ulica i broj, postanski broj, mesto i drzava:</span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;"></p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
                                    <span id="bookmark=id.17dp8vu"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Pronalazac/Adresa/Ulica_i_broj"/></span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Pronalazac/Adresa/Postanski_broj"/> </span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Pronalazac/Adresa/Mesto"/> </span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Pronalazac/Adresa/Drzava"/> </span>
                                </p>
                            </td>
                            <td colspan="2" style="width: 159.7pt; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: -0.55pt; margin-left: 0.55pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Broj telefona:</span>
                                </p>
                                <p style="text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Pronalazac/Kontakt_podaci/Broj_telefona"/></span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 23.25pt;">
                            <td style="display: none; width: 185.1pt; border-width: 0.75pt 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="display: none; width: 185.1pt; border-width: 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="width: 159.7pt; border-width: 0.75pt 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: -0.7pt; margin-left: 0pt; margin-right: 1.45pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Broj faksa:</span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; margin-right: 1.45pt;">
                                    <span id="bookmark=id.3rdcrjn"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Pronalazac/Kontakt_podaci/Broj_faksa"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                    <span id="bookmark=id.26in1rg"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">               </span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 23.25pt;"><td style="display: none; width: 185.1pt; border-width: 0.75pt 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                            <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                        </td>
                            <td colspan="2" style="display: none; width: 185.1pt; border-width: 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="width: 159.7pt; border-width: 0.75pt 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt; margin-right: 1.45pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">E-posta:</span>
                                </p>
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt; margin-right: 1.45pt;">
                                    <span id="bookmark=id.lnxbz9"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Pronalazac/Kontakt_podaci/E_posta"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                </p>
                            </td>
                        </tr>
                    </table>
                    <p style="margin-bottom: 8pt; text-indent: 0pt; margin-left: 0pt;"></p>
                    <p style="text-indent: 0pt; margin-left: 0pt;"></p>
                    <table class="no-vband docx_a1" style="width: 529.8pt; table-layout: auto;">
                        <colgroup>
                            <col style="width: 19.1pt;"/>
                            <col style="width: 116.65pt;"/>
                            <col style="width: 116.6pt;"/>
                            <col style="width: 10.95pt;"/>
                            <col style="width: 118.1pt;"/>
                            <col style="width: 21.6pt;"/>
                            <col style="width: 90pt;"/>
                            <col style="width: 36.8pt;"/>
                        </colgroup>
                        <tr style="height: 90.7pt;">
                            <td colspan="8" style="width: 529.8pt; border-width: 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; line-height: 1.08; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Polje Broj IV          </span>
                                    <xsl:choose>
                                        <xsl:when test="//Punomocnik/Tip_punomocnika/Punomocnik_za_prijem_pismena">
                                            <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">  PUNOMOCNIK ZA PRIJEM PISMENA            </span>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">  PUNOMOCNIK ZA ZASTUPANJE             </span>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </p>
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt;">
                                    <xsl:choose>
                                        <xsl:when test="//Zajednicki_predstavnik = 'true'">
                                            <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">                                 JESTE ZAJEDNICKI PREDSTAVNIK</span>
                                            <span style="min-height: 9pt; font-size: 9pt;"><span class="docx-tab-stop"> </span></span>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">                                 NIJE ZAJEDNICKI PREDSTAVNIK</span>
                                            <span style="min-height: 9pt; font-size: 9pt;"><span class="docx-tab-stop"> </span></span>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </p>
                                <p style="margin-bottom: 2pt; line-height: 1.08; text-indent: 0pt; margin-left: 0pt;">
                                    <span>* Punomocnik za zastupanje je lice koje po ovlascenju podnosioca prijave preduzima radnje u upravnom postupku u granicama punomocja</span>
                                </p>
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span>* Punomocnik za prijem pismena je lice koje je podnosilac prijave odredio kao lice kome se upucuju sva pismena naslovljena na podnosioca</span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span>* Zajednicki predstavnik je podnosilac prijave koga su podnosioci prijave, u slucaju da prijavu podnosi vise lica, odredili da istupa u postupku pred organom ako podnosioci nisu imenovali zajednickog punomocnika za zastupanje</span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 31.2pt;">
                            <td rowspan="2" colspan="4" style="width: 263.3pt; border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Ime i prezime / Poslovno ime</span>
                                    <span>: (prezime / poslovno ime upisati velikim slovima)</span>
                                    <span style="min-height: 9pt; font-size: 9pt;"> </span>
                                </p>
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
                                    <span id="bookmark=id.35nkun2"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">    </span>
                                </p>
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Punomocnik/Naziv"/> </span>
                                </p>
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;"></p>
                            </td>
                            <td rowspan="2" colspan="2" style="width: 139.7pt; border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Ulica i broj, postanski broj, mesto, drzava:</span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;"></p>
                                <p>
                                    <span id="bookmark=id.1ksv4uv"></span>
                                    <span> </span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Punomocnik/Adresa/Ulica_i_broj"/> </span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Punomocnik/Adresa/Postanski_broj"/></span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Punomocnik/Adresa/Mesto"/> </span>
                                </p>
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Punomocnik/Adresa/Drzava"/></span>
                                </p>
                            </td>
                            <td colspan="2" style="width: 126.8pt; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: -0.55pt; margin-left: 0.55pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Broj telefona:</span>
                                </p>
                                <p style="text-indent: 0pt; margin-left: 0pt;">
                                    <span id="bookmark=id.44sinio"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Punomocnik/Kontakt_podaci/Broj_telefona"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 8.2pt;">
                            <td colspan="4" style="display: none; width: 263.3pt; border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="display: none; width: 139.7pt; border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="width: 126.8pt; border-width: 0.75pt 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p>
                                    <span style="min-height: 9pt; font-size: 9pt;">E-posta:</span>
                                </p>
                                <p>
                                    <span id="bookmark=id.2jxsxqh"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Punomocnik/Kontakt_podaci/E_posta"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"> </span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 39.7pt;">
                            <td colspan="8" style="width: 529.8pt; border-width: 1.5pt 1.5pt 0.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 2pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Polje Broj V        (ELEKTRONSKA) ADRESA ZA DOSTAVLJANJE  </span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span>(ovo polje se popunjava ako podnosilac prijave, zajednicki predstavnik ili punomocnik zeli da se dostavljanje podnesaka vrsi na drugoj adresi od njegove navedene adrese)</span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 17pt;">
                            <td colspan="8" style="width: 529.8pt; border-width: 0.5pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <xsl:choose>
                                        <xsl:when test="//Nacin_dostavljanja/Papirni">
                                            <span style="min-height: 9pt; font-size: 9pt;">Ulica i broj, postanski broj i mesto: </span>
                                            <span id="bookmark=id.z337ya"></span>
                                            <span style="min-height: 9pt; font-size: 9pt;"> </span>
                                            <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Nacin_dostavljanja/Papirni/Adresa/Ulica_i_broj"/>, </span>
                                            <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Nacin_dostavljanja/Papirni/Adresa/Postanski_broj"/>, </span>
                                            <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Nacin_dostavljanja/Papirni/Adresa/Mesto"/>, </span>
                                            <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Nacin_dostavljanja/Papirni/Adresa/Drzava"/></span>
                                            <span style="min-height: 9pt; font-size: 9pt;">  </span>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <span style="min-height: 9pt; font-size: 9pt;">Elektronska adresa: </span>
                                            <span id="bookmark=id.z337ya"></span>
                                            <span style="min-height: 9pt; font-size: 9pt;"> </span>
                                            <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Nacin_dostavljanja/Elektronski/Email"/> </span>
                                            <span style="min-height: 9pt; font-size: 9pt;">  </span>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 17pt;">
                            <td colspan="8" style="width: 529.8pt; border-width: 0.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Polje Broj VI        NACIN DOSTAVLJANJA</span>
                                </p>
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                        </tr>
                        <tr style="height: 35pt;">
                            <td colspan="8" style="width: 529.8pt; border-width: 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <xsl:choose>
                                    <xsl:when test="//Nacin_dostavljanja/Elektronski">
                                        <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;">
                                            <span style="min-height: 9pt; font-size: 9pt;">Podnosilac prijave je saglasan da Zavod vrsi dostavljanje pismena iskljucivo elektronskim putem u formi</span>
                                            <span>(u ovom slucaju neophodna je registracija na portalu "eUprave")</span>
                                        </p>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;">
                                            <span style="min-height: 9pt; font-size: 9pt;">Podnosilac prijave je saglasan da Zavod vrsi dostavljanje pismena u papirnoj formi </span>
                                        </p>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>
                        </tr>
                        <tr style="height: 7.4pt;">
                            <td colspan="7" style="width: 493pt; border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Polje Broj VII</span>
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"><span class="docx-tab-stop"> </span></span>
                                    <xsl:choose>
                                        <xsl:when test="//Dodatna_prijava/Tip_prijave/Dopunska_prijava">
                                            <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">DOPUNSKA PRIJAVA</span>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">IZDVOJENA PRIJAVA</span>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </p>
                            </td>
                            <td style="width: 36.8pt; border-top: 1.5pt solid rgb(0, 0, 0); border-left: none; border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 7.4pt;">
                            <td colspan="7" style="width: 493pt; border-top: 0.75pt solid rgb(0, 0, 0); border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Broj prvobitne prijave / osnovne prijave, odnosno osnovnog patenta: </span>
                                    <span id="bookmark=id.3j2qqm3"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">  </span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Dodatna_prijava/Broj_prvobitne_prijave"/> </span>
                                    <span style="min-height: 9pt; font-size: 9pt;">   </span>
                                </p>
                            </td>
                            <td style="width: 36.8pt; border-top: 0.75pt solid rgb(0, 0, 0); border-left: none; border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                        </tr>
                        <tr style="height: 7.4pt;">
                            <td colspan="7" style="width: 493pt; border-top: 0.75pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Datum podnosenja prvobitne prijave / osnovne prijave: </span>
                                    <span id="bookmark=id.1y810tw"></span>
                                    <span style="min-height: 9pt; font-size: 9pt;">  </span>
                                    <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Dodatna_prijava/Datum_podnosenja_prijave"/></span>
                                    <span style="min-height: 9pt; font-size: 9pt;"> </span>
                                </p>
                            </td>
                            <td style="width: 36.8pt; border-top: 0.75pt solid rgb(0, 0, 0); border-left: none; border-bottom: 1.5pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                        </tr>
                        <tr style="height: 7.4pt;">
                            <td colspan="7" style="width: 493pt; border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Polje Broj VIII       ZAHTEV ZA PRIZNANJE PRAVA PRVENSTVA IZ RANIJIH PRIJAVA: </span>
                                    <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"><span class="docx-tab-stop"> </span></span>
                                </p>
                            </td>
                        </tr>
                        <tr style="height: 28.35pt;">
                            <td colspan="2" style="width: 135.75pt; border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; text-align: center;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Datum podnosenja ranije prijave</span>
                                </p>
                            </td>
                            <td style="width: 116.6pt; border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="border-width: initial; border-style: none; border-color: initial; margin-bottom: 0pt; line-height: 1.15; text-indent: 0pt; margin-left: 0pt;"></p>
                            </td>
                            <td colspan="2" style="width: 129.05pt; border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; text-align: center;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Broj ranije prijave </span>
                                </p>
                            </td>
                            <td colspan="3" style="width: 148.4pt; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; text-align: center;">
                                    <span style="min-height: 9pt; font-size: 9pt;">Dvoslovna oznaka drzave, regionalne ili medjunarodne organizacije</span>
                                </p>
                            </td>
                        </tr>

                        <xsl:for-each select="//Priznanja_prava_prvenstva/Priznanje_prava_prvenstva">
                            <tr style="height: 15.85pt;">
                                <td style="width: 19.1pt; border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                    <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; text-align: center;">
                                        <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">
                                            <xsl:value-of select="position()"/>.
                                        </span>
                                    </p>
                                </td>
                                <td style="width: 116.65pt; border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                    <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                        <span id="bookmark=id.4i7ojhp"></span>
                                        <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                        <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Datum_prijave"/></span>
                                    </p>
                                </td>
                                <td style="width: 116.6pt; border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                    <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;"></p>
                                </td>
                                <td colspan="2" style="width: 129.05pt; border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                    <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                        <span id="bookmark=id.2xcytpi"></span>
                                        <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                        <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Broj_prvobitne_prijave"/></span>
                                    </p>
                                </td>
                                <td colspan="3" style="width: 148.4pt; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0);">
                                    <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt;">
                                        <span id="bookmark=id.1ci93xb"></span>
                                        <span style="min-height: 9pt; font-size: 9pt;">     </span>
                                        <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//Dvoslovna_oznaka_drzave_organizacije"/></span>
                                    </p>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </article>
            </section>
        </div>
        </html>
    </xsl:template>
</xsl:stylesheet>