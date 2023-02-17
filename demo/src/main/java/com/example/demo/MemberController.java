package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
public class MemberController {
    @PostMapping("/Member")
    //@RequestMapping(value = "/Member", method = RequestMethod.POST)
    public  String create( @RequestBody @Valid Member mem){
//        if(mem.getId() == null ){
//            throw new RuntimeException("Id不可為null !");
//        }
        return  "執行資料庫的 Create 操作";
    }
    @GetMapping("/Member/{memberId}")
    public String read(@PathVariable  @Min(100) Integer memberId){
        return  "執行資料庫的 Read 操作";
    }
    @PutMapping("/Member/{memberId}")
    public  String update(@PathVariable Integer memberId,
                                        @RequestBody  Member mem){
        return  "執行資料庫的 Update 操作";
    }
@DeleteMapping("/Member/{memberId}")
    public  String delete(@PathVariable Integer memberId){
        return  "執行資料庫的 Delete 操作";
    }
}
