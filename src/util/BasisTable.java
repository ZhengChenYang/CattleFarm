package util;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BasisTable extends JPanel {

	/**
	 * ����id
	 */
	JLabel fatherIdLabel = new JLabel("����");
	JTextField fatherId = new JTextField();

	/**
	 * ĸ��id
	 */
	JLabel montherIdLabel = new JLabel("ĸ��");
	JTextField mothrerId = new JTextField();

	/**
	 * ��������
	 */
	JLabel birthDateLabel = new JLabel("��������");
	JTextField birthDate = new JTextField();

	/**
	 * �����ص�
	 */
	JLabel birthPlaceLabel = new JLabel("�����ص�");
	JTextField birthPlace = new JTextField();

	/**
	 * ëɫ
	 */
	JLabel colorLabel = new JLabel("ëɫ");
	JTextField color = new JTextField();

	/**
	 * ��ǰ���
	 */
	JLabel curSituationLabel = new JLabel("��ǰ���");
	JTextArea curSituation = new JTextArea();

	/**
	 * ֹͣ��������
	 */
	JLabel stopFeedingDateLabel = new JLabel("ֹͣ��������");
	JTextField stopFeedingDate = new JTextField();

	/**
	 * ��������
	 */
	JLabel birthWeightLabel = new JLabel("��������");
	JTextField birthWeight = new JTextField();

	ResultSet rs;

	public BasisTable(String id) {

		String sql = HandleDB.selectData("basis_cattle", id);
		rs = HandleDB.queryDB(sql);
		birthDateLabel.setBounds(25, 25, 65, 20);
		birthDateLabel.setFont(new Font("����", Font.BOLD, 19));
		add(birthDateLabel);
		// re.getString("idOfFather");

	}
}
