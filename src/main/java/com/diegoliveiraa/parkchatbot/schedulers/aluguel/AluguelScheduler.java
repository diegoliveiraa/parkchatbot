package com.diegoliveiraa.parkchatbot.schedulers.aluguel;

import com.diegoliveiraa.parkchatbot.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AluguelScheduler {

    @Autowired
    private AluguelService aluguelService;

    @Scheduled(cron = "0 0 0 * * ?")
    public  void endAlugueisFinalizados(){
        this.aluguelService.endAlugueisFinalizados();
    }
}
