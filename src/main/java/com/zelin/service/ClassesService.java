package com.zelin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zelin.pojo.Classes;

import java.util.List;

/**
 * Created by WF on 2020/9/1 10:44
 */
public interface ClassesService {

    List<Classes> findAll();

    void insert(Classes classes);

    void delete(long [] ids);

    void update(Classes classes);

    IPage<Classes> findByPage(long page , long pageSize , Classes classes);
}
