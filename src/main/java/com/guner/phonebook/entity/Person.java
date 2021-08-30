package com.guner.phonebook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="person",indexes = {@Index(name="idx_phoneNumber",columnList = "phone_Number")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @SequenceGenerator(name="seq_person",allocationSize = 1)
    @GeneratedValue(generator = "seq_person",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name", nullable = false, length = 50)
    private String name;

    @Column(name="surname", nullable = false, length = 50)
    private String surname;

    @Column(name="phone_Number",nullable = false, length = 50, unique = true)
    private String phoneNumber;

    @Column(name="notes", nullable = true, columnDefinition = "TEXT")
    private String notes;

    @Column(name="status")
    private Boolean status;


}
