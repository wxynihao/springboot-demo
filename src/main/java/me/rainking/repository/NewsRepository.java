package me.rainking.repository;

import me.rainking.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer>{

    /**使用标题查询新闻
     * @param title 新闻标题
     * @return 符合标题条件的新闻
     */
    List<News> findByTitle(String title);

}
