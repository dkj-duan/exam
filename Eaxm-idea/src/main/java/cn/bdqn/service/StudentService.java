package cn.bdqn.service;

import cn.bdqn.domain.Exam;
import cn.bdqn.domain.Stuanswer;
import cn.bdqn.domain.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentService {

    //查询学生信息
    public Student queryByStuNameAndStuPwd(String stuName ,String stuPwd);

    //添加学生信息
    public  void insertIntoStudent(Student student);

    //根据用户名查询信息
    public  Student selectName(String name);

    //更新密码
    public void updatePwd(Student student);
}
