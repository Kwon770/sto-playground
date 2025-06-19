package com.koscom.sto_was.vo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@MappedTypes({FepStatCode.class})
public class CmnCodeEnumTypeHandler<E extends Enum<E> & CmnCodeEnum> extends BaseTypeHandler<E> {
    private final Class<E> type;

    public CmnCodeEnumTypeHandler(Class<E> type) {
        this.type = type;
    }

    // Enum 타입의 코드를 DB에 저장할 때 사용
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    // DB에서 Select 쿼리 결과를 읽어올 때 컬럼명을 지정해서 결과를 Enum 타입으로 변환
    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.wasNull() ? null :toEnum(rs.getString(columnName));
    }

    // 위와 동일한데 컬럼 인덱스로 값을 읽음
    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.wasNull() ? null : toEnum(rs.getString(columnIndex));
    }

    // DB 프로시저 호출 결과로 값을 반환받을 때 사용
    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.wasNull() ? null : toEnum(cs.getString(columnIndex));
    }

    private E toEnum(String code) {
        return Arrays.stream(type.getEnumConstants())
                .filter(constant -> constant.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant " + type.getName() + " with code " + code));
    }
}
