package org.zuel.course.frame.service;

import org.zuel.course.frame.model.Bookmark;
import org.zuel.course.frame.query_param.BookmarkQuery;

import java.util.List;

public interface IBookmarkService {

    // 按名称模糊查询数据库中的记录
    List<Bookmark> list(String name);
    // 向数据库中添加新的记录
    void add(Integer id, String name, String author, String category);
    // 按编号删除数据库中的记录
    void del(Integer id);

    List<Bookmark> rest(BookmarkQuery query);

}
