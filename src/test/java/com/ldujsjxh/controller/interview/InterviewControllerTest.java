package com.ldujsjxh.controller.interview;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @Author Alaskyed
 * @Date 18/10/2020 - 11:14
 * @Version 1.0
 * @Description
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InterviewControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void buildWAC() {
        mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getNextCandidate() {

    }

    @Test
    public void addCandidate() throws Exception {
        RequestBuilder request = post("/java/addCandidate")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("candidateStuId","20205238321");
        String response = mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }
}