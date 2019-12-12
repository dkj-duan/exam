package cn.bdqn.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.Admin;
import cn.bdqn.sevice.AdminSevice;
import cn.bdqn.sevice.impl.AdminSeviceImpl;
import cn.bdqn.utils.MD5Util;

public class AdminServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7379791879995303486L;

	private AdminSevice adSevice = new AdminSeviceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}


	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String judge = req.getParameter("judge");
		if ("login".equals(judge)) {		
			//��¼
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
			//��������ǩ��
			String md5Pwd = MD5Util.encode(pwd);
			//���ò�ѯ�û��ķ���
			Admin ad = adSevice.adminLogin(name, md5Pwd);
			if (ad!=null) {
				//����������
				HttpSession se = req.getSession();
				se.setAttribute("admin", ad);
				resp.sendRedirect("adinmInformation.jsp");
			}else{
				resp.sendRedirect("adminLogin.jsp");
			}
		}else{
			//ע��
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			String cardId = req.getParameter("cardId");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			try {
				//��������ǩ��
				String md5Pwd = MD5Util.encode(pwd);
				//��װ����
				Admin ad = new Admin();
				ad.setAdminName(name);
				ad.setAdminPwd(md5Pwd);
				ad.setAdminEmail(email);
				ad.setAdminCardId(cardId);
				ad.setAdminPhone(phone);
				//����ע�᷽��
				adSevice.adminRegister(ad);
				//����������
				//����������
				HttpSession se = req.getSession();
				se.setAttribute("adLogin", ad);
				resp.sendRedirect("adminLogin.jsp");
			} catch (Exception e) {
				resp.sendRedirect("mass.jsp");
			}
		}
	
	}

}
