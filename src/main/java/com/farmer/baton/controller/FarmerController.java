package com.farmer.baton.controller;

import com.farmer.baton.repo.impl.FarmerRepositoryImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;

@Controller
@RequestMapping("/farmer")
public class FarmerController {
    private static final Log log = LogFactory.getLog(FarmerController.class);
    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${name}")
    private String name;

    @Autowired
    private FarmerRepositoryImpl farmerRepository;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void create() {
        log.debug("create farmer start");
//        farmerRepository.save(new Farmer("张三", 18));
//        farmerRepository.save(new Farmer("李四", 100));

//        log.debug("farmer: " + farmerRepository.findByAge(18));
        log.debug("create farmer finish");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String search() throws Exception {
        log.debug("search farmer start");
        List<String> farmers = farmerRepository.findFarmerAge18();

//        List<Farmer> farmers = farmerRepository.findAll();
        String resultArrayJson = mapper.writeValueAsString(farmers);
        log.debug(format("resultArrayJson: %s", resultArrayJson));
        log.debug("search farmer finish");
        return resultArrayJson;
    }


}
