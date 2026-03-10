package com.newcoder.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.newcoder.subject.application.convert.SubjectCategoryDtoConverter;
import com.newcoder.subject.application.dto.SubjectCategoryDto;
import com.newcoder.subject.common.entity.Result;
import com.newcoder.subject.domain.entity.SubjectCategoryBo;
import com.newcoder.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类controller
 *
 * @author chenye
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            Preconditions.checkNotNull(subjectCategoryDto.getCategoryName(), "分类名不能为空");
            Preconditions.checkNotNull(subjectCategoryDto.getParentId(), "分类父级ID不能为空");


            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConverter.INSTANCE.convertDtoToBo(subjectCategoryDto);
            subjectCategoryDomainService.add(subjectCategoryBo);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDto>> queryPrimaryCategory() {
        try {
            List<SubjectCategoryBo> subjectCategoryBoList = subjectCategoryDomainService.queryCategory();
            List<SubjectCategoryDto> subjectCategoryDtoList = SubjectCategoryDtoConverter.INSTANCE.convertBoToDtoList(subjectCategoryBoList);

            return Result.ok(subjectCategoryDtoList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }

}
