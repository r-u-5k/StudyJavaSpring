package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itwill.guest.GuestService;
import com.itwill.guest.dto.GuestDto;
import com.itwill.guest.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/*

1. GET  	/guests       		: 방명록리스트  (모든데이타요청)
2. GET  	/guests/{guest_no}  : 방명록상세보기(guest_no 데이타를요청)
3. POST 	/guests  	  		: 방명록쓰기	(데이타추가)
4. PUT  	/guests/{guest_no} 	: 방명록수정    (guest_no 데이타를수정)
5. DELETE 	/guests/{guest_no}	: 방명록삭제	(guest_no 데이타를삭제)
 */
@CrossOrigin(origins = "*")
@RequestMapping("/guests")
@RestController
public class GuestRestController {

    @Autowired
    private GuestService guestService;

    @Operation(summary = "방명록 리스트")
    @GetMapping
    public ResponseEntity<List<GuestDto>> guest_list() throws Exception {
        List<GuestDto> guestDtos = guestService.guestList();
        return ResponseEntity.status(HttpStatus.OK).body(guestDtos);
    }

    @Operation(summary = "방명록 상세보기")
    @Parameter(name = "guest_no")
    @GetMapping(value = "/{guest_no}")
    public ResponseEntity<GuestDto> guest_detail(@PathVariable(value = "guest_no") int guest_no) throws Exception {
        GuestDto guestDto = guestService.guestDetail(guest_no);
        return ResponseEntity.status(HttpStatus.OK).body(guestDto);
    }

    @Operation(summary = "방명록쓰기")
    @PostMapping
    public ResponseEntity<GuestDto> guest_write_action(@RequestBody GuestDto guest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(guestService.guestWrite(guest));
    }

    @Operation(summary = "방명록 수정")
    @Parameter(name = "guest_no")
    @PutMapping(value = "/{guest_no}")
    public ResponseEntity<GuestDto> guest_modify_action(@PathVariable(name = "guest_no") int guest_no, @RequestBody GuestDto guest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(guestService.guestUpdate(guest));
    }

    @Operation(summary = "방명록 삭제")
    @DeleteMapping(value = "/{guest_no}")
    public ResponseEntity<Map> guest_remove_action(@PathVariable(name = "guest_no") int guest_no) throws Exception {
        guestService.guestDelete(guest_no);
        return ResponseEntity.status(HttpStatus.CREATED).body(new HashMap<>());
    }

}
