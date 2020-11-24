package com.zelin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

   //代表的是自增的ID
    @TableId(type=IdType.AUTO)
    private Integer sid;

    private String sname;

    private String sex;

    private Integer age;

    private String addr;

    private Integer cid;

    @TableField(exist=false)   //此字段不去映射
    private String cname;

}