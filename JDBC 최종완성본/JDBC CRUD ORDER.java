import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

	public class Order   {
		static int order_number;
		static int order_cnt ;
		static int price ;
		static String mobile ;
		static int order_date;
		static int sum ;
	 Scanner sc1 = new Scanner(System.in);
	 Scanner sc2 = new Scanner(System.in);
	 Scanner sc3 = new Scanner(System.in);
	 Scanner sc4 = new Scanner(System.in);
    int howManyCount ;
    String mobileNumber;
    int getPrice ;
    int wantMenu;
    int price2 ; 
 
	
	Order(){
		sum = 0; 
		
	}
	
	    void addOrder() throws SQLException, ClassNotFoundException {
	    	//ó���� DB�� ������//
	    	Connection conn=DB.dbConn();
	    	System.out.println("���Ͻô� ��ǰ�� �Է����ּ���.��Ҵ� ����");
	        String menu2 = sc1.nextLine();
	    
	      
	        while(!menu2.equals("")) {
	        	System.out.println("������ �Է����ּ���.");
	        	int count2 = sc2.nextInt();
	        	
	        	
	        	System.out.println("");
	        	System.out.println("����Ϲ�ȣ�� �Է����ּ���.");
	            String mobile = sc3.nextLine();
	          
	    		String sql = "select price from menu where name ='"+menu2+"'";
	            Statement stmt=conn.createStatement();
	            ResultSet rs=stmt.executeQuery(sql);
	            rs.next();
	             price2 = rs.getInt("price");
	            rs.close();
	            stmt.close();
	               

//	            
	            String sql1="insert into custom values(?,?,?,?,to_char(sysdate,'yyyymmdd'))";
	   		 	PreparedStatement ps1 = conn.prepareStatement(sql1);
	            //��ǰDB//
				ps1.setString(1,menu2 );
	            //����DB//
	            ps1.setInt(2,count2);
	           
	            ps1.setInt(3, price2);
	            ps1.setString(4, mobile);
	            ps1.executeUpdate();
	            System.out.println("���Ͻô� ��ǰ�� �Է����ּ���.��Ҵ� ����");
	            menu2 = sc1.nextLine();
	           
	            
	        }
	        //����ϰ��� DB����//
	        conn.close();
	        
		}

	 
	    void total() throws SQLException, ClassNotFoundException{
	    	//DB������//
	    	Connection conn=DB.dbConn();
	    	String sql7 = "select order_number, order_cnt, price, mobile, order_date from custom";
	        Statement stmt7=conn.createStatement();
	        
	        ResultSet rs=stmt7.executeQuery(sql7);
	        int sum =0;
	        
	        while(rs.next()) {
	        	
	        	String order_number = rs.getString("order_number");
	        	int order_cnt = rs.getInt("order_cnt");
	        	int price = rs.getInt("price");
	        	String mobile = rs.getString("mobile");        	
	        	int order_date = rs.getInt("order_date");
	        	
	        	
	        		System.out.println(order_cnt*price+"��, ��ȣ: " + mobile+", �ֹ���¥:" + order_date);
	        		sum += order_cnt*price;
	        		System.out.println(sum);
	        	
	      
	        }
	        
	        rs.close();
	        stmt7.close();
	        //DB�ݾ���//
	    	conn.close();
	    	
	    	
	    }
    }
		
		
    
