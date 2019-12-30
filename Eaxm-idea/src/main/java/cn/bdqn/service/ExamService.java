package cn.bdqn.service;

import cn.bdqn.domain.Exam;

import java.util.List;

public interface ExamService {

    /**
     * 查询全部试题
     * @return
     */
    public List<Exam> selectExam();
}
