import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbapp {

	public static void main(String[] args) {
		//����������//
		String driver = "oracle.jdbc.driver.OracleDriver";
		//localhost ���� ������ �ƴ� ��Ʈ��ȣ , �ּҰ� �ʿ�//
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//user id //
		String user = "system";
		//password//
		String password = "human123";
		try {
			
			Class.forName(driver);
			//Connection conn ���� java.sql.Connection �� import//
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("����Ŭ ���� ����");
			System.out.println("jdbc driver �ε� ����");
			//sql ��//
			String sql = "select channel_id,channel_desc "+" from channels";
		
			//java.sql.Statement import//
			Statement stmt = null;
			//executeQuery = �������� ����//
			//import Resultset ���ش�//
			//ResultSet�� ����� 2���� �迭ó�� ������� �����Եȴ� //
			stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {			
            	int e_id = rs.getInt("channel_id");
            	String e_name = rs.getString("channel_desc");
            	//int m_id = rs.getInt("manager_id");//
            	System.out.println(e_id+","+e_name+",");
            }
            //�� ������ �������� �ݴ´�//
            conn.close();
            stmt.close();
            rs.close();
			
					
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver �ε� ����");
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����");
		}

	}

}