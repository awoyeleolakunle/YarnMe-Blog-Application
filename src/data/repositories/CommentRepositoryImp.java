package data.repositories;

import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImp implements CommentRepository{

    private int count;

    List<Comment> comments = new ArrayList<>();

    @Override
    public Comment save(Comment comment) {
        if(comment.getId()==0){
           comment.setId(generateId());
        comments.add(comment);
        count++;}
        return comment;
    }

    @Override
    public Comment findById(int id) {
        for (Comment comment:comments) {
            if(comment.getId()==id)
                return comment;
        }
        return null;
    }
    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public List<Comment> comments() {
        return null;
    }

    @Override
    public void delete(int id) {
        for (Comment comment:comments) {
            if(comment.getId() == id)
                comments.remove(comment);
            count--;
            break;
        }

        }


    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteByComment(Comment comment) {

    }
    public int generateId(){
        return count+1;
    }
}
