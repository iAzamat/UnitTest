package ru.geekbrains.Seminars.Seminar4.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DataProcessorTest {
    @Test
    void dataProcessorTest(){
        Database db = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(db);
        when(db.query(anyString())).thenReturn(Arrays.asList("string1", "string2"));

        List<String> result = db.query("string");

        verify(db).query("string");
        assertThat(result).isNotNull().asList().hasSize(2).isEqualTo(Arrays.asList("string1", "string2"));
    }
}