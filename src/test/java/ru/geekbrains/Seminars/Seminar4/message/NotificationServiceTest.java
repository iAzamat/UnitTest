package ru.geekbrains.Seminars.Seminar4.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void messgeServiceTest(){
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        messageService.sendMessage("Hello", "Vasia");

        verify(messageService, times(1)).sendMessage("Hello", "Vasia");
    }
}