package ru.geekbrains.Seminars.Seminar4.webService;

public class WebService {
    HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void getHTTP(String url) {
        System.out.println(httpClient.getHTTPRequest(url));
    }
}
