package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from `user`\n" +
            "inner join `account` on `user`.username = `account`.username\n" +
            "inner join ward on `user`.ward_id = ward.ward_id\n" +
            "inner join account_status on account_status.account_status_id = `account`.account_status_id\n" +
            "where concat( email , `name` ,`account`.username, ward.ward_name , account_status.account_status_name ) like concat('%',?1,'%')" ,nativeQuery = true)
    List<User> searchAll(String key);

    @Query(value = "select * from `user` \n" +
            "inner join `account` on `user`.username = `account`.username\n" +
            "inner join account_role on `account`.username = account_role.username\n" +
            "where account_role.role_id = 1\n" +
            "group by `user`.user_id \n" +
            "limit ?1 , 5", nativeQuery = true)
    List<User> getAllUser(int index);

    @Query(value = "select * from `user` \n" +
            "inner join `account` on `user`.username = `account`.username\n" +
            "inner join account_role on `account`.username = account_role.username\n" +
            "where account_role.role_id = 1\n", nativeQuery = true)
    List<User> findAllUser();


    @Query(value = "select * from `user` where user_id = ?1", nativeQuery = true)
    User findUserById(Integer userId);

    @Modifying
    @Query(value = "update User u" +
            " set u.name = ?2, " +
            "u.email =?3, " +
            "u.phone =?4, " +
            "u.ward =?5, " +
            "u.avatarUrl =?6, " +
            "u.gender = ?7, " +
            "u.birthday = ?8" +
            " where u.userId = ?1")
    void updateUser(Integer userId, String name, String email, String phone, Ward ward, String avatarUrl,int gender, String birthday);

    @Query(value = "select  * from `user` where `user`.email = ?1" ,nativeQuery = true)
    User getUserByEmail(String email);


    @Query(value = "select * from `user` where `user`.username = ?1" , nativeQuery = true)
    User getUserByUsername (String username);

    @Query(value = "select * from `user` where `user`.id_card = ?1" , nativeQuery = true)
    User getUserByIdCard (String username);

    @Modifying
    @Query(value = "INSERT INTO `user` ( avatar_url, birthday, email, gender, id_card, name, phone, username, ward_id) " +
            "values " + "(:avatarUrl," + ":birthday," + ":email,"+" :gender,"+" :idCard," + ":name," + ":phone," + ":username," + ":wardId ) ",
            nativeQuery = true)
    @Transactional
    void saveUserCus(@Param("avatarUrl") String avatarUrl,
                     @Param("name") String name,
                     @Param("username") String username,
                     @Param("email") String email,
                     @Param("birthday") String birthday,
                     @Param("idCard") String idCard,
                     @Param("gender") int gender,
                     @Param("phone") String phone,
                     @Param("wardId") Integer wardId);

}
