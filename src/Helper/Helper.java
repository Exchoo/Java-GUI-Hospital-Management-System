package Helper; //S�k kulland���m�z metodlar� buraya static tan�ml� �ekilde yaz�yoruz.Tekrardan kurtuluyoruz.

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {

	public static void optionPaneChangeButtonText() { // Yes No Cancel Okey buttonlar�n� t�rk�ele�tirdik
		UIManager.put("OptionPane.cancelButtonText", "�ptal");
		UIManager.put("OptionPane.noButtonText", "Hay�r");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");

	}

	public static void showMsg(String str) {
		String msg;
		optionPaneChangeButtonText();
		switch (str) { // bo� alan b�rak�labilecek yerlere str ="fill" olacak �ekilde bu metodu
						// yazaca��z.
		case "fill":
			msg = "L�tfen T�m Alanlar� Doldurnuz..";
			break;
		case "succes":
			msg = "��lem Ba�ar�l� !";
			break;

		default: // Di�er mesajlarda ekrana b�yle bas�lacak.
			msg = str;
			break;
		}
		JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean confirm(String str) {
		String msg;
		optionPaneChangeButtonText();
		switch (str) {
		case "sure":
			msg = "Bu i�lemi ger�ekle�tirmek istiyor musunuz ?";
			break;

		default:
			msg = str;
			break;
		}
		int result = JOptionPane.showConfirmDialog(null, msg, "Dikkat ! ", JOptionPane.YES_NO_OPTION);
		if (result == 0) { // Yes'e t�klad�ysa
			return true;
		} else
			return false;

	}
}
