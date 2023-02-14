package data.repositories;

import data.models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplTest {
    private ArticleRepository articleRepository;
    private Article article;
    @BeforeEach
    void setUp() {
        articleRepository = new ArticleRepositoryImpl();
        article = new Article();
    }
    @Test
    public void saveOneArticleTest(){
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
    }
    @Test
    public void saveOneArticle_IdOfArticleIsOneTest(){
        articleRepository.save(article);
        articleRepository.findById(1);
        assertEquals(1, article.getId());
    }
    @Test
    public void savedTwoArticlesWithOneId_IdIsOneTest(){
        Article newArticle = articleRepository.save(article);
        assertEquals(1, newArticle.getId());
        Article foundArticle = articleRepository.findById(1);
        assertEquals(foundArticle, newArticle);
    }
    @Test
    public void saveOneArticle_deleteOneArticleTest(){
        article = articleRepository.save(article);
        assertEquals(1, article.getId());
        articleRepository.deleteById(1);
        assertEquals(0, articleRepository.count());

    }

    @Test
     public void deleteAllArticle_countIsZero(){
        article = articleRepository.save(article);

        Article newArticle = new Article();
        newArticle = articleRepository.save(newArticle);
        assertEquals(2,articleRepository.count());
        articleRepository.deleteAll();
        assertEquals(0, articleRepository.count());
    }
}