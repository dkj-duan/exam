package cn.bdqn.mapper;

import cn.bdqn.domain.Exam;
import cn.bdqn.domain.Stuanswer;

public interface StuanswerMapper {

    /**
     * 添加答案
     * @param record
     * @return
     */
    int insert(Stuanswer record);

    /**
     * 根据条件添加答案
     * @param record
     * @return
     */
    int insertSelective(Stuanswer record);

    /**
     * 添加试卷
     * @param stuanswer
     */
    void  insertStuanswer(Stuanswer stuanswer);


}