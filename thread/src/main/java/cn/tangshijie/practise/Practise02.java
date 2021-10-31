package cn.tangshijie.practise;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : tangshijie
 * @since : 2021-10-31 21:13
 */
public class Practise02 {

    public static void main(String[] args) {

        /*
            1.有2个用户分别从同一个卡上取钱
            2.每次都取出1000，当余额不足时，就不能取款了
            3.不能出现超取
         */

        Card card = new Card(10000);
        Thread thread01 = new Thread(card);
        Thread thread02 = new Thread(card);
        thread01.start();
        thread02.start();
    }

    static class Card implements Runnable {

        private int money;

        @Override
        public void run() {
            while (true) {
                try {
                    int leftMoney;
                    synchronized (this) {
                        leftMoney = getMoney() - 1000;
                        if (leftMoney < 0) {
                            break;
                        }
                        setMoney(leftMoney);
                    }
                    System.out.println(Thread.currentThread() + "取走了1000元 还剩下：" + leftMoney + "元");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        Card(int initMoney) {
            this.money = initMoney;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }
    }

}
