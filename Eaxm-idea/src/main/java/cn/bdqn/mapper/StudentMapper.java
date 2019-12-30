package cn.bdqn.mapper;

import cn.bdqn.domain.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    int deleteByPrimaryKey(Integer stuid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    //查询学生是否存在
    Student selectByNameAndPwd(@Param("stuName")String stuName ,@Param("stuPwd")String stuPwd);

    //添加学生
    void insertIntoStudent(Student student);

    //根据用户名查询
    Student selectName(String name);

    //更新密码
    void updatePwd(Student student);
}