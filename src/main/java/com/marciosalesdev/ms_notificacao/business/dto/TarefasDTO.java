package com.marciosalesdev.ms_notificacao.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marciosalesdev.ms_notificacao.business.enums.StatusNorificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarefasDTO {

    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNorificacaoEnum statusNorificacaoEnum;

}
