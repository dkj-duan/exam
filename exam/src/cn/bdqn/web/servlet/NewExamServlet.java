package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.NewExam;
import cn.bdqn.entity.Paper;
import cn.bdqn.sevice.NewExamService;
import cn.bdqn.sevice.PaperService;
import cn.bdqn.sevice.impl.NewExamServiceImpl;
import cn.bdqn.sevice.impl.PaperServiceImpl;

@WebServlet("/newExam")
public class NewExamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9146047964289691639L;

	private NewExamService es = new NewExamServiceImpl();

	private PaperService paperService = new PaperServiceImpl();
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
			String paperId = req.getParameter("paperId");
			try {
				//��������ʵ����
				NewExam exam = new NewExam();
				//��װ����
				exam.setAnswerA(answerA);
				exam.setAnswerB(answerB);
				exam.setAnswerC(answerC);
				exam.setAnswerD(answerD);
				exam.setIssueText(issueText);
				exam.setIssueType(Integer.parseInt(issueType));
				exam.setScore(5);
				exam.setPaperId(Integer.parseInt(paperId));
				exam.setAnswer(answer);
				es.addNewExam(exam);
				
				HttpSession se  = req.getSession();
				req.setAttribute("mass", "��ӳɹ�~");
				req.getRequestDispatcher("newAddition.jsp").forward(req, resp);
			} catch (Exception e) {
				resp.sendRedirect("mass.jsp");
			}
		}else if("del".equals(qu)){
			String paperId = req.getParameter("paper");
			//����ɾ���ķ���
			es.delNewExam(Integer.parseInt(paperId));
			paperService.delPaper(Integer.parseInt(paperId));
			//�ض���
			resp.sendRedirect("adinmInformation.jsp");
		}else{
			String paperId  = req.getParameter("paper");
			try {
				Paper paper = new Paper();
				paper = paperService.queryPaperId(Integer.parseInt(paperId));
				List<NewExam> examList = new ArrayList<NewExam>();
				examList = es.allExam(Integer.parseInt(paperId));
				HttpSession se = req.getSession();
				se.setAttribute("newExamList", examList);
				se.setAttribute("paper", paper);
				resp.sendRedirect("newExam.jsp");
			} catch (Exception e) {
				resp.sendRedirect("list.jsp");
			}
		}
	}
}
