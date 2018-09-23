package com.wjy.springcloud.Controller;

import com.wjy.springcloud.entities.Dept;
import com.wjy.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController(value = "/consumer")
public class DeptController_Consumer {

    @Autowired(required = false)
    private DeptClientService deptClientService;

    @PostMapping(value = "/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.get(id);
    }

    @GetMapping(value = "/dept/list")
    public List<Dept> list() {
        return deptClientService.list();
    }
}
