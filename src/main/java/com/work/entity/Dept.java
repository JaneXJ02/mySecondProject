package com.work.entity;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dept") //对应的表
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptno")

    private  int deptno;

    private String dname;

    private String loc;



}
