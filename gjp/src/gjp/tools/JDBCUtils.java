package gjp.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 实现一个连接池的工具类
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
			pro.load(in);//我的天这一步我都能忘记，还到处找bug我天 我真是%……*&@&*！……

			driverClass = pro.getProperty("driverClass");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new RuntimeException("加载配置文件失败！");
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