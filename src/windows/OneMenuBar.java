package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OneMenuBar extends JMenuBar { // �˵���

	private static JMenu mFile; // "�ļ�"�˵�

	private static JMenuItem miNew;

	private static JMenuItem miQuit;

	private static JMenuItem miAdd;

	private static boolean isOnlyRead = true;

	OneMenuBar() {
		mFile = new JMenu("�ļ�");
		miNew = new JMenuItem("�˳�");
		miQuit = new JMenuItem("�޸�ģʽ");
		miAdd = new JMenuItem("������ţ");

		miAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jf = new JFrame();

			}
		});
		mFile.add(miNew);
		mFile.add(miQuit);
		mFile.add(miAdd);

		add(mFile);
	}
}
