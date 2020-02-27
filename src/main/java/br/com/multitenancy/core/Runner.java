package br.com.multitenancy.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Runner {

    @Autowired
    private DatabaseMigration databaseMigration;

    Logger logger = LoggerFactory.getLogger(Runner.class);

    /**
     * When the application is ready, starts the database migration
     */
    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        logger.info("Migration started");
        databaseMigration.run();
        logger.info("Migration finished");
        logger.info("Application Ready!");
    }
}
