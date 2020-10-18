package com.ldujsjxh.controller.interview;

import junit.framework.TestCase;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @Author Alaskyed
 * @Date 27/09/2020 - 15:35
 * @Version 1.0
 * @Description
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InterviewerControllerTest extends TestCase {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void buildWAC() {
        mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetCandidatesByDepartment() throws Exception {

        RequestBuilder request = post("/java/getCondidatesByDepartment/硬件部") .contentType(MediaType.APPLICATION_JSON_UTF8);
        String response = mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    @Test
    public void testGetCandidateDetail() throws Exception {
        RequestBuilder request = post("/java/getCandidateDtail")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("candidateId","2");
        String response = mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    @Test
    public void getCandidateDetail() throws Exception {
        RequestBuilder request = post("/java/interviewAdmin")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("adminPasswd","jsjxh0");
        String response = mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);

    }

    @Test
    public void candidateScore() throws Exception {
        RequestBuilder request = post("/java/candidateScore")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("candidateId","20")
                .param("score","9");
        String response = mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);

    }
}