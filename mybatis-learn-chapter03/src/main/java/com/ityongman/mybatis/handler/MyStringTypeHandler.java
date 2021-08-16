package com.ityongman.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author shedunze
 * @Date 2021/8/12 10:00 上午
 * @Description
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyStringTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        System.out.println(String.format("MyStringTypeHandler ps=%s, i=%d, parameter=%s, jdbcType=%s", ps, i, parameter, jdbcType));
        ps.setString(i, parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        System.out.println(String.format("MyStringTypeHandler ResultSet=%s, columnName=%s", rs, columnName));
        return rs.getString(columnName);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        System.out.println(String.format("MyStringTypeHandler ResultSet=%s, columnIndex=%s", rs, columnIndex));
        return rs.getString(columnIndex);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        System.out.println(String.format("MyStringTypeHandler CallableStatement=%s, columnIndex=%s", cs, columnIndex));
        return cs.getString(columnIndex);
    }
}
