package proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import proxy.config.AppV1Config;
import proxy.config.AppV2Config;
import proxy.config.v1_proxy.ConcreteProxyConfig;
import proxy.config.v1_proxy.InterfaceProxyConfig;
import proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import proxy.config.v5_autoproxy.AutoProxyConfig;
import proxy.config.v6_aop.AopConfig;
import proxy.trace.logtrace.LogTrace;
import proxy.trace.logtrace.ThreadLocalLogTrace;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
//@Import(AutoProxyConfig.class)
@Import(AopConfig.class)
@SpringBootApplication(scanBasePackages = "proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
