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
     * strings���ͣ������key-string���ͣ��ַ���
     * ȡֵʱ��get(key)
     */
    public static void testStrings(){
        redis.set("name","yanglidong");
        System.out.println(redis.get("name"));
        redis.mset("id","1","age","22");
        redis.append("name","_liuhuan");
        System.out.println(redis.mget("name1", "age"));
    }

    /**
     * hashs���ͣ������key-map����
     * ȡֵʱ��get(key,map��key)��getAll(key)
     */
    public static void testHashs(){
        redis.hset("url","baidu","www.baidu.com");
        redis.hset("url","google","www.google.com");
        System.out.println(redis.hgetAll("url"));
    }

    /**
     * lists���ͣ������key-����
     */
    public static void testLists(){
        //��list��߲���Ԫ��
        redis.lpush("mylist","a");
        //��list�ұ߲���Ԫ��
        redis.rpush("mylist","b");
        //ɾ����ߵ�һ��Ԫ��
        redis.lpop("mylist");
        //ɾ���ұߵ�һ��Ԫ��
        redis.rpop("mylist");
        //ȡlist�ĳ���
        redis.llen("mylist");
        //ȡֵ����һ��������key���ڶ�����������ʼλ�ã��ڶ��������ǽ���λ�ã�-1��ʾȡ����
        redis.lrange("mylist",0,-1);
    }

    /**
     * sets���ͣ������key-set
     * java��set�Ͳ��������ظ�Ԫ�أ�����redis��setҲ�ǲ��ܴ��ظ�Ԫ�ص�
     */
    public static void testSets(){
        //���Ԫ��a
        redis.sadd("myset","a");
        //���Ԫ��b
        redis.sadd("myset","b");
        //ɾ��Ԫ��b
        redis.srem("myset","b");
        //ö��set
        redis.smembers("myset");
    }

    /**
     * sorted sets���ͣ������ key-set����sets���������棬��������Ĺ���
     * ��Ȼ����������ʵ֤�������ǲ�������ظ�Ԫ��
     */
    public static void testSorted_Set(){
        //���Ԫ�أ���һ��������key���ڶ����������൱����ţ�������������Ԫ��
        redis.zadd("sortset",1,"a");
        redis.zadd("sortset",2,"c");
        redis.zadd("sortset",3,"f");
        //ȡֵ��������
        redis.zrevrange("sortset",0,-1);
        //ȡֵ��������
        redis.zrevrange("sortset",0,-1);
    }

    public static void main(String[] args) {
        testSorted_Set();
    }


}
