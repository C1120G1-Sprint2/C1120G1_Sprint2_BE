package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.RoomSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomSeatRepository extends JpaRepository<RoomSeat,Integer> {

    @Query(value = "select * from cinema_db.room_seat where room_id = ?1",nativeQuery = true)
    List<RoomSeat> showAllSeatByRoomId(Integer roomId);

    @Query(value = "select * from cinema_db.room_seat where room_id = ?1 and (seat_status_id = 1 or seat_status_id = 2)",nativeQuery = true)
    List<RoomSeat> getSeatTotal(Integer roomId);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE cinema_db.room_seat SET seat_status_id = 3 WHERE room_seat_id = ?1",nativeQuery = true)
    void deleteSeat(Integer roomSeatId);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE cinema_db.room_seat SET seat_status_id = 1 WHERE room_seat_id = ?1",nativeQuery = true)
    void creatSeat(Integer roomSeatId);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '1', '1') " +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '2', '1') " +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '3', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '4', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '5', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '6', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '7', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '8', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '9', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '10', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '11', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '12', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '13', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '14', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '15', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '16', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '17', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '18', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '19', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '20', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '21', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '22', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '23', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '24', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '25', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '26', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '27', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '28', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '29', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '30', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '31', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '32', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '33', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '34', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '35', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '36', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '37', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '38', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '39', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '40', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '41', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '42', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '43', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '44', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '45', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '46', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '47', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '48', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '49', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '50', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '51', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '52', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '53', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '54', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '55', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '56', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '57', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '58', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '59', '1')" +
            "INSERT INTO `cinema_db`.`room_seat` (`room_id`, `seat_id`, `seat_status_id`) VALUES (?, '60', '1')",nativeQuery = true)
    void saveRoom(Integer roomId);
}
