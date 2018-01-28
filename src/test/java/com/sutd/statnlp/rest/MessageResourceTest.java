package com.sutd.statnlp.rest;


import com.sutd.statnlp.InitializerApplication;
import com.sutd.statnlp.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InitializerApplication.class)
public class MessageResourceTest {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    private MockMvc restMessageMockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MessageResource messageResource = new MessageResource(messageService);
        this.restMessageMockMvc = MockMvcBuilders.standaloneSetup(messageResource)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Test
    public void getAllMessages() throws Exception {

        // Get all the messageList
        restMessageMockMvc.perform(get("/api/messages"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
