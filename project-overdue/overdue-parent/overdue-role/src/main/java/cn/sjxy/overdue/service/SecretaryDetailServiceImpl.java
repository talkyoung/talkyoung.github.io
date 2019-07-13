package cn.sjxy.overdue.service;
/**
 * @author 陶杨
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.sjxy.overdue.pojo.Secretary;

public class SecretaryDetailServiceImpl implements UserDetailsService {
    @Autowired
    private SecretaryService secretaryService;

    private String username;

    public void setSecretaryService(SecretaryServiceImpl secretaryService) {
        this.secretaryService = secretaryService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        this.username = username;
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_SECRETARY"));
        List<Secretary> secretaryList = secretaryService.findOneByName(username);
        Secretary secretary = secretaryList.get(0);
        if (secretary != null) {
            return new User(username, secretary.getSecPassword(), grantedAuths);
        } else {
            return null;
        }
    }
    public String getUsername() {
        return username;
    }
}
