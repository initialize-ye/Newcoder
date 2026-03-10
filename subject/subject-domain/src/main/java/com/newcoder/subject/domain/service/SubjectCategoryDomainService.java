package com.newcoder.subject.domain.service;

import com.newcoder.subject.domain.entity.SubjectCategoryBo;

import java.util.List;

/**
 * Description:
 *
 * @author chenye
 */
public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBo subjectCategoryBo);

    List<SubjectCategoryBo> queryCategory();
}
