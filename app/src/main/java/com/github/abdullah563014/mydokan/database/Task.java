package com.github.abdullah563014.mydokan.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "task")
public class Task implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "electric")
    private String electric;

    @ColumnInfo(name = "store")
    private String store;

    @ColumnInfo(name = "car")
    private String car;

    @ColumnInfo(name = "guest")
    private String guest;

    @ColumnInfo(name = "donation")
    private String donation;

    @ColumnInfo(name = "commute")
    private String commute;

    @ColumnInfo(name = "commission")
    private String commission;

    @ColumnInfo(name = "mixed")
    private String mixed;

    @ColumnInfo(name = "share_holder")
    private String share_holder;

    @ColumnInfo(name = "habibure_vai")
    private String habibure_vai;

    @ColumnInfo(name = "faizullah_vai")
    private String faizullah_vai;

    @ColumnInfo(name = "motorcycle")
    private String motorcycle;

    public Task(String date, String electric, String store, String car, String guest, String donation, String commute, String commission, String mixed, String share_holder, String habibure_vai, String faizullah_vai, String motorcycle) {
        this.date = date;
        this.electric = electric;
        this.store = store;
        this.car = car;
        this.guest = guest;
        this.donation = donation;
        this.commute = commute;
        this.commission = commission;
        this.mixed = mixed;
        this.share_holder = share_holder;
        this.habibure_vai = habibure_vai;
        this.faizullah_vai = faizullah_vai;
        this.motorcycle = motorcycle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getElectric() {
        return electric;
    }

    public void setElectric(String electric) {
        this.electric = electric;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }

    public String getCommute() {
        return commute;
    }

    public void setCommute(String commute) {
        this.commute = commute;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getMixed() {
        return mixed;
    }

    public void setMixed(String mixed) {
        this.mixed = mixed;
    }

    public String getShare_holder() {
        return share_holder;
    }

    public void setShare_holder(String share_holder) {
        this.share_holder = share_holder;
    }

    public String getHabibure_vai() {
        return habibure_vai;
    }

    public void setHabibure_vai(String habibure_vai) {
        this.habibure_vai = habibure_vai;
    }

    public String getFaizullah_vai() {
        return faizullah_vai;
    }

    public void setFaizullah_vai(String faizullah_vai) {
        this.faizullah_vai = faizullah_vai;
    }

    public String getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(String motorcycle) {
        this.motorcycle = motorcycle;
    }
}
