package com.controller;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class Jedisa {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("39.107.105.219",6379);
		jedis.hset("h1","username", "lisi");
		System.out.println(jedis.hget("h1", "username"));
		jedis.close();
	}

}
