package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.ksmart.driverdb.DriverDB;
import kr.or.ksmart.dto.User;

//��ü ȸ�������� ���� Ŭ����
public class Mdao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	User u = null;
	ArrayList<User> alm = new ArrayList<User>();
	
	//08 ���̵� �Է¹޾� �̸��� ������ �����ϴ� �޼��� ����
	public User mGetForSession(String in_id) throws ClassNotFoundException, SQLException{
		System.out.println("08 mGetForSession Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("select user_level,user_name from tb_user where user_id=?");
		pstmt.setString(1, in_id);
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			u = new User();
			u.setUser_level(rs.getString("user_level"));
			u.setUser_name(rs.getString("user_name"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return u;
	}
	
	//07 ���̵�� ��� �Է¹޾� DB���̵�� ��� Ȯ�� �� �����ϴ� �޼��� ����
	//���ϻ�Ȳ : 01 ���̵����ġ 02 �α��μ��� 03 ��й�ȣ ����ġ
	public String mLoginCheck(String id, String pw) throws ClassNotFoundException, SQLException {
	
	System.out.println("07 mLoginCheck Mdao.java");
	String re = null;
	DriverDB db = new DriverDB();
	conn = db.driverDbcon();
	pstmt = conn.prepareStatement("select * from tb_user where user_id=?");
	pstmt.setString(1, id);
	rs = pstmt.executeQuery();
			if(rs.next()){
				if(pw.equals(rs.getString("user_pw"))){
					re = "02�α��μ���";
					//session������ ����
					
				} else {
					re = "03�������ġ";
				}
			}else {
				re = "01���̵����ġ";
			}
			rs.close();
			pstmt.close();
			conn.close();
			return re;
}
	
	//06 ȸ���˻� �޼��� ����
	public ArrayList<User> mSearch(String sk, String sv) throws ClassNotFoundException, SQLException {
		System.out.print("06 mSearch Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		if(sk == null & sv == null){
			System.out.println("01 sk �� sv ���� ����");
			pstmt = conn.prepareStatement("select * from tb_user");
			//select * from tb_user; 
		}else if(sk != null & sv.equals("")){
			System.out.println("02 sk ���ְ� sv ���� ����");
			pstmt = conn.prepareStatement("select * from tb_user");
			//select * from tb_user; 
		}else if(sk != null & sv != null){
			System.out.println("03 sk sv �Ѵ� �ִ� ����");
			pstmt = conn.prepareStatement("select * from tb_user where "+sk+"=?");
			pstmt.setString(1, sv);
		}
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			u = new User();
			System.out.println(u+"<-u mSearch Mdao.java");
			u.setUser_id(rs.getString("user_id"));
			u.setUser_pw(rs.getString("user_pw"));
			u.setUser_name(rs.getString("user_name"));
			u.setUser_level(rs.getString("user_level"));
			u.setUser_add(rs.getString("user_add"));
			
			alm.add(u);
			System.out.println(alm+"<- alm mSearch Mdao.java");
		}
		pstmt.close();
		conn.close();
		return alm;
	}

	//05 ��üȸ����ȸ �޼���
	public ArrayList<User> mAllSelect() throws ClassNotFoundException, SQLException{
		System.out.print("05 mAllSelect Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("select * from tb_user");
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			u = new User();
			System.out.println(u+"<- m mAllSelect Mdao.java");
			u.setUser_id(rs.getString("user_id"));
			u.setUser_pw(rs.getString("user_pw"));
			u.setUser_name(rs.getString("user_name"));
			u.setUser_level(rs.getString("user_level"));
			u.setUser_add(rs.getString("user_add"));
			
			alm.add(u);
			System.out.println(alm+"<- alm mAllSelect Mdao.java");
		}
		pstmt.close();
		conn.close();
		return alm;
	}

	//04 �Ѹ�ȸ������ ��ȸ �޼��� ����(����ȭ�� �Ǵ� �󼼺��� ��)
	public User mSelectforUpdate(String userid) throws ClassNotFoundException, SQLException{
		System.out.println("04 mSelectforUpdate Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("select * from tb_user where user_id=?");
		pstmt.setString(1, userid);
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			u = new User();
			u.setUser_id(rs.getString("user_id"));
			u.setUser_pw(rs.getString("user_pw"));
			u.setUser_name(rs.getString("user_name"));
			u.setUser_level(rs.getString("user_level"));
			u.setUser_add(rs.getString("user_add"));
		}
		pstmt.close();
		conn.close();
		return u;
	}
	
	//03 ����ó�� �ż��� ����
	public void mDelete(String userid) throws ClassNotFoundException, SQLException {
		System.out.println("03 ����ó�� �ż��� ����");
		
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		
		pstmt = conn.prepareStatement(
				"DELETE FROM tb_user WHERE user_id=?");
		pstmt.setString(1, userid);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}

	//02 ����ó�� �ż��� ����
	public void mUpdate(User u) throws ClassNotFoundException, SQLException {
		System.out.println("02 ����ó�� �ż��� ����");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		
		
		pstmt = conn.prepareStatement(
				"UPDATE tb_user SET user_pw=?,user_name=?,user_level=?,user_add=? WHERE user_id=?");
		System.out.println(pstmt + "<-- pstmt 1");
		System.out.println(pstmt.getClass() + "<-- pstmt.getClass() 1");

		pstmt.setString(1, u.getUser_pw());
		pstmt.setString(2, u.getUser_name());
		pstmt.setString(3, u.getUser_level());
		pstmt.setString(4, u.getUser_add());
		pstmt.setString(5, u.getUser_id());
		
		System.out.println(pstmt + "<-- pstmt 2");
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	//01_02 ȸ����� �޼��� ����
	public void mInsert(User u) throws SQLException, ClassNotFoundException{
		//3�ܰ� ���������غ���� ����
		System.out.println("01_02 ȸ����� �޼��� ����");
		
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		
		try{		
			pstmt = conn.prepareStatement(
					"INSERT INTO tb_user VALUES (?, ?, ?, ?, ?)");
			pstmt.setString(1, u.getUser_id());
			pstmt.setString(2, u.getUser_pw());
			pstmt.setString(3, u.getUser_name());
			pstmt.setString(4, u.getUser_level());
			pstmt.setString(5, u.getUser_add());
			
			System.out.println(pstmt + "<--  pstmt mInsert Mdao.java");
			
			pstmt.executeUpdate();
		}finally{
			//06�ܰ� :statement �Ǵ� prepareStatement��ü ����(close())
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			//07�ܰ� :Connection ��ü ����(close())
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}	
	
	//ȸ������
}
