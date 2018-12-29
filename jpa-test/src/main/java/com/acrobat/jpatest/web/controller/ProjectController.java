package com.acrobat.jpatest.web.controller;

import com.acrobat.jpatest.constant.FailureCode;
import com.acrobat.jpatest.entity.Project;
import com.acrobat.jpatest.repository.ProjectRepository;
import com.acrobat.jpatest.web.BaseResult;
import com.acrobat.jpatest.web.domain.I_Project;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xutao
 * @date 2018-12-29 13:57
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @PostMapping("/add")
    public BaseResult<Project> add(@RequestBody I_Project i_project) {
        // 非空检查
        String name = i_project.getName();
        if (name == null
                || i_project.getDescription() == null) {
            return FailureCode.ERR_MISSING_PARAMS.fail();
        }

        // 重名检查
        Project existProject = projectRepository.findByName(name);
        if (existProject != null) {
            return FailureCode.ERR_DATA_EXIST.fail();
        }

        // 保存项目信息
        Project project = new Project();
        project.setCreateTime(new Date());
        BeanUtils.copyProperties(i_project, project, "id");
        projectRepository.save(project);

        // 返回
        Project savedProject = projectRepository.findByName(name);
        return BaseResult.success(savedProject);
    }
}
