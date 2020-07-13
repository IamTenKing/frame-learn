package com.example.framelearn.balance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * 权重随机, 缺点，权重相同的可能只有一个会被选中
 * @author jt
 * @date 2020-7-1
 */
public class Balance3 {

    static  Integer pos=0;
    static  Random random = new Random();

    public static void main(String[] args) {
        Server server1 = new Server(0,10);
        Server server2 = new Server(1,15);
        Server server3 = new Server(2,25);
        Server server4 = new Server(3,35);
        Server server5 = new Server(4,45);

        Server[] servers = new Server[5] ;
        servers[0] =server1;
        servers[1] =server2;
        servers[2] =server3;
        servers[3] =server4;
        servers[4] =server5;

        for (int i = 0; i < 50; i++) {
            Server choice = choice(servers);

            System.out.println("选择："+choice.getNum());

        }
    }


    public static Server choice(Server[] servers) {
       Integer seed =0;
        for (Server server : servers) {
            seed+=server.getWeight();
        }
        //排序
        List<Server> collect = Arrays.asList(servers).stream().
                sorted(Comparator.comparing(Server::getWeight)).collect(Collectors.toList());

        //随机生成数


        int tmp = random.nextInt(seed);

        int total =0;
        for (Server server : collect) {
            total+=server.getWeight();
            if(tmp<=total){
                return server;
            }

        }


        return null;
    }
}
