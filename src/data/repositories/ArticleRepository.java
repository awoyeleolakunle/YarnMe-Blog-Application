package data.repositories;

import data.models.Article;

import java.util.List;

public interface ArticleRepository {
    Article save(Article article);

    Article findById(int id);

    List<Article> findAll();

    long count();

    void deleteById(int id);

    void deleteAll();

}
