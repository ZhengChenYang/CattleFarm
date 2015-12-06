package windows;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.BasisTable;
import util.Cattle;

public class CattleInfoPanel extends JPanel {

	/**
	 * ţ�ı��
	 */
	private static JLabel idLabel = new JLabel("��ţ�");
	private static JTextField idText = new JTextField(20);

	/**
	 * ţ��Ʒ��
	 */
	private static JLabel featureLabel = new JLabel("Ʒ�֣�");
	private static JTextField featureText = new JTextField();

	/**
	 * ������ѡ����
	 */
	private static JLabel seeTable = new JLabel("�鿴��Ϣ��");
	private static String tableName[] = { "������Ϣ", "���̼�¼", "��̥��¼", "��������",
			"���߷�Ӧ��¼", "��ò����", "Ԥ��ע�估��Ҫ����", "�������" };
	private static JComboBox comboBox = new JComboBox(tableName);

	/**
	 * table��JPanel
	 */
	JScrollPane tableScrollPane = new JScrollPane();

	public CattleInfoPanel(Cattle cattle) {
		setLayout(null);
		setBackground(new Color(255, 255, 255));

		// ���ñ�ű�ǩ
		idLabel.setFont(new Font("����", Font.BOLD, 19));
		idLabel.setBounds(40, 20, 65, 20);
		add(idLabel);
		// ��ʾ�����Ϣ
		String idOfCattle = cattle.getIdOfCattle();
		idText.setFont(new Font("����", Font.BOLD, 18));
		idText.setText(idOfCattle);
		idText.setBounds(95, 20, 80, 20);
		idText.setEditable(false);
		idText.setBorder(BorderFactory
				.createLineBorder(new Color(238, 238, 238)));
		idText.setBackground(new Color(255, 255, 255));
		add(idText);

		// ����Ʒ�ֱ�ǩ
		featureLabel.setFont(new Font("����", Font.BOLD, 19));
		featureLabel.setBounds(180, 20, 65, 20);
		add(featureLabel);
		// ��ʾƷ����Ϣ
		featureText.setFont(new Font("����", Font.BOLD, 18));
		featureText.setText("sss");
		featureText.setBounds(235, 20, 80, 20);
		featureText.setEditable(false);
		featureText.setBorder(BorderFactory.createLineBorder(new Color(238,
				238, 238)));
		featureText.setBackground(new Color(255, 255, 255));
		add(featureText);

		// �����������ǩ
		seeTable.setFont(new Font("����", Font.BOLD, 19));
		seeTable.setBounds(400, 20, 100, 20);
		add(seeTable);
		// ����������
		comboBox.setBounds(500, 19, 180, 23);
		comboBox.setFont(new Font("����", Font.BOLD, 15));
		add(comboBox);

		tableScrollPane.setBounds(25, 60, 900, 555);
		tableScrollPane.setViewportView(new BasisTable(idOfCattle));
		add(tableScrollPane);

	}

}
