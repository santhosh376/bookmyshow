package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.BookTicketRequestDto;
import org.example.bookmyshow.dtos.BookTicketResponseDto;
import org.example.bookmyshow.model.Booking;
import org.example.bookmyshow.model.Movie;
import org.example.bookmyshow.repository.MovieRepository;
import org.example.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "ticket")
public class TicketController {

    private final BookingService bookingService;

    @Autowired
    public TicketController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(path = "/book")
    public @ResponseBody BookTicketResponseDto bookTicket(@RequestBody BookTicketRequestDto requestDto) {

        System.out.println(requestDto);

        Booking booking = bookingService.bookMovie(requestDto.getShowSeatIds());
        return BookTicketResponseDto.builder()
                .bookingId(booking.getId())
                .amount(booking.getAmount())
                .theatreName(booking.getShow().getScreen().getTheatre().getName())
                .build();
    }

//    @PostMapping(path = "/book")
//    public String Ticket(){
//        System.out.println("Request hit the server");
//        return "I can see post beans";
//    }

    @GetMapping(path = "/get")
    @ResponseStatus(HttpStatus.OK)
    public String getTicket() {
        System.out.println("Request hit the server - 2");
        return "Get request ran";
    }
}