package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import cn.bdqn.entity.Student;
import cn.bdqn.sevice.StudentSevice;
import cn.bdqn.sevice.impl.StudentSeviceImpl;
import cn.bdqn.utils.MD5Util;

@WebServlet("/updateStu")
public class UpdateStuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4357971485842996795L;

	private StudentSevice stuSevice = new StudentSeviceImpl();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		 //获得学生对象
		HttpSession se = req.getSession();
		Student stu =  (Student)se.getAttribute("stu");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String pwd = req.getParameter("pwd");
			String yuanPwd = req.getParameter("yuanPwd");
			//设置密码签名
			String md5YuanPwd = MD5Util.encode(yuanPwd);
			String md5Pwd = MD5Util.encode(pwd);
			if (md5YuanPwd.equals(stu.getStuPwd())) {
				stu.setStuPwd(md5Pwd);
				//调用修改密码的方法
				stuSevice.updatePwd(stu);
				map.put("qu", true);
			}else{
				map.put("qu", false);
			}
			//转为JSON对象
			String json = JSONObject.toJSONString(map);
			resp.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("qu", false);
			String json = JSONObject.toJSONString(map);
			resp.getWriter().write(json);
		}
		
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
