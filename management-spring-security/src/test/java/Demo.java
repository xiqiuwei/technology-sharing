import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.spring.security.jdbc.dataobject.User;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiqiuwei
 * @Date Created in 21:35 2020/5/26
 * @Description
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<User> list = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            User user = new User();
//            user.setUserSex(1);
//            user.setDepartmentKey("JAVA");
//            user.setLoginAccount("root"+i);
//            user.setLoginPass("12345");
//            user.setRegisterTime(LocalDate.now().toString());
//            user.setUserBirthday("1993-09-30");
//            user.setUserEmail("xiqiuwei@gmail.com");
//            user.setUserHead("RSA");
//            user.setUserName("奚秋伟");
//            user.setUserPhone("110");
//            list.add(user);
//        }
//        System.out.println(objectMapper.writeValueAsString(list));
        User user = new User();
        user.setUserSex(1);
        user.setDepartmentKey("JAVA");
        user.setLoginAccount("root");
        user.setLoginPass("12345");
        user.setRegisterTime(LocalDate.now().toString());
        user.setUserBirthday("1993-09-30");
        user.setUserEmail("xiqiuwei@gmail.com");
        user.setUserHead("RSA");
        user.setUserName("奚秋伟");
        user.setUserPhone("110");
        //System.out.println(getFieldsValues(user));
    }




}
