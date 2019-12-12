package cn.bdqn.mapper;

import cn.bdqn.domain.Grade;

public interface GradeMapper {
    int insert(Grade record);

    int insertSelective(Grade record);
}