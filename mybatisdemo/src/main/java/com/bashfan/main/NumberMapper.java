package com.bashfan.main;

import com.bashfan.domain.Number;
import org.apache.ibatis.annotations.Select;

public interface NumberMapper {

    @Select("select * from test.numbers where id = #{id}")
    Number selectNumber(int id);
}
