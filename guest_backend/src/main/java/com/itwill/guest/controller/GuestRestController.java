package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/*
 * 1. GET /guests : 방명록 리스트 (모든 데이터 요청)
 * 2. GET /guests/{guest_no} : 방명록 상세보기 (guest_no 데이터 요청)
 * 3. POST /guests : 방명록 쓰기 (데이터 추가)
 * 4. PUT /guests/{guest_no} : 방명록 수정 (guest_no 데이터 수정)
 * 5. DELETE /guests/{guest_no} : 방명록 삭제 (guest_no 데이터 삭제)
 */
@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;

	@Operation(summary = "방명록 리스트 (모든 데이터 요청)")
	@GetMapping(value = "/guests", produces = "application/json;charset=UTF-8")
	public Map guest_list() throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		int status = 1;
		String msg = "";
		List<Guest> data = guestService.guestList();

		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}

	@Operation(summary = "방명록 상세보기", description = "guest_no 데이터 요청")
	@Parameter(name = "guest_no", description = "방명록 번호")
	@GetMapping(value = "/guests/{guest_no}", produces = "application/json;charset=UTF-8")
	public Map guest_detail(@PathVariable(value = "guest_no") int guest_no) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		int status = 1;
		String msg = "";
		List<Guest> data = new ArrayList<Guest>();
		Guest guest = guestService.guestDetail(guest_no);
		if (guest != null) {
			data.add(guest);
		} else {
			status = 2;
			msg = "게시물이 존재하지 않습니다.";
		}

		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}

	@Operation(summary = "방명록 쓰기", description = "데이터 추가")
	@PostMapping(value = "/guests", produces = "application/json;charset=UTF-8")
	public Map guest_write_action(@RequestBody Guest guest) {
		Map<String, Object> resultMap = new HashMap<>();
		int status = 1;
		String msg = "";
		List<Guest> data = new ArrayList<Guest>();
		try {
			int insert_guest_no = guestService.guestWrite(guest);
			Guest newGuest = guestService.guestDetail(insert_guest_no);
			status = 1;
			msg = "성공";
			data.add(newGuest);
		} catch (Exception e) {
			e.printStackTrace();
			status = 2;
			msg = "실패";
		}

		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}

	@Operation(summary = "방명록 삭제", description = "guest_no 데이터 삭제")
	@PostMapping(value = "/guests/{guest_no}", produces = "application/json;charset=UTF-8")
	public Map guest_delete_action(@PathVariable int guest_no) {
		Map<String, Object> resultMap = new HashMap<>();
		int status = 1;
		String msg = "";
		List<Guest> data = new ArrayList<Guest>();
		try {
			int deleteGuest = guestService.guestDelete(guest_no);
			if (deleteGuest != 0) {
				status = 1;
				msg = "성공";
			} else {
				status = 2;
				msg = "실패";
			}
		} catch (Exception e) {
			e.printStackTrace();
			exceptionHandler(e);
		}

		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	@Operation(summary = "방명록 수정", description = "guest_no 데이터 수정")
	@Parameter(name = "guest_no", description = "방명록 번호")
	@PutMapping(value = "/guests/{guest_no}", produces = "application/json;charset=UTF-8")
	public Map guest_modify_action(@PathVariable(name = "guest_no") int guest_no, @RequestBody Guest guest) {
		System.out.println("guest_no: " + guest_no);
		System.out.println("guest: " + guest);
		Map<String, Object> resultMap = new HashMap<>();
		int status = 1;
		String msg = "";
		List<Guest> data = new ArrayList<Guest>();
		try {
			guest.setGuestNo(guest_no);
			guestService.guestUpdate(guest);
			status = 1;
			msg = "성공";
			data.add(guest);
		} catch (Exception e) {
			e.printStackTrace();
			status = 2;
			msg = "실패";
		}

		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}

	@ExceptionHandler(Exception.class)
	public Map exceptionHandler(Exception e) {
		Map<String, Object> resultMap = new HashMap<>();
		int status = 3;
		String msg = e.getLocalizedMessage();
		List<Guest> data = new ArrayList<Guest>();

		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
}
