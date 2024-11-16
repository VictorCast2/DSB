package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Repository.ContactUsRepository;
import lombok.Data;

@Data
@Service
public class ContactUsServices {

    @Autowired
    private ContactUsRepository contactUsRepository;

    

}