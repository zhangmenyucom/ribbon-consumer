package com.taylor;

import com.netflix.discovery.provider.Serializer;
import lombok.Data;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/14 16:48
 */
@Data
@Serializer
public class SearchBean {
    private int id;
    private String name;
}
