package com.zelin.service;

import cn.hutool.db.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;

import java.util.List;

/**
 * Created by WF on 2020/9/1 9:45
 */
public interface StudentService {
    List<Student> findAll();

    void insert(Student student);

    void delete(long ids[]);

    void update(Student student);

    IPage<Student> findByPage(long page, long pageSize, Student student);
}
