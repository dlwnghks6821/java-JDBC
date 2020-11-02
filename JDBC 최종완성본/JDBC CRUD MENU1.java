import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;
public class Menu1 {
	//���ڿ��� �޴�//
	static Scanner string1 = new Scanner(System.in);
	static Scanner integer1 = new Scanner(System.in);
      Menu1(){
    	  
      }
      
      static void buildMenu() throws SQLException, ClassNotFoundException{
    	  //DB������//
    	  Connection conn=DB.dbConn();
    	  String sql1 = "insert into menu values (?, ?)";
    	  PreparedStatement ps1 = conn.prepareStatement(sql1);
    	  System.out.println("�޴��� �Է����ּ���.");
    	  String menuName = string1.nextLine();
    	  while(!menuName.equals("")) {
    		  System.out.println("������ �Է����ּ���.");
    		  int price = integer1.nextInt();
    		  ps1.setString(1, menuName);
    		  ps1.setInt(2, price);
    		  ps1.executeUpdate();
    		  System.out.println("�޴��� �Է����ּ���.");
        	  menuName = string1.nextLine();
        	  ps1.setString(1, menuName);
    		  
    		  
    	  }
    	  ps1.close();
    	  //DB�ݾ���//
    	  conn.close();
      }
      static void deleteMenu() throws SQLException, ClassNotFoundException {
    	  //DB������//
    	  Connection conn=DB.dbConn();
    	String sql2 = "delete from menu where name=?";
    	PreparedStatement ps2 = conn.prepareStatement(sql2);
    	System.out.println("������ �޴��� �̸��� �Է����ּ���.");
    	String deleteMenu = string1.nextLine();
    	while(!deleteMenu.equals("")) {
    		ps2.setString(1,deleteMenu);
    		ps2.executeUpdate();   		
    		System.out.println("������ �޴��� �̸��� �Է����ּ���.");
        	deleteMenu = string1.nextLine();
        	
    		
    	}
    	ps2.close();
    	//DB�ݾ���//
    	conn.close();
      }

  
	static void updateMenu() throws SQLException, ClassNotFoundException {
		//DB������//
		Connection conn=DB.dbConn();
		 String sql3 = "update menu set name=?,price=? where name=?";
         PreparedStatement ps3=conn.prepareStatement(sql3);
         
        System.out.println("������ �޴� �̸����Է����ּ���");
        String oldName = string1.nextLine();
       while(!oldName.equals("")) {
          System.out.println("�� �޴� �̸��� �Է����ּ���");
          String newMenuName =  string1.nextLine();
          System.out.println("�� ������ �Է����ּ���.");
           int newPrice = integer1.nextInt();
           ps3.setString(1,newMenuName);
           ps3.setInt(2,newPrice);
           ps3.setString(3,oldName);
           ps3.executeUpdate();
           System.out.println("������ �޴� �̸�");
           oldName = string1.nextLine();
          
       }
       System.out.println("�Է¿Ϸ�");
       ps3.close();
       //DB�ݾ���//
       conn.close();
	  
}
	static void selectMenu() throws SQLException, ClassNotFoundException {
		//DB������//
		Connection conn=DB.dbConn();
		String sql4 = "select name,price "+"from menu";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql4);
      while(rs.next()) {
           String m_name = rs.getString("name");
           int m_price = rs.getInt("price");
           System.out.println(m_name+","+m_price);
      }
      rs.close();
      stmt.close();
	System.out.println("End");
	//DB�ݾ���//
	conn.close();
   }


	  
}
	

