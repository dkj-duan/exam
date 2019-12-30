package cn.bdqn.service.Impl;

import cn.bdqn.domain.Exam;
import cn.bdqn.domain.Stuanswer;
import cn.bdqn.domain.Student;
import cn.bdqn.mapper.StudentMapper;
import cn.bdqn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //查询学生信息
    @Override
    public Student queryByStuNameAndStuPwd(String stuName, String stuPwd) {
        return studentMapper.selectByNameAndPwd(stuName,stuPwd);
    }

    //添加学生信息
    @Override
    public void insertIntoStudent(Student student) {
        studentMapper.insertIntoStudent(student);
    }

    //根据用户名查询信息
    @Override
    public Student selectName(String name) {
       return studentMapper.selectName(name);
    }

    //更新密码
    @Override
    public void updatePwd(Student student) {
        studentMapper.updatePwd(student);
    }


}
