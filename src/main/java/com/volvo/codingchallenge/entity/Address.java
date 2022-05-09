package com.volvo.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 9)
    @NotNull
    private String zipCode;

    @Column
    @NotNull
    private Integer number;

    @Column
    //@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Customer> customers;
}
