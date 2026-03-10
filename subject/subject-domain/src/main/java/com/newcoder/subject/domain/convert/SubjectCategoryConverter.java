package com.newcoder.subject.domain.convert;

import com.newcoder.subject.domain.entity.SubjectCategoryBo;
import com.newcoder.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Description:
 *
 * @author chenye
 */
@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBo subjectCategoryBO);

    List<SubjectCategoryBo> convertBoToCategory(List<SubjectCategory> categoryList);
}
