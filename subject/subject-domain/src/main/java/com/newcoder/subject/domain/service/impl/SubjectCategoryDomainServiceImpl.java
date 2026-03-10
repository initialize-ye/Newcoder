package com.newcoder.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.newcoder.subject.domain.convert.SubjectCategoryConverter;
import com.newcoder.subject.domain.entity.SubjectCategoryBo;
import com.newcoder.subject.domain.service.SubjectCategoryDomainService;
import com.newcoder.subject.infra.basic.entity.SubjectCategory;
import com.newcoder.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


/**
 * Description:
 *
 * @author chenye
 */
@Service("SubjectCategoryDomainService")
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBo subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategoryService.insert(subjectCategory);

    }

    @Override
    public List<SubjectCategoryBo> queryCategory() {
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(0L);

        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryPrimaryCategory(subjectCategory);
        List<SubjectCategoryBo> boList = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryList);

        log.info("Domain层查询结果: {}", JSON.toJSONString(boList));
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryPrimaryCategory.boList:{}", JSON.toJSONString(boList));
        }
        return boList;
    }
}

