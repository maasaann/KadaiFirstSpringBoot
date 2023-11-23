package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }

    @GetMapping("/dayofweek/{val}")
    public String dispDayOfWeek(@PathVariable String val) {

        String week[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        //年月日を確定する（Dateオブジェクトの仕様対策）
        int yyyy = Integer.parseInt(val.substring(0,4));
        int MM = Integer.parseInt(val.substring(4,6))-1; //-1 がDateオブジェクトの仕様
        int dd = Integer.parseInt(val.substring(6,8));

        //入力値から年月日を取得
        Calendar fullDate = Calendar.getInstance();
        fullDate.set(yyyy, MM, dd);

        //yyyymmdd形式を曜日に変換する
        return "実行結果：" + week[fullDate.get(Calendar.DAY_OF_WEEK)-1]; //-1も仕様

    }
}