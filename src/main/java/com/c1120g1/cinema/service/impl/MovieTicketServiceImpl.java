package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.entity.ShowTime;
import com.c1120g1.cinema.repository.MovieTicketRepository;
import com.c1120g1.cinema.service.MovieTicketService;
import com.c1120g1.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {
    final Integer basicPrice = 45000;

    @Autowired
    private ShowTimeService showTimeService;

    @Autowired
    private MovieTicketRepository movieTicketRepository;

    @Override
    public List<MovieTicket> findAll() {
        return movieTicketRepository.findAll();
    }

    @Override
    public void createMovieTicket(MovieTicket movieTicket) throws ParseException {

        // co ngay - gio - ngay - calendar , gio` - Date - so sanh before or after
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(movieTicket.getShowDate()));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        ShowTime showTime = showTimeService.findById(movieTicket.getShowTime().getShowTimeId());

        // isNormalDate == true if (dayOfWeek != 5 && dayOfWeek != 6)
        boolean isNormalDate = dayOfWeek != 5 && dayOfWeek != 6;
        boolean isEarly17 = getDateByShowTime(showTime.getShowTime());

        int projectionId = movieTicket.getProjectionType().getProjectionId();

        String priceTicket = getPrice(isNormalDate, isEarly17, projectionId);
        movieTicket.setTicketPrice(priceTicket);
        movieTicketRepository.save(movieTicket);

    }

    /**
     * author : NgocNHB
     * function : getDateByShowTime()
     * @param showTime : a string of showTime
     * @return a boolean variable
     * @throws ParseException : throws a ParseException
     */
    public Boolean getDateByShowTime(String showTime) throws ParseException {
        // test
        String fullDateShowTime = "2021-06-24 " + showTime + ":00";
        String sevenDateShowTime = "2021-06-24 17:00:00";

        Date dateOfShowTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(fullDateShowTime);
        Date dateOfSeven = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sevenDateShowTime);

        return dateOfShowTime.before(dateOfSeven);
    }

    /**
     * author : NgocNHB
     * function : getPrice()
     * @param isNormalDate : a boolean variable is a normal Date
     * @param isEarly17 : a boolean variable is early than 17:00
     * @return a price string
     */
    public String getPrice(boolean isNormalDate, boolean isEarly17, int projectionId) {
        int price;

        if (isNormalDate && isEarly17 && projectionId == 1) {
            price = basicPrice;
        } else if ( (!isNormalDate && isEarly17 && projectionId == 1) ||
        (isNormalDate && !isEarly17 && projectionId == 1) ||
        (isNormalDate && isEarly17 && projectionId == 2)) {
            price = 4 * basicPrice / 3;
        } else if ((!isNormalDate && !isEarly17 && projectionId == 1) ||
        (!isNormalDate && isEarly17 && projectionId == 2) ||
        (isNormalDate && !isEarly17 && projectionId == 2)){
            price = 16 * basicPrice / 9;
        } else {
            price = basicPrice * 2;
        }
        return Math.round(price) + "";


    }


    @Override
    public void checkDuplicate(MovieTicket movieTicket, Errors errors) {
        for (MovieTicket movT : findAll()) {
            if (movT.getShowTime().equals(movieTicket.getShowTime())) {
                errors.rejectValue("showTime", "checkDupShowTime");
            }
        }
    }

    @Override
    public MovieTicket findById(Integer id) {
        return movieTicketRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMovieTicket(Integer id) {
        movieTicketRepository.deleteById(id);
    }

    @Override
    public void editMovieTicket(MovieTicket movieTicket) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(movieTicket.getShowDate()));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        ShowTime showTime = showTimeService.findById(movieTicket.getShowTime().getShowTimeId());

        // isNormalDate == true if (dayOfWeek != 5 && dayOfWeek != 6)
        boolean isNormalDate = dayOfWeek != 5 && dayOfWeek != 6;
        boolean isEarly17 = getDateByShowTime(showTime.getShowTime());

        int projectionId = movieTicket.getProjectionType().getProjectionId();


        String priceTicket = getPrice(isNormalDate, isEarly17, projectionId);
        movieTicket.setTicketPrice(priceTicket);
        movieTicketRepository.editMovieTicket(movieTicket.getShowDate(),
                movieTicket.getTicketPrice(),
                movieTicket.getProjectionType().getProjectionId(),
                movieTicket.getRoom().getRoomId(),
                movieTicket.getShowTime().getShowTimeId(),
                movieTicket.getMovieTicketId());


    }

    @Override
    public Page<MovieTicket> findAllMovieTicket(Pageable pageable) {
        return movieTicketRepository.findAll(pageable);
    }

    @Override
    public Page<MovieTicket> searchMovieTicket(Pageable pageable, String q) {
        return movieTicketRepository.searchMovieTicket(pageable,q);
    }

    @Override
    public List<MovieTicket> findAllByDate(String showDate) {
        return movieTicketRepository.findAllMovieTicketByDate(showDate);
    }


}
