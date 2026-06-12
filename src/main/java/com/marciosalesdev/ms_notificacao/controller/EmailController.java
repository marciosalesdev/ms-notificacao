package com.marciosalesdev.ms_notificacao.controller;

import com.marciosalesdev.ms_notificacao.business.EmailService;
import com.marciosalesdev.ms_notificacao.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    public final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> enviarEmail(@RequestBody TarefasDTO tarefasDTO){
        emailService.envioEmail(tarefasDTO);
        return ResponseEntity.ok().build();
    }
}
