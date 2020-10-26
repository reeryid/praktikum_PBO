package modul5;
import java.util.Random;
abstract class Divisi{
	public static final String divisi="Spermatophyta";
	String subdivisi,kelas;
	int kelopak;
	public void taksonomi(){
		System.out.println("INFORMASI TAKSONOMI ========================================");
		System.out.println("Divisi\t\t: "+divisi);
		System.out.println("Subdivisi\t: "+subdivisi);
		System.out.println("Kelas\t\t: "+kelas);
	}
	public String getSumber(){return "Fotosintesis";}
	public String getSel(){return "Multiseluler";}
	public String getTubuh(){return "Makroskopis";}
}

interface Angiospermae extends Monocotyledoneae,Dicotyledoneae{}
interface Gymnospermae extends Cycadinae,Coniferae,Ginkgoinae,Gnetinae{}

interface Monocotyledoneae {}
interface Dicotyledoneae{}
interface Cycadinae{}
interface Coniferae{}
interface Ginkgoinae{}
interface Gnetinae{}

class Subdivisi extends Divisi implements Angiospermae,Gymnospermae{
	Random random=new Random();
	final int MAX_KELIPATAN_KONSTAN=3;//
	int monokotil=2;
	int[] listDiko= {2,4,5};
	int dikotil=listDiko[random.nextInt(3)];
	
	public String descSubdivisi(Angiospermae tipe){
		return "INFORMASI REPRODUKSI =======================================\n"
				+ "Biji \t\t: Tertutup\n"
				+ "Alat Reproduksi : Bunga\n"
				+ "Kelopak Bunga\t: "+this.kelopak+
				"\nPembuahan \t: Ganda";
	}
	public String descSubdivisi(Gymnospermae tipe){
		return "INFORMASI REPRODUKSI =======================================\n"
				+"Biji \t\t: Terbuka\n"
				+"Alat Reproduksi : Strobilus\n"
				+"Ovarium \t: Tidak Punya\n"
				+"Pembuahan \t: Tunggal";
	}
	

}
//diJurnal diberi tahu bahwa Kelas jenis tumbuhan tidak memiliki properti jadi saya ambil kesimpulan kelas jenis sebagai interface, 
//dan jenis klasifikasi subdivisi tidak disertakan didalam class Subdivisi jadi saya mengambil kesimpulan untuk mempermudah klasifikasi subdivisi menggunakan interface
//dikarenakan jurnal yang tidak membolehkan/menggunakan statement looping dan statement control

class tumbuhan extends Subdivisi{ //seharusnya namanya "Kelas" tetapi dicontoh namanya "tumbuhan", jadi mengikuti contoh agar mudah dimengerti
	String nama,tanggal;
	String batang,kambium,akar,tulang,descFoto;
	String sel="Multiseluler";
	String deskripsiSub;
	
	tumbuhan(String nama,String tanggal, Monocotyledoneae mono){
		this.nama=nama;
		this.tanggal=tanggal;
		this.subdivisi="Angiospermae";
		this.kelas="Monocotyledoneae";
		this.kelopak=random.nextInt((this.MAX_KELIPATAN_KONSTAN+1))*this.monokotil;
		
		Angiospermae jenis=new Subdivisi();
		this.deskripsiSub=descSubdivisi(jenis);

		this.kambium="Tidak Punya";
		this.batang="Tidak Bercabang";
		this.tulang="Sejajar";
		this.akar="Serabut";
		this.descFoto=
				"dilakukan di daun. Lalu, hasilnya\r\n" + 
				"dikirim ke seluruh bagian melalui\r\n" + 
				"pembuluh xylem. Xylem berada di sisi\r\n" + 
				"dalam dan floem berada di arah sisi\r\n" + 
				"luar. Penempatan pembuluh bersifat acak\r\n" + 
				"tersebar pada batang. Ikatan pembuluh\r\n" + 
				"memiliki ukuran verariasi dan tidak\r\n" + 
				"beraturan, ada yang besar dan kecil.\r\n" + 
				"Fotosintesis lebih efisien dilakukan\r\n" + 
				"pada intensitas cahaya rendah";
	}
	
	tumbuhan(String nama,String tanggal, Dicotyledoneae dico){
		this.nama=nama;
		this.tanggal=tanggal;
		this.subdivisi="Angiospermae";
		this.kelas="Dicotyledoneae";
		this.kelopak=random.nextInt((this.MAX_KELIPATAN_KONSTAN+1))*this.dikotil;
		
		Angiospermae jenis=new Subdivisi();
		this.deskripsiSub=descSubdivisi(jenis);
		
		this.kambium="Punya";
		this.batang="Bercabang";
		this.tulang="Menyirip atau Menjari";
		this.akar="Tunggang";
		this.descFoto=
				"dilakukan di daun. Lalu, hasilnya\r\n" + 
				"dikirim ke seluruh bagian melalui\r\n" + 
				"pembuluh xylem. Xylem berada di sisi\r\n" + 
				"luar dan floem berada di arah sisi\r\n" + 
				"dalam. Penempatan pembuluh bersifat\r\n" + 
				"teratur membentuk lingkaran di dalam\r\n" + 
				"batang tanaman. Ikatan pembuluh\r\n" + 
				"memiliki ukuran yang beraturan.\r\n" + 
				"Fotosintesis lebih efisien dilakukan\r\n" + 
				"pada intensitas cahaya rendah";
	}
	
	tumbuhan(String nama,String tanggal, Cycadinae cyca){
		this.nama=nama;
		this.tanggal=tanggal;
		this.subdivisi="Gymnospermae";
		this.kelas="Cycadinae";
		
		Gymnospermae jenis=new Subdivisi();
		this.deskripsiSub=descSubdivisi(jenis);
		
		this.kambium="Punya";
		this.batang="Tidak Bercabang";
		this.tulang="Menyirip";
		this.akar="Tunggang";
		this.descFoto= 
				"dilakukan di daun. Lalu, hasilnya\r\n" + 
				"dikirim ke seluruh bagian melalui\r\n" + 
				"pembuluh xylem. Xylem hanya terfiri\r\n" + 
				"atas trakeid saja. Xylem berada di sisi\r\n" + 
				"dalam dan floem di arah sisi luar. Di\r\n" + 
				"antara xylem dan phloem, terdapat\r\n" + 
				"kambium. Fotosintesis lebih efisien\r\n" + 
				"dilakukan pada intensitas cahaya Tinggi";
	}
	
	tumbuhan(String nama,String tanggal, Coniferae coni){
		this.nama=nama;
		this.tanggal=tanggal;
		this.subdivisi="Gymnospermae";
		this.kelas="Coniferae";
		
		Gymnospermae jenis=new Subdivisi();
		this.deskripsiSub=descSubdivisi(jenis);
		
		this.kambium="Punya";
		this.batang="Tidak Bercabang";
		this.tulang="Meruncing";
		this.akar="Tunggang";
		this.descFoto=
				"dilakukan di daun. Lalu, hasilnya\r\n" + 
				"dikirim ke seluruh bagian melalui\r\n" + 
				"pembuluh xylem. Xylem hanya terfiri\r\n" + 
				"atas trakeid saja. Xylem berada di sisi\r\n" + 
				"dalam dan floem di arah sisi luar. Di\r\n" + 
				"antara xylem dan phloem, terdapat\r\n" + 
				"kambium. Fotosintesis lebih efisien\r\n" + 
				"dilakukan pada intensitas cahaya Tinggi";
	}
	
	tumbuhan(String nama,String tanggal, Ginkgoinae gink){
		this.nama=nama;
		this.tanggal=tanggal;
		this.subdivisi="Gymnospermae";
		this.kelas="Ginkgoinae";
		
		Gymnospermae jenis=new Subdivisi();
		this.deskripsiSub=descSubdivisi(jenis);
		
		this.kambium="Punya";
		this.batang="Bercabang";
		this.tulang="Meruncing";
		this.akar="Tunggang";
		this.descFoto=
				"dilakukan di daun. Lalu, hasilnya\r\n" + 
				"dikirim ke seluruh bagian melalui\r\n" + 
				"pembuluh xylem. Xylem hanya terfiri\r\n" + 
				"atas trakeid saja. Xylem berada di sisi\r\n" + 
				"dalam dan floem di arah sisi luar. Di\r\n" + 
				"antara xylem dan phloem, terdapat\r\n" + 
				"kambium. Fotosintesis lebih efisien\r\n" + 
				"dilakukan pada intensitas cahaya Tinggi";
	}
	
	tumbuhan(String nama,String tanggal, Gnetinae gnet){
		this.nama=nama;
		this.tanggal=tanggal;
		this.subdivisi="Gymnospermae";
		this.kelas="Gnetinae";
		
		Gymnospermae jenis=new Subdivisi();
		this.deskripsiSub=descSubdivisi(jenis);
		
		this.kambium="Punya";
		this.batang="Bercabang";
		this.tulang="Menyirip";
		this.akar="Tunggang";
		this.descFoto= 
				"dilakukan di daun. Lalu, hasilnya\r\n" + 
				"dikirim ke seluruh bagian melalui\r\n" + 
				"pembuluh xylem. Xylem hanya terfiri\r\n" + 
				"atas trakeid saja. Xylem berada di sisi\r\n" + 
				"dalam dan floem di arah sisi luar. Di\r\n" + 
				"antara xylem dan phloem, terdapat\r\n" + 
				"kambium. Fotosintesis lebih efisien\r\n" + 
				"dilakukan pada intensitas cahaya Tinggi";
	}
	
	
	public void informasi_umum(){//informasi umum tumbuhan
		System.out.println("INFORMASI UMUM =============================================");
		System.out.println("Tumbuhan "+nama+" ditemukan pada "+tanggal);
	}
	public void informasi_taksonomi(){
		super.taksonomi();
	}
	public void informasi_sel(){ //informasi mengenai sel
		System.out.println("INFORMASI SEL ==============================================");
		System.out.println("Jumlah sel\t: "+getSel());
	}
	public void informasi_bentuk(){//informasi bentuk tumbuhan bedasarkan kelas
		System.out.println("INFORMASI BENTUK ===========================================");
		System.out.println("Bentuk tubuh\t: "+getTubuh());
		System.out.println("Batang\t\t: "+this.batang);
		System.out.println("Kambium\t\t: "+this.kambium);
		System.out.println("Tulang Daun\t: "+this.tulang);
		System.out.println("Akar\t\t: "+this.akar);
	}
	public void informasi_reproduksi(){
		System.out.println(this.deskripsiSub);
	}
	public void informasi_sumber_energi(){//informasi mengenai sumber energi
		System.out.println("INFORMASI SUMBER ENERGI ====================================");
		System.out.println("Sumber Makanan : "+getSumber());
		System.out.println(this.descFoto+"\n");
	}
}

public class Jurnal1 {

	public static void main(String[] args) {
		Monocotyledoneae mono = new Subdivisi();
		Dicotyledoneae dico = new Subdivisi();
		Cycadinae cyca = new Subdivisi();
		Coniferae coni = new Subdivisi();
		Ginkgoinae gink = new Subdivisi();
		Gnetinae gnet = new Subdivisi();
		
		tumbuhan exMono = new tumbuhan("EX-MONO","01-01-2001",mono); //input hanya boleh 6 kali 
		tumbuhan exDico = new tumbuhan("EX-DICO","02-02-2002",dico);
		tumbuhan exCyca = new tumbuhan("EX-CYCA","03-03-2003",cyca);
		tumbuhan exConi = new tumbuhan("EX-CONI","04-04-2004",coni);
		tumbuhan exGink = new tumbuhan("EX-GINK","05-05-2005",gink);
		tumbuhan exGnet = new tumbuhan("EX-GNET","06-06-2006",gnet);
		
		exMono.informasi_umum();
		exMono.informasi_taksonomi();
		exMono.informasi_sel();
		exMono.informasi_bentuk();
		exMono.informasi_reproduksi();
		exMono.informasi_sumber_energi();
		
		exDico.informasi_umum();
		exDico.informasi_taksonomi();
		exDico.informasi_sel();
		exDico.informasi_bentuk();
		exDico.informasi_reproduksi();
		exDico.informasi_sumber_energi();
		
		exCyca.informasi_umum();
		exCyca.informasi_taksonomi();
		exCyca.informasi_sel();
		exCyca.informasi_bentuk();
		exCyca.informasi_reproduksi();
		exCyca.informasi_sumber_energi();
		
		exConi.informasi_umum();
		exConi.informasi_taksonomi();
		exConi.informasi_sel();
		exConi.informasi_bentuk();
		exConi.informasi_reproduksi();
		exConi.informasi_sumber_energi();
		
		exGink.informasi_umum();
		exGink.informasi_taksonomi();
		exGink.informasi_sel();
		exGink.informasi_bentuk();
		exGink.informasi_reproduksi();
		exGink.informasi_sumber_energi();
	
		exGnet.informasi_umum();
		exGnet.informasi_taksonomi();
		exGnet.informasi_sel();
		exGnet.informasi_bentuk();
		exGnet.informasi_reproduksi();
		exGnet.informasi_sumber_energi();
	}
}
