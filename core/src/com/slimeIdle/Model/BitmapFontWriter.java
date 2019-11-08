package com.slimeIdle.Model;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.utils.Array;

public class BitmapFontWriter {
    private static BitmapFontWriter.OutputFormat format;

    public BitmapFontWriter() {
    }

    public static void setOutputFormat(BitmapFontWriter.OutputFormat fmt) {
        if (fmt == null) {
            throw new NullPointerException("format cannot be null");
        } else {
            format = fmt;
        }
    }

    public static BitmapFontWriter.OutputFormat getOutputFormat() {
        return format;
    }

    private static String quote(Object params) {
        return quote(params, false);
    }

    private static String quote(Object params, boolean spaceAfter) {
        return getOutputFormat() == BitmapFontWriter.OutputFormat.XML ? "\"" + params.toString().trim() + "\"" + (spaceAfter ? " " : "") : params.toString();
    }

    public static void writeFont(BitmapFont.BitmapFontData fontData, String[] pageRefs, FileHandle outFntFile, BitmapFontWriter.FontInfo info, int scaleW, int scaleH) {
        if (info == null) {
            info = new BitmapFontWriter.FontInfo();
            info.face = outFntFile.nameWithoutExtension();
        }

        int lineHeight = (int)fontData.lineHeight;
        int pages = pageRefs.length;
        int packed = 0;
        int base = (int)(fontData.capHeight + (fontData.flipped ? -fontData.ascent : fontData.ascent));
        BitmapFontWriter.OutputFormat fmt = getOutputFormat();
        boolean xml = fmt == BitmapFontWriter.OutputFormat.XML;
        StringBuilder buf = new StringBuilder();
        if (xml) {
            buf.append("<font>\n");
        }

        String xmlOpen = xml ? "\t<" : "";
        String xmlCloseSelf = xml ? "/>" : "";
        String xmlTab = xml ? "\t" : "";
        String xmlClose = xml ? ">" : "";
        String xmlQuote = xml ? "\"" : "";
        String alphaChnlParams = xml ? " alphaChnl=\"0\" redChnl=\"0\" greenChnl=\"0\" blueChnl=\"0\"" : " alphaChnl=0 redChnl=0 greenChnl=0 blueChnl=0";
        buf.append(xmlOpen).append("info face=\"").append(info.face == null ? "" : info.face.replaceAll("\"", "'")).append("\" size=").append(quote(info.size)).append(" bold=").append(quote(info.bold ? 1 : 0)).append(" italic=").append(quote(info.italic ? 1 : 0)).append(" charset=\"").append(info.charset == null ? "" : info.charset).append("\" unicode=").append(quote(info.unicode ? 1 : 0)).append(" stretchH=").append(quote(info.stretchH)).append(" smooth=").append(quote(info.smooth ? 1 : 0)).append(" aa=").append(quote(info.aa)).append(" padding=").append(xmlQuote).append(info.padding.up).append(",").append(info.padding.right).append(",").append(info.padding.down).append(",").append(info.padding.left).append(xmlQuote).append(" spacing=").append(xmlQuote).append(info.spacing.horizontal).append(",").append(info.spacing.vertical).append(xmlQuote).append(xmlCloseSelf).append("\n");
        buf.append(xmlOpen).append("common lineHeight=").append(quote(lineHeight)).append(" base=").append(quote(base)).append(" scaleW=").append(quote(scaleW)).append(" scaleH=").append(quote(scaleH)).append(" pages=").append(quote(pages)).append(" packed=").append(quote(Integer.valueOf(packed))).append(alphaChnlParams).append(xmlCloseSelf).append("\n");
        if (xml) {
            buf.append("\t<pages>\n");
        }

        for(int i = 0; i < pageRefs.length; ++i) {
            buf.append(xmlTab).append(xmlOpen).append("page id=").append(quote(i)).append(" file=\"").append(pageRefs[i]).append("\"").append(xmlCloseSelf).append("\n");
        }

        if (xml) {
            buf.append("\t</pages>\n");
        }

        Array<BitmapFont.Glyph> glyphs = new Array(256);

        int i;
        int j;
        for(i = 0; i < fontData.glyphs.length; ++i) {
            if (fontData.glyphs[i] != null) {
                for(j = 0; j < fontData.glyphs[i].length; ++j) {
                    if (fontData.glyphs[i][j] != null) {
                        glyphs.add(fontData.glyphs[i][j]);
                    }
                }
            }
        }

        buf.append(xmlOpen).append("chars count=").append(quote(glyphs.size)).append(xmlClose).append("\n");
        i = 0;
        int padRight = 0;
        int padTop = 0;
        int padX = 0;
        int padY = 0;
        if (info != null) {
            padTop = info.padding.up;
            i = info.padding.left;
            j = info.padding.right;
            int var10000 = i + j;
            var10000 = info.padding.up + info.padding.down;
        }

        int kernCount;
        for(kernCount = 0; kernCount < glyphs.size; ++kernCount) {
            BitmapFont.Glyph g = (BitmapFont.Glyph)glyphs.get(kernCount);
            boolean empty = g.width == 0 || g.height == 0;
            buf.append(xmlTab).append(xmlOpen).append("char id=").append(quote(String.format("%-6s", g.id), true)).append("x=").append(quote(String.format("%-5s", empty ? 0 : g.srcX), true)).append("y=").append(quote(String.format("%-5s", empty ? 0 : g.srcY), true)).append("width=").append(quote(String.format("%-5s", empty ? 0 : g.width), true)).append("height=").append(quote(String.format("%-5s", empty ? 0 : g.height), true)).append("xoffset=").append(quote(String.format("%-5s", g.xoffset - i), true)).append("yoffset=").append(quote(String.format("%-5s", fontData.flipped ? g.yoffset + padTop : -(g.height + g.yoffset + padTop)), true)).append("xadvance=").append(quote(String.format("%-5s", g.xadvance), true)).append("page=").append(quote(String.format("%-5s", g.page), true)).append("chnl=").append(quote(0, true)).append(xmlCloseSelf).append("\n");
        }

        if (xml) {
            buf.append("\t</chars>\n");
        }

        kernCount = 0;
        StringBuilder kernBuf = new StringBuilder();

        for(int indx = 0; indx < glyphs.size; ++indx) {
            for(int jg = 0; jg < glyphs.size; ++jg) {
                BitmapFont.Glyph first = (BitmapFont.Glyph)glyphs.get(indx);
                BitmapFont.Glyph second = (BitmapFont.Glyph)glyphs.get(jg);
                int kern = first.getKerning((char)second.id);
                if (kern != 0) {
                    ++kernCount;
                    kernBuf.append(xmlTab).append(xmlOpen).append("kerning first=").append(quote(first.id)).append(" second=").append(quote(second.id)).append(" amount=").append(quote(kern, true)).append(xmlCloseSelf).append("\n");
                }
            }
        }

        buf.append(xmlOpen).append("kernings count=").append(quote(kernCount)).append(xmlClose).append("\n");
        buf.append(kernBuf);
        if (xml) {
            buf.append("\t</kernings>\n");
        }

        if (info.hasOverrideMetrics) {
            if (xml) {
                buf.append("\t<metrics>\n");
            }

            buf.append(xmlTab).append(xmlOpen).append("metrics ascent=").append(quote(info.ascent, true)).append(" descent=").append(quote(info.descent, true)).append(" down=").append(quote(info.down, true)).append(" capHeight=").append(quote(info.capHeight, true)).append(" lineHeight=").append(quote(info.lineHeight, true)).append(" spaceXAdvance=").append(quote(info.spaceXAdvance, true)).append(" xHeight=").append(quote(info.xHeight, true)).append(xmlCloseSelf).append("\n");
            if (xml) {
                buf.append("\t</metrics>\n");
            }
        }

        if (xml) {
            buf.append("</font>");
        }

        String charset = info.charset;
        if (charset != null && charset.length() == 0) {
            charset = null;
        }

        outFntFile.writeString(buf.toString(), false, charset);
    }

    public static void writeFont(BitmapFont.BitmapFontData fontData, Pixmap[] pages, FileHandle outFntFile, BitmapFontWriter.FontInfo info) {
        String[] pageRefs = writePixmaps(pages, outFntFile.parent(), outFntFile.nameWithoutExtension());
        writeFont(fontData, pageRefs, outFntFile, info, pages[0].getWidth(), pages[0].getHeight());
    }

    public static String[] writePixmaps(Pixmap[] pages, FileHandle outputDir, String fileName) {
        if (pages != null && pages.length != 0) {
            String[] pageRefs = new String[pages.length];

            for(int i = 0; i < pages.length; ++i) {
                String ref = pages.length == 1 ? fileName + ".png" : fileName + "_" + i + ".png";
                pageRefs[i] = ref;
                PixmapIO.writePNG(outputDir.child(ref), pages[i]);
            }

            return pageRefs;
        } else {
            throw new IllegalArgumentException("no pixmaps supplied to BitmapFontWriter.write");
        }
    }

    public static String[] writePixmaps(Array<PixmapPacker.Page> pages, FileHandle outputDir, String fileName) {
        Pixmap[] pix = new Pixmap[pages.size];

        for(int i = 0; i < pages.size; ++i) {
            pix[i] = ((PixmapPacker.Page)pages.get(i)).getPixmap();
        }

        return writePixmaps(pix, outputDir, fileName);
    }

    static {
        format = BitmapFontWriter.OutputFormat.Text;
    }

    public static class FontInfo {
        public String face;
        public int size = 12;
        public boolean bold;
        public boolean italic;
        public String charset;
        public boolean unicode = true;
        public int stretchH = 100;
        public boolean smooth = true;
        public int aa = 2;
        public BitmapFontWriter.Padding padding = new BitmapFontWriter.Padding();
        public BitmapFontWriter.Spacing spacing = new BitmapFontWriter.Spacing();
        public int outline = 0;
        public boolean hasOverrideMetrics;
        public float ascent;
        public float descent;
        public float down;
        public float capHeight;
        public float lineHeight;
        public float spaceXAdvance;
        public float xHeight;

        public FontInfo() {
        }

        public FontInfo(String face, int size) {
            this.face = face;
            this.size = size;
        }

        public void overrideMetrics(BitmapFont.BitmapFontData data) {
            this.hasOverrideMetrics = true;
            this.ascent = data.ascent;
            this.descent = data.descent;
            this.down = data.down;
            this.capHeight = data.capHeight;
            this.lineHeight = data.lineHeight;
            //this.spaceXAdvance = data.spaceXadvance;
            this.xHeight = data.xHeight;
        }
    }

    public static class Spacing {
        public int horizontal;
        public int vertical;

        public Spacing() {
        }
    }

    public static class Padding {
        public int up;
        public int down;
        public int left;
        public int right;

        public Padding() {
        }

        public Padding(int up, int down, int left, int right) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }

    public static enum OutputFormat {
        Text,
        XML;

        private OutputFormat() {
        }
    }
}
