package io.walkers.planes.pandora.mybatis.common;

import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into user(id, name, region) values (#{id}, #{name}, #{region, typeHandler=io.walkers.planes.pandora.mybatis.typehandler.RegionTypeHandler})")
    int insert(User user);
}
