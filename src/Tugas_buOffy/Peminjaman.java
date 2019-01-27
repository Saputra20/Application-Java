package Tugas_buOffy;

public class Peminjaman {
	private int Tanggal_pinjam  ;
	private int Tanggal_kembali ;
	private int Total_pinjam ;
	private int Total_buku ;
	
	public int getTotal_buku() {
		return Total_buku;
	}

	public void setTotal_buku(int total_buku) {
		Total_buku = total_buku;
	}

	public int getTanggal_pinjam() {
		return Tanggal_pinjam ; 
	}
	
	public void setTanggal_pinjam(int Tanggal_pinjam) {
		this.Tanggal_pinjam = Tanggal_pinjam ;
	}
	
	public int getTanggal_kembali() {
		return Tanggal_kembali ; 
	}
	
	public void setTanggal_kembali(int Tanggal_kembali) {
		this.Tanggal_kembali = Tanggal_kembali ; 
	}
	
	public int getTotal_pinjam() {
		return Total_pinjam ; 
	}
	
	public void setTotal_pinjam(int Total_pinjam) {
		this.Total_pinjam = this.Total_pinjam + Total_pinjam; 
	}
	
}
