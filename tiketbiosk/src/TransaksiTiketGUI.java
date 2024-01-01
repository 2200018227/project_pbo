import javax.swing.*;

class Film {
    private String judul;
    private int harga;

    public Film(String judul, int harga) {
        this.judul = judul;
        this.harga = harga;
    }

    public String getJudul() {
        return judul;
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return judul;
    }
}

class Bioskop {
    private Film[] daftarFilm;

    public Bioskop(Film[] daftarFilm) {
        this.daftarFilm = daftarFilm;
    }

    public Film[] getDaftarFilm() {
        return daftarFilm;
    }
}

class TransaksiTiket {
    private Bioskop bioskop;
    private int jumlahTiket;

    public TransaksiTiket(Bioskop bioskop, int jumlahTiket) {
        this.bioskop = bioskop;
        this.jumlahTiket = jumlahTiket;
    }

    public int hitungTotalHarga() {
        Film[] daftarFilm = bioskop.getDaftarFilm();
        int totalHarga = 0;

        for (Film film : daftarFilm) {
            totalHarga += film.getHarga() * jumlahTiket;
        }

        return totalHarga;
    }
}

public class TransaksiTiketGUI {
    public static void main(String[] args) {
        // Inisialisasi beberapa film
        Film film1 = new Film("Avengers: Endgame", 50000);
        Film film2 = new Film("Spider-Man: No Way Home", 45000);
        Film film3 = new Film("Joker", 40000);
        Film film4 = new Film("Aquaman And the Lost Kingdom", 20000);
        Film film5 = new Film("Batman Begins ", 25000);
        Film film6 = new Film("Captain america ", 35000);
        Film film7 = new Film("Flash ", 55000);
        Film film8 = new Film("Iron Man ", 25000);

        // Inisialisasi bioskop dengan daftar film
        Film[] daftarFilm = {film1, film2, film3, film4, film5, film6, film7, film8};
        Bioskop bioskop = new Bioskop(daftarFilm);

        // Meminta pengguna memilih film
        Film selectedFilm = (Film) JOptionPane.showInputDialog(
                null,
                "Pilih film:",
                "Transaksi Tiket Bioskop",
                JOptionPane.PLAIN_MESSAGE,
                null,
                daftarFilm,
                daftarFilm[0]
        );

        // Meminta pengguna memasukkan jumlah tiket
        String jumlahTiketStr = JOptionPane.showInputDialog(null, "Masukkan jumlah tiket:", "Transaksi Tiket Bioskop", JOptionPane.PLAIN_MESSAGE);
        int jumlahTiket = Integer.parseInt(jumlahTiketStr);

        // Melakukan transaksi
        TransaksiTiket transaksi = new TransaksiTiket(bioskop, jumlahTiket);
        int totalHarga = transaksi.hitungTotalHarga();

        // Menampilkan hasil transaksi
        JOptionPane.showMessageDialog(
                null,
                "Detail Transaksi:\n" +
                        "Film: " + selectedFilm.getJudul() + "\n" +
                        "Jumlah Tiket: " + jumlahTiket + "\n" +
                        "Total Harga: " + totalHarga,
                "Transaksi Selesai",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
