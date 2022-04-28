package com.example.clinicaOdontologica2.Service;


import com.example.clinicaOdontologica2.Model.Rol;
import com.example.clinicaOdontologica2.Model.User;
import com.example.clinicaOdontologica2.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.getUserByName(userName);

        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        for(Rol rol: user.get().getRoles()) //lleno la autorizacion con los roles que tiene el usuario
        {
            GrantedAuthority autorizacion = new SimpleGrantedAuthority(rol.getName());
            autorizaciones.add(autorizacion);

        }

        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(user.get().getName(),"{noop}" + user.get().getPassword(),true, true, true,true,autorizaciones);
        return userDetail;
    }
}
