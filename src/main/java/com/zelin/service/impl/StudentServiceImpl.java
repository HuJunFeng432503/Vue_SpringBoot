package com.zelin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zelin.mapper.ClassessMapper;
import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.Student;

import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WF on 2020/9/1 9:45
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClassessMapper classessMapper;


    @Override
    public List<Student> findAll() {

        List<Student> students = studentMapper.selectList(null);

        //将学生与班级绑定
        for (Student student : students) {
            student.setCname(classessMapper.selectById(student.getCid()).getCname());
        }
        //返回学生列表
        return students;
    }

    @Override
    public void insert(Student student) {

        studentMapper.insert(student);
    }

    @Override
    public void delete(long[] ids) {

        studentMapper.deleteById(ids);
    }

    @Override
    public void update(Student student) {

        studentMapper.updateById(student);
    }


    //条件查询带分页
    @Override
    public IPage<Student> findByPage(long page, long pageSize, Student student) {


        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();


        if(StrUtil.isNotBlank(student.getSname())){
            queryWrapper.like("sname",student.getSname());
        }


        if(StrUtil.isNotBlank(student.getAddr())){
            queryWrapper.like("addr" , student.getAddr());
        }

        if(student.getCid() != null && student.getCid() != 0){
            queryWrapper.eq("cid",student.getCid());
        }

        Page<Student> studentPage = studentMapper.selectPage(new Page<>(page, pageSize), queryWrapper);//查询

        List<Student> records = studentPage.getRecords();

        //将学生与班级名称关联
        for (Student stud : records) {
            stud.setCname(classessMapper.selectById(stud.getCid()).getCname());
        }


        //返回
        return studentPage;

    }
}
