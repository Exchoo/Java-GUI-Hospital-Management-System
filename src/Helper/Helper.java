package Helper; //Sýk kullandýðýmýz metodlarý buraya static tanýmlý þekilde yazýyoruz.Tekrardan kurtuluyoruz.

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {

	public static void optionPaneChangeButtonText() { // Yes No Cancel Okey buttonlarýný türkçeleþtirdik
		UIManager.put("OptionPane.cancelButtonText", "Ýptal");
		UIManager.put("OptionPane.noButtonText", "Hayýr");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");

	}

	public static void showMsg(String str) {
		String msg;
		optionPaneChangeButtonText();
		switch (str) { // boþ alan býrakýlabilecek yerlere str ="fill" olacak þekilde bu metodu
						// yazacaðýz.
		case "fill":
			msg = "Lütfen Tüm Alanlarý Doldurnuz..";
			break;
		case "succes":
			msg = "Ýþlem Baþarýlý !";
			break;

		default: // Diðer mesajlarda ekrana böyle basýlacak.
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
			msg = "Bu iþlemi gerçekleþtirmek istiyor musunuz ?";
			break;

		default:
			msg = str;
			break;
		}
		int result = JOptionPane.showConfirmDialog(null, msg, "Dikkat ! ", JOptionPane.YES_NO_OPTION);
		if (result == 0) { // Yes'e týkladýysa
			return true;
		} else
			return false;

	}
}
