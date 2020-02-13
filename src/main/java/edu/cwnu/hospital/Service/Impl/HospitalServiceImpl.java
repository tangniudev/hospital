package edu.cwnu.hospital.Service.Impl;

import edu.cwnu.hospital.Mapper.BloodMapper;
import edu.cwnu.hospital.Mapper.HospitalMapper;
import edu.cwnu.hospital.Mapper.UserMapper;
import edu.cwnu.hospital.Pojo.Blood;
import edu.cwnu.hospital.Pojo.Hospital;
import edu.cwnu.hospital.Pojo.User;
import edu.cwnu.hospital.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;
    @Autowired
    private BloodMapper bloodMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Hospital findById(int h_id) {
        Hospital hospital = hospitalMapper.findById(h_id);
        setobject(hospital);
        return hospital;
    }

    @Override
    public List<Hospital> findByAddress(String address) {
        return hospitalMapper.findByAddress(address);
    }

    @Override
    public List<Hospital> findAll() {
        List<Hospital> hospitals = hospitalMapper.findAll();
        for (Hospital h:hospitals) {
            setobject(h);
        }
        return hospitals;
    }
    void setobject(Hospital hospital){

            List<Blood> bloodList=bloodMapper.findByh_id(hospital.getH_id()   );
            for (Blood blood:bloodList) {
                User user=userMapper.findById(blood.getU_id());
                switch (user.getU_type()){
                    case "A":
                        hospital.setTypeA(hospital.getTypeA()+blood.getCapacity());
                        break;
                    case "B":
                        hospital.setTypeB(hospital.getTypeB()+blood.getCapacity());
                        break;
                    case "AB":
                        hospital.setTypeAB(hospital.getTypeAB()+blood.getCapacity());
                        break;
                    case "O":
                        hospital.setTypeO(hospital.getTypeO()+blood.getCapacity());
                        break;


            }
        }
    }
}
