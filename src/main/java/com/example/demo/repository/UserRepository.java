package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Modifying
    @Query("Update User u Set u.status = 'PENDING' Where u.status = 'APROVED' and u.role = 'USER' and u.id in :userIds")
    void updateAllUser(List<Long> userIds);
}
