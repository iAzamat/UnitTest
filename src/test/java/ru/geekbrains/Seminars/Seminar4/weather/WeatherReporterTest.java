package ru.geekbrains.Seminars.Seminar4.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

    @Test
    void weatherTest(){
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);

        when(weatherService.getCurrentTemperature()).thenReturn(25);
        String report = weatherReporter.generateReport();
        verify(weatherService, times(1)).getCurrentTemperature();
        assertThat(report).isEqualTo("Текущая температура: 25 градусов.");
    }

}