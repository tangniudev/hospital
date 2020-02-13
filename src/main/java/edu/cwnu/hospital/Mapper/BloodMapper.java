package edu.cwnu.hospital.Mapper;

import edu.cwnu.hospital.Pojo.Blood;
import edu.cwnu.hospital.utils.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodMapper {
    Blood findById(int b_id);
   List<Blood> findByPage(int start);
    List<Blood> findAll();


    List<Blood> findMyself(int u_id);
     void insertone (Blood blood);

    void updateState(Blood blood);

    void deleteById(int b_id);

    List<Blood> selectByState(String state);

    List<Blood> findByh_id(int h_id);
}
