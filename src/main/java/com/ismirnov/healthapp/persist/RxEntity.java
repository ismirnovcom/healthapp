package com.ismirnov.healthapp.persist;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "RX", schema = "PUBLIC")
public class RxEntity {
    private int id;
    private String symptoms;
    private String medicine;
    private Timestamp createTime;
    private Timestamp lastUpdated;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "seq")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userId;

    @OneToOne
    @JoinColumn(name = "DOCTOR_ID")
    private DoctorEntity doctorId;

    @Basic
    @Column(name = "symptoms")
    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Basic
    @Column(name = "medicine")
    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_updated")
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RxEntity rxEntity = (RxEntity) o;
        return id == rxEntity.id &&
                Objects.equals(symptoms, rxEntity.symptoms) &&
                Objects.equals(medicine, rxEntity.medicine) &&
                Objects.equals(createTime, rxEntity.createTime) &&
                Objects.equals(lastUpdated, rxEntity.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symptoms, medicine, createTime, lastUpdated);
    }

    public String toString() {
        return this.getSymptoms() + " - " + this.getMedicine();
    }
}
