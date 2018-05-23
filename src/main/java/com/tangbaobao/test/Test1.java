package com.tangbaobao.test;

import com.tangbaobao.mapper.UserDao;
import com.tangbaobao.pojo.User;
import com.tangbaobao.utils.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * 测试Mapper
 *
 * @author 唐学俊
 * @create 2018/02/02
 **/

public class Test1 {
    @Test
    public void fun1() throws IOException {
        GetSqlSession getSqlSession = GetSqlSession.newInstance();
        SqlSession session = getSqlSession.openSession();
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> users = mapper.selectAll();
        users.forEach(u-> System.out.println(u));
    }
}
