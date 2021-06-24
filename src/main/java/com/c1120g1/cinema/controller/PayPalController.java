package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.common.PaypalPaymentIntent;
import com.c1120g1.cinema.common.PaypalPaymentMethod;
import com.c1120g1.cinema.service.impl.PaypalServiceImpl;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/paypal")
public class PayPalController {

    public static final String URL_PAYPAL_SUCCESS = "/pay/success";
    public static final String URL_PAYPAL_CANCEL = "/pay/cancel";

    public final String cancelUrl = "http://localhost:4200/confirm";
    public final String successUrl = "http://localhost:4200/confirm/success";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalServiceImpl paypalService;

    @PostMapping("/pay")
    public String pay(@RequestParam(name = "price") double price) {

        try {
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
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }


    @GetMapping(URL_PAYPAL_CANCEL)
    public String cancelPay() {
        return "http://localhost:4200/api/confirm";
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
        return "redirect:/";
    }
}
