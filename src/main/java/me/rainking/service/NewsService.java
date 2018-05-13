package me.rainking.service;

import me.rainking.repository.NewsRepository;
import me.rainking.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    /**
     * 添加两条新闻，使用事务，即两条新闻要么都插入成功，要么都不插入
     */
    @Transactional
    public void insertTwoNews()
    {
        News sport = new News();
        sport.setTitle("体育");
        sport.setContent("这是体育新闻");
        newsRepository.save(sport);

        News mil = new News();
        mil.setTitle("军事");
        mil.setContent("这是军事新闻");
        newsRepository.save(mil);
    }

}
