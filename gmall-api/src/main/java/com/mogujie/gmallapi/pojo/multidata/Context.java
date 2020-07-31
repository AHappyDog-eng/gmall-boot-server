package com.mogujie.gmallapi.pojo.multidata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WN
 * @date 2020/7/10 10:30
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class Context {
    private String currentTime;
}
