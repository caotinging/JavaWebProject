package gjp.dao;

import java.sql.SQLException;
import java.util.List;

import gip.domain.ZhangWu;
import gjp.tools.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/*
 * ZhangWuDao�����һ����Ա����QueryRunner����
 * ��Ϊ����ʹ��dbutils���������ݿ�
 */

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	public List<ZhangWu> selectAll() {
		//�����ݿ���в�ѯ�������ݲ���
		try{
			String sql = "select * from gjp_zhangwu;";
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
			return list;
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("��ѯ����ʧ�ܣ�");
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
			throw new RuntimeException("��ѯʧ�ܣ�");
		}
	}

	public void addZhangWu(ZhangWu zw) {
		try {
			String sql = "insert into gjp_zhangwu (flname, money, zhangHu, createtime, description) values (?,?,?,?,?);";
			Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(), zw.getDescription()};
			qr.update(sql, params);
			
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("���ʧ�ܣ�");
		}
	}

	public void editZhangWu(ZhangWu zw) {
		try{
			String sql = "update gjp_zhangwu set flname=?,money=?,zhangHu=?,createtime=?,description=? where zwid=?;";
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			qr.update(sql, params);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("�޸�����ʧ�ܣ�");
		}
	}

	public void deleteZhangWu(int zwid) {
		try{
			String sql = "delete from gjp_zhangwu where zwid=?;";
			qr.update(sql, zwid);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("ɾ������ʧ��!");
		}
	}
}
