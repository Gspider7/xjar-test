package com.acrobat.jpatest.repository;

import com.acrobat.jpatest.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xutao
 * @date 2018-12-25 13:54
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // findByXxx, xxx为对应Entity的属性
    public Project findByName(String name);

}
