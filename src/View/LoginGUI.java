package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Bashekim;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import Helper.*;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_HastaTc;
	private JTextField fld_HastaSifre;
	private JTextField fld_doctorTc;
	private JPasswordField fld_doctorPass;
	private DBConnection conn = new DBConnection();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setResizable(false);
		setTitle("Hastane Otomasyonu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("medicine.png")));
		lbl_logo.setBounds(154, 0, 143, 117);
		w_pane.add(lbl_logo);
		
		JLabel lblNewLabel = new JLabel("Hastane Y\u00F6netim Sistemine Ho\u015Fgeldiniz !");
		lblNewLabel.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 20));
		lblNewLabel.setBounds(105, 115, 259, 27);
		w_pane.add(lblNewLabel);
		
		JTabbedPane w_tabpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabpane.setBounds(10, 142, 474, 219);
		w_pane.add(w_tabpane);
		
		JPanel w_hastaLogin = new JPanel();
		w_hastaLogin.setBackground(Color.WHITE);
		w_tabpane.addTab("Hasta Giriþi", null, w_hastaLogin, null);
		w_hastaLogin.setLayout(null);
		
		JLabel lblTcN = new JLabel("T.C.  Numaran\u0131z : ");
		lblTcN.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 20));
		lblTcN.setBounds(37, 11, 126, 27);
		w_hastaLogin.add(lblTcN);
		
		JLabel lblifre = new JLabel("\u015Eifre :");
		lblifre.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 20));
		lblifre.setBounds(37, 65, 126, 27);
		w_hastaLogin.add(lblifre);
		
		fld_HastaTc = new JTextField();
		fld_HastaTc.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 18));
		fld_HastaTc.setBounds(173, 11, 224, 26);
		w_hastaLogin.add(fld_HastaTc);
		fld_HastaTc.setColumns(10);
		
		fld_HastaSifre = new JTextField();
		fld_HastaSifre.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 18));
		fld_HastaSifre.setColumns(10);
		fld_HastaSifre.setBounds(173, 65, 224, 26);
		w_hastaLogin.add(fld_HastaSifre);
		 
		JButton btn_register = new JButton("Kay\u0131t Ol");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_register.setBounds(37, 119, 183, 49);
		w_hastaLogin.add(btn_register);
		
		JButton btn_hastaLogin = new JButton("Giri\u015F Yap");
		btn_hastaLogin.setBounds(258, 119, 183, 49);
		w_hastaLogin.add(btn_hastaLogin);
		
		JPanel w_doctorLogin = new JPanel();
		w_doctorLogin.setBackground(Color.WHITE);
		w_tabpane.addTab("Doktor Giriþi", null, w_doctorLogin, null);
		w_doctorLogin.setLayout(null);
		
		JLabel lblTcN_1 = new JLabel("T.C.  Numaran\u0131z : ");
		lblTcN_1.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 20));
		lblTcN_1.setBounds(33, 23, 126, 27);
		w_doctorLogin.add(lblTcN_1);
		
		fld_doctorTc = new JTextField();
		fld_doctorTc.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 18));
		fld_doctorTc.setColumns(10);
		fld_doctorTc.setBounds(169, 23, 224, 26);
		w_doctorLogin.add(fld_doctorTc);
		
		JLabel lblifre_1 = new JLabel("\u015Eifre :");
		lblifre_1.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 20));
		lblifre_1.setBounds(33, 77, 126, 27);
		w_doctorLogin.add(lblifre_1);
		
		JButton btn_doctorLogin = new JButton("Giri\u015F Yap");
		btn_doctorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	if(fld_doctorTc.getText().length() == 0 || fld_doctorPass.getText().length() ==0 ) { Bunun yerine direkt aþaðýdakini yazýyoruz(Helper class'ýný)
					JOptionPane.showMessageDialog(null, "Lütfen Tüm Alanlarý Doldurunuz.."); }*/
				//Helper helper = new Helper();  Bunun yerine  en üste package'ý dahil ediyoruz
				if(fld_doctorTc.getText().length() == 0 || fld_doctorPass.getText().length() ==0 ) {
				Helper.showMsg("fill");
				}else {
					
					try {
						Connection con = conn.connDB(); // Yukarda DBConnectiondan conn adýnda obje türettik.Burda ise obje ile method çaðýrdýk.
						Statement st = con.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM user");
						while(rs.next()) {
							if(fld_doctorTc.getText().equals(rs.getString("tcno"))&& fld_doctorPass.getText().equals(rs.getString("password"))) {
								Bashekim bhekim = new Bashekim();
								bhekim.setId(rs.getInt("id"));
								bhekim.setPassword(rs.getString("password"));
								bhekim.setTcno(rs.getString("tcno"));
								bhekim.setName(rs.getString("name"));
								bhekim.setType(rs.getString("type"));
								//System.out.println(bhekim.getName());
								BashekimGUI bGUI=new BashekimGUI(bhekim);
								bGUI.setVisible(true);
								dispose(); //Bu JFrame'i öldürür.
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btn_doctorLogin.setBounds(44, 131, 387, 49);
		w_doctorLogin.add(btn_doctorLogin);
		
		fld_doctorPass = new JPasswordField();
		fld_doctorPass.setBounds(169, 77, 224, 27);
		w_doctorLogin.add(fld_doctorPass);
	}
}
