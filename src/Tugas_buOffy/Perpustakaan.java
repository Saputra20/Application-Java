package Tugas_buOffy;

public class Perpustakaan {
	private int Kode_buku ; 
	private String Nama_buku ;
	
	
	public  Perpustakaan() {
		
	}
	public  Perpustakaan(int Kode_buku , String Nama_buku ) {
		this.Kode_buku = Kode_buku ;
		this.Nama_buku = Nama_buku ; 
	}
	public int getKode_buku() {
		return Kode_buku;
	}
	public void setKode_buku(int kode_buku) {
		Kode_buku = kode_buku;
	}
	public String getNama_buku() {
		return Nama_buku;
	}
	public void setNama_buku(String nama_buku) {
		Nama_buku = nama_buku;
	}
	
	
	
	
}
