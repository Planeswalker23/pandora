package io.walkers.planes.pandora.mybatis.quickstart.common;

import org.apache.ibatis.annotations.Select;

/**
 * User 映射器类
 *
 * @author planeswalker23
 */
public interface UserMapper {

    User selectUserById(Integer id);

    @Select("select * from user where name=#{name}")
    User selectUserByName(String name);
}
