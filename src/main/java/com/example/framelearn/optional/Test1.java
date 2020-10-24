package com.example.framelearn.optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Date:2020/10/23
 */
public class Test1 {

    public static void main(String[] args) {

        //报错java.lang.NullPointerException
//        Optional<Object> o = Optional.of(null);

        Optional<Object> o1 = Optional.ofNullable(null);
        if(o1.isPresent()){
            System.out.println("不为null");
        }else{
            System.out.println("为null");
        }


//        @Permission(type = ResourceType.SITE, permissionLogin = true)
//        @ApiOperation(value = "根据id查询用户信息")
//        @GetMapping(value = "/{id}/info")
//        public ResponseEntity<UserDTO> queryInfo(@PathVariable Long id) {
//            return Optional.ofNullable(userService.queryInfo(id))
//                    .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
//                    .orElseThrow(NotFoundException::new);
//        }


    }
}
