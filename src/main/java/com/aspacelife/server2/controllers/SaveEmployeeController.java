//package com.aspacelife.server2.controllers;
//
//import io.vertx.core.Vertx;
//import io.vertx.core.eventbus.DeliveryOptions;
//import io.vertx.core.eventbus.Message;
//import io.vertx.core.json.JsonObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//
//@Slf4j
//@Controller
//public class SaveEmployeeController {
//
//    private final Vertx vertx;
//
//    public SaveEmployeeController(Vertx vertx) {
//        this.vertx = vertx;
//        vertx.eventBus().consumer("save.employee.controller", this::saveEmployeeRequest);
//    }
//
//    private void saveEmployeeRequest(Message<Object> message) {
//        log.info("Forwarding save employee request: {}", message.body());
//        vertx.eventBus().send("save.employee.verticle", message.body(), new DeliveryOptions().setSendTimeout(1000));
//        message.reply(new JsonObject().put("status", "forwarded"));
//    }
//}
