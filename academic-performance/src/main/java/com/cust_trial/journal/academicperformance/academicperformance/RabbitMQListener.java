package com.cust_trial.journal.academicperformance.academicperformance;

import com.cust_trial.journal.academicperformance.academicperformance.Entity.Result;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQListener {

    @Autowired
    AutoAttendance autoAttendance;

    @RabbitListener(queuesToDeclare = @Queue(name = "${sc.attendance.queue.name}", durable = "true"))
    public void processIncomingMessage(EventAttendanceFactMessageJson msg){
        autoAttendance.process(msg.getLessonId(), msg.getPersonId(), msg.getAttendanceFact());
    }
}
