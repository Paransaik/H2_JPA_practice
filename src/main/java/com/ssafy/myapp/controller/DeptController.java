package com.ssafy.myapp.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@Api("부서 정보 REST API")
@Controller
@RequestMapping("/api/depts")
public class DeptController {

//	@GetMapping
//	private List<Dept> deptRestList()  {
//		return deptService.getDeptList();
//	}

/*
    private DeptService deptService;

    @Autowired
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }


    @GetMapping("/")
    public String callGetMapping() {
        return "success";
    }

    @GetMapping
    public List<Dept> searchDept(@RequestParam(required = false) String dName, @RequestParam(required = false) String loc) {

        HashMap<String, String> condition = new HashMap<String, String>();
        if (dName != null) condition.put("dName", dName);
        if (loc != null) condition.put("loc", loc);

        return deptService.searchDeptList(condition);
    }

    @PostMapping
    private boolean deptRegist(@RequestBody Dept dept) {
        return deptService.registDept(dept);
    }

    @GetMapping("/{deptNo}")
    private Dept deptDetail(@PathVariable int deptNo) {
        return deptService.getDept(deptNo);
    }

    @DeleteMapping("/{deptNo}")
    public boolean removeDept(@PathVariable int deptNo) {
        return deptService.removeDept(deptNo);
    }

    @PutMapping("/{deptNo}")
    public boolean modifyDept(@PathVariable int deptNo, @RequestBody Dept dept) throws SQLException {
        return deptService.modifyDept(dept);
    }


//	@GetMapping(params = {"dName","loc"})
//	public List<Dept> searchDept(@RequestParam Map<String,String> condition) {
//		return deptService.searchDeptList(condition);
//	}
//	@GetMapping(params = {"dName"})
//	public List<Dept> searchDept2(@RequestParam Map<String,String> condition) {
//		return deptService.searchDeptList(condition);
//	}

*/
}
