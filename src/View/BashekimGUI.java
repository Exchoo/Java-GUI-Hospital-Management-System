package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Model.*;


import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Helper.*;

public class BashekimGUI extends JFrame {
	static Bashekim bashekim= new Bashekim();
	Clinic clinic = new Clinic();
	private JPanel w_pane;
	private JTextField fld_dName;
	private JTextField fld_dTcno;
	private JTextField fld_dPass; 
	private JTextField fld_dID;
	private JTable table_doctor;
	
	private DefaultTableModel doctorModel=null;
	private Object[] doctorData=null;
	private JTable table_clinic;
	private JTextField fld_clinicName;
	
	private DefaultTableModel clinicModel = null;
	private Object[] clinicData= null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BashekimGUI frame = new BashekimGUI(bashekim);	//Consturctor'a Bashekim classýndan obje eklediðimiz için burayada bashekimi eklemek zorundayýz.
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public BashekimGUI(Bashekim bashekim) throws SQLException {
		
		JScrollPane scrollPane = new JScrollPane();		//Consturctor'a Bashekim nesnesi ekledik.En yukarýda objeyi oluþturup import ettik.
		getContentPane().add(scrollPane, BorderLayout.CENTER);
			//DoctorModel
		doctorModel= new DefaultTableModel(); 	//Table Objesini oluþturduk. En yukardada null olarak oluþturmuþtuk.
		Object[] colDoctorName = new Object[4]; // id name tc password olduðu için 4 boyutlu array oluþturduk //Table'daki column (kolonlarý) oluþturuyoruz.
		colDoctorName[0]= "ID";
		colDoctorName[1]= "TC NO";
		colDoctorName[2]= "Adý Soyadý";
		colDoctorName[3]= "Þifre";
		
		doctorModel.setColumnIdentifiers(colDoctorName);
		doctorData = new Object[4];
		
		for(int i=0; i< bashekim.getDoctorList().size();i++) {
			doctorData[0]=bashekim.getDoctorList().get(i).getId();
			doctorData[1]=bashekim.getDoctorList().get(i).getTcno();
			doctorData[2]=bashekim.getDoctorList().get(i).getName();
			doctorData[3]=bashekim.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
			
			
		}
		//ClinicModel
		clinicModel= new DefaultTableModel(); 	//Table Objesini oluþturduk. En yukardada null olarak oluþturmuþtuk.
		Object[] colClinic= new Object[2]; // id name tc password olduðu için 4 boyutlu array oluþturduk //Table'daki column (kolonlarý) oluþturuyoruz.
		colClinic[0]= "ID";
		colClinic[1]= "Poliklinik Adý";
		clinicModel.setColumnIdentifiers(colClinic);
		clinicData = new Object[2];
		
		for(int i=0; i< clinic.getList().size();i++) {
			clinicData[0]=clinic.getList().get(i).getId();
			clinicData[1]=clinic.getList().get(i).getName();
			clinicModel.addRow(clinicData);
			}
			
		
		setTitle("Hastane Y\u00F6netim Sistemi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoþgeldiniz,Sayýn "+bashekim.getName());
		lblNewLabel.setBounds(10, 11, 218, 21);
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton.setBounds(630, 12, 104, 23);
		btnNewButton.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		w_pane.add(btnNewButton);
		
		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setBounds(10, 83, 724, 378);
		w_pane.add(w_tab);
		
		JPanel w_doctor = new JPanel();
		w_doctor.setBackground(Color.WHITE);
		w_tab.addTab("Doktor Y\u00F6netimi", null, w_doctor, null);
		w_doctor.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(606, 11, 103, 14);
		w_doctor.add(lblNewLabel_1);
		
		fld_dName = new JTextField();
		fld_dName.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		fld_dName.setBounds(606, 29, 103, 20);
		w_doctor.add(fld_dName);
		fld_dName.setColumns(10);
		
		fld_dTcno = new JTextField();
		fld_dTcno.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		fld_dTcno.setColumns(10);
		fld_dTcno.setBounds(606, 78, 103, 20);
		w_doctor.add(fld_dTcno);
		
		JLabel lblNewLabel_1_1 = new JLabel("T.C No");
		lblNewLabel_1_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(606, 60, 103, 14);
		w_doctor.add(lblNewLabel_1_1);
		
		fld_dPass = new JTextField();
		fld_dPass.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		fld_dPass.setColumns(10);
		fld_dPass.setBounds(606, 127, 103, 20);
		w_doctor.add(fld_dPass);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u015Eifre");
		lblNewLabel_1_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(606, 109, 103, 14);
		w_doctor.add(lblNewLabel_1_2);
		
		JButton btn_addDoctor = new JButton("Ekle");
		btn_addDoctor.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		
		btn_addDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fld_dName.getText().length() == 0 || fld_dTcno.getText().length() == 0 || fld_dPass.getText().length() == 0 ) {
					Helper.showMsg("fill");
				}else {
					try {
						boolean control = bashekim.addDoctor(fld_dTcno.getText(), fld_dPass.getText(), fld_dName.getText());	
						if(control) {
						Helper.showMsg("succes");
						fld_dName.setText(null);
						fld_dPass.setText(null);
						fld_dTcno.setText(null); //Ekleye bastýktan sonra fld'larýn içi boþalýyor.
						updateDoctorModel();
						}
					
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
					}
				}
		});
		btn_addDoctor.setBounds(606, 158, 103, 23);
		w_doctor.add(btn_addDoctor);
		
		fld_dID = new JTextField();
		fld_dID.setEnabled(false);
		fld_dID.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		fld_dID.setColumns(10);
		fld_dID.setBounds(606, 219, 103, 20);
		w_doctor.add(fld_dID);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Kullan\u0131c\u0131 ID");
		lblNewLabel_1_2_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(606, 201, 103, 14);
		w_doctor.add(lblNewLabel_1_2_1);
		
		JButton btn_delDoctor = new JButton("Sil");
		btn_delDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_dID.getText().length() == 0 ) {
					Helper.showMsg("Lütfen Geçerli Bir Doktro Seçiniz.");
				}else {
					if(Helper.confirm("sure")) { //Kullanýcý Yes'e bastýysa.
						int selectID = Integer.parseInt(fld_dID.getText()); //fld_dID'yi integer'a çevirdik.
						try {
							boolean control = bashekim.deleteDoctor(selectID);
							if(control) {
								Helper.showMsg("succes");
								fld_dID.setText(null);
								updateDoctorModel();
							}	
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btn_delDoctor.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		btn_delDoctor.setBounds(606, 250, 103, 23);
		w_doctor.add(btn_delDoctor);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 11, 580, 328);
		w_doctor.add(scrollPane1);
		
		table_doctor = new JTable(doctorModel);
		scrollPane1.setViewportView(table_doctor);
				
		
		table_doctor.getSelectionModel().addListSelectionListener(new ListSelectionListener() { //Tabloda üzerine týkladýðýmýz kolonun id sini kullanýcý id ' ye yazdýrma.
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
			try {	//Kendimiz Try/catch ' e aldýk.Çünkü sildiðimizde hala Týklanlanýlmýþ bir Þekilde sildiði için sildikten sonra o id yi bulamayýp hata veriyor.
				fld_dID.setText(table_doctor.getValueAt(table_doctor.getSelectedRow(), 0).toString());
			} catch (Exception e2) {
				// TODO: handle exception
			}
				
			}
		});
		JPanel w_clinic = new JPanel();
		w_clinic.setBackground(Color.WHITE);
		w_tab.addTab("Poliklinikler", null, w_clinic, null);
		w_clinic.setLayout(null);
		
		JScrollPane w_scrollClinic = new JScrollPane();
		w_scrollClinic.setBounds(10, 11, 272, 328);
		w_clinic.add(w_scrollClinic);
		
		JPopupMenu clinicMenu = new JPopupMenu();	//Table'ýn içinde bir popup menu oluþturduk.Bunu polikliniklerin üzerine sað týklayýnca güncelle ve sil olacak þekilde kullanacaðýz.
		JMenuItem updateMenu = new JMenuItem("Güncelle");
		JMenuItem deleteMenu = new JMenuItem("Sil");
		clinicMenu.add(updateMenu);
		clinicMenu.add(deleteMenu);
		
		updateMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	//Bu güncelleme iþlemini Doktor Yöetimi penceresi gibide yapabilirz.Bu farklý bir yöntem..
				
				int selectedID = Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(), 0).toString());	//getSelectedRow aþaðýdaki aldýðýmýz koordinatlardýr.
				Clinic selectClinic = clinic.getFetch(selectedID);
				UpdateClinicGUI updateGUI = new UpdateClinicGUI(selectClinic); //selectClinic'i fld_clinicName'e atýyor.
				updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateGUI.setVisible(true);
			
				updateGUI.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						try {
							uptadeClinicModel();
	 					} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}
				});
			}
		});
		
		deleteMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Helper.confirm("sure")) {
					int selectedID = Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(), 0).toString()); //seçtiðimiz noktayý alýyor .
					try {
						if(clinic.deleteClinic(selectedID)) {
							Helper.showMsg("succes");
							uptadeClinicModel();
							
						}else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		
		table_clinic = new JTable(clinicModel);
		table_clinic.setComponentPopupMenu(clinicMenu); // Sað týklayýnca yukarýdaki popup menü çýkacak.
		table_clinic.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { //Sað týkladýðýmýz kolonun koordinatlarýný alýyor biz buna göre iþlem yapýyoruz yukarda.
				Point point = e.getPoint();
				int selectedRow = table_clinic.rowAtPoint(point);
				table_clinic.setRowSelectionInterval(selectedRow, selectedRow);
			}
		});
		w_scrollClinic.setViewportView(table_clinic);
		
		JLabel lblNewLabel_1_3 = new JLabel("Poliklinik Ad\u0131");
		lblNewLabel_1_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(292, 11, 103, 14);
		w_clinic.add(lblNewLabel_1_3);
		
		fld_clinicName = new JTextField();
		fld_clinicName.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		fld_clinicName.setColumns(10);
		fld_clinicName.setBounds(292, 28, 130, 29);
		w_clinic.add(fld_clinicName);
		
		JButton btn_addClinic = new JButton("Ekle");
		btn_addClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fld_clinicName.getText().length() == 0 ) {
					Helper.showMsg("fill");
				}else {
					try {
						if(clinic.addClinic(fld_clinicName.getText())) {
							Helper.showMsg("succes");
							fld_clinicName.setText(null);
							uptadeClinicModel();
 
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btn_addClinic.setBounds(292, 61, 130, 29);
		w_clinic.add(btn_addClinic);
		
		JScrollPane w_scrollClinic_1 = new JScrollPane();
		w_scrollClinic_1.setBounds(437, 11, 272, 328);
		w_clinic.add(w_scrollClinic_1);

	}
	public void updateDoctorModel () throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_doctor.getModel();
		clearModel.setRowCount(0); //Bunu yazýnca table'daki bütün veriler siliniyor.
		
		for(int i=0; i< bashekim.getDoctorList().size();i++) {	//Sonra tabloya tekrar DB'deki bütün veriler yazýlýyor.Tablo güncellenmiþ oluyor.Yukarýda kullandýk bu methodu.
			doctorData[0]=bashekim.getDoctorList().get(i).getId();
			doctorData[1]=bashekim.getDoctorList().get(i).getTcno();
			doctorData[2]=bashekim.getDoctorList().get(i).getName();
			doctorData[3]=bashekim.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
			}
	}
	
	public void uptadeClinicModel () throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_clinic.getModel();
		clearModel.setRowCount(0);
		for(int i=0; i< clinic.getList().size();i++) {	// Yukarda kullandýðýmýz for döngüsünü tekrar kullandýk
			clinicData[0]=clinic.getList().get(i).getId();
			clinicData[1]=clinic.getList().get(i).getName();
			clinicModel.addRow(clinicData);
			}
	}
}

