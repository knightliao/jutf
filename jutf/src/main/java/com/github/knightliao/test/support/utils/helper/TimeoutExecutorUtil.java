package com.github.knightliao.test.support.utils.helper;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author knightliao
 * @email knightliao@gmail.com
 * @date 2021/8/24 13:20
 */
public class TimeoutExecutorUtil {

    public static void doAction(final IMyTestCallback myTestCallback) {

        ExecutorService executor = Executors.newCachedThreadPool();

        Callable<Object> task = new Callable<Object>() {
            public Object call() {
                return myTestCallback.doAction();
            }
        };

        Future<Object> future = executor.submit(task);
        try {

            Object result = future.get(5, TimeUnit.SECONDS);

        } catch (TimeoutException ex) {
            // handle the timeout

        } catch (InterruptedException e) {
            // handle the interrupts

        } catch (ExecutionException e) {
            // handle other exceptions

        } finally {
            future.cancel(true); // may or may not desire this
        }
    }
}
