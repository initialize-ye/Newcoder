package com.newcoder.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目分类实体类
 *
 * @author makejava
 */

@Data
public class SubjectCategoryBo implements Serializable {
    private static final long serialVersionUID = -68161421718816271L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类类型
     */
    private Integer categoryType;
    /**
     * 图标链接
     */
    private String imageUrl;
    /**
     * 父级id
     */
    private Long parentId;
}

