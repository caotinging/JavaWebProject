package gip.test;

import java.sql.SQLException;

import gjp.tools.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.Test;

public class GjpTest {
	
	@Test
	public void test1() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] obj = qr.query("select * from gjp_zhangwu where Zwid = 1;", new ArrayHandler());
		System.out.println(obj);
	}
}
