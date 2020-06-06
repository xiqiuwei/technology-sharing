package com.management.spring.security.jdbc.controller;

import com.management.spring.security.jdbc.dataobject.User;
import com.management.spring.security.jdbc.service.InsertBatchService;
import com.management.spring.security.security.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xiqiuwei
 * @Date Created in 23:45 2020/5/26
 * @Description
 * @Modified By:
 */
@RestController
public class JdbcController {

    @Autowired
    private InsertBatchService insertBatchService;

    @PostMapping("insertBatch")
    public ResponseEntity insertBatch(@RequestBody List<User> userList) {
        if (null == userList) {
            return ResponseEntity.fail("用户信息不能为空",1993);
        }
        String result = insertBatchService.insertBatch(userList);
        return ResponseEntity.success(result);
    }
}
