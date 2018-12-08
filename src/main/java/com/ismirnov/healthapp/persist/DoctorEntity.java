package com.ismirnov.healthapp.persist;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "DOCTOR", schema = "PUBLIC")
public class DoctorEntity implements Serializable {
    @Column(name = "speciality_code")
    private String specialityCode;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_seq")
    @SequenceGenerator(name = "doc_seq", sequenceName = "seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;
}
