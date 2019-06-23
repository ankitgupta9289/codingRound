package com.testvagrant.codingRound.logger;

import org.slf4j.LoggerFactory;

public class Logger {
    static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    public static void logPass(String log) {
        logger.info(log);
    }
}
