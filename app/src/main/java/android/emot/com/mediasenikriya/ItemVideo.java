package android.emot.com.mediasenikriya;

import android.net.Uri;

public class ItemVideo {
    private String nama,judul;
    private int linkvideo;

    public ItemVideo(String nama, String judul, int linkvideo) {
        this.nama = nama;
        this.judul = judul;
        this.linkvideo = linkvideo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getLinkvideo() {
        return linkvideo;
    }

    public void setLinkvideo(int linkvideo) {
        this.linkvideo = linkvideo;
    }
}
