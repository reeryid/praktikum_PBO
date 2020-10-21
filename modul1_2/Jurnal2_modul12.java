package modul1_2;
import java.util.Scanner;

public class Jurnal2_modul12 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Banyak Data : ");
		int data=input.nextInt();
		
		String profil[] = new String[data];
		
		String test=input.nextLine();
		for(int i=0;i<profil.length;i++) {
			System.out.print("Masukkan data : ");
			String hasil=input.nextLine();
			profil[i]=hasil;
		}
		
		System.out.println("\nData : ");
		for(int i=0;i<profil.length;i++) {
			System.out.println(profil[i]);
		}

	}

}
