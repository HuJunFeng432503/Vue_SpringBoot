package com.zelin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zelin.mapper.ClassessMapper;
import com.zelin.pojo.Classes;
import com.zelin.pojo.Student;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WF on 2020/9/1 10:45
 */
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassessMapper classessMapper;


    //1.查询所有的班级
    @Override
    public List<Classes> findAll() {
        return classessMapper.selectList(null);
    }

    @Override
    public void insert(Classes classes) {
        classessMapper.insert(classes);

    }

    @Override
    public void delete(long[] ids) {

        classessMapper.deleteById(ids);
    }

    @Override
    public void update(Classes classes) {

        classessMapper.updateById(classes);
    }

    @Override
    public IPage<Classes> findByPage(long page, long pageSize, Classes classes) {



        QueryWrapper<Classes> queryWrapper=new QueryWrapper<>();



        if(classes.getCid() != null && classes.getCid() != 0){
            queryWrapper.eq("cid",classes.getCid());
        }

        if(StrUtil.isNotBlank(classes.getCname())){
            queryWrapper.like("cname" , classes.getCname());
        }

        Page<Classes> classesPage = classessMapper.selectPage(new Page<>(page, pageSize), queryWrapper);//查询


        //返回
        return classesPage;
    }
}
