package com.nortal.devdash.ping;

import static com.mmnaseri.utils.spring.data.dsl.factory.RepositoryFactoryBuilder.builder;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nortal.devdash.ping.model.PingInfo;

public class PingInfoServiceTests {

    /*
     * Not using Spring context at all, the best scenario possible.
     * Using open-source Spring JPA Data mock framework to partially mock our repository,
     * which is actually allowing us to test even more than we need.
     * As we aren't writing any implementation code to queries, we don't need to test persistence layer.
     * That is already tested by Spring source base.
     */

    private PingInfoService notificationService;
    private PingInfoRepository notificationRepository;

    @Before
    public void setUp() throws Exception {
        notificationRepository = builder().mock(PingInfoRepository.class);
        notificationService = new PingInfoServiceImpl(notificationRepository);
    }

    @Test
    public void returnsPingInfosIfPresent() {
        notificationRepository.save(pingInfo("Module"));
        List<PingInfo> pingInfos = notificationService.getAll();
        assertThat(pingInfos).isNotEmpty();

        PingInfo pingInfo = pingInfos.get(0);
        assertThat(pingInfo.getId()).isNotNull();
        assertThat(pingInfo.getModule()).isEqualTo("Module");
    }

    private PingInfo pingInfo(String module) {
        PingInfo pingInfo = new PingInfo();
        pingInfo.setModule(module);
        return pingInfo;
    }
}
