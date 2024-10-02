package com.DevSalud.DSB.Repository;

import com.DevSalud.DSB.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u WHERE u.username = :username OR u.emailAddress = :emailAddress")
    UserModel findByUsernameOrEmailAddress(@Param("username") String username, @Param("emailAddress") String emailAddress);
}