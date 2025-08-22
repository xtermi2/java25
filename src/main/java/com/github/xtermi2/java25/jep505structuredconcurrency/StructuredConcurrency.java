package com.github.xtermi2.java25.jep505structuredconcurrency;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class StructuredConcurrency {

    public record Response(String user, String order) {
    }

    Response executeStructuredConcurrently() throws InterruptedException {
        try (var scope = StructuredTaskScope.open(Joiner.awaitAllSuccessfulOrThrow())) {
            Subtask<String> user = scope.fork(this::findUser);
            Subtask<String> order = scope.fork(this::fetchOrder);

            scope.join();  // Join subtasks, propagating exceptions

            // Here, both forks have succeeded, so compose their results
            return new Response(user.get(), order.get());
        }
    }

    Response executeClassicConcurrently() throws ExecutionException, InterruptedException {
        try (var exec = Executors.newCachedThreadPool()) {
            Future<String> user = exec.submit(this::findUser);
            Future<String> order = exec.submit(this::fetchOrder);
            String theUser = user.get();   // Join findUser
            String theOrder = order.get();  // Join fetchOrder
            return new Response(theUser, theOrder);
        }
    }

    private String findUser() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(1));
        return "User 1";
    }

    private String fetchOrder() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(2));
        return "Order 1";
    }
}
