package com.tw.apistackbase;

import com.tw.apistackbase.modle.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_expected_employees_when_call_get_all_employees() throws Exception {
        this.mockMvc.perform(get("/employees")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"employee0\",\n" +
                        "        \"age\": 0,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"employee1\",\n" +
                        "        \"age\": 1,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 5000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"employee2\",\n" +
                        "        \"age\": 2,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 10000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_expected_employees_when_call_get_employee() throws Exception {
        this.mockMvc.perform(get("/employees/1")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"employee1\",\n" +
                        "        \"age\": 1,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 5000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_expected_employees_when_calls_get_all_employees() throws Exception {
        this.mockMvc.perform(get("/employees?page=1&pageSize=2")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"employee0\",\n" +
                        "        \"age\": 0,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"employee1\",\n" +
                        "        \"age\": 1,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 5000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_expected_employees_when_call_get_all_employees_given_gender() throws Exception {
        this.mockMvc.perform(get("/employees?gender=Female")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"employee0\",\n" +
                        "        \"age\": 0,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"employee1\",\n" +
                        "        \"age\": 1,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 5000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"employee2\",\n" +
                        "        \"age\": 2,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 10000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_expected_employees_when_call_add_employees_given_employee() throws Exception {
        String json="{\n" +
                "\"id\":3,\n" +
                "\"name\":\"Trump Fake\",\n" +
                "\"age\":18,\n" +
                "\"gender\":\"FeMale\"\n" +
                "}";
        this.mockMvc.perform(post("/employees").contentType("application/json;charset=UTF-8").content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"employee0\",\n" +
                        "        \"age\": 0,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"employee1\",\n" +
                        "        \"age\": 1,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 5000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"employee2\",\n" +
                        "        \"age\": 2,\n" +
                        "        \"gender\": \"Female\",\n" +
                        "        \"salary\": 10000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"Trump Fake\",\n" +
                        "        \"age\": 18,\n" +
                        "        \"gender\": \"FeMale\",\n" +
                        "        \"salary\": 0\n" +
                        "    }\n" +
                        "]"));
    }
}


