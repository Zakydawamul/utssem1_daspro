import java.util.Scanner;
public class ManajemenNilaiSiswa07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalNilai = 0;
        int jumlahSiswa = 0;
        String nama;

        while (true) {
            System.out.print("Masukkan nama siswa (atau ketik 'selesai' untuk mengakhiri): ");
            nama = scanner.nextLine();
            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Masukkan nilai untuk " + nama + ": ");
            double nilai;
            try {
                nilai = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nilai harus berupa angka. Silakan coba lagi.");
                continue;
            }

            totalNilai += nilai;
            jumlahSiswa++;
        }
        if (jumlahSiswa == 0) {
            System.out.println("Tidak ada data siswa yang dimasukkan.");
            return;
        }

        double rataRata = totalNilai / jumlahSiswa;
        int diAtasRataRata = 0;

        System.out.println("\nEvaluasi nilai siswa:");
        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.print("Masukkan nilai siswa ke-" + (i + 1) + ": ");
            double nilai;
            try {
                nilai = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nilai harus berupa angka. Silakan coba lagi.");
                i--; 
                continue;
            }

            if (nilai > rataRata) {
                diAtasRataRata++;
            }
        }

        System.out.printf("\nRata-rata nilai kelas: %.2f%n", rataRata);
        System.out.println("Jumlah siswa yang mendapatkan nilai di atas rata-rata: " + diAtasRataRata);
        System.out.println("Jumlah siswa yang mendapatkan nilai di bawah rata-rata: " + (jumlahSiswa - diAtasRataRata));

        if (diAtasRataRata > jumlahSiswa / 2) {
            System.out.println("Kelas ini memiliki mayoritas siswa dengan nilai di atas rata-rata.");
        } else {
            System.out.println("Kelas ini tidak memiliki mayoritas siswa dengan nilai di atas rata-rata.");
        }

        scanner.close();
    }
}