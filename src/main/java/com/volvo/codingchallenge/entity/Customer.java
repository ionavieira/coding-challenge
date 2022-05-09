package com.volvo.codingchallenge.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customerId;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    @Size(min=1, max=3)
    private Integer age;

    @Column
    @NotNull
    private Date registrationDate;

    @Column
    private String lastUpdateInfo;

    @Column
    @ManyToMany(mappedBy = "customers")
    private List<Address> addresses;

}
