package edu.cwnu.hospital.Service;

import edu.cwnu.hospital.Pojo.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HospitalService {
    Hospital findById(int h_id);
    List<Hospital> findByAddress(String h_address);
    List<Hospital> findAll();
}
