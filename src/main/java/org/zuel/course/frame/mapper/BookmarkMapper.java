package org.zuel.course.frame.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zuel.course.frame.model.Bookmark;
import org.zuel.course.frame.model.BookmarkExample;

public interface BookmarkMapper {
    long countByExample(BookmarkExample example);

    int deleteByExample(BookmarkExample example);

    int insert(Bookmark record);

    int insertSelective(Bookmark record);

    List<Bookmark> selectByExample(BookmarkExample example);

    int updateByExampleSelective(@Param("record") Bookmark record, @Param("example") BookmarkExample example);

    int updateByExample(@Param("record") Bookmark record, @Param("example") BookmarkExample example);
}

