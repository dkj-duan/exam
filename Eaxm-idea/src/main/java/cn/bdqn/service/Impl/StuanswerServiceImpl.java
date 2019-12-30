package cn.bdqn.service.Impl;

import cn.bdqn.domain.Exam;
import cn.bdqn.domain.Stuanswer;
import cn.bdqn.mapper.StuanswerMapper;
import cn.bdqn.service.StuanswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stuanswerService")
public class StuanswerServiceImpl implements StuanswerService {

    @Autowired
    private StuanswerMapper stuanswerMapper;

    @Override
    public Stuanswer queryIdStuanswer(Integer id) {
        return null;
    }

    @Override
    public void insertStuanswer(Stuanswer stuanswer) {
        stuanswerMapper.insertStuanswer(stuanswer);
    }

    @Override
    public int insert(Stuanswer record) {
        return stuanswerMapper.insert(record);
    }


}
