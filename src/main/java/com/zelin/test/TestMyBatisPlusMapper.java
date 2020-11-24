package com.zelin.test;

import com.zelin.pojo.Student;
import com.zelin.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by WF on 2020/9/1 9:41
 */
//下面两个注解代表springboot与junit进行整合
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMyBatisPlusMapper {
    @Autowired
    private StudentService studentService;


    @Test
    public void test01(){
        List<Student> students = studentService.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
