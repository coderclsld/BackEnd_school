package clsld.dao;


import clsld.entity.answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface answerdao extends JpaRepository<answer,Integer> {
    @Modifying
    @Query("update answer set zang = zang+1 where answer_id=?1")
    void addZang(int answer_id);

    @Modifying
    @Query("update answer set zang = zang-1 where answer_id=?1")
    void cutZang(int answer_id);

    @Query("select zang from answer where answer_id=?1")
    int getZang(int answer_id);

    @Query(value="SELECT * From answer WHERE question_id=?1",nativeQuery = true)
    List<answer> selectOneAnswer(int question_id);
    
    @Query(value = "select * from answer where answer_id=?1",nativeQuery = true)
    answer getAnswerById(int answer_id);
}
