package com.example.event_registration.controller;

import com.example.event_registration.entity.Event;
import com.example.event_registration.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventRepository eventRepository;

    @Test
    void shouldReturnAllEvents() throws Exception {
        Event event = new Event(null, null, null, null, null);
        event.setId(1L);
        event.setName("Test Event");
        event.setEventDate(LocalDate.now());
        event.setLocation("Test Location");

        List<Event> events = Arrays.asList(event);
        given(eventRepository.findAll()).willReturn(events);

        mockMvc.perform(get("/api/events"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value(event.getName()));
    }
}
