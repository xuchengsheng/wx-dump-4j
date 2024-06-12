package com.xcs.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author xcs
 * @date 2023年12月21日 17时02分
 **/
@SpringBootApplication
@EnableTransactionManagement
public class WxDumpApplication {

    public static void main(String[] args) throws UnknownHostException {
        long startTime = System.currentTimeMillis();
        ConfigurableApplicationContext context = SpringApplication.run(WxDumpApplication.class, args);
        long endTime = System.currentTimeMillis();

        String port = context.getEnvironment().getProperty("server.port", "8080");
        String contextPath = context.getEnvironment().getProperty("server.servlet.context-path", "");
        String localHostAddress = InetAddress.getLocalHost().getHostAddress();

        String localUrl = "http://localhost:" + port + contextPath;
        String networkUrl = "http://" + localHostAddress + ":" + port + contextPath;

        System.out.println("DONE successfully in " + (endTime - startTime) + "ms");
        System.out.println("Time: " + new Date());
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║ App listening at:                                  ║");
        System.out.println("║    > Local:   " + localUrl + "                      ");
        System.out.println("║    > Network: " + networkUrl + "                    ");
        System.out.println("║                                                    ║");
        System.out.println("║ Now you can open browser with the above addresses↑ ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
    }
}
