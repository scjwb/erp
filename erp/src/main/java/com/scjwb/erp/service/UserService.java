package com.scjwb.erp.service;

import com.scjwb.erp.dao.RolesMapper;
import com.scjwb.erp.dao.UserMapper;
import com.scjwb.erp.model.Roles;
import com.scjwb.erp.model.User;
import com.scjwb.erp.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria().andNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);

        List<Roles> rolesList = rolesMapper.selectRolesByUserId(user.getId());
        user.setRolesList(rolesList);

        return user;
    }
}
