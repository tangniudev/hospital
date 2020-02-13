package edu.cwnu.hospital.Service;

import edu.cwnu.hospital.Pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User login(int number,int password);

    void updateAll(User user);

    User fingById(int is);
}
