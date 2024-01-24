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

public class GuestMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField titleTextField;

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
		setBounds(100, 100, 414, 330);
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
		nameLabel.setBounds(12, 7, 57, 15);
		guestInsertPanel.add(nameLabel);
		
		JLabel titleLabel = new JLabel("제목");
		titleLabel.setBounds(12, 32, 57, 15);
		guestInsertPanel.add(titleLabel);
		
		JLabel addressLabel = new JLabel("내용");
		addressLabel.setBounds(12, 141, 57, 18);
		guestInsertPanel.add(addressLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(81, 7, 96, 18);
		guestInsertPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(81, 32, 160, 18);
		guestInsertPanel.add(titleTextField);
		titleTextField.setColumns(10);
		
		JButton guestWriteButton = new JButton("방명록쓰기");
		guestWriteButton.setBounds(81, 219, 150, 23);
		guestInsertPanel.add(guestWriteButton);
		
		JScrollPane guestContentScrollPane = new JScrollPane();
		guestContentScrollPane.setBounds(81, 57, 270, 152);
		guestInsertPanel.add(guestContentScrollPane);
		
		JTextArea guestContentTextArea = new JTextArea();
		guestContentScrollPane.setViewportView(guestContentTextArea);
		
		JPanel guestListPanel = new JPanel();
		guestTabbedPane.addTab("방명록리스트", null, guestListPanel, null);
		guestListPanel.setLayout(null);
		
		JButton guestListButton = new JButton("방명록리스트");
		guestListButton.setBounds(116, 201, 150, 23);
		guestListPanel.add(guestListButton);
		
		JScrollPane guestListScrollPane = new JScrollPane();
		guestListScrollPane.setBounds(12, 10, 359, 187);
		guestListPanel.add(guestListScrollPane);
	}
}
