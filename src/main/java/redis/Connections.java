package redis;

import redis.clients.jedis.Jedis;

/**
 * Created by lidongyang on 2017/8/9 0009.
 */
public class Connections {

    private static Jedis redis = null;

    static {
        redis = new Jedis("localhost",6379);
    }

    /**
     * strings类型，存的是key-string类型，字符串
     * 取值时，get(key)
     */
    public static void testStrings(){
        redis.set("name","yanglidong");
        System.out.println(redis.get("name"));
        redis.mset("id","1","age","22");
        redis.append("name","_liuhuan");
        System.out.println(redis.mget("name1", "age"));
    }

    /**
     * hashs类型，存的是key-map类型
     * 取值时，get(key,map的key)或getAll(key)
     */
    public static void testHashs(){
        redis.hset("url","baidu","www.baidu.com");
        redis.hset("url","google","www.google.com");
        System.out.println(redis.hgetAll("url"));
    }

    /**
     * lists类型，存的是key-链表
     */
    public static void testLists(){
        //在list左边插入元素
        redis.lpush("mylist","a");
        //在list右边插入元素
        redis.rpush("mylist","b");
        //删除左边第一个元素
        redis.lpop("mylist");
        //删除右边第一个元素
        redis.rpop("mylist");
        //取list的长度
        redis.llen("mylist");
        //取值，第一个参数是key，第二个参数是起始位置，第二个参数是结束位置，-1表示取所有
        redis.lrange("mylist",0,-1);
    }

    /**
     * sets类型，存的是key-set
     * java中set就不可以有重复元素，所以redis中set也是不能存重复元素的
     */
    public static void testSets(){
        //添加元素a
        redis.sadd("myset","a");
        //添加元素b
        redis.sadd("myset","b");
        //删除元素b
        redis.srem("myset","b");
        //枚举set
        redis.smembers("myset");
    }

    /**
     * sorted sets类型，存的是 key-set，是sets类型升级版，加了排序的功能
     * 虽然可以排序，事实证明，还是不能添加重复元素
     */
    public static void testSorted_Set(){
        //添加元素，第一个参数是key，第二个参数是相当于序号，第三个参数是元素
        redis.zadd("sortset",1,"a");
        redis.zadd("sortset",2,"c");
        redis.zadd("sortset",3,"f");
        //取值，按逆序
        redis.zrevrange("sortset",0,-1);
        //取值，按升序
        redis.zrevrange("sortset",0,-1);
    }

    public static void main(String[] args) {
        testSorted_Set();
    }


}
