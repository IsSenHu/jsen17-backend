package com.jsen17.helper;

import com.jsen17.helper.po.UserPO;
import com.jsen17.helper.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuSen
 * @since 2022/5/27 2:46 PM
 */
@RestController
@SpringBootApplication
public class Application {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/user/findAll")
    public List<UserPO> findAll() {
        return userRepository.findAll();
    }

    public static void main(String[] args) {
        UserRepository userRepository = SpringApplication.run(Application.class, args).getBean(UserRepository.class);
        long start = System.currentTimeMillis();
        userRepository.findAll();
        System.out.println(System.currentTimeMillis() - start);
        userRepository.findAll();
        System.out.println(System.currentTimeMillis() - start);
    }
}
