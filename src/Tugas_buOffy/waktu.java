package Tugas_buOffy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class waktu {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String Tanggal_awal ; 
		String Tanggal_akhir ; 
		DateFormat TanggalAwal = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat TanggalAkhir = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("masukan Tanggal Pinjam = ");
        Tanggal_awal = input.nextLine();
        System.out.print("masukan Tanggal kembali = ");
        Tanggal_akhir = input.nextLine();
        
        
        try {
            Date tglAwal = TanggalAwal.parse(Tanggal_awal);
            Date tglAkhir = TanggalAkhir.parse(Tanggal_akhir);
             
            Date baruAwal = tglAwal;
            Date baruAkhir = tglAkhir;
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(baruAwal);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(baruAkhir);
             
            String hasil = String.valueOf(hitung_tanggal(cal1, cal2));
             
            System.out.println("Tanggal Awal  = " +Tanggal_awal);
            System.out.println("Tanggal Akhir = " +Tanggal_akhir);
            System.out.println("Selisih: " +hasil+ " hari");
             
        } catch (ParseException e) {
        }
        
	}
	private static long hitung_tanggal(Calendar tanggalAwal, Calendar tanggalAkhir) {
        long lama = 0;
        Calendar tanggal = (Calendar) tanggalAwal.clone();
        while (tanggal.before(tanggalAkhir)) {
            tanggal.add(Calendar.DAY_OF_MONTH, 1);
            lama++;
        }
        return lama;
    }
}
