package util;

import jodd.datetime.JDateTime;

/**
 * Created by reeco_000 on 2015/4/19.
 */
public class DataConvert {

    public static Boolean isrunYear(Integer year){
        Boolean flag = false;
        if((year)%400==0||(year%4==0&&year%100!=0)){
            flag = true;
        }
        return flag;
    }

    public static Integer remainDay(JDateTime now,JDateTime returnData){

        Integer check = now.compareDateTo(returnData);

        switch (check){
            case 1:
                //已超期
                return -1;
            case 0:
                //今天需要还
                return 0;
            case -1:
                Integer year = returnData.getYear() - now.getYear();
                if(year==0){
                   return returnData.getDayOfYear()- now.getDayOfYear();
                }
                else {
                    Boolean temp = isrunYear(returnData.getYear());
                    Integer returnYearDay;
                    if(temp)
                        returnYearDay = 365;
                    else
                        returnYearDay = 365;

                    return returnData.getDayOfYear()+returnYearDay-now.getDayOfYear();
                }

        }
        //出错
        return -2;
    }
}
