package com.ghosttrio.smartfarmmanager.controller.batch.util.slack;

import com.slack.api.methods.SlackApiException;

import java.io.IOException;

public interface SlackUtil {
    void pdfDaySend(byte[] pdf) throws SlackApiException, IOException;
}
