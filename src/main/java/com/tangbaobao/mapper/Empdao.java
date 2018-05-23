package com.tangbaobao.mapper;

import com.tangbaobao.pojo.Emp;
import com.tangbaobao.pojo.Exp;
import com.tangbaobao.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 查询接口
 *
 * @author 唐学俊
 * @create 2018/02/05
 **/
public interface Empdao {


    /**
     * :增加一个员工，并增加员工的教育经历
     */
    public void add(Emp emp);

    public void addExpByEmp(Exp exp);

    /**
     * 更新,根据员工
     */
    public void updateByEmp(Emp emp);

    /**
     * 根据教育经历更细
     *
     * @param exp
     */
    public void updateByExp(Exp exp);


    /**
     * 根据EmpId删除员工
     *
     * @param empId
     * @return
     */
    public int deleteByEmpId(String empId);

    /**
     * 根据员工教育经历删除员工
     *
     * @param expId
     * @return
     */
    public int deleteByExpId(String expId);

    /**
     * 查询所有员工(包含，每个员工的教育经历)
     *
     * @return
     */
    public List<Emp> selectAll();

    public Emp selectEmpByID(int id);

    /**
     * 根据学校名查询这个员工
     *
     * @param s
     */
    public List<Exp> selectEmpBySchool(String s);
}
