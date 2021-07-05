package clsld.dao;

import clsld.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<user,Integer> {
    @Query(value="SELECT * From user WHERE userid=?1",nativeQuery = true)
    user getOne(String integer);

}
