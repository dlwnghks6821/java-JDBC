
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
           
    	  Menu1 menu = new Menu1();
    	  Order order = new Order();


         System.out.println("�۾��� �����ϼ���");
         System.out.println("1.�޴��߰�, 2.����, 3.����, 4.��ȸ, 5.�ֹ�, 6.������ȸ, 0.���� ");
         Scanner s = new Scanner(System.in);
         int i = s.nextInt();
         while(i!=0) {
            switch(i) {
            case 1:

            	menu.buildMenu();
            	System.out.println("----------------------");
            
            	break;

            case 2:

            	menu.deleteMenu();
            	System.out.println("----------------------");
            	break;

            case 3:

            	menu.updateMenu();
            	System.out.println("----------------------");
            	break;

            case 4:

            	menu.selectMenu();
            	System.out.println("----------------------");
            	break;

            case 5:
            	
            	
            	
            	order.addOrder();
            	break;

            case 6:
            	order. total();
            }
            System.out.println("1.�޴��߰�, 2.����, 3.����, 4.��ȸ, 5.�ֹ�, 6.������ȸ, 0.����");
               i = s.nextInt();
         }
         System.out.println("End");







      }catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver loading has failed");
         } catch(SQLException e) {
            System.out.println("Oracle connection has failed");
         }


      }
   } 