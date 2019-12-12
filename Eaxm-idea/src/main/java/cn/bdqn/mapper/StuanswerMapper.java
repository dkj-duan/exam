package cn.bdqn.mapper;

import cn.bdqn.domain.Stuanswer;

public interface StuanswerMapper {
    int insert(Stuanswer record);

    int insertSelective(Stuanswer record);
}