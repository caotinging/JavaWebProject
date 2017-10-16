package gjp.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * ʵ��һ�����ӳصĹ�����
 */

public class JDBCUtils {
	private static BasicDataSource dataSource;
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		getConfig();
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		dataSource.setMaxActive(10);
		dataSource.setMaxIdle(5);
		dataSource.setMinIdle(1);
		dataSource.setInitialSize(10);
	}
	
	private static void getConfig() {
		InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);//�ҵ�����һ���Ҷ������ǣ���������bug���� ������%����*&@&*������

			driverClass = pro.getProperty("driverClass");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new RuntimeException("���������ļ�ʧ�ܣ�");
		}
		
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("in.close() error!");
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}