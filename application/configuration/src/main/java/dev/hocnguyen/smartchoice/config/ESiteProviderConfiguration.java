package dev.hocnguyen.smartchoice.config;

import dev.hocnguyen.smartchoice.providers.thirdparty.esite.ESiteFunctional;
import dev.hocnguyen.smartchoice.providers.thirdparty.esite.LazadaESite;
import dev.hocnguyen.smartchoice.providers.thirdparty.esite.ShopeeESite;
import dev.hocnguyen.smartchoice.providers.thirdparty.esite.TikiESite;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ESiteProviderConfiguration {

  @Bean
  public ESiteFunctional TikiESite() {
    return new TikiESite();
  }

  @Bean
  public ESiteFunctional LazadaESite() {
    return new LazadaESite();
  }

  @Bean
  public ESiteFunctional ShopeeESite() {
    return new ShopeeESite();
  }

}
