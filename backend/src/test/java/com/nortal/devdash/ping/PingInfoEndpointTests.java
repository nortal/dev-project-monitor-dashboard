package com.nortal.devdash.ping;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.nortal.devdash.ping.model.PingInfo;

@RunWith(SpringRunner.class)
@WebMvcTest(PingInfoEndpoint.class)
public class PingInfoEndpointTests {

    /*
     * Loading partial Spring context to test something, kind of bad
     * but it is a RestController we are testing so what else could we do?
     */

    @Autowired
    private MockMvc mvc;
    @MockBean
    private PingInfoUseCase pingInfoUseCase;

    @Test
    public void returnsPingResultIfPresent() throws Exception {
        given(pingInfoUseCase.getPingResult())
                .willReturn(Arrays.asList(pingInfo("Module 1"),
                                          pingInfo("Module 2")));

        mvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].module", is("Module 1")))
                .andExpect(jsonPath("$[1].module", is("Module 2")));

        verify(pingInfoUseCase).getPingResult();
    }

    private PingInfo pingInfo(String module) {
        PingInfo pingInfo = new PingInfo();
        pingInfo.setModule(module);
        return pingInfo;
    }
}
