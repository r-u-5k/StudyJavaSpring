package com.itwill.address.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddressMainFramePre extends JFrame {
	/*** 1. AddressService 멤버 필드 선언 ***/
	AddressService addressService;
	/****************************************/

	private JPanel contentPane;
	private JTable addressListTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressMainFramePre frame = new AddressMainFramePre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public AddressMainFramePre() {
		setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		setTitle("주소록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel addressInsertPanel = new JPanel();
		addressInsertPanel.setBackground(Color.PINK);
		tabbedPane.addTab("주소록쓰기", null, addressInsertPanel, null);
		addressInsertPanel.setLayout(null);
		
		JButton addressInsertButton = new JButton("주소록쓰기");
		addressInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***************주소록쓰기***************/
				try {
					Address address = Address.builder()
											 .name("김미영")
											 .phone("111-1111")
											 .address("서울중앙지검")
											 .build();
					int insertRowCount = addressService.addressWrite(address);
					if (insertRowCount > 0) {
						int result = JOptionPane.showConfirmDialog(null, "Insert 성공. 메인으로 이동 ㄱ?");
						System.out.println("showConfirmDialog -> " + result);
						return;
					} else {
						JOptionPane.showConfirmDialog(null, "Insert 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				/****************************************/
			}
		});
		addressInsertButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		addressInsertButton.setBounds(156, 187, 97, 23);
		addressInsertPanel.add(addressInsertButton);
		
		JPanel addressListPanel = new JPanel();
		addressListPanel.setBackground(Color.YELLOW);
		addressListPanel.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("주소록리스트", null, addressListPanel, null);
		addressListPanel.setLayout(null);
		
		JButton addressListButton = new JButton("주소록리스트");
		addressListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**************주소록리스트**************/
				try {
					List<Address> addressList = addressService.addressList();
					
					Vector<String> columnVector = new Vector<>();
					columnVector.add("번호");
					columnVector.add("이름");
					columnVector.add("전화번호");
					columnVector.add("주소");
					
					Vector tableVector = new Vector();
					for (Address address : addressList) {
						Vector rowVector = new Vector();
						rowVector.add(address.getNo());
						rowVector.add(address.getName());
						rowVector.add(address.getPhone());
						rowVector.add(address.getAddress());
						tableVector.add(rowVector);
					}

					DefaultTableModel tableModel = new DefaultTableModel(tableVector, columnVector);
					
					addressListTable.setModel(tableModel);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "호갱님 ㅈㅅ ;;");
					e1.printStackTrace();
				}
				/****************************************/
			}
		});
		addressListButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		addressListButton.setBounds(145, 187, 115, 23);
		addressListPanel.add(addressListButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 20, 395, 164);
		addressListPanel.add(scrollPane);
		
		addressListTable = new JTable();
		addressListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		addressListTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		addressListTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		addressListTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(addressListTable);
		
		JPanel addressDetailPanel = new JPanel();
		addressDetailPanel.setBackground(Color.GREEN);
		addressDetailPanel.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("주소록상세보기", null, addressDetailPanel, null);
		addressDetailPanel.setLayout(null);
		
		JButton addressDetailButton = new JButton("주소록상세보기");
		addressDetailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*************주소록상세보기*************/
				try {
					Address address = addressService.addressDetail(4);
					if (address == null) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 주소록임");
					}
					System.out.println("UI >> " + address);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "호갱님 ㅈㅅ ;;");
					e1.printStackTrace();
				}
				/****************************************/
			}
		});
		addressDetailButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		addressDetailButton.setBounds(148, 187, 128, 23);
		addressDetailPanel.add(addressDetailButton);
		
		/*** 2. AddressService 객체 생성 ***/
		try {
			this.addressService = new AddressService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		/***********************************/
		
	} // 생성자 끝
}
