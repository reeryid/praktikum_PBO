package modul6;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View extends JFrame {
	Jurnal_Modul6 mein = new Jurnal_Modul6();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		JLabel lblNama = new JLabel();
		JLabel lblStock = new JLabel();
		setTitle("View Fruit");
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
					if(mein.n < mein.nama_buah.size()-1){
						mein.n++;
			            String viewNama=mein.nama_buah.get(mein.n);
						int vStock=mein.jumlah_buah.get(mein.n);
						String viewStock=Integer.toString(vStock); 
						lblNama.setText(viewNama);
						lblStock.setText(viewStock);
		            	}
					} 
				else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
					if(0 < mein.n) {
						mein.n--;
						String viewNama=mein.nama_buah.get(mein.n);
						int vStock=mein.jumlah_buah.get(mein.n);
						String viewStock=Integer.toString(vStock); 
						lblNama.setText(viewNama);
						lblStock.setText(viewStock);
						}
					}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel judulView = new JLabel("View Fruit");
		judulView.setFont(new Font("Tahoma", Font.BOLD, 16));
		judulView.setHorizontalAlignment(SwingConstants.CENTER);
		judulView.setBounds(0, 33, 434, 14);
		getContentPane().add(judulView);
		
		
		if(mein.nama_buah.size()==0){
			lblNama.setText("Tidak Ada Buah");
		}
		else {
			String viewNama=mein.nama_buah.get(mein.n);
			int vStock=mein.jumlah_buah.get(mein.n);
			String viewStock=Integer.toString(vStock); 
			lblNama.setText(viewNama);
			lblStock.setText(viewStock);
		}
		
		
		lblNama.setHorizontalAlignment(SwingConstants.CENTER);
		lblNama.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNama.setBounds(0, 122, 434, 18);
		getContentPane().add(lblNama);
		
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStock.setBounds(0, 158, 434, 18);
		getContentPane().add(lblStock);
	}

}
