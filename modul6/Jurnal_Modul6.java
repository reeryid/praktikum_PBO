package modul6;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Jurnal_Modul6 {
	static int n=0;
	private JFrame frmFruitCourt;
	private JTextField tf_nama;
	private JTextField tf_stock;
	
	public static ArrayList<String> nama_buah = new ArrayList<String>();
	public static ArrayList<Integer> jumlah_buah = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jurnal_Modul6 window = new Jurnal_Modul6();
					window.frmFruitCourt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jurnal_Modul6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFruitCourt = new JFrame();
		frmFruitCourt.setTitle("Fruit Court");
		frmFruitCourt.setBounds(100, 100, 600, 300);
		frmFruitCourt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFruitCourt.getContentPane().setLayout(null);
		
		JLabel judul = new JLabel("Fruit Court");
		judul.setFont(new Font("Tahoma", Font.BOLD, 14));
		judul.setBounds(0, 11, 584, 57);
		judul.setHorizontalAlignment(SwingConstants.CENTER);
		frmFruitCourt.getContentPane().add(judul);
		
		JLabel lblNewLabel = new JLabel("Fruit Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(55, 109, 89, 14);
		frmFruitCourt.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fruit Stock :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(55, 157, 121, 14);
		frmFruitCourt.getContentPane().add(lblNewLabel_1);
		
		tf_nama = new JTextField();
		tf_nama.setBounds(143, 102, 360, 30);
		frmFruitCourt.getContentPane().add(tf_nama);
		tf_nama.setColumns(10);
		
		tf_stock = new JTextField();
		tf_stock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char ch_txt=e.getKeyChar();
				if(Character.isLetter(ch_txt)){
					tf_stock.setEditable(false);
				}
				else {
					tf_stock.setEditable(true);
				}
				
			}
		});
		tf_stock.setBounds(143, 150, 360, 30);
		frmFruitCourt.getContentPane().add(tf_stock);
		tf_stock.setColumns(10);
		
		JButton saveBtn = new JButton("SAVE");
		saveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nama_in=tf_nama.getText();
				int stock_in=Integer.parseInt(tf_stock.getText());
				nama_buah.add(nama_in);
				jumlah_buah.add(stock_in);
				tf_nama.setText("");
				tf_stock.setText("");
				JOptionPane.showMessageDialog(frmFruitCourt,
						"Buah Berhasil Ditambahkan ke ArrayList",
						"Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		saveBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		saveBtn.setBounds(143, 205, 90, 30);
		frmFruitCourt.getContentPane().add(saveBtn);
		
		JButton clearBtn = new JButton("RESET");
		clearBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nama_buah.clear();
				jumlah_buah.clear();
				JOptionPane.showMessageDialog(frmFruitCourt,
						"ArrayList berhasil Dibersihkan",
						"Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		clearBtn.setBounds(275, 205, 90, 30);
		frmFruitCourt.getContentPane().add(clearBtn);
		
		JButton viewBtn = new JButton("VIEW");
		viewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				View buka=new View();
				buka.setVisible(true);
			}
		});
		viewBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		viewBtn.setBounds(413, 205, 90, 30);
		frmFruitCourt.getContentPane().add(viewBtn);
		
	}
	
	
}
