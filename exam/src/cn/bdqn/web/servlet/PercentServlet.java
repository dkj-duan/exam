package cn.bdqn.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Student;
import cn.bdqn.sevice.GradeService;
import cn.bdqn.sevice.StudentSevice;
import cn.bdqn.sevice.impl.GradeServiceImpl;
import cn.bdqn.sevice.impl.StudentSeviceImpl;

@WebServlet("/percent")
public class PercentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1534021072689774708L;
	private GradeService gradeService = new GradeServiceImpl();
	private StudentSevice studentSevice = new StudentSeviceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getParameter("UTF-8");
		try {
			String stuName = req.getParameter("stuName");
			String paperName = req.getParameter("paperName");
			Student stu = studentSevice.queryName(stuName);
			if (stu!=null) {
				int pass = gradeService.select(stu.getStuId(), paperName);
				int count = gradeService.selectcount(stu.getStuId(), paperName);
				if (count!=0) {
					if (pass!=0) {
						String passLv = (double)pass/count*100+"%";
						resp.getWriter().write(passLv);
					}else{
						resp.getWriter().write("0%");
					}
				}else{
					resp.getWriter().write("本试卷无做题记录");
				}
			}else{
				resp.getWriter().write("学生不存在");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
