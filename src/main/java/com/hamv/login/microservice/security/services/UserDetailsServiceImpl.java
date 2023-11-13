package com.hamv.login.microservice.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamv.login.microservice.entities.Usuarios;
import com.hamv.login.microservice.repository.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private UsuariosRepository userRepository;
  @Autowired
  public void userRepository(UsuariosRepository userRepository){
    this.userRepository=userRepository;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuarios user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

}
