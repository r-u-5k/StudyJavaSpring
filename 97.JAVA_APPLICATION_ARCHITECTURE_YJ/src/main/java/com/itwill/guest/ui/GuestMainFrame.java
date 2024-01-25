package com.itwill.guest.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

public class GuestMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTable guestListTable;
	private JTextField titleTextField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestMainFrame frame = new GuestMainFrame();
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
	public GuestMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane guestTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(guestTabbedPane, BorderLayout.CENTER);
		
		JPanel guestInsertPanel = new JPanel();
		guestTabbedPane.addTab("방명록쓰기", null, guestInsertPanel, null);
		guestInsertPanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("작성자");
		nameLabel.setBounds(27, 14, 42, 15);
		guestInsertPanel.add(nameLabel);
		
		JLabel addressLabel = new JLabel("내용");
		addressLabel.setBounds(37, 170, 36, 18);
		guestInsertPanel.add(addressLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(82, 12, 96, 18);
		guestInsertPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JButton guestWriteButton = new JButton("방명록쓰기");
		guestWriteButton.setBounds(81, 219, 150, 23);
		guestInsertPanel.add(guestWriteButton);
		
		JScrollPane guestContentScrollPane = new JScrollPane();
		guestContentScrollPane.setBounds(83, 141, 158, 74);
		guestInsertPanel.add(guestContentScrollPane);
		
		JTextPane guestContentTextPane = new JTextPane();
		guestContentScrollPane.setViewportView(guestContentTextPane);
		
		JLabel titleLabel = new JLabel("제목");
		titleLabel.setBounds(37, 43, 32, 15);
		guestInsertPanel.add(titleLabel);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(81, 40, 116, 21);
		guestInsertPanel.add(titleTextField);
		titleTextField.setColumns(10);
		
		JLabel dateLabel = new JLabel("작성일");
		dateLabel.setBounds(27, 81, 42, 15);
		guestInsertPanel.add(dateLabel);
		
		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setBounds(27, 113, 42, 15);
		guestInsertPanel.add(emailLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 78, 116, 21);
		guestInsertPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 110, 116, 21);
		guestInsertPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel guestListPanel = new JPanel();
		guestTabbedPane.addTab("방명록리스트", null, guestListPanel, null);
		guestListPanel.setLayout(null);
		
		JButton guestListButton = new JButton("방명록리스트");
		guestListButton.setBounds(116, 201, 150, 23);
		guestListPanel.add(guestListButton);
		
		JScrollPane guestListScrollPane = new JScrollPane();
		guestListScrollPane.setBounds(12, 10, 626, 187);
		guestListPanel.add(guestListScrollPane);
		
		guestListTable = new JTable();
		guestListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC774\uB984", "\uB0A0\uC9DC", "\uC774\uBA54\uC77C", "\uD648\uD398\uC774\uC9C0", "\uC81C\uBAA9", "\uB0B4\uC6A9"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		guestListTable.getColumnModel().getColumn(6).setPreferredWidth(161);
		guestListScrollPane.setViewportView(guestListTable);
	}
}
