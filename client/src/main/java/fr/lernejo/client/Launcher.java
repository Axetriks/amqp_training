package fr.lernejo.client;

import java.io.IOException;
import java.util.Scanner;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


@SpringBootApplication
public class Launcher {
    

    public static void main(String[] args) throws IOException {
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.ERROR);
        String input = new String();
        Scanner scanner = new Scanner(System.in);
        ApplicationContext send = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate test = send.getBean(RabbitTemplate.class);
        System.out.println("Input a message, we will send it for you (q for quit)");
        input = scanner.nextLine();
        while(!input.equals("q")){
            
            test.convertAndSend("", "chat_messages" , input);
            System.out.println("Input a message, we will send it for you (q for quit)");
            input = scanner.nextLine();
            
        }
        scanner.close();
        ((AnnotationConfigApplicationContext)send).close();
    }
}
