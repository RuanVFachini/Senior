package com.senior.teste.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class Utils {

    public Utils(){
    }

    public int[] getDiasUtilsFds(Date dataIni,Date dataFim){
        int[] resultado = new int[2];
        resultado[0] = 0;
        resultado[1] = 0;

        Calendar cal = Calendar.getInstance();
        cal.setTime(dataIni);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dataFim);

        while(cal.get(Calendar.DAY_OF_YEAR) >= cal2.get(Calendar.DAY_OF_YEAR)){
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                resultado[1]++;
            }else{
                resultado[0]++;
            }
            cal.add(cal.DAY_OF_MONTH, +1);
        }

        return resultado;
    }

}
