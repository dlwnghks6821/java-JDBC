import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Order extends Menu {
	//--->��ǰ�Է� scanner<---//
	Scanner sc1= new Scanner(System.in);
	//--->�����Է� scanner<---//
	Scanner sc2 = new Scanner(System.in);
	//--->����Ϲ�ȣ �Է� scanner<---//
	Scanner sc3 = new Scanner(System.in);
	//--->����Ϲ�ȣ ArrayList<---//
	Scanner sc4 = new Scanner(System.in);
	ArrayList<String> mobile1 = new ArrayList<String>();
	//--->�޴�ArrayList<---//
	ArrayList<String> menu1 = new ArrayList<String>();
	//--->����ArrayList<---//
	ArrayList<Integer> count1 = new ArrayList<Integer>();
	Order(){
		mobile1 = new ArrayList<String>();
		menu1 = new ArrayList<String>();
		count1= new ArrayList<Integer>();
	}
	//-->addOrder = ��ǰ,����,������ �Է¹޾ƾ���<--//
		void addOrder(Connection conn) throws SQLException, ClassNotFoundException {
		
		
		System.out.println("���Ͻô� ��ǰ�� �Է����ּ���.��Ҵ� ����");
        String menu2 = sc1.nextLine();
        //��ǰ ArrayList����//
        menu1.add(menu2);
        while(!menu2.equals("")) {
        	System.out.println("������ �Է����ּ���.");
        	int count2 = sc2.nextInt();
        	//���� ArrayList����//
        	count1.add(count2);
        	System.out.println("");
        	System.out.println("����Ϲ�ȣ�� �Է����ּ���.");
            String mobile = sc3.nextLine();
          //����Ϲ�ȣ ArrayList����//
            mobile1.add(mobile);
//            System.out.println("1");
//            String sql = "select price from menu";
//            System.out.println("2");
//            Statement stmt=conn.createStatement();
//            System.out.println("3");
//            ResultSet rs=stmt.executeQuery(sql);
//            System.out.println("4");
//            int price2 = rs.getInt("price");         
//            System.out.println("5");
    		sql = "select price from menu where name ='"+menu2+"'";
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            int price2 = rs.getInt("price");
            rs.close();
            stmt.close();
               

//            
            String sql1="insert into custom values(?,?,?,?,to_char(sysdate,'yyyymmdd'))";
   		 	PreparedStatement ps1 = conn.prepareStatement(sql1);
            //��ǰDB//
			ps1.setString(1,menu2 );
            //����DB//
            ps1.setInt(2,count2);
            //����Ϲ�ȣDB//
            ps1.setInt(3, price2);
            ps1.setString(4, mobile);
            ps1.executeUpdate();
            System.out.println("���Ͻô� ��ǰ�� �Է����ּ���.��Ҵ� ����");
            menu2 = sc1.nextLine();
            menu1.add(menu2);
            
//            Menu menu = new Menu();
//            menu.price(conn);
             
//            rs.close();
//            stmt.close();
        }
        conn.close();
        
	}

    void getMethod() {
    	for(int i = 0 ; i<=mobile1.size();i++) {
    	  System.out.println(mobile1.get(i));
    	}
    	for(int j = 0 ; j<=menu1.size();j++) {
    		System.out.println(menu1.get(j));
    	}
    	for(int k = 0 ; k<=count1.size();k++) {
    		System.out.println(count1.get(k));
    	}
    	
    }
    void total(Connection conn) throws SQLException, ClassNotFoundException{
    	String sql7 = "select order_number, order_cnt, price, mobile, order_date from custom";
        Statement stmt7=conn.createStatement();
        ResultSet rs=stmt7.executeQuery(sql7);
        int sum =0;
        while(rs.next()) {
        	int order_number = rs.getInt("order_number");
        	int order_cnt = rs.getInt("order_cnt");
        	int price = rs.getInt("price");
        	int mobile = rs.getInt("mobile");        	
        	int order_date = rs.getInt("order_date");
        	
        	while(rs.next()) {
        		System.out.println(order_cnt*price+"��, ��ȣ: " + mobile+", �ֹ���¥:" + order_date);
        		sum += order_cnt*price;
        	}System.out.println(sum);
      
        };System.out.println("2");
        
        rs.close();
        stmt7.close();
    	
    	
    	
    }
    

}