package com.ssafy.myapp.api.controller;

import com.ssafy.myapp.domain.User;
import com.ssafy.myapp.api.service.JwtService;
import com.ssafy.myapp.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserContorller {
    public static final Logger logger = LoggerFactory.getLogger(UserContorller.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<User> registUser() throws Exception {
        System.out.println("User controller create 시작");
//        user.setId(map.get("id"));
//        user.setPassword(map.get("password"));
//        System.out.println(user.getId());
//        User savedUser = userService.createMember(user);
        User user = User
                .builder()
                .password("1234")
                .email("user@example.com")
                .build();
//        System.out.println(user);
        User u = userService.createMember(user);
        Optional<User> us = userService.fbp();
        logger.debug("Optional User: " + us);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseEntity<User> registUser(@RequestBody Map<String, String> map) throws Exception {
//        System.out.println("User controller create 시작");
////        user.setId(map.get("id"));
////        user.setPassword(map.get("password"));
////        System.out.println(user.getId());
//        User user = null;
//        User savedUser = userService.createMember(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.OK);
//    }

//    @GetMapping("/check/{id}")
//    public int checkId(@PathVariable String id) throws Exception {
//        System.out.println("checkId controller 시작");
//        int cnt = 1;
//        cnt = userService.checkId(id);
//        return cnt;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> registUser(@RequestBody Map<String, String> map) throws Exception {
//        System.out.println("resister controller 시작");
//        userService.registUser(map);
//        System.out.println("map : " + map);
//        User loginUser = userService.loginUser(map.get("id"), map.get("password"));
//        String token = "";
//        if (loginUser != null) {
//            token = jwtService.create("id", loginUser.getId(), "token");
//            return new ResponseEntity<String>(token, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<String>(token, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @ApiOperation(value = "회원정보수정", notes = "", response = Map.class)
//    @PutMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> updateUser(
//            @RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) @PathVariable String id,
//            @RequestBody Map<String, String> map) {
//        System.out.println("update User 호출");
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status = null;
//        try {
//            map.put("id", id);
//            userService.updateUser(map);
//            resultMap.put("userInfo", map);
//            resultMap.put("message", SUCCESS);
//            status = HttpStatus.ACCEPTED;
//        } catch (Exception e) {
//            logger.error("수정 실패 : {}", e);
//            resultMap.put("message", e.getMessage());
//            status = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
//
//    @ApiOperation(value = "회원정보삭제", notes = "", response = Map.class)
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> deleteUser(
//            @RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) @PathVariable String id) {
//        System.out.println("delete user 호출");
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status = null;
//        try {
//            userService.deleteUser(id);
//            resultMap.put("message", SUCCESS);
//            status = HttpStatus.ACCEPTED;
//        } catch (Exception e) {
//            logger.error("삭제 실패 : {}", e);
//            resultMap.put("message", e.getMessage());
//            status = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
//
//    @ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, Object>> loginUser(
//            @RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) User user) {
//        System.out.println("login contoller 호출");
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status = null;
//        try {
//            User loginUser = userService.loginUser(user.getId(), user.getPassword());
//            if (loginUser != null) {
//                String token = jwtService.create("id", loginUser.getId(), "token");// key, data, subject
//                logger.debug("로그인 토큰정보 : {}", token);
//                resultMap.put("token", token);
//                resultMap.put("message", SUCCESS);
//                status = HttpStatus.ACCEPTED;
//            } else {
//                resultMap.put("message", FAIL);
//                status = HttpStatus.ACCEPTED;
//            }
//        } catch (Exception e) {
//            logger.error("로그인 실패 : {}", e);
//            resultMap.put("message", e.getMessage());
//            status = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Integer> checkPasswordFind(@PathVariable String id, @RequestParam String email) throws Exception {
//        int cnt = 0;
//        System.out.println("checkPasswordFind 실행");
//        cnt = userService.checkPasswordFind(id, email);
//        return new ResponseEntity<Integer>(cnt, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
//    @GetMapping("/info/{id}")
//    public ResponseEntity<Map<String, Object>> getUserInfo(
//            @PathVariable("id") @ApiParam(value = "인증할 회원의 아이디.", required = true) String id,
//            HttpServletRequest request) {
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status;
//        try {
//            User user = userService.infoUser(id);
//            resultMap.put("userInfo", user);
//            resultMap.put("message", SUCCESS);
//            status = HttpStatus.ACCEPTED;
//        } catch (Exception e) {
//            logger.error("정보조회 실패 : {}", e);
//            resultMap.put("message", e.getMessage());
//            status = HttpStatus.INTERNAL_SERVER_ERROR;
//            return new ResponseEntity<Map<String, Object>>(resultMap, status);
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
}
