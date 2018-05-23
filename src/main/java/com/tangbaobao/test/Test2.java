package com.tangbaobao.test;

import com.tangbaobao.mapper.Empdao;
import com.tangbaobao.mapper.UserDao;
import com.tangbaobao.pojo.Emp;
import com.tangbaobao.pojo.Exp;
import com.tangbaobao.pojo.User;
import com.tangbaobao.utils.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * 测试一对多
 *
 * @author 唐学俊
 * @create 2018/02/05
 **/

public class Test2 {
    GetSqlSession getSqlSession = null;

    @Before
    public void init() {

        getSqlSession = GetSqlSession.newInstance();
    }

    @Test
    public void testMap(){
        SqlSession sqlSession = getSqlSession.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Set<Integer> userSet = new HashSet<>();
        userSet.addAll(Arrays.asList(1,2,3));
        Map<String,List<User>> user = mapper.getUser(userSet);
        System.out.println(user);
    }


    /**
     * 增加
     */
    @Test
    public void add() {

        SqlSession sqlSession = getSqlSession.openSession();

        Empdao mapper = sqlSession.getMapper(Empdao.class);


        try {
            Emp emp = new Emp();
            emp.setEmpId("3");
            emp.setBirthday(new Date());
            emp.setEmpName("命名");
            emp.setEmpPassword("555f55");
            emp.setEmail("110275@qq.xom");


            Exp exp = new Exp();
            exp.setEndTime(new Date());
            exp.setExpId("3333");
            exp.setProfession("大学");
            exp.setSchool("宁夏大学");
            exp.setStartTime(new Date());
            exp.setStudyRecord("本科");
            exp.setEmp(emp);


            /**
             * 业务
             */
            mapper.add(emp);

            mapper.addExpByEmp(exp);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        sqlSession.close();

    }





    /**
     * 删除emp
     * 业务:
     * 必须先删除该emp对应的expid
     */
    @Test
    public void delte() {
        SqlSession sqlSession = getSqlSession.openSession();

        Empdao mapper = sqlSession.getMapper(Empdao.class);


        try {
            //删除教育经历
            mapper.deleteByExpId("1");

            //删除员工
            mapper.deleteByEmpId("1");

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        SqlSession sqlSession = getSqlSession.openSession();
        try {

            Empdao mapper = sqlSession.getMapper(Empdao.class);

            List<Emp> emps = mapper.selectAll();

            emps.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 根据id查询
     *
     * @return
     */
    @Test
    public void findEmpById() {
        SqlSession sqlSession = getSqlSession.openSession();
        try {

            Empdao mapper = sqlSession.getMapper(Empdao.class);

            Emp emp = mapper.selectEmpByID(1);

            System.out.println(emp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 模糊查询
     */
    @Test
    public void likeSelect() {
        SqlSession sqlSession = getSqlSession.openSession();
        Empdao mapper = sqlSession.getMapper(Empdao.class);

        List<Exp> empList = mapper.selectEmpBySchool("林业大学");

        empList.forEach(emp -> System.out.println(emp));

    }

    /**
     * 更新方法
     */
    @Test
    public  void updateEmp(){
            SqlSession sqlSession = getSqlSession.openSession();
        try {
            Empdao mapper = sqlSession.getMapper(Empdao.class);
            Emp emp = new Emp();
            emp.setEmpId("1");
            emp.setEmail("8888@qq.com");
            mapper.updateByEmp(emp);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }
}
