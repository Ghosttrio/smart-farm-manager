package com.ghosttrio.smartfarmmanager.controller.batch.scheduler;

import com.ghosttrio.smartfarmmanager.controller.batch.job.pdf.config.PdfConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class PdfScheduler {

    private final JobLauncher jobLauncher;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final PdfConfig pdfConfig;
    private final Tasklet pdfDayTasklet;
    private final Tasklet pdfWeekTasklet;

    @Scheduled(cron = "0 0 9 * * *", zone = "Asia/Seoul")
    public void executeDayJob() throws
            JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobRestartException,
            JobInstanceAlreadyCompleteException {
        Step step = pdfConfig.pdfDayStep(jobRepository, pdfDayTasklet, transactionManager);
        Job job = pdfConfig.pdfDayJob(jobRepository, step);
        JobParameters date = new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
        jobLauncher.run(job, date);
    }

    @Scheduled(cron = "0 0 9 * * MON", zone = "Asia/Seoul")
    public void executeWeekJob() throws
            JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobRestartException,
            JobInstanceAlreadyCompleteException {
        Step step = pdfConfig.pdfWeekStep(jobRepository, pdfWeekTasklet, transactionManager);
        Job job = pdfConfig.pdfWeekJob(jobRepository, step);
        JobParameters date = new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
        jobLauncher.run(job, date);
    }

}