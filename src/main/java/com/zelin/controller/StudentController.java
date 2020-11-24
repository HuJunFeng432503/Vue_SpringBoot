package com.zelin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zelin.pojo.Classes;
import com.zelin.pojo.PageResult;
import com.zelin.pojo.Result;
import com.zelin.pojo.Student;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by WF on 2020/9/1 10:30
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/list")
    public List<Student> findAll(){
        return studentService.findAll();
    }


    @RequestMapping("/add")
    public Result add(@RequestBody Student student){

        try{
            studentService.insert(student);

            return new Result(true,"添加学生成功!!");

        }catch (Exception exception){

            exception.printStackTrace();
            return new Result(false,"添加学生失败！");
        }

    }


    @RequestMapping("/update")
    public Result update(@RequestBody Student student){

        try{
            studentService.update(student);

            return new Result(true,"更新学生成功!!");

        }catch (Exception exception){

            exception.printStackTrace();
            return new Result(false,"更新学生失败！");
        }

    }



    @RequestMapping("/delete")
    public Result delete(long [] ids){

        try{
            studentService.delete(ids);

            return new Result(true,"删除学生成功!!");

        }catch (Exception exception){

            exception.printStackTrace();
            return new Result(false,"删除学生失败！");
        }

    }



    @RequestMapping("/search")
    public PageResult search(long page, long pageSize , @RequestBody Student student){

        try{
            IPage<Student> byPages=studentService.findByPage(page, pageSize , student);

            return new PageResult(byPages.getTotal()   ,  byPages.getRecords());

        }catch (Exception exception){

            exception.printStackTrace();
            return new PageResult();
        }

    }

}
