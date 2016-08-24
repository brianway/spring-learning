package com.brianway.learning.spring.mvc.web;

import com.brianway.learning.spring.mvc.domain.User;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import static com.lowagie.text.FontFactory.TIMES_ROMAN;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;

import com.lowagie.text.pdf.PdfWriter;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.*;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=" +
                new String("用户列表".getBytes(), "iso8859-1"));
        List<User> userList = (List<User>) model.get("userList");
        Table table = new Table(3);
        table.setWidth(80);
        table.setBorder(1);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        //BaseFont cnBaseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
        BaseFont cnBaseFont = BaseFont.createFont();
        Font cnFont = new Font(cnBaseFont, 10, Font.NORMAL, Color.BLUE);

        table.addCell(buildFontCell("帐号", cnFont));
        table.addCell(buildFontCell("姓名", cnFont));
        table.addCell(buildFontCell("生日", cnFont));
        for (User user : userList) {
            table.addCell(user.getUserName());
            table.addCell(buildFontCell(user.getRealName(), cnFont));
            String createDate = DateFormatUtils.format(user.getBirthday(),
                    "yyyy-MM-dd");
            table.addCell(createDate);
        }
        document.add(table);

    }

    private Cell buildFontCell(String content, Font font) throws RuntimeException {
        try {
            Phrase phrase = new Phrase(content, font);
            return new Cell(phrase);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
