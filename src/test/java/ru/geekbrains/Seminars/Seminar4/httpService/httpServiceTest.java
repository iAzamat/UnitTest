package ru.geekbrains.Seminars.Seminar4.httpService;

import org.junit.jupiter.api.Test;
import ru.geekbrains.Seminars.Seminar4.webService.HttpClient;
import ru.geekbrains.Seminars.Seminar4.webService.WebService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class httpServiceTest {

    @Test
    void httpRequestTest(){
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.getHTTPRequest(anyString())).thenReturn("Site");
        String url = "www.internet.net";

        webService.getHTTP(url);

        verify(httpClient, times(1)).getHTTPRequest(anyString());
    }
}
