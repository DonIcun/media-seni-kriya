package android.emot.com.mediasenikriya;

/**
 * Created by Windows 8.1 on 12/04/2019.
 */

public class SoalPilgan {

    //arr soal
    public String setSoal[] = {
/*1*/            "Produk yang terbuat dari bahan anorganik non-logam yang telah mengalami proses panas yang tinggi dan bahan jadinya mempunyai struktur campuran disebut . . .",
/*2*/            "Berikut urutan tahap pembuatan keramik yang benar adalah . . .",
/*3*/            "Tahap pembuatan keramik yang memiiki tujuan utama untuk menghilangkan air plastis yang terikat pada badan keramik adalah . . .",
/*4*/            "Secara umum terdapat beberapa teknik dalam pembuatan keramik. Dibawah ini yang bukan teknik pembuatan keramik adalah . . .",
/*5*/            "Jenis tanah liat yang digunakan dalam pembuatan keramik ada dua, yaitu  tanah liat primer dan tanah liat sekunder. Jenis tanah liat yang dihasilkan lewat pelapukan batu feldspatik oleh tenaga endogen yang tidak berpindah dari batuan induk adalah jenis tanah liat . . .",
/*6*/            "• Kurang murni\n" +
            "• Cenderung berbutir halus\n" +
            "• Elastis\n" +
            "• Berwarna krem/ abu-abu/ coklat/ merah jambu/ kuning, kuning muda, kuning kecoklatan, kuning kemerahan, kuning kehitaman\n" +
            "• Suhu bakar 1200ºC - 1300ºC, ada yang sampai suhu bakar 1400ºC (fireclay, stoneware, ballclay)\n" +
            "• Suhu bakar rendah 900ºC - 1180ºC, ada yang sampai 1200ºC (earthnware)\n" +
            "Ciri-ciri diatas merupakan jenis tanah liat . . .",
/*7*/            "Salah satu sifat dari dari tanah liat adalah plastis, Sifat plastis ini mempunyai fungsi sebagai . . .",
/*8*/            "Susut kering dan bakar yang baik pada saat pembakaran kermaik sekitar . . . ",
/*9*/            "1.Silica\n"+"2.Stoneware\n"+"3.Fireclay\n"+"4.Alumunim\n"+"5.Ballclay\n"+"6.Kwarsa\n"+"Bahan Bahan diatas yang merupakan bahan tanah liat yang bersifat tidak plastis adalah . . . ",
/*10*/            "Gambar diatas merupakan Keramik dengan teknik pengerjaan . . .",
/*11*/            "Gambar diatas merupakan Keramik dengan teknik pengerjaan . . .",
/*12*/            "Gambar diatas merupakan Keramik dengan teknik pengerjaan . . .",
/*13*/            "Alat bantu yang digunankan untuk memotong tanah liat dan membentuk detail dalam membuat tanah liat menggunakan . . . ",
/*14*/            "Nama gambar peralatan diatas adalah . . .",
/*15*/            "Gambar peralatan diatas memiliki fungsi . . ."
    };

    public int setImage[] = {
            0,0,0,0,0,
            0,0,0,0,R.drawable.soal10,
            R.drawable.soal11,R.drawable.soal12,0,R.drawable.soal14,R.drawable.soal15
    };

    //arr kunci
    public String pilihanJawaban[][] = {
            {"Marmer","Serat","Keramik","Semen","Kulit"},
            {"Pengolahan bahan, pengglasiran, pembentukan, pembakaran, pengeringan","Pengolahan bahan, pembentukan, pembakaran, pengeringan, pengglasiran","Pengolahan, pembentukan, pengeringan, pembakaran, pengglasiran","Pengglasiran, pengolahan bahan, pembentukan, pembakaran, pengeringan","Pengglasiran, pengolahan bahan, pembakaran, pembentukan, pengeringan"},
            {"Pembentukan","Pengolahan bahan","Pembakaran","Penglasiran","Pengeringan"},
            {"Teknik Slab","Teknik Pahat","Teknik Putar","Teknik Pijit","Teknik Pilin"},
            {"Plastis","Sekunder","Ball Clay","Primer","Kaolin"},
            {"Primer" ,"Stoneware","Tradisional","Modern","Sekunder"},
            {"Pengikat dalam proses pembentukan sehingga benda yang dibentuk tidak mengalami keretakan atau berubah bentuk","Penompang bentuk dalam proses pembentukan keramik","Mempercepat pengendapan butiran-butiran tanah liat, yaitu: magnesium sulfat","Menambah daya tahan bakar keramik saat masuk dalam proses pembakaran","Mempermudah proses penyusutan kadar air dalam tanah liat"},
            {"1%-5%","5%-15%","10%-30%","20%-25%","25%-40%"},
            {"1,2,3","1,2,5","1,4,6","2,4,5","3,4,6"},
            {"Teknik Pijit","Teknik Putar","Teknik Slab","Teknik Pilin","Teknik Cetak"},
            {"Teknik Slab","Teknik Pilin","Teknik Cetak","Teknik Putar","Teknik Pijit"},
            {"Teknik Pijit","Teknik Putar","Teknik Slab","Teknik Pilin","Teknik Cetak"},
            {"Spons dan Butsir" ,"Kawat pemotong dan Butsir","Kawat pemotong dan Roll Kayu","Kawat pemotong dan Alat putar tangan","Penggaris dan Butsir"},
            {"Alat putar mesin","Alat putar tangan","Alat putar kaki","Meja" , "Alat putar listrik"},
            {"Untuk mengukur panjang dan posisi tegak lurus dari benda atau model","Untuk membuat pilinan tanah liat plastis sesuai dengan asesoris yang digunkan","Sebagai alas pada waktu proses pembuatan benda keramik dan model","Sebagai media untuk membuat keramik dengan teknik putar","Untuk membuat lempengan tanah"}
    };

    public int jawabanBenar[] = {
            2,2,4,1,3,
            4,0,1,2,1,
            2,3,1,2,4
    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = setSoal[x];
        return soal;
    }

    //membuat getter untuk ambil gambar
    public int getGambar(int x){
        int gambar = setImage[x];
        return gambar;
    }

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    //membuat getter untuk mengambil pilihan jawaban 3
    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }
    //membuat getter untuk mengambil pilihan jawaban 4
    public String getPilihanJawaban4(int x){
        String jawaban3 = pilihanJawaban[x][3];
        return jawaban3;
    }
    //membuat getter untuk mengambil pilihan jawaban 4
    public String getPilihanJawaban5(int x){
        String jawaban3 = pilihanJawaban[x][4];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        int jawaban = jawabanBenar[x];
        String jawabanBenar = pilihanJawaban[x][jawaban];
        return jawabanBenar;
    }
}
