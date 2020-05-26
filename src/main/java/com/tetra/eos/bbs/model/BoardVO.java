package com.tetra.eos.bbs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {


    private int code;
    private String title = "";
    private String content = "";
    private String writer = "";
    private String reg_datetime = "";
    
	
}
