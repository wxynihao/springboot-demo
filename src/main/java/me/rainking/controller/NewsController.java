package me.rainking.controller;

import me.rainking.model.News;
import me.rainking.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;


    /**
     * 查询全部新闻
     *
     * @return
     */
    @GetMapping("/news")
    public List<News> listNews() {
        return newsRepository.findAll();
    }

    /**
     * 添加新闻
     *
     * @param title 标题
     * @param content 内容
     * @param publishTimeStr 发布时间
     * @return
     */
    @PostMapping("/news")
    public News addNews(@RequestParam("title") String title,
                        @RequestParam("content") String content,
                        @RequestParam("publishTime") String publishTimeStr) {
        News news = new News();
        news.setTitle(title);
        news.setContent(content);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date publishTime = null;
        try {
            publishTime = sdf.parse(publishTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        news.setPublishTime(publishTime);

        return newsRepository.save(news);
    }

    /**
     * 通过主键查询一条新闻
     *
     * @param id
     * @return
     */
    @GetMapping("/news/{id}")
    public News getNewsById(@PathVariable("id") Integer id) {
        return newsRepository.findOne(id);
    }

    /**
     * 通过标题查询新闻
     *
     * @param title
     * @return
     */
    @GetMapping("/news/title/{title}")
    public List<News> getNewsByTitle(@PathVariable("title") String title) {
        return newsRepository.findByTitle(title);
    }


    /**
     * 更新一条新闻 必须同时提供全部参数
     *
     * @param id
     * @param title
     * @param content
     * @param publishTimeStr
     * @return
     */
    @PutMapping("/news/{id}")
    public News updateNews(@PathVariable("id") Integer id,
                           @RequestParam("title") String title,
                           @RequestParam("content") String content,
                           @RequestParam("publishTime") String publishTimeStr) {

        News news = new News();
        news.setId(id);
        news.setTitle(title);
        news.setContent(content);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date publishTime = null;
        try {
            publishTime = sdf.parse(publishTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        news.setPublishTime(publishTime);

        return newsRepository.save(news);
    }

    /**
     * 删除一条新闻
     *
     * @param id
     */
    @DeleteMapping("/news/{id}")
    public void deleteNews(@PathVariable("id") Integer id) {
        newsRepository.delete(id);
    }

}
