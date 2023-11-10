package org.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class Main {

    private final IMenu menu;
    @Autowired
    public Main(MenuControler menu) {
        this.menu = menu;
    }
    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void execute() throws IOException {
        menu.Loop();
    }
}

