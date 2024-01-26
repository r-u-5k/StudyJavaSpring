package com.itwill.guest.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.address.Address;
import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;

public class GuestMainFrame extends JFrame {
	private GuestService guestService;
	int status = 0;
	private JPanel contentPane;
	private JTextField guestNameTextField;
	private JTable guestListTable;
	private JTextField guestTitleTextField;
	private JTextField guestDateTextField;
	private JTextField guestEmailTextField;
	private JTextField guestHomepageTextField;
	private JTextPane guestContentTextPane;
	private JTabbedPane guestTabbedPane;
	private JTextField searchTextField;

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
		
		guestTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		contentPane.add(guestTabbedPane, BorderLayout.CENTER);
		
		JPanel guestInsertPanel = new JPanel();
		guestTabbedPane.addTab("방명록쓰기", null, guestInsertPanel, null);
		guestInsertPanel.setLayout(null);
		
		JLabel guestNameLabel = new JLabel("작성자");
		guestNameLabel.setBounds(27, 14, 42, 15);
		guestInsertPanel.add(guestNameLabel);
		
		JLabel guestAddressLabel = new JLabel("내용");
		guestAddressLabel.setBounds(37, 170, 36, 18);
		guestInsertPanel.add(guestAddressLabel);
		
		guestNameTextField = new JTextField();
		guestNameTextField.setBounds(81, 12, 96, 18);
		guestInsertPanel.add(guestNameTextField);
		guestNameTextField.setColumns(10);
		
		JButton guestWriteButton = new JButton("방명록쓰기");
		guestWriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = guestNameTextField.getText();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = format.parse(guestDateTextField.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String email = guestEmailTextField.getText();
				String homepage = guestHomepageTextField.getText();
				String title = guestTitleTextField.getText();
				String content = guestContentTextPane.getText();
				Guest guest = Guest.builder().guestContent(content)
											 .guestDate(date)
											 .guestEmail(email)
											 .guestHomepage(homepage)
											 .guestName(name)
											 .guestTitle(title)
											 .build();
				try {
					int rowCount = guestService.guestWrite(guest);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				guestNameTextField.setText("");
				guestHomepageTextField.setText("");
				guestEmailTextField.setText("");
				guestTitleTextField.setText("");
				guestContentTextPane.setText("");
				
				guestTabbedPane.setSelectedIndex(0);
			}
		});
		guestWriteButton.setBounds(81, 219, 150, 23);
		guestInsertPanel.add(guestWriteButton);
		
		JScrollPane guestContentScrollPane = new JScrollPane();
		guestContentScrollPane.setBounds(81, 155, 150, 60);
		guestInsertPanel.add(guestContentScrollPane);
		
		guestContentTextPane = new JTextPane();
		guestContentScrollPane.setViewportView(guestContentTextPane);
		
		JLabel guestTitleLabel = new JLabel("제목");
		guestTitleLabel.setBounds(37, 39, 32, 15);
		guestInsertPanel.add(guestTitleLabel);
		
		guestTitleTextField = new JTextField();
		guestTitleTextField.setBounds(81, 40, 116, 17);
		guestInsertPanel.add(guestTitleTextField);
		guestTitleTextField.setColumns(10);
		
		JLabel guestDateLabel = new JLabel("작성일");
		guestDateLabel.setBounds(27, 74, 42, 15);
		guestInsertPanel.add(guestDateLabel);
		
		JLabel guestEmailLabel = new JLabel("이메일");
		guestEmailLabel.setBounds(27, 99, 42, 15);
		guestInsertPanel.add(guestEmailLabel);

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		guestDateTextField = new JTextField(formatter.format(date));
		guestDateTextField.setEnabled(false);
		guestDateTextField.setBounds(81, 67, 116, 21);
		guestInsertPanel.add(guestDateTextField);
		guestDateTextField.setColumns(10);
		
		guestEmailTextField = new JTextField();
		guestEmailTextField.setBounds(82, 96, 116, 21);
		guestInsertPanel.add(guestEmailTextField);
		guestEmailTextField.setColumns(10);
		
		JLabel guestHomepageLabel = new JLabel("홈페이지");
		guestHomepageLabel.setBounds(27, 130, 57, 15);
		guestInsertPanel.add(guestHomepageLabel);
		
		guestHomepageTextField = new JTextField();
		guestHomepageTextField.setBounds(81, 124, 116, 21);
		guestInsertPanel.add(guestHomepageTextField);
		guestHomepageTextField.setColumns(10);
		
		JPanel guestListPanel = new JPanel();
		guestTabbedPane.addTab("방명록리스트", null, guestListPanel, null);
		guestListPanel.setLayout(null);
		
		JButton guestListButton = new JButton("방명록리스트");
		
		
		guestListButton.setBounds(117, 219, 150, 23);
		guestListPanel.add(guestListButton);
		
		JScrollPane guestListScrollPane = new JScrollPane();
		guestListScrollPane.setBounds(12, 27, 626, 187);
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
		
		JComboBox searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"전체", "이름", "제목", "내용"}));
		searchComboBox.setBounds(386, 3, 51, 23);
		guestListPanel.add(searchComboBox);
		
		guestTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (guestTabbedPane.getSelectedIndex() == 0 && status != 0)
					try {
						int selectedIndex = searchComboBox.getSelectedIndex();
						String searchString = searchTextField.getText();
						displayGuestList(selectedIndex, searchString);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		guestListButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedIndex = searchComboBox.getSelectedIndex();
					String searchString = searchTextField.getText();
					displayGuestList(selectedIndex, searchString);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		searchTextField = new JTextField();
		searchTextField.setBounds(441, 4, 161, 21);
		guestListPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton searchButton = new JButton("");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedIndex = searchComboBox.getSelectedIndex();
				String searchString = searchTextField.getText();
				displayGuestList(selectedIndex, searchString);
			}
		});
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setBorder(null);
		searchButton.setBackground(Color.WHITE);
		searchButton.setOpaque(false);
		searchButton.setIcon(new ImageIcon(GuestMainFrame.class.getResource("/images/search_image20.png")));
		searchButton.setBounds(604, 3, 34, 23);
		guestListPanel.add(searchButton);
		
		guestTabbedPane.setSelectedIndex(1);
		
		try {
			status = 1;
			guestService = new GuestService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}//생성자끝
	
	private void displayGuestList(int searchType, String searchString) {
		List<Guest> guestList;
		try {
			guestList = guestService.findByGuest(searchType, searchString);
			Vector<String> columnVector = new Vector<>();
			columnVector.add("번호");
			columnVector.add("이름");
			columnVector.add("작성일");
			columnVector.add("이메일");
			columnVector.add("홈페이지");
			columnVector.add("제목");
			columnVector.add("내용");
			
			Vector tableVector = new Vector();
			for (Guest guest : guestList) {
				Vector rowVector = new Vector();
				rowVector.add(guest.getGuestNo());
				rowVector.add(guest.getGuestName());
				rowVector.add(guest.getGuestDate());
				rowVector.add(guest.getGuestEmail());
				rowVector.add(guest.getGuestHomepage());
				rowVector.add(guest.getGuestTitle());
				rowVector.add(guest.getGuestContent());
				tableVector.add(rowVector);
			}
			DefaultTableModel tableModel = new DefaultTableModel(tableVector, columnVector);
			guestListTable.setModel(tableModel);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "리스트가 없습니다.");
		}
		
	}
	
}
