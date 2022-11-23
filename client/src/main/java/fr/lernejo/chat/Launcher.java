package fr.lernejo.chat;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate rabbitTemplate  = ctx.getBean(RabbitTemplate.class);

        String outputMessage = "Input a message, we will sent it for you (q for quit)";
        System.out.println(outputMessage);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("q")) {
                System.out.println("Bye");
                break;
            }
            rabbitTemplate.convertAndSend("chat_messages", input);
            System.out.println("Message sent. " + outputMessage);
        }
    }
}
