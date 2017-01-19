package com.nortal.devdash.ping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.nortal.devdash.ping.model.PingInfo;
import com.nortal.devdash.ping.model.PingStatus;

@RunWith(MockitoJUnitRunner.class)
public class PingInfoUseCaseTests {

    /*
     * Letting Mockito perform injection, better than loading Spring context.
     */

    @InjectMocks
    private PingInfoUseCase pingInfoUseCase;
    @Mock
    private PingInfoService pingInfoService;

    @Test
    public void returnsPingInfosIfPresent() {
        Date checkDate = new Date();
        PingInfo existing = pingInfo("Module", checkDate);
        given(pingInfoService.getAll())
                .willReturn(Arrays.asList(existing));

        List<PingInfo> pingInfos = pingInfoUseCase.getPingResult();
        assertThat(pingInfos).isNotEmpty();

        PingInfo pingInfo = pingInfos.get(0);
        assertThat(pingInfo.getId()).isEqualTo(Long.valueOf(1L));
        assertThat(pingInfo.getModule()).isEqualTo("Module");
        assertThat(pingInfo.getUrl()).isEqualTo("Url");
        assertThat(pingInfo.getStatus()).isEqualTo(PingStatus.OK);
        assertThat(pingInfo.getStatusDetail()).isEqualTo("Status Detail");
        assertThat(pingInfo.getChecked()).isEqualTo(checkDate);
        assertThat(pingInfo.getLastResponded()).isEqualTo(checkDate);
        assertThat(existing.hashCode()).isEqualTo(pingInfo.hashCode());
        assertThat(existing.equals(pingInfo)).isTrue();

        verify(pingInfoService).getAll();
    }

    private PingInfo pingInfo(String module, Date checkDate) {
        PingInfo pingInfo = new PingInfo();
        pingInfo.setId(Long.valueOf(1L));
        pingInfo.setModule(module);
        pingInfo.setUrl("Url");
        pingInfo.setStatus(PingStatus.OK);
        pingInfo.setStatusDetail("Status Detail");
        pingInfo.setChecked(checkDate);
        pingInfo.setLastResponded(checkDate);
        return pingInfo;
    }
}
