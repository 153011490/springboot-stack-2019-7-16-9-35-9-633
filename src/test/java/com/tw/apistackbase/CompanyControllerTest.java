package com.tw.apistackbase;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_expected_companies_when_call_get_all_companies() throws Exception {
        this.mockMvc.perform(get("/companies")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"name\": \"company0\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"name\": \"company1\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"name\": \"company2\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_expected_company_when_call_get_company_by_id_given_1() throws Exception {
        this.mockMvc.perform(get("/companies/1")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"company0\",\n" +
                        "    \"employees\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"employee0\",\n" +
                        "            \"age\": 0,\n" +
                        "            \"gender\": \"Female\",\n" +
                        "            \"salary\": 0\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"employee1\",\n" +
                        "            \"age\": 1,\n" +
                        "            \"gender\": \"Female\",\n" +
                        "            \"salary\": 5000\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"employee2\",\n" +
                        "            \"age\": 2,\n" +
                        "            \"gender\": \"Female\",\n" +
                        "            \"salary\": 10000\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }

    @Test
    public void should_return_expected_employees_when_call_get_employees_by_company_id_given_1() throws Exception {
        this.mockMvc.perform(get("/companies/1/employees")).andDo(print())
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
    public void should_return_expected_companies_when_call_get_all_companies_given_page_pageSize() throws Exception {
        this.mockMvc.perform(get("/companies?page=1&pageSize=2")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"company0\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"company1\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_expected_companies_when_call_add_company_given_company() throws Exception {
        String json=" {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"company4\",\n" +
                "        \"employees\": [\n" +
                "            {\n" +
                "                \"id\": 0,\n" +
                "                \"name\": \"employee0\",\n" +
                "                \"age\": 0,\n" +
                "                \"gender\": \"Female\",\n" +
                "                \"salary\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 1,\n" +
                "                \"name\": \"employee1\",\n" +
                "                \"age\": 1,\n" +
                "                \"gender\": \"Female\",\n" +
                "                \"salary\": 5000\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 2,\n" +
                "                \"name\": \"employee2\",\n" +
                "                \"age\": 2,\n" +
                "                \"gender\": \"Female\",\n" +
                "                \"salary\": 10000\n" +
                "            }\n" +
                "        ]\n" +
                "    }";
        this.mockMvc.perform(post("/companies").content(json).contentType("application/json;chaset=UTF-8")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"company0\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"company1\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"company2\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 4,\n" +
                        "        \"name\": \"company4\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_expected_companiy_when_call_update_company_given_company() throws Exception {
        String json="{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"company0\",\n" +
                "    \"employees\": [\n" +
                "        {\n" +
                "            \"id\": 0,\n" +
                "            \"name\": \"employee0\",\n" +
                "            \"age\": 0,\n" +
                "            \"gender\": \"Female\",\n" +
                "            \"salary\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"employee1\",\n" +
                "            \"age\": 1,\n" +
                "            \"gender\": \"Female\",\n" +
                "            \"salary\": 5000\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"employee2\",\n" +
                "            \"age\": 2,\n" +
                "            \"gender\": \"Female\",\n" +
                "            \"salary\": 10000\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        this.mockMvc.perform(put("/companies/1").content(json).contentType("application/json;chaset=UTF-8")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"company0\",\n" +
                        "    \"employees\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"employee0\",\n" +
                        "            \"age\": 0,\n" +
                        "            \"gender\": \"Female\",\n" +
                        "            \"salary\": 0\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"employee1\",\n" +
                        "            \"age\": 1,\n" +
                        "            \"gender\": \"Female\",\n" +
                        "            \"salary\": 5000\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"employee2\",\n" +
                        "            \"age\": 2,\n" +
                        "            \"gender\": \"Female\",\n" +
                        "            \"salary\": 10000\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }

    @Test
    public void should_return_expected_company_when_call_delete_company_given_1() throws Exception {
        this.mockMvc.perform(delete("/companies/1")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"company1\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"company2\",\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"employee0\",\n" +
                        "                \"age\": 0,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 0\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"employee1\",\n" +
                        "                \"age\": 1,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 5000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"employee2\",\n" +
                        "                \"age\": 2,\n" +
                        "                \"gender\": \"Female\",\n" +
                        "                \"salary\": 10000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

}
