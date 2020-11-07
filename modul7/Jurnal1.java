package modul7;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Jurnal1 extends Thread{
	
	static final String URL = "jdbc:mysql://localhost/pombensin";
	static final String USER = "root";
	static final String PASS = "";

	static Connection conn;
	static Statement stmt;
	static ResultSet rs;

	JButton btnReset,btnStop,btnIsi;
	
	private JFrame frmPomBensin;
	private JTextField beli_field;
	private JTextField liter_field;
	private JTextField bayar_field;
	private JTable table;
	private JTable table_1;

	int beli_isi=0;
	
	int bayar_isi=0;
	float liter_isi=0;
	
	/**
	 * Launch the application.
	 */
	
	class MyThread extends Thread {
	      @Override
	      public void run() {
	    	  try {
		    	  if(beli_isi==0){
			  		for(;;){
					  		Thread.sleep(100);
					  		bayar_isi+=100;
					  		liter_isi+=0.01;
					  		String inc_liter=String.format("%.02f", liter_isi);
					  		
					  		liter_field.setText(inc_liter);
					  		bayar_field.setText(String.valueOf(bayar_isi));
				  		} 
		    	  }
		    	  else {
		    		  while(bayar_isi<beli_isi) {
		    			  	Thread.sleep(100);
					  		bayar_isi+=100;
					  		liter_isi+=0.01;
					  		String inc_liter=String.format("%.02f", liter_isi);
					  		
					  		liter_field.setText(inc_liter);
					  		bayar_field.setText(String.valueOf(bayar_isi));
		    			  	}
		    		  
		    	  }
		  	}
	    	  
	    	 catch (InterruptedException e) {
		  			e.printStackTrace();
		  		}
	    	}
	  	}
	   
	
	
	public static void main(String[] args) {
		Jurnal1 window = new Jurnal1();
		window.frmPomBensin.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public Jurnal1() {
		try {
	    	 //Panggil JDBC Driver - Eclipse
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	         // buat koneksi ke database
	         conn = DriverManager.getConnection(URL, USER, PASS);}
		catch(Exception e) {
			e.printStackTrace();
		}

		MyThread thread=new MyThread();
		
		frmPomBensin = new JFrame();
		frmPomBensin.setResizable(false);
		frmPomBensin.setTitle("Pertamina Budget");
		frmPomBensin.setBounds(100, 100, 500, 450);
		frmPomBensin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPomBensin.getContentPane().setLayout(null);
		
		beli_field = new JTextField();
		beli_field.setText("0");
		beli_field.setBounds(200, 40, 150, 30);
		frmPomBensin.getContentPane().add(beli_field);
		beli_field.setColumns(10);
		
		liter_field = new JTextField();
		liter_field.setText("0.00");
		liter_field.setColumns(10);
		liter_field.setBounds(200, 80, 150, 30);
		frmPomBensin.getContentPane().add(liter_field);
		
		bayar_field = new JTextField();
		bayar_field.setText("0");
		bayar_field.setColumns(10);
		bayar_field.setBounds(200, 121, 150, 30);
		frmPomBensin.getContentPane().add(bayar_field);
		
		JLabel beli_lbl = new JLabel("Beli (Rp)");
		beli_lbl.setFont(new Font("Arial", Font.BOLD, 14));
		beli_lbl.setBounds(80, 43, 90, 15);
		frmPomBensin.getContentPane().add(beli_lbl);
		
		JLabel liter_lbl = new JLabel("Liter");
		liter_lbl.setFont(new Font("Arial", Font.BOLD, 14));
		liter_lbl.setBounds(80, 88, 90, 15);
		frmPomBensin.getContentPane().add(liter_lbl);
		
		JLabel bayar_lbl = new JLabel("Bayar (Rp)");
		bayar_lbl.setFont(new Font("Arial", Font.BOLD, 14));
		bayar_lbl.setBounds(80, 129, 90, 15);
		frmPomBensin.getContentPane().add(bayar_lbl);
		
		btnIsi = new JButton("ISI");
		btnIsi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				beli_isi=Integer.parseInt(beli_field.getText());

				
		               if (!thread.isAlive()) {
		                  thread.start();
		               }
		               else{
		                  thread.resume();
		               }
		           
			}
		});
		btnIsi.setBounds(81, 180, 89, 23);
		frmPomBensin.getContentPane().add(btnIsi);
		
		btnStop = new JButton("STOP");
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thread.suspend();
				System.out.println(thread.isAlive());
			}
		});
		btnStop.setBounds(180, 180, 89, 23);
		frmPomBensin.getContentPane().add(btnStop);
		
		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
					liter_field.setText("0.00");
		        	bayar_field.setText("0");
		        	beli_field.setText("0");
		        	beli_isi=0;
		        	bayar_isi=0;
		        	liter_isi=0;
			}
		});
		btnReset.setBounds(279, 180, 89, 23);
		frmPomBensin.getContentPane().add(btnReset);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insert_into(bayar_isi,liter_isi);
				show_table();
			}
		});
		btnLoad.setBounds(180, 214, 89, 23);
		frmPomBensin.getContentPane().add(btnLoad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 250, 370, 134);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		frmPomBensin.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	
	private void insert_into(int bayar,float liter){
		try {
        PreparedStatement pStmt = conn.prepareStatement("insert into history(beli, liter) VALUES (?,?)");
        pStmt.setInt(1, bayar);
        pStmt.setFloat(2, liter);
        int sukses = pStmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void show_table() {
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Bayar");
		model.addColumn("Liter");
		try {
			String select_history = "SELECT *FROM HISTORY";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_history);
			while(rs.next()){
				model.addRow(new Object[] {
					rs.getInt("beli"),
					rs.getFloat("liter")
				});
			}
			rs.close();
			stmt.close();
			
			table_1.setModel(model);
			table_1.setAutoResizeMode(0);
			table_1.getColumnModel().getColumn(0).setPreferredWidth(185);
			table_1.getColumnModel().getColumn(1).setPreferredWidth(185);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
