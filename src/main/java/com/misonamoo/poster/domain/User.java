package com.misonamoo.poster.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name="POSTER_USER", schema = "bizmiso")
/*@TableGenerator(name="POSTER_SEQ_GENERATOR",
            table = "POSTER_SEQUENCES",
            pkColumnValue = "POSTER_SEQ",
           allocationSize = 1)*/
public class User {

    @Id @GeneratedValue
    @Column(name = "ID")
    private String id;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

}
