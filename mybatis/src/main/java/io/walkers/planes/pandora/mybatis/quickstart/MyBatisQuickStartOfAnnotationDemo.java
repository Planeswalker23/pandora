package io.walkers.planes.pandora.mybatis.quickstart;

import io.walkers.planes.pandora.mybatis.common.User;
import io.walkers.planes.pandora.mybatis.common.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis demo of Annotation
 *
 * @author planeswalker23
 */
public class MyBatisQuickStartOfAnnotationDemo {

    public static void main(String[] args) throws IOException {
        // 加载配置文件
        String resource = "quickstart/quickstart-mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 基于构建者模式构建 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 基于工厂模式构建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // way1: 调用 sqlSession.selectOne 传入 statementId(mapper全路径+.方法名) + 参数查询数据库
        User user = sqlSession.selectOne("io.walkers.planes.pandora.mybatis.common.UserMapper.selectUserByName", "root");
        System.out.println("MyBatisQuickStartOfAnnotationDemo result of way1: " + user);

        // way2: getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("MyBatisQuickStartOfAnnotationDemo result of way2: " + mapper.selectUserByName("root"));
    }
}
