package com.example.framelearn.singleton;

/**
 *
 * 枚举类单例实现1
 * @author jt
 * @date 2020-8-2
 */
public class User {
        //私有化构造函数
        private User(){ }

        //定义一个静态枚举类
        static enum SingletonEnum{
            //创建一个枚举对象，该对象天生为单例
            INSTANCE;
            private User user;
            //私有化枚举的构造函数，在构造方法中初始化单例对象
            private SingletonEnum(){
                user=new User();
            }
            public User getInstnce(){
                return user;
            }
        }

        //对外暴露一个获取User对象的静态方法
        public static User getInstance(){
            return SingletonEnum.INSTANCE.getInstnce();
        }


}

 class Test {
    public static void main(String [] args){
        System.out.println(User.getInstance());
        System.out.println(User.getInstance());
        System.out.println(User.getInstance()==User.getInstance());
    }
}
