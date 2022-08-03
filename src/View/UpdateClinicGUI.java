package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Clinic;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateClinicGUI extends JFrame {

	private JPanel contentPane;
	private JTextField fld_clinicName;
	private static Clinic clinic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClinicGUI frame = new UpdateClinicGUI(clinic);	//clinic'i biz ekledik.
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
	public UpdateClinicGUI(Clinic clinic) {	//Clinic clinic'i biz ekledik.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Poliklinik Ad\u0131");
		lblNewLabel_1_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(10, 11, 103, 14);
		contentPane.add(lblNewLabel_1_3);
		
		fld_clinicName = new JTextField();
		fld_clinicName.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		fld_clinicName.setColumns(10);
		fld_clinicName.setBounds(10, 28, 189, 29);
		fld_clinicName.setText(clinic.getName()); //Hangi Polikliniði düzenliyeceðimiz poliklinik adýný set ettik.
		contentPane.add(fld_clinicName);
		
		JButton btn_updateClinic = new JButton("D\u00FCzenle");
		btn_updateClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Helper.confirm("sure")) {
					clinic.updateClinic(clinic.getId(), fld_clinicName.getText());
					Helper.showMsg("succes");
					dispose();
				}
			}
		});
		btn_updateClinic.setBounds(10, 68, 189, 33);
		contentPane.add(btn_updateClinic);
	}
}
