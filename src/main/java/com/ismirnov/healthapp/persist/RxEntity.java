package com.ismirnov.healthapp.persist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "RX", schema = "PUBLIC")
public class RxEntity {
    @Column(name = "symptoms")
    private String symptoms;
    @Column(name = "medicine")
    private String medicine;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rx_seq")
    @SequenceGenerator(name = "rx_seq", sequenceName = "seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userId;

    @OneToOne
    @JoinColumn(name = "DOCTOR_ID")
    private DoctorEntity doctorId;
}
