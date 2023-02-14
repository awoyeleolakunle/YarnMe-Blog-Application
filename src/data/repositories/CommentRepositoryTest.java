package data.repositories;

import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryTest {

    private CommentRepository commentRepository;
    private Comment comment;

    @BeforeEach

    public void setUp(){
        commentRepository= new CommentRepositoryImp();
        comment = new Comment();
    }
    @Test
    public void savedOneCommentTest(){
        Comment comment1 = new Comment();
        commentRepository.save(comment);
        commentRepository.save(comment1);
        assertEquals(2, commentRepository.count());

    }
    @Test
    public void savedOneComment_IdOfCommentIsOneTest(){
        Comment newComment = commentRepository.save(comment);
        Comment comment1 = new Comment();
        Comment secondComment = commentRepository.save(comment1);
        assertEquals(1, newComment.getId());
        assertEquals(2, secondComment.getId());
    }
    @Test
    public void savedTwoCommentsWithSameId_CountIsOneTest(){
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
        Comment foundComment = commentRepository.findById(1);
        assertEquals(foundComment,savedComment);

    }
    @Test
    public void savedOneComment_deleteOneCommentTest(){
        comment = commentRepository.save(comment);
        assertEquals(1, comment.getId());
        commentRepository.delete(1);
        assertEquals(0,commentRepository.count());

    }

}