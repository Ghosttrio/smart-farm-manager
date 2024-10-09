package com.ghosttrio.smartfarmmanager.controller.batch.util.slack;

import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class SlackUtilImpl implements SlackUtil {

    private final SlackProperties slackProperties;
    private final MethodsClient methodsClient;

    @Override
    public void pdfDaySend(byte[] pdf) throws SlackApiException, IOException {
        methodsClient.filesUpload(r -> r
                .token(slackProperties.getToken())
                .initialComment("")
                .channels(Arrays.asList(slackProperties.getChannel()))
                .filetype("pdf")
                .filename(" 일일 리포트.pdf")
                .fileData(pdf)
        );
    }
}
