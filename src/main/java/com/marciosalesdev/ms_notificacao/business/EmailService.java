package com.marciosalesdev.ms_notificacao.business;

import com.marciosalesdev.ms_notificacao.business.dto.TarefasDTO;
import com.marciosalesdev.ms_notificacao.infrastructure.exception.EmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Value("${envio.email.remetente}")
    private String envioEmailRemetente;

    @Value("${envio.email.nomeRemetente}")
    private String nomeRemetente;

    public void envioEmail(TarefasDTO tarefaDto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());

            mimeMessageHelper.setFrom(new InternetAddress(envioEmailRemetente, nomeRemetente));
            mimeMessageHelper.setTo(InternetAddress.parse(tarefaDto.getEmailUsuario()));
            mimeMessageHelper.setSubject("Notificação de Tarefa");

            Context context = new Context();
            context.setVariable("nomeTarefa", tarefaDto.getNomeTarefa());
            context.setVariable("dataEvento", tarefaDto.getDataEvento());
            context.setVariable("descricao", tarefaDto.getDescricao());
            String template = templateEngine.process("EmailTemplate", context);
            mimeMessageHelper.setText(template, true);
            javaMailSender.send(message);

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailException("Erro ao envio email ", e.getCause()
            );
        }
    }
}
