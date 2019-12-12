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



//����excel
public class ExcelExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ȷ�ϵ�ǰϵͳ���ԡ���ȡ��ǰϵͳ���ԡ�ϵͳ�ļ��ָ�
	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// �����Ͷ���utf-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// ��ѯ�û���Ϣ
		List<UserBean> list = new UserJsonService().finall();

		// ����������ʱ������Ϊ�ļ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(new Date()) + ".xlsx";
		// �ļ�·��
		String filePath = FILE_SEPARATOR + fileName;

		try {
			// �����
			OutputStream os = new FileOutputStream(filePath);
			// ������
			XSSFWorkbook wb = new XSSFWorkbook();
			// ��������
			XSSFSheet sheet = wb.createSheet("ͨѶ¼");

			// ������ͷ
			XSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("������");
			row.createCell(1).setCellValue("��������");
			row.createCell(2).setCellValue("��������");
			row.createCell(3).setCellValue("�������");
			row.createCell(4).setCellValue("��A");
			row.createCell(5).setCellValue("��B");
			row.createCell(6).setCellValue("��C");
			row.createCell(7).setCellValue("��D");
			row.createCell(8).setCellValue("���Դ�");

			
			
			
			
			
			// ��������װ��table
			for (int i = 0; i < list.size(); i++) {
				// sheet.createRow(i+1) ��Ϊ��ͷ��0
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
			// �ر������
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		download(filePath, response);

	}
	
	
	
	private void download(String path, HttpServletResponse response) {
		try {
			// path��ָ�����ص��ļ���·����
			File file = new File(path);
			// ȡ���ļ�����
			String filename = file.getName();
			// ��������ʽ�����ļ���
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// ���response
			response.reset();
			// ����response��Header
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
