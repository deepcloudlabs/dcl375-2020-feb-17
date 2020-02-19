package com.example.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aop.Profiler;
import com.example.service.Calculator;

@Service
@Profiler(TimeUnit.NANOSECONDS)
public class SimpleCalculator {
	//@Autowired private Calculator self;
	
	public int add(int x, int y) {
		return x+y;
	}

	public int sub(int x, int y) {
		return x-y;
	}

	public int mul(int x, int y) {
		int sum=0;
		for (int i=0;i<x;++i,sum = this.add(sum,y));
		return sum;
	}

	public int div(int x, int y) {
		return x/y;
	}

}
