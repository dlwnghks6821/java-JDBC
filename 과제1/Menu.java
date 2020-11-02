import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu  {
	public ArrayList<String> alName;
	public ArrayList<Integer> alPrice;
	String sql;
	Scanner sName = new Scanner(System.in);
    Scanner sPrice = new Scanner(System.in);//Scanner�� String�� int �� �� ���� new Scanner ���� ���� 
	
	Menu(){
		alName = new ArrayList<String>();
		alPrice = new ArrayList<Integer>();
		
	}
	public ArrayList<String> getMenu() {
		return this.alName;
	}
	public ArrayList<Integer> getPrice() {
		return this.alPrice;
	}
	
	void buildMenu(Connection conn) throws ClassNotFoundException, SQLException{
		
		DB.dbConn();
        System.out.println("----------------");
        System.out.println("<1.�޴��߰�>");
   
        
        //�޴��߰� 1, ���� 2, ���� 3, ��ȸ 4, ���� 0 
       Menu menu = new Menu();
       Order order = new Order();
       
       this.sql = "insert into menu values(?,?)";
       PreparedStatement ps=conn.prepareStatement(sql); //�� Prepare'd' �� prepare ���� 
       
       System.out.println("�����Է�");
       String name = sName.nextLine();
       alName.add(name);
       
      while(!name.equals("")) {
              System.out.println("�����Է�");
              int price = sPrice.nextInt();
              this.alPrice.add(price);
              ps.setString(1,name);
              ps.setInt(2,price);
              ps.executeUpdate();
              System.out.println("�����Է�");
              name = sName.nextLine();
              alName.add(name);
           }
      System.out.println("----------------------");
      System.out.println("�Է¿Ϸ�");
      ps.close();

	}
	
	void menuRemove(Connection conn) throws ClassNotFoundException, SQLException {
		DB.dbConn();
        sql = "delete from menu where name=?";
        PreparedStatement ps1=conn.prepareStatement(sql);
        
        System.out.println("���� �޴� �̸�");

       String name1 = sName.nextLine();
      while(!name1.equals("")) {
         
              ps1.setString(1,name1);
              ps1.executeUpdate();
              System.out.println("���� �޴� �̸�");
              name1 = sName.nextLine();
              
      }
      System.out.println("�Է¿Ϸ�");
      ps1.close();
	}
	
	void menuUpdate(Connection conn) throws ClassNotFoundException, SQLException {
		sql = "update menu set name=?,price=? where name=?";
        PreparedStatement ps2=conn.prepareStatement(sql);
        
       System.out.println("������ �޴� �̸�");
       String name2 = sName.nextLine();
      while(!name2.equals("")) {
         System.out.println("�� �޴� �̸�");
         String Nname = sName.nextLine();
         System.out.println("�� ����");
          int Nprice = sPrice.nextInt();
          ps2.setString(1,Nname);
          ps2.setInt(2,Nprice);
          ps2.setString(3,name2);
          ps2.executeUpdate();
          System.out.println("������ �޴� �̸�");
           name2 = sName.nextLine();
         
      }
      System.out.println("�Է¿Ϸ�");
      ps2.close();
	}
	
	void menuList(Connection conn) throws ClassNotFoundException, SQLException {
//		DB.dbConn();
		sql = "select name,price "+"from menu";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
      while(rs.next()) {
           String m_name = rs.getString("name");
           int m_price = rs.getInt("price");
           System.out.println(m_name+","+m_price);
         
      }
      rs.close();
      stmt.close();
	}
	
	void price(Connection conn) throws ClassNotFoundException, SQLException {
//		DB.dbConn();
		sql = "select name,price "+"from menu";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
      while(rs.next()) {
           String m_name = rs.getString("name");
           int m_price = rs.getInt("price");
           System.out.println(m_price);
         
      }
      rs.close();
      stmt.close();
	}
	
	
	
	void subMenu() {
		System.out.println("--------------------");
		System.out.println("<������"
				+ " �޴�>");
		for(int i=0; i<this.alName.size();i++) {
			System.out.print((i+1)+"."+this.alName.get(i));
			System.out.print("\t"+this.alPrice.get(i)+"��\n");
		}
	}
}