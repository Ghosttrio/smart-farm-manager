package com.ghosttrio.smartfarmmanager.controller.batch.job.pdf.config;

import com.ghosttrio.smartfarmmanager.controller.batch.job.pdf.service.CreateMemberDayActivityPdfService;
import com.ghosttrio.smartfarmmanager.controller.batch.util.slack.SlackUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@RequiredArgsConstructor
public class PdfConfig {

    private final SlackUtil slackUtil;

    @Bean
    public Job pdfDayJob(JobRepository jobRepository, Step pdfDayStep) {
        return new JobBuilder("pdfDayJob", jobRepository)
                .start(pdfDayStep)
                .build();
    }

    @Bean
    public Step pdfDayStep(JobRepository jobRepository, Tasklet pdfDayTasklet, PlatformTransactionManager transactionManager) {
        return new StepBuilder("pdfDayStep", jobRepository)
                .tasklet(pdfDayTasklet, transactionManager)
                .build();
    }

    @Bean
    public Tasklet pdfDayTasklet() {
        return ((contribution, chunkContext) -> {
            byte[] pdf = null;
            slackUtil.pdfDaySend(pdf);
            return RepeatStatus.FINISHED;
        });
    }

}
