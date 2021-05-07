package io.walkers.planes.pandora.mybatis.typehandler;

import com.alibaba.fastjson.JSON;
import io.walkers.planes.pandora.mybatis.common.Region;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 地区类型类型处理器
 * Demo for {@link TypeHandler}
 *
 * @author planeswalker23
 */
public class RegionTypeHandler implements TypeHandler<Region> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Region region, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSON.toJSONString(region));
    }

    @Override
    public Region getResult(ResultSet resultSet, String s) throws SQLException {
        return JSON.parseObject(resultSet.getString(s), Region.class);
    }

    @Override
    public Region getResult(ResultSet resultSet, int i) throws SQLException {
        return JSON.parseObject(resultSet.getString(i), Region.class);
    }

    @Override
    public Region getResult(CallableStatement callableStatement, int i) throws SQLException {
        return JSON.parseObject(callableStatement.getString(i), Region.class);
    }
}
