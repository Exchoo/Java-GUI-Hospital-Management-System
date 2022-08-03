package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Clinic {

	private int id;
	private String name;

	DBConnection conn = new DBConnection(); // Helper package'�n�n i�indeki calsstan obje t�rettik.Yan� User class'�n�
											// DB'e ba�lad�k.Dolay�s�yla b�t�n userlar ba�lanm�� oldu.
	
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Clinic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Clinic() {
	}

	public ArrayList<Clinic> getList() throws SQLException {
		ArrayList<Clinic> list = new ArrayList<>();
		Clinic obj;
		Connection con = conn.connDB();// conn.connDB �st s�n�ftan geldi.
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic");
			while (rs.next()) {
				obj = new Clinic();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}

		return list;

	}

	public boolean addClinic(String name) throws SQLException {
		String query = "INSERT INTO clinic" + "(name) VALUES" + "(?)"; // Parantez i�indeki s�ra
																								// �nemli..User
																								// tablosundaki s�rayla
																								// ayn� olmal�..
		boolean key = false;
		Connection con = conn.connDB();
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (key)
			return true;
		else
			return false;
	}
	
	
	public boolean deleteClinic(int id) throws SQLException {
		String query = "DELETE FROM clinic WHERE id= ?";
		boolean key = false;
		Connection con = conn.connDB();

		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (key)
			return true;
		else
			return false;
	}
	
	public boolean updateClinic(int id ,String name) {
		String query = "UPDATE clinic SET name = ? WHERE id= ?";
		boolean key = false;
		Connection con = conn.connDB();

		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (key)
			return true;
		else
			return false;
	}
	
	public Clinic getFetch(int id) { //sadece 1 de�er �ekti�imiz method.
		Connection con = conn.connDB();
		Clinic c= new Clinic()	;
		try {
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM clinic WHERE id =" +id); //id'si consturctor'a girilen idyle ayn� olan�n name'ini �a��r�yoruz
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				break;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
