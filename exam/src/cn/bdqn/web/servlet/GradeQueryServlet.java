package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import com.alibaba.fastjson.JSONObject;

import cn.bdqn.entity.Grade;
import cn.bdqn.entity.Student;
import cn.bdqn.sevice.GradeService;
import cn.bdqn.sevice.impl.GradeServiceImpl;

@WebServlet("/grade")
public class GradeQueryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7067222592221638382L;

	private GradeService gradeService = new GradeServiceImpl();
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		try {
			HttpSession se = req.getSession();
			 Student stu = (Student)se.getAttribute("stu");
			 List<Grade> grades = gradeService.queryGrade(stu.getStuId());
			 //设置作用域
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("stu", stu);
			 map.put("grades", grades);
			 //转换JSON对象
			 String Json = JSONObject.toJSONString(map);
			 //传输
			 resp.getWriter().write(Json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
