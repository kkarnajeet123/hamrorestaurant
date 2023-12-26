package com.hamrorestaurant.hamrorestaurant.service.employeeService;

import com.hamrorestaurant.hamrorestaurant.exception.CommonException;
import com.hamrorestaurant.hamrorestaurant.model.restCall.EmployeeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private RestTemplate restTemplate;

    public static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
//    public EmployeeInfo getAllEmployee(){
//        ResponseEntity<EmployeeInfo> response= null;
//        String url="https://dummy.restapiexample.com/api/v1/employees";
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("Accept", "/");
//        HttpEntity<Object> httpEntity = new HttpEntity(httpHeaders);
//
//        logger.info("Calling employee rest call ");
//        try {
//            response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, EmployeeInfo.class);
//            logger.info("Getting response from employee api " + response);
//        }catch(Exception e){
//                throw new CommonException("Error getting api response", e);
//        }
//        EmployeeInfo empInfo =  (response!=null) ? response.getBody():null;
//        return empInfo;
//    }

    @Override
    public EmployeeInfo getAllEmployee() {
        ResponseEntity<EmployeeInfo> response= null;
        String url="https://dummy.restapiexample.com/api/v1/employees";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "/");
        HttpEntity<Object> httpEntity = new HttpEntity(httpHeaders);

        logger.info("Calling employee rest call ");
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, EmployeeInfo.class);
            logger.info("Getting response from employee api " + response);
        }catch(Exception e){
                throw new CommonException("Error getting api response", e);
        }
        EmployeeInfo empInfo =  (response!=null) ? response.getBody():null;
        return empInfo;
    }

    @Override
    public String updateEmployeeInfo(EmployeeInfo employeeInfo, String employeeId) {
        return null;
    }

    @Override
    public String saveEmployeeInfo(EmployeeInfo employeeInfo) {
        return null;
    }

    @Override
    public String deleteEmployeeInfo(String employeeId) {
        return null;
    }

    @Override
    public EmployeeInfo getEmployeeById(String employeeId) {
        return null;
    }
}
