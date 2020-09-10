package ru.job4j.gc;

public class User {
    int num;

    public User(int num) {
        this.num = num;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("destroy");
    }

    public static void main(String[] args) {
        memory();
        for (int i = 0; i < 100000; i++) {
            User user = new User(i);
        }
        System.out.println("finish");
        memory();
    }

    public static void memory() {
        int mb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory() / mb;
        long freeMemory = rt.freeMemory() / mb;
        long usedMemory = totalMemory - freeMemory;
        System.out.println("statistics");
        System.out.println("totalMemory = " + totalMemory);
        System.out.println("freeMemory = " + freeMemory);
        System.out.println("usedMemory = " + usedMemory);
        System.out.println();
    }
}
