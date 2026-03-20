package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lesson.memo.model.Admin;
import com.lesson.memo.repository.AdminRepository;

//ユーザーが入力したアドレスをリポジトリと照合
public class AdminDetailService implements UserDetailsService {
	@Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // ① 名簿からアドレス検索（いなければエラーを出す）
        Admin admin = adminRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("見つかりません"));

        // ② 見つかった方の「メール」「パスワード」「権限」をセットにしてSpringに渡す
        return new User(admin.getEmail(), admin.getPassword(), 
            AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
    }
}
