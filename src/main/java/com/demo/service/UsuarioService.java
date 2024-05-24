package com.demo.service;

import com.demo.entity.Usuario;
import com.demo.repository.GestorUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UsuarioService")
public class UsuarioService implements UserDetailsService {

    @Autowired
    @Qualifier("gestor")
    private GestorUsuario gestor;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = gestor.findByUsuario(username);
        return new User(user.getUsuario(), user.getContrasena(), user.isActivo() , user.isActivo(),
                user.isActivo(), user.isActivo(), builGrantes(user.getRol()) );
    }

    public List<GrantedAuthority> builGrantes(byte rol){
        String[] roles = {"LECTOR", "USUARIO", "ADMIN"};
        List<GrantedAuthority> auths = new ArrayList<>();
        for (int i = 0; i < rol; i++) {
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }
        return auths;
    }
}
