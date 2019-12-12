package cn.bdqn.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.Student;
import cn.bdqn.sevice.StudentSevice;
import cn.bdqn.sevice.impl.StudentSeviceImpl;
import cn.bdqn.utils.MD5Util;

@WebServlet("/stu")
public class StuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6877340024563336422L;

	private StudentSevice stuSevice = new StudentSeviceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String judge = req.getParameter("judge");
		if ("login".equals(judge)) {		
			//登录
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
			//调用查询用户的方法
			String md5Pwd = MD5Util.encode(pwd);
			Student stu = stuSevice.stuLogin(name, md5Pwd);
			if (stu!=null) {
				//设置作用于
				HttpSession se = req.getSession();
				se.setAttribute("stu", stu);
				resp.sendRedirect("stuInformation.jsp");
			}else{
				resp.sendRedirect("login.jsp");
			}
		}else{
			//注册
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			String cardId = req.getParameter("cardId");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			try {
				//设置密码签名
				String md5Pwd = MD5Util.encode(pwd);
				//封装数据
				Student stu = new Student();
				stu.setStuName(name);
				stu.setStuPwd(md5Pwd);
				stu.setStuEmail(email);
				stu.setStuCardId(cardId);
				stu.setStuPhone(phone);
				//调用注册方法
				stuSevice.stuRegister(stu);
				//设置作用域
				//设置作用于
				HttpSession se = req.getSession();
				se.setAttribute("login", stu);
				resp.sendRedirect("login.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("mass.jsp");
			}
		}
	}
}
