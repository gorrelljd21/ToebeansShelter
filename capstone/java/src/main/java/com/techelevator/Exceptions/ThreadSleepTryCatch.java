package com.techelevator.Exceptions;

public class ThreadSleepTryCatch {

    public void threadSleep() throws InterruptedException {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ie) {
            throw new InterruptedException();
        }
    }
}
