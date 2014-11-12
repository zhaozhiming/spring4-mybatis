package com.farmer.baton.controller;

import com.farmer.baton.model.Farmer;
import com.farmer.baton.repo.FarmerMapper;
import com.farmer.baton.repo.impl.FarmerRepositoryImpl;
import com.farmer.baton.service.FarmerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    @Autowired
    private FarmerMapper farmerMapper;

    @Autowired
    private FarmerService farmerService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void create() {
        farmerRepository.save(new Farmer(100L, "王五", 20));
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String search() throws Exception {
        List<Farmer> farmers = farmerRepository.findAll();
        String resultArrayJson = mapper.writeValueAsString(farmers);
        log.debug(format("resultArrayJson: %s", resultArrayJson));
        return resultArrayJson;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String find() throws Exception {
        List<Farmer> farmers = farmerMapper.findAll();
        String resultArrayJson = mapper.writeValueAsString(farmers);
        log.debug(format("resultArrayJson: %s", resultArrayJson));
        return resultArrayJson;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseStatus(value = HttpStatus.OK)
    public void update() throws Exception {
        farmerService.updateTwoFarmers(new Farmer(23), new Farmer(22));
    }
}
