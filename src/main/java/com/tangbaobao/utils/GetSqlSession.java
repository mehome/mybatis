package com.tangbaobao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具获取SqlSession
 *
 * @author 唐学俊
 * @create 2018/02/02
 **/

public class GetSqlSession {
    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private static SqlSessionFactory sqlSessionFactory;
    private volatile static  GetSqlSession instance;

    /**
     * 私有构造方法,防止实例化
     */
    private GetSqlSession() {

    }

    /**
     * 加载配置文件
     */
    static {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("sqlMapConfig.xml");
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单利模式返回一个对象
     * 由于存在并发问题,和线程轮流调度问题,对执行指令可能重拍,
     * 所以用了volatile,保证执行顺序,每个线程只返回一个实例
     * @return
     */
    public static GetSqlSession newInstance(){
        if(instance == null){
            synchronized (GetSqlSession.class){
                if(instance == null){
                    instance = new GetSqlSession();
                }
            }
        }
        return instance;
    }

    /**
     * 返回给调用者Session
     * @return
     */
    public  SqlSession openSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }


}
