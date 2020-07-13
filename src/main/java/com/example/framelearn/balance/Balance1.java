package com.example.framelearn.balance;

import java.awt.*;

/**
 * @author jt
 * @date 2020-7-1
 */
public class Balance1 {


    public static void main(String[] args) {
        Server server1 = new Server(0,0);
        Server server2 = new Server(1,0);

        Server[] servers = new Server[2] ;
        servers[0] =server1;
        servers[1] =server2;

        for (int i = 0; i < 5; i++) {
            Server choice = choice(servers);

            System.out.println("选择："+choice.getNum());

        }




    }


    public static Server choice(Server[] servers) {
        int index = (int) (Math.random() * servers.length);
        return servers[index];
    }
}
