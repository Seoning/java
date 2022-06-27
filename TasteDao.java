import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TasteDao {
	String load="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String id="jspid";
	String pw="jsppw";
	Connection conn=null;
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	
	TasteDao(){
		try {
			Class.forName(load);
		} catch (ClassNotFoundException e) {
			System.out.println("로드");
		}
	}//TasteDao
	
	void Connect(){
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			System.out.println("연결");
		}
	}//Connect

	public ArrayList <TasteBean> SelectAll() {
		ArrayList <TasteBean> lists = new ArrayList <TasteBean> ();
		Connect();
		sql = "select * from taste order by no";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String region = rs.getString("region");
				String type = rs.getString("type");
				String store = rs.getString("store");
				String food = rs.getString("food");
				int price = rs.getInt("price");
				String open = rs.getString("open");
				String close = rs.getString("close");
				String vacancy = rs.getString("vacancy");
				Double star = rs.getDouble("star");
				
				TasteBean tb = new TasteBean();
				
				tb.setNo(no);
				tb.setRegion(region);
				tb.setType(type);
				tb.setStore(store);
				tb.setFood(food);
				tb.setPrice(price);
				tb.setOpen(open);
				tb.setClose(close);
				tb.setVacancy(vacancy);
				tb.setStar(star);
				
				lists.add(tb);
				
			}
		} catch (SQLException e) {
			System.out.println("sql");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close");
			}
		}
		return lists;
	}//SelectAll

	public ArrayList <TasteBean> SelectRegion(String region, String type) {
		ArrayList <TasteBean> lists = new ArrayList <TasteBean> ();
		Connect();
		sql = "select * from taste where region = '"+region+"'and type = '"+type+"'";
//		select * from taste where region = '서울';
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String region2 = rs.getString("region");
				String type2 = rs.getString("type");
				String store = rs.getString("store");
				String food = rs.getString("food");
				int price = rs.getInt("price");
				String open = rs.getString("open");
				String close = rs.getString("close");
				String vacancy = rs.getString("vacancy");
				Double star = rs.getDouble("star");
				
				TasteBean tb = new TasteBean();
				
				tb.setNo(no);
				tb.setRegion(region2);
				tb.setType(type2);
				tb.setStore(store);
				tb.setFood(food);
				tb.setPrice(price);
				tb.setOpen(open);
				tb.setClose(close);
				tb.setVacancy(vacancy);
				tb.setStar(star);
				
				lists.add(tb);
				
			}
		} catch (SQLException e) {
			System.out.println("sql");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close");
			}
		}
		return lists;
		
	}//SelectRegion

	public int TasteAdd(TasteBean tb) {
		Connect();
		int insert=-1;
		sql = "insert into taste values(tasteseq.nextval,?,?,?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, tb.getRegion());
			ps.setString(2, tb.getType());
			ps.setString(3, tb.getStore());
			ps.setString(4, tb.getFood());
			ps.setInt(5, tb.getPrice());
			ps.setString(6, tb.getOpen());
			ps.setString(7, tb.getClose());
			ps.setString(8, tb.getVacancy());	
			ps.setDouble(9, tb.getStar());
			
			insert = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close");
			}
		}
		return insert;
	}//TasteAdd

	public int TasteDelete(int no) {
		Connect();
		int delete = -1;
		sql = "delete taste where no="+no;
		try {
			ps = conn.prepareStatement(sql);
			delete = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close");
			}
		}
		return delete;
	}//TasteDelete

	public int TasteUpdate(TasteBean tb) {
		Connect();
		int update=-1;
		sql = "update taste set region=?,type=?,store=?,food=?,price=?,open=?,close=?,vacancy=?,star=? where no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tb.getRegion());
			ps.setString(2, tb.getType());
			ps.setString(3, tb.getStore());
			ps.setString(4, tb.getFood());
			ps.setInt(5, tb.getPrice());
			ps.setString(6, tb.getOpen());
			ps.setString(7, tb.getClose());
			ps.setString(8, tb.getVacancy());
			ps.setDouble(9, tb.getStar());
			ps.setInt(10, tb.getNo());
			
			update=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close");
			}
		}
		return update;
		
	}//TasteUpdate

	public ArrayList <TasteBean> SelectByPrice(String input, String order) {
		ArrayList <TasteBean> lists = new ArrayList <TasteBean> ();
		Connect();
		sql = "select * from taste where region = '"+input+"' order by price "+order;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String region = rs.getString("region");
				String type = rs.getString("type");
				String store = rs.getString("store");
				String food = rs.getString("food");
				int price = rs.getInt("price");
				String open = rs.getString("open");
				String close = rs.getString("close");
				String vacancy = rs.getString("vacancy");
				Double star = rs.getDouble("star");
				
				TasteBean tb = new TasteBean();
				
				tb.setNo(no);
				tb.setRegion(region);
				tb.setType(type);
				tb.setStore(store);
				tb.setFood(food);
				tb.setPrice(price);
				tb.setOpen(open);
				tb.setClose(close);
				tb.setVacancy(vacancy);
				tb.setStar(star);
				
				lists.add(tb);
				
			}
		} catch (SQLException e) {
			System.out.println("sql");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close");
			}
		}
		return lists;
		
		
	}//SelectByPrice

	public ArrayList <TasteBean> SelectByOpen(String input, String time, String dayOfWeek) {
		ArrayList <TasteBean> lists = new ArrayList <TasteBean> ();
		Connect();
		sql = "Select * from taste where region = ? and open <= ? and vacancy not like ? order by no";//'10:30'
		//select * from taste where region = '서울' and open <='12:18' and vacancy not like '%월%';
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, input);
			ps.setString(2, time);
			ps.setString(3, "%"+dayOfWeek+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String region = rs.getString("region");
				String type = rs.getString("type");
				String store = rs.getString("store");
				String food = rs.getString("food");
				int price = rs.getInt("price");
				String open = rs.getString("open");
				String close = rs.getString("close");
				String vacancy = rs.getString("vacancy");
				Double star = rs.getDouble("star");
				
				TasteBean tb = new TasteBean();
				
				tb.setNo(no);
				tb.setRegion(region);
				tb.setType(type);
				tb.setStore(store);
				tb.setFood(food);
				tb.setPrice(price);
				tb.setOpen(open);
				tb.setClose(close);
				tb.setVacancy(vacancy);
				tb.setStar(star);
				
				lists.add(tb);
				
			}
		} catch (SQLException e) {
			System.out.println("sql");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close");
			}
		}
	
		return lists;	
	}//SelectByOpen

	public ArrayList <TasteBean> SelectByType(String type, String order) {
		ArrayList <TasteBean> lists = new ArrayList <TasteBean> ();
		Connect();
		sql = "select * from taste where type = '"+type+"' order by star "+order;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String region = rs.getString("region");
				String type2 = rs.getString("type");
				String store = rs.getString("store");
				String food = rs.getString("food");
				int price = rs.getInt("price");
				String open = rs.getString("open");
				String close = rs.getString("close");
				String vacancy = rs.getString("vacancy");
				Double star = rs.getDouble("star");
				
				TasteBean tb = new TasteBean();
				
				tb.setNo(no);
				tb.setRegion(region);
				tb.setType(type2);
				tb.setStore(store);
				tb.setFood(food);
				tb.setPrice(price);
				tb.setOpen(open);
				tb.setClose(close);
				tb.setVacancy(vacancy);
				tb.setStar(star);
				
				lists.add(tb);
				
			}
		} catch (SQLException e) {
			System.out.println("sql");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close");
			}
		}
		return lists;
	}//SelectByType

	
	
	
	
	
	
	
	
	
	
	

}
