package com.tangbaobao.mapper;

import com.tangbaobao.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author 唐学俊
 * @create 2018/02/02 16:40
 **/
public interface UserDao {
    /**
     * 查找所有用户
     * @return
     */
    public List<User> selectAll() ;
    public Map<String, List<User>> getUser(@Param("set") Set<Integer> set);

}
