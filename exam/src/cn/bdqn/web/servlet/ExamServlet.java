package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.Answer;
import cn.bdqn.entity.Exam;
import cn.bdqn.sevice.ExamSevice;
import cn.bdqn.sevice.impl.ExamSeviceImpl;

public class ExamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2406340780605398414L;

	private ExamSevice es = new ExamSeviceImpl();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String qu = req.getParameter("exam");
		if ("add".equals(qu)) {
			String issueText = req.getParameter("issueText");
			String issueType = req.getParameter("issueType");
			String answerA = req.getParameter("answerA");
			String answerB = req.getParameter("answerB");
			String answerC = req.getParameter("answerC");
			String answerD = req.getParameter("answerD");
			String answer = req.getParameter("answer");
			try {
				//创建试题实体类
				Exam exam = new Exam();
				//封装数据
				exam.setAnswerA(answerA);
				exam.setAnswerB(answerB);
				exam.setAnswerC(answerC);
				exam.setAnswerD(answerD);
				exam.setIssueText(issueText);
				exam.setIssueType(Integer.parseInt(issueType));
				exam.setScore(5);
				//创建标准答案类
				Answer as = new Answer();
				as.setAnswer(answer);
				es.addExam(exam, as);
				req.setAttribute("mass", "添加成功~");
				req.getRequestDispatcher("addition.jsp").forward(req, resp);
			} catch (Exception e) {
				resp.sendRedirect("mass.jsp");
			}
		}else{
			try {
				List<Exam> examList = new ArrayList<Exam>();
				examList = es.allExam();
				HttpSession se = req.getSession();
				se.setAttribute("examList", examList);
				resp.sendRedirect("exam.jsp");
			} catch (Exception e) {
				resp.sendRedirect("list.jsp");
			}
		}
	}

}
