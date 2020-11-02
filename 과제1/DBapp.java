import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DBapp {
	
   public static void main(String[] args) {
      try {
    	  Connection conn=DB.dbConn();
    	  Menu menu = new Menu();
    	  Order order = new Order();
		
		
         System.out.println("�۾��� �����ϼ���");
         System.out.println("1.�޴��߰�, 2.����, 3.����, 4.��ȸ, 5.�ֹ�, 6.������ȸ, 0.���� ");
         Scanner s = new Scanner(System.in);
         int i = s.nextInt();
         while(i!=0) {
            switch(i) {
            case 1:
            	
            	menu.buildMenu(conn);
            	System.out.println("----------------------");
            	System.out.println(menu.getPrice());
            	break;
               
            case 2:
            	
            	menu.menuRemove(conn);
            	System.out.println("----------------------");
            	break;
               
            case 3:
            	
            	menu.menuUpdate(conn);
            	System.out.println("----------------------");
            	break;
             
            case 4:
            	
            	menu.menuList(conn);
            	System.out.println("----------------------");
            	break;
            	
            case 5:
            	menu.menuList(conn);
            	System.out.println("----------------------");
            	order.addOrder(conn);
            	break;
            	
            case 6:
            	order.total(conn);
            }
            System.out.println("1.�޴��߰�, 2.����, 3.����, 4.��ȸ, 5.�ֹ�, 6.������ȸ, 0.����");
               i = s.nextInt();
         }System.out.println("End");
         
         
         
         
         

         
      }catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver loading has failed");
         } catch(SQLException e) {
            System.out.println("Oracle connection has failed");
         }
      
      
      }
   }