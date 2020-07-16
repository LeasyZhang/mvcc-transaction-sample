package com.transaction.demo.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "memo")
    private String memo;
    @Column(name = "start_date")
    private Instant startDate;
    @Column(name = "created_time")
    private Instant createdTime;
    @Column(name = "updated_time")
    private Instant updatedTime;
}