package Model;

import Helper.DBConnection;

//Database'den çektiðimiz verileri sýnýflara aktardýðýmýz package..

public class User {

	private int id;
	String tcno, name, password, type;
	DBConnection conn = new DBConnection(); // Helper package'ýnýn içindeki calsstan obje türettik.Yaný User
											// class'ýný DB'e baðladýk.Dolayýsýyla bütün userlar baðlanmýþ oldu.

	public User(int id, String tcno, String name, String password, String type) {
		this.id = id;
		this.tcno = tcno;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public User() {
	} // Boþ conturctor

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
