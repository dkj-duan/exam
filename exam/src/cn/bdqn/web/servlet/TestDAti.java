package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.Answer;
import cn.bdqn.entity.Exam;
import cn.bdqn.entity.Grade;
import cn.bdqn.entity.StuAnswer;
import cn.bdqn.entity.Student;
import cn.bdqn.sevice.AnswerSevice;
import cn.bdqn.sevice.ExamSevice;
import cn.bdqn.sevice.GradeService;
import cn.bdqn.sevice.impl.AnswerSeviceImpl;
import cn.bdqn.sevice.impl.ExamSeviceImpl;
import cn.bdqn.sevice.impl.GradeServiceImpl;
import cn.bdqn.utils.ArrayUtils;

@WebServlet("/dati")
public class TestDAti extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3083782098524955439L;

	private AnswerSevice as = new AnswerSeviceImpl();
	private ExamSevice examSevice = new ExamSeviceImpl();
	private GradeService gradeService = new GradeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ���
		req.setCharacterEncoding("UTF-8");
		//ѧ���𰸼���
		List<StuAnswer> stuAnswers = new ArrayList<StuAnswer>();
		//��׼�𰸼���
		List<Answer> answers = new ArrayList<Answer>();
		int score = 0;//���Է���
		//�����ż���
		int [] textId = new int[20];
		Student stu = new Student();
		HttpSession se = req.getSession();
		try {
			//ѭ��ѧ�����մ�
			for (int i = 0; i <=19; i++) {
				//����ѧ������
				StuAnswer stuAnswer = new StuAnswer();
				//�������id
				String id = req.getParameter("issueId"+i);
				//��ô�
				String [] reply = req.getParameterValues("xuanZe"+i);
				//���ѧ����
				String StuReply = ArrayUtils.array2string(reply);
				//����Ծ�id
				stuAnswer.setIssueId(Integer.parseInt(id));
				 stu = (Student)se.getAttribute("stu");
				 //���ѧ��id
				 stuAnswer.setStuId(stu.getStuId());
				//���������
				textId[i] = Integer.parseInt(id);
				stuAnswer.setStuAnswer(StuReply);
				//��ӵ�ѧ���𰸼��Ϻ�
				stuAnswers.add(stuAnswer);
			}
			
			for (int i = 0; i < textId.length; i++) {
				//���ش���ı�׼�𰸼���
				Integer id  = textId[i];
				answers.add(as.queryIssueIdAnswer(id));
			}
			//ѭ���Աȴ�ʮ����ȷ
			int count = 0;
			//�������⼯��
			List<Exam> integers = new ArrayList<Exam>();
			List<String>  strings = new ArrayList<String>();
			List<Answer> answerlist = new ArrayList<Answer>();
			for (int i = 0; i < answers.size(); i++) {
				Integer stuId = stuAnswers.get(i).getIssueId();
				Integer id = answers.get(i).getIssueId();
				if (stuId.equals(id)) {
					if (answers.get(i).getAnswer().equals(stuAnswers.get(i).getStuAnswer())) {
						score+=5;
						count++;
					}else{
						answerlist.add(as.queryIssueIdAnswer(id));
						integers.add(examSevice.selectSingleExam(id));
						strings.add(stuAnswers.get(i).getStuAnswer());
					}
				}
			}
			//�����ɼ���
			Grade grade = new Grade();
			grade.setStuId(stu.getStuId());
			grade.setStuGrade(score);
			double accuracy = ((double)count/20)*100;//������ȷ��
			grade.setAccuracy(accuracy);
			grade.setExamTime(new Date());
			gradeService.addGrade(grade);
			//����������
			req.setAttribute("score", score);
			se.setAttribute("cuoTi", integers);
			se.setAttribute("stuCuoTi",strings);
			se.setAttribute("daAn", answerlist);
			req.getRequestDispatcher("score.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("score", "�ύ�쳣,�����Ŀ��������,����ϵ��ʦ");
			se.setAttribute("cuoTi", " ��");
			se.setAttribute("stuCuoTi"," �� ");
			se.setAttribute("daAn", " �� ");
			req.getRequestDispatcher("score.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		doPost(req, resp);
	}
	
}
