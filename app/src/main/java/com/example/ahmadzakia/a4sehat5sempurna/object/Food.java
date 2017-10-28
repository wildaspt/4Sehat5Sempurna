package com.example.ahmadzakia.a4sehat5sempurna.object;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ahmadzakia on 26/10/2017.
 */

public class Food implements Serializable{
    private int id;
    private String nama;
    private float suhu;
    private float berat;
    private String info_gizi;
    private Date last_eaten;
    private int photo_url;

    public Food(int id, String nama,int photo_url) {
        this.id = id;
        this.nama = nama;
        this.photo_url = photo_url;
        suhu = 0;
        berat = 0;
        info_gizi = null;
        last_eaten = null;

    }

    public float getBerat() {
        return berat;
    }

    public void setBerat(float berat) {
        this.berat = berat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getSuhu() {
        return suhu;
    }

    public void setSuhu(float suhu) {
        this.suhu = suhu;
    }

    public String getInfo_gizi() {



        return info_gizi;
    }

    public void setInfo_gizi(String info_gizi) {
        this.info_gizi = info_gizi;
    }

    public Date getLast_eaten() {
        return last_eaten;
    }

    public void setLast_eaten(Date last_eaten) {
        this.last_eaten = last_eaten;
    }

    public int getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(int photo_url) {
        this.photo_url = photo_url;
    }
}
