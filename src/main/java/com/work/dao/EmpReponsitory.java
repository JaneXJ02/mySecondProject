package com.work.dao;

import com.work.entity.Dept;
import com.work.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmpReponsitory extends JpaRepository<Emp,Integer> {
    //2.查询员工表中，工资大于2000，部门为20的员工信息。
    @Query("select e from Emp e where e.dept.deptno = :deptno and e.sal > :sal")
    public List<Emp> find1(@Param("deptno") Integer deptno,@Param("sal") Integer sal);




    //3.查询员工表中，部门为SALES，奖金高于500，按工资降序排列。
//    @Query("select e from emp e where e.DEPTNO=d.DEPTNO and e.sal > :sal and d.dname = :dname ORDER BY d.DEPTNO DESC")
    @Query("select e from Emp e where e.sal > :sal and e.dept.dname = :dname ORDER BY e.dept.deptno DESC")
    public List<Emp> find2(@Param("sal") Integer sal, @Param("dname")String dname);

    //1.查询部门为10的信息，并显示所有员工

    @Query("select e from Emp e where e.dept.deptno = :deptno")
    public List<Emp> find3(@Param("deptno") Integer deptno);
}
