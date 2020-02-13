package edu.cwnu.hospital.Mapper;

import edu.cwnu.hospital.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    User findBynumber(int number);

    void updateAll(User user);

    User findById(int id);


}
