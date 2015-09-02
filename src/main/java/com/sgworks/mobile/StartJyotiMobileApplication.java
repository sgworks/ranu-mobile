package com.sgworks.mobile;

import com.sgworks.mobile.configurations.SpringProfiles;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import static java.util.Collections.singletonMap;

@SpringBootApplication
public class StartJyotiMobileApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartJyotiMobileApplication.class);

    @Autowired
    private Environment env;

    @PostConstruct
    public void initApplication() throws IOException {
        if (env.getActiveProfiles().length == 0) {
            LOGGER.warn("No Spring profile configured, running with default configuration");
        } else {
            LOGGER.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
        }
    }

    public static void main(String[] args)  throws UnknownHostException {
        //SpringApplication.run(StrartJyotiMobileApplication.class, args);
        SpringApplication app = new SpringApplication(StartJyotiMobileApplication.class);
        app.setShowBanner(false);
        app.setDefaultProperties(singletonMap("spring.config.name", "application"));

        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

        // Check if the selected profile has been set as argument.
        // if not the development profile will be added
        addDefaultProfile(app, source);
        Environment env = app.run(args).getEnvironment();
        LOGGER.info("Access URLs:\n----------------------------------------------------------\n\t"
                        + "Local: \t\thttp://localhost:{}{}\n\t"
                        + "External: \thttp://{}:{}{}\n----------------------------------------------------------",
                env.getProperty("server.port"),
                env.getProperty("server.context-path"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.context-path"));
    }

    /**
     * Set a default profile if it has not been set
     */
    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active")) {
            app.setAdditionalProfiles(SpringProfiles.LOCAL);
        }
    }
}
