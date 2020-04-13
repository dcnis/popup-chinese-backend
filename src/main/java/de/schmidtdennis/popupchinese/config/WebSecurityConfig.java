package de.schmidtdennis.popupchinese.config;

import com.okta.spring.boot.oauth.Okta;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer().jwt();
            http.cors().and().csrf().disable();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers(HttpMethod.POST, "/findLessonsByDifficulty")
            .antMatchers(HttpMethod.GET, "/getLesson/**")
            .antMatchers(HttpMethod.GET, "/getDialogsByLessonId/**")
            .antMatchers(HttpMethod.GET, "/getVocabularyByLessonId/**")
            .antMatchers(HttpMethod.GET, "/searchLesson?**");
        }
        
}