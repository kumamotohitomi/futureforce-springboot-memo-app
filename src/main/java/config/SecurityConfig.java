package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class SecurityConfig {
 @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder(); //パスワード暗号化
  }

 @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/admin/signup", "/admin/signin","/css/**", "/js/**").permitAll()
            .anyRequest().authenticated()
    ).formLogin(login -> login
            .loginPage("/admin/signin")//ログインURL
            .loginProcessingUrl("/admin/signin")//ログインボタン押したときの接続先
            .failureUrl("/admin/signin?error=true")//失敗したら
            .defaultSuccessUrl("/admin/memos", true)//成功したら
            .usernameParameter("email")//メールでログイン
            .passwordParameter("password")//パスワードログイン
    ).logout(logout -> logout
            .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
            .logoutSuccessUrl("/admin/signin?logout")
            .permitAll()
    );
    return http.build();
   }
}

