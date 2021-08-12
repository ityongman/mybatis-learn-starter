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
@MappedJdbcTypes(JdbcType.INTEGER)
public class MyIntegerTypeHandler extends BaseTypeHandler<Long> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType)
            throws SQLException {
        System.out.println(String.format("MyIntegerTypeHandler ps=%s, i=%d, parameter=%s, jdbcType=%s", ps, i, parameter, jdbcType));
        ps.setLong(i, parameter);
    }

    @Override
    public Long getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        System.out.println(String.format("MyIntegerTypeHandler ResultSet=%s, columnName=%s", rs, columnName));
        long result = rs.getLong(columnName);
        return result == 0 && rs.wasNull() ? null : result;
    }

    @Override
    public Long getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        System.out.println(String.format("MyIntegerTypeHandler ResultSet=%s, columnIndex=%s", rs, columnIndex));
        long result = rs.getLong(columnIndex);
        return result == 0 && rs.wasNull() ? null : result;
    }

    @Override
    public Long getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        System.out.println(String.format("MyIntegerTypeHandler CallableStatement=%s, columnIndex=%s", cs, columnIndex));
        long result = cs.getLong(columnIndex);
        return result == 0 && cs.wasNull() ? null : result;
    }
}
