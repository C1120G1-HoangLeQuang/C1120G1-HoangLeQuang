package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/")
    public String getTimeByZone(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city, Model model) {
        Date date = new Date(); // lay thoi gian hien tai o dia phuong
        TimeZone local = TimeZone.getDefault(); //lay mui gio dia phuong
        TimeZone locate = TimeZone.getTimeZone(city); // lay thoi gian o thanh pho
        // Xác định thời gian hiện tại của thành phố được chỉ định dựa trên sự chênh lệch về thời gian giữa các múi giờ và múi giờ chuẩn (UTC).
        //Hàm getRawOffset()trả về lượng thời gian tính bằng mili giây để thêm vào UTC để có thời gian chuẩn trong múi giờ này.
        long locate_time = date.getTime() + (locate.getRawOffset() - locate.getRawOffset());
        date.setTime(locate_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
