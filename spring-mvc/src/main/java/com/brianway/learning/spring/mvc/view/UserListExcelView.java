package com.brianway.learning.spring.mvc.view;

import com.brianway.learning.spring.mvc.domain.User;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://stackoverflow.com/questions/37983946/abstractexcelview-is-deprecated-in-spring-based-application
public class UserListExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=" +
                new String("用户列表".getBytes(), "iso8859-1"));
        List<User> userList = (List<User>) model.get("userList");
        HSSFSheet sheet = workbook.createSheet("users");
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("帐号");
        header.createCell(1).setCellValue("姓名");
        header.createCell(2).setCellValue("生日");

        int rowNum = 1;
        for (User user : userList) {
            HSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getUserName());
            row.createCell(1).setCellValue(user.getRealName());
            String createDate = DateFormatUtils.format(user.getBirthday(),
                    "yyyy-MM-dd");
            row.createCell(2).setCellValue(createDate);
        }
    }
}
