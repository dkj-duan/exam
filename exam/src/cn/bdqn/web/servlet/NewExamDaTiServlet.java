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

import cn.bdqn.entity.Grade;
import cn.bdqn.entity.NewExam;
import cn.bdqn.entity.Paper;
import cn.bdqn.entity.StuAnswer;
import cn.bdqn.entity.Student;
import cn.bdqn.sevice.GradeService;
import cn.bdqn.sevice.NewExamService;
import cn.bdqn.sevice.impl.GradeServiceImpl;
import cn.bdqn.sevice.impl.NewExamServiceImpl;
import cn.bdqn.utils.ArrayUtils;

@WebServlet("/newExamDaTi")
public class NewExamDaTiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3412714284161252704L;
	private NewExamService newExamService = new NewExamServiceImpl(); 
	private GradeService gradeService = new GradeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//学生答案集合
		List<StuAnswer> stuAnswers = new ArrayList<StuAnswer>();
		//标准答案集合
		List<NewExam> newExams = new ArrayList<NewExam>();
		int score = 0;//考试分数
		//试题编号集合
		int [] textId = new int[20];
		//创建学生对象
		Student stu = new Student();
		HttpSession se = req.getSession();
		try {
			//循环学生接收答案
			for (int i = 0; i <=19; i++) {
				//创建学生答案类
				StuAnswer stuAnswer = new StuAnswer();
				//获得试题id
				String id = req.getParameter("issueId"+i);
				//获得答案
				String [] reply = req.getParameterValues("xuanZe"+i);
				//添加学生答案
				String StuReply = ArrayUtils.array2string(reply);
				//添加试卷id
				stuAnswer.setIssueId(Integer.parseInt(id));
				 stu = (Student)se.getAttribute("stu");
				 //添加学生id
				 stuAnswer.setStuId(stu.getStuId());
				//添加试题编号
				textId[i] = Integer.parseInt(id);
				stuAnswer.setStuAnswer(StuReply);
				//添加到学生答案集合红
				stuAnswers.add(stuAnswer);
			}
			for (int i = 0; i < textId.length; i++) {
				//返回答题的标准答案集合
				Integer id  = textId[i];
				newExams.add(newExamService.querySingleExam(id));
			}
			//循环对比答案十分正确
			int count = 0;
			//错误试题集合
			List<NewExam> integers = new ArrayList<NewExam>();
			List<String>  strings = new ArrayList<String>();
			for (int i = 0; i < newExams.size(); i++) {
				Integer stuId = stuAnswers.get(i).getIssueId();
				Integer id = newExams.get(i).getIssueId();
				if (stuId.equals(id)) {
					if (newExams.get(i).getAnswer().equals(stuAnswers.get(i).getStuAnswer())) {
						score+=5;
						count++;
					}else{
						integers.add(newExamService.querySingleExam(id));
						strings.add(stuAnswers.get(i).getStuAnswer());
					}
				}
			}
			Paper pa = (Paper)se.getAttribute("paper");
			//创建成绩表
			Grade grade = new Grade();
			grade.setStuId(stu.getStuId());
			grade.setStuGrade(score);
			grade.setPaperName(pa.getPaperName());		
			double accuracy = ((double)count/20)*100;//计算正确率
			grade.setAccuracy(accuracy);
			grade.setExamTime(new Date());
			gradeService.insterGrade(grade);
			//设置作用域
			req.setAttribute("score", score);
			se.setAttribute("cuoTi", integers);
			se.setAttribute("stuCuoTi",strings);
			req.getRequestDispatcher("newScore.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("score", "提交异常,题库题目数量不足,请联系老师");
			se.setAttribute("cuoTi", " 无");
			se.setAttribute("stuCuoTi"," 无 ");
			req.getRequestDispatcher("newScore.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
