package com.taller.votos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taller.votos.daos.AdminDao;
import com.taller.votos.entities.AdminEntity;

@Service("userDetailsService")
public class AdminService implements UserDetailsService {
    
    @Autowired
    private AdminDao adminDao;

    @Transactional()
    public List<AdminEntity> list() {
        return (List<AdminEntity>) adminDao.findAll();
    }

    @Transactional()
    public AdminEntity search(AdminEntity admin) {
        return adminDao.findById(admin.getId()).orElse(null);
    }

    @Transactional()
    public void save(AdminEntity admin) {
        adminDao.save(admin);
    }

    @Transactional()
    public void delete(AdminEntity admin) {
        adminDao.delete(admin);
    }

    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AdminEntity admin = adminDao.findByEmail(email);
        
        if (admin == null) {
            throw new UsernameNotFoundException(email);
        }

        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        roles.add(new SimpleGrantedAuthority("ADMIN"));

        return new User(admin.getEmail(), admin.getPassword(), roles);
    }
}