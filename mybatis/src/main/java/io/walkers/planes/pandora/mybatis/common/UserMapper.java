package io.walkers.planes.pandora.mybatis.common;

import org.apache.ibatis.annotations.Select;

/**
 * User 映射器类
 *
 * @author planeswalker23
 */
public interface UserMapper {

    User selectUserById(Integer id);

    User selectUserByTypeHandlerAndId(Integer id);

    @Select("select * from user where name=#{name}")
    User selectUserByName(String name);
}
