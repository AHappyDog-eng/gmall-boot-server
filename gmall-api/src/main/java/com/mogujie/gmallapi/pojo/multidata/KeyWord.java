package com.mogujie.gmallapi.pojo.multidata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author WN
 * @date 2020/7/10 10:42
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class KeyWord {
    private Context context;
    private boolean isEnd;
    private Integer nextPage;
    private List<ShowMsgKey> list;
}
