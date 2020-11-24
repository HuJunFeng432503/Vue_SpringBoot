package com.zelin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zelin.pojo.Classes;
import com.zelin.pojo.PageResult;
import com.zelin.pojo.Result;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by WF on 2020/9/1 10:43
 */
@RestController
@RequestMapping("classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;


    @GetMapping("list")
    public List<Classes> findAll(){
        return classesService.findAll();
    }


    @RequestMapping("/add")
    public Result add(@RequestBody Classes classes){

        try{
            classesService.insert(classes);

            return new Result(true,"添加班级成功!!");

        }catch (Exception exception){

            exception.printStackTrace();
            return new Result(false,"添加班级失败！");
        }

    }


    @RequestMapping("/update")
    public Result update(@RequestBody Classes classes){

        try{
            classesService.update(classes);

            return new Result(true,"更新班级成功!!");

        }catch (Exception exception){

            exception.printStackTrace();
            return new Result(false,"更新班级失败！");
        }

    }



    @RequestMapping("/delete")
    public Result delete(long [] ids){

        try{
            classesService.delete(ids);

            return new Result(true,"删除班级成功!!");

        }catch (Exception exception){

            exception.printStackTrace();
            return new Result(false,"删除班级失败！");
        }

    }



    @RequestMapping("/search")
    public PageResult search(long page, long pageSize , @RequestBody Classes classes){

        try{
            IPage<Classes> byPage = classesService.findByPage(page, pageSize, classes);

            return new PageResult(byPage.getTotal(),byPage.getRecords());

        }catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }



}
