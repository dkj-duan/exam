package cn.bdqn.service.Impl;

import cn.bdqn.domain.Exam;
import cn.bdqn.mapper.ExamMapper;
import cn.bdqn.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("examService")
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<Exam> selectExam() {
        return examMapper.selectExam();
    }
}
