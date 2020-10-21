package modul1_2;
import java.util.Scanner;

public class Jurnal3_modul12 {
	public static void main(String[] args) {
//		- info saldo
//		- tarik tunai
//		- transfer
//		- pembayaran (pulsa hp, pulsa listrik)
//		- ubah pin
//		- keluar
		Scanner input=new Scanner(System.in);
		int pin=123456;
		
		System.out.print("Masukkan PIN : ");
		int inputPin=input.nextInt();
		int pilih;
		double saldo=700.212;
		
		if(pin==inputPin) {
			do {
			System.out.println("Pilih Menu");	
			System.out.println("1. Info Saldo");
			System.out.println("2. Tarik Tunai");
			System.out.println("3. Transfer");
			System.out.println("4. Pembayaran");
			System.out.println("5. Ubah pin");
			System.out.println("0. Keluar");
			
			System.out.print("Pilih : ");
			pilih=input.nextInt();
			
			if(pilih==1) {
				System.out.println("Saldo anda : "+saldo);
			}
			
			else if(pilih==2) {
				System.out.print("Masukkan Jumlah yang ingin ditarik : ");
				double tarik=input.nextDouble();
				if(saldo>=tarik) {
					System.out.println("Penarikan tunai berhasil");
					saldo-=tarik;
				}
				else {
					System.out.println("Saldo tidak cukup");
				}
			}
			
			else if(pilih==3) {
				System.out.print("Masukkan rekening Tujuan : ");
				String rektujuan=input.nextLine();
				rektujuan=input.nextLine();
				System.out.print("Masukkan Jumlah yang ingin ditransfer : ");
				double tarik=input.nextDouble();
				if(saldo>=tarik) {
					System.out.println("Transfer ke rekening "+rektujuan+" berhasil");
					saldo-=tarik;
				}
				else {
					System.out.println("Saldo tidak cukup");
				}
			}
			else if(pilih==4) {
				System.out.println("Pilih menu Pembayaran");
				System.out.println("1. Pulsa HP");
				System.out.println("2. Pulsa Listrik");
				System.out.print("Pilih : ");
				int pembayaran=input.nextInt();
				
				if(pembayaran==1){
					System.out.print("Masukkan Nomor HP : ");
					String hp=input.nextLine();
					hp=input.nextLine();
					System.out.println("Menu Pulsa");
					System.out.println("1. 25.000");
					System.out.println("2. 50.000");
					System.out.println("3. 100.000");
					System.out.print("Pilih : ");
					int pulsa=input.nextInt();
					if(pulsa==1) {
						if(saldo>=25){
						saldo-=25;
						System.out.println("Pengisian Pulsa Berhasil");
						}
						else {
							System.out.println("Saldo Kurang");
						}
					}
					else if(pulsa==2) {
						if(saldo>=50){
							saldo-=50;
							System.out.println("Pengisian Pulsa Berhasil");
							}
							else {
								System.out.println("Saldo Kurang");
							}
					}
					else if(pulsa==3) {
						if(saldo>=100){
							saldo-=100;
							System.out.println("Pengisian Pulsa Berhasil");
							}
							else {
								System.out.println("Saldo Kurang");
							}
					}
					else {
						System.out.println("Pilihan tidak tersedia");
					}
					
				}
				else if(pembayaran==2){
					System.out.print("Masukkan Nomor Pengguna : ");
					String pengguna=input.nextLine();
					pengguna=input.nextLine();
					System.out.println("Menu Pulsa Listrik");
					System.out.println("1. 25.000");
					System.out.println("2. 50.000");
					System.out.println("3. 100.000");
					System.out.print("Pilih : ");
					int pulsa=input.nextInt();
					if(pulsa==1) {
						if(saldo>=25){
						saldo-=25;
						System.out.print("Kode Pulsa : ");
						System.out.println("X1S2-ASD12-AS21-ZX334");
						}
						else {
							System.out.println("Saldo Kurang");
						}
					}
					else if(pulsa==2) {
						if(saldo>=50){
							saldo-=50;
							System.out.print("Kode Pulsa : ");
							System.out.println("OIM2-YYR2-AS21-QT42");
							}
							else {
								System.out.println("Saldo Kurang");
							}
					}
					else if(pulsa==3) {
						if(saldo>=100){
							saldo-=100;
							System.out.print("Kode Pulsa : ");
							System.out.println("PPO9-RY22-77AS-QT42");
							}
							else {
								System.out.println("Saldo Kurang");
							}
					}
					else {
						System.out.println("Pilihan tidak tersedia");
					}
				}
				
				else {
					System.out.println("Pilihan tidak tersedia");
				}
				
			}
			
			else if(pilih==5) {
				System.out.print("Konfirmasi PIN : ");
				int konfir=input.nextInt();
				if(konfir==pin){
					System.out.print("Masukkan PIN Baru : ");
					pin=input.nextInt();
					System.out.println("PIN Berhasil diganti");
				}
				else {
					System.out.println("PIN Salah");
				}
			}
			
			
			}
			while(pilih!=0);
		}
		
		else {
			System.out.println("PIN salah");
		}
	}
}
