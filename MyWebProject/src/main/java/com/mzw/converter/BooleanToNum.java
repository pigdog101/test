package com.mzw.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class BooleanToNum extends BaseTypeHandler<Boolean>{
    //java to db
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		if(parameter==true) {
			ps.setInt(i, 1);
		}else {
			ps.setInt(i, 0);
		}
		
	}
    // db to java
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int index = rs.getInt(columnName);
		if(index==1) {
			return true;
		}else {
			return false;
			
		}
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}
    //java to DB


}
