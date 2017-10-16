package gjp.dao;

import java.sql.SQLException;
import java.util.List;

import gip.domain.ZhangWu;
import gjp.tools.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/*
 * ZhangWuDao类添加一个成员变量QueryRunner对象，
 * 因为我们使用dbutils来操作数据库
 */

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	public List<ZhangWu> selectAll() {
		//对数据库进行查询所有数据操作
		try{
			String sql = "select * from gjp_zhangwu;";
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
			return list;
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("查询数据失败！");
		}
	}

	public List<ZhangWu> select(String start, String end) {
		try {
			String sql = "select * from gjp_zhangwu where createtime between ? and ?;";
			Object[] params = {start, end};
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class), params);
			return list;
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("查询失败！");
		}
	}

	public void addZhangWu(ZhangWu zw) {
		try {
			String sql = "insert into gjp_zhangwu (flname, money, zhangHu, createtime, description) values (?,?,?,?,?);";
			Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(), zw.getDescription()};
			qr.update(sql, params);
			
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("添加失败！");
		}
	}

	public void editZhangWu(ZhangWu zw) {
		try{
			String sql = "update gjp_zhangwu set flname=?,money=?,zhangHu=?,createtime=?,description=? where zwid=?;";
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			qr.update(sql, params);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("修改数据失败！");
		}
	}

	public void deleteZhangWu(int zwid) {
		try{
			String sql = "delete from gjp_zhangwu where zwid=?;";
			qr.update(sql, zwid);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("删除数据失败!");
		}
	}
}
