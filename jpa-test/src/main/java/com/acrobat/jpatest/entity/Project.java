package com.acrobat.jpatest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 项目
 * @author xutao
 * @date 2018-12-25 13:36
 */
@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** 项目名称 */
    @Column(name = "name", nullable = false, unique = true, length = 64)
    private String name;
    /** 项目说明 */
    @Column(name = "description", nullable = false)
    private String description;
    /** 项目创建时间 */
    @Column(name = "create_time")
    private Date createTime;
}
