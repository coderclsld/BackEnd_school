package clsld.dao;

import clsld.entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentdao extends JpaRepository<comment,Integer> {
}
