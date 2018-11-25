package com.firelord.test.db.mybatis;

import com.firelord.test.db.mybatis.dao.mapper.UserMapper;
import com.firelord.test.db.mybatis.dao.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/db/mybatis")
public class MybatisController {
    //#region Fields

    @Resource
    private UserMapper userMapper;

    //#endregion

    //#region test

    @RequestMapping("/test")
    @ResponseBody
    @Transactional
    public void test() {
        User oUser = new User();
        oUser.setUserid(1);
        oUser.setUsername("userName");
        oUser.setPassword("password");
        oUser.setPhone("111111");
        int iUserId = this.userMapper.insert(oUser);

        oUser.setPhone("222");
        int iUserId2 = this.userMapper.updateByPrimaryKey(oUser);

        User oUserQuery = this.userMapper.selectByPrimaryKey(1);

        int iRes = this.userMapper.deleteByPrimaryKey(1);
    }

    //#endregion
}
