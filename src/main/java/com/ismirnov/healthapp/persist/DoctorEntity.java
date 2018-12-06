package com.ismirnov.healthapp.persist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DOCTOR", schema = "PUBLIC")
public class DoctorEntity {
    private int id;
    private String specialityCode;
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

    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    public UserEntity getUserEntity() {
        return this.user;
    }

    public void setUserEntity(UserEntity user) {
        this.user = user;
    }

    private Set<RxEntity> rxs = new HashSet<>();
    @OneToMany(mappedBy = "doctorId", targetEntity = RxEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    public Set<RxEntity> getRxs() {
        return rxs;
    }
    public void setRxs(Set<RxEntity> rxs) {
        this.rxs = rxs;
    }

    @Basic
    @Column(name = "speciality_code")
    public String getSpecialityCode() {
        return specialityCode;
    }

    public void setSpecialityCode(String specialityCode) {
        this.specialityCode = specialityCode;
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
        DoctorEntity that = (DoctorEntity) o;
        return id == that.id &&
                Objects.equals(specialityCode, that.specialityCode) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialityCode, createTime, lastUpdated);
    }

    public String toString() {
        return this.getSpecialityCode() +" "+ this.user;
    }

}
