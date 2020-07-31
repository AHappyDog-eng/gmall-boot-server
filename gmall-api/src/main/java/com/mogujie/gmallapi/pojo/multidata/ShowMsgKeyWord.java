package com.mogujie.gmallapi.pojo.multidata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WN
 * @date 2020/7/10 10:40
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class ShowMsgKeyWord {
    private String acm;
    private String defaultKeyWord;
}
