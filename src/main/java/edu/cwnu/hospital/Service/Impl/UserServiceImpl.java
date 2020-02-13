package edu.cwnu.hospital.Service.Impl;


import edu.cwnu.hospital.Mapper.UserMapper;
import edu.cwnu.hospital.Pojo.User;
import edu.cwnu.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(int number, int password) {
       User user= userMapper.findBynumber(number);
       if (password!=user.getU_password()){
          return null;
       }return user;

    }

    @Override
    public void updateAll(User user) {
        userMapper.updateAll(user);
    }

    @Override
    public User fingById(int id) {
        return userMapper.findById(id);
    }
}
