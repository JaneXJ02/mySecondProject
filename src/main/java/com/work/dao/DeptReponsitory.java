package com.work.dao;

import com.work.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptReponsitory extends JpaRepository<Dept,Integer>{

    //1.查询部门表中，部门编号大于等于30，部门名称中包含“T”关键字，并降序排列。
    public List<Dept> findByDeptnoGreaterThanEqualAndDnameLikeOrderByDeptnoDesc(Integer id,String name);

}
