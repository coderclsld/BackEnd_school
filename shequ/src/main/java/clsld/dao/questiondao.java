package clsld.dao;


import clsld.entity.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface questiondao extends JpaRepository<question,Integer> {
//    增加关注数
    @Modifying
    @Query("update question set focus = focus+1 where question_id=?1")
    void addfocus(int question_id);
//    减少关注数
    @Modifying
    @Query("update question set focus = focus-1 where question_id=?1")
    void cutfocus(int question_id);
//    得到关注数
    @Query("select focus from question where question_id=?1")
    int getfocus(int question_id);
}
