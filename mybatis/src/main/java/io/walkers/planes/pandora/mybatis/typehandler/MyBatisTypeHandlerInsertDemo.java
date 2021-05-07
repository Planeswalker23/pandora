package io.walkers.planes.pandora.mybatis.typehandler;

import io.walkers.planes.pandora.mybatis.common.Region;
import io.walkers.planes.pandora.mybatis.common.User;
import io.walkers.planes.pandora.mybatis.common.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis demo of TypeHandler insert
 *
 * @author planeswalker23
 */
public class MyBatisTypeHandlerInsertDemo {

    public static void main(String[] args) throws IOException {
        // 加载配置文件
        String resource = "quickstart/quickstart-mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 基于构建者模式构建 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 基于工厂模式构建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // way2: getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setName("test_name" + user.getId());
        Region region = new Region();
        region.setCountry("China");
        region.setArea("ZheJiang");
        user.setRegion(region);
        int result = mapper.insert(user);
        sqlSession.commit();
        System.out.println("MyBatisTypeHandlerInsertDemo result of way2: " + result);
    }
}
