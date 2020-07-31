package com.mogujie.gmallprovider8001.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 封装数据返回状态码
 * @author WN
 * @date 2020/7/31 9:25
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class RestResultGenerator {
    private String restResultMsg;
    private Integer code;
    public static RestResultGenerator createResult(String restResultMsg,Integer code){
        return new RestResultGenerator(restResultMsg,code);
    }
}
