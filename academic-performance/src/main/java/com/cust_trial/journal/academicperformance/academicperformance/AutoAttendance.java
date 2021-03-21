package com.cust_trial.journal.academicperformance.academicperformance;

import com.cust_trial.journal.academicperformance.academicperformance.Entity.Result;
import com.cust_trial.journal.academicperformance.academicperformance.Entity.ResultType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

@Component(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AutoAttendance {

    public static final String AUTO_ATTENDANCE_MARK = "PRESENT";

    @Autowired
    ResultRepository resultRepository;


    public void process(String lessionId, String personId, String attendanceValue){

        if(lessionId != null && personId != null) {

            Result existedResult = resultRepository.findByLessionIdAndPersonIdAndResultType(
                    lessionId,
                    personId,
                    ResultType.AUTO_ATTENDANCE );

            if(existedResult == null && AUTO_ATTENDANCE_MARK.equals(attendanceValue)){
                Result newResult = new Result( lessionId, personId, ResultType.AUTO_ATTENDANCE);
                resultRepository.save(newResult);
            } else if(existedResult != null) {
                if( ! AUTO_ATTENDANCE_MARK.equals(attendanceValue)){
                    resultRepository.delete(existedResult);
                }
            }
        }
    }
}
