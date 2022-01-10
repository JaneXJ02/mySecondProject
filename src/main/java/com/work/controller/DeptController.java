package com.work.controller;

import com.work.dao.DeptReponsitory;
import com.work.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptReponsitory deptReponsitory;

    //1.查询20号部门并显示。
    @GetMapping("/{id}")
    public Dept queryById(@PathVariable("id") Integer id){
        Dept dept = deptReponsitory.findById(id).get();
        return dept;
    }
    //2.添加一个新的部门。
    @GetMapping("/add")
    public Dept addDept (){
        Dept d=new Dept();
        d.setDname("DEVELOPMENT");
        d.setLoc("CHANGSAN");
        deptReponsitory.save(d);
        return d;
    }
    //3.修改新增的部门名称。
    @GetMapping("/update/{id}")
    public Dept updateDept(@PathVariable("id") Integer id){
        Dept dept = deptReponsitory.findById(id).get();
        dept.setDname(dept.getDname()+"s");
        deptReponsitory.save(dept);
        return dept;
    }
    //4.删除新增的部门。
    @GetMapping("/delete/{id}")
    public String deleteDept(@PathVariable("id") Integer id){
        try {
            Dept dept = deptReponsitory.findById(id).get();
            deptReponsitory.delete(dept);
            return "删除成功";
        }catch (Exception e){
            e.printStackTrace();
            return "删除失败";
        }
    }

    //1.查询部门表中，部门编号大于等于30，部门名称中包含“T”关键字，并降序排列。
    @GetMapping("/query/{id}/{name}")
    public List<Dept> queryByIdAndName(@PathVariable("id") Integer id,@PathVariable("name") String name){
        List<Dept> deptList = deptReponsitory.findByDeptnoGreaterThanEqualAndDnameLikeOrderByDeptnoDesc(id,"%"+name+"%");
        return deptList;
    }

}
