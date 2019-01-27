package Tugas_buOffy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.omg.Messaging.SyncScopeHelper;

public class Library extends Perpustakaan implements Menu{
	private String awal_pinjam , akhir_pinjam ; 
	private DateFormat TanggalAwal , TanggalAkhir ; 
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private String ulang = "Y", keluar = "N" , exit = "Y" , Nama ;
	private Peminjaman pj ; 
	private ArrayList<Integer> pesan = new ArrayList<Integer>();
	private ArrayList<Integer> Total_pesan = new ArrayList<Integer>();
	private int Bayar , pilih , nrp ; 
	private Perpustakaan b1 , b2 , b3 , b4 , b5 , b6 , b7 , b8  ;
	private String hasil ;
	private String note , note1 ; 
	
	public Library() {
		b1 = new Perpustakaan( 1 , "Bahasa Indonesia" );
		b2 = new Perpustakaan( 2 , "Matematika");
		b3 = new Perpustakaan( 3 , "IPS" ) ; 
		b4 = new Perpustakaan( 4 , "IPA");
		b5 = new Perpustakaan( 5 , "Sastra" );
		b6 = new Perpustakaan( 6 , "Bahasa Inggris");
		b7 = new Perpustakaan( 7 , "Pendidikan Agama Islam");
		b8 = new Perpustakaan( 8 , "PPKN");

	}
	
	public void Menu_pilihan() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		TanggalAwal = new SimpleDateFormat("dd/MM/yyyy");
		TanggalAkhir = new SimpleDateFormat("dd/MM/yyyy");
		while(true) {
			
		System.out.println("\t================= MENU PERPUSTAKAAN =================");
		System.out.println("\t1. Isi Data");
		System.out.println("\t2. Pinjam Buku ");
		System.out.println("\t3. Pengembalian ");
		System.out.println("\t4. Keluar ");
		System.out.println("\t=====================================================");
		System.out.print(" \tMasukan Pilihan :");
		pilih = Integer.parseInt(input.readLine());
		
		switch(pilih) {
		case 1 :
			System.out.println("\t================= Data Peminjam =====================");
			System.out.println();
			System.out.print(" \tNama Peminjam  = ");
			Nama = input.readLine();
			System.out.print(" \tNRP            = ");
			nrp = Integer.parseInt(input.readLine());
			System.out.println(" \t(dd/MM/yyy)");
			System.out.print(" \tTanggal Pinjam = ");
			awal_pinjam = input.readLine();
			break;
			
		case 2 :
			int i = 1 ;
			do {
				System.out.println("\t================= PINJAMAN BUKU =====================");
				System.out.println(" \tDaftar Buku ");
				System.out.println("");
				System.out.println("\t"+b1.getKode_buku() +". "+b1.getNama_buku() );
				System.out.println("\t"+b2.getKode_buku() +". "+b2.getNama_buku() );
				System.out.println("\t"+b3.getKode_buku() +". "+b3.getNama_buku() );
				System.out.println("\t"+b4.getKode_buku() +". "+b4.getNama_buku() );
				System.out.println("\t"+b5.getKode_buku() +". "+b5.getNama_buku() );
				System.out.println("\t"+b6.getKode_buku() +". "+b6.getNama_buku() );
				System.out.println("\t"+b7.getKode_buku() +". "+b7.getNama_buku() );
				System.out.println("\t"+b8.getKode_buku() +". "+b8.getNama_buku() ); 
				System.out.println("\t======================================================");
				System.out.println("\tPinjaman ke -"+i);
				System.out.println("\t======================================================");
				i++;
				System.out.println();
				System.out.print("\tMasukan pilihan anda :");
				pesan.add(Integer.parseInt(input.readLine()));
				if(pesan.get(pesan.size()-1)> 8 ) {
					System.out.println("\t========================= Warning ========================");
					System.out.println(" \tMaaf Pesanan Anda Tidak Ada!!! Coba Lihat Daftar Menu ~ ");
					System.out.println();
					pesan.remove(pesan.size()-1);
					Menu_pilihan();
					break ; 
				}
				System.out.print("\tMasukan Jumlah Pinjaman Buku : ");
				Total_pesan.add(Integer.parseInt(input.readLine()));
				if(Total_pesan.get(Total_pesan.size()-1) > 3 ) {
					System.out.println("\t========================= Warning ========================");
					System.out.println(" \tMaaf tidak boleh pinjam lebih dari 1 buku ~ ");
					System.out.println();
					pesan.remove(Total_pesan.size()-1);
					Menu_pilihan();
					break ; 
				}
				System.out.print(" \tApakah anda ingin memesan buku lagi [Y/N]?");
				ulang = input.readLine();
			
			}while(ulang.equalsIgnoreCase("Y"));
			break ;
		case 3 : 
			System.out.println("\t======================== Pengembalian Buku =====================");
			System.out.println(" \tData Diri ");
			System.out.println("\t================================================================");
			System.out.println(" \tNama           = "+Nama);
			System.out.println(" \tNrp            = "+nrp);
			System.out.println(" \tTanggal Pinjam = "+awal_pinjam);
			System.out.println();
			System.out.println("\t================================================================");
			System.out.println(" \tDaftar Buku Yang Di Pinjam \t"+awal_pinjam);
			System.out.println("\t================================================================");
			System.out.println();
								Daftar_buku();
			System.out.println("\t================================================================");
			System.out.println(" \tTotal Buku     =\t\t"+Total_pesan());
			System.out.print(" \tTanggal kembali =\t\t");
			
			akhir_pinjam = input.readLine();
			Tanggal();
			if(Integer.parseInt(hasil) < 7 ) {
				System.out.print(" \tTotal Kembali =\t\t");
				Bayar = Integer.parseInt(input.readLine());
				int sisa = Total_pesan() - Bayar ; 
				System.out.println("\t================================================================");
				
				Hitung_KembalianBuku();//Hitung buku
				
				if(Hitung_KembalianBuku()==0) {
					System.out.println();
					System.out.println(" \tNote : Buku yang di pinjam tidak ada yang hilang ");
					System.out.println();
				}
				else if(Hitung_KembalianBuku() < Total_pesan()){
					System.out.println();
					System.out.println(" \tNote : Buku tidak kumplit!! Dapat denda Rp. 15000 /Buku ");
					System.out.println();
					int total = sisa * 15000 ;
					
					System.out.println(" \tDenda = \t\tRp. "+total);
					System.out.println("\t=============================================================");
					System.out.print(" \tBayar Denda = \t\tRp. ");
					int uang = Integer.parseInt(input.readLine());
					if(total == uang) {
						System.out.println("\t\t\t~Lunas");
					}
					else if(total < uang) {
						int total_final = uang - total ; 
						System.out.println("\t=============================================================");
						System.out.println(" \tKembalian = \t\tRp. "+total_final);
						System.out.println("\t\t\t~Lunas");
					}
					else {
						System.out.println();
						System.out.println(" \t\t\t~Uang Tidak Cukup!!!!");
					}
				}
				else {
					System.out.println();
					System.out.println(" \tBuku yang dikembaikan Lebih!! Kembalikan buku sesuai dengan total kembali!!");
				}
	
			}
			else {
				System.out.println("\t====================================================================");
				System.out.println(" \tNOTE!!");
				System.out.println();
				System.out.println(" \tDIkenakan denda karna lebih dari hari yang di tentukan yaitu 7 hari ");
				System.out.println();
				System.out.println(" \tDenda \t\t\t\tRp. 10000 ");
				System.out.print(" \tBayar Denda = \t\t\tRp. ");
				int denda = Integer.parseInt(input.readLine());
				if(denda==10000) {
					
					System.out.println("\t====================================================================");
					System.out.println();
					System.out.println(" \t\t\t\t~Lunas");
				}
				else if(denda > 10000 ) {
					int uang = denda - 10000 ;
					System.out.println("\t====================================================================");
					System.out.println(" \tKembalian = \t\t\tRp. "+uang);
					System.out.println(" \t\t\t\t~Lunas");
				}
				else if(denda < 10000) {
					System.out.println(" \t\t\t\t~Uang Tidak Cukup!!!");
				}
				System.out.println();
				System.out.print(" \tTotal Kembali =\t\t\t");
				Bayar = Integer.parseInt(input.readLine());
				int sisa = Total_pesan() - Bayar ; 
				System.out.println("\t================================================================");
				
				Hitung_KembalianBuku();//Hitung buku
				
				if(Hitung_KembalianBuku()==Total_pesan()) {
					System.out.println();
					System.out.println(" \tNote : Buku yang di pinjam tidak ada yang hilang ");
					System.out.println();
				}
				else if(Hitung_KembalianBuku() > Total_pesan()) {
					System.out.println(" \tNOTE!!!");
					System.out.println();
					System.out.println(" \t Buku tidak kumplit!! Dapat denda Rp. 15000 /Buku ");
					System.out.println();
					int total = sisa * 15000 ;
					
					System.out.println(" \tDenda = \t\t\tRp. "+total);
					System.out.print(" \tBayar Denda = \t\t\tRp. ");
					int uang = Integer.parseInt(input.readLine());
					if(total == uang) {
						System.out.println();
						System.out.println("\t\t\t\t~Lunas");
						System.out.println();
					}
					else if(total < uang) {
						int total_final = uang - total ; 
						System.out.println("\t=============================================================");
						System.out.println(" \tKembalian = \t\t\tRp. "+total_final);
						System.out.println("\t\t\t\t~Lunas");
						System.out.println();
					}
					else {
						System.out.println(" \t\\t\t\t~Uang Tidak Cukup!!!!");
						System.out.println();
					}
				
				}
				else {
					System.out.println();
					System.out.println(" \tBuku yang dikembaikan Lebih!! Kembalikan buku sesuai dengan total kembali!!");
				}
			}
			break;
		case 4 :
			System.exit(0);
			break;
		default :
			System.out.println();
			System.out.println(" \tMaaf Pilihan Tidak Ada!!");
		}//swhitc
	}//while
}//method
	


	
	public void Daftar_buku() {
		// TODO Auto-generated method stub
		if(pesan.isEmpty() == false){
			for(int i = 0; i < pesan.size();i++){
				if(pesan.get(i)==1){
					System.out.println("\t"+(i+1) + ". "+ b1.getNama_buku() +"\t\t"+ Total_pesan.get(i));
				}else if (pesan.get(i)==2){
					System.out.println("\t"+(i+1) + ". "+ b2.getNama_buku() +"\t\t\t\t"+ Total_pesan.get(i));
				}else if (pesan.get(i)==3){
					System.out.println("\t"+(i+1) + ". "+ b3.getNama_buku() +"\t\t\t\t"+ Total_pesan.get(i));
				}else if (pesan.get(i)==4){
					System.out.println("\t"+(i+1) + ". "+ b4.getNama_buku() +"\t\t\t\t"+ Total_pesan.get(i));
				}else if (pesan.get(i)==5){
					System.out.println("\t"+(i+1) + ". "+ b5.getNama_buku() +"\t\t\t"+ Total_pesan.get(i));
				}else if (pesan.get(i)==6){
					System.out.println("\t"+(i+1) + ". "+ b6.getNama_buku() +"\t\t\t"+ Total_pesan.get(i));
				}else if (pesan.get(i)==7){
					System.out.println("\t"+(i+1) + ". "+ b7.getNama_buku() +"\t"+ Total_pesan.get(i));
				}else if (pesan.get(i)==8){
					System.out.println("\t"+(i+1) + ". "+ b8.getNama_buku() +"\t\t\t\t"+ Total_pesan.get(i));
				}	
	
	}
	}
	}
	public void Tanggal() {
		TanggalAkhir = new SimpleDateFormat("dd/MM/yyyy");
		TanggalAwal = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
	            Date tglAwal = TanggalAwal.parse(awal_pinjam);
	            Date tglAkhir = TanggalAkhir.parse(akhir_pinjam);
	             
	            Date baruAwal = tglAwal;
	            Date baruAkhir = tglAkhir;
	            Calendar cal1 = Calendar.getInstance();
	            cal1.setTime(baruAwal);
	            Calendar cal2 = Calendar.getInstance();
	            cal2.setTime(baruAkhir);
	             
	             hasil = String.valueOf(Hitung_tanggal(cal1, cal2));
	             
	            
	             
	        } catch (ParseException e) {
	        }
		
	}
	private static long Hitung_tanggal(Calendar tanggalAwal, Calendar tanggalAkhir) {
        long lama = 0;
        Calendar tanggal = (Calendar) tanggalAwal.clone();
        while (tanggal.before(tanggalAkhir)) {
            tanggal.add(Calendar.DAY_OF_MONTH, 1);
            lama++;
        }
        return lama;
    }
	@Override
	public int Total_pesan() {
		pj = new Peminjaman();
		if(pesan.isEmpty() == false){
			for(int x = 0 ; x < pesan.size() ; x++) {
				if(pesan.get(x)==1) {
					pj.setTotal_pinjam((Total_pesan.get(x)));
				}
				else if(pesan.get(x)==2) {
					pj.setTotal_pinjam((Total_pesan.get(x)));
				}
				else if(pesan.get(x)==3) {
					pj.setTotal_pinjam((Total_pesan.get(x)));
				}
				else if(pesan.get(x)==4) {
					pj.setTotal_pinjam((Total_pesan.get(x)));
				}
				else if(pesan.get(x)==5) {
					pj.setTotal_pinjam((Total_pesan.get(x)));
				}
				else if(pesan.get(x)==6) {
					pj.setTotal_pinjam((Total_pesan.get(x)));
				}
				else if(pesan.get(x)==7) {
					pj.setTotal_pinjam((Total_pesan.get(x)));
				}
				else if(pesan.get(x)==8) {
					pj.setTotal_pinjam((Total_pesan.get(x)));
				}
			}
		}
		return pj.getTotal_pinjam();
		// TODO Auto-generated method stub
		
	}
	public int Hitung_KembalianBuku() {
		return Bayar - Total_pesan();
	}

}
