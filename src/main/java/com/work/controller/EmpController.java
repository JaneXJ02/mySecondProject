package com.work.controller;

import com.work.dao.DeptReponsitory;
import com.work.dao.EmpReponsitory;
import com.work.entity.Dept;
import com.work.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpReponsitory empReponsitory;
    @Autowired
    private DeptReponsitory deptReponsitory;

    //2.查询员工表中，工资大于2000，部门为20的员工信息。
    @GetMapping("/query1/{deptno}/{sal}")
    public List<Emp> queryBy1(@PathVariable("deptno") Integer deptno, @PathVariable("sal")Integer sal){
		system.out.print("查询一");
		system.out.print("查询一一");
        return empReponsitory.find1(deptno,sal);
    }

//    // 3.查询员工表中，部门为SALES，奖金高于500，按工资降序排列
    @GetMapping("/query2/{sal}/{dname}")
    public List<Emp> queryBy2(@PathVariable("sal") Integer sal, @PathVariable("dname") String dname){
        List<Emp> empList = empReponsitory.find2(sal, dname);
        return empList;
    }

    //1.查询部门为10的信息，并显示所有员工。
    @GetMapping("/querydeptno/{deptno}")
    public List<Emp> queryByDeptno(@PathVariable("deptno") Integer deptno){
        List<Emp> empList = empReponsitory.find3(deptno);
        return empList;
    }

    //2.查询员工为7698的信息，并显示部门。
    @GetMapping("/{id}")
    public Emp queryById(@PathVariable("id") Integer id){
        Emp emp = empReponsitory.findById(id).get();
        return emp;
    }
    //3.增加一个新员工。
    @GetMapping("/add")
    public Emp add(){
        Emp emp = new Emp();
        emp.setEmpno(7656);
        emp.setEname("JANE");
        emp.setJob("SALESMAN");
        emp.setMgr("7698");
        emp.setHiredate(new Date());
        emp.setSal(3500);
        emp.setComm("200");
        Dept dept = deptReponsitory.findById(30).get();
        emp.setDept(dept);
        return emp;
    }
}
