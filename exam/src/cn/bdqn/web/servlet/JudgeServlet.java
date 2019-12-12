package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.bdqn.entity.Admin;
import cn.bdqn.entity.Student;
import cn.bdqn.sevice.AdminSevice;
import cn.bdqn.sevice.StudentSevice;
import cn.bdqn.sevice.impl.AdminSeviceImpl;
import cn.bdqn.sevice.impl.StudentSeviceImpl;

public class JudgeServlet  extends HttpServlet{

	private StudentSevice stuSevice = new StudentSeviceImpl();
	private AdminSevice adSevice = new AdminSeviceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -7450377642917023213L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ju = req.getParameter("ju");
		if ("stu".equals(ju)) {
			
			//获得注册的用户名
			String name = req.getParameter("name");
			Student stu = stuSevice.queryName(name);
			Map<String, Object> map = new HashMap<String, Object>();
			if (stu!=null) {
				map.put("boolean", false);
				map.put("span", "<span class='tiShi'>*用户名不可用</span>");
			}else{
				map.put("boolean", true);
				map.put("span", "<span class='tiShi' style = 'color: green;' >*用户名可用</span>");
			}
			//转换位json
			String json = JSONObject.toJSONString(map);
			//传递值
			resp.getWriter().write(json);
		}else{
			//获得注册的用户名
			String name = req.getParameter("name");
			Admin ad = adSevice.queryName(name);
			Map<String, Object> map = new HashMap<String, Object>();
			if (ad!=null) {
				map.put("boolean", false);
				map.put("span", "<span class='tiShi'>*用户名不可用</span>");
			}else{
				map.put("boolean", true);
				map.put("span", "<span class='tiShi' style = 'color: green;' >*用户名可用</span>");
			}
			//转换位json
			String json = JSONObject.toJSONString(map);
			//传递值
			resp.getWriter().write(json);
		}
		
	
	}
}
