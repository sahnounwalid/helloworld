package tn.enis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.sun.org.apache.xpath.internal.operations.String;

@EnableWebMvc
@ComponentScan(basePackages={"tn.enis"})
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Bean
	public UrlBasedViewResolver viewResolver(){
		UrlBasedViewResolver viewResolver=new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}
	@Bean
	public TilesConfigurer tilesconfigurer()
	{
		TilesConfigurer tilesconfigurer=new TilesConfigurer();
		tilesconfigurer.setDefinitions(new String[] {
				"/WEB-INF/layouts/layouts.xml",
				"/WEB-INF/views/**/views.xml"
		});
		tilesconfigurer.setCheckRefresh(true);
		return tilesconfigurer;
	}
}
