package com.misonamoo.poster.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name="POSTER_CATEGORY", schema="bizmiso")
@TableGenerator(name="CATEGORY_SEQ_GENERATOR",
        table = "CATEGORY_SEQUENCES",
        pkColumnValue = "CATEGORY_SEQ",
        allocationSize = 1)
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "CATEGORY_SEQ_GENERATOR")
    @Column(name = "CTGRY_NO")
    private Long ctgryNo;

    @Column(name = "CTGRY_ENG_NM")
    private String ctgryEngNm;

    @Column(name = "CTGRY_KOR_NM")
    private String ctgryKorNm;

    @Column(name="CTGRY_REGISTER")
    private Long ctgryRegister;

    @Column(name="CTGRY_REGIST_DT")
    private Date ctgryRegistDt;

    @Column(name="CTGRY_UPDT_USR")
    private Long ctgryUpdtUsr;

    @Column(name="CTGRY_UPDT_DT")
    private Date ctgryUpdtDt;

}
