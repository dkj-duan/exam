package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.NewExam;
import cn.bdqn.sevice.NewExamService;
import cn.bdqn.sevice.impl.NewExamServiceImpl;

@WebServlet("/careful")
public class CarefulServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7325034250893662682L;

	private NewExamService newExamService = new NewExamServiceImpl();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		try {
			//获得书卷id
			String paperId = req.getParameter("paperID");
			String paperName = req.getParameter("paperName");
			paperName = new String(paperName.getBytes("ISO-8859-1"),"UTF-8");
			List<NewExam> newExams = newExamService.selectPaperId(Integer.parseInt(paperId));
			//设置作用域
			HttpSession se = req.getSession();
			se.setAttribute("newExamlist", newExams);
			se.setAttribute("count", newExams.size());
			se.setAttribute("paperName", paperName);
			se.setAttribute("paperId", Integer.parseInt(paperId));
			resp.sendRedirect("careful.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("mass.jsp");
		}
	}
	
}
