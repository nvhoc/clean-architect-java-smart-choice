package dev.hocnguyen.smartchoice.config;

import dev.hocnguyen.smartchoice.providers.thirdparty.esite.ESiteFunctional;
import dev.hocnguyen.smartchoice.providers.thirdparty.product.GetListByThirdParty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdPartyProviderConfiguration {

  @Bean
  public GetListByThirdParty getListByThirdParty(ESiteFunctional... eSites) {
    return new GetListByThirdParty(eSites);
  }
}
