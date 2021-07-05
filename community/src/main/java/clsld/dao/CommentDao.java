package clsld.dao;

import clsld.entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface CommentDao extends JpaRepository<comment,Integer> {
    @Query("SELECT c FROM comment c WHERE c.answer_id = ?1")
    List<comment> getAllcommentByAnswerId(Integer answer_id);

}
