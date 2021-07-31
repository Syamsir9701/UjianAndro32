package com.juaracoding.minimarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Response<T> {
	private int statusCode;
	private String message;
	private T data;

}
