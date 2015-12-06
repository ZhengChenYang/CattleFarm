package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HandleDB { // �������ݿ�����

	public static ResultSet rs;
	public static Connection conn;
	/**
	 * �����ݿ��в��Ҷ�Ӧ������
	 */
	public static final String SELECT_BASIS_CATTLE = "SELECT * FROM basis_cattle";

	public static final String SELECT_MILK_CROP_RECORD = "SELECT * FROM milk_crop_record";

	public static final String SELECT_COPULATION_RECORD1 = "SELECT * FROM copulation_record";

	public static final String SELECT_PRO_PROPERTY = "SELECT * FROM pro_property";

	public static final String SELECT_INSPECTION_RECORD = "SELECT * FROM inspection_record";

	public static final String SELECT_APPEARANCE_RECORD = "SELECT * FROM appearance_record";

	public static final String SELECT_DISEASE_RECORD = "SELECT * FROM disease_record";

	public static final String SELECT_SIZE_WEIGHT = "SELECT * FROM size_weight";

	/**
	 * �������ݿ�
	 */
	public static void connectDB() {
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���
		String url = "jdbc:mysql://192.168.2.24:3306/cattlefarm";
		// MySQL����ʱ���û���
		String user = "hong2";
		// MySQL����ʱ������
		String password = "123456";
		try {
			// ������������
			Class.forName(driver);
			// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	/**
	 * ��ȡ�������ݿ����
	 */
	public static ResultSet queryDB(String sql) {
		try {
			// statement����ִ��SQL���
			Statement statement = conn.createStatement();
			// Ҫִ�е�SQL���
			// �����
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * �������ݿ����
	 */
	public static int updateDB(String sql) {
		int rs = 0;
		try {
			Statement statement = conn.createStatement();
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * �����ݿ��в���ָ��idţ
	 */
	public static String selectData(String tableName, String id) {
		String handleString = "SELECT* FROM " + tableName + " WHERE "
				+ "idOfCattle =" + id;
		return handleString;
	}

	/**
	 * �����ݿ��в�������
	 */
	public static String insertData(String tableName, String[] properties) {
		String handleString = "INSERT��INTO " + tableName + " VALUES " + '(';
		for (int i = 0; i < properties.length; i++) {
			if (i != properties.length - 1) {
				handleString = handleString + properties[i] + ',';
			} else {
				handleString = handleString + properties[i];
			}
		}
		handleString = handleString + ')';
		return handleString;
	}

	/**
	 * �����ݿ��и�������
	 */
	public static String updateData(String tableName, String setString,
			String whereString) {
		String handleString = "UPDATE " + tableName + " SET " + setString
				+ " WHERE ";
		return handleString;
	}

	/**
	 * �����ݿ���ɾ������
	 */
	public static String deleteData(String tableName, String whereString) {
		String handleString = "DELETE FROM " + tableName + " WHERE "
				+ whereString;
		return handleString;
	}
}
