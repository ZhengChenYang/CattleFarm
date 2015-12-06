package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import util.Cattle;
import util.HandleDB;

public class MainFrame extends JFrame { // ������

	private static OneMenuBar menuBar = new OneMenuBar();
	private Container container;

	/**
	 * JList����ʾ
	 */
	public Vector<Cattle> cattleVector = new Vector<Cattle>();
	private JList<Cattle> cattleList = new JList<Cattle>(cattleVector);

	private JPanel centerPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();

	/**
	 * ǰ��ţ������ţ�洢�б� ��ǰţ
	 */
	public Cattle currentCattle;
	public List<Cattle> advenceList;
	public List<Cattle> retreatList;

	/**
	 * ǰ�� ���� ������
	 */
	public JButton retreatButton = new JButton();
	public JButton advanceButton = new JButton();
	public JButton goTo = new JButton();
	public JTextField idBar = new JTextField(35);

	/**
	 * �� �в�����
	 */
	public JScrollPane leftScrollPane = new JScrollPane(cattleList);
	public JScrollPane centerScrollPane = new JScrollPane();

	/**
	 * ���� ��� ɾ��
	 */
	public JButton deleteButton = new JButton("ɾ��");
	public JButton addButton = new JButton("���");

	MainFrame() {
		super("ţ������ϵͳ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setJMenuBar(menuBar);
		setSize(1230, 850);
		setLayout(new BorderLayout());

		// �������ݿ�
		HandleDB.connectDB();

		// ��ʼ��װ�ؼ�
		container = getContentPane();

		container.add(BorderLayout.NORTH, menuBar);
		container.add(BorderLayout.CENTER, centerPanel);

		// �����м�ؼ�
		setCenterPanel();

		// ���õײ��ؼ�
		setBottomPanel();

		setVisible(true);
	}

	private void setCenterPanel() {
		// ǰ�� ���� ������
		advanceButton.setIcon(new ImageIcon("res\\retreatSolid.png"));
		advanceButton.setEnabled(false);
		advanceButton.setBounds(275, 25, 25, 25);
		retreatButton.setIcon(new ImageIcon("res\\advanceSolid.png"));
		retreatButton.setEnabled(false);
		retreatButton.setBounds(300, 25, 25, 25);
		idBar.setBounds(400, 25, 400, 25);
		idBar.setBorder(BorderFactory
				.createLineBorder(new Color(144, 144, 144)));
		goTo.setBounds(800, 25, 20, 25);
		goTo.setIcon(new ImageIcon("res\\goTo.png"));
		centerPanel.add(advanceButton);
		centerPanel.add(retreatButton);
		centerPanel.add(idBar);
		centerPanel.add(goTo);

		// ��� �м���湹��
		centerPanel.setLayout(null);
		leftScrollPane.setBounds(25, 80, 200, 610);
		centerScrollPane.setBounds(230, 80, 950, 650);
		centerPanel.add(leftScrollPane);
		centerPanel.add(centerScrollPane);

		// ���°�ť
		deleteButton.setBounds(30, 695, 80, 35);
		deleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				delete();
				initListData();
				cattleList.setSelectedIndex(0);
			}
		});
		addButton.setBounds(140, 695, 80, 35);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		centerPanel.add(deleteButton);
		centerPanel.add(addButton);

		// cattleList�����¼�����
		cattleList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int pos = ((JList) e.getSource()).getSelectedIndex();
				Cattle cattle = cattleVector.get(pos);
				CattleInfoPanel cattlePanel = new CattleInfoPanel(cattle);
				centerScrollPane.setViewportView(cattlePanel);
			}
		});

		// ����ţList����
		initListData();
	}

	private void setBottomPanel() {
		bottomPanel.setLayout(new FlowLayout());
	}

	/**
	 * �����ݿ��л�ȡ���ݣ���ʼ��JList�е�����
	 */
	private void initListData() {
		// ��ȡ������
		ResultSet rs = HandleDB.queryDB(HandleDB.SELECT_BASIS_CATTLE);
		try {
			System.out.println("this");
			while (rs.next()) {
				String id = rs.getString("idOfCattle");
				System.out.println(id);
				String features = rs.getString("feature");
				Cattle cattle = new Cattle(id, features);
				cattleVector.add(cattle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void delete() {
		int selectedCattle[] = cattleList.getSelectedIndices();
		for (int counter = 0; counter < selectedCattle.length; counter++) {
			HandleDB.updateDB(HandleDB.deleteData("basis_cattle",
					"idOfCattle = "
							+ cattleVector.get(selectedCattle[counter])
									.getIdOfCattle()));
			System.out
					.println("delete:"
							+ "idOfCattle = "
							+ cattleVector.get(selectedCattle[counter])
									.getIdOfCattle());
		}
	}
}
