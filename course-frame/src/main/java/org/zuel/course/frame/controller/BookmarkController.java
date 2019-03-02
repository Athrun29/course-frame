package org.zuel.course.frame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zuel.course.frame.model.Bookmark;
import org.zuel.course.frame.query_param.BookmarkQuery;
import org.zuel.course.frame.service.impl.BookmarkService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("bookmarks") ArrayList<Bookmark> bookmarks) {
        ModelAndView modelAndView = new ModelAndView("list");
        if(bookmarks.size() == 0) {
            bookmarks = (ArrayList<Bookmark>) bookmarkService.list("");
        }
        modelAndView.addObject("bookmarks", bookmarks);
        return modelAndView;
    }

    @RequestMapping("/query")
    public String query(@RequestParam("queryName") String name, RedirectAttributes attr) {
        List<Bookmark> list = bookmarkService.list(name);
        attr.addFlashAttribute("bookmarks", list);
        return "redirect:list";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/doAdd")
    public String doAdd(@RequestParam("id") Integer id, @RequestParam("name") String name,
                        @RequestParam("author") String author, @RequestParam("category") String category) {
        bookmarkService.add(id, name, author, category);
        return "redirect:list";
    }

    @RequestMapping("/del")
    public String del(@RequestParam("delId") String id, RedirectAttributes attr) {
        try {
            bookmarkService.del(Integer.valueOf(id));
            return "redirect:list";
        } catch (Exception e) {
            attr.addFlashAttribute("error", e.getMessage());
            return "redirect:/500";
        }
    }

    @RequestMapping("/rest")
    @ResponseBody
    public List<Bookmark> rest(@RequestBody BookmarkQuery query) {
        return bookmarkService.rest(query);
    }

}
