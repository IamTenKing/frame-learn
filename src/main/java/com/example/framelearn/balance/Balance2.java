package com.example.framelearn.balance;

/**
 * @author jt
 * @date 2020-7-1
 */
public class Balance2 {

    static  Integer pos=0;

    public static void main(String[] args) {
        Server server1 = new Server(0,0);
        Server server2 = new Server(1,0);
        Server server3 = new Server(2,0);
        Server server4 = new Server(3,0);
        Server server5 = new Server(4,0);

        Server[] servers = new Server[5] ;
        servers[0] =server1;
        servers[1] =server2;
        servers[2] =server3;
        servers[3] =server4;
        servers[4] =server5;

        for (int i = 0; i < 5; i++) {
            Server choice = choice(servers);

            System.out.println("选择："+choice.getNum());

        }
    }


    public static Server choice(Server[] servers) {
        Server result = null;
        synchronized (pos) {
//            if (pos >= servers.length) {
//                pos = 0;
//            }
//            result = servers[pos];

            //缺点数会越加越大。。。
            result = servers[pos%servers.length];

            pos++;
        }
        return result;
    }
}
