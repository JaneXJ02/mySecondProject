package com.work.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emp") //对应的表
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private Date hiredate;
    private int sal;
    private String comm;
    //private int deptno;

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept dept;
}
