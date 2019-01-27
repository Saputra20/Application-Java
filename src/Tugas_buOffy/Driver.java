package Tugas_buOffy;

import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Library lb = new Library();
		
		try {
			lb.Menu_pilihan();
		} catch (IOException | NumberFormatException e) {
			System.out.println();
			System.out.println(" \tMaaf input anda salah");
			lb.Menu_pilihan();
		}
	}

}
