package com.misonamoo.poster.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name="POSTER_MAIN", schema = "bizmiso")
@TableGenerator(name="POSTER_SEQ_GENERATOR",
            table = "POSTER_SEQUENCES",
            pkColumnValue = "POSTER_SEQ",
           allocationSize = 1)
public class Poster {

    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "POSTER_SEQ_GENERATOR")
    @Column(name = "POSTER_NO")
    private Long posterNo;

    @Column(name="POSTER_TITLE")
    private String posterTitle;

    @Column(name="POSTER_CONTENT")
    private String posterContent;

    @Column(name="POSTER_TYPE")
    private int posterType;

    @Column(name="POSTER_REGIST_DT")
    private Date posterRegistDt;

    @Column(name="POSTER_REGISTER")
    private Long posterRegister;

    @Column(name="POSTER_UPDT_USR")
    private Long posterUpdtUsr;

    @Column(name="POSTER_UPDT_DT")
    private Date posterUpdtDt;

    @Column(name="POSTER_IMG_PATH")
    private String posterImgPath;

}
