package org.zuel.course.frame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zuel.course.frame.mapper.BookmarkMapper;
import org.zuel.course.frame.model.Bookmark;
import org.zuel.course.frame.model.BookmarkExample;
import org.zuel.course.frame.query_param.BookmarkQuery;
import org.zuel.course.frame.service.IBookmarkService;

import java.util.List;

@Service
public class BookmarkService implements IBookmarkService {

    @Autowired
    private BookmarkMapper bookmarkMapper;

    @Override
    public List<Bookmark> list(String name) {
        BookmarkExample example = new BookmarkExample();
        example.setDistinct(true);
        if(name != null && !"".equals(name)) {
            example.createCriteria().andNameLike("%" + name + "%");
        }
        List<Bookmark> list = bookmarkMapper.selectByExample(example);
        return list;
    }

    @Override
    public void add(Integer id, String name, String author, String category) {
        Bookmark bookmark = new Bookmark();
        bookmark.setId(id);
        bookmark.setName(name);
        bookmark.setAuthor(author);
        bookmark.setCategory(category);
        bookmarkMapper.insert(bookmark);
    }

    @Override
    public void del(Integer id) {
        BookmarkExample example = new BookmarkExample();
        example.createCriteria().andIdEqualTo(id);
        bookmarkMapper.deleteByExample(example);
    }

    @Override
    public List<Bookmark> rest(BookmarkQuery query) {
        BookmarkExample example = new BookmarkExample();
        example.setDistinct(true);
        if(query.getName() != null && !"".equals(query.getName())) {
            example.createCriteria().andNameLike("%" + query.getName() + "%");
        }
        List<Bookmark> list = bookmarkMapper.selectByExample(example);
        return list;
    }
}
