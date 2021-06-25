package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.common.PaypalPaymentIntent;
import com.c1120g1.cinema.common.PaypalPaymentMethod;
import com.c1120g1.cinema.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/paypal")
public class PayPalController {

    public static final String URL_PAYPAL_SUCCESS = "/pay/success";
    public static final String URL_PAYPAL_CANCEL = "/pay/cancel";

    public final String cancelUrl = "http://localhost:4200/confirm";
    public final String successUrl = "http://localhost:4200/admin";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;

    @PostMapping("/pay")
    public String pay(HttpServletRequest request, @RequestBody Double price) {

        try {
            System.err.println("PRICE : "+price); //test
            Payment payment = paypalService.createPayment(
                    price,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    return successUrl;
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }


    @GetMapping(URL_PAYPAL_CANCEL)
    public String cancelPay() {
        return cancelUrl;
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public String successPay(@RequestParam("paymentId") String paymentId,
                             @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return successUrl;
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return successUrl;
    }
}
