package cn.bdqn.web.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.bdqn.entity.UserBean;
import cn.bdqn.sevice.UserJsonService;



//导出excel
public class ExcelExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 确认当前系统属性。获取当前系统属性。系统文件分割
	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 请求发送都是utf-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 查询用户信息
		List<UserBean> list = new UserJsonService().finall();

		// 本地年月日时分秒作为文件名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(new Date()) + ".xlsx";
		// 文件路径
		String filePath = FILE_SEPARATOR + fileName;

		try {
			// 输出流
			OutputStream os = new FileOutputStream(filePath);
			// 工作区
			XSSFWorkbook wb = new XSSFWorkbook();
			// 工作区名
			XSSFSheet sheet = wb.createSheet("通讯录");

			// 创建表头
			XSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("考题编号");
			row.createCell(1).setCellValue("考试内容");
			row.createCell(2).setCellValue("考试类型");
			row.createCell(3).setCellValue("考题分数");
			row.createCell(4).setCellValue("答案A");
			row.createCell(5).setCellValue("答案B");
			row.createCell(6).setCellValue("答案C");
			row.createCell(7).setCellValue("答案D");
			row.createCell(8).setCellValue("考试答案");

			
			
			
			
			
			// 遍历数据装进table
			for (int i = 0; i < list.size(); i++) {
				// sheet.createRow(i+1) 因为表头是0
				XSSFRow rows = sheet.createRow(i + 1);
				rows.createCell(0).setCellValue(list.get(i).getIssueId());
				rows.createCell(1).setCellValue(list.get(i).getIssueText());
				rows.createCell(2).setCellValue(list.get(i).getIssueType());
				rows.createCell(3).setCellValue(list.get(i).getScore());
				rows.createCell(4).setCellValue(list.get(i).getAnswerA());
				rows.createCell(5).setCellValue(list.get(i).getAnswerB());
				rows.createCell(6).setCellValue(list.get(i).getAnswerC());
				rows.createCell(7).setCellValue(list.get(i).getAnswerD());
				rows.createCell(8).setCellValue(list.get(i).getAnswer());
			}

			wb.write(os);
			// 关闭输出流
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		download(filePath, response);

	}
	
	
	
	private void download(String path, HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="+ new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
