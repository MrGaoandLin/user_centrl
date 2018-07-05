package com.ut;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Entity
public class TestEntity {
    @Id
    @GeneratedValue
    Long id;
    String a;
    Integer b;
    Double c;
    @Transient
    String e;
}
