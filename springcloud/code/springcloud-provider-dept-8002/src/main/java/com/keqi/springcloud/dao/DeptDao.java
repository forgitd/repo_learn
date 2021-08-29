package com.keqi.springcloud.dao;

import com.keqi.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    @Insert("insert into dept (dname,db_source) values (#{dname},#{db_source})")
    public boolean addDept(Dept dept);

    @Select("select * from dept where deptno = #{id}")
    public Dept queryById(Long id);

    @Select("select * from dept")
    public List<Dept> queryAll();
}
