package cn.bdqn.service;

import cn.bdqn.domain.Exam;
import cn.bdqn.domain.Stuanswer;
import org.springframework.stereotype.Service;

public interface StuanswerService {


    public Stuanswer queryIdStuanswer(Integer id);

    public  void insertStuanswer(Stuanswer stuanswer);

    //添加答案
    public  int insert(Stuanswer record);
}
