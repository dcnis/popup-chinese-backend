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
            .csrf().disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/getVocabularyByLessonId/**").authenticated()
            // .anyRequest().authenticated()
            // .authorizeRequests()
            // .antMatchers("/findLessonsByDifficulty", "/getLesson/**", "getVocabularyByLessonId/**", "getDialogsByLessonId/**").permitAll()
            // .anyRequest().permitAll();
            .and()
            .oauth2ResourceServer().jwt();

            http.cors();

            // force a non-empty response body for 401's to make the response more browser friendly
            // Okta.configureResourceServer401ResponseBody(http);

        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        }
        
}