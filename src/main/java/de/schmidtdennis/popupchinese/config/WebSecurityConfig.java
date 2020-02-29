package de.schmidtdennis.popupchinese.config;

import com.okta.spring.boot.oauth.Okta;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
            .antMatchers("/findLessonsByDifficulty", "/getLesson/**", "getVocabularyByLessonId/**", "getDialogsByLessonId/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer().jwt();

            http.cors();

            // force a non-empty response body for 401's to make the response more browser friendly
            Okta.configureResourceServer401ResponseBody(http);

        }
        
}