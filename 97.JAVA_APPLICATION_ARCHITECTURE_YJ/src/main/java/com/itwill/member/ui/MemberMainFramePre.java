package com.itwill.member.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MemberMainFramePre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMainFramePre frame = new MemberMainFramePre();
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
	public MemberMainFramePre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 434);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("회원");
		mnNewMenu.setMnemonic('m');
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("로그인");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("회원가입");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("로그아웃");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("종료");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("상품");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel searchNorthPanel = new JPanel();
		contentPane.add(searchNorthPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		searchNorthPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("검색");
		searchNorthPanel.add(btnNewButton_2);
		
		JPanel menuSouthPanel = new JPanel();
		contentPane.add(menuSouthPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Home");
		menuSouthPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("My Info");
		menuSouthPanel.add(btnNewButton_1);
		
		JTabbedPane shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		JPanel shopMainTabPanel = new JPanel();
		shopTabbedPane.addTab("메인", null, shopMainTabPanel, null);
		shopMainTabPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MemberMainFramePre.class.getResource("/images/o_big_dog.png")));
		shopMainTabPanel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel shopMemberTabPanel = new JPanel();
		shopTabbedPane.addTab("회원", null, shopMemberTabPanel, null);
		shopMemberTabPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopMemberTabPanel.add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberLoginPanel = new JPanel();
		memberTabbedPane.addTab("로그인", null, memberLoginPanel, null);
		
		JPanel memberDetailPanel = new JPanel();
		memberTabbedPane.addTab("회원보기", null, memberDetailPanel, null);
		
		JPanel memberJoinPanel = new JPanel();
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		
		JPanel shopProductTabPanel = new JPanel();
		shopTabbedPane.addTab("제품", null, shopProductTabPanel, null);
		shopProductTabPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopProductTabPanel.add(productTabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		productTabbedPane.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		productTabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		productTabbedPane.addTab("New tab", null, panel_2, null);
	}

}
