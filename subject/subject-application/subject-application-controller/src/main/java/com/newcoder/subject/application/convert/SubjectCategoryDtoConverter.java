package com.newcoder.subject.application.convert;

import com.newcoder.subject.application.dto.SubjectCategoryDto;
import com.newcoder.subject.domain.entity.SubjectCategoryBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Description:
 *
 * @author chenye
 */
@Mapper
public interface SubjectCategoryDtoConverter {

    SubjectCategoryDtoConverter INSTANCE = Mappers.getMapper(SubjectCategoryDtoConverter.class);

    SubjectCategoryBo convertDtoToBo(SubjectCategoryDto subjectCategoryDto);
    SubjectCategoryDto convertBoToDto(SubjectCategoryBo subjectCategoryBo);
    List<SubjectCategoryDto> convertBoToDtoList(List<SubjectCategoryBo> subjectCategoryBoList);
}
