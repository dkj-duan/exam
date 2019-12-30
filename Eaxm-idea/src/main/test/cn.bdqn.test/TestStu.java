package cn.bdqn.test;

import cn.bdqn.domain.Exam;
import cn.bdqn.domain.Stuanswer;
import cn.bdqn.domain.Student;
import cn.bdqn.mapper.ExamMapper;
import cn.bdqn.mapper.StuanswerMapper;
import cn.bdqn.mapper.StudentMapper;
import cn.bdqn.service.StuanswerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestStu {


    @Test
    public void testLogin()throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        StudentMapper studentMapper = ac.getBean("studentMapper", StudentMapper.class);

        Student student = studentMapper.selectByNameAndPwd("段康家","123456");

        System.out.printf(student.toString());
    }

    @Test
    public void testInsertIntoStudent() throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        StudentMapper studentMapper = ac.getBean("studentMapper", StudentMapper.class);

        Student stu = new Student();
        stu.setStuname("hahah");
        stu.setStupwd("12345");
        stu.setStuemail("11222@qq.com");
        stu.setStucardid("14234231232312322");
        stu.setStuphone("1243254774");
        studentMapper.insertIntoStudent(stu);

        System.out.println(toString());
    }

    @Test
    public void testSelectName()throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        StudentMapper studentMapper = ac.getBean("studentMapper", StudentMapper.class);

        Student stu = studentMapper.selectName("段康家");

        System.out.println(stu.toString());
    }


    @Test
    public void testUpdatePwd()throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        StudentMapper studentMapper = ac.getBean("studentMapper", StudentMapper.class);

        Student stu = new Student();
        stu.setStuid(20);
        stu.setStuname("hahah");
        stu.setStupwd("1234567");
        stu.setStuemail("11222@qq.com");
        stu.setStucardid("14234231232312322");
        stu.setStuphone("1243254774");
        studentMapper.updatePwd(stu);

        System.out.println(stu.toString());
    }



    @Test
    public void testSelectExam()throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        ExamMapper examMapper = ac.getBean("examMapper",ExamMapper.class);

        List<Exam> exam = examMapper.selectExam();

        System.out.printf(exam.toString());
    }


    @Test
    public void testInsert()throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        StuanswerService stuanswer = ac.getBean("stuanswerService", StuanswerService.class);

        Stuanswer stuan = new Stuanswer();
        stuan.setStuid(1);
        stuan.setIssueid(1);
        stuan.setPaperid(1);
        stuan.setStuanswer("A");
        stuanswer.insert(stuan);

        System.out.println(stuan.toString());
    }
}
