package ru.gb.homework.sem12_homework.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface InterfaceFileGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);

}
