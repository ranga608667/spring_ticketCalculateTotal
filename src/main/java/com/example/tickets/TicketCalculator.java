package com.example.tickets;

import model.ResultResponse;
import model.Ticket;
import model.TicketsRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketCalculator {

    @PostMapping("/flights/tickets/total")
    public ResultResponse priceCalculator(@RequestBody TicketsRequest request){
        ResultResponse totalPrice=new ResultResponse();
        int price=0;

      TicketsRequest newRequest= new TicketsRequest();
      newRequest=request;
      List<Ticket> ticketsList=new ArrayList<>();
     ticketsList.addAll(newRequest.getTickets());
//       // request.itinerary.length;
       for (int i = 0; i < ticketsList.size(); i++) {
           price += ticketsList.get(i).getPrice();
        }
        totalPrice.setResult(price);
        return totalPrice;

    }
}
