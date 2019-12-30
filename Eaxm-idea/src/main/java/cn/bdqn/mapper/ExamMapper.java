package cn.bdqn.mapper;

import cn.bdqn.domain.Exam;

import java.util.List;

public interface ExamMapper {
    int deleteByPrimaryKey(Integer issueid);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer issueid);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);

    /**
     * 查询全部试题
     * @return
     */
    List<Exam> selectExam();
}