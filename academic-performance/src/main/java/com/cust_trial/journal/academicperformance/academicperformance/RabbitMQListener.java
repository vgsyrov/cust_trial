package com.cust_trial.journal.academicperformance.academicperformance;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQListener {


    @RabbitListener(queuesToDeclare = @Queue(name = "${sc.attendance.queue.name}", durable = "true"))
    //@RabbitListener(queuesToDeclare = @Queue(name = "queue1", durable = "true"))
    public void processIncomingMessage(String msg){
        System.out.println("ScheduleCalendar incoming message: " +msg);
    }
}
