package com.aspacelife.server2.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.api.service.WebApiServiceGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class SaveEmployeeVerticle extends AbstractVerticle {


    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer("save.employee", this::saveEmployees);
    }

    private void saveEmployees(Message<Object> objectMessage) {
        JsonObject jsonObject = (JsonObject) objectMessage.body();
        performTask(jsonObject, resultHandler -> {
            if (resultHandler.succeeded()) {
                log.info("Saved employee: {}", jsonObject);
                JsonObject entries = resultHandler.result().toJson();
                objectMessage.reply(entries);
            } else {
                log.error("Failed to save employee: {}", jsonObject, resultHandler.cause());
            }
        });
    }

    private void performTask(JsonObject body, Handler<AsyncResult<ServiceResponse>> resultHandler) {
        //Perform your task and send the result
        resultHandler.handle(
                Future.succeededFuture(
                        ServiceResponse.completedWithJson(body)
                )
        );
    }

    boolean saveEmployeeToDb(JsonObject employee) {
        return true;
    }
}
