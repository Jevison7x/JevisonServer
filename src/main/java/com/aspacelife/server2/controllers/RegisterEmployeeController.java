package com.aspacelife.server2.controllers;

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.api.service.RouteToEBServiceHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
@RequiredArgsConstructor
public class RegisterEmployeeController {


    /*@Autowired
    public RegisterEmployeeController(Router router, EventBus eventBus) {
        router.post("/register")
                .handler(this::validateRequest)
                .handler(this::customizeRequest)
                .handler(RouteToEBServiceHandler.build(eventBus, "save.employee.controller", "save",
                        new DeliveryOptions().setSendTimeout(1000)));
    }

    private void validateRequest(RoutingContext rc) {

        log.info("Validating request");
        rc.next();
    }

    private void customizeRequest(RoutingContext rc) {
        log.info("Customizing request");
        rc.next();
    }*/


    @Autowired
    public RegisterEmployeeController(Router router, EventBus eventBus) {
        router.post("/register")
                .handler(this::validateRequest)
                .handler(this::customizeRequest)
                .handler(RouteToEBServiceHandler.build(eventBus, "save.employee", "saveEmployee",
                        new DeliveryOptions().setSendTimeout(1000)));
    }

    private void validateRequest(RoutingContext rc) {

        log.info("Validating request");
        rc.next();
    }

    private void customizeRequest(RoutingContext rc) {
        log.info("Customizing request");
        rc.next();
    }
}