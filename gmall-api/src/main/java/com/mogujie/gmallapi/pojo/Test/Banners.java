package com.mogujie.gmallapi.pojo.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WN
 * @date 2020/7/9 17:57
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class Banners {
    private String bannersName;
    private String bannersAge;
}
