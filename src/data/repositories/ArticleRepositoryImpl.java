package data.repositories;

import data.models.Article;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository{

    private int count;
    List<Article> articles = new ArrayList<>();

    @Override
    public Article save(Article article) {
        if(article.getId()==0){
        article.setId(generateId());
        articles.add(article);
        count++;}
        return article;
    }

    @Override
    public Article findById(int id) {
        for (Article article:articles) {
            if(article.getId()==id)
                return article;
        }
        return null;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void deleteById(int id) {
        for (Article article : articles) {
            if (article.getId()==id) {
                articles.remove(article);
                count--;
                break;
            }
        }
    }


    @Override
    public void deleteAll() {
        for (Article article: articles) {
            articles.removeAll(articles);
            count = articles.size();
            break;
        }

    }
    public int generateId(){
        return count+1;
    }
}
